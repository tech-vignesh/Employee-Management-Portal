package com.deloitte.portal.model;

import java.sql.Date; 

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name= "employee")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
		
		@Id
		@NotNull(message="Employee Id cannot be blank")
		private Long empId;
		
		
		@Column(name="first_name",nullable=false)
		@Pattern(regexp = "^[A-Za-z]*$",message = "firstname Only alphabets are allowed!!")
		@Size(min=1, max=50, message="Firstname should be between 1-50")
		@NotBlank(message = "First name cannot be empty")
		private String firstName;
		
		@Column(name="last_name",nullable = false)
		@Pattern(regexp = "^[A-Za-z]*$",message = "lastname  Only alphabets are allowed!!")
		@Size(min=1, max=50, message="lastname should be between 1-50")
		@NotBlank(message = "Last name cannot be empty")
		private String lastName;
		
		@Column(name="gender", nullable = false)
		@NotBlank(message = "Gender cannot be empty")
		private String gender;
		
		@Column(name="dob", nullable = false)
		private Date dob;
		
		@Column(name="pan_num")
		@Pattern(regexp = "^[A-Za-z0-9]*$", message = "Pan number should be alpha numeric")
		@Size(min=10,max=10,message = "Pan number should have 10 characters")
		@NotBlank(message = "Pan number cannot be empty")
		private String panNum;
		
		@Column(name="aadhaar_num")
		@Pattern(regexp = "^[0-9]*$", message = "Aadhar number should be numeric")
		@Size(min=12,max=12,message = "Aadhar number should have 12 characters")
		@NotBlank(message = "Aadhar number cannot be empty")
		private String aadhaarNum;
		
		@Column(name="mobile_num", nullable = false)
		@Pattern(regexp = "^[0-9]*$", message = "Aadhar number should be numeric")
		@Size(min=10,max=10,message = "Pan number should have 12 characters")
		@NotBlank(message = "Mobile number cannot be empty")
		private String mobileNum;
		
		@Column(name="email_id", nullable = false)
		@Email(message="Enter email in proper format")
		private String emailId;
		
		@Column(name="office_mail", nullable = false)
		@Email(message="Enter email in proper format")
		private String officeMail;
		
		@Column(name="permanant_address")
		@Size(max=200, message="Permanant address should be under 200 characters")
		private String permanantAddresss;
		
		@Column(name="present_address")
		@Size(max=200, message="Permanant address should be under 200 characters")
		private String presentAddresss;
		
		@Column(name="blood_group")
		@Pattern(regexp="^(A|B|AB|O)[+-]$", message="Enter correct bloodgroup")
		private String bloodGroup;
		
		@Column(name="profile_pict")
		private String profiePic;
		
		@Column(name="doj", nullable = false)
		private Date doj;
		
		@Column(name="emp_level", nullable = false)
		@NotBlank(message = "Employee level cannot be empty")
		private String emp_Level;
		
		@Column(name="post_name", nullable = false)
		@Size(max=30, message = "out of range")
		@NotBlank(message = "Post name cannot be empty")
		@Pattern(regexp="^[A-Za-z]*|[\\s]*$", message="Enter postname in proper format")
		private String post_name;
		
		@Column(name="basic_pay", nullable = false)
		@NotNull(message = "Basic pay cannot be empty")
		@Min(value=100, message="Range too low")
		@Max(value=99999999, message="Out of range")
		private long basicPay;
		
		@Column(name="house_allowance", nullable = false)
		@NotNull(message = "House Allowance cannot be empty")
		@Min(value=100, message="Range too low")
		@Max(value=99999, message="Out of range")
		private long houseAllowance;

}
