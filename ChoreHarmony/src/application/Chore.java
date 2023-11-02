package application;

import java.util.ArrayList;

public class Chore {

	private String name;
	private int frequency;
	private int startTime;
	private int endTime;
	private boolean teamTask;
	private ArrayList<User> teamMemberList;
	private int EffortOfChore;
	private int selfSatisfactionOfTask;

	public Chore(String name) {
		super();
		this.name = name;
	}

	public Chore(String name, int frequency, int startTime, boolean teamTask) {
		super();
		this.name = name;
		this.frequency = frequency;
		this.startTime = startTime;
		this.teamTask = teamTask;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	public int getStartTime() {
		return startTime;
	}

	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

//	public int getEndTime() {
//		return endTime;
//	}
//
//	public void setEndTime(int endTime) {
//		this.endTime = endTime;
//	}
//
	public boolean isTeamTask() {
		return teamTask;
	}

	public void setTeamTask(boolean teamTask) {
		this.teamTask = teamTask;
	}
//
//	public int getEffortOfChore() {
//		return EffortOfChore;
//	}
//
//	public void setEffortOfChore(int effortOfChore) {
//		EffortOfChore = effortOfChore;
//	}
//
//	public int getSelfSatisfactionOfTask() {
//		return selfSatisfactionOfTask;
//	}
//
//	public void setSelfSatisfactionOfTask(int selfSatisfactionOfTask) {
//		this.selfSatisfactionOfTask = selfSatisfactionOfTask;
//	}

	public void addTeamMember(User teamMember) {
		teamMemberList.add(teamMember);
	}

	public void deleteTeamMember(User teamMember) {
		teamMemberList.remove(teamMemberList.indexOf(teamMember));
	}

}
