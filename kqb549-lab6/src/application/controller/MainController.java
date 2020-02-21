package application.controller;

import java.io.IOException;

import application.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
/**
 * 
 * @author huaweisun
 *
 */
public class MainController implements EventHandler<ActionEvent> {
	@FXML
	Button button1;
	@FXML
	Button button2;

	@FXML
	public void handle(ActionEvent event) {
		Parent root;
		if (event.getSource().equals(button1)) {
			try {
				root = FXMLLoader.load(getClass().getResource("../view/Average.fxml"));
				Main.stage.setScene(new Scene(root, 650, 650));
				Main.stage.show();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (event.getSource().equals(button2)) {
			try {
				root = FXMLLoader.load(getClass().getResource("../view/Grade.fxml"));
				Main.stage.setScene(new Scene(root, 650, 650));
				Main.stage.show();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
