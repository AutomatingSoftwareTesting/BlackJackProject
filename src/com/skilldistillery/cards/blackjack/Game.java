package com.skilldistillery.cards.blackjack;

import java.util.Scanner;

public class Game {
	public void play() {
		Scanner sc = new Scanner(System.in);
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
		
		// Dealer will get dealt a second card face down
		// For now is below the next couple lines of logic
		
		System.out.println(pName + " is dealt " + p.getHand().toString() + " for a total of " + p.getHand().getValueOfHand() + ".");
		System.out.println("The dealer, is showing a " + d.getHand().toString() + " for a total of " + d.getHand().getValueOfHand() + ".");
		
		// Dealer gets dealt second card. This card is dealt before the player's additional cards are.
		card = d.getCard();
		d.dealerHand(card);
		
		// Add check for blackjack. Dealer checks first, then player.
		if (d.getHand().getValueOfHand() == 21) {
			System.out.println("The dealer has 21. Sorry, you lose");
		}
		else if (p.getHand().getValueOfHand() == 21){
			System.out.println("Congragulations " + pName + ", you win with blackjack.");
		}
		else {
			// Player hand logic
			while (p.getHand().getValueOfHand() < 22) {
				System.out.println(pName + " what do you want to do? ('H' = Hit, 'S' = Stand):");
				String pDecision = sc.nextLine().toUpperCase();
				
				if (pDecision.equals("H")) {
					card = d.getCard();
					p.playerHand(card);
					System.out.println(pName + " is dealt " + p.getHand().toString() + " for a total of " + p.getHand().getValueOfHand() + ".");
					if (p.getHand().getValueOfHand() > 21) {
						System.out.println("Sorry, " + pName + " busts and the dealer wins.");
						// Subtract bet size from stack size
					}
					p.getHand().getValueOfHand();
				}
				else {
					System.out.println(pName + " stands at " + p.getHand().getValueOfHand());
					break;
				}
			}
			
			// Dealer hand logic
			System.out.println("The dealer flips up their down card showing a hand of " + d.getHand() + " for a point total of " + d.getHand().getValueOfHand() + ".");
			
			while (d.getHand().getValueOfHand() < 17) {
				card = d.getCard();
				d.dealerHand(card);
				System.out.println("The dealer is dealt " + d.getHand().toString() + " for a total of " + d.getHand().getValueOfHand() + ".");
				if (d.getHand().getValueOfHand() > 21) {
					System.out.println("Congragulations, the dealer busts and " + pName + " wins.");
					// Add bet size to stack size
				}
				d.getHand().getValueOfHand();
			}
			System.out.println("The dealer stands at " + d.getHand().getValueOfHand());
		}
	}
	
	public void houseRules() {
		// The rules below may change as the game evolves.
		System.out.println("The limits for this table range from $1 to $20; in increments of $1.");
		System.out.println("I will stand on hands totaling 17 and above; including 'soft' 17s. Obviously, this rule favors the house.");
		System.out.println("However, you are not allowed to buy insurance; which actually favors you as the player.");
		System.out.println("Therefore, if someone reaches 21 they immdediately win the game. Good luck and have fun." + "\n");
	}
	
}
