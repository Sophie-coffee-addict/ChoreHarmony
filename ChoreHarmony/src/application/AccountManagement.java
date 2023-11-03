package application;

public class AccountManagement {
	private Database database;

	public AccountManagement() {
		this.database = Database.getInstance();
	}

	// create household account and add it into households arrayList
	public void createHouseholdAccount(String householdName, String creatorName, String email, String password) {
		Household household = new Household(householdName);
		database.addHousehold(household);

		User creator = new User(creatorName, email, password, true);
		household.addUser(creator);
	}

	// login
	public boolean userExist(String householdName, String email, String password) {
		boolean exist = false;
		for (User teamMember : getCurrentHousehold(householdName).getUsers()) {
			if (teamMember.getEmail().equalsIgnoreCase(email) && teamMember.getPassword().equalsIgnoreCase(password)) {
				exist = true;
				break;
			}
		}
		if (exist) {
			return true;
		} else {
			return false;// email or password is wrong or email does not exist
		}
	}

	// Choose a chore for a team member
	public Chore selectedChore(String householdName, String email, String ChoreName, String frequency, String startTime,
			boolean teamTask) {
		Chore chore = new Chore(ChoreName, frequency, startTime, teamTask);
		for (User teamMember : getCurrentHousehold(householdName).getUsers()) {
			if (teamMember.getEmail().equalsIgnoreCase(email)) {
				teamMember.addChore(chore); // add this chore into the chore list of this user
				chore.addTeamMember(teamMember); // add this user into the team member list of this chore
				getCurrentHousehold(householdName).addChore(chore);// add this chore into chores list of this household
				return chore;
			}
		}
		return null;
	}

	// get current household
	public Household getCurrentHousehold(String householdName) {
		for (Household household : database.getHouseholds()) {
			if (household.getName().equalsIgnoreCase(householdName)) {
				return household;
			}
		}
		return null;
	}

}
