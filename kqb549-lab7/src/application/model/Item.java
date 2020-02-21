package application.model;
/**
 * Item
 * @author huaweisun
 *
 */
public class Item {
	private String name;
	private int quantity;
	private double price;

	// <<constructor>>
	public Item(String name, int getQuatity, Double getPrice) {
		this.name = name;
		this.quantity = getQuatity;
		this.price = getPrice;
	}

	// getter name
	public String getName() {
		return name;
	}

	// setter name
	public void setName(String name) {
		this.name = name;
	}

	// getter quantity
	public int getQuantity() {
		return quantity;
	}

	// setter quantity
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	// getter price
	public double getPrice() {
		return price;
	}

	// setter price
	public void setPrice(double price) {
		this.price = price;
	}
}
