package com.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.model.Employee;
import com.web.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	public EmployeeService service;

	@GetMapping("/welcome")
	public String welcome()
	{
		return "welcome to spring boot";
	}
	
	@GetMapping("/admin")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String admin()
	{
		return "Welcome Admin";
	}
	
	@GetMapping("/user")
	@PreAuthorize("hasRole('ROLE_USER')")
	public String user()
	{
		return "Welcome user";
	}
	
	@PostMapping("/save")
	public Employee save(@RequestBody Employee ed)
	{
		return service.save(ed);
	}
	
	@GetMapping("/fetch/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public Employee getOne(@PathVariable Integer id)
	{
		return service.getOne(id);
	}
	
	@GetMapping("/fetchAll")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
	public List<Employee> findAll()
	{
		return service.findAll();
	}
	
}
