package com.webhav.hibernateconcepts;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.assertj.core.util.Arrays;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.webhav.hibernateconcepts.entity.Order;
import com.webhav.hibernateconcepts.entity.OrderItem;
import com.webhav.hibernateconcepts.repository.OrderRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
public class HibernateConceptsApplicationTests {
	
	@Autowired
	private TestEntityManager em;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	OrderRepository orderRepository;

	//@Test
	public void contextLoads() {
		
		Order o = new Order();
		o.setOrderId(123456L);
		
		//em.persist(o);
		//em.close();
		
		orderRepository.save(o);
		
		System.out.println("*********** order id in DB " + o.getId());
		
		Order find = em.find(Order.class, 1L);
		
		System.out.println("*********** order found in DB " + find);
	}
	
	@Test
	public void Test_Jpa_Persist() {
		System.out.println("*********** Test_Jpa_Persist Started ************");
		Order o = new Order();
		o.setOrderId(1234L);
		
		em.persist(o);
		
		System.out.println("Pesisted order id is " + o.getId());
	}
	
	//@Test
	public void Test_Jpa_Find() {
		Order o = new Order();
		o.setOrderId(1234L);
		em.persist(o);
		System.out.println("*********** order id in DB " + o.getId());
		System.out.println("*********** Test_Jpa_Find Started ************");
		Optional<Order> findById = orderRepository.findById(3L);
		System.out.println("Order found from DB " +findById.get());
	}
	
	@Test
	public void Test_OneToMany() {
		System.out.println("*********** Test_OneToMany Started ************");
		Order o = new Order();
		o.setOrderId(2345L);
		
		OrderItem oi = new OrderItem();
		oi.setName("pen");
		oi.setQuantity(1);
		
		OrderItem oi1 = new OrderItem();
		oi1.setName("notebook");
		oi1.setQuantity(3);
		
		List<OrderItem> items = new ArrayList<>();
		items.add(oi); items.add(oi1);
		
		o.setItems(items);
		
		em.persist(o);
		
		Order find = em.find(Order.class, o.getId());
		
		System.out.println("Order found is " + find);
		
	}

}
