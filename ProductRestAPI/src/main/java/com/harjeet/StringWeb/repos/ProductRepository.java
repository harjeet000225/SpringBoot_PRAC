package com.harjeet.StringWeb.repos;

import java.lang.Integer;
import org.springframework.data.jpa.repository.JpaRepository;
import com.harjeet.StringWeb.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	


}
