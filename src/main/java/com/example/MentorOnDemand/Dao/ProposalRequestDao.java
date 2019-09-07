package com.example.MentorOnDemand.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.MentorOnDemand.Model.Mentor;
import com.example.MentorOnDemand.Model.ProposalRequest;

public interface ProposalRequestDao extends JpaRepository<ProposalRequest, Integer>{

	@Query("Select pr from ProposalRequest pr where pr.mentorId =:mentorId")
	List<ProposalRequest> mentorNotify(@Param("mentorId") int mentorId);


   @Query("Select pr from ProposalRequest pr where pr.proposalId =:proposalId")
   ProposalRequest acceptanceStatus(@Param("proposalId") int proposalId);
   
   @Query("Select pr from ProposalRequest pr where pr.traineeName =:userName and pr.proposalStatus=:status")
	List<ProposalRequest> userNotify(@Param("userName") String userName,@Param("status") String status);
   
   @Query("Select pr from ProposalRequest pr where pr.traineeName =:userName")
  	List<ProposalRequest> status(@Param("userName") String userName);
}