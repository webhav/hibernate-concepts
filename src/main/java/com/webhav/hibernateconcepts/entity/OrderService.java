package com.webhav.hibernateconcepts.entity;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webhav.hibernateconcepts.repository.OrderRepository;

@Service
public class OrderService {
	
	private OrderRepository orderRepository;
	
	@Autowired
	private EntityManager entityManager;
	
	private SessionFactory sessionFactory;
	
	public OrderService(OrderRepository orderRepository, EntityManager entityManager) {
		this.orderRepository = orderRepository;
	}
	
	@Transactional
	public void getOrderAndAddItems(Long orderId) { 
		Order find = entityManager.find(Order.class, orderId);
		entityManager.merge(find);
		System.out.println("Order found is " + find);
	}
	
	@Transactional
	public void saveOrderItem(OrderItem oi, long orderId) {
		Session session = entityManager.unwrap(Session.class);
		Order order = session.load(Order.class, orderId);
		oi.setOrder(order);
		session.save(oi);
	}
	
	@Transactional
	public void saveOrder(Order order) {
		entityManager.persist(order);
	}

}
