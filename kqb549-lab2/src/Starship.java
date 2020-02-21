import java.util.ArrayList;
/**
 * Starship contains all crewmember
 * kqb549
 * @author huaweisun
 *
 */
public class Starship {
//	A name, represented as a String (i.e.: USS Enterprise)
//	A registry, represented as a String (i.e.: NCC-1701-A)
//	A class, represented as a String (i.e.: Constitution)
//	An array of CrewMember objects, with a maximum capacity of 10.
//	A toString() method which returns a String representation of all crew members in the Starship
	private String name;
	private String registry;
	private String clas;
	//need a dynamic arraylist for crewmembers
	private ArrayList<CrewMember> crewmeber;
	public String getName() {
		return name;
	}
	//setter for name
	public void setName(String name) {
		this.name = name;
	}
	//getter for clas
	public String getClas() {
		return clas;
	}
	//setter clas
	public void setClas(String clas) {
		this.clas = clas;
	}
	/**
	 * getter for crewmeber which give
	 * you all the crewmeber in arraylist
	 * @returnV
	 */
	public ArrayList<CrewMember> getCrewmeber() {
		return crewmeber;
	}
	//set for crewmeber
	public void setCrewmeber(ArrayList<CrewMember> crewmeber) {
		this.crewmeber = crewmeber;
	}
	
	public Starship(String nameEnterpise, String registryNum, String Class) {
		//set all the variables
		this.name=nameEnterpise;
		this.registry=registryNum;
		this.clas=Class;
		this.crewmeber = new ArrayList<CrewMember>();
	}
	//setter for CrewMember
	public void setCrewMember(ArrayList<CrewMember> crewmeber) {
		this.crewmeber=crewmeber;	
	}
	//getter for CrewMember
	public ArrayList<CrewMember> getCrewMembers() {
		return this.crewmeber;
	}
	//adding and count number of crew
	public void addCrewMember(CrewMember crewmemmber) {
		this.crewmeber.add(crewmemmber);
		}
	//remove which remove a crewmember for crewmber
	public void removeCrewMember(CrewMember crewmeber)
	{
		this.crewmeber.remove(crewmeber);
	}
	//getter for registry
	public String getRegistry() {
		return registry;
	}
	//setter for registy
	public void setRegistry(String registry) {
		this.registry = registry;
	}
	//using to string to print all the information
	//need a loop to loop thru all crewmember
	public String toString() {
		String ret = "";
		ret+=this.name;
			ret+="["+this.registry+"]";
			ret+=" Class: "+this.clas+" crew: "+this.crewmeber.size()+"\n";
			for(int i=0; i<crewmeber.size(); i++)
			{
				ret+=""+this.crewmeber.get(i).toString()+"\n";
			}
		
		return ret;
	}


}
