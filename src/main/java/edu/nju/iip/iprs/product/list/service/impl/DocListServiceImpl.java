package edu.nju.iip.iprs.product.list.service.impl;

import com.google.gson.Gson;
import edu.nju.iip.iprs.elasticsearch.RestClientConfig;
import edu.nju.iip.iprs.message.ApiMessage;
import edu.nju.iip.iprs.product.list.constants.IProdListMessagesConstants;
import edu.nju.iip.iprs.product.list.dto.ProdListQueryDto;
import edu.nju.iip.iprs.product.list.dto.SaveDocListDto;
import edu.nju.iip.iprs.product.list.dto.SearchDocListDto;
import edu.nju.iip.iprs.product.list.dto.response.DocListItemDto;
import edu.nju.iip.iprs.product.list.dto.response.DocListResponseDto;
import edu.nju.iip.iprs.product.list.dto.response.ProdInfoDto;
import edu.nju.iip.iprs.product.list.model.DocListItem;
import edu.nju.iip.iprs.product.list.model.ProdListItem;
import edu.nju.iip.iprs.product.list.repository.IDocListItemsRepository;
import edu.nju.iip.iprs.product.list.service.IDocListService;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//import edu.nju.iip.iprs.product.list.repository.IDocListItemsElasticsearchRepository;

/**
 * ClassName: ValueListServiceImpl Description: the default implementation for {@link IDocListService}.
 *
 * @author SAP
 * @see
 * @since
 */
@Service
@Transactional
public class DocListServiceImpl implements IDocListService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private IDocListItemsRepository docListItemsRepository;

//    @Autowired
//    private IDocListItemsElasticsearchRepository docListItemsESRepository;

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    @Autowired
    private RestClientConfig restClientConfig;

    @Override
    public ApiMessage<DocListResponseDto> addProdList(SaveDocListDto saveDocListDto) throws RuntimeException {
        List<DocListItemDto> docList = saveDocListDto.getDocList();
        Integer successCount = 0;

        for (DocListItemDto docListItemDto : docList) {
            DocListItem doc = new DocListItem();

            doc.setCauseOfAction(docListItemDto.getCauseOfAction());
            doc.setCourt(docListItemDto.getCourt());
            doc.setCriteria(docListItemDto.getCriteria());
            doc.setDocId(docListItemDto.getDocId());
            doc.setLitigant(docListItemDto.getLitigant());
            doc.setName(docListItemDto.getName());
            doc.setProcessing(docListItemDto.getProcessing());
            doc.setProduct(docListItemDto.getProduct());
            doc.setPublishDate(docListItemDto.getPublishDate());
            doc.setContent(docListItemDto.getContent());
            doc.setType(docListItemDto.getType());

            List<ProdListItem> prodListItemList = new ArrayList<>();

            for (ProdInfoDto prodInfoDto : docListItemDto.getProdList()) {
                ProdListItem prodListItem = new ProdListItem(docListItemDto.getDocId(), prodInfoDto.getContext());
                prodListItem.setDocListItem(doc);
                prodListItemList.add(prodListItem);
            }

            doc.setProdLists(prodListItemList);

            docListItemsRepository.save(doc);

//           save to ES
            IndexRequest indexRequest = new IndexRequest(restClientConfig.getIndex()).type("_doc");
            indexRequest.source(new Gson().toJson(docListItemDto), XContentType.JSON);

            try {
                restHighLevelClient.index(indexRequest);
                successCount++;
            } catch (Exception e) {
                new RuntimeException(e.getMessage());
            }
        }
        ApiMessage apiMessage = new ApiMessage<DocListResponseDto>();
        apiMessage.setMsg(String.format(IProdListMessagesConstants.SAVE_DOC_RESULT_MESSAGE, successCount, docList.size() - successCount));

        return apiMessage;
    }

    @Override
    public ApiMessage<DocListResponseDto> searchProdList(SearchDocListDto searchDocListDto) throws RuntimeException {

        SearchRequest searchRequest = new SearchRequest(restClientConfig.getIndex());
        SearchSourceBuilder searchSourceBuilder = getESQueryBuilder(searchDocListDto.getQuery());
        searchRequest.source(searchSourceBuilder);
        SearchResponse response = new SearchResponse();

        try {
            response = restHighLevelClient.search(searchRequest);
        } catch (Exception e) {
            new RuntimeException(e.getMessage());
        }

        SearchHit[] hits = response.getHits().getHits();
        List<DocListItemDto> docList = new ArrayList<>();

        for(SearchHit hit : hits) {
            DocListItemDto docListItem = new Gson().fromJson(hit.getSourceAsString(), DocListItemDto.class);
            docList.add(docListItem);
        }

        return new ApiMessage<>(new DocListResponseDto(docList));
    }


    private SearchSourceBuilder getESQueryBuilder(ProdListQueryDto query) {
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();


        boolQueryBuilder.must(QueryBuilders.matchQuery("content", query.getContent()));
        boolQueryBuilder.must(QueryBuilders.matchQuery("name", query.getName()));
        boolQueryBuilder.must(QueryBuilders.matchQuery("type", query.getType()));
        boolQueryBuilder.must(QueryBuilders.matchQuery("causeOfAction", query.getCauseOfAction()));
        boolQueryBuilder.must(QueryBuilders.matchQuery("processing", query.getProcessing()));
        boolQueryBuilder.must(QueryBuilders.matchQuery("litigant", query.getLitigant()));
        boolQueryBuilder.must(QueryBuilders.matchQuery("criteria", query.getCriteria()));

        return searchSourceBuilder.query(boolQueryBuilder);
    }

    @Override
    public ApiMessage<SearchResponse> getEsInfo() {
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        // SearchRequest
        SearchRequest searchRequest = new SearchRequest();
        searchRequest.source(searchSourceBuilder);

        SearchResponse searchResponse = null;
        // 查询ES
        try {
            searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);

        } catch (IOException e) {
            System.out.println("error");
        }
        return new ApiMessage<>(searchResponse);
    }
}
