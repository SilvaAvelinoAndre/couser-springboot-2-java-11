package com.aastechnology.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aastechnology.course.entities.OrderItem;


public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
