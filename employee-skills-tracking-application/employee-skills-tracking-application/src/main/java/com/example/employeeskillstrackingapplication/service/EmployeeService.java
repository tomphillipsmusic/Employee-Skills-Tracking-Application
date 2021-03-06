package com.example.employeeskillstrackingapplication.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employeeskillstrackingapplication.exceptions.EmployeeNotFoundException;
import com.example.employeeskillstrackingapplication.exceptions.InvalidIdException;
import com.example.employeeskillstrackingapplication.model.Employee;
import com.example.employeeskillstrackingapplication.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	public List<Employee> getAllEmployees() {
		List<Employee> allEmployees = new ArrayList<>();
		employeeRepository.findAll().forEach(employee -> allEmployees.add(employee));
		return allEmployees;
	}

	public Employee getEmployeeById(Integer id) {
		Optional<Employee> employeeOp = employeeRepository.findById(id);
		Employee requestedEmployee = employeeOp
				.orElseThrow(() -> new EmployeeNotFoundException("Perficient Employee Not Found"));
		return requestedEmployee;
	}

	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);

	}

	public Employee updateEmployee(Employee employee) {
		int employeeId = employee.getEmployeeId();
		if (getEmployeeById(employeeId) == null) {
			throw new EmployeeNotFoundException("Perficient Employee Not Found");
		}
		return saveEmployee(employee);
	}

	public void delete(int id) {
		if (getEmployeeById(id) == null) {
			throw new EmployeeNotFoundException("Perficient Employee Not Found");
		}
		employeeRepository.deleteById(id);
	}

}
