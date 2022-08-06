package com.ndex.service.productservice.productservice.dto;

import com.ndex.service.productservice.productservice.models.RatingModel;

public class RatingDTO {
    private String productId;
    private String description;
    private int ratingValue;
    private String sid;


    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRatingValue() {
        return ratingValue;
    }

    public void setRatingValue(int ratingValue) {
        this.ratingValue = ratingValue;
    }

    public RatingModel getModel() {
        RatingModel model = new RatingModel();
        model.setDescription(this.description);
        model.setRatingValue(this.ratingValue);
        model.setSID(this.sid);
        model.setProductId(this.productId);
        return model;

    }
}
