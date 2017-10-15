package com.skilldistillery.cards.blackjack;

public class Game {
	public void play() {
		// Create a new dealer and describe the rules at this casino
		Dealer d = new Dealer();
		String dName = d.getRandomName();
		System.out.println("Welcome to the Skill Distillery Blackjack room; the dealer, " + dName + " said.");
		houseRules();
		
		// Create a new player. 
		// In future, add option to allow more than one player vs. dealer.
		Player p = new Player();
		String pName = p.getRandomName();
		int pStackSize = p.getRandomStackSize();
		Card card;
		
		System.out.println(pName + ", the player in the first seat, has $" + pStackSize + ".");
		System.out.println(pName + " decides to bet $" + p.placeRandomBet() + "." + "\n");
		
		// Player gets dealt first card; which is added to their hand
		card = d.getCard();
		p.playerHand(card);
		
		// Dealer gets dealt first card; which is added to their hand (different than the players)
		card = d.getCard();
		d.dealerHand(card);
		
		// Player gets dealt second card
		card = d.getCard();
		p.playerHand(card);
		
		// Dealer gets dealt a second card face down
		// For now, moving below (or pretending we are NOT playing in US)
		// Dealer gets dealt second card
		card = d.getCard();
		d.dealerHand(card);
		
		System.out.println(pName + " is dealt " + p.getHand().toString() + " for a total of " + p.getHand().getValueOfHand() + ".");
		System.out.println(dName + ", the dealer, is showing a " + d.getHand().toString() + " for a total of " + d.getHand().getValueOfHand() + ".");
		
		
		System.out.println(pName + " what do you want to do? ('H' = Hit, 'S' = Stand)":);
	
		
	}
	
	public void houseRules() {
		// The rules below may change as the game evolves.
		System.out.println("The limits for this table range from $1 to $20; in increments of $1.");
		System.out.println("I will stand on hands totaling 17 and above; including 'soft' 17s. Obviously, this rule favors the house.");
		System.out.println("However, you are not allowed to buy insurance; which actually favors you as the player.");
		System.out.println("Therefore, if someone reaches 21 they immdediately win the game. Good luck and have fun." + "\n");
	}
	
}
