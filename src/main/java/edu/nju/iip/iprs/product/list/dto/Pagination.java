package edu.nju.iip.iprs.product.list.dto;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class Pagination implements Serializable {

    private Integer count;

    @NotNull
    private Integer pageSize;

    @NotNull
    private Integer pageNumber;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Pagination() {
    }

    public Pagination(Integer count, @NotNull Integer pageSize, @NotNull Integer pageNumber) {

        this.count = count;
        this.pageSize = pageSize;
        this.pageNumber = pageNumber;
    }
}
