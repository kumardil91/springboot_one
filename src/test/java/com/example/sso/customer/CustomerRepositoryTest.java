package com.example.sso.customer;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class CustomerRepositoryTest {


	private CustomerRepository customerRepo;
	
	@Before
	public void setup() {
		customerRepo =  new CustomerRepository();
	}
	@Test
	public void testFindAll() {
		
		List<Customer> customer= customerRepo.findAll();
		assertEquals("Total number of customer", 5, customer.size());
	}

	@Test
	public void testFindOne() {
		Customer customer = customerRepo.findOne(2L);
		assertEquals("customer name","Facebook Inc.", customer.getName());
	}

}
