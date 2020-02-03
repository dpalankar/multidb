package com.multidb.mysql.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.multidb.mysql.model.CustomerModel;

@Repository
public interface CustomerRepository extends JpaRepository < CustomerModel, Integer > {
}