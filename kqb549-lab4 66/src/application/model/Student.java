package application.model;
/**
 * 
 * @author huaweisun
 *
 *
 *  A Student object must have a name and a year. 
 * The year indicates their progress through the school
 *  - incoming students are in year 1, 
 *  second year students are year 2, and so on.
 *  Valid years for students include 1 through 7.
 */

public class Student {
	private String name;
	private String years;
	public Student(String name, String years) {
		// TODO Auto-generated constructor stub
		this.name=name;
		this.years=years;
	}
	//getter for name
	public String getName() {
		return name;
	}
	//setter for name
	public void setName(String name) {
		this.name = name;
	}
	//getter for years
	public String getYears() {
		return years;
	}
	//setter for year
	public void setYears(String years) {
		this.years = years;
	}
}
