package com.samridhidubey.empdept.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import com.samridhidubey.empdept.dao.EmployeeDao;
import com.samridhidubey.empdept.domain.Employee;

@Repository
public class EmployeeJDBCTemplateDao implements EmployeeDao {
	@Autowired
	private JdbcTemplate template;

	@Override
	public Boolean create(final Employee emp) {

		Assert.notNull(emp, "Employee object cannot be null while creating");

		String query = "INSERT INTO employee(e_name, e_date_of_birth, e_salary, e_address, e_email, e_phone, e_d_id) VALUES(?,?,?,?,?,?,?)";
		int result = template.update(query, emp.getName(), emp.getDateOfBirth(), emp.getSalary(), emp.getAddress(),
				emp.getEmail(), emp.getPhoneNumber(), emp.getDepartmentId());

		return (result > 0);
	}

	@Override
	public Boolean update(final Employee emp) {
		Assert.notNull(emp, "Employee object cannot be null while updating");

		String query = "UPDATE employee SET e_name =?, e_date_of_birth =?, e_salary=?, e_address=?, e_email=?, e_phone=?, e_d_id=? WHERE e_id=?";
		int result = template.update(query, emp.getName(), emp.getDateOfBirth(), emp.getSalary(), emp.getAddress(),
				emp.getEmail(), emp.getPhoneNumber(), emp.getDepartmentId(), emp.getId());

		return (result > 0);

	}

	@Override
	public Boolean delete(final Employee emp) {

		Assert.notNull(emp, "Employee object cannot be null while deleting");

		String query = "DELETE FROM employee WHERE e_id=?";
		int result = template.update(query, emp.getId());

		return (result > 0);
	}

	@Override
	public Employee findById(final Integer id) {
		Assert.notNull(id, "Employee id cannot be null");
		Assert.isTrue(id.intValue() > 0, "Employee id need to be greater than 0");

		String query = "SELECT * FROM employee WHERE e_id=?";
		return template.queryForObject(query, new Object[] { id }, new EmployeeRowMapper());
	}

}

class EmployeeRowMapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet rs, int index) throws SQLException {
		Employee emp = new Employee();

		emp.setId(rs.getInt("e_id"));
		emp.setName(rs.getString("e_name"));
		emp.setDateOfBirth(rs.getString("e_date_of_birth"));
		emp.setSalary(rs.getDouble("e_salary"));
		emp.setAddress(rs.getString("e_address"));
		emp.setEmail(rs.getString("e_email"));
		emp.setPhoneNumber(rs.getString("e_phone"));
		emp.setDepartmentId(rs.getInt("e_d_id"));

		return emp;
	}
}
