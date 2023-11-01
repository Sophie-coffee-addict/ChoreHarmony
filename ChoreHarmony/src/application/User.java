package application;

import java.util.ArrayList;

public class User {

	private String name;
	private String emailAddress;
	private String password;
	private ArrayList<Chore> choreList;
	private String awayMode;
	private Boolean isCreator;

	public User(String name, String emailAddress, String password, String awayMode, Boolean isCreator,
			ArrayList<Chore> choreList) {
		super();
		this.name = name;
		this.emailAddress = emailAddress;
		this.password = password;
		this.choreList = new ArrayList<>();
		this.awayMode = awayMode;
		this.isCreator = isCreator;
	}

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

	public ArrayList<Chore> getChoreList() {
		return choreList;
	}

	public void setChoreList(ArrayList<Chore> choreList) {
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

	public void addChore(Chore chore) {
		choreList.add(chore);
	}

}
