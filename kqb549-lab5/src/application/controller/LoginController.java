package application.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import application.model.User;
import application.model.Wand;
import application.model.WandShop;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
/**
 * 
 * @author huaweisun
 *
 */
public class LoginController implements Initializable {
	public static WandShop wandshop = new WandShop("Olivaders");
	@FXML
	TextField UserName;
	@FXML
	PasswordField PassWord;
	@FXML
	Label PError;
	//initialize
	public void initialize(URL location, ResourceBundle resources) {
		try {
			wandshop.loadUser("data/users.csv");
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@FXML
	public void handle(ActionEvent Event) {
		Parent root;
		try {
			if (wandshop.validate(UserName.getText(), PassWord.getText()) == true) {
				root = FXMLLoader.load(getClass().getResource("../view/WandShop.fxml"));
				Main.stage.setScene(new Scene(root, 550, 650));
				Main.stage.show();
			}
			else
			{
				PError.setText(":PassWord  Incorrect");
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}