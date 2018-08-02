package com.webhav.hibernateconcepts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.webhav.hibernateconcepts.entity.Order;
import com.webhav.hibernateconcepts.repository.OrderRepository;

@SpringBootApplication
public class HibernateConceptsApplication implements CommandLineRunner {
	
	@Autowired
	private OrderRepository orderRepository;

	public static void main(String[] args) {
		SpringApplication.run(HibernateConceptsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Order o = new Order();
		o.setOrderId(123L);
		orderRepository.save(o);
	}
}
