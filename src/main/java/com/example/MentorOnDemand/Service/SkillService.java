package com.example.MentorOnDemand.Service;

import java.util.List;

import com.example.MentorOnDemand.Exception.ApplicationException;
import com.example.MentorOnDemand.Model.Skill;

public interface SkillService {
	public boolean insertSkill(Skill skill) throws ApplicationException;

	public List<Skill> getSkillList() throws ApplicationException;
}
