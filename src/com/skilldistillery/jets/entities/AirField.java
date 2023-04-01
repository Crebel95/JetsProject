package com.skilldistillery.jets.entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AirField {

	// Only the airfield can talk to any jet on the airfield
	// lots of methods here

	private List<Jet> fleet;

	public AirField() {
		// populate its fleet from the file
		fleet = readFromFile("jets.txt");

	}

	public List<Jet> readFromFile(String fn) { // something has to call the readFromFile
		List<Jet> jets = new ArrayList<>();

		// read in the various jet types from the file.
		try (BufferedReader bufIn = new BufferedReader(new FileReader(fn))) {
			String aJet;
			while ((aJet = bufIn.readLine()) != null) {
				// as you read in a Jet, create a Jet. //new
				String[] jetDetails = aJet.split(",");
				// create the appropriate jet based on all the jet details.
				// psy -- if the jet details in the first position happens to be a DCV, then
				// create a dilithiumPowered jet
				// psy -- if the jet details in the first position happens to be a fighter jet,
				// then create a fighter jet

				// and add that specific jet to your jets list
				String type = jetDetails[0];
				String model = jetDetails[1];
				double speed = Double.parseDouble(jetDetails[2]);
				int range = Integer.parseInt(jetDetails[3]);
				long price = Long.parseLong(jetDetails[4]);

				if (type.equals("UAV")) {

					Jet newJet = new UAV(model, speed, range, price);
					jets.add(newJet);
				}
				if (type.equals("SpacePlane")) {
					Jet newJet = new SpacePlane(model, speed, range, price);
					jets.add(newJet);
				}
				if (type.equals("FighterJet")) {
					Jet newJet = new FighterJet(model, speed, range, price);
					jets.add(newJet);
				}
				if (type.equals("PassengerPlane")) {
					Jet newJet = new PassengerPlane(model, speed, range, price);
					jets.add(newJet);
				}
				if (type.equals("CargoPlane")) {
					Jet newJet = new CargoPlane(model, speed, range, price);
					jets.add(newJet);
				}

			}
		} catch (IOException e) {
			System.err.println(e);
		}

		return jets;
	}

	public void printFleet() {
		for (Jet jets : fleet) {
			System.out.println(jets.toString());
		}
	}

	public void flyFleet() {
		for (Jet jets : fleet) {
			System.out.println(jets.fly());
		}
	}

	public void viewFastest() {

		double highest = 0.0;
		Jet fastest = null;

		for (Jet jet : fleet) {
			if (jet.getSpeed() > highest) {
				highest = jet.getSpeed();
				fastest = jet;
			}
		}
		System.out.println(fastest);
	}

	public void viewLongestRange() {
		double highest = 0.0;
		Jet longestRange = null;

		for (Jet jet : fleet) {
			if (jet.getRange() > highest) {
				highest = jet.getRange();
				longestRange = jet;
			}
		}
		System.out.println(longestRange);

	}

	public void loadCargoJets() {
		for (Jet jet : fleet) {
			if (jet instanceof CargoPlane) {
				CargoPlane cp = (CargoPlane) jet;
				cp.loadCargo();
			}
		}

	}

	public void activateFighterJets() {
		for (Jet jet : fleet) {
			if (jet instanceof FighterJet) {
				FighterJet cp = (FighterJet) jet;
				cp.fight();
			}
		}

	}

	public void addJet() {
		Scanner sc = new Scanner(System.in);
		System.out.println(
				"Enter the type of Jet you would like to add to the fleet (UAV, FighterJet, SpacePlane, PassengerPlane, or CargoPlane: ");
		String type = sc.nextLine();
		System.out.println("Enter the model of Jet: ");
		String model = sc.nextLine();
		System.out.println("Enter the Jet's speed: ");
		double speed = sc.nextDouble();
		System.out.println("Enter the Jet's range: ");
		int range = sc.nextInt();
		System.out.println("Enter the Jet's price: ");
		long price = sc.nextLong();

		if (type.equals("UAV")) {

			Jet newJet = new UAV(model, speed, range, price);
			fleet.add(newJet);
		}
		if (type.equals("SpacePlane")) {
			Jet newJet = new SpacePlane(model, speed, range, price);
			fleet.add(newJet);
		}
		if (type.equals("FighterJet")) {
			Jet newJet = new FighterJet(model, speed, range, price);
			fleet.add(newJet);
		}
		if (type.equals("PassengerPlane")) {
			Jet newJet = new PassengerPlane(model, speed, range, price);
			fleet.add(newJet);
		}
		if (type.equals("CargoPlane")) {
			Jet newJet = new CargoPlane(model, speed, range, price);
			fleet.add(newJet);
		}
		
	}

}