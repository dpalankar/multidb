package com.multidb.mysql2.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.multidb.mysql2.model.ProductModel;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel,Integer> {
}