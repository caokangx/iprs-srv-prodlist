package edu.nju.iip.iprs.product.list.controller;

import edu.nju.iip.iprs.message.ApiMessage;
import edu.nju.iip.iprs.product.list.dto.SaveDocListDto;
import edu.nju.iip.iprs.product.list.dto.SearchDocListDto;
import edu.nju.iip.iprs.product.list.dto.response.DocListResponseDto;
import edu.nju.iip.iprs.product.list.service.IDocListService;
import org.elasticsearch.action.search.SearchResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * ClassName: ValueListController Description: Spring MVC Controller for value list
 *
 * @author NJU-IIP
 * @see
 * @since
 */
@RestController
public class DocListController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private IDocListService docListService;

    @PutMapping(value = "/prodlist")
    public ResponseEntity<ApiMessage<DocListResponseDto>> addDocList(@RequestBody SaveDocListDto saveDocListDto) throws RuntimeException{
        ApiMessage<DocListResponseDto> result = docListService.addProdList(saveDocListDto);
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @PostMapping(value = "/prodlist")
    public ResponseEntity<ApiMessage<DocListResponseDto>> searchDocList(@RequestBody SearchDocListDto searchDocListDto) throws Exception {
        ApiMessage<DocListResponseDto> result = docListService.searchProdList(searchDocListDto);
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @GetMapping(value = "/test")
    public String testInterface() {
        return "test";
    }

    @GetMapping(value = "/es")
    public ResponseEntity<ApiMessage<SearchResponse>> getESInfo() {
        ApiMessage<SearchResponse> result = docListService.getEsInfo();
        return new ResponseEntity(result, HttpStatus.OK);
    }
}
