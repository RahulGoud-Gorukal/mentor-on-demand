package com.example.MentorOnDemand.Service;

import com.example.MentorOnDemand.Exception.ApplicationException;
import com.example.MentorOnDemand.Model.Admin;

public interface AdminService {
	public boolean insertAdmin(Admin admin) throws  ApplicationException;

	public Admin loginAdmin(String username,String password) throws ApplicationException;

}
