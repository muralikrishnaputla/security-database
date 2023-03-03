package com.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.web.model.Employee;
import com.web.repo.EmployeeRepo;

@Service
public class EmployeeServiceImp implements EmployeeService {
	
	@Autowired
	private EmployeeRepo repo;
	
	@Autowired
	private PasswordEncoder encoder;
	
	

	@Override
	public Employee save(Employee e) {
		e.setPassword(encoder.encode(e.getPassword()));
		return repo.save(e);
	}

	@Override
	public void delete(Integer id) {
		repo.deleteById(id);
	}

	@Override
	public Employee getOne(Integer id) {
		return repo.findById(id).get();
	}
	

	@Override
	public List<Employee> findAll() {
		return repo.findAll();
	}

}
