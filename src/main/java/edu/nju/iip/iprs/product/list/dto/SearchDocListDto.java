package edu.nju.iip.iprs.product.list.dto;

import edu.nju.iip.iprs.product.list.dto.response.DocListItemDto;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for value list.
 */

/**
 * 
 * ClassName: SearchDocListDto Description: The request/response data structure for the product list model.
 * 
 * @author NJU-IIP
 * @version
 * @see
 * @since
 */
public class SearchDocListDto implements Serializable
{

    private String guid;

    private DocListQueryDto query;

    private Pagination pagination;

    public SearchDocListDto(String guid, DocListQueryDto query, Pagination pagination, List<DocListItemDto> prods) {
        this.guid = guid;
        this.query = query;
        this.pagination = pagination;
        this.prods = prods;
    }

    public List<DocListItemDto> getProds() {
        return prods;
    }

    public void setProds(List<DocListItemDto> prods) {
        this.prods = prods;
    }

    private List<DocListItemDto> prods;

    /**
     * create an instance: SearchDocListDto. Title: SearchDocListDto Description: default constructor
     */
    public SearchDocListDto()
    {
        super();

    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }


    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public DocListQueryDto getQuery() {
        return query;
    }

    public void setQuery(DocListQueryDto query) {
        this.query = query;
    }

    public SearchDocListDto(String guid, DocListQueryDto query) {

        this.guid = guid;
        this.query = query;
    }
}
