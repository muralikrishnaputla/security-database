package com.web.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.model.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

	public Optional<Employee> findByUsername(String username);
}
