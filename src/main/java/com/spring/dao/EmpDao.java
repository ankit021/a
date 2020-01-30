package com.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.spring.model.Employee;

public class EmpDao {

	JdbcTemplate template;

	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public int save(Employee emp) {
		String sql = "insert into Emp99(name,sal,designation) values(?,?,?)";
		return template.update(sql, new Object[] { emp.getName(), emp.getSalary(), emp.getDesignation() });
	}

	public List<Employee> getEmployees() {

		return template.query("select * from Emp99", new RowMapper<Employee>() {
			public Employee mapRow(ResultSet rs, int row) throws SQLException {
				Employee e = new Employee();
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setSalary(rs.getFloat(3));
				e.setDesignation(rs.getString(4));
				return e;
			}
		});
	}

	public int update(Employee emp) {
		String sql = "UPDATE Emp99 SET sal = ?,designation=? WHERE name = ?";
		return template.update(sql, new Object[] { emp.getSalary(), emp.getDesignation(), emp.getName() });
	}

	public int delete(Employee emp) {
		
		String sql="delete from Emp99 where id=?";
		return template.update(sql,new Object[] {emp.getId()});
	}
}
