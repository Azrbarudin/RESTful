package com.azreen.restful.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.azreen.restful.exception.ResourceNotFoundException;
import com.azreen.restful.model.Employee;
import com.azreen.restful.repository.EmployeeRepository;
import com.azreen.restful.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository empRepo;
	
	/*
	public EmployeeServiceImpl(EmployeeRepository empRepo) {
		super();
		this.empRepo = empRepo;
	}
	 */
	
	@Override
	public Employee insertEmployee(Employee employee) {
				
		return empRepo.save(employee);
	}

	@Override
	public List<Employee> getAllEmployee() {
		
		return empRepo.findAll();
	}

	@Override
	public Employee getEmployeeById(long id) {
	/*	
		Optional<Employee> employee = empRepo.findById(id);
		if(employee.isPresent()) {
			
			return employee.get();
		}else {
			throw new ResourceNotFoundException("Employee", "id", id);
		}
		*/
		
		return empRepo.findById(id).orElseThrow(()-> 
			new ResourceNotFoundException("Employee", "id", id));
	}

	@Override
	public Employee updateEmployee(Employee employee, long id) {
		
		//check employee id exist
		
		Employee empDB = empRepo.findById(id).orElseThrow(()-> 
			new ResourceNotFoundException("Employee", "id", id));
		
		empDB.setFirstname(employee.getFirstname());
		empDB.setLastname(employee.getLastname());
		empDB.setEmail(employee.getEmail());
		
		//save
		empRepo.save(empDB);
		
		return empDB;
	}

	@Override
	public void deleteEmployee(long id) {
		
		//check employee id exist
		Employee empDB = empRepo.findById(id).orElseThrow(()-> 
		new ResourceNotFoundException("Employee", "id", id));
		
		empRepo.deleteById(id);	
	}

}
