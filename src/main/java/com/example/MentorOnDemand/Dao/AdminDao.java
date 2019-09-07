package com.example.MentorOnDemand.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.MentorOnDemand.Model.Admin;
import com.example.MentorOnDemand.Model.Mentor;

public interface AdminDao extends JpaRepository<Admin, Integer> {
	@Query("Select a from Admin a where a.email =:username and a.password = :password")
	Admin loginAdmin(@Param("username") String username , @Param("password") String password);

}
