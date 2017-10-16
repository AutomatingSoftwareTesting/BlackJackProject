package com.skilldistillery.cards.blackjack;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GameDriver {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String dName;
		
		// Requirement #1: Your program must NOT be contained in one procedural main(). You MUST design a OO class structure.
		// Create a new dealer and describe the rules at this casino. The rules below may change as the game evolves.
		Dealer d = new Dealer();
		dName = d.getRandomName();
		System.out.println("Welcome to the Skill Distillery Blackjack room; the dealer, " + dName + " said.");
		System.out.println("The limits for this table range from $1 to $20; in increments of $1.");
		System.out.println("I will stand on hands totaling 17 and above; including 'soft' 17s. Obviously, this rule favors the house.");
		System.out.println("However, you are not allowed to buy insurance; which actually favors you as the player.");
		// Requirement #3: If a player or dealer is dealt 21 the game is over. Otherwise the player can choose to hit or stay.
		System.out.println("Therefore, if someone gets 21 (blackjack) with their first two cards they immdediately win the game.");
		// Requirement #5: The game is immediately over if either player gets above 21.
		System.out.println("Finally, if someone goes over 22 at any point they immdediately lose the game.");
		System.out.println("Good luck and have fun." + "\n");
		
		// Create a new player. 
		// In future, add option to allow more than one player vs. dealer.
		Player p = new Player();
		String pName = p.getRandomName();
		int pStackSize = p.getRandomStackSize();
		Card card;
		
		System.out.println(pName + ", the player in the first seat, has $" + pStackSize + ".");
		int pBet = 0;
		try {
			while (pBet < 1 || pBet > 20) {
				System.out.println("Please bet within the table limits.");
				System.out.println(pName + ", how much do you want to bet ($1 to $20)? ");
				pBet = sc.nextInt();
			}
		} catch (InputMismatchException e) {
			System.out.println("Please re-run the game and enter a whole number for the bet size.");
			System.exit(1);
		}
		System.out.println(pName + " decides to bet $" + pBet + "." + "\n");
		
		// Requirement #2: When the game begins both the player and dealer are dealt two cards.
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
		// Until isCardFaceUp() is working this is below the next couple lines of logic

		System.out.println(pName + " is dealt " + p.getHand().getHand() + " for a total of " + p.getHand().getValueOfHand() + ".");
		System.out.println("The dealer, is showing a " + d.getHand().getHand() + " for a total of " + d.getHand().getValueOfHand() + ".");
		
		// Dealer gets dealt second card. This card is dealt before the player's additional cards are.
		card = d.getCard();
		d.dealerHand(card);
		
		boolean pBusts = false;
		boolean dBusts = false;
		// Add check for blackjack. Dealer checks first, then player.
		if (d.getHand().getValueOfHand() == 21) {
			System.out.println("The dealer has blackjack (21). Sorry " + pName + ", you lose.");
		}
		else if (p.getHand().getValueOfHand() == 21){
			System.out.println("Congragulations " + pName + ", you win with blackjack.");
		}
		else {
			// Player hand logic
			while (p.getHand().getValueOfHand() < 22) {
				System.out.println(pName + " what do you want to do? ('H' = Hit, 'S' = Stand): ");
				String pDecision = sc.next().toUpperCase();
				
				if (pDecision.equals("H")) {
					card = d.getCard();
					p.playerHand(card);
					System.out.println(pName + " is dealt a " + card + " for a hand of " + p.getHand().getHand() + " totaling " + p.getHand().getValueOfHand() + ".");
					if (p.getHand().getValueOfHand() > 21) {
						pBusts = true;
						break;
					}
					p.getHand().getValueOfHand();
				}
				else {
					if (! pBusts) {
						System.out.println(pName + " stands at " + p.getHand().getValueOfHand());
					}
					break;
				}
			}
			// Requirement #4: Once the player has completed their turn the dealer will begin their turn.
			// Dealer hand logic
			System.out.println("The dealer flips up their down card showing a hand of " + d.getHand().getHand() + "; totaling " + d.getHand().getValueOfHand() + ".");
			
			if (! pBusts) {
				while (d.getHand().getValueOfHand() < 17) {
					card = d.getCard();
					d.dealerHand(card);
					System.out.println("The dealer is dealt a " + card + " for a hand of " + d.getHand().getHand() + " totaling " + d.getHand().getValueOfHand() + ".");
					if (d.getHand().getValueOfHand() > 21) {
						dBusts = true;
						break;
					}
					d.getHand().getValueOfHand();
				}
				if (! dBusts) {
					System.out.println("The dealer stands at " + d.getHand().getValueOfHand());
				}
			}
		}
		
		// Determine winner and new stack size
		if (pBusts) {
			System.out.println("\n" + "Sorry, " + pName + ", you went over 21 and the dealer wins.");
			// Subtract bet size from stack size
			pStackSize -= pBet;
		}
		else if (dBusts) {
			System.out.println("\n" + "Congragulations " + pName + ", the dealer busts and you win!");
			// Add bet size to stack size
			pStackSize += pBet;
		}
		else if (p.getHand().getValueOfHand() == d.getHand().getValueOfHand()) {
			System.out.println("\n" + "It's a push (tie).");
			// Stack sizes don't change
		}
		else if (p.getHand().getValueOfHand() > d.getHand().getValueOfHand()) {
			System.out.println("\n" + "Congragulations " + pName + ", you win!");
			// Add bet size to stack size
			pStackSize += pBet;
		}
		else {
			System.out.println("\n" + "Sorry " + pName + ", the dealer wins.");
			// Subtract bet size from stack size
			pStackSize -= pBet;
		}
		
		System.out.println(pName + "'s final hand was " + p.getHand().getHand() + "; a total of " + p.getHand().getValueOfHand() + ".");
		System.out.println("The dealer's final hand was " + d.getHand().getHand() + "; a total of " + d.getHand().getValueOfHand() + ".");
		System.out.println(pName + "'s new stack size is "  + pStackSize + ".");
		
		sc.close();
	}
}
