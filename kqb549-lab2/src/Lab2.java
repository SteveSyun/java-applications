import java.io.IOException;
/**
 * kqb549
 * main function use to call
 * loadstar
 * loadcrew
 * reassgin
 * save
 * @author huaweisun
 *
 */
public class Lab2 {	
  	public static void main( String[] args ) {	
     	Fleet federation = new Fleet( "United Federation of Planets" );	

     	try{	
/**
 * loadstarships will load all the ships from fleet
 * loadCrew will load all the crew from personel
 * save function will save my output 
 */
        	federation.loadStarships( "data/fleet.csv" );	
        	federation.loadCrew( "data/personnel.csv" );	
        	federation.reassign("James T. Kirk", "NCC-71805");
        	federation.reassign("Spock", "NCC-1941");
        	federation.save();

     	}catch( IOException e ) {	
        	System.out.println( "Error loading the file - please check its location." );	
        	e.printStackTrace();	
     	}	

     	System.out.println( federation );	
  	}	
}	
