
package edu.nju.iip.iprs.product.list.dto.response;

import edu.nju.iip.iprs.product.list.dto.Pagination;

import java.util.ArrayList;
import java.util.List;


/**
 * ClassName: ProductListResponseDto Description:
 * 
 * @author NJU-IIP
 * @version
 * @see
 * @since
 */

public class DocListResponseDto
{
    private List<DocListItemDto> docList;

    private Pagination pagination;

    public List<DocListItemDto> getDocList() {
        return docList;
    }

    public void setDocList(List<DocListItemDto> docList) {
        this.docList = docList;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public DocListResponseDto(List<DocListItemDto> docList, Pagination pagination) {

        this.docList = docList;
        this.pagination = pagination;
    }

    public DocListResponseDto() {
        this.docList = new ArrayList<>();
        this.pagination = new Pagination();
    }

    public DocListResponseDto(List<DocListItemDto> docList) {
        this.docList = docList;
    }
}
