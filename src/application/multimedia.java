package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class multimedia extends Application{

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		Parent root = FXMLLoader.load(getClass().getResource("multimediafxml.fxml"));
		Scene scene = new Scene(root,600,400);
		stage.setScene(scene);
		stage.setTitle("멀티미디어");
		stage.show();
	}
	
	public static void main(String[] args) {
	// TODO Auto-generated method stub
		launch(args);
	}
}

