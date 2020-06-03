package edu.nju.iip.iprs.product.list.dto;

import java.io.Serializable;

public class DocListQueryDateDto implements Serializable {

    private Long start;

    private Long end;

    public DocListQueryDateDto() {
        super();
    }

    public DocListQueryDateDto(Long start, Long end) {

        this.start = start;
        this.end = end;
    }

    public Long getStart() {
        return start;
    }

    public void setStart(Long start) {
        this.start = start;
    }

    public Long getEnd() {
        return end;
    }

    public void setEnd(Long end) {
        this.end = end;
    }

    public boolean isEmpty() {
        return start == null && end == null;
    }
}
