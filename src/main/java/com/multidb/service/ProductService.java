package com.multidb.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multidb.h2.model.User;
import com.multidb.h2.repo.UserRepository;
import com.multidb.mysql.model.CustomerModel;
import com.multidb.mysql.repo.CustomerRepository;
import com.multidb.mysql2.model.ProductModel;
import com.multidb.mysql2.repo.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	public ProductRepository productRepository;
	
	@Autowired
	public CustomerRepository customerRepository;
	
	@Autowired
	public UserRepository userRepository;

	public ProductModel getProductById(int id) throws Exception {
		Optional<ProductModel> product = productRepository.findById(id);
		if (!product.isPresent()) {
			throw new Exception("Product not found");
		}
		return product.get();
	}
	
	public CustomerModel getCustomerById(int id) throws Exception {
		Optional<CustomerModel> customer = customerRepository.findById(id);
		if (!customer.isPresent()) {
			throw new Exception("Customer not found");
		}
		return customer.get();
	}
	
	public User getUserById(long id) throws Exception {
		Optional<User> user = userRepository.findById(id);
		if (!user.isPresent()) {
			throw new Exception("User not found");
		}
		return user.get();
	}
}
