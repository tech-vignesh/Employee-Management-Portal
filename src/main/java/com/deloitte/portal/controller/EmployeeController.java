package com.deloitte.portal.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import com.deloitte.portal.Dao.EmployeeDao;
import com.deloitte.portal.model.Employee;
import com.deloitte.portal.model.EmployeeHistory;
import com.deloitte.portal.service.EmployeeService;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@Autowired
	EmployeeDao employeeDao;

	@RequestMapping("/")
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView("home");
		List<Employee> employees = employeeService.findAll();
//		System.out.println(employees+"\n");
		mav.addObject("employees", employees);
		return mav;
	}

	@RequestMapping("/employee")
	public ModelAndView addEmployee() {
		ModelAndView mav = new ModelAndView("employee");
		mav.addObject("employee", new Employee());
		return mav;

	}

	@RequestMapping(value = "/employee", method = RequestMethod.POST)
	public String save(@Valid @ModelAttribute("employee") Employee employee, BindingResult br) {
		if(br.hasErrors()) {
			return "employee";
		}
		else {
		employeeService.save(employee);
		return "redirect:/";
		}
	}

	@RequestMapping(value = "/employee/{empId}")
	public ModelAndView edit(@PathVariable("empId") Long empId) {

		ModelAndView mav = new ModelAndView("employee");
		Employee employee = employeeService.findById(empId);
		mav.addObject("employee", employee);
		return mav;

	}

	@RequestMapping(value = "/{empId}")
	public String delete(@PathVariable("empId") Long empId) {
		employeeService.delete(empId);
		return "redirect:/";
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public ModelAndView search(@Param("empId") Long empId, @Param("firstname") String firstname) {

		ModelAndView mav = new ModelAndView("home"); // using home
		List<Employee> employees = new ArrayList<>();

		if (empId != null) {
			employees = employeeDao.search(empId);
		} else if (firstname != null) {
			employees = employeeDao.search(firstname);
		}
		mav.addObject("employees", employees);
		System.out.println(employees + "\n");
		return mav;
	}

	@RequestMapping(value = "/employments/{empId}")
	public ModelAndView findHistory(@PathVariable("empId") Long empId) {

		ModelAndView mav = new ModelAndView("employments");
		List<EmployeeHistory> history = new ArrayList<>();

		history = employeeDao.getHistory(empId);

		Employee employee = employeeService.findById(empId);

		mav.addObject("employeehistory", history);
		mav.addObject("name", employee);

		return mav;

	}

	@RequestMapping(value = "/export")
	public void exportToCSV(HttpServletResponse response) throws IOException {
		response.setContentType("text/csv");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
		String currentDateTime = dateFormatter.format(new Date());

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=Employee_" + currentDateTime + ".csv";
		response.setHeader(headerKey, headerValue);

		List<Employee> empList = employeeService.findAll();

		ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
		String[] csvHeader = { "User ID", "E-mail", "First Name", "Last Name", "Gender", "Salary", "Dob", "Pan Card Number",
				"Aadhaar Card Number", "Mobile", "Permanant Addresss", "Present Addresss", "Blood Group", "Post name" };
		String[] nameMapping = { "empId", "emailId", "firstName", "lastName", "gender", "basicPay", "dob", "panNum",
				"aadhaarNum", "mobileNum", "permanantAddresss", "presentAddresss", "bloodGroup", "post_name" };

		csvWriter.writeHeader(csvHeader);

		for (Employee emp : empList) {
			csvWriter.write(emp, nameMapping);
		}

		csvWriter.close();

	}

//	INSERT INTO `employee_portal`.`employee` (`emp_id`, `first_name`, `last_name`, `gender`, `dob`, `pan_num`, `aadhaar_num`, `mobile_num`, `email_id`, `office_mail`, `permanant_address`, `present_address`, `blood_group`, `doj`, `emp_level`, `post_name`, `basic_pay`, `house_allowance`) VALUES ('101', 'Vicky', 'V V', 'M', '2000-09-08', '3456765', '4776548', '9790351600', 'V@D.com', 'Vicky@deloitte.com', '2, Iyyerbungalow, Madurai.', '4, Bellandur, Bangalore', 'B-ve', '2023-01-16', '1', 'analyst', '760000', '10000');
//	INSERT INTO `employee_portal`.`employee` (`emp_id`, `first_name`, `last_name`, `gender`, `dob`, `mobile_num`, `email_id`, `office_mail`, `permanant_address`, `present_address`, `blood_group`, `doj`, `emp_level`, `post_name`, `basic_pay`, `house_allowance`) VALUES ('103', 'Megha', 'N ', 'F', '2001-01-21', '8874027811', 'b@d.com', 'megha@deloitte.com', '2, tanzania, africa', '3, bellandur, Bangalore', 'O-ve', '2023-01-16', '1', 'analyst', '760000', '15000');
//	INSERT INTO `employee_portal`.`employee` (`emp_id`, `first_name`, `last_name`, `gender`, `dob`, `pan_num`, `aadhaar_num`, `mobile_num`, `email_id`, `office_mail`, `permanant_address`, `present_address`, `blood_group`, `doj`, `emp_level`, `post_name`, `basic_pay`, `house_allowance`) VALUES ('104', 'Shenba', 'priya', 'F', '2001-06-15', '2345676', '9852245', '1234567876', 'Shenba@gmail.com', 'Shenba@accenture.com', '5, madurai, India', '6, bellandur, Bangalore', 'O-ve', '2022-11-07', '2', 'trainee', '560000', '10000');

//	INSERT INTO `employee_portal`.`employee_history` (`id`, `emp_id`, `organization_name`, `from_date`, `until_date`, `location`, `country`, `post`, `skill_used`) VALUES ('1', '103', 'CTS', '2021-07-14', '2022-06-15', 'Mumbai', 'India', 'pa', 'excel');
//	INSERT INTO `employee_portal`.`employee_history` (`id`, `emp_id`, `organization_name`, `from_date`, `until_date`, `location`, `country`, `post`, `skill_used`) VALUES ('2', '103', 'TCS', '2022-06-15', '2023-06-15', 'Bangalore', 'India', 'a', 'python');
//	INSERT INTO `employee_portal`.`employee_history` (`id`, `emp_id`, `organization_name`, `from_date`, `until_date`, `location`, `country`, `post`, `skill_used`) VALUES ('4', '104', 'Accenture', '2022-06-15', '2023-06-15', 'NY', 'USA', 'ASE', 'Salesforce');
//	INSERT INTO `employee_portal`.`employee_history` (`id`, `emp_id`, `organization_name`, `from_date`, `until_date`, `location`, `country`, `post`, `skill_used`) VALUES ('5', '104', 'CTS', '2021-07-14', '2022-07-14', 'California', 'USA', 'sae', 'java');
//	INSERT INTO `employee_portal`.`employee_history` (`id`, `emp_id`, `organization_name`, `from_date`, `until_date`, `location`, `country`, `post`, `skill_used`) VALUES ('6', '104', 'TCS', '2022-07-14', '2022-12-30', 'Ohio', 'USA', 'CEO', 'Spring');

}
