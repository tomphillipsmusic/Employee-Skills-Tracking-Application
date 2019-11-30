package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.employeeskillstrackingapplication.Employee;

import model.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		return employeeService.getAllEmployees();
	}
	
	@GetMapping("/employees/{id}")
	public Employee getEmployeeById(@PathVariable("id") int id) {
		return employeeService.getEmployeeById(id);
	}
	
	@DeleteMapping("/employees/{id}")
	public void deleteEmployeeById(@PathVariable("id") int id) {
		employeeService.delete(id);
	}
	
	@PostMapping("/employees") 
	public void saveEmployee(@RequestBody Employee employee) {
		employeeService.saveOrUpdate(employee);
	}
}
