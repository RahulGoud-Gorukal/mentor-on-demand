package com.example.MentorOnDemand.Controller;

import com.example.MentorOnDemand.Model.Admin;

public interface AdminController {
	public boolean insertAdmin(Admin admin);
	public Admin loginAdmin(String username, String password);

}
