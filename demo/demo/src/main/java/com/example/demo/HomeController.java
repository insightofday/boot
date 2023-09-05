package com.example.demo;

import java.util.Date;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.customer.Customer;
import com.example.demo.customer.CustomerRepository;

@RestController
public class HomeController {
	@Autowired
	CustomerRepository repo;
	@Autowired
	private SimpMessagingTemplate template;
	
//	@GetMapping("/")
//	public String greet() {
//		return "hello";
//	}
	@GetMapping("/cust")
	public Iterator<Customer>cust(){
		 String text = "[" + new Date() + "]:" + "cust hehe";
	     this.template.convertAndSend("/topic/cust", text);
		return repo.findAll().iterator();
	}
	
	
}
