package com.example.crud;

import java.util.List;

public interface CustomerService {
	
	public void register(Customer c1);
	
	public List<Customer> getallInfo();
	
	public void deletesomerecord(int id);
	
	public Customer getSingleInfo(int id);
	
	 

}
