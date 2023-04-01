package com.skilldistillery.jets.app;

import com.skilldistillery.jets.entities.AirField;

public class JetsApplication {

	public static void main(String[] args) {
		JetsApplication ja = new JetsApplication();
		ja.launch();
		

	}
	
	public void launch() {
		AirField af = new AirField();
	
	}
	
	public void menu() {
		
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
	}

}
