package com.multidb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.multidb.h2.model.User;
import com.multidb.mysql.model.CustomerModel;
import com.multidb.mysql2.model.ProductModel;
import com.multidb.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	ProductService productService;
	
	@GetMapping("/")
	public ResponseEntity<String> welcome() throws Exception{
		return new ResponseEntity<String>("Welcome", HttpStatus.OK);
	}
	
	@GetMapping("/hello")
	public ResponseEntity<String> hello() throws Exception{
		return new ResponseEntity<String>("hello", HttpStatus.OK);
	}
	
	@GetMapping("/product/{id}")
	public ResponseEntity<ProductModel> getProduct(@PathVariable int id) throws Exception{
		ProductModel productModel =  productService.getProductById(id);
		return new ResponseEntity<ProductModel>(productModel, HttpStatus.OK);
	}
	
	@GetMapping("/customer/{id}")
	public ResponseEntity<CustomerModel> getCustomer(@PathVariable int id) throws Exception{
		CustomerModel customerModel = productService.getCustomerById(id);
		return new ResponseEntity<CustomerModel>(customerModel, HttpStatus.OK);
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUser(@PathVariable long id) throws Exception{
		User user = productService.getUserById(id);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
}
