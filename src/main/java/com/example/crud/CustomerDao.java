package com.example.crud;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerDao implements CustomerService {

	@Autowired
	CustomerRepository cr;
	
	@Override
	public void register(Customer c1) {
		
		cr.save(c1);
	}

	@Override
	public List<Customer> getallInfo() {
		
		return cr.findAll();
	}

	@Override
	public void deletesomerecord(int id) {
		
		cr.deleteById(id);		
	}

	@Override
	public Customer getSingleInfo(int id) {
		// TODO Auto-generated method stub
		return cr.getById(id);
	}

	 
	

}
