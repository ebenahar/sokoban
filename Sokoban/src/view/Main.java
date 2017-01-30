package view;

import model.MyGameModel;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;
import controller.SokobanController;
import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application{
	@Override
	public void start(Stage starting){
		try{
			FXMLLoader loader = new FXMLLoader();
			BorderPane root = loader.load(getClass().getResource("Sample.fxml").openStream());
		
			Scene scene = new Scene(root,600,600);

			MyGameModel model = new MyGameModel();
			SokobanController controller = new SokobanController(model, view);

			model.addObserver(controller);
			view.addObserver(controller);

			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			starting.setScene(scene);
			//view.start();

			starting.show();
		} 
		catch(Exception exception){
			exception.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		launch(args);
	}
}