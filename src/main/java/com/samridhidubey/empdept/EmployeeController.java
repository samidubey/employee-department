package com.samridhidubey.empdept;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	private static final Logger LOG = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private JdbcTemplate template;

	@RequestMapping("/count")
	public String getCount() {
		Integer count = template.queryForObject("select count(*) from employee", Integer.class);
		return count.toString();
	}

	@RequestMapping("/empcreate")
	public String create(String empName, String empDateOfBirth, float empSalary, String empAddress, String empEmail,
			String empPhone, String deptName) {
		if (empName != null && !empName.isEmpty()) {
			StringBuilder queryStr = new StringBuilder();
			String deptQuery;
			deptQuery = "select d_id from department where d_name =" + "'" + deptName + "'";
			int deptId = template.queryForObject(deptQuery, Integer.class);
			if (deptId != 0) {
				queryStr.append(
						"INSERT INTO employee(e_name, e_date_of_birth, e_salary, e_address, e_email, e_phone, e_d_id)");
				queryStr.append("VALUES(" + "'" + empName + "'" + "," + "'" + empDateOfBirth + "'" + "," + "'"
						+ empSalary + "'" + "," + "'" + empAddress + "'" + "," + "'" + empEmail + "'" + "," + "'"
						+ empPhone + "'" + "," + "'" + deptId + "')");
				template.update(queryStr.toString());
				return "row created";
			}
			return "department name is wrong or not given";

		}
		return "row not created";
	}
}
