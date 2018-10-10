package com.capgemini.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.customer.entity.Customer;
import com.capgemini.customer.exception.AuthenticationFailedException;
import com.capgemini.customer.exception.CustomerNotFoundException;
import com.capgemini.customer.service.CustomerService;

@RestController
public class CustomerController {
	
@Autowired
CustomerService customerService;

@PostMapping("/customer")
public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
	
	ResponseEntity<Customer> responseEntity=new ResponseEntity<Customer>(customerService.addCustomer(customer), HttpStatus.OK);
	return responseEntity;
	
}
@PutMapping("/customer")
public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer){
	try {
	Customer customerFromDb=customerService.findCustomerById(customer.getCustomerId());
	if(customerFromDb !=null)
		return new ResponseEntity<Customer>(customerService.updateCustomer(customer),HttpStatus.OK);
	
	}
	catch(CustomerNotFoundException exception) {
		
	}
	return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
}

	
	@GetMapping("/customer/{customerId}")
	public ResponseEntity<Customer> findCustomerById(@PathVariable int customerId) throws CustomerNotFoundException{
		Customer customerFromdb=customerService.findCustomerById(customerId);
		return new ResponseEntity<Customer>(customerFromdb,HttpStatus.OK);
		
		}
	
/*	@DeleteMapping("/customer/{customerId}")
	public ResponseEntity<Customer> deleteCustomer(@RequestBody Customer customer) throws CustomerNotFoundException{
		
			customerService.deleteCustomer();
			return new ResponseEntity<Customer>(HttpStatus.OK);*/
			
	@DeleteMapping("/customer/{customerId}")
	public ResponseEntity<Customer> deleteCustomer(@PathVariable int customerId) throws CustomerNotFoundException{

				Customer customer1 = customerService.findCustomerById(customerId);
				if (customer1 != null) {
					customerService.deleteCustomer(customer1);
					return new ResponseEntity<Customer>(HttpStatus.OK);
				}
				return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
			}		
			
	
	@PostMapping("/login")
	public ResponseEntity<Customer> authenticateCustomer(@RequestBody Customer customer) throws AuthenticationFailedException, CustomerNotFoundException{
		
		Customer customer1 = customerService.authenticateCustomer(customer);
		if (customer1 != null)
			return new ResponseEntity<Customer>(customerService.authenticateCustomer(customer), HttpStatus.OK);

		return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
	
	}
	
	
	@GetMapping("/all")
	public ResponseEntity<List> listAllCustomers(){
		List<Customer> list = customerService.getAllCustomers();
		return new ResponseEntity<List>(list, HttpStatus.OK);
	}

}
