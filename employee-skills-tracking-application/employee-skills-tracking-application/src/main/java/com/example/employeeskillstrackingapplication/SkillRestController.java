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
public class SkillRestController {

	@Autowired
	SkillService skillService;
	
	@Autowired
	EmployeeService employeeService;

	@GetMapping("/employees/{employeeId}/skills")
	public List<Skill> getSkillsByEmployee(@PathVariable("employeeId") int employeeId) {
		return skillService.getSkillsByEmployeeId(employeeId);
	}

	@GetMapping("/employees/{employeeId}/skills/{skillId}")
	public Skill getSkillById(@PathVariable("employeeId") int employeeId, 
			@PathVariable("skillId") long skillId) {
		return skillService.getSkillById(skillId);
	}
	
	@PostMapping("/employees/{employeeId}/skills")
	public long saveOrUpdateSkill(@RequestBody Skill skill,
			@PathVariable("employeeId") int employeeId) {
		Employee employee = employeeService.getEmployeeById(employeeId);
		skill.setEmployee(employee);
		skillService.saveOrUpdate(skill);
		return skill.getSkillId();
	}
	
	@DeleteMapping("/employees/{employeeId}/skills/{skillId}")
	public void deleteEmployee(@PathVariable("skillId") Long skillId) {
		skillService.delete(skillId);
	}
	
}
