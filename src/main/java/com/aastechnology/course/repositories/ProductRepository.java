package com.aastechnology.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aastechnology.course.entities.Product;


public interface ProductRepository extends JpaRepository<Product, Long> {

}
