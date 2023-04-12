package com.deloitte.portal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deloitte.portal.model.Employee;
import com.deloitte.portal.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public void save(Employee employee) {
		employeeRepository.save(employee);

	}

	@Override
	public Employee findById(Long id) {
		if(employeeRepository.findById(id).isPresent()) {
			return employeeRepository.findById(id).get();
		}
		return null;
	}

	@Override
	public void delete(Long empId) {
		
		employeeRepository.deleteById(empId);

	}

}
