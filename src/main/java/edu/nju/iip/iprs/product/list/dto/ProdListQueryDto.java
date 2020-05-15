package edu.nju.iip.iprs.product.list.dto;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class ProdListQueryDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String guid;

    private String content;

    private String name;

    private String type;

    private String causeOfAction;

    private String processing;

    private ProdListQueryDateDto date;

    private String litigant;

    private String criteria;

    public ProdListQueryDto() {
        super();
    }

    public ProdListQueryDto(String guid, String content, String name, String type, String causeOfAction, String processing, ProdListQueryDateDto date, String litigant, String criteria) {

        this.guid = guid;
        this.content = content;
        this.name = name;
        this.type = type;
        this.causeOfAction = causeOfAction;
        this.processing = processing;
        this.date = date;
        this.litigant = litigant;
        this.criteria = criteria;
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

    public ProdListQueryDateDto getDate() {
        return date;
    }

    public void setDate(ProdListQueryDateDto date) {
        this.date = date;
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
}
