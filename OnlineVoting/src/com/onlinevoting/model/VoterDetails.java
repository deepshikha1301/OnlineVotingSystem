package com.onlinevoting.model;



import javax.persistence.*;

@Entity
@Table(name = "VOTERDATA")
public class VoterDetails {
	
	//private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "voterID")
	String voterID;
	
	@Column(name = "fullName")
	String fullName;
	
	@Column(name = "Email")
	String emailID;
	
	@Column(name = "password")
	String passWord;
	
	public VoterDetails() {}
	
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmailID() {
		return emailID;
	}
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
	public String getVoterID() {
		return voterID;
	}
	public void setVoterID(String voterID) {
		this.voterID = voterID;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

}
