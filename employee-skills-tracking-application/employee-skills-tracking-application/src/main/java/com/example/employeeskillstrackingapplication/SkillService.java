package com.example.employeeskillstrackingapplication;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillService {

	@Autowired
	SkillRepository skillRepository;
	
	public Skill getSkillById(Long skillId) {
		return skillRepository.findById(skillId).get();
	}
	
	public List<Skill> getSkillsByEmployeeId(int employeeId){
		List<Skill> allSkills = getAllSkills();
		List<Skill> employeeSkills = new ArrayList<>();
		for(Skill skill : allSkills) {
			if (skill.getEmployee().getEmployeeId() == employeeId) {
				employeeSkills.add(skill);
			}
		}
		return allSkills;
	}
	
	public List<Skill> getAllSkills(){
		List<Skill> allSkills = new ArrayList<>();
		skillRepository.findAll().forEach(skill -> allSkills.add(skill));
		return allSkills;
	}
	
	public Skill saveOrUpdate(Skill skill) {
		return skillRepository.save(skill);
	}
	
	public void delete(Long id) {
		skillRepository.deleteById(id);
	}
	
}
