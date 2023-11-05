package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class LoginPage extends StackPane {
	String email;
	String householdName;
	AccountManagement accountManagement = new AccountManagement();

	StackPane loginLayout = new StackPane();
	GridPane loginGrid = new GridPane();

	Label heading = new Label("Login to Your Account");

//	Text householdName = new Text("household Name:");
//	Text emailHint = new Text("Email: ");
//	Text passwordHint = new Text("Password: ");

	TextField householdNameField = new TextField();
	TextField emailField = new TextField();
	PasswordField passwordField = new PasswordField();

	Button loginButton = new Button("Log In");

	// error page of login
	StackPane errorPane = new StackPane();
	Label errorLabel = new Label("");
	Button ok = new Button("OK");

//	HBox household = new HBox(householdName, householdName);
//	HBox email = new HBox(emailHint, emailEntry);
//	HBox password = new HBox(passwordHint, passwordEntry);

//	VBox loginLayout = new VBox(heading, household, email, password, loginButton);

	public LoginPage() {
		this.errorPane.getChildren().addAll(errorLabel, ok);
		this.getChildren().addAll(loginGrid, errorPane);
		errorPane.setVisible(false);
		errorPane.setDisable(true);

		this.setStyle("-fx-background-color: #FAC8CD");

		this.loginGrid.setPadding(new Insets(35, 30, 20, 30));
		ColumnConstraints col1 = new ColumnConstraints(350);
		this.loginGrid.getColumnConstraints().add(col1);
		this.loginGrid.setVgap(15);

//		this.heading.getStyleClass().add("heading");
		this.heading.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");
		this.heading.setMaxWidth(400);
		this.heading.setAlignment(Pos.CENTER);

		this.loginButton.setPrefSize(350, 35);
		this.loginButton.setStyle("-fx-font-weight: bold;-fx-text-fill: #ffffff; -fx-background-color: #6E51E4;");
		this.loginButton.setFont(new Font(15));
//		this.loginButton.getStyleClass().add("button");
//		this.loginButton.setTextFill(Color.web("#ffffff"));

		this.householdNameField.setStyle("-fx-font-size: 14px; -fx-font-style: italic;");
		householdNameField.setPromptText("Household name");

		this.emailField.setStyle("-fx-font-size: 14px; -fx-font-style: italic;");
		emailField.setPromptText("Your email");

		this.passwordField.setStyle("-fx-font-size: 14px; -fx-font-style: italic;");
		passwordField.setPromptText("Your password");

		this.loginGrid.add(heading, 0, 0);
		this.loginGrid.add(householdNameField, 0, 3);
		this.loginGrid.add(emailField, 0, 4);
		this.loginGrid.add(passwordField, 0, 5);
		this.loginGrid.add(loginButton, 0, 7);

		// set error page (stackPane)
		this.errorPane.setMaxWidth(220);
		this.errorPane.setMaxHeight(150);
		this.errorPane.setStyle("-fx-background-color: lightblue;");
		this.errorPane.setMargin(errorLabel, new javafx.geometry.Insets(8, 15, 60, 15));
		this.errorLabel.setWrapText(true);
		this.errorLabel.setStyle("-fx-font-size: 15px; -fx-font-weight: bold;");
		this.errorLabel.setContentDisplay(ContentDisplay.CENTER);

		this.ok.setPrefSize(40, 25);
		this.ok.setStyle("-fx-font-weight: bold;-fx-text-fill: #ffffff; -fx-background-color: #6E51E4;");
		this.ok.setFont(new Font(15));
		this.ok.setTranslateX(0);
		this.ok.setTranslateY(30);

//		this.heading.setFill(Color.GREEN);
//		this.emailHint.getStyleClass().add("hinttext");
//		this.passwordHint.getStyleClass().add("hinttext");
//		this.loginLayout.setSpacing(10);

		this.loginButton.setOnAction(e -> {
			householdName = householdNameField.getText();
			email = emailField.getText();
			String password = passwordField.getText();
			// Database db = Database.getInstance();

			if (!email.isEmpty() && !password.isEmpty()
					&& accountManagement.userExist(householdName, email, password)) {
				// success,jump into AddAChorePage
				openAddAChorePage();
			} else {
				errorPane.setVisible(true);
				errorPane.setDisable(false);
				errorLabel.setText("Login failed, please check the household name, your email and password.");

				householdNameField.clear();
				emailField.clear();
				passwordField.clear();
				emailField.setPromptText("Your email");
				passwordField.setPromptText("Your password");
				householdNameField.setPromptText("Household name");
//				showError("Login failed, please check your email and password.");
			}
		});

		ok.setOnAction(e -> {
			errorPane.setVisible(false);
			errorPane.setDisable(true);
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
//
//	private void showError(String message) {
//		Alert alert = new Alert(Alert.AlertType.ERROR);
//		alert.setTitle("Error");
//		alert.setHeaderText(null);
//		alert.setContentText(message);
//		alert.showAndWait();
//	}

}
