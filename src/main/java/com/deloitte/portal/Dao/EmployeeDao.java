package com.deloitte.portal.Dao;

import java.util.List;

import com.deloitte.portal.model.Employee;
import com.deloitte.portal.model.EmployeeHistory;

public interface EmployeeDao {
	
	
	List<Employee> search(Long empId);
	List<Employee> search(String name);
	
	List<EmployeeHistory> getHistory(Long empId);

}
