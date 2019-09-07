package com.example.MentorOnDemand.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.MentorOnDemand.Model.Skill;

public interface SkillDao extends JpaRepository<Skill, Integer>{

}
