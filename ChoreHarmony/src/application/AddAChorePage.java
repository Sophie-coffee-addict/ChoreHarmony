package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class AddAChorePage extends BorderPane {
	String email;
	String householdName;
//	Chore chore = new Chore("", "", "", false);
	AccountManagement accountManagement = new AccountManagement();

	ObservableList<String> choreOptions = FXCollections.observableArrayList("Mow lawn", "Wash dishes", "Feed cats",
			"Laundry");
	final ComboBox choreBox = new ComboBox(choreOptions);

	ObservableList<String> frequencyOptions = FXCollections.observableArrayList("Daily", "Weekly", "Monthly",
			"Quarterly", "Yearly");
	final ComboBox frequencyBox = new ComboBox(frequencyOptions);

	ObservableList<String> timeOptions = FXCollections.observableArrayList("06:00", "06:30", "07:00", "07:30", "08:00");
	final ComboBox timeBox = new ComboBox(timeOptions);

//	ObservableList<String> taskTypes = FXCollections.observableArrayList("Team Task", "Individual Task");
//	final ComboBox<String> taskTypeBox = new ComboBox<>(taskTypes);

	CheckBox isTeamTaskCheckBox = new CheckBox("Yes");
	CheckBox notTeamTaskCheckBox = new CheckBox("No");
	HBox checkBox = new HBox(isTeamTaskCheckBox, notTeamTaskCheckBox);

	ObservableList<String> TeamMemberOptions = FXCollections.observableArrayList("Sophie", "Jia", "Richard", "Jay",
			"Emma");
	final ComboBox teamBox = new ComboBox(TeamMemberOptions);

	BorderPane addChoreLayout = new BorderPane();
	GridPane addChore = new GridPane();

	Label heading = new Label("Choose A Chore");
	Label chooseChoreHint = new Label("Chores: ");
	Label frequencyHint = new Label("Frequency: ");
	Label timingHint = new Label("Start time: ");
	Label taskTypeHint = new Label("Team work:");
	Label teamHint = new Label("Team members: ");

//	HBox frequency = new HBox(frequencyHint, frequencyBox);
//	HBox PickChore = new HBox(chooseChoreHint, choreBox);
//	HBox PickTime = new HBox(timingHint, timeBox);
//	HBox teamMember = new HBox(teamHint, teamBox);
	Button addButton = new Button("Add");

//	VBox addChoreLayout = new VBox(heading, PickChore, frequency, PickTime, taskTypeLabel, taskTypeComboBox, teamMember,
//			saveButton);

	public AddAChorePage(String householdName, String email) {
		this.householdName = householdName;
		this.email = email;

//		this.getChildren().add(addChoreLayout);
		teamHint.setDisable(true);
		teamBox.setDisable(true);

		this.setStyle("-fx-background-color: #FAC8CD");

		this.heading.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");
		this.heading.setMaxWidth(400);
		this.heading.setAlignment(Pos.CENTER);
		BorderPane.setMargin(heading, new javafx.geometry.Insets(40, 0, 0, 0));
		this.setTop(heading);

		this.addChore.setPadding(new Insets(15, 50, 20, 50));
		this.addChore.setVgap(20);
		this.addChore.setHgap(25);

		this.chooseChoreHint.setStyle("-fx-font-weight: bold;-fx-font-size: 15px");
		this.frequencyHint.setStyle("-fx-font-weight: bold;-fx-font-size: 15px");
		this.timingHint.setStyle("-fx-font-weight: bold;-fx-font-size: 15px");
		this.taskTypeHint.setStyle("-fx-font-weight: bold;-fx-font-size: 15px");
		this.teamHint.setStyle("-fx-font-weight: bold;-fx-font-size: 15px");
		this.choreBox.setPrefWidth(155);
		this.frequencyBox.setPrefWidth(155);
		this.timeBox.setPrefWidth(155);
		this.checkBox.setSpacing(35);
		this.teamBox.setPrefWidth(155);

//		this.chooseChoreHint.getStyleClass().add("hinttext");
//		this.frequencyHint.getStyleClass().add("hinttext");
//		this.timingHint.getStyleClass().add("hinttext");
//		this.addChoreLayout.setSpacing(10);

		this.addChore.add(chooseChoreHint, 0, 3);
		this.addChore.add(choreBox, 1, 3);
		this.addChore.add(frequencyHint, 0, 4);
		this.addChore.add(frequencyBox, 1, 4);
		this.addChore.add(timingHint, 0, 5);
		this.addChore.add(timeBox, 1, 5);
		this.addChore.add(taskTypeHint, 0, 6);
		this.addChore.add(checkBox, 1, 6);
		this.addChore.add(teamHint, 0, 7);
		this.addChore.add(teamBox, 1, 7);
//		this.addChore.add(addButton, 1, 9);

		this.setCenter(addChore);

		this.addButton.setPrefSize(300, 35);
		this.addButton.setStyle("-fx-font-weight: bold;-fx-text-fill: #ffffff; -fx-background-color: #6E51E4;");
		this.addButton.setFont(new Font(15));
		BorderPane.setMargin(addButton, new javafx.geometry.Insets(0, 0, 310, 50));
		this.setBottom(addButton);

		isTeamTaskCheckBox.setOnAction(event -> {
			if (isTeamTaskCheckBox.isSelected()) {
				teamHint.setDisable(false);
				teamBox.setDisable(false);
				notTeamTaskCheckBox.setSelected(false);
			} else {
				teamHint.setDisable(true);
				teamBox.setDisable(true);
			}
		});

		notTeamTaskCheckBox.setOnAction(event -> {
			if (notTeamTaskCheckBox.isSelected()) {
				teamHint.setDisable(true);
				teamBox.setDisable(true);
				isTeamTaskCheckBox.setSelected(false);
			}
		});

		this.addButton.setOnAction(e -> {
			String ChoreName = (String) choreBox.getValue();
			String Frequency = (String) frequencyBox.getValue();
			String startTime = (String) timeBox.getValue();
//			String householdname = AccountManagement.getHouseholdName();
			Boolean teamTask = false;
			if (isTeamTaskCheckBox.isSelected()) {
				teamTask = true;
			}
			System.out.println(householdName);
			accountManagement.selectedChore(householdName, email, ChoreName, Frequency, startTime, teamTask);
			openShowChoreListPage();
		});
	}

	private void openShowChoreListPage() {
		Stage newstage = new Stage();
		newstage.setTitle("Chore List");
		ShowChoreListPage choreListPage = new ShowChoreListPage(householdName, email);
//		choreListPage.start(newstage);
		Scene scene = new Scene(choreListPage, 400, 700);
		newstage.setScene(scene);
		newstage.show();
	}
}
