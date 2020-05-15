package edu.nju.iip.iprs.product.list.service;

import edu.nju.iip.iprs.message.ApiMessage;
import edu.nju.iip.iprs.product.list.dto.SaveDocListDto;
import edu.nju.iip.iprs.product.list.dto.SearchDocListDto;
import edu.nju.iip.iprs.product.list.dto.response.DocListResponseDto;
import org.elasticsearch.action.search.SearchResponse;

import java.io.IOException;


/**
 * ClassName:ValueListService
 * Description: the service for the value list.
 * 
 * @author i325285
 *
 */
public interface IDocListService
{
    /**
     * Convert the {@link SearchDocListDto} model to JPA entity and save to database.
     * 
     * @param searchDocListDto the data source.
     * @return the {@link DocListResponseDto} entity.
     */
    public ApiMessage<DocListResponseDto> addProdList(SaveDocListDto saveDocListDto);
    

    public ApiMessage<DocListResponseDto> searchProdList(SearchDocListDto searchDocListDto);


    public ApiMessage<SearchResponse> getEsInfo();
    /**
     * 
      * Title: isValid
      * Description:  check if the header's code is unique
      * @exception
      * @see
      * @since
      * {@inheritDoc} 
      * @param docListDto
      * @return true if it's unique
     */
//    public boolean isValid(SearchDocListDto docListDto);

}
