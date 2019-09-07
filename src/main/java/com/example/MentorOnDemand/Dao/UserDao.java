package com.example.MentorOnDemand.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.MentorOnDemand.Model.User;

public interface UserDao  extends JpaRepository<User, Integer> {
	@Query("Select u from User u where u.email =:username and u.password = :password")
	User loginUser(@Param("username") String username , @Param("password") String password);

	@Query("Select u.username from User u where u.email =:email")
	public String findByUsername(@Param("email") String email);
	
	@Query("Select u.userId from User u where u.username =:username")
	public int findByUserId(@Param("username") String username);
	
	@Query("Select u.userId from User u where u.username =:username")
	public int findByEmail(@Param("username") String username);
	
	
}
