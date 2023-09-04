package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.customer.Customer;
import com.example.demo.customer.CustomerRepository;

@SpringBootTest
class DemoApplicationTests {
	@Autowired
	CustomerRepository customerRepo;
	
	@Test
	void findByName() {
		List<Customer>list=customerRepo.findByName("ㅎㅎ");
		System.out.println(list);
		assertEquals("ㅎㅎ", list.get(0).getName());
	}
	
	//@Test
	void findAll() {
		Iterable<Customer> list=customerRepo.findAll();
		list.forEach(cust->System.out.println(cust.getName()));
		Iterator<Customer> iter=list.iterator();
		while(iter.hasNext()) {
			String a=list.iterator().next().getPhone();
			System.out.println(a);
		}
	}
	//@Test
	//@Rollback
	void save() {
		Customer cu=new Customer();
		cu.setName("sksksk");
		cu.setPhone("114");
		Customer result=customerRepo.save(cu);
		assertEquals(cu.getName(), result.getName());
	}

}
