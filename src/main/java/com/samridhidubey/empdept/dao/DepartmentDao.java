package com.samridhidubey.empdept.dao;

import com.samridhidubey.empdept.domain.Department;

public interface DepartmentDao {
	Boolean create(final Department department);

	Boolean update(final Department department);

	Boolean delete(final Department department);

	Department findById(final Integer id);

}
