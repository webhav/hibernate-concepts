package com.webhav.hibernateconcepts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webhav.hibernateconcepts.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
