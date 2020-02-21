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
import javafx.scene.control.RadioButton;
/**
 * Maincontroller
 * @author huaweisun
 *
 */
public class MainController implements EventHandler<ActionEvent> {
	@FXML
	private RadioButton story1;
	@FXML
	private RadioButton story2;
	@FXML
	private Button start;
	public static int check=0;
	@Override
	//handle two dif scence
	public void handle(ActionEvent event) {
		Parent root = null;
		if (event.getSource().equals(story1)) {
			story2.setSelected(false);
			check=1;
			
		} else if (event.getSource().equals(story2)) {
		
			story1.setSelected(false);
			check=2;
		}
		if (event.getSource().equals(start)) {
			try {
				root = FXMLLoader.load(getClass().getResource("../view/Story.fxml"));
				Main.stage.setScene(new Scene(root, 650, 650));
				Main.stage.show();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
