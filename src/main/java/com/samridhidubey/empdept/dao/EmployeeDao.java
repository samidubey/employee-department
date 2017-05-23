package com.samridhidubey.empdept.dao;

import com.samridhidubey.empdept.domain.Employee;

public interface EmployeeDao {

	Boolean create(final Employee employee);

	Boolean update(final Employee employee);

	Boolean delete(final Employee employee);

	Employee findById(final Integer id);
}
