package com.samridhidubey.empdept.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.samridhidubey.empdept.dao.EmployeeDao;
import com.samridhidubey.empdept.domain.Employee;
import com.samridhidubey.empdept.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeDao dao;

	@Override
	public Boolean create(Employee employee) {
		return dao.create(employee);
	}

	@Override
	public Boolean update(Employee employee) {
		return dao.update(employee);
	}

	@Override
	public Boolean delete(Employee employee) {
		return dao.delete(employee);
	}

	@Override
	public Employee findById(Integer id) {
		return dao.findById(id);
	}

}
