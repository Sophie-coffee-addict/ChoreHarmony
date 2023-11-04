package application;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AddAChorePage extends Pane{
	AccountManagement accountManagement = new  AccountManagement();
	
	ObservableList<String> choreOptions = 
		    FXCollections.observableArrayList(
		        "Mow lawn",
		        "Do dishes",
		        "Feed cats",
		        "Do laundry"
		    );
	
		final ComboBox choreBox = new ComboBox(choreOptions);
		
		ObservableList<String> frequencyOptions = 
			    FXCollections.observableArrayList(
			        "Daily",
			        "Weekly",
			        "Monthly",
			        "Quarterly",
			        "Yearly"
			    );
		
			final ComboBox frequencyBox = new ComboBox(frequencyOptions);
			
			ObservableList<String> timeOptions = 
				    FXCollections.observableArrayList(
				        "06:00",
				        "06:30",
				        "07:00",
				        "07:30",
				        "08:00"
				    );
			
				final ComboBox timeBox = new ComboBox(timeOptions);
		
			
				 Label taskTypeLabel = new Label("Task Type:");

			        ObservableList<String> taskTypes = FXCollections.observableArrayList("Team Task", "Individual Task");
			        ComboBox<String> taskTypeComboBox = new ComboBox<>(taskTypes);

					
					ObservableList<String> TeamMemberOptions = 
						    FXCollections.observableArrayList(
						        "Sophie",
						        "Jia",
						        "Richord",
						        "Jay",
						        "Emma"
						    );
					
					final ComboBox teamBox = new ComboBox(TeamMemberOptions);
				
			
				
			        
			        
				
		Text heading = new Text("Choose My Chore");
		Text chooseChoreHint = new Text("Choose my chore: ");
		Text frequencyHint = new Text("What frequency: ");
		Text timingHint = new Text("What time is it due: ");
		Text teamHint = new Text("Choose team mumbers: ");
		
		HBox frequency = new HBox(frequencyHint, frequencyBox);
		HBox PickChore = new HBox(chooseChoreHint, choreBox);
		HBox PickTime = new HBox(timingHint, timeBox);
		HBox teamMember = new HBox(teamHint, teamBox);
		Button saveButton = new Button("Save");
		
		VBox addChoreLayout = new VBox(heading, PickChore, frequency, PickTime,taskTypeLabel,taskTypeComboBox,teamMember,saveButton);
	
	
	public AddAChorePage() {
		this.getChildren().add(addChoreLayout);
		this.setStyle("-fx-background-color: #FAC8CD");
		this.heading.getStyleClass().add("heading");
		this.chooseChoreHint.getStyleClass().add("hinttext");
		this.frequencyHint.getStyleClass().add("hinttext");
		this.timingHint.getStyleClass().add("hinttext");
		this.addChoreLayout.setSpacing(10);
		
		
		this.saveButton.setOnAction(e -> {
			String ChoreName= (String) choreBox.getValue();
			String Frequency = (String) frequencyBox.getValue();
			String startTime = (String) timeBox.getValue();
			String  householdname = accountManagement.getHouseholdName();
			System.out.println(householdname);
	      accountManagement.selectedChore(householdname, ChoreName,Frequency,startTime,true);
			ShowChoreListPage();
	    });
		
	}
	 private void  ShowChoreListPage() {
		   Stage newstage = new Stage();
		   newstage.setTitle("Add A Chore");
		   ShowChoreListPage choreListPage = new ShowChoreListPage();
		   choreListPage.start(newstage);
	   }
}
