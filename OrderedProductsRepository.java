package com.orderManagement.repository;

import com.orderManagement.model.OrderedProductsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface OrderedProductsRepository extends JpaRepository<OrderedProductsModel,Long> {
}
