package com.example.employeeskillstrackingapplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exceptions.EmployeeNotFoundException;
import exceptions.SkillNotFoundException;

@Service
public class SkillService {

	@Autowired
	SkillRepository skillRepository;

	public Skill getSkillById(Long skillId) {
		Optional<Skill> skillOp = skillRepository.findById(skillId);
		Skill requestedSkill = skillOp
				.orElseThrow(() -> new SkillNotFoundException("Skill Not Found"));
		return requestedSkill;
	}

	public List<Skill> getSkillsByEmployeeId(int employeeId) {
		List<Skill> allSkills = getAllSkills();
		List<Skill> employeeSkills = new ArrayList<>();
		for (Skill skill : allSkills) {
			if (skill.getEmployee().getEmployeeId() == employeeId) {
				employeeSkills.add(skill);
			}
		}
		return employeeSkills;
	}

	public List<Skill> getAllSkills() {
		List<Skill> allSkills = new ArrayList<>();
		skillRepository.findAll().forEach(skill -> allSkills.add(skill));
		return allSkills;
	}

	public Skill save(Skill skill) {
		if (isValidSkill(skill)) {
			return skillRepository.save(skill);
		}
		return null;
	}

	public Skill update(Skill skill) {
		long skillId = skill.getSkillId();
		System.out.println(skillId);
		if (getSkillById(skillId) == null) {
			throw new SkillNotFoundException("Employee Skill Not Found");
		}
		return save(skill);
	}

	public void delete(Long id) {
		skillRepository.deleteById(id);
	}

	private boolean isValidSkill(Skill skill) {
		if (skill.getName() != null && skill.getRating() != null && skill.getDescription() != null) {
			return true;
		}
		return false;
	}

}
