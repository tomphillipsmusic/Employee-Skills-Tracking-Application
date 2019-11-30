package model.copy;

import org.springframework.data.repository.CrudRepository;

import com.example.employeeskillstrackingapplication.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer>{

}
