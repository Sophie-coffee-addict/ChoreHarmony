package application;

import java.util.ArrayList;

public class AccountManagement {
	private Database db;

	public AccountManagement() {
		this.db = Database.getInstance();
	}

	public void createHouseholdAccount(int id, String name, Household household) {
		household = new Household(id, name);
		db.addHousehold(household);
	}

	public void addMember(String name, String emailAddress, String password, String awayMode, Boolean isCreator,
			ArrayList<Chore> choreList, User teamMember) {
		teamMember = new User(name, emailAddress, password, awayMode, isCreator, choreList);
		db.addUser(teamMember);
	}

	public void addChore(String name, int frequency, int startTime, boolean teamTask, ArrayList<User> teamMemberList,
			Chore chore) {
		chore = new Chore(name, frequency, startTime, teamTask, teamMemberList);
		db.addChore(chore);
	}

	public void deleteAccount() {

	}

	public void deleteMember() {

	}

	public void deleteChore() {

	}

}
