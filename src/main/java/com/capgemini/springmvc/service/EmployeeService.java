package com.capgemini.springmvc.service;

import java.util.List;

import com.capgemini.springmvc.beans.EmployeeBean;

public interface EmployeeService {

	public EmployeeBean login(int empId, String passwod);
	public boolean addEmployee(EmployeeBean employeeBean);
	public EmployeeBean searchEmployee(int empId);
	public boolean deleteEmployee(int empId);
	public boolean updateEmployee(EmployeeBean employeeBean);
	public List<EmployeeBean> getEmployee();
}
