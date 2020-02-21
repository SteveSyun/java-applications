package application.controller;

import java.io.IOException;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import application.model.Item;
import application.model.Market;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

/**
 * Main controller
 * 
 * @author huaweisun
 *
 */
public class MainController implements EventHandler<ActionEvent> {
	Market market = new Market();

	@FXML
	Button save;
	@FXML
	TextArea textarea;

	// load item from file and loop thru all table dates and append
	public void initialize() {
		try {
			market.loadItemsFromFile();
			String line = " ";
			for (Map.Entry<String, Item> itemsprint : market.getSortedMap().entrySet()) {
				line += String.format("%-30s\t\t%-19d\t\t $%.2f\n", itemsprint.getValue().getName(),
						itemsprint.getValue().getQuantity(), itemsprint.getValue().getPrice());
			}
			System.out.println(line);
			textarea.appendText(line);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void handle(ActionEvent event) {
		//get datas from textare and put into tree map and call save
		SortedMap<String, Item> sortedMap = new TreeMap<String, Item>();
		for (String line : textarea.getText().split("\\n")) {
			String token[] = line.split("\\t+");
			int getQuatity = Integer.parseInt(token[1].replace(" ", ""));
			double getPrice = Double.parseDouble(token[2].replaceAll("\\$", ""));
			Item item = new Item(token[0].replaceAll(" ", ""), getQuatity, getPrice);
			sortedMap.put(token[0], item);
			market.setSortedMap(sortedMap);
		}
		try {
			market.saveItemsToFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
