
public class Starship {
//	A name, represented as a String (i.e.: USS Enterprise)
//	A registry, represented as a String (i.e.: NCC-1701-A)
//	A class, represented as a String (i.e.: Constitution)
//	An array of CrewMember objects, with a maximum capacity of 10.
//	A toString() method which returns a String representation of all crew members in the Starship
	private String name;
	private String registry;
	private String clas;
	private CrewMember [] crewmeber;
	//numofcrews to count crewMember
	private int numbofcrew;
	
	public Starship(String nameEnterpise, String registryNum, String Class) {
		//set all the variables
		this.name=nameEnterpise;
		this.registry=registryNum;
		this.clas=Class;
		this.numbofcrew=0;
		this.crewmeber = new CrewMember[10];
	}
	//setter for CrewMember
	public void setCrewMember(CrewMember[] crewmeber) {
		this.crewmeber=crewmeber;
		this.numbofcrew=crewmeber.length;
		
	}
	//getter for CrewMember
	public CrewMember[] getCrewMembers() {
		return this.crewmeber;
	}
	//adding and count number of crew
	public void addCrewMember(CrewMember crewmeber) {
		this.crewmeber[numbofcrew]=crewmeber;
		this.numbofcrew++;
	}
	//using to string to print all the information
	//need a loop to loop thru all crewmember
	public String toString() {
		String ret = "";
		ret+=this.name+"(";
			ret+=""+this.registry+")";
			ret+="\n[class:"+this.clas+"]"+"\n";
		for(int i =0; i<numbofcrew; i++)
		{
			ret+=this.crewmeber[i].toString()+" \n";
			
			
		}
		
		return ret;
	}
}
