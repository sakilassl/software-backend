package com.ndex.service.productservice.productservice.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "product")
public class ProductModel {
    @Id
    private String pid;
    private String discountPercentage;
    private String colour;
    private String pname;
    private String availableQuantity;
    private String price;
    private String size_;

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(String discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(String availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSize_() {
        return size_;
    }

    public void setSize_(String size_) {
        this.size_ = size_;
    }
}
