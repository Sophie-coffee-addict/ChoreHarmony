package application;

import java.io.OutputStream;
import java.io.PrintStream;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
/**
 * This is the main UI class.��
 */
public class Main extends Application {
	 private Label titleLabel;
		private Label outputLabel;
		@Override
		public void start(Stage primaryStage) {
			primaryStage.setTitle("Register");
			BorderPane borderPane = new BorderPane();
			
			 titleLabel = new Label("Create Account");
		     titleLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");
		     titleLabel.setMaxWidth(400);
		     titleLabel.setAlignment(Pos.CENTER);
		     borderPane.setTop(titleLabel);
			
	        GridPane grid = new GridPane();
	        grid.setPadding(new Insets(20, 20, 20, 20));
	        grid.setVgap(10);
	        grid.setHgap(10);
	        
	        Label householdLabel = new Label("Household Name:");
	        householdLabel.setPrefWidth(120); 
	        householdLabel.setPrefHeight(30); 
	        householdLabel.setFont(new Font(20));
	        TextField nameField1 = new TextField();
	        
	        Label nameLabel = new Label("Name:");
	        nameLabel.setPrefWidth(80); 
	        nameLabel.setPrefHeight(30); 
	        nameLabel.setFont(new Font(20));
	        TextField nameField = new TextField();
	        Label emailLabel = new Label("Email:");
	        emailLabel.setPrefSize(80, 30);
	        emailLabel.setFont(new Font(20));
	        TextField emailField = new TextField();
	        Label passwordLabel = new Label("Password:");
	        passwordLabel.setPrefSize(80, 30);
	        passwordLabel.setFont(new Font(20));
	        PasswordField passwordField = new PasswordField();
	        Label confirmPasswordLabel = new Label("Confirm Password:");
	        confirmPasswordLabel.setPrefSize(150, 30);
	        confirmPasswordLabel.setFont(new Font(20));
	        PasswordField confirmPasswordField = new PasswordField();
	  
	        //css
	        nameField1.setStyle("-fx-font-size: 14px; -fx-font-style: italic;");
	        nameField.setStyle("-fx-font-size: 14px; -fx-font-style: italic;");
	        emailField.setStyle("-fx-font-size: 14px; -fx-font-style: italic;");
	        passwordField.setStyle("-fx-font-size: 14px; -fx-font-style: italic;");
	        confirmPasswordField.setStyle("-fx-font-size: 14px; -fx-font-style: italic;");
	        // ��������ı�����
	        outputLabel = new Label("");
	        outputLabel.setWrapText(true);
	        
	        Button registerButton = new Button("Create");
	        registerButton.setPrefSize(150, 50);
	        registerButton.setFont(new Font(20));
	        registerButton.getStyleClass().add("button");
	        registerButton.setTextFill(Color.web("#ffffff"));
	        //GridPane.setConstraints(registerButton, 1, 4);
	        
	        
	        grid.add(householdLabel,0,0);
	        grid.add(nameField1, 1, 0);
	        grid.add(nameLabel, 0, 1);
	        grid.add(nameField, 1, 1);
	        grid.add(emailLabel, 0, 2);
	        grid.add(emailField, 1, 2);
	        grid.add(passwordLabel, 0, 3);
	        grid.add(passwordField, 1, 3);
	        grid.add(confirmPasswordLabel, 0, 4);
	        grid.add(confirmPasswordField, 1, 4);
	        grid.add(registerButton, 1, 5);
	        grid.add(outputLabel, 0, 6, 2, 1);
	         
	       borderPane.setCenter(grid);
	        registerButton.setOnAction(e -> {
	            String name = nameField.getText();
	            String email = emailField.getText();
	            String password = passwordField.getText();
	            String confirmPassword = confirmPasswordField.getText();

	            if (name.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
	                updateOutputLabel("Please fill in all the fields.");
	            } else if (!password.equals(confirmPassword)) {
	                updateOutputLabel("Password does not match. Please try again.");
	            } else {
	                updateOutputLabel("Create successful!");
	            }
	        });
	        
	        borderPane.setStyle("-fx-background-color: #FAC8CD");
	        Scene scene = new Scene(borderPane, 400, 800);
	        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	        primaryStage.setScene(scene);
	        primaryStage.show();
	        
	        redirectSystemOut();
		}
		
		
		  private void updateOutputLabel(String text) {
		        outputLabel.setText(outputLabel.getText() + "\n" + text);
		    }
		  
		  private void redirectSystemOut() {
		        PrintStream printStream = new PrintStream(new OutputStream() {
		            @Override
		            public void write(int b) {
		                updateOutputLabel(String.valueOf((char) b));
		            }
		        });

		        System.setOut(printStream);
		    }
		  
		public static void main(String[] args) {
			launch(args);
		}
	}
