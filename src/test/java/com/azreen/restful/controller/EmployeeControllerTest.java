package com.azreen.restful.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EmployeeControllerTest {

	@Test
	void test() {
		
		EmployeeController employeeController = new EmployeeController();
		assertEquals("test", employeeController.getAllEmployees());
	}

}
