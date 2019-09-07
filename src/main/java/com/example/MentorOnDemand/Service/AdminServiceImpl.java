package com.example.MentorOnDemand.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MentorOnDemand.Dao.AdminDao;
import com.example.MentorOnDemand.Exception.ApplicationException;
import com.example.MentorOnDemand.Model.Admin;
import com.example.MentorOnDemand.Model.Mentor;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminDao adminDao;
	@Override
	public boolean insertAdmin(Admin admin) throws ApplicationException {
		// TODO Auto-generated method stub
		try
		{
			adminDao.save(admin) ;
		}
		catch(Exception e)
		{
			throw new ApplicationException("Insert admin failed");
		}
		 return true;
	}

	@Override
	public Admin loginAdmin(String username, String password) throws ApplicationException {
		// TODO Auto-generated method stub
		Admin adminObject;
		try
		{
			adminObject=adminDao.loginAdmin(username,password);
		}
		catch(Exception e)
		{
			throw new ApplicationException("Admin Login failed");
		}
		 return adminObject;
	}

}
