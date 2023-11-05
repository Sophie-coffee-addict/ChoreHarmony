package application;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ShowChoreListPage extends BorderPane {
	String email;
	String householdName;
	AccountManagement accountManagement = new AccountManagement();

	BorderPane root = new BorderPane();
	Label titleLabel = new Label("Chore List");
	TableView<Chore> tableView = new TableView<>();
	Button addChoreButton = new Button("Add a chore");

	public ShowChoreListPage(String householdName, String email) {
		this.householdName = householdName;
		this.email = email;

		// set background color
		this.setStyle("-fx-background-color: #FAC8CD");

		// set heading
		this.titleLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");
		this.titleLabel.setMaxWidth(400);
		this.titleLabel.setAlignment(Pos.CENTER);
		BorderPane.setMargin(titleLabel, new javafx.geometry.Insets(40, 0, 0, 0));
		this.setTop(titleLabel);

		// set add a chore button
		this.addChoreButton.setPrefSize(120, 35);
		this.addChoreButton.setStyle("-fx-font-weight: bold;-fx-text-fill: #ffffff; -fx-background-color: #6E51E4;");
		this.addChoreButton.setFont(new Font(15));
		BorderPane.setMargin(addChoreButton, new javafx.geometry.Insets(0, 0, 50, 265));
		this.setBottom(addChoreButton);

		// set tableView
		TableColumn<Chore, String> choreNameCol = new TableColumn<>("Chore");
		choreNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

		TableColumn<Chore, String> frequencyCol = new TableColumn<>("Frequency");
		frequencyCol.setCellValueFactory(new PropertyValueFactory<>("frequency"));

		TableColumn<Chore, Integer> startTimeCol = new TableColumn<>("Start time");
		startTimeCol.setCellValueFactory(new PropertyValueFactory<>("startTime"));

		TableColumn<Chore, String> teamWorkCol = new TableColumn<>("Team task");
		teamWorkCol.setCellValueFactory(cellData -> {
			Boolean teamTask = cellData.getValue().isTeamTask();
			return new SimpleStringProperty(teamTask ? "Yes" : "No");
		});

		// Divide the width into 3 parts
		choreNameCol.prefWidthProperty().bind(tableView.widthProperty().divide(4));
		frequencyCol.prefWidthProperty().bind(tableView.widthProperty().divide(4));
		startTimeCol.prefWidthProperty().bind(tableView.widthProperty().divide(4));
		teamWorkCol.prefWidthProperty().bind(tableView.widthProperty().divide(4));

		// Add columns to the TableView
		tableView.getColumns().add(choreNameCol);
		tableView.getColumns().add(frequencyCol);
		tableView.getColumns().add(startTimeCol);
		tableView.getColumns().add(teamWorkCol);

		BorderPane.setMargin(tableView, new javafx.geometry.Insets(50, 25, 25, 25));
		this.setCenter(tableView);

		ObservableList<Chore> choreList = FXCollections
				.observableArrayList(accountManagement.getChoreListOfAUser(householdName, email));
		tableView.setItems(choreList);

		// action on add a chore button
		this.addChoreButton.setOnAction(e -> {
			openAddAChorePage();
		});

	}

	private void openAddAChorePage() {
		Stage newstage = new Stage();
		newstage.setTitle("Add A Chore");
		AddAChorePage AddAChorePage = new AddAChorePage(householdName, email);

		Scene scene = new Scene(AddAChorePage, 400, 700);
		newstage.setScene(scene);
		newstage.show();
	}

}
