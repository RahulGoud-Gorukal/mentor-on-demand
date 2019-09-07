package com.example.MentorOnDemand.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="skill")
public class Skill {

	@Column(name="skillId")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long skillId;
	@Column(name="skill_name")
	private String skillName;
	@Column(name="fees")
	private double fees;
	public long getSkillId() {
		return skillId;
	}
	public void setSkillId(long skillId) {
		this.skillId = skillId;
	}
	public String getSkillName() {
		return skillName;
	}
	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}
	public double getFees() {
		return fees;
	}
	public void setFees(double fees) {
		this.fees = fees;
	}
	@Override
	public String toString() {
		return "Skill [skillId=" + skillId + ", skillName=" + skillName + ", fees=" + fees + "]";
	}
	public Skill() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Skill(long skillId, String skillName, double fees) {
		super();
		this.skillId = skillId;
		this.skillName = skillName;
		this.fees = fees;
	}
	
}
