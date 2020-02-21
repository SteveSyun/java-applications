package application.controller;

//import java.awt.Label;
import java.io.IOException;
import java.util.ArrayList;

import application.model.House;
import application.model.School;
import application.model.Student;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
//import javafx.scene.control.Label;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
/**
 * MainController
 * @author huaweisun
 *
 */

public class MainController implements EventHandler<ActionEvent>{
	School school=new School("Hogwarts");
	
	@FXML 
	Label buttonLabel1;
	@FXML
	Label buttonLabel2;
	@FXML
	Label buttonLabel3;
	@FXML
	Label buttonLabel4;
	@FXML
	TextArea textarea;
	@FXML
	TextArea textarea1;
	@FXML
	TextArea textarea2;
	@FXML
	TextArea textarea3;
	
	
	
	@Override
	public void handle(ActionEvent event) {
		try {
			
			school.save(textarea, 0);
			school.save(textarea1, 1);
			school.save(textarea2, 2);
			school.save(textarea3, 3);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
		
			

	}
	// initialize the javafx
	@FXML
	void initialize()
	{
			// load the file and try catch error
		try {
			school.loaddhouse("data/Gryffindor.csv");
			school.loaddhouse("data/Hufflepuff.csv");
			school.loaddhouse("data/Ravenclaw.csv");
			school.loaddhouse("data/Slytherin.csv");
			//load student
//			school.loadStudent("data/Gryffindor.csv");
//			school.loadStudent("data/Hufflepuff.csv");
//			school.loadStudent("data/Ravenclaw.csv");
//			school.loadStudent("data/Slytherin.csv");
			
			//split the path and change to just a house name
			//(house1)
			String s = school.getHouse().get(0).getName();
			String[] arrofStr= s.split("/",2);
			String[] arrofStr1=arrofStr[1].split("\\.", 2);
			buttonLabel1.setText(arrofStr1[0]);
			
			//house2
			String s1 = school.getHouse().get(1).getName();
			String[] arrofStr2= s1.split("/",2);
			String[] arrofStr3=arrofStr2[1].split("\\.", 2);
			buttonLabel2.setText(arrofStr3[0]);
			
			//house3
			String s2 = school.getHouse().get(2).getName();
			String[] arrofStr4=s2.split("/", 2);
			String[] arrofStr5=arrofStr4[1].split("\\.", 2);
			buttonLabel3.setText(arrofStr5[0]);
			
			//house4
			String s3 = school.getHouse().get(3).getName();
			String[] arrofStr6=s3.split("/", 2);
			String[] arrofStr7=arrofStr6[1].split("\\.", 2);
			buttonLabel4.setText(arrofStr7[0]);
			
			//get student for different house and 
			//append to text area
			//house1 get student
			House tmp= school.getHouse().get(0);
			ArrayList<Student> studentList = tmp.getStudent();
			for (Student student: studentList) {
				textarea.appendText(student.getYears().toString()+" - "+student.getName().toString()+"\n");
			}
			
			//get student for different house and 
			//append to text area
			//house2 get student
			tmp= school.getHouse().get(1);
			ArrayList<Student>studentList1=tmp.getStudent();
			for (Student student: studentList1) {
				textarea1.appendText(student.getYears().toString()+" - "+student.getName().toString()+"\n");
			}
			
			//get student for different house and 
			//append to text area
			//house3 get student
			tmp= school.getHouse().get(2);
			ArrayList<Student>studentList2=tmp.getStudent();
			for (Student student: studentList2) {
				textarea2.appendText(student.getYears().toString()+" - "+student.getName().toString()+"\n");
			}
			
			//get student for different house and 
			//append to text area
			//house4 get student
			tmp=school.getHouse().get(3);
			ArrayList<Student>studentList3=tmp.getStudent();
			for (Student student: studentList3) {
				textarea3.appendText(student.getYears().toString()+" - "+student.getName().toString()+"\n");
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
