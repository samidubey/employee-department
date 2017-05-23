package com.samridhidubey.empdept.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.samridhidubey.empdept.domain.Employee;
import com.samridhidubey.empdept.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	private static final Logger LOG = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeService service;

	@RequestMapping(method = RequestMethod.POST, value = "/create")
	public ResponseEntity<?> create(String empName, String empDateOfBirth, Double empSalary, String empAddress,
			String empEmail, String empPhone, Integer deptId) {

		Employee employee = new Employee();
		employee.setName(empName);
		employee.setDateOfBirth(empDateOfBirth);
		employee.setSalary(empSalary);
		employee.setAddress(empAddress);
		employee.setEmail(empEmail);
		employee.setPhoneNumber(empPhone);
		employee.setDepartmentId(deptId);

		Boolean result = service.create(employee);

		if (result) {
			return new ResponseEntity<String>("Employee record inserted.", null, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<String>("Unable to create employee", null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}
