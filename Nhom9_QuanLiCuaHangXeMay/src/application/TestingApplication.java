package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class TestingApplication extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();

//			BorderPane frm2 = (BorderPane)FXMLLoader.load(getClass().getResource("FrmQuanLiXe.fxml"));
//			Scene sceneTaoKH = new Scene(frm2);
//			Stage secondaryStage = new Stage();
//			secondaryStage.setScene(sceneTaoKH);
//			secondaryStage.setResizable(false);
//			secondaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
