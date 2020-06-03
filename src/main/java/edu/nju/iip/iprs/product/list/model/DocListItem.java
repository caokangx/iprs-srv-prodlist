
/**
 * Project Name:com.sap.ems.config
 * File Name:ValueListsItem.java
 * Description: Value list item entity in database table.
 * Copyright: Copyright (c) 2017
 * Company:SAP
 *
 * @author SAP
 * @date Jul 20, 2017 12:42:23 PM
 * @version
 * @see
 * @since
 */

package edu.nju.iip.iprs.product.list.model;

import edu.nju.iip.iprs.product.list.model.constants.DocListsItemDbConstants;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * ClassName: ValueListsItem Description:
 *
 * @author SAP
 * @see
 * @since
 */

@Entity
@Table(name = DocListsItemDbConstants.DOC_LIST_ITEM_TABLE_NAME)
public class DocListItem implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = DocListsItemDbConstants.GLOBAL_GUID)
    private String guid;

    @Column(name = DocListsItemDbConstants.DOC_NAME_COLUMN_NAME)
    private String name;

//    @Lob
//    @Basic(fetch = FetchType.LAZY), columnDefinition = "Text"
    @Column(name = DocListsItemDbConstants.CONTENT_COLUMN_NAME)
    private String content;

    @Column(name = DocListsItemDbConstants.COURT_COLUMN_NAME)
    private String court;

    @Column(name = DocListsItemDbConstants.DOC_ID_COLUMN_NAME)
    private String docId;

    @Column(name = DocListsItemDbConstants.CAUSE_OF_ACTION_COLUMN_NAME)
    private String causeOfAction;

    @Column(name = DocListsItemDbConstants.PROCESSING_COLUMN_NAME)
    private String processing;

    @Column(name = DocListsItemDbConstants.LITIGANT_COLUMN_NAME)
    private String litigant;

    @Column(name = DocListsItemDbConstants.PRODUCT_COLUMN_NAME)
    private String product;

    @Column(name = DocListsItemDbConstants.CRITERIA_COLUMN_NAME)
    private String criteria;

    @Column(name = DocListsItemDbConstants.PUBLISH_DATE_COLUMN_NAME)
    private Long publishDate;

    @Column(name = DocListsItemDbConstants.TYPE_COLUMN_NAME)
    private String type;


    @OneToMany(mappedBy = "docListItem", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<ProdListItem> prodLists = new ArrayList<>();

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourt() {
        return court;
    }

    public void setCourt(String court) {
        this.court = court;
    }

    public String getDocId() {
        return docId;
    }

    public void setDocId(String docId) {
        this.docId = docId;
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

    public List<ProdListItem> getProdLists() {
        return prodLists;
    }

    public void setProdLists(List<ProdListItem> prodLists) {
        this.prodLists = prodLists;
    }

    @Override
    public String toString() {
        return "DocListItem{" +
                "guid='" + guid + '\'' +
                ", name='" + name + '\'' +
                ", court='" + court + '\'' +
                ", docId='" + docId + '\'' +
                ", causeOfAction='" + causeOfAction + '\'' +
                ", processing='" + processing + '\'' +
                ", litigant='" + litigant + '\'' +
                ", product='" + product + '\'' +
                ", criteria='" + criteria + '\'' +
                ", publishDate=" + publishDate +
                ", prodLists=" + prodLists +
                '}';
    }

    /**
     * create an instance: ValueListsItem. Title: ValueListsItem Description: default constructor for JPA
     */
    public DocListItem() {
        super();
    }


}
