package com.example.employeeskillstrackingapplication;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "skill")
public class Skill {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long skillId;
	private String name;
	private String description;
	private int rating;

	@ManyToMany(fetch = FetchType.LAZY, 
			cascade = { 
					CascadeType.PERSIST, 
					CascadeType.MERGE }, 
			mappedBy = "skills")
	private Set<Employee> employee = new HashSet<>();

	public long getSkillId() {
		return skillId;
	}

	public void setSkillId(long skillId) {
		this.skillId = skillId;
	}

	public Set<Employee> getEmployee() {
		return employee;
	}

	public void setEmployee(Set<Employee> employee) {
		this.employee = employee;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public int getRating() {
		return rating;
	}

}
