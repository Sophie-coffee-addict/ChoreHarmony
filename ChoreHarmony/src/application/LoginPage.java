package application;


import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class LoginPage extends Pane {
	
	Text heading = new Text("Login to ChoreHarmony");
	
	//
	Text emailHint = new Text("Email: ");
	Text passwordHint = new Text("Password: ");
	TextField emailEntry = new TextField();
	TextField passwordEntry = new TextField();
	
	
	
	
	HBox email = new HBox(emailHint, emailEntry);
	HBox password = new HBox(passwordHint, passwordEntry);
	
	VBox loginLayout = new VBox(heading, email, password);
	
	
	public LoginPage() {
		this.getChildren().add(loginLayout);
		this.setStyle("-fx-background-color: #FAC8CD");
		this.heading.getStyleClass().add("heading");
		this.heading.setFill(Color.GREEN);
		this.emailHint.getStyleClass().add("hinttext");
		this.passwordHint.getStyleClass().add("hinttext");
		this.loginLayout.setSpacing(10);
		this.loginLayout.setAlignment(Pos.CENTER);
		
	}
	
}



