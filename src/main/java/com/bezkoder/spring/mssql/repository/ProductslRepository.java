package com.bezkoder.spring.mssql.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bezkoder.spring.mssql.model.Products;


public interface ProductslRepository extends JpaRepository<Products, Long> {
  Products findById(Integer id);
 
}
