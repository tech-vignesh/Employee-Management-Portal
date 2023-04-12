package com.deloitte.portal.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Table(name="employee_history")
@Data
public class EmployeeHistory {
	
	@Id
	private Long id;
	
	@Column(name="emp_id", nullable=false)
	private Long empId;
	
	@Column(name="Organization_name",nullable=false)
	private String organization_name;
	
	@Column(name="from_date", nullable = false)
	private Date from_date;
	
	@Column(name="until_date", nullable = false)
	private Date until_date;
	
	@Column(name="location",nullable=false)
	private String location;
	
	@Column(name="country")
	private String country;
	
	@Column(name="post",nullable=false)
	private String post;
	
	@Column(name="skill_used")
	private String skill_used;

}
