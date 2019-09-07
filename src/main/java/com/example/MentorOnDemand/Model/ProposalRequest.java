package com.example.MentorOnDemand.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="proposal_request")
public class ProposalRequest {
	@Column(name="proposal_Id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int proposalId;
	@Column(name="mentor_name")
	private String mentorName;
	@Column(name="trainee_name")
	private String traineeName;
	@Column(name="mentor_Id")
	private int mentorId;
	@Column(name="trainee_Id")
	private int traineeId;
	@Column(name="technology")
	private String technology;
	@Column(name="proposal_status")
	private String proposalStatus;
	public int getProposalId() {
		return proposalId;
	}
	public void setProposalId(int proposalId) {
		this.proposalId = proposalId;
	}
	public String getMentorName() {
		return mentorName;
	}
	public void setMentorName(String mentorName) {
		this.mentorName = mentorName;
	}
	public String getTraineeName() {
		return traineeName;
	}
	public void setTraineeName(String traineeName) {
		this.traineeName = traineeName;
	}
	public int getMentorId() {
		return mentorId;
	}
	public void setMentorId(int mentorId) {
		this.mentorId = mentorId;
	}
	public int getTraineeId() {
		return traineeId;
	}
	public void setTraineeId(int traineeId) {
		this.traineeId = traineeId;
	}
	public String getTechnology() {
		return technology;
	}
	public void setTechnology(String technology) {
		this.technology = technology;
	}
	public String getProposalStatus() {
		return proposalStatus;
	}
	public void setProposalStatus(String proposalStatus) {
		this.proposalStatus = proposalStatus;
	}
	@Override
	public String toString() {
		return "ProposalRequest [proposalId=" + proposalId + ", mentorName=" + mentorName + ", traineeName="
				+ traineeName + ", mentorId=" + mentorId + ", traineeId=" + traineeId + ", technology=" + technology
				+ ", proposalStatus=" + proposalStatus + "]";
	}
	public ProposalRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProposalRequest(int proposalId, String mentorName, String traineeName, int mentorId, int traineeId,
			String technology, String proposalStatus) {
		super();
		this.proposalId = proposalId;
		this.mentorName = mentorName;
		this.traineeName = traineeName;
		this.mentorId = mentorId;
		this.traineeId = traineeId;
		this.technology = technology;
		this.proposalStatus = proposalStatus;
	}
	
	

}
