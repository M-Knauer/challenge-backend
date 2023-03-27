package com.marcelo.main.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.marcelo.main.entities.Product;

@Service
public class ProductService {

	public List<Product> findAll(String begindate, String finaldate) {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate minDate = LocalDate.parse(begindate, formatter);
		LocalDate maxDate = LocalDate.parse(finaldate, formatter);
		
		RestTemplate restTemplate = new RestTemplate();
		
		String apiUrl = "http://www.mocky.io/v2/5817803a1000007d01cc7fc9";
		ParameterizedTypeReference<List<Product>> typeRef = new ParameterizedTypeReference<List<Product>>() {};
		ResponseEntity<List<Product>> response = restTemplate.exchange(apiUrl, HttpMethod.GET, null, typeRef);
		
		List<Product> prodFilter = new ArrayList<>();
		
		for (Product prod : response.getBody() ) {
			LocalDate date =  LocalDate.parse(prod.getDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"));
			if (!date.isBefore(minDate) && !date.isAfter(maxDate)) {
				prodFilter.add(prod);
			}
		}
	
		
		return prodFilter;
	}

}
