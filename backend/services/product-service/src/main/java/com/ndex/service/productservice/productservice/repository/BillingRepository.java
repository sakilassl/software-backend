package com.ndex.service.productservice.productservice.repository;


import com.ndex.service.productservice.productservice.models.BillDetailsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillingRepository extends JpaRepository<BillDetailsModel, String>
{
    List<BillDetailsModel> findAllByUserId (String UserID);
}
