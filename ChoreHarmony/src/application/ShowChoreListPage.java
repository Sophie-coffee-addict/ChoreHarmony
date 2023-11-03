package application;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ShowChoreListPage extends Application {
	 private Label titleLabel;

	 
	public void start(Stage primaryStage) {
		//AccountManagement accountManagement = new  AccountManagement();
		primaryStage.setTitle("Register");
		 VBox vbox = new  VBox();
		 vbox.setAlignment(javafx.geometry.Pos.CENTER); 
		 titleLabel = new Label("Chore List");
	     titleLabel.setStyle("-fx-font-size: 40px; -fx-font-weight: bold;");
	     titleLabel.setAlignment(Pos.CENTER);

	  //creat a ListView
	        ListView<String> listView = new ListView<>();
	        listView.setPrefWidth(300);//宽度设置不起作用
	       /* 加载数据不成功
	        Household household = accountManagement.getCurrentHousehold("123");
	        String chore = household.getChores().get(0).toString();
	      
	       */ 
	          listView.getItems().addAll("Do dishs  Weekly  8:00  Individual", "chorename2", "chorename3","chorename4");
	     Button button = new Button("Add a chore");
	     button.setPrefSize(150, 50);
	     button.setFont(new Font(20));

	     vbox.getChildren().addAll(titleLabel,listView, button);
	     Scene scene = new Scene(vbox, 400, 800);
	        Image backgroundImage = new Image("https://img.ixintu.com/download/jpg/201911/7fd3f0716dc87769a3914c760681f158.jpg!con0");
	        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
	        BackgroundImage backgroundImageObj = new BackgroundImage(backgroundImage, null, null, null, backgroundSize);
	        Background background = new Background(backgroundImageObj);

	        vbox.setBackground(background);
	        primaryStage.setScene(scene);
	        primaryStage.show();
	 
	}
	
	public static void main(String[] args) {
		launch(args);
	}
		
}
