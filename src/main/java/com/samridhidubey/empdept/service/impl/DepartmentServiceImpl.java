package com.samridhidubey.empdept.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.samridhidubey.empdept.dao.DepartmentDao;
import com.samridhidubey.empdept.domain.Department;
import com.samridhidubey.empdept.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
	private DepartmentDao dao;

	@Override
	public Boolean create(Department department) {
		return dao.create(department);
	}

	@Override
	public Boolean update(Department department) {
		return dao.update(department);
	}

	@Override
	public Boolean delete(Department department) {
		return dao.delete(department);
	}

	@Override
	public Department findById(Integer id) {
		return dao.findById(id);
	}

}
