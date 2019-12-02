package com.example.employeeskillstrackingapplication;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EmployeeServiceTest {
	
	
	EmployeeService employeeService = new EmployeeService();	
	

	
	@Test
	public void trueIsTrue() {
		assertTrue(1 == 1);
	}

	@Test
	public void getAllEmployeesReturnsThreeEmployees() {
		List<Employee> allEmployees = employeeService.getAllEmployees();
		int actualSize = allEmployees.size();
		assertEquals(3, actualSize);
	}
}