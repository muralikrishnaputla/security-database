package com.web.service;

import java.util.List;

import com.web.model.Employee;

public interface EmployeeService {

	public Employee save(Employee e);
	public void delete(Integer id);
	public Employee getOne(Integer id);
	public List<Employee> findAll();
}
