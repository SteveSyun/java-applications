
public class CrewMember {
	//a name represented as a String (i.e James T. Kirk)
  private String name;
  private String commaname;
  //A position, represented as a String (i.e. Commanding Officer)
  public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getCommaname() {
	return commaname;
}
public void setCommaname(String commaname) {
	this.commaname = commaname;
}
  //A toString() method which returns a String
  //representation of all CrewMembers in the Starship
  public CrewMember(String commander, String name)
  {
	  this.commaname=commander;
	  this.name=name;
  }
  //to print all infor parameters
  public String toString() {
	  String ret= " ";
	  ret+="-"+""+this.name+":";
	  ret+=""+this.commaname;
	  
	return ret;
	  
  }
  
}
