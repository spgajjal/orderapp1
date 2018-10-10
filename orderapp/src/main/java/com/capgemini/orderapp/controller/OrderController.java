package com.capgemini.orderapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.orderapp.entity.LineItem;
import com.capgemini.orderapp.entity.Order;
import com.capgemini.orderapp.service.OrderService;

@RestController
public class OrderController {

	@Autowired
	OrderService orderService;

	@PostMapping("/addorder/{customerId}")
	public ResponseEntity<LineItem> addLineItem(@RequestBody LineItem lineItem, @PathVariable int customerId) {
		orderService.addLineItem(lineItem, customerId);
		return new ResponseEntity<>(HttpStatus.OK);
		}
	
	
	
	@PostMapping("/submitorder")
	public ResponseEntity<Order> submitOrder(@RequestBody Order order) {
		return new ResponseEntity<Order>(orderService.submitOrder(order), HttpStatus.OK);
	
	}
}
