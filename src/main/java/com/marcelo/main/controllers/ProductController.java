package com.marcelo.main.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.marcelo.main.entities.Product;
import com.marcelo.main.services.ProductService;

@RestController
@RequestMapping("/challenge-backend")
public class ProductController {

	@Autowired
	private ProductService service;
	
	@GetMapping("/item")
	public List<Product> findAll(@RequestParam String begindate, @RequestParam String finaldate) {
		return service.findAll(begindate, finaldate);
	}
}
