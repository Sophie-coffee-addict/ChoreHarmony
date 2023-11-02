package application;

import java.util.ArrayList;

public class User {

	private String name;
	private String email;
	private String password;
	private ArrayList<Chore> choreList;
	private String awayMode;
	private Boolean isCreator;

	public User(String name, String email, String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

//	public ArrayList<Chore> getChoreList() {
//		return choreList;
//	}
//
//	public void setChoreList(ArrayList<Chore> choreList) {
//		this.choreList = choreList;
//	}
//
//	public String getAwayMode() {
//		return awayMode;
//	}
//
//	public void setAwayMode(String awayMode) {
//		this.awayMode = awayMode;
//	}

	public void addChore(Chore chore) {
		choreList.add(chore);
	}

	public void deleteChore(String Name) {
		for (Chore item : choreList)
			if (item.getName().equalsIgnoreCase(Name))
				choreList.remove(choreList.indexOf(item));
	}

}
