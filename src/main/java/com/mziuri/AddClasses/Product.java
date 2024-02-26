package com.mziuri.AddClasses;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.hibernate.id.factory.internal.AutoGenerationTypeStrategy;
import org.hibernate.id.factory.spi.GenerationTypeStrategy;

@Entity(name="'product'")
public class Product {
    @Id
    @Column(name="prod_id")
    private int prod_id;
    @Column(name="prod_name")
    private String prod_name;
    @Column(name="prod_price")
    private float prod_price;
    @Column(name="prod_amount")
    private int prod_amount;

    @JsonCreator
    public Product(@JsonProperty("prod_id")int prod_id,
                   @JsonProperty("prod_name")String prod_name,
                   @JsonProperty("prod_price")float prod_price,
                   @JsonProperty("prod_amount")int prod_amount) {
        this.prod_id = prod_id;
        this.prod_name = prod_name;
        this.prod_price = prod_price;
        this.prod_amount = prod_amount;
    }

    public Product() {

    }

    public int getProd_id() {
        return prod_id;
    }

    public void setProd_id(int prod_id) {
        this.prod_id = prod_id;
    }

    public String getProd_name() {
        return prod_name;
    }

    public void setProd_name(String prod_name) {
        this.prod_name = prod_name;
    }

    public float getProd_price() {
        return prod_price;
    }

    public void setProd_price(float prod_price) {
        this.prod_price = prod_price;
    }

    public int getProd_amount() {
        return prod_amount;
    }

    public void setProd_amount(int prod_amount) {
        this.prod_amount = prod_amount;
    }
}
