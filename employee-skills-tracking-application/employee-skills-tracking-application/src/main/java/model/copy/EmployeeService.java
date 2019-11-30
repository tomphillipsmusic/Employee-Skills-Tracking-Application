package model.copy;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employeeskillstrackingapplication.Employee;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	public List<Employee> getAllEmployees() {
		List<Employee> allEmployees = new ArrayList<>();
		employeeRepository.findAll().forEach(employee -> allEmployees.add(employee));
		return allEmployees;
	}
	
    public Employee getEmployeeById(int id) {
        return employeeRepository.findById(id).get();
    }

    public void saveOrUpdate(Employee employee) {
        employeeRepository.save(employee);
    }

    public void delete(int id) {
        employeeRepository.deleteById(id);
    }

}
