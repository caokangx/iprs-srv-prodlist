
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

import edu.nju.iip.iprs.product.list.model.constants.ProdListsItemDbConstants;

import javax.persistence.*;
import java.io.Serializable;


/**
 * ClassName: ValueListsItem Description:
 * 
 * @author SAP
 * @version
 * @see
 * @since
 */

@Entity
@Table(name = ProdListsItemDbConstants.PROD_LIST_ITEM_TABLE_NAME)
public class ProdListItem implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "system-uuid")
    @Column(name = ProdListsItemDbConstants.GLOBAL_GUID, nullable=false)
    private String guid;

    @Column(name = ProdListsItemDbConstants.DOC_ID_COLUMN_NAME)
    private String docId;


    @Column(name = ProdListsItemDbConstants.PRODUCT_CONTEXT_COLUMN_NAME)
    private String productContext;

    @ManyToOne
    @JoinColumn(name = "docGuid")
    private DocListItem docListItem;

    @Override
    public String toString() {
        return "ProdListItem{" +
                "guid='" + guid + '\'' +
                ", docId='" + docId + '\'' +
                ", productContext='" + productContext + '\'' +
                '}';
    }

    public DocListItem getDocListItem() {
        return docListItem;
    }

    public void setDocListItem(DocListItem docListItem) {
        this.docListItem = docListItem;
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

    public String getProductContext() {
        return productContext;
    }

    public void setProductContext(String productContext) {
        this.productContext = productContext;
    }

    public ProdListItem(String docId, String productContext) {

        this.docId = docId;
        this.productContext = productContext;
    }




}
