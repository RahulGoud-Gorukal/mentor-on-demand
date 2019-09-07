package com.example.MentorOnDemand.Service;

import java.util.List;


import com.example.MentorOnDemand.Exception.ApplicationException;
import com.example.MentorOnDemand.Model.Mentor;


public interface MentorService {

	public boolean insertMentor(Mentor mentor) throws  ApplicationException;

	public Mentor loginMentor(String username,String password) throws ApplicationException;

	public List<Mentor> searchMentor(String skill)throws ApplicationException;
	
	public List<Mentor> getMentorList() throws ApplicationException;
}
