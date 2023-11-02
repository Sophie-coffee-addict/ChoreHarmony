package application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class CreateAccountPage extends BorderPane {
	
	Label outputLabel = new Label("");
	Label titleLabel = new Label("Create Account");
	GridPane grid = new GridPane();
	Label householdLabel = new Label("Household Name:");
	TextField nameField1 = new TextField();
	Label nameLabel = new Label("Name:");
	TextField nameField = new TextField();
	Label emailLabel = new Label("Email:");
	TextField emailField = new TextField();
	Label passwordLabel = new Label("Password:");
	PasswordField passwordField = new PasswordField();
	Label confirmPasswordLabel = new Label("Confirm Password:");
	PasswordField confirmPasswordField = new PasswordField();
	Button registerButton = new Button("Create");
	
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
	
	
	
	
	

   
   
   
  
   
   

   
   public CreateAccountPage() {
	   this.setStyle("-fx-background-color: #FAC8CD");
	   this.titleLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");
	   this.titleLabel.setMaxWidth(400);
	   this.titleLabel.setAlignment(Pos.CENTER);
	   this.setTop(titleLabel);
	   this.grid.setPadding(new Insets(20, 20, 20, 20));
	   this.grid.setVgap(10);
	   this.grid.setHgap(10);
	   this.householdLabel.setPrefWidth(120); 
	   this.householdLabel.setPrefHeight(30); 
	   this.householdLabel.setFont(new Font(20));
	   this.nameLabel.setPrefWidth(80); 
	   this.nameLabel.setPrefHeight(30); 
	   this.nameLabel.setFont(new Font(20));
	   this.emailLabel.setPrefSize(80, 30);
	   this.emailLabel.setFont(new Font(20));
	   this.passwordLabel.setPrefSize(80, 30);
	   this.passwordLabel.setFont(new Font(20));
	   this.confirmPasswordLabel.setPrefSize(150, 30);
	   this.confirmPasswordLabel.setFont(new Font(20));
	   
	   this.registerButton.setPrefSize(150, 50);
	   this.registerButton.setFont(new Font(20));
	   this.registerButton.getStyleClass().add("button");
	   this.registerButton.setTextFill(Color.web("#ffffff"));
	   
	   this.nameField1.setStyle("-fx-font-size: 14px; -fx-font-style: italic;");
	   this.nameField.setStyle("-fx-font-size: 14px; -fx-font-style: italic;");
	   this.emailField.setStyle("-fx-font-size: 14px; -fx-font-style: italic;");
	   this.passwordField.setStyle("-fx-font-size: 14px; -fx-font-style: italic;");
	   this.confirmPasswordField.setStyle("-fx-font-size: 14px; -fx-font-style: italic;");
	   
	   this.outputLabel.setWrapText(true);
	   
	   this.grid.add(householdLabel,0,0);
	   this.grid.add(nameField1, 1, 0);
	   this.grid.add(nameLabel, 0, 1);
	   this.grid.add(nameField, 1, 1);
	   this.grid.add(emailLabel, 0, 2);
	   this.grid.add(emailField, 1, 2);
	   this.grid.add(passwordLabel, 0, 3);
	   this.grid.add(passwordField, 1, 3);
	   this.grid.add(confirmPasswordLabel, 0, 4);
	   this.grid.add(confirmPasswordField, 1, 4);
	   this.grid.add(registerButton, 1, 5);
	   this.grid.add(outputLabel, 0, 6, 2, 1);
	    
	  this.setCenter(grid);
	  
	  this.registerButton.setOnAction(e -> {
		   String householdname = nameField1.getText();
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
	       
	       
	       try(BufferedWriter writer = new BufferedWriter(new FileWriter("X:\\workspace\\workspace0707\\choreharmony\\ChoreHarmony\\userdata.txt",true))){
	       	writer.write(householdname+" ");
	       	writer.write(name+" ");
	       	writer.write(email+" ");
	       	writer.write(password+" ");
	       	writer.write(confirmPassword+System.lineSeparator());
	       	
	       	writer.close();
	       	Alert alert = new Alert(Alert.AlertType.INFORMATION);
	       	alert.setTitle("Success");
	       	alert.setContentText("Save Successed");
	       	alert.showAndWait();

	       	
	       } catch (IOException e1) {
	   		// TODO Auto-generated catch block
	   		e1.printStackTrace();
	   	}
	       
	   });
	  
	  redirectSystemOut();
	   
   }

}
