package com.example.crud;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomerController {
	
	@Autowired 
	CustomerService cs;
	
	@RequestMapping("/")
	public String one()
	{
		return "index";
	}
	
	@PostMapping("/save")
	public String SaveData(@ModelAttribute ("cr") Customer cr)
	{
		cs.register(cr);
		return "redirect:/disp";
		
	}
	
	@RequestMapping("/disp")
	public String Displydata(Model m)
	{
		List<Customer> ck = cs.getallInfo();
		m.addAttribute("mm",ck);
		System.out.println(ck);
		return "disp";
		
	}
	
	@GetMapping("/del/{id}")
	public String GetdatabyId(@PathVariable int id)
	{
		cs.deletesomerecord(id);
		return"redirect:/disp";
	}
	
	@GetMapping("/edit/{id}")
	public String Editdata(@PathVariable int id, Model m)
	{
		Customer ct = cs.getSingleInfo(id);
		m.addAttribute("kk", ct);
		return "edit";
	}
	
	@PostMapping("/update")
	public String Updatedata(@ModelAttribute("cf") Customer cf)
	{
		Customer c = new Customer();
		c.setCid(cf.getCid());
		c.setCname(cf.getCname());
		c.setCemail(cf.getCemail());
		c.setCcontact(cf.getCcontact());
		c.setCpassword(cf.getCpassword());
		cs.register(c);
		return "redirect:/disp";
		
	}
	
}
