package com.example.MentorOnDemand.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MentorOnDemand.Dao.SkillDao;
import com.example.MentorOnDemand.Exception.ApplicationException;
import com.example.MentorOnDemand.Model.Skill;

@Service
public class SkillServiceImpl implements SkillService {
	
	@Autowired
	private SkillDao skillDao;

	@Override
	public boolean insertSkill(Skill skill) throws ApplicationException {
		try
		{
			skillDao.save(skill);
		}
		catch(Exception e)
		{
			throw new ApplicationException("Insert skill failed");
		}
		 return true;
	}

	@Override
	public List<Skill> getSkillList() throws ApplicationException {
		// TODO Auto-generated method stub
		return skillDao.findAll();
	}

}
