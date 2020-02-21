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
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

/**
 * 
 * @author huaweisun
 *
 */
public class GradeController implements EventHandler<ActionEvent> {
	@FXML
	Button homebutton;
	@FXML
	Button calculating;
	@FXML
	TextField textfield1;
	@FXML
	TextField textfield2;
	@FXML
	TextField textfield3;
	@FXML
	TextField textfield4;
	@FXML
	TextField textfield5;
	@FXML
	TextField Displayfield;
	@FXML
	TextField Lettergradef;
	@FXML
	Slider slider1;
	@FXML
	Slider slider2;
	@FXML
	Slider slider3;
	@FXML
	Slider slider4;
	@FXML
	Slider slider5;
	@FXML
	Label ErrorM;
	Calculator calculator = new Calculator();
	private int counter = 0;

	@Override
	public void handle(ActionEvent event) {
		Parent root;
		//event getSource using for check what button it is
		if (event.getSource().equals(homebutton)) {
			try {
				root = FXMLLoader.load(getClass().getResource("../view/Main.fxml"));
				Main.stage.setScene(new Scene(root, 650, 650));
				Main.stage.show();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (event.getSource().equals(calculating)) {
			if (counter == 0) {
				calculator.calculategrade(slider1.getValue(), textfield1.getText());
				calculator.calculategrade(slider2.getValue(), textfield2.getText());
				calculator.calculategrade(slider3.getValue(), textfield3.getText());
				calculator.calculategrade(slider4.getValue(), textfield4.getText());
				calculator.calculategrade(slider5.getValue(), textfield5.getText());
				if (calculator.getGetTextfieldTo() != 100) {

					ErrorM.setText(
							"current total weight=" + calculator.getGetTextfieldTo() + ", total weight should be 100");
				}
				Displayfield.setText(Integer.toString(calculator.getTotal()));
				String result = calculator.check(calculator.getTotal());
				Lettergradef.setText(result);
				counter++;
				//counter using for refresh setText
			} else if (counter >= 1) {
				Calculator calculator = new Calculator();
				//refresh textfield
				ErrorM.setText("");
				calculator.calculategrade(slider1.getValue(), textfield1.getText());
				calculator.calculategrade(slider2.getValue(), textfield2.getText());
				calculator.calculategrade(slider3.getValue(), textfield3.getText());
				calculator.calculategrade(slider4.getValue(), textfield4.getText());
				calculator.calculategrade(slider5.getValue(), textfield5.getText());
				if (calculator.getGetTextfieldTo() != 100) {

					ErrorM.setText(
							"current total weight=" + calculator.getGetTextfieldTo() + ", total weight should be 100");
				}
				Displayfield.setText(Integer.toString(calculator.getTotal()));
				String result = calculator.check(calculator.getTotal());
				Lettergradef.setText(result);
			}
		}
	}

}
