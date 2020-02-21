package application.model;

import java.util.ArrayList;
/**
 * 
 * @author huaweisun
 *
 */
public class User {
	private String name;
	private String password;
	private ArrayList<Wand> wand;
	// construct
	public User(String name, String password, Wand wand) {
		this.name = name;
		this.password = password;
		this.wand = new ArrayList<Wand>();
		
	}

	// getter name
	public String getName() {
		return name;
	}

	// setter name
	public void setName(String name) {
		this.name = name;
	}

	// getter password
	public String getPassword() {
		return password;
	}

	// setter password
	public void setPassword(String password) {
		this.password = password;
	}

	// getter array list wand
	public ArrayList<Wand> getWand() {
		return wand;
	}

	// setter array list wand
	public void setWand(ArrayList<Wand> wand) {
		this.wand = wand;
	}
	//add
	public void addWand(Wand wand) {
		this.wand.add(wand);
	}
}
