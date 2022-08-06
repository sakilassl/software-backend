package com.ndex.service.productservice.productservice.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RatingResponse {
    private String productId;
    private int meanRatingValue;

}
