package application.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import application.controller.MainController;
import javafx.scene.image.Image;
/**
 * Story.java
 * @author huaweisun
 *
 */
public class Story {
	private Image image;
	private ArrayList<Image> imageFiles;
	private ArrayList<String> sentences;
	private int timer=36;
	
	//getter arraylist(string) get sentence
	public ArrayList<String> getSentences() {
		return sentences;
	}
	//setter arraylist(string)
	public void setSentences(ArrayList<String> sentences) {
		this.sentences = sentences;
	}

	// getter for array list image
	public ArrayList<Image> getImageFiles() {
		return imageFiles;
	}

	// setter for array list image
	public void setImageFiles(ArrayList<Image> imageFiles) {
		this.imageFiles = imageFiles;
	}

	// constructor
	public Story() {
		this.imageFiles = new ArrayList<Image>();
		this.sentences = new ArrayList<String>();
	}


	// getter Image
	public Image getImage() {
		return image;
	}

	// setter Image
	public void setImage(Image image) {
		this.image = image;
	}
	//load images
	public void loadeImage() {
		// if it is story 1 load else load story2
		if (MainController.check == 1) {
			File file = new File("Data/story1");
			File[] files = file.listFiles();
			Arrays.sort(files);
			for (File f : files) {

				if (!f.getName().equals("story.txt") && !f.getName().equals(".DS_Store")) {
					this.image = new Image(f.toURI().toString());
					this.imageFiles.add(image);
				}
			}
			System.out.println("file length="+files.length);
		} else if (MainController.check == 2) {
			File file = new File("Data/story2");
			File[] files = file.listFiles();
			Arrays.sort(files);
			for (File f : files) {
				if (!f.getName().equals("story.txt") && !f.getName().equals(".DS_Store")) {
					this.image = new Image(f.toURI().toString());
					this.imageFiles.add(image);
				}
			}
			System.out.println("files length="+files.length);
		}
	}
	//load contents
	public void loadeContents() throws FileNotFoundException {
		//if story1 or stroy2
		if (MainController.check == 1) {
			File file = new File("Data/story1/story.txt");
			Scanner scan = new Scanner(file);
			while (scan.hasNextLine()) {
				String line = scan.nextLine();
				String[] token = line.split("[0-9]: ");
				this.sentences.add(token[1]);

			}
		} else if (MainController.check == 2) {
			File file = new File("Data/story2/story.txt");
			Scanner scan = new Scanner(file);
			while (scan.hasNextLine()) {
				String line = scan.nextLine();
				String[] token = line.split("[0-9]: ");
				this.sentences.add(token[1]);

			}
		}
	}
	//getter for timer
	public int getTimer() {
		return timer;
	}
	//setter for timer
	public void setTimer(int timer) {
		this.timer = timer;
	}

}
