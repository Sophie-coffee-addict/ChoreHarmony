package application;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Database implements Serializable{
	
	
	private static final long serialVersionUID = 1L;

	private static Database single_instance = null;

//	private ArrayList<Chore> chores = new ArrayList<>();
//	private ArrayList<User> users = new ArrayList<>();
	private ArrayList<Household> households = new ArrayList<>();

//	public Database(ArrayList<Chore> chores, ArrayList<User> users) {
//		super();
//		this.chores = chores;
//		this.users = users;
//	}

	public Database(ArrayList<Household> households) {
		super();
		this.households = households;
	}

	public Database() {
		super();
	}
//
//	public ArrayList<Chore> getChores() {
//		return chores;
//	}
//
//	public void setChores(ArrayList<Chore> chores) {
//		this.chores = chores;
//	}
//
//	public ArrayList<User> getUsers() {
//		return users;
//	}
//
//	public void setUsers(ArrayList<User> users) {
//		this.users = users;
//		
//	}	

//	public ArrayList<Chore> getChores() {
//		return chores;
//	}
//
//	public void setChores(ArrayList<Chore> chores) {
//		this.chores = chores;
//	}
//
//	public ArrayList<User> getUsers() {
//		return users;
//	}
//
//	public void setUsers(ArrayList<User> users) {
//		this.users = users;
//		
//	}
	
	
	 public ArrayList<Household> getHouseholds() {
		return households;
	}

	public void setHouseholds(ArrayList<Household> households) {
		this.households = households;
	}

	public void addHousehold(Household household) {
		households.add(household);
	}

	public static synchronized Database getInstance() 
	    { 
	        if (single_instance == null) 
	            single_instance =  loadData();  // load your database eg: loadDb(String)
	  
	        return single_instance; 
	    } 
	 
//	 public void addChore(Chore chore) {
//		 chores.add(chore);
//	 }
//	 
//	 public void addUser(User user) {
//		 users.add(user);
//	 }
	 
	 public void saveData() throws IOException {
//		 file = new File("householdDataBase");
		 FileOutputStream fileOutputStream
	      = new FileOutputStream("householdDataBase.db");
	    ObjectOutputStream objectOutputStream 
	      = new ObjectOutputStream(fileOutputStream);
	    objectOutputStream.writeObject(this);
	    objectOutputStream.flush();
	    objectOutputStream.close();
	 }
	 
	 public static Database loadData() {
		 FileInputStream fileInputStream;
		try {
			fileInputStream = new FileInputStream("householdDataBase.db");
	    ObjectInputStream objectInputStream;

			objectInputStream = new ObjectInputStream(fileInputStream);
		    Database db = (Database) objectInputStream.readObject();
			
		    objectInputStream.close();
		    return db;
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
			return new Database();
		}

	}
}
