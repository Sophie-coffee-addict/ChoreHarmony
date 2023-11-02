package application;

import java.io.Serializable;

public class Household implements Serializable {

	private int id;
	private String name;

	public Household(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
