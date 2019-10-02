package com.capgemini.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.springmvc.beans.EmployeeBean;
import com.capgemini.springmvc.dao.EmployeeDAO;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO dao;
	
	@Override
	public EmployeeBean login(int empId, String passwod) {
		return dao.login(empId, passwod);
	}

	@Override
	public boolean addEmployee(EmployeeBean employeeBean) {
		return dao.addEmployee(employeeBean);
	}

	@Override
	public EmployeeBean searchEmployee(int empId) {
		return dao.searchEmployee(empId);
	}

	@Override
	public boolean deleteEmployee(int empId) {
		return dao.deleteEmployee(empId);
	}

	@Override
	public boolean updateEmployee(EmployeeBean employeeBean) {
		return dao.updateEmployee(employeeBean);
	}

	@Override
	public List<EmployeeBean> getEmployee() {
		return dao.getEmployee();
	}

}
