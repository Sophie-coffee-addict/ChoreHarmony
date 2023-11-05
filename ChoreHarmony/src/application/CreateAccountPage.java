package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class CreateAccountPage extends StackPane {
	AccountManagement accountManagement = new AccountManagement();

//	Label outputLabel = new Label("");

	// homepage
	StackPane stackPane = new StackPane();
	BorderPane borderPane = new BorderPane();
	VBox buttonHomepage = new VBox();
	Button createHousehold = new Button("CREATE A NEW HOUSDHOLD");
	Button existHousehold = new Button("MY HOUSEHOLD HAS AN ACCOUNT");
//	Image logoImage = new Image("logo.jpg");
//	ImageView logo = new ImageView(logoImage);

	// create account page
	Label titleLabel = new Label("Create a Household");
	GridPane grid = new GridPane();
	Label householdLabel = new Label("Step 1: Name your household.");
	TextField householdNameField = new TextField();
	Label creatorLabel = new Label("Step 2: Register an administrator.");
	TextField nameField = new TextField();
//	Label emailLabel = new Label("Email:");
	TextField emailField = new TextField();
//	Label passwordLabel = new Label("Password:");
	PasswordField passwordField = new PasswordField();
//	Label confirmPasswordLabel = new Label("Confirm Password:");
	PasswordField confirmPasswordField = new PasswordField();
	Button registerButton = new Button("Create");

	// response page of registerButton
	StackPane responsePane = new StackPane();
//	Label responseText = new Label("login");
	Label outputLabel = new Label("");
	Button ok = new Button("OK");
	Button login = new Button("Log In");

//	private void updateOutputLabel(String text) {
//		outputLabel.setText(outputLabel.getText() + "\n" + text);
//	}

//	private void redirectSystemOut() {
//		PrintStream printStream = new PrintStream(new OutputStream() {
//			@Override
//			public void write(int b) {
//				updateOutputLabel(String.valueOf((char) b));
//			}
//		});
//
//		System.setOut(printStream);
//	}

	public CreateAccountPage() {
		// set homepage(borderPane)
		grid.setVisible(false);
		grid.setDisable(true);
		responsePane.setVisible(false);
		responsePane.setDisable(true);

		this.buttonHomepage.setSpacing(6);
		BorderPane.setMargin(buttonHomepage, new javafx.geometry.Insets(0, 0, 20, 0));

		this.createHousehold.setPrefSize(400, 35);
		this.createHousehold.setStyle("-fx-font-weight: bold;");
		this.createHousehold.setFont(new Font(15));
		this.createHousehold.getStyleClass().add("button");
		this.createHousehold.setTextFill(Color.web("#ffffff"));

		this.existHousehold.setPrefSize(400, 35);
		this.existHousehold.setStyle("-fx-font-weight: bold;");
		this.existHousehold.setFont(new Font(15));
		this.existHousehold.getStyleClass().add("button");
		this.existHousehold.setTextFill(Color.web("#ffffff"));

		this.buttonHomepage.getChildren().addAll(createHousehold, existHousehold);
		this.borderPane.setBottom(buttonHomepage);

//		this.borderPane.setCenter(logo);

		createHousehold.setOnAction(e -> {
			borderPane.setVisible(false);
			borderPane.setDisable(true);
			grid.setVisible(true);
			grid.setDisable(false);
		});

		// set response page (stackPane)
		this.responsePane.setMaxWidth(220);
		this.responsePane.setMaxHeight(150);
		this.responsePane.setStyle("-fx-background-color: lightblue;");
		this.responsePane.setMargin(outputLabel, new javafx.geometry.Insets(8, 15, 60, 15));
		this.outputLabel.setWrapText(true);
		this.outputLabel.setStyle("-fx-font-size: 15px; -fx-font-weight: bold;");
		this.outputLabel.setContentDisplay(ContentDisplay.CENTER);

		this.ok.setPrefSize(40, 25);
		this.ok.setStyle("-fx-font-weight: bold;");
		this.ok.setFont(new Font(12));
		this.ok.getStyleClass().add("button");
		this.ok.setTextFill(Color.web("#ffffff"));
		this.ok.setTranslateX(0);
		this.ok.setTranslateY(30);

		this.login.setPrefSize(60, 25);
		this.login.setStyle("-fx-font-weight: bold;");
		this.login.setFont(new Font(12));
		this.login.getStyleClass().add("button");
		this.login.setTextFill(Color.web("#ffffff"));
		this.login.setTranslateX(0);
		this.login.setTranslateY(30);
		login.setVisible(false);
		login.setDisable(true);

		this.responsePane.getChildren().addAll(outputLabel, ok, login);

		// set gridPane
		this.grid.setStyle("-fx-background-color: #FAC8CD");
//		this.setTop(titleLabel);
		this.grid.setPadding(new Insets(35, 30, 20, 30));
		ColumnConstraints col1 = new ColumnConstraints(350);
		this.grid.getColumnConstraints().add(col1);
		this.grid.setVgap(15);
//		this.grid.setHgap(10);
		this.titleLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");
		this.titleLabel.setMaxWidth(400);
		this.titleLabel.setAlignment(Pos.CENTER);
		this.householdLabel.setPrefWidth(350);
//		this.householdLabel.setPrefHeight(30);
		this.householdLabel.setFont(new Font(15));
		this.creatorLabel.setPrefWidth(350);
		this.creatorLabel.setFont(new Font(15));
//		this.nameLabel.setPrefWidth(80);
//		this.nameLabel.setPrefHeight(30);
//		this.nameLabel.setFont(new Font(20));
//		this.emailLabel.setPrefSize(80, 30);
//		this.emailLabel.setFont(new Font(20));
//		this.passwordLabel.setPrefSize(80, 30);
//		this.passwordLabel.setFont(new Font(20));
//		this.confirmPasswordLabel.setPrefSize(150, 30);
//		this.confirmPasswordLabel.setFont(new Font(20));

		this.registerButton.setPrefSize(350, 35);
		this.registerButton.setStyle("-fx-font-weight: bold;");
		this.registerButton.setFont(new Font(20));
		this.registerButton.getStyleClass().add("button");
		this.registerButton.setTextFill(Color.web("#ffffff"));

		this.householdNameField.setStyle("-fx-font-size: 14px; -fx-font-style: italic;");
		householdNameField.setPromptText("Household name");
		householdNameField.textProperty().addListener((observable, oldValue, newValue) -> {
			if (newValue.length() > 10) {
				householdNameField.setText(oldValue);
			}
		});

		this.nameField.setStyle("-fx-font-size: 14px; -fx-font-style: italic;");
		nameField.setPromptText("Your name (maximum 10 characters)");
		nameField.textProperty().addListener((observable, oldValue, newValue) -> {
			if (newValue.length() > 10) {
				nameField.setText(oldValue);
			}
		});

		this.emailField.setStyle("-fx-font-size: 14px; -fx-font-style: italic;");
		emailField.setPromptText("Your email (example@example.com)");
		emailField.textProperty().addListener((observable, oldValue, newValue) -> {
			if (!isValidEmailFormat(newValue)) {
				emailField.setStyle("-fx-text-box-border: red ; -fx-focus-color: red ;");
			} else {
				emailField.setStyle(""); // Restore default style
			}
		});

		this.passwordField.setStyle("-fx-font-size: 14px; -fx-font-style: italic;");
		passwordField.setPromptText("Set a password");

		this.confirmPasswordField.setStyle("-fx-font-size: 14px; -fx-font-style: italic;");
		confirmPasswordField.setPromptText("Confirm the password");

//		this.outputLabel.setWrapText(true);

		this.grid.add(titleLabel, 0, 0);
		this.grid.add(householdLabel, 0, 3);
		this.grid.add(householdNameField, 0, 4);
		this.grid.add(creatorLabel, 0, 6);
		this.grid.add(nameField, 0, 7);
//		this.grid.add(emailLabel, 0, 2);
		this.grid.add(emailField, 0, 8);
//		this.grid.add(passwordLabel, 0, 3);
		this.grid.add(passwordField, 0, 9);
//		this.grid.add(confirmPasswordLabel, 0, 4);
		this.grid.add(confirmPasswordField, 0, 10);
		this.grid.add(registerButton, 0, 12);
//		this.grid.add(outputLabel, 0, 14, 1, 1);

//		this.setCenter(grid);

		this.registerButton.setOnAction(e -> {
			String householdname = householdNameField.getText();
			String name = nameField.getText();
			String email = emailField.getText();
			String password = passwordField.getText();
			String confirmPassword = confirmPasswordField.getText();

			responsePane.setVisible(true);
			responsePane.setDisable(false);

			if (name.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()
					|| householdname.isEmpty()) {
				outputLabel.setText("Please fill in all the fields.");
//				updateOutputLabel("Please fill in all the fields.");

			} else if (!password.equals(confirmPassword)) {
				outputLabel.setText("Password does not match. Please try again.");
//				updateOutputLabel("Password does not match. Please try again.");
			} else {
				outputLabel.setText("Create successful!");
//				updateOutputLabel("Create successful!");
				ok.setVisible(false);
				ok.setDisable(true);
				login.setVisible(true);
				login.setDisable(false);
//				openLoginPage();
				// ����create����
				accountManagement.createHouseholdAccount(householdname, name, email, confirmPassword);

			}

			/*
			 * try(BufferedWriter writer = new BufferedWriter(new
			 * FileWriter("ChoreHarmony\\userdata.txt",true))){
			 * writer.write(householdname+" "); writer.write(name+" ");
			 * writer.write(email+" "); writer.write(password+" ");
			 * writer.write(confirmPassword+System.lineSeparator());
			 * 
			 * writer.close(); Alert alert = new Alert(Alert.AlertType.INFORMATION);
			 * alert.setTitle("Success"); alert.setContentText("Save Successed");
			 * alert.showAndWait();
			 * 
			 * 
			 * } catch (IOException e1) { // TODO Auto-generated catch block
			 * e1.printStackTrace(); }
			 */

		});

		ok.setOnAction(e -> {
			responsePane.setVisible(false);
			responsePane.setDisable(true);
		});

		login.setOnAction(e -> {
			openLoginPage();
		});

		this.getChildren().addAll(borderPane, grid, responsePane);//

//		redirectSystemOut();

	}

	// Use regular expressions to verify Email format
	private boolean isValidEmailFormat(String email) {
		String emailPattern = "^[A-Za-z0-9+_.-]+@(.+)$";
		return email.matches(emailPattern);
	}

	private void openLoginPage() {
		Stage newstage = new Stage();
		newstage.setTitle("Login page");
		LoginPage lgoinPage = new LoginPage();

		Scene scene = new Scene(lgoinPage, 400, 700);
		newstage.setScene(scene);
		newstage.show();
	}
}
