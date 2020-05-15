package edu.nju.iip.iprs.product.list.dto.response;

import java.io.Serializable;

public class ProdInfoDto implements Serializable {
    private String context;

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public ProdInfoDto() {
    }

    public ProdInfoDto(String context) {

        this.context = context;
    }
}
