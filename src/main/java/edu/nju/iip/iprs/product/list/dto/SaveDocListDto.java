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
public class SaveDocListDto implements Serializable
{
    private static final long serialVersionUID = 1L;


    private List<DocListItemDto> docList;

    public SaveDocListDto() {
    }

    public static long getSerialVersionUID() {

        return serialVersionUID;
    }

    public List<DocListItemDto> getDocList() {
        return docList;
    }

    public void setDocList(List<DocListItemDto> docList) {
        this.docList = docList;
    }

    public SaveDocListDto(List<DocListItemDto> docList) {

        this.docList = docList;
    }
}
