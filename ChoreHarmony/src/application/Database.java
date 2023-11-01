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
	
	 public static synchronized Database getInstance() 
	    { 
	        if (single_instance == null) 
	            single_instance =  loadData();  // load your database eg: loadDb(String)
	  
	        return single_instance; 
	    } 
	 
	 public void addChore(Chore chore) {
		 chores.add(chore);
	 }
	 
	 public void addUser(User user) {
		 users.add(user);
	 }
	 
	 public void saveData() throws IOException {
		 FileOutputStream fileOutputStream
	      = new FileOutputStream("yourfile.db");
	    ObjectOutputStream objectOutputStream 
	      = new ObjectOutputStream(fileOutputStream);
	    objectOutputStream.writeObject(this);
	    objectOutputStream.flush();
	    objectOutputStream.close();
	 }
	 
	 public static Database loadData() {
		 FileInputStream fileInputStream;
		try {
			fileInputStream = new FileInputStream("yourfile.db");
	    ObjectInputStream objectInputStream;

			objectInputStream = new ObjectInputStream(fileInputStream);
		    Database db = (Database) objectInputStream.readObject();
		    objectInputStream.close();
		    return db;
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;

	 }
}
