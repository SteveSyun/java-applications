package application.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * 
 * @author huaweisun
 * 
 */
public class Wand {
	/*
	 * The Wand.java class represents a wand in this application. Each wand has a
	 * wood, a length (in inches), a core, and a quality.
	 */
	private String wood;
	private String length;
	private String core;
	private String quality;
	
	
	public static ArrayList<String> woodString=new ArrayList<>();
	public static ArrayList<String> lengthString=new ArrayList<>();
	public static ArrayList<String> coreString=new ArrayList<>();
	public static ArrayList<String> qualityString=new ArrayList<>();

	// construct
	public Wand(String wood, String length, String core, String quality) {
		this.wood = wood;
		this.length = length;
		this.core = core;
		this.quality = quality;
		

	}

	
	// getter for wood
	public String getWood() {
		return wood;
	}

	// setter for wood
	public void setWood(String wood) {
		this.wood = wood;
	}

	// getter length
	public String getLength() {
		return length;
	}

	// setter for length
	public void setLength(String length) {
		this.length = length;
	}

	// getter for Core
	public String getCore() {
		return core;
	}

	// setter for core
	public void setCore(String core) {
		this.core = core;
	}

	// getter for quality
	public String getQuality() {
		return quality;
	}

	// setter for quality
	public void setQuality(String quality) {
		this.quality = quality;
	}
	
	//loadwand
	public static void loadwand(String Filename) throws FileNotFoundException {
		File file = new File(Filename);
		Scanner scan = new Scanner(file);
		while (scan.hasNext()) {
			String line = scan.nextLine();
			String[] tokens = line.split(",");
			if (tokens[0].equals("Wood")) {
				for (int i = 1; i < tokens.length; i++) {
					woodString.add(tokens[i]);

				}
			} else if (tokens[0].equals("Core")) {
				for (int i = 1; i < tokens.length; i++) {
					coreString.add(tokens[i]);
				}
			}else if (tokens[0].equals("Quality")) {
				for (int i = 1; i < tokens.length; i++) {
					qualityString.add(tokens[i]);
				}
			}else if (tokens[0].equals("Length")) {
				for (int i = 1; i < tokens.length; i++) {
					lengthString.add(tokens[i]);
				}
			}

		}
		scan.close();
	}
}
