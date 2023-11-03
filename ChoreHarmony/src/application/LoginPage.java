package application;


import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class LoginPage extends Pane {
	AccountManagement accountManagement = new  AccountManagement();
	Text heading = new Text("Login to ChoreHarmony");
	
	Text householdName = new Text("household Name:");
	Text emailHint = new Text("Email: ");
	Text passwordHint = new Text("Password: ");
	
	TextField householdEntry = new TextField();
	TextField emailEntry = new TextField();
	TextField passwordEntry = new TextField();
	
	Button loginButton = new Button("Login");
	
	HBox household = new HBox(householdName,householdEntry);
	HBox email = new HBox(emailHint, emailEntry);
	HBox password = new HBox(passwordHint, passwordEntry);
	
	VBox loginLayout = new VBox(heading,household,email, password,loginButton);
	
	
	public LoginPage() {
		this.getChildren().add(loginLayout);
		this.setStyle("-fx-background-color: #FAC8CD");
		this.heading.getStyleClass().add("heading");
		this.heading.setFill(Color.GREEN);
		this.emailHint.getStyleClass().add("hinttext");
		this.passwordHint.getStyleClass().add("hinttext");
		this.loginLayout.setSpacing(10);
		this.loginLayout.setAlignment(Pos.CENTER);
		
		
		 this.loginButton.setOnAction(e -> {
               String householdName = householdEntry.getText();
		       String email = emailEntry.getText();
		       String password =passwordEntry.getText();
		      // Database db = Database.getInstance();

		       if (!email.isEmpty() && !password.isEmpty() 
		    		   &&accountManagement.userExist(householdName,email, password)) {
		                // 登录成功，跳转到 AddAChorePage 页面
		    	   
		                openAddAChorePage();
		            } else {
		                // 登录失败，显示错误消息
		                showError("Login failed, please check your email and password.");
		            }

		 });
	}
	
	 private void  openAddAChorePage() {
		   Stage newstage = new Stage();
		   newstage.setTitle("Add A Chore");
		   AddAChorePage AddAChorePage = new AddAChorePage();
		   
		   Scene scene = new Scene(AddAChorePage,400,800);
		   newstage.setScene(scene);
		   newstage.show();
	   }
	
	 private void showError(String message) {
	        Alert alert = new Alert(Alert.AlertType.ERROR);
	        alert.setTitle("Error");
	        alert.setHeaderText(null);
	        alert.setContentText(message);
	        alert.showAndWait();
	    }
	
	
	
	
}



