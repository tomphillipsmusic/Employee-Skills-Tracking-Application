package com.example.employeeskillstrackingapplication;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	public List<Employee> getAllEmployees(){
		List<Employee> allEmployees = new ArrayList<>();
		employeeRepository.findAll().forEach(employee -> allEmployees.add(employee));
		return allEmployees;
	}
	
	public Employee getEmployeeById(int id) {
		return employeeRepository.findById(id).get();
	}
	
	public Employee saveOrUpdate(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	public void delete(int id) {
		employeeRepository.deleteById(id);
	}
	
	
	
	

}
