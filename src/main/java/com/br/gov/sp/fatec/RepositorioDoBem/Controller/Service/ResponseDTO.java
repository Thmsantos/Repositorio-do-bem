package com.br.gov.sp.fatec.RepositorioDoBem.Controller.Service;

import com.br.gov.sp.fatec.RepositorioDoBem.Model.Domain.Alimento;

public class ResponseDTO {
    private Alimento responseData;
    private Boolean responseBoolean;

    public void setResponseData(Alimento responseData) {
        this.responseData = responseData;
    }

    public void setResponseBoolean(Boolean responseBoolean) {
        this.responseBoolean = responseBoolean;
    }

    public Alimento getResponseData() {
        return responseData;
    }

    public Boolean getResponseBoolean() {
        return responseBoolean;
    }
}