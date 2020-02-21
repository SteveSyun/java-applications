package application.model;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.scene.control.TextArea;

/**
 * School.java
 * @author huaweisun
 * 
 * 
 * 
 * To be initialized, a School object must have a name.
In addition, every School has an ArrayList of House objects.
In this lab, every school will have only 4 houses. 
The School will be the access point for the data in the
 remainder of the app. The controller will call on methods
  in the School to access house names, student information,
   and to load 
& save data in the files.
 */

public class School {
	private String name;
	ArrayList<House> house;
	//construct
	public School(String name) {
			this.name=name;
			this.house=new ArrayList<House>();
		// TODO Auto-generated constructor stub
	}
	//getter array for house
	public ArrayList<House> getHouse() {
		return this.house;
	}
	//setter array for house arraylist
	public void setHouse(ArrayList<House> house) {
		this.house = house;
	}
	//getter a name
	public String getName() {
		return name;
	}
	//setter a name
	public void setName(String name) {
		this.name = name;
	}
	//addhouse is using for add house into
	public void addhouse(House name)
	{
		this.house.add(name);
	}
	//loadhouse will load info from file.csv and add into house
	// add split the file into student array list 
	public void loaddhouse(String Filename)throws IOException{
		House house1= new House(Filename);
//		this.addhouse(house);
		this.addhouse(house1);
		File file=new File(Filename);
		Scanner scan=new Scanner(file);
		while(scan.hasNextLine())
		{
			String line=scan.nextLine();
			String[] tokens=line.split(",");
			if(Integer.parseInt(tokens[1].replaceAll(" ", ""))>=1 && Integer.parseInt(tokens[1].replaceAll(" ", ""))<=7) {
				Student student=new Student(tokens[0],tokens[1]);
				house1.addstudent(student);
			}
			else {
				
				System.out.println("year error, check year");
			}
			
		}
	}
	//save function is save your edition back to datafile 
	public void save(TextArea textarea, int i)throws IOException
	{
		String[] token;
		{
			//use a house0 construction get the info
			//from house we save it
			House house0=house.get(i);
			File file= new File(house0.getName().toString());
			//System.out.println(house0.getName());
			//this will write the file
			FileWriter printer=new FileWriter(file);
			for (String line : textarea.getText().split("\\n"))
			{
				token = line.split(" ", 2);
				//token = line.split("-",2);
				if(Integer.parseInt(token[0].replaceAll(" ", ""))>=1 && Integer.parseInt(token[0].replaceAll(" ", ""))<=7){
					printer.write(token[1]+","+token[0].replaceAll(" ", "")+"\n");
				}else {
					System.out.println("You make error modificaion\n");
				}
			}
			printer.close();
		}
		
//		ArrayList<Student> studentslist= house0.getStudent();
//		for(Student student : studentslist)
//		{
//			printer.write(student.getName()+","+student.getYears()+"\n");
//			
//		}
	
	}
}