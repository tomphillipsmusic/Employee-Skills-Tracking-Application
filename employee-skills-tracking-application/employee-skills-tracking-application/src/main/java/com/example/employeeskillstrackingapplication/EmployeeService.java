package com.example.employeeskillstrackingapplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exceptions.EmployeeNotFoundException;
import exceptions.InvalidIdException;

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

	public Employee save(Employee employee) {
		if (isValidEmployee(employee)) {
			return employeeRepository.save(employee);
		}
		return null;
	}
	
	public Employee update(Employee employee) {
		int employeeId = employee.getEmployeeId();
		if (getEmployeeById(employeeId) == null) {
			throw new EmployeeNotFoundException("Perficient Employee Not Found");
		}
		return save(employee);
	}

	public void delete(int id) {
		if (getEmployeeById(id) == null) {
			throw new EmployeeNotFoundException("Perficient Employee Not Found");
		}
		employeeRepository.deleteById(id);
	}

	private boolean isValidEmployee(Employee employee) {
		if (employee.getFirstName() != null && employee.getLastName() != null && employee.getPosition() != null) {
			return true;
		}

		return false;
	}

}
