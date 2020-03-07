package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.entity.Customer;

@Repository
public class CustomerDAOImp implements CustomerDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	
	public List<Customer> getCustomer() {
		
		// get current hibernate session
		Session currentsession = sessionFactory.getCurrentSession();
		
		// create a query .. sort by last name
		Query<Customer>
		thequery = currentsession.createQuery("from Customer order by lastname",Customer.class);
		
		// execute a query and get a result
		List<Customer> customer = thequery.getResultList();
		
		
		//return the result
		
		return customer;
	}


	@Override
	public void savecustomer(Customer thecustomer) {
		Session currentsession = sessionFactory.getCurrentSession();
		
		// save the customer
		currentsession.save(thecustomer);
		
	}

}
