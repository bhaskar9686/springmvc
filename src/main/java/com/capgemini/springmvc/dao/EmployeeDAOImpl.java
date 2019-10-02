package com.capgemini.springmvc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.springmvc.beans.EmployeeBean;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{
	static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("TestPersistence");
	
	@Override
	public EmployeeBean login(int empId, String password) {
		EntityManager manager = factory.createEntityManager();
		
		String jpql = "from EmployeeBean WHERE empId = :id and password= :pwd";
		Query query = manager.createQuery(jpql);
		query.setParameter("id", empId);
		query.setParameter("pwd", password);
		EmployeeBean employeeBean = null;
		try {
			 employeeBean = (EmployeeBean) query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employeeBean ;
	}

	@Override
	public boolean addEmployee(EmployeeBean employeeBean) {
		EntityManager manager = factory.createEntityManager();
		boolean isAdded = false;
		try {
			manager.getTransaction().begin();
			manager.persist(employeeBean);
			manager.getTransaction().commit();
			isAdded =true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		manager.close();
		return isAdded;
	}

	@Override
	public EmployeeBean searchEmployee(int empId) {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		EmployeeBean employeeBean  = manager.find(EmployeeBean.class, empId);
		if(employeeBean!=null) {
			return employeeBean;
		}
		manager.getTransaction().commit();
		manager.close();
		return employeeBean;
	}

	@Override
	public boolean deleteEmployee(int empId) {
		boolean isDeleted = false;
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		EmployeeBean employeeBean = manager.find(EmployeeBean.class, empId);
		manager.remove(employeeBean);
		manager.getTransaction().commit();
		isDeleted = true;
		manager.close();
		return isDeleted;
	}

	@Override
	public boolean updateEmployee(EmployeeBean employeeBean) {
		boolean isUpdated = false;
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		EmployeeBean employeeBean2 = manager.find(EmployeeBean.class, employeeBean.getEmpId());
		employeeBean2.setEmpName(employeeBean.getEmpName());
		employeeBean2.setAge(employeeBean.getAge());
		employeeBean2.setPosition(employeeBean.getPosition());
		employeeBean2.setSalary(employeeBean.getSalary());
		manager.getTransaction().commit();
		isUpdated = true;
		manager.close();
		return isUpdated;
	}

	@Override
	public List<EmployeeBean> getEmployee() {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		String jpql = "from EmployeeBean";
		Query query = manager.createQuery(jpql);
		List<EmployeeBean> list = null;
		try {
			list = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
