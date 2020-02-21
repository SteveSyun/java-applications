/**
 * crewmebers
 * kqb549
 * @author huaweisun
 *
 */
public class CrewMember {
	//a name represented as a String (i.e James T. Kirk)
  private String name;
  //A position, represented as a String (i.e. Commanding Officer)
  private String commaname;
 //rank (ie. Lieutenant)
  private String rank;
  //species of personnel (i.e Klingon or Human
  private String species;
  
  //getter for name
  public String getName() {
	return name;
}
  //setter for name
public void setName(String name) {
	this.name = name;
}

	//getter for the commender
public String getCommaname() {
	return commaname;
}
	//setter for the commender
public void setCommaname(String commaname) {
	this.commaname = commaname;
}

//getter for rank
public String getRank() {
	return rank;
}
//setter for rank
public void setRank(String rank) {
	this.rank = rank;
}
//getter for species
public String getSpecies() {
	return species;
}
//setter for species
public void setSpecies(String species) {
	this.species = species;
}
  //A toString() method which returns a String
  //representation of all CrewMembers in the Starship
  public CrewMember(String name,String commander, String rank, String registry,String species)
  {
	  this.commaname=commander;
	  this.name=name;
	  this.rank=rank;
	  this.species=species;
  }
  //to print all infor parameters
  public String toString() {
	  String ret= " ";
	  ret+="  -"+this.name+",";
	  ret+=" "+this.commaname;
	  ret+=" "+this.rank;
	  ret+=" ("+this.species+")";
	return ret;
  }

  
}
