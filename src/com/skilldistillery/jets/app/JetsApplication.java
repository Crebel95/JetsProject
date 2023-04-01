package com.skilldistillery.jets.app;

import java.util.Scanner;

import com.skilldistillery.jets.entities.AirField;
import com.skilldistillery.jets.entities.Jet;

public class JetsApplication {

	public static void main(String[] args) {
		JetsApplication ja = new JetsApplication();
		ja.launch();

	}

	public void launch() {
		menu();

	}

	public void menu() {
		AirField af = new AirField();
		Scanner sc = new Scanner(System.in);

		int selection;
		boolean running = true;

		while (running) {

			System.out.println("Welcome to the Main Menu. Please select an option from the list below: ");
			System.out.println(" ");
			System.out.println("--------Main Menu-------");
			System.out.println(" ");
			System.out.println("1. List Fleet ");
			System.out.println("2. Fly all jets ");
			System.out.println("3. View the fastest jet ");
			System.out.println("4. View jet with longest range ");
			System.out.println("5. Load all Cargo Jets ");
			System.out.println("6. Deploy Fighter Jets ");
			System.out.println("7. Add a new jet to the fleet ");
			System.out.println("8. Remove a jet from the fleet ");
			System.out.println("9. Exit program ");

			selection = sc.nextInt();

			if (selection == 1) {
				af.printFleet();
			}

			if (selection == 2) {
				af.flyFleet();
			}
			if (selection == 3) {
				af.viewFastest();
			}

			if (selection == 4) {
				af.viewLongestRange();
			}
			if (selection == 5) {
				// load all cargo jets
			}

			if (selection == 6) {
				// deploy fighter jets
			}
			if (selection == 7) {
				//// add jet to fleet
			}

			if (selection == 8) {
				// remove jet from fleet
			}
			if (selection == 9) {
				// quit
			}

		}
	}

}
