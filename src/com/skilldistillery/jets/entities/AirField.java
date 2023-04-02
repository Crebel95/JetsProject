package com.skilldistillery.jets.entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AirField {

	private List<Jet> fleet;

	public AirField() {
		fleet = readFromFile("jets.txt");
	}

	public List<Jet> readFromFile(String fn) {
		List<Jet> jets = new ArrayList<>();

		try (BufferedReader bufIn = new BufferedReader(new FileReader(fn))) {
			String aJet;
			while ((aJet = bufIn.readLine()) != null) {

				String[] jetDetails = aJet.split(",");

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
	
	public void removeJet() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Remove a Jet by entering its Jet number: ");
		printFleet();
		int userSelection = sc.nextInt();
		
		if (userSelection >= 1 && userSelection <= fleet.size()) {
			fleet.remove(userSelection - 1);
			System.out.println("Jet number " + userSelection + " has been removed from the fleet.");
		}
		else {
			System.out.println("The number entered is invalid.");
		}
		
		
		
	}

}