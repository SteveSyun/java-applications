package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
/**
 * Main
 * @author huaweisun
 *
 */

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			//BorderPane root = new BorderPane();
			FXMLLoader loader= new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/Main.fxml"));
			AnchorPane anchorPane = (AnchorPane) loader.load();
			Scene scene = new Scene(anchorPane, 600,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
