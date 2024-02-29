package com.mziuri.AddClasses;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GetProductInfoResponse {
    private String name;
    private Float price;
    private Integer amount;
    @JsonCreator
    public GetProductInfoResponse(
           @JsonProperty("name") String name,
           @JsonProperty("price") Float price,
           @JsonProperty("amount") Integer amount) {
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "GetProductInfoResponse{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                '}';
    }
}
