package com.webhav.hibernateconcepts;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
		
		/*OrderItem oi = new OrderItem();
		oi.setName("pen");
		oi.setDescription("reynolds");
		oi.setQuantity(1);
		orderService.saveOrderItem(oi, 5L);
		
		System.out.println("OrderItemSaved id : " + oi.getId());*/
		//fetchOrder(5L);
		
		Order o = new Order();
		o.setOrderId(32432423L);
		
		OrderItem oi = new OrderItem();
		oi.setName("mouse");
		oi.setQuantity(1);
		
		OrderItem oi1 = new OrderItem();
		oi1.setName("keyboard");
		oi1.setQuantity(1);
		
		OrderItem oi2 = new OrderItem();
		oi2.setName("cpu");
		oi2.setQuantity(1);
		
		List<OrderItem> items = new ArrayList<>();
		items.add(oi);items.add(oi1);
		items.add(oi2);		
		
		o.setItems(items);
		
		orderService.saveOrder(o);
	}
	
	private void fetchOrder(Long orderId) {
		//Optional<Order> findById = orderRepository.findById(orderId);
		orderService.getOrderAndAddItems(orderId);
		//System.out.println(findById.get().toString());
	}
	
	

}
