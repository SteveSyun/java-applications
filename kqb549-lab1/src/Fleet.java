
public class Fleet{
	private String name;
	private Starship[] starship;
	private int numofships;
	
	
	public Fleet(String name) {
		this.name=name;
		this.numofships=0;
		this.starship= new Starship[3];
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
	public Starship[] getStarship() {
		return starship;
	}
	//setter for starship
	public void setStarship(Starship[] starship) {
		this.starship = starship;
	}
	// getter numofship
	public int getNumofships() {
		return numofships;
	}
	//setter for numofships
	public void setNumofships(int numofships) {
		this.numofships = numofships;
	}

	//set starship array and for length
	public void setShips(Starship[] starship)
	{
		this.starship=starship;
		this.numofships=starship.length;
	}
	//adding startships
	public void addStarship(Starship enterprise)
	{
		//inside need to count numofship
		this.starship[numofships]= enterprise;
		numofships++;	
	}
	
	//to print federation
	public String toString() {
		String ret = "";
		ret+="-------------------------------------------------------"+"\n"
				 +this.name+"\n";
			ret+="-------------------------------------------------------"+"\n\n";
			//goes two ships and print two starship
		for(int i =0; i<numofships; i++)
		{
			
			ret+=starship[i].toString()+" \n";
			if(i<=0)
				ret+="- - - - - - - - - - - - - - - - - - - - - - - - - - - - "+"\n";
			
		}

		return ret;
	}

	
	
	
	
	//main function
	public static void main( String[] args ) { 
		
		//intializing 
		Fleet federation = new Fleet( "United Federation of Planets" ); 
		Starship enterpriseA = new Starship( "USS Enterprise", "NCC-1701-A", "Constitution" ); 
		Starship enterpriseD = new Starship( "USS Enterprise", "NCC-1701-D", "Galaxy" );

		CrewMember jamesKirk = new CrewMember( "James T. Kirk", "Commanding Officer" ); 
		CrewMember spock = new CrewMember( "Spock", "First Officer" ); 
		CrewMember leonardMcCoy = new CrewMember( "Leonard McCoy", "Chief Medical Officer" ); 
		CrewMember montgomeryScott = new CrewMember( "Montgomery Scott", "Chief Engineering Officer" ); 
		CrewMember jeanLucPicard = new CrewMember( "Jean-Luc Picard", "Commanding Officer" ); 
		CrewMember williamRiker = new CrewMember( "William T. Riker", "First Officer" ); 
		CrewMember beverlyCrusher = new CrewMember( "Beverly Crusher", "Chief Medical Officer" ); 
		CrewMember geordiLaForge = new CrewMember( "Geordi La Forge", "Chief Engineering Officer" ); 
		//two enterprise
		enterpriseA.addCrewMember( jamesKirk ); 
		enterpriseA.addCrewMember( spock ); 
		enterpriseA.addCrewMember( leonardMcCoy ); 
		enterpriseA.addCrewMember( montgomeryScott ); 
		enterpriseD.addCrewMember( jeanLucPicard ); 
		enterpriseD.addCrewMember( williamRiker ); 
		enterpriseD.addCrewMember( beverlyCrusher ); 
		enterpriseD.addCrewMember( geordiLaForge ); 
		//add ships
		federation.addStarship( enterpriseA ); 
		federation.addStarship( enterpriseD ); 
		
		System.out.println( federation ); 
		} 

}
