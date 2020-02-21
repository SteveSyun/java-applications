	package application.model;

import java.util.ArrayList;
/**
 * @author huaweisun 
 *
 *
 *
 * A House object must have a name as well,
 *  and each House has an ArrayList of Student objects.
	There is no limit on the number of students in a house.
 */


public class House {
	private String name;
	private ArrayList<Student> student;
	public House(String name)
	{
		this.name=name;
		this.student= new ArrayList<Student>();		
	}
	//getter name
	public String getName() {
		return name;
	}
	//setter name
	public void setName(String name) {
		this.name = name;
	}
	//getter for arraylist student
	public ArrayList<Student> getStudent() {
		return student;
	}
	//setter for arraylist srudent
	public void setStudent(ArrayList<Student> student) {
		this.student = student;
	}
	//addstudent using for adding student into stdent arraylist
	public void addstudent(Student student)
	{
		this.student.add(student);
	}
}
