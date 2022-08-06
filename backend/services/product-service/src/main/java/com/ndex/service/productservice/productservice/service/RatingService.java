package com.ndex.service.productservice.productservice.service;

import com.ndex.service.productservice.productservice.dto.RatingDTO;
import com.ndex.service.productservice.productservice.models.RatingModel;
import org.springframework.http.ResponseEntity;

public interface RatingService {
    RatingModel addRating(RatingDTO body);

    ResponseEntity<Object> getRatingByProductId(String productId);

    ResponseEntity<Object> getRatingReport();

    ResponseEntity<Object> getReviews(String productId);
}
