package application.model.test;

import static org.junit.Assert.*;

import java.util.SortedMap;
import java.util.TreeMap;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import application.model.Item;
import application.model.Market;

/**
 * MarketTest Junit
 * @author huaweisun
 *
 */
public class MarketTest {
	private Market testmarket;
	private SortedMap<String, Item> sortedMap;
	private Item item;

	@Before
	public void setUp() throws Exception {
		// create testing structures
		this.testmarket = new Market();
		this.item = new Item("specialfruits", 52, 0.55);
		this.setSortedMap(new TreeMap<String, Item>());

	}

	@Test
	public void testadditem() {
		// add item and test sorted map contains it
		testmarket.addItem(item);
		if (!testmarket.getSortedMap().containsKey("specialfruits"))
			fail("Add is not work");
	}

	@After
	public void testGetQuantity() {
		// get quantity and check if the quantity amount able to find
		// in sorted map
		int check = testmarket.getQuantity("specialfruits");
		assert (!testmarket.getSortedMap()
				.containsValue(check)) : "Error Cant find the number please check getqyantity or map";
	}

	@After
	public void testGetPrice() {
		// get price and check if the price amount able to find
		// in sorted map
		double check1 = testmarket.getPrice("specialfruits");
		assert (!testmarket.getSortedMap()
				.containsValue(check1)) : "Error Cant find the number please check getprice or map";
	}

	@After
	public void testUpdateQuantity() {
		//updatQuantity updating the quantity if not throw error
		testmarket.updateQuantity("specialfruits", 100);
		assert (!testmarket.getSortedMap().containsValue(100)) : "Error Cant updatedate quantity please check";

	}

	public SortedMap<String, Item> getSortedMap() {
		return sortedMap;
	}

	public void setSortedMap(SortedMap<String, Item> sortedMap) {
		this.sortedMap = sortedMap;
	}

}
