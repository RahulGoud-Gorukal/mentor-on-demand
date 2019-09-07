package com.example.MentorOnDemand.Controller;

import java.sql.SQLException;
import java.util.List;

import com.example.MentorOnDemand.Exception.ApplicationException;
import com.example.MentorOnDemand.Model.Skill;

public interface SkillController {
	
	public boolean insertSkill(Skill skill);
	
	public List<Skill> getSkillList() throws SQLException, ApplicationException;

}
