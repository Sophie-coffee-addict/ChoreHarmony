package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class AddAChorePage extends Pane{
	
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
		
		Text heading = new Text("Choose My Chore");
		Text chooseChoreHint = new Text("Choose my chore: ");
		Text frequencyHint = new Text("What frequency: ");
		Text timingHint = new Text("What time is it due: ");
		
		HBox frequency = new HBox(frequencyHint, frequencyBox);
		HBox PickChore = new HBox(chooseChoreHint, choreBox);
		HBox PickTime = new HBox(timingHint, timeBox);
		
		Button saveButton = new Button("Save");
		
		VBox addChoreLayout = new VBox(heading, PickChore, frequency, PickTime, saveButton);
	
	
	public AddAChorePage() {
		this.getChildren().add(addChoreLayout);
		this.setStyle("-fx-background-color: #FAC8CD");
		this.heading.getStyleClass().add("heading");
		this.chooseChoreHint.getStyleClass().add("hinttext");
		this.frequencyHint.getStyleClass().add("hinttext");
		this.timingHint.getStyleClass().add("hinttext");
		this.addChoreLayout.setSpacing(10);
	}

}
