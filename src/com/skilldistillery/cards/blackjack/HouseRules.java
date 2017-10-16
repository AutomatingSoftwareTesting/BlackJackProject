package com.skilldistillery.cards.blackjack;

public class HouseRules {
	public void instructions() {
		// Is there a way I can divide this out from main?
		String dName = "";
		
		System.out.println("Welcome to the Skill Distillery Blackjack room; the dealer, " + dName + " said.");
		System.out.println("The limits for this table range from $1 to $20; in increments of $1.");
		System.out.println("I will stand on hands totaling 17 and above; including 'soft' 17s. Obviously, this rule favors the house.");
		System.out.println("However, you are not allowed to buy insurance; which actually favors you as the player.");
		// Requirement #3: If a player or dealer is dealt 21 the game is over. Otherwise the player can choose to hit or stay.
		System.out.println("Therefore, if someone gets 21 (blackjack) with their first two cards they immdediately win the game.");
		// Requirement #5: The game is immediately over if either player gets above 21.
		System.out.println("Finally, if someone goes over 22 at any point they immdediately lose the game.");
		System.out.println("Good luck and have fun." + "\n");
	}

}
