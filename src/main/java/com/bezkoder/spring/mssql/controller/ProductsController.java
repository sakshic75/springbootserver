package com.bezkoder.spring.mssql.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bezkoder.spring.mssql.model.Products;
import com.bezkoder.spring.mssql.repository.ProductslRepository;


@CrossOrigin(origins = "http://localhost:3002")
@RestController
public class ProductsController {

	@Autowired
	ProductslRepository productsRepository;

	@GetMapping("/products")
	public ResponseEntity<List<Products>> getAllProducts() {
		try {
			List<Products> products = new ArrayList<Products>();

		
				productsRepository.findAll().forEach(products::add);
		

			if (products.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			System.out.println(products.toString());
			return new ResponseEntity<>(products, HttpStatus.OK);
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/product/{id}")
	public ResponseEntity<Products> getProductById(@PathVariable("id") Long id) {
		Optional<Products> productData = productsRepository.findById(id);

		if (productData.isPresent()) {
			return new ResponseEntity<>(productData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/add/product")
	public ResponseEntity<Products> createTutorial(@RequestBody Products product) {
		try {
			Products productAdded = productsRepository.save(new Products(product.getId(), product.getName(), product.getPrice(), product.getDescription()));
			return new ResponseEntity<>(productAdded, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/product/{id}")
	public ResponseEntity<Products> updateTutorial(@PathVariable("id") Long id, @RequestBody Products product) {
		Optional<Products> productData = productsRepository.findById(id);

		if (productData.isPresent()) {
			Products updatedProduct = productData.get();
			updatedProduct.setName(product.getName());
			updatedProduct.setPrice(product.getPrice());
			return new ResponseEntity<>(productsRepository.save(updatedProduct), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/product/{id}")
	public ResponseEntity<HttpStatus> deleteProduct(@PathVariable("id") Long id) {
		try {
			productsRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/deleteAll/products")
	public ResponseEntity<HttpStatus> deleteAllProducts() {
		try {
			productsRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}


}
