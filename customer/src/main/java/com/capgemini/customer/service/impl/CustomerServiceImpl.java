package com.capgemini.customer.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.customer.entity.Customer;
import com.capgemini.customer.exception.AuthenticationFailedException;
import com.capgemini.customer.exception.CustomerNotFoundException;
import com.capgemini.customer.repository.CustomerRepository;
import com.capgemini.customer.service.CustomerService;
@Service
public class CustomerServiceImpl implements CustomerService{

	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer addCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer findCustomerById(int CustomerId) throws CustomerNotFoundException {
		Optional<Customer> optionalCustomer= customerRepository.findById(CustomerId);
		if(optionalCustomer.isPresent())
			return optionalCustomer.get();
		throw new CustomerNotFoundException("customer does not exists");
	}

	@Override
	public void deleteCustomer(Customer customer) {
		customerRepository.delete(customer);
		
	}

	@Override
	public Customer authenticateCustomer(Customer customer)
			throws CustomerNotFoundException, AuthenticationFailedException {
		Optional<Customer> customer1 = customerRepository.findById( customer.getCustomerId());
		if (!customer1.isPresent())
			throw new CustomerNotFoundException("Customer Not found");
		if (customer1.isPresent()) {
			if (customer1.get().getCustomerPassword().equals(customer.getCustomerPassword()))
				return customer1.get();
		}
		throw new AuthenticationFailedException();
	}

	@Override
	public List<Customer> getAllCustomers() {
		
		return customerRepository.findAll();
	}
	
	

	}