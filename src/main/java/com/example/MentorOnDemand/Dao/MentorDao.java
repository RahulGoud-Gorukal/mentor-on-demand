package com.example.MentorOnDemand.Dao;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.MentorOnDemand.Model.Mentor;
import com.example.MentorOnDemand.Model.ProposalRequest;

public interface MentorDao extends JpaRepository<Mentor, Integer> {
	
	@Query("Select m from Mentor m where m.email =:username and m.password = :password")
	Mentor loginMentor(@Param("username") String username , @Param("password") String password);

	@Query("Select m from Mentor m where m.technology=:skill")
	Mentor searchMentor(@Param("skill") String skill);

	public List<Mentor> findBytechnology(String skill);
	
	@Query("Select m.mentorId from Mentor m where m.email =:userName")
	public int findByEmail(@Param("userName") String username);
	
	@Query("Select m from Mentor m where m.mentorId =:mentorId")
	Mentor findByMentorId(@Param("mentorId") int mentorId);
	

}
