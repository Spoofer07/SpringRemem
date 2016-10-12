package com.mihai.DT;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class LoginDetails {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private int userid;
	private String user;
	private String pass;
	
	
	
	/*public LoginDetails(String user, String pass) {
		super();
		this.user = user;
		this.pass = pass;
	}*/
	

	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}

	/*@Override
	public String toString() {
		return "LoginDetails [user=" + user + ", pass=" + pass + "]";
	}*/
	
	
	
	
}
