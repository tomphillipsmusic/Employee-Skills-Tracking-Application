package com.example.employeeskillstrackingapplication.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employeeskillstrackingapplication.exceptions.SkillNotFoundException;
import com.example.employeeskillstrackingapplication.model.Skill;
import com.example.employeeskillstrackingapplication.repository.SkillRepository;

@Service
public class SkillService {

	@Autowired
	SkillRepository skillRepository;

	public Skill getSkillById(Long skillId) {
		Optional<Skill> skillOp = skillRepository.findById(skillId);
		Skill requestedSkill = skillOp.orElseThrow(() -> new SkillNotFoundException("Skill Not Found"));
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

	public Skill saveSkill(Skill skill) {
		return skillRepository.save(skill);

	}

	public Skill updateSkill(Skill skill) {
		long skillId = skill.getSkillId();
		if (getSkillById(skillId) == null) {
			throw new SkillNotFoundException("Employee Skill Not Found");
		}
		return saveSkill(skill);
	}

	public void delete(Long id) {
		skillRepository.deleteById(id);
	}

}
