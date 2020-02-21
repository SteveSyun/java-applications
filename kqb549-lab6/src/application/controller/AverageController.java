package application.controller;

import java.io.IOException;

import application.Main;
import application.model.Calculator;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
/**
 * 
 * @author huaweisun
 *
 */
public class AverageController implements EventHandler<ActionEvent> {
	@FXML
	Button buttonhome;
	@FXML
	Button Calculating;
	@FXML
	TextField textfield1;
	@FXML
	TextField textfield2;
	@FXML
	Label Derorr;

	public Calculator calculator = new Calculator();
	private int counter = 0;

	public void handle(ActionEvent event) {
		Parent root;
		try {
			//check what button it is
			if (event.getSource().equals(buttonhome)) {

				root = FXMLLoader.load(getClass().getResource("../view/Main.fxml"));
				Main.stage.setScene(new Scene(root, 650, 650));
				Main.stage.show();
			} else if (event.getSource().equals(Calculating)) {
				calculator.getTextSp(textfield1.getText());
				String getAver = Integer.toString(calculator.getSum());
				textfield2.setText(getAver);
				if (calculator.getBuffer() == 1) {
					Derorr.setText(": Please enter only numbers");
				}
				counter++;
				//counter using to refresh setText
				if (counter >= 2) {
					Calculator calculator = new Calculator();
					Derorr.setText("");
					calculator.getTextSp(textfield1.getText());
					getAver = Integer.toString(calculator.getSum());
					textfield2.setText(getAver);
					if (calculator.getBuffer() >= 1) {
						Derorr.setText(": Please enter only numbers");
					}
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}
}
