package com.azreen.restful.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.azreen.restful.model.Employee;
import com.azreen.restful.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	//build create employee REST API
	@PostMapping
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
		
		return new ResponseEntity<Employee>(employeeService.insertEmployee(employee),HttpStatus.CREATED);
		
	}
	
	//get all employee REST API
	@GetMapping
	public List<Employee> getAllEmployees(){
		return employeeService.getAllEmployee();
	}
	
	//get employee by ID
	@GetMapping("{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long id){
		return new ResponseEntity<Employee>(employeeService.getEmployeeById(id),HttpStatus.OK);
		
	}
	
	//update employee by ID
	@PutMapping("{id}")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee,@PathVariable("id") long id){
		
		return new ResponseEntity<Employee>(employeeService.updateEmployee(employee, id),HttpStatus.OK);
	}
	
	//delete employee by id
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id){
		
		employeeService.deleteEmployee(id);
		
		return new ResponseEntity<String>("Employee deleted successfully",HttpStatus.OK);
	}
}
