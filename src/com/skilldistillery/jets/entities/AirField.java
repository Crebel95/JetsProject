package com.skilldistillery.jets.entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AirField {
	//Only the airfield can talk to any jet on the airfield
	//lots of methods here
	
	private List<Jet> fleet;
	
	public AirField() {
		// populate its fleet from the file
	}

	public List<Jet> readFromFile(String fn) {      //something has to call the readFromFile
	List<Jet> jets = new ArrayList<>();
	
	// read in the various jet types from the file.
	try ( BufferedReader bufIn = new BufferedReader(new FileReader(fn)) ) {
		  String aJet;
		  while ((aJet = bufIn.readLine()) != null) {
			  // as you read in a Jet, create a Jet. //new
		   String[] jetDetails = aJet.split(",");    
		   //create the appropriate jet based on all the jet details.
		   //psy -- if the jet details in the first position happens to be a DCV, then create a dilithiumPowered jet
		   //psy -- if the jet details in the first position happens to be a fighter jet, then create a fighter jet
		  
		   //and add that specific jet to your jets list
			  
		  }
		}
		catch (IOException e) {
		  System.err.println(e);
		}
	//and add that specific Jet type to your Jet List.
	
	return jets;
}
}