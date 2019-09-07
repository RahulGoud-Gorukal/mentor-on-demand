package com.example.MentorOnDemand.Controller;

import java.sql.SQLException;

import org.springframework.web.servlet.ModelAndView;

import com.example.MentorOnDemand.Model.Mentor;

public interface MentorController {

	public boolean insertMentor(Mentor mentor);
	public Mentor loginMentor(String username, String password);
	
}
