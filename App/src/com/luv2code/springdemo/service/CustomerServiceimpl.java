package com.luv2code.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;

@Service
public class CustomerServiceimpl implements CustomerService {

	
	// need to inject customer dao
	
	@Autowired
	private CustomerDAO customerdao;
	
	
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		
		
		return customerdao.getCustomer();
	}



	@Override
	@Transactional
	public void savecustomer(Customer thecustomer) {
		
		customerdao.savecustomer(thecustomer);
		
		
		
	}

}
