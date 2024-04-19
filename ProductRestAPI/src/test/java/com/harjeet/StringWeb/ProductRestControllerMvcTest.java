package com.harjeet.StringWeb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.io.IOException;
import java.net.URI;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.apache.tomcat.util.digester.ArrayStack;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito.Then;
import org.mockito.plugins.MockMaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.harjeet.StringWeb.repos.ProductRepository;

import ch.qos.logback.core.net.ObjectWriter;

//@Runwith(SpringRunner.class)
@WebMvcTest
public class ProductRestControllerMvcTest {

	private static final String PRODUCT_URL= "/productapi/products";

	private static final String CONTEXT_API = "/productapi";

	private static final int PRICE = 1000;

	private static final String DES = "check";

	private static final String NAME = "macbook";

	private static final  int PRODUCT_ID = 1;

	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private ProductRepository resp;
	
	
	@Test
	public void testCreateProduct() throws JsonProcessingException, Exception {
		Product product= new Product();
		when(resp.save(any())).thenReturn(product);
		com.fasterxml.jackson.databind.ObjectWriter objectwriter= new ObjectMapper().writer().withDefaultPrettyPrinter();
		
		mvc.perform(post(PRODUCT_URL).contextPath(CONTEXT_API).contentType(MediaType.APPLICATION_JSON)
				.content(objectwriter.writeValueAsString(product))).andExpect(status().isOk());		
	}
	@Test
	public void testFindAll() throws Exception {
		Product product = buildProduct();
		List<Product> products=new ArrayList<Product>();
		when(resp.findAll()).thenReturn(products);
		com.fasterxml.jackson.databind.ObjectWriter objectwriter = new ObjectMapper().writer().withDefaultPrettyPrinter(); 
		mvc.perform(get(PRODUCT_URL).contextPath(CONTEXT_API)).andExpect(status().isOk())
		.andExpect((ResultMatcher) content().json(objectwriter.writeValueAsString(products)));	
	}
	private Product buildProduct() {
		Product product =new Product();
		product.setId(1);
		product.setName(NAME);
		product.setDescription(DES);
		product.setPrice(PRICE);
		return product;
	}
}