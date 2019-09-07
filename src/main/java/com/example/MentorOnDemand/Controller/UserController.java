package com.example.MentorOnDemand.Controller;

import com.example.MentorOnDemand.Model.User;

public interface UserController {
	public boolean insertUser(User user);
	public User loginUser(String username, String password);

}
