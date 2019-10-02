package com.capgemini.springmvc.dao;

import java.util.List;

import com.capgemini.springmvc.beans.EmployeeBean;

public interface EmployeeDAO {

	public EmployeeBean login(int empId, String passwod);
	public boolean addEmployee(EmployeeBean employeeBean);
	public EmployeeBean searchEmployee(int empId);
	public boolean deleteEmployee(int empId);
	public boolean updateEmployee(EmployeeBean employeeBean);
	public List<EmployeeBean> getEmployee();
}
