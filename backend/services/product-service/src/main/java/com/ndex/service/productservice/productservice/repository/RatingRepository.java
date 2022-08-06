package com.ndex.service.productservice.productservice.repository;

import com.ndex.service.productservice.productservice.models.RatingModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<RatingModel, Integer> {
    List<RatingModel> findAllByProductId(String productId);

}
