package application;

import java.util.ArrayList;

public class User {
	
	private String name;
	private String emailAddress;
	private String password;
	private ArrayList<String> choreList;
	private String awayMode;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}
	
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public ArrayList<String> getChoreList() {
		return choreList;
	}
	
	public void setChoreList(ArrayList<String> choreList) {
		this.choreList = choreList;
	}
	
	public String getAwayMode() {
		return awayMode;
	}
	
	public void setAwayMode(String awayMode) {
		this.awayMode = awayMode;
	}
	
	public User(String name, String emailAddress, String password) {
		super();
		this.name = name;
		this.emailAddress = emailAddress;
		this.password = password;
	}
	
	
	
	
	

}
