package com.example.employeeskillstrackingapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.employeeskillstrackingapplication.model.Skill;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long>{

}
