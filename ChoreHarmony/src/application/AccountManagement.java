package application;

public class AccountManagement {
	private Database db;

	public AccountManagement() {
		this.db = Database.getInstance();
	}

	// create household account
	public void createHouseholdAccount(String name, Household household) {
		household = new Household(name);
		db.addHousehold(household);
	}

	// login
	public boolean login(String email, String password) {
		boolean exist = false;
		for (User item : db.getUsers()) {
			if (item.getEmail().equalsIgnoreCase(email) && item.getPassword().equalsIgnoreCase(password)) {
				exist = true;
				break;
			}
		}
		if (!exist) {
			return true;
		} else {
			return false;
		}
	}

	// Choose/create a chore
//	public Chore chooseChore(String email, String ChoreName, int frequency, int startTime, boolean teamTask) {
//		Chore chore = new Chore(ChoreName, frequency, startTime, false);
//		for (User item : db.getUsers()) {
//			if (item.getEmail().equalsIgnoreCase(email)) {
//				item.addChore(chore);
////				chore.addTeamMember(item);
//			}
//		}
//		return chore;
//	}

	public Chore choosedChose(String email, String ChoreName, int frequency, int startTime, boolean teamTask,
			User teamMember) {
		Chore chore = new Chore(ChoreName, frequency, startTime, false);
		return chore;
	}

//	// creator deletes account
//	public void deleteAccount(int id) {
//		for (Household item : db.getHouseholds()) {
//			if (item.getId() == id) {
//				db.getHouseholds().remove(db.getHouseholds().indexOf(item));
//			}
//		}
//	}
//
//	// creator creates team member
//	public void createMember(String name, String email, String password, String awayMode, Boolean isCreator,
//			ArrayList<Chore> choreList, User teamMember) {
//		for (User item : db.getUsers()) {
//			if (!item.getEmail().equalsIgnoreCase(email)) {
//				teamMember = new User(name, email, password, awayMode, isCreator, choreList);
//				db.addUser(teamMember);
//			}
//		}
//	}
//
//	// creator deletes team member
//	public void deleteTeamMember(String email) {
//		for (User item : db.getUsers()) {
//			if (item.getEmail().equalsIgnoreCase(email)) {
//				db.getUsers().remove(db.getUsers().indexOf(item));
//			}
//		}
//	}
//
//	// creator creates chore
//	public void createChore(String name, int frequency, int startTime, boolean teamTask, ArrayList<User> teamMemberList,
//			Chore chore) {
//		for (Chore item : db.getChores()) {
//			if (!item.getName().equalsIgnoreCase(name)) {
//				chore = new Chore(name, frequency, startTime, teamTask, teamMemberList);
//				db.addChore(chore);
//			}
////			else {"This chore already exists!"}
////		}
//		}
//	}
//
//	// creator deletes chore
//	public void deleteChore(String name) {
//		for (Chore item : db.getChores()) {
//			if (item.getName().equalsIgnoreCase(name)) {
//				db.getChores().remove(db.getChores().indexOf(item));
//			}
//		}
//	}
//
//	// teamMember adds chore for themselves
//	public void addChore(String choreName, User teamMember) {
//		for (Chore item : db.getChores()) {
//			if (item.getName().equalsIgnoreCase(choreName)) {
//				teamMember.addChore(item);
//				item.addTeamMember(teamMember);
//			}
//		}
//	}
//
//	// teamMember removes chore for themselves
//	public void removeChore(String choreName, User teamMember) {
//		for (Chore item : db.getChores()) {
//			if (item.getName().equalsIgnoreCase(choreName)) {
//				teamMember.deleteChore(choreName);
//				item.deleteTeamMember(teamMember.getEmail());
//			}
//		}
//	}
//
//	// teamMember register themselves as a team member
//	public void registerAsTeamMember(String name, String email, String password, String awayMode, Boolean isCreator,
//			ArrayList<Chore> choreList, User teamMember) {
//		boolean exist = false;
//		for (User item : db.getUsers()) {
//			if (item.getEmail().equalsIgnoreCase(email)) {
//				exist = true;
//				break;
//			}
//		}
//		if (!exist) {
//			teamMember = new User(name, email, password, awayMode, isCreator, choreList);
//			db.addUser(teamMember);
//		}
////		else {
////			""
////		}
//
//	}

}
