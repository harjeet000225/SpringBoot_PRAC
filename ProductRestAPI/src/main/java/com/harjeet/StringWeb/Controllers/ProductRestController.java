package com.harjeet.StringWeb.Controllers;

import java.lang.Integer;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.harjeet.StringWeb.Product;
import com.harjeet.StringWeb.repos.ProductRepository;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class ProductRestController {

	@Autowired
	ProductRepository productresp;
	
	
	@RequestMapping(value="/products/", method=RequestMethod.GET)
	public List<Product> getProducts(){
		return productresp.findAll();
	}
	
	@RequestMapping(value="/products/{id}", method=RequestMethod.GET)
	public Product getproduct(@PathVariable("id") int id) {
		return productresp.findById(id).get();
	}
	
	@RequestMapping(value="/products/", method = RequestMethod.POST)
	public Product createProduct(@Valid @RequestBody Product product) {
		return productresp.save(product);
	}
	
	@RequestMapping(value="/products/", method = RequestMethod.PUT)
	public Product updateProduct(@RequestBody Product product) {
		return productresp.save(product);
	}
	@RequestMapping(value="/products/{id}", method=RequestMethod.DELETE)
	public void deleteproduct(@PathVariable("id") int id) {
		productresp.deleteById(id);
	}
	
}
 