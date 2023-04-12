package com.deloitte.portal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import com.deloitte.portal.model.Employee;



@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	List<Employee>findAll();

}
