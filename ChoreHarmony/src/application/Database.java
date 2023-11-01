package application;

import java.util.ArrayList;

public class Database {
	
	private ArrayList<String> chores = new ArrayList<>();
	private ArrayList<String> users = new ArrayList<>();
	
	
	
	
	public Database() {
		super();
	}


	public Database(ArrayList<String> chores, ArrayList<String> users) {
		super();
		this.chores = chores;
		this.users = users;
	}


	public void loadData() {
		
		
	}
	
	
	public void saveData() {
		
		
		
	}


	public ArrayList<String> getChores() {
		return chores;
	}


	public void setChores(ArrayList<String> chores) {
		this.chores = chores;
	}


	public ArrayList<String> getUsers() {
		return users;
	}


	public void setUsers(ArrayList<String> users) {
		this.users = users;
	}
	
	

}
