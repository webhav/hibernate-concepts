package com.webhav.hibernateconcepts;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.webhav.hibernateconcepts.entity.Order;
import com.webhav.hibernateconcepts.entity.OrderItem;
import com.webhav.hibernateconcepts.entity.OrderService;
import com.webhav.hibernateconcepts.repository.OrderRepository;

@SpringBootApplication
@EnableTransactionManagement
public class HibernateConceptsApplication implements CommandLineRunner {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private EntityManager entityManager;

	public static void main(String[] args) {
		SpringApplication.run(HibernateConceptsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//orderService.getOrderAndAddItems();
		
		OrderItem oi = new OrderItem();
		oi.setName("pen");
		oi.setDescription("reynolds");
		oi.setQuantity(1);
		orderService.saveOrderItem(oi, 5L);
		
		System.out.println("OrderItemSaved id : " + oi.getId());
	}

}
