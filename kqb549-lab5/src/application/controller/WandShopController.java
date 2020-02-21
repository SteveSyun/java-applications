package application.controller;

import java.io.FileNotFoundException;
import java.io.IOException;

import application.model.Wand;
import application.model.WandShop;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;


/**
 * 
 * @author huaweisun
 *
 */
public class WandShopController implements EventHandler<ActionEvent> {
	public static WandShop wandshop = new WandShop("Olivaders");
	@FXML
	ComboBox <String> combox1;
	@FXML
	ComboBox <String>combox2;
	@FXML
	ComboBox <String>combox3;
	@FXML
	ComboBox <String>combox4;
	
	@Override
	public void handle(ActionEvent event)
	{
		try {
			String tmp=combox1.getSelectionModel().getSelectedItem();
			String tmp1=combox2.getSelectionModel().getSelectedItem();
			String tmp2=combox3.getSelectionModel().getSelectedItem();
			String tmp3=combox4.getSelectionModel().getSelectedItem();
		
			wandshop.save(tmp, tmp1, tmp2, tmp3);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@FXML
	void initialize() 
	{
		
		try {
			System.out.println("check case is ="+WandShop.check);
			//load user's wand shop items
			if(WandShop.check==0) {
			
			combox1.getSelectionModel().select(WandShop.CurrentWand.get(0).getWood());
			combox2.getSelectionModel().select(WandShop.CurrentWand.get(0).getCore());
			combox3.getSelectionModel().select(WandShop.CurrentWand.get(0).getLength());
			combox4.getSelectionModel().select(WandShop.CurrentWand.get(0).getQuality());
			}
			Wand.loadwand("data/wands.csv");
			//add  different wand to  combox
			combox1.getItems().addAll(Wand.woodString);
			combox2.getItems().addAll(Wand.coreString);
			combox3.getItems().addAll(Wand.lengthString);
			combox4.getItems().addAll(Wand.qualityString);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	

}
