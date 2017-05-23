package com.samridhidubey.empdept.service;

import com.samridhidubey.empdept.domain.Employee;

public interface EmployeeService {

	Boolean create(final Employee employee);

	Boolean update(final Employee employee);

	Boolean delete(final Employee employee);

	Employee findById(final Integer id);
}
