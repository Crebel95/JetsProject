package com.skilldistillery.jets.entities;

public class FighterJet extends Jet implements CombatReady{
	
	public FighterJet(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}
	
	
	public void fight() {
		String activateFighters = "Now activating Fighter Jets!";
		System.out.println(activateFighters);
		
	}
 	

}
