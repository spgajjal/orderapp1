package com.capgemini.orderapp.service.impl;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.orderapp.entity.LineItem;
import com.capgemini.orderapp.entity.Order;
import com.capgemini.orderapp.repository.OrderRepository;
import com.capgemini.orderapp.service.OrderService;
@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	private HashMap<Integer, Set<LineItem>> map = new HashMap<>();
	
	@Override
	public Set<Order> getOrders(int customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order submitOrder(Order order) {
		order.setOrderDate(LocalDate.now());
		return orderRepository.save(order);
	}

	@Override
	public void updateOrder(Order order) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteOrder(int OrderId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cancelOrder(int OrderId) {
		// TODO Auto-generated method stub
		
	}
	

	@Override
	public void addLineItem(LineItem lineItem, int customerId) {
		
		Set<LineItem>  set=map.get(customerId);
		if (set == null) {
			set = new HashSet<>();
			set.add(lineItem);
			map.put(customerId, set);
		} else {
			set.add(lineItem);
			map.put(customerId, set);
		}
		
		
	}

	@Override
	public void removeLineItem(LineItem lineItem, int customerId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Set<LineItem> getLineItems(int customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order getOrder(int OrderId) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}