package com.azreen.restful.service;

import java.util.List;

import com.azreen.restful.model.Employee;

public interface EmployeeService {

	Employee insertEmployee(Employee employee);
	List<Employee> getAllEmployee();
	Employee getEmployeeById(long id);
	Employee updateEmployee(Employee employee, long id);
	void deleteEmployee( long id);
}
