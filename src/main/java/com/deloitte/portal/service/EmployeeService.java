package com.deloitte.portal.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.deloitte.portal.model.Employee;

@Service
public interface EmployeeService {
	
	List<Employee> findAll();
	
	void save(Employee expense);
	
	Employee findById(Long id);

	void delete(Long id);

}
