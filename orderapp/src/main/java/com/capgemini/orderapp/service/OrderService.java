package com.capgemini.orderapp.service;

import java.util.Set;

import com.capgemini.orderapp.entity.LineItem;
import com.capgemini.orderapp.entity.Order;

public interface OrderService {
	
	public Set<Order> getOrders(int customerId);
	
	public Order getOrder(int OrderId);
	
	public Order submitOrder(Order order);
	
	public void updateOrder(Order order);
	
	public void deleteOrder(int OrderId);
	
	public void cancelOrder(int OrderId);
	
    public void addLineItem(LineItem lineItem,int customerId);
	
	public void removeLineItem(LineItem lineItem,int customerId);
	
	public Set<LineItem> getLineItems(int customerId);


}
