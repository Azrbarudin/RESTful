package com.azreen.restful.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.azreen.restful.model.Employee;

//@Repository spring jpa added it already
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
	
	

}
