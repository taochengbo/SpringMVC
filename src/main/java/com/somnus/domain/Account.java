package com.somnus.domain;

import java.io.Serializable;

public class Account implements Serializable{
	private static final long serialVersionUID = -4835224895952766346L;
	private String username;
	private String password;
	
	public void setUsername(String username){
		this.username=username;
	}
	public void setPassword(String password){
		this.password=password;
	}
	
	public String getUsername(){
		return this.username;
	}
	public String getPassword(){
		return this.password;
	}
}
