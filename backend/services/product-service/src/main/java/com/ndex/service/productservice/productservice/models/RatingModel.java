package com.ndex.service.productservice.productservice.models;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity(name = "rating")
public class RatingModel {

    
//    @GeneratedValue(generator = "uuid2")
//    @GenericGenerator(name = "uuid2", strategy = "uuid2")
//    @Type(type = "uuid-char")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="rating_id")
    private Integer ratingId;
    @Column(name = "descript")
    private String description;
    @Column(name = "rating_value")
    private int ratingValue;
    @Column(name ="SID")
    private String SID;
    @Column(name = "product_id")
    private String productId;

    public Integer getRatingId() {
        return ratingId;
    }

    public void setRatingId(Integer ratingId) {
        this.ratingId = ratingId;
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

    public String getSID() {
        return SID;
    }

    public void setSID(String SID) {
        this.SID = SID;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
}
