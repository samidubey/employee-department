package com.samridhidubey.empdept;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/department")
public class DepartmentController {
	@Autowired
	private JdbcTemplate template;

	@RequestMapping("/create")
	public String create(String deptName, String deptDesc) {
		// DepartmentProperties objDeptProp = new DepartmentProperties();
		if (deptName != null && !deptName.isEmpty()) {
			StringBuilder queryStr = new StringBuilder();
			// deptName = objDeptProp.getDeptName();
			// deptDesc = objDeptProp.getDeptDesc();
			queryStr.append("INSERT INTO department(d_name, d_details)");
			queryStr.append("VALUES(" + "'" + deptName + "'" + "," + "'" + deptDesc + "'" + ")");
			template.update(queryStr.toString());
			return "row created";
		}
		return "row not created";
	}
}
