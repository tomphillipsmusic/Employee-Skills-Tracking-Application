package com.example.employeeskillstrackingapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.employeeskillstrackingapplication.exceptions.EmployeeNotFoundException;
import com.example.employeeskillstrackingapplication.exceptions.InvalidDataException;
import com.example.employeeskillstrackingapplication.model.Employee;
import com.example.employeeskillstrackingapplication.service.EmployeeService;

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
	@ResponseStatus(HttpStatus.CREATED)
	public int saveEmployee(@RequestBody Employee employee) {
		Employee newEmployee = employeeService.save(employee);
		if (newEmployee != null) {
			return employee.getEmployeeId();
		} else {
			throw new InvalidDataException("Invalid Perficient employee data sent to server.");
		}
	}

	@GetMapping("employees/{id}")
	public Employee getEmployeeById(@PathVariable("id") int employeeId) {
		return employeeService.getEmployeeById(employeeId);

	}

	@PutMapping("/employees/{id}")
	public int updateEmployee(@PathVariable("id") int employeeId, @RequestBody Employee employee) {
		employee.setEmployeeId(employeeId);
		Employee newEmployee = employeeService.update(employee);
		if (newEmployee != null) {
			return employee.getEmployeeId();
		} else {
			throw new InvalidDataException("Invalid Perficient employee data sent to server.");
		}
	}

	@DeleteMapping("/employees/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteEmployee(@PathVariable("id") int employeeId) {
		employeeService.delete(employeeId);
	}

}