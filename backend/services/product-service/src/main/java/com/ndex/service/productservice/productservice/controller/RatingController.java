package com.ndex.service.productservice.productservice.controller;

import com.ndex.service.productservice.productservice.models.RatingModel;
import com.ndex.service.productservice.productservice.dto.RatingDTO;
import com.ndex.service.productservice.productservice.models.RatingResponse;
import com.ndex.service.productservice.productservice.service.RatingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(value = "*")
@RestController
@RequestMapping("/rating")
@Slf4j
public class RatingController {

    private final RatingService ratingService;

    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @PostMapping
    public ResponseEntity<Object> addRating(@RequestBody RatingDTO body){
        log.info("HIT-/rating | POST");
        RatingModel response = ratingService.addRating(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Object> getRatingByProductId(@PathVariable String productId){
        log.info("HIT-/rating | GET | productId : {}", productId);
        return ratingService.getRatingByProductId(productId);
    }

    @GetMapping("/review/{productId}")
    public ResponseEntity<Object> getReviews(@PathVariable String productId){
        log.info("HIT-/rating/review | GET | productId : {}", productId);
        return ratingService.getReviews(productId);
    }

}
