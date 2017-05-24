package com.samridhidubey.empdept.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import com.samridhidubey.empdept.dao.DepartmentDao;
import com.samridhidubey.empdept.domain.Department;

@Repository
public class DepartmentJDBCTemplateDao implements DepartmentDao {

	@Autowired
	private JdbcTemplate template;

	@Override
	public Boolean create(Department department) {
		Assert.notNull(department, "Department cannot be null while creating.");
		String query = "INSERT INTO department(d_name,d_details) VALUES(?,?)";
		int result = template.update(query, department.getName(), department.getDetails());
		return (result > 0);
	}

	@Override
	public Boolean update(Department department) {
		Assert.notNull(department, "Department cannot be null while updating.");
		String query = "UPDATE department SET d_name = ?,d_details =? WHERE d_id = ?";
		int result = template.update(query, department.getName(), department.getDetails(), department.getId());
		return (result > 0);

	}

	@Override
	public Boolean delete(Department department) {
		Assert.notNull(department, "Department cannot be null while deleting.");
		String query = "DELETE FROM department WHERE d_id = ?";
		int result = template.update(query, department.getId());
		return (result > 0);
	}

	@Override
	public Department findById(Integer id) {
		Assert.notNull(id, "Department id cannot be null while searching.");
		Assert.isTrue(id > 0, "Department id need to be greater than 0");
		String query = "SELECT * FROM department WHERE d_id = ?";
		return template.queryForObject(query, new Object[] { id }, new DepartmentRowMapper());
	}

}

class DepartmentRowMapper implements RowMapper<Department> {

	@Override
	public Department mapRow(ResultSet rs, int index) throws SQLException {
		Department dept = new Department();
		dept.setId(rs.getInt("d_id"));
		dept.setName(rs.getString("d_name"));
		dept.setDetails(rs.getString("d_details"));
		return dept;
	}

}
