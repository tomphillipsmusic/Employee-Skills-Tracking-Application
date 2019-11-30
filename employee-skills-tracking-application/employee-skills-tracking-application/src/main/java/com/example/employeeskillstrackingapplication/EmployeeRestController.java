package com.example.employeeskillstrackingapplication;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeRestController {
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("employees")
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}
	
	@GetMapping("employees/{id}")
	public Employee getEmployeeById(@PathVariable("id") int employeeId) {
		return employeeService.getEmployeeById(employeeId);
	}
	
	@PostMapping("employees")
	public int saveEmployee(@RequestBody Employee employee) {
		employeeService.saveOrUpdate(employee);
		return employee.getEmployeeId();
	}
	
	@DeleteMapping("/employees/{id}")
	public void deleteEmployee(@PathVariable("id") int employeeId) {
		employeeService.delete(employeeId);
	}
	
	

}
