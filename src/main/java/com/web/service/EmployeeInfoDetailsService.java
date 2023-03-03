package com.web.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.web.dto.EmployeeInfoDetails;
import com.web.model.Employee;
import com.web.repo.EmployeeRepo;

public class EmployeeInfoDetailsService implements UserDetailsService {
	
	@Autowired
	private EmployeeRepo repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Employee> employeeInfo=repo.findByUsername(username);
		return employeeInfo.map(EmployeeInfoDetails::new).orElseThrow(()-> new UsernameNotFoundException("User Name not Found"));
	}

}
