package application;

import java.util.ArrayList;

public class Database {
	
	private ArrayList<Chore> chores = new ArrayList<>();
	private ArrayList<User> users = new ArrayList<>();
	
	public Database(ArrayList<Chore> chores, ArrayList<User> users) {
		super();
		this.chores = chores;
		this.users = users;
	}
	
	public Database() {
		super();
	}
	public ArrayList<Chore> getChores() {
		return chores;
	}
	public void setChores(ArrayList<Chore> chores) {
		this.chores = chores;
	}
	public ArrayList<User> getUsers() {
		return users;
	}
	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}
	
	
	

	

}
