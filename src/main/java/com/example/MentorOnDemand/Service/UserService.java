package com.example.MentorOnDemand.Service;

import com.example.MentorOnDemand.Exception.ApplicationException;
import com.example.MentorOnDemand.Model.User;

public interface UserService {
	public boolean insertUser(User user) throws  ApplicationException;

	public User loginUser(String username,String password) throws ApplicationException;

}
