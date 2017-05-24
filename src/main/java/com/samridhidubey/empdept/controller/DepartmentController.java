package com.samridhidubey.empdept.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.samridhidubey.empdept.domain.Department;
import com.samridhidubey.empdept.service.DepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentController {
	@Autowired
	private DepartmentService service;

	@RequestMapping(method = RequestMethod.POST, value = "/create")
	public ResponseEntity<?> create(String deptName, String deptDesc) {
		Department dept = new Department();
		dept.setName(deptName);
		dept.setDetails(deptDesc);
		Boolean result = service.create(dept);
		if (result) {
			return new ResponseEntity<String>("Department record inserted.", null, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<String>("Unable to create department", null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(method = RequestMethod.POST, value = "/update")
	public ResponseEntity<?> update(int id, String deptName, String deptDesc) {
		Department dept = new Department();
		dept.setId(id);
		dept.setName(deptName);
		dept.setDetails(deptDesc);
		Boolean result = service.update(dept);
		if (result) {
			return new ResponseEntity<String>("Department record update.", null, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<String>("Unable to update department", null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(method = RequestMethod.POST, value = "/delete")
	public ResponseEntity<?> delete(int id) {
		Department dept = new Department();
		dept.setId(id);
		Boolean result = service.delete(dept);
		if (result) {
			return new ResponseEntity<String>("Department record deleted.", null, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<String>("Unable to delete department", null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(method = RequestMethod.GET, value = "/find")
	public Department find(int id) {
		Department dept = new Department();
		dept.setId(id);
		return service.findById(id);
	}
}
