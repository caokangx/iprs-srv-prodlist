package edu.nju.iip.iprs.product.list.dto.response;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * ClassName: DocListItemDto Description: DTO for product list item.
 * 
 * @author NJU-IIP
 * @version
 * @see
 * @since
 */
public class DocListItemDto implements  Serializable
{
    private static final long serialVersionUID = 1L;

    private String guid;

    private String docId;

    private String name;

    private String content;

    private String url;

    private String court;

    private String causeOfAction;

    private String processing;

    private String litigant;

    private String product;

    private String criteria;

    private String type;

    private Long publishDate;

    private List<ProdInfoDto> prodList;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getDocId() {
        return docId;
    }

    public void setDocId(String docId) {
        this.docId = docId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCourt() {
        return court;
    }

    public void setCourt(String court) {
        this.court = court;
    }

    public String getCauseOfAction() {
        return causeOfAction;
    }

    public void setCauseOfAction(String causeOfAction) {
        this.causeOfAction = causeOfAction;
    }

    public String getProcessing() {
        return processing;
    }

    public void setProcessing(String processing) {
        this.processing = processing;
    }

    public String getLitigant() {
        return litigant;
    }

    public void setLitigant(String litigant) {
        this.litigant = litigant;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getCriteria() {
        return criteria;
    }

    public void setCriteria(String criteria) {
        this.criteria = criteria;
    }

    public Long getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Long publishDate) {
        this.publishDate = publishDate;
    }

    public List<ProdInfoDto> getProdList() {
        return prodList;
    }

    public void setProdList(ArrayList<ProdInfoDto> prodList) {
        this.prodList = prodList;
    }

    public DocListItemDto() {
    }

    public DocListItemDto(String guid, String docId, String name, String url, String court, String causeOfAction, String processing, String litigant, String product, String criteria, Long publishDate, ArrayList<ProdInfoDto> prodList) {

        this.guid = guid;
        this.docId = docId;
        this.name = name;
        this.url = url;
        this.court = court;
        this.causeOfAction = causeOfAction;
        this.processing = processing;
        this.litigant = litigant;
        this.product = product;
        this.criteria = criteria;
        this.publishDate = publishDate;
        this.prodList = prodList;
    }
}
