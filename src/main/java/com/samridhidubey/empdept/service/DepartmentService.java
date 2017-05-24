package com.samridhidubey.empdept.service;

import com.samridhidubey.empdept.domain.Department;

public interface DepartmentService {
	Boolean create(final Department department);

	Boolean update(final Department department);

	Boolean delete(final Department department);

	Department findById(final Integer id);
}
