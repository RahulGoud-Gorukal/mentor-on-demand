package com.example.MentorOnDemand.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MentorOnDemand.Dao.MentorDao;
import com.example.MentorOnDemand.Exception.ApplicationException;
import com.example.MentorOnDemand.Model.Mentor;

@Service
public class MentorServiceImpl implements MentorService{

	@Autowired
	private MentorDao mentorDao;
	
	@Override
	public boolean insertMentor(Mentor mentor) throws ApplicationException {
		// TODO Auto-generated method stub
		try
		{
			 mentorDao.save(mentor) ;
		}
		catch(Exception e)
		{
			throw new ApplicationException("Insert Mentor failed");
		}
		 return true;

	}

	@Override
	public Mentor loginMentor(String username,String password) throws ApplicationException {
		// TODO Auto-generated method stub
		Mentor mentor;
		try
		{
		mentor=mentorDao.loginMentor(username,password);
		}
		catch(Exception e)
		{
			throw new ApplicationException("Mentor Login failed");
		}
		 return mentor;
	}

	@Override
	public List<Mentor> searchMentor(String skill) throws ApplicationException {
		// TODO Auto-generated method stub
		/*Mentor mentor;
		try
		{
		mentor=mentorDao.fi(skill);
		}
		catch(Exception e)
		{
			throw new ApplicationException("Mentor Search failed");
		}
		 return mentor;*/
		return mentorDao.findBytechnology(skill);
		
	}

	@Override
	public List<Mentor> getMentorList() throws ApplicationException {
		// TODO Auto-generated method stub
		return mentorDao.findAll();
	}

}
