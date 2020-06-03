package edu.nju.iip.iprs.product.list.dto;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class DocListQueryDto implements Serializable {

    private String guid;

    private String content;

    private String name;

    private String type;

    private String causeOfAction;

    private String processing;

    private DocListQueryDateDto publishDate;

    private String litigant;

    private String criteria;

    private String product;

    private String court;

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getCourt() {
        return court;
    }

    public void setCourt(String court) {
        this.court = court;
    }

    public DocListQueryDto() {
        super();
    }

    public DocListQueryDto(String guid, String content, String name, String type, String causeOfAction, String processing, DocListQueryDateDto publishDate, String litigant, String criteria) {

        this.guid = guid;
        this.content = content;
        this.name = name;
        this.type = type;
        this.causeOfAction = causeOfAction;
        this.processing = processing;
        this.publishDate = publishDate;
        this.litigant = litigant;
        this.criteria = criteria;
    }


    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public DocListQueryDateDto getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(DocListQueryDateDto publishDate) {
        this.publishDate = publishDate;
    }

    public String getLitigant() {
        return litigant;
    }

    public void setLitigant(String litigant) {
        this.litigant = litigant;
    }

    public String getCriteria() {
        return criteria;
    }

    public void setCriteria(String criteria) {
        this.criteria = criteria;
    }

    @Override
    public String toString() {
        return "ProdListQueryDto{" +
                "guid='" + guid + '\'' +
                ", content='" + content + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", causeOfAction='" + causeOfAction + '\'' +
                ", processing='" + processing + '\'' +
                ", publishDate=" + publishDate +
                ", litigant='" + litigant + '\'' +
                ", criteria='" + criteria + '\'' +
                ", product='" + product + '\'' +
                ", court='" + court + '\'' +
                '}';
    }
}
