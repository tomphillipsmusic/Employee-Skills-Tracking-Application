package com.example.employeeskillstrackingapplication.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.employeeskillstrackingapplication.model.Employee;
import com.example.employeeskillstrackingapplication.model.Skill;
import com.example.employeeskillstrackingapplication.service.EmployeeService;
import com.example.employeeskillstrackingapplication.service.SkillService;

@CrossOrigin
@RestController
public class SkillRestController {

	@Autowired
	SkillService skillService;

	@Autowired
	EmployeeService employeeService;

	@GetMapping("/employees/{employeeId}/skills")
	public List<Skill> getSkillsByEmployee(@PathVariable("employeeId") int employeeId) {
		return skillService.getSkillsByEmployeeId(employeeId);
	}

	@PostMapping("/employees/{employeeId}/skills")
	@ResponseStatus(HttpStatus.CREATED)
	public long saveSkill(@Valid @RequestBody Skill skill, @PathVariable("employeeId") int employeeId) {
		Employee employee = employeeService.getEmployeeById(employeeId);
		skill.setEmployee(employee);
		skillService.saveSkill(skill);
		return skill.getSkillId();

	}

	@GetMapping("/employees/{employeeId}/skills/{skillId}")
	public Skill getSkillById(@PathVariable("employeeId") int employeeId, @PathVariable("skillId") long skillId) {
		employeeService.getEmployeeById(employeeId);
		return skillService.getSkillById(skillId);

	}

	@PutMapping("/employees/{employeeId}/skills/{skillId}")
	public long updateSkill(@Valid @RequestBody Skill skill, @PathVariable("employeeId") int employeeId,
			@PathVariable("skillId") long skillId) {
		Employee employee = employeeService.getEmployeeById(employeeId);
		skill.setEmployee(employee);
		skill.setSkillId(skillId);
		skillService.updateSkill(skill);
		return skill.getSkillId();

	}

	@DeleteMapping("/employees/{employeeId}/skills/{skillId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteEmployee(@PathVariable("employeeId") int employeeId, @PathVariable("skillId") Long skillId) {
		employeeService.getEmployeeById(employeeId);
		skillService.getSkillById(skillId);
		skillService.delete(skillId);
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		return errors;
	}

}
