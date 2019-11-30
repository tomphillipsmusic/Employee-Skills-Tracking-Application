package com.example.employeeskillstrackingapplication;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class EmployeeRestController {
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("employees")
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}
	
	@PostMapping("employees")
	public int saveEmployee(@RequestBody Employee employee) {
		employeeService.saveOrUpdate(employee);
		return employee.getEmployeeId();
	}
	
	@GetMapping("employees/{id}")
	public Employee getEmployeeById(@PathVariable("id") int employeeId) {
		return employeeService.getEmployeeById(employeeId);
	}
	
	@PutMapping("/employees/{id}")
	public int updateEmployee(@PathVariable("id") int employeeId,
			@RequestBody Employee employee) {
		employee.setEmployeeId(employeeId);
		employeeService.saveOrUpdate(employee);
		return employee.getEmployeeId();
	}
		
	@DeleteMapping("/employees/{id}")
	public void deleteEmployee(@PathVariable("id") int employeeId) {
		employeeService.delete(employeeId);
	}
	
	

}
