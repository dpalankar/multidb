package com.multidb.h2.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.multidb.h2.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
