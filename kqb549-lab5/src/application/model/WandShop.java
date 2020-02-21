package application.model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import application.controller.LoginController;
import application.controller.WandShopController;

/**
 * 
 * @author huaweisun
 *
 */

public class WandShop {
	private String name;
	private  ArrayList<User> user;
	private String[] tokens;
	public static ArrayList<Wand> CurrentWand = new ArrayList<>();
	public static String CurrentUser;
	public static String CurrentPassword;
	public static int check = 0;

	// getter for user array
	public ArrayList<User> getUser() {
		return user;
	}

	// setter for user array
	public void setUser(ArrayList<User> user) {
		this.user = user;
	}

	// construct
	public WandShop(String name) {
		this.name = name;
		this.user = new ArrayList<User>();

	}

	// getter name
	public String getName() {
		return name;
	}

	// setter name
	public void setName(String name) {
		this.name = name;
	}

	// addfunc
	public void addUser(User user) {
		this.user.add(user);
	}

	// loaduser
	public void loadUser(String Filename) throws IOException {
		File file = new File(Filename);
		Scanner scan = new Scanner(file);
		while (scan.hasNextLine()) {
			String line = scan.nextLine();
			String[] tokens = line.split(",");
			Wand wand = new Wand(tokens[2], tokens[4], tokens[3], tokens[5]);
			User user = new User(tokens[0], tokens[1], wand);
			this.addUser(user);
			user.addWand(wand);

		}
		scan.close();
	}

	// check validate
	public boolean validate(String phase1, String phase2) {
		CurrentUser = phase1;
		CurrentPassword = phase2;

		for (int i = 0; i < user.size(); i++) {
			if (user.get(i).getName().equals(phase1) && user.get(i).getPassword().equals(phase2)) {
				CurrentWand = user.get(i).getWand();
				CurrentUser = user.get(i).getName();
				System.out.println("success");
				return true;
			} else if (user.get(i).getName().equals(phase1) && !user.get(i).getPassword().equals(phase2)) {
				System.out.println("password no correct");

				return false;
			}
		}
		// create a new one
		check++;
		System.out.println("create a new user");
		return true;
	}

	// save func
	public void save(String tmp, String tmp1, String tmp2, String tmp3) throws IOException {
		File file = new File("data/users.csv");
		FileWriter writer = new FileWriter(file);
		int buffer = 0;
		for (int i = 0; i < LoginController.wandshop.getUser().size(); i++) {
			for (int j = 0; j < LoginController.wandshop.getUser().get(i).getWand().size(); j++) {
				User user1 = LoginController.wandshop.getUser().get(i);
				Wand wand1 = LoginController.wandshop.getUser().get(i).getWand().get(j);
				
				if (user1.getName().equals(CurrentUser) && user1.getPassword().equals(CurrentPassword)) {
					System.out.println(tmp+","+tmp1+","+tmp2+","+tmp3);
					writer.write(CurrentUser + "," + CurrentPassword + "," + tmp + "," + tmp1 + "," + tmp2 + ","
							+ tmp3+"\n");
					buffer++;
					System.out.println("change user is write succes");
				} else {
					writer.write(user1.getName() + "," + user1.getPassword() + "," + wand1.getWood() + ","
							+ wand1.getCore() + "," + wand1.getLength() + "," + wand1.getQuality()+"\n");
					System.out.println("saved orginal file");
				}
			}
		}
		if (buffer <= 0) {
			writer.write(CurrentUser + "," + CurrentPassword + "," + tmp + "," + tmp1 + "," + tmp2 + "," + tmp3+"\n");
			System.out.println("Create is write succes");
		}
		writer.close();
	}

}
