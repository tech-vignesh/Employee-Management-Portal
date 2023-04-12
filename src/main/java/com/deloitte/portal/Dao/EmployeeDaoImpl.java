package com.deloitte.portal.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.deloitte.portal.model.Employee;
import com.deloitte.portal.model.EmployeeHistory;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<Employee> search(Long empId) {
		return jdbcTemplate.query("select * from employee where emp_id = ?",
				new BeanPropertyRowMapper<Employee>(Employee.class), empId);
	}

	@Override
	public List<Employee> search(String name) {
		return jdbcTemplate.query(
				"select * from employee where first_name like '%" + name + "%' OR last_name LIKE '%" + name + "%'",
				new BeanPropertyRowMapper<Employee>(Employee.class));
	}

	@Override
	public List<EmployeeHistory> getHistory(Long empId) {
		
		return jdbcTemplate.query("select * from employee_history where emp_id = ?", new BeanPropertyRowMapper<EmployeeHistory>(EmployeeHistory.class),empId);
	}

}
