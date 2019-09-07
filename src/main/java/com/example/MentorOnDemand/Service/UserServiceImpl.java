package com.example.MentorOnDemand.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MentorOnDemand.Dao.UserDao;
import com.example.MentorOnDemand.Exception.ApplicationException;
import com.example.MentorOnDemand.Model.Admin;
import com.example.MentorOnDemand.Model.User;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;

	@Override
	public boolean insertUser(User user) throws ApplicationException {
		// TODO Auto-generated method stub
		try
		{
			userDao.save(user) ;
		}
		catch(Exception e)
		{
			throw new ApplicationException("Insert User failed");
		}
		 return true;
	}

	@Override
	public User loginUser(String username, String password) throws ApplicationException {
		// TODO Auto-generated method stub
		User userObject;
		try
		{
			userObject=userDao.loginUser(username, password);
		}
		catch(Exception e)
		{
			throw new ApplicationException("Login user failed");
		}
		 return userObject;
	}
	}


