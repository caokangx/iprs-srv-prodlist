package edu.nju.iip.iprs.product.list.dto;

import java.io.Serializable;
import java.sql.Timestamp;

public class ProdListQueryDateDto implements Serializable {

    private Timestamp start;

    private Timestamp end;

    public ProdListQueryDateDto() {
        super();
    }

    public ProdListQueryDateDto(Timestamp start, Timestamp end) {

        this.start = start;
        this.end = end;
    }

    public Timestamp getStart() {
        return start;
    }

    public void setStart(Timestamp start) {
        this.start = start;
    }

    public Timestamp getEnd() {
        return end;
    }

    public void setEnd(Timestamp end) {
        this.end = end;
    }
}
