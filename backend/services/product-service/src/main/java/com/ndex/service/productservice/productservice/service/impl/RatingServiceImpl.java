package com.ndex.service.productservice.productservice.service.impl;

import com.ndex.service.productservice.productservice.dto.RatingDTO;
import com.ndex.service.productservice.productservice.models.RatingModel;
import com.ndex.service.productservice.productservice.models.RatingResponse;
import com.ndex.service.productservice.productservice.repository.RatingRepository;
import com.ndex.service.productservice.productservice.service.RatingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    private final RatingRepository ratingRepository;

    public RatingServiceImpl(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    @Override
    public RatingModel addRating(RatingDTO body) {
        RatingModel model = body.getModel();
        return ratingRepository.save(model);
    }

    @Override
    public ResponseEntity<Object> getRatingByProductId(String productId) {
        List<RatingModel> ratingList = ratingRepository.findAllByProductId(productId);
        if (ratingList != null && !ratingList.isEmpty()){
            int sum = 0;
            for (RatingModel item : ratingList){
                sum = sum + item.getRatingValue();
            }
            int average = (int) Math.floor((double) sum / ratingList.size());
            return ResponseEntity.status(HttpStatus.OK).body(RatingResponse.builder().productId(productId).meanRatingValue(average).build());
        }
        HashMap<String, String> error = new HashMap<>();
        error.put("message", productId.concat(" is not found. please input correct productId"));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
