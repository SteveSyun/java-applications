package application.model;
/**
 * Market
 * @author huaweisun
 */
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;
public class Market {
	//sorted map is type of hash map
	SortedMap<String, Item> sortedMap;
	// constructor
	public Market() {
		this.sortedMap = new TreeMap<String, Item>();
	}

	// add to map
	public void addItem(Item item) {
		sortedMap.put(item.getName(), item);
	}

	// loadItems from file and put into item and add to map
	public void loadItemsFromFile() throws IOException {
		File file = new File("market.csv");
		Scanner scan = new Scanner(file);
		while (scan.hasNextLine()) {
			String line = scan.nextLine();
			String[] tokens = line.split(",");
			int getQuatity = Integer.parseInt(tokens[1]);
			double getPrice = Double.parseDouble(tokens[2]);
			Item item = new Item(tokens[0], getQuatity, getPrice);
			addItem(item);
		}
		scan.close();
	}
	//save item back to file
	public void saveItemsToFile() throws IOException {
		File file = new File("market.csv");
		FileWriter writer = new FileWriter(file);
		System.out.println("Save Success");
		for (Map.Entry<String, Item> itemsprint : getSortedMap().entrySet()) {
			System.out.println(itemsprint.getValue().getName() + itemsprint.getValue().getQuantity() + "  "
					+ itemsprint.getValue().getPrice());
			writer.write(itemsprint.getValue().getName() + "," + itemsprint.getValue().getQuantity() + ","
					+ itemsprint.getValue().getPrice()+"\n");
		}
		writer.close();
	}

	// updateQuantity(name,quantity) - Updates the Item, saved in the Market,
	// given the item name (String)
	// and quantity (Integer).
	public void updateQuantity(String name, int quantity) {
		for (int i = 0; i < sortedMap.size(); i++) {
			if (sortedMap.containsKey(name)) {
				sortedMap.get(name).setQuantity(quantity);
			}
		}
	}

	// getter for sortedMap
	public SortedMap<String, Item> getSortedMap() {
		return sortedMap;
	}

	// setter for sortedMap
	public void setSortedMap(SortedMap<String, Item> sortedMap) {
		this.sortedMap = sortedMap;
	}

	// getter price
	public double getPrice(String Name) {
		return sortedMap.get(Name).getPrice();
	}

	// getter quantity
	public int getQuantity(String Name) {
		return sortedMap.get(Name).getQuantity();
	}
}
