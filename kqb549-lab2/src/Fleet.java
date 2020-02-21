import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * fleet class contains 
 * all of the starships
 * 
 * @author huaweisun
 *	kqb549
 */
public class Fleet{
	//name holds the of starships
	private String name;
	//arraylist for startship
	private ArrayList<Starship> starship;
	
	
	public Fleet(String name) {
		this.name=name;
		//sign name to new arraylist to create new arraylist
		this.starship= new ArrayList<Starship>();
	}
	//getter name for federation
	public String getName() {
		return name;
	}
	//setter name for federation
	public void setName(String name) {
		this.name = name;
	}
	//getter for starship	
	public ArrayList<Starship> getStarship() {
		return starship;
	}
	//setter for starship
	public void setStarship(ArrayList<Starship> starship) {
		this.starship = starship;
	}

	//set starship array and for length
	public void setShips(ArrayList<Starship> starship)
	{
		this.starship=starship;
	
	}
	//adding startships
	public void addStarship(Starship enterprise)
	{
		//call add func to add starship
		this.starship.add(enterprise);
	}
	
	//to print federation
	public String toString() {
		String ret = ""
				 +this.name+"\n";
			ret+="-------------------------------------------------------"+"\n";
			//goes two ships and print two starship
		
			
			for(Starship item : starship)
				ret += item;
		return ret;
	}

	/**
	 * loadstarship read the files from data 
	 * and sperate each field
	 * and create new Starships array
	 * in the end add starship to fleet
	 * @param Filename
	 * @throws IOException
	 */
	public void loadStarships(String Filename)throws IOException{
		// TODO Auto-generated method stub

				File file=new File(Filename);
				Scanner scan = new Scanner(file);
				while(scan.hasNextLine()) {
				String line = scan.nextLine();
				String[] tokens=line.split(",");
				Starship ships= new Starship(tokens[0], tokens[1], tokens[2]);
				
				this.addStarship(ships);
				
		}

		
				scan.close();
	}
	/**
	 * loadCrew will load the crew number to starship
	 * read files from data of personnel
	 * and sperate into field
	 * and using a loop to check 
	 * if they are in the same registry
	 * if same we add
	 * in the end we closed the field
	 * @param Filename
	 * @throws IOException
	 */
	public void loadCrew(String Filename)throws IOException {
		// TODO Auto-generated method stub
		File file=new File(Filename);
		Scanner scan = new Scanner(file);
		while(scan.hasNextLine()) {
		String line = scan.nextLine();
		String[] tokens=line.split(",");
		CrewMember crewmemmber= new CrewMember(tokens[0], tokens[1], tokens[2],tokens[3],tokens[4]);
		for(int i=0; i<starship.size(); i++)
		{
			if(starship.get(i).getRegistry().equals(tokens[3]))
				starship.get(i).addCrewMember(crewmemmber);
		}
	} 
		scan.close();
	}
	/**
	 * ressgin a crewnummber into a new registry
	 * tmp = //save the crewmember we need to remove
	 * so we won lost it 
	 * need two loop to access crewmember
	 * and tmp sign to that crewmember 
	 * then remove it
	 * 
	 * 
	 * to add back to new registry just 
	 * need a loop thru and equal to same registry
	 *then add
	 * @param name
	 * @param registry
	 */
	public void reassign(String name, String registry)
	{
		
		CrewMember tmp = null;
		for(int i=0; i<starship.size(); i++)
		{
			for(int j=0; j<starship.get(i).getCrewMembers().size(); j++)
			if(starship.get(i).getCrewMembers().get(j).getName().equals(name)) {
				tmp=starship.get(i).getCrewMembers().get(j);
				starship.get(i).getCrewMembers().remove(j);	
				}
		}
		for(int i=0; i<starship.size(); i++)
		{
			if(starship.get(i).getRegistry().equals(registry))
				starship.get(i).addCrewMember(tmp);
		}
	}
	/**
	 * save fun will save all the output into a csv file 
	 * which need to use write into a csv
	 * in the end closed filed
	 * @throws IOException
	 */
	public void save() throws IOException
	{
		File file=new File("data/fleet2.csv");
		FileWriter printer= new FileWriter(file);
		Starship tmp;
		for(int k=0; k<starship.size(); k++)
		{
			tmp=starship.get(k);
			printer.write(tmp.getName()+","+tmp.getRegistry()+","+tmp.getClas()+"\n");
		
		}
		printer.close();
		File file1=new File("data/personnel2.csv");
		FileWriter printer1 = new FileWriter(file1);
		CrewMember tmp1;
		for(int i=0; i<starship.size(); i++)
		{
			for(int j=0; j<starship.get(i).getCrewMembers().size(); j++)
			{
				tmp1=starship.get(i).getCrewmeber().get(j);
				printer1.write(tmp1.getName()+","+tmp1.getCommaname()+","+tmp1.getRank()+","+tmp1.getSpecies()+"\n");
				
			}
		}
		printer1.close();
	}
}