package com.example.put.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Cardto {
    private String name;
    @JsonProperty
    private String carNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }
}
