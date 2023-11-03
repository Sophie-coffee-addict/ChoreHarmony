package application;

import javafx.application.Application;

import javafx.scene.Scene;

import javafx.stage.Stage;
/**
 * This is the main UI class.��
 */
public class Main extends Application {
	
		public int householdID;

		@Override
		public void start(Stage primaryStage) {
			primaryStage.setTitle("Register");
			
	        CreateAccountPage register = new CreateAccountPage();
	        
	        Scene scene = new Scene(register, 400, 800);
	        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	        primaryStage.setScene(scene);
	        primaryStage.show();
	        
	       // Database db = Database.getInstance();
		}
		
		
		  
		  
		public static void main(String[] args) {
			launch(args);
		}
	}
