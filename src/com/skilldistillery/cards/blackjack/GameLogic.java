package com.skilldistillery.cards.blackjack;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GameLogic {
	private Scanner sc = new Scanner(System.in);
	private Dealer d = new Dealer();
	private Player p = new Player();
	private String dName;
	private String pName;
	private int pStackSize;
	private Card card;
	private int pBet;
	private String pDecision;
	private boolean pBusts;
	private boolean dBusts;
	private boolean blackjack;
	private int tableMin = 1;
	private int tableMax = 20;
	
	public void startGame() {
		dealer();
		houseRules();
		player();
		
		do {
			d.shuffle();
			int b = playerBet();
			initialDeal();
			blackjackCheck();
			if (! blackjack) {
				playerHandLogic();
				dealerHandLogic();
			}
			handSummary(handWinner(b));
			p.removeCardsFromPlayerHand();
			d.removeCardsFromDealerHand();
		} while (pBet != 0);
		
		sc.close();
	}
	
	public void dealer() {
		// Requirement #1: Your program must NOT be contained in one procedural main(). You MUST design a OO class structure.
		dName = d.getRandomName();
	}
	
	public void houseRules() {
		// Describe the rules at this casino. The rules below may change as the game evolves.
		System.out.println("Welcome to the Skill Distillery Blackjack room; the dealer, " + dName + " said.");
		System.out.println("The limits for this table range from $" + tableMin + " to $" + tableMax + "; in increments of $" + tableMin + ".");
		System.out.println("I will stand on hands totaling 17 and above; including 'soft' 17s. Obviously, this rule favors the house.");
		System.out.println("However, you are not allowed to buy insurance; which actually favors you as the player.");
		// Requirement #3: If a player or dealer is dealt 21 the game is over. Otherwise the player can choose to hit or stay.
		System.out.println("Therefore, if someone gets 21 (blackjack) with their first two cards they immdediately win the game.");
		// Requirement #5: The game is immediately over if either player gets above 21.
		System.out.println("Finally, if someone goes over 21 at any point they immdediately lose the game.");
		System.out.println("You can leave the table at any time by entering a bet size of '0'. Good luck and have fun!");
	}
	
	public void player() {
		pName = p.getRandomName();
		pStackSize = p.getRandomStackSize();
	}
	
	public int playerBet() {
		System.out.println("\n" + pName + ", the player in the first seat, has $" + pStackSize + ".");
		int pBet = -1;
		try {
			while (pBet < (tableMin - 1) || pBet > tableMax) {
				System.out.print(pName + ", how much do you want to bet ($" + tableMin + " to $" + tableMax +")? ");
				pBet = sc.nextInt();
			}
		} catch (InputMismatchException e) {
			if(!sc.hasNextInt()) {
			    sc.next();
		    		System.out.println("Sorry " + pName + ", you didn't enter a whole number for your bet.");
		    		System.out.println("Therefore, you'll bet the table minimum for this hand.");
			}
			pBet = tableMin;
		}
		if (pBet == 0) {
			System.out.println("Thanks for playing " + pName + "! See you next time.");
			System.exit(1);
		}
		else {
			System.out.println(pName + " decides to bet $" + pBet + "." + "\n");
		}
		return pBet;
	}
	
	public void initialDeal() {
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
	}
	
	public void blackjackCheck() {
		// Add check for blackjack. Dealer checks first, then player.
		// Could add logic here later if we want to offer insurance 
		// It is in the player's best interest to decline.
		blackjack = false;
		if (d.getHand().getValueOfHand() == 21) {
			System.out.println("The dealer has blackjack (21). Sorry " + pName + ", you lose.");
			blackjack = true;
		}
		if (p.getHand().getValueOfHand() == 21){
			System.out.println("Congragulations " + pName + ", you win with blackjack.");
			blackjack = true;
		}
	}
	
	public void playerHandLogic() {
		pBusts = false;
		while (p.getHand().getValueOfHand() < 22) {
			System.out.print(pName + " what do you want to do? ('H' = Hit, 'S' = Stand): ");
			pDecision = sc.next().toUpperCase();
			// Player will stand on all input except for "H" or "h".
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
	}
	
	public void dealerHandLogic() {
		// Requirement #4: Once the player has completed their turn the dealer will begin their turn.
		dBusts = false;
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
	
	public int handWinner(int b) {
		pBet = b;
		// Determine winner and new stack size
		if (pBusts) {
			System.out.println("\n" + "Sorry, " + pName + ", you went over 21 and the dealer wins.");
			pStackSize -= pBet;
		}
		else if (dBusts) {
			System.out.println("\n" + "Congragulations " + pName + ", the dealer busts and you win!");
			pStackSize += pBet;
		}
		else if (p.getHand().getValueOfHand() == d.getHand().getValueOfHand()) {
			// Stack sizes don't change
			System.out.println("\n" + "It's a push (tie).");
		}
		else if (p.getHand().getValueOfHand() > d.getHand().getValueOfHand()) {
			System.out.println("\n" + "Congragulations " + pName + ", you win!");
			pStackSize += pBet;
		}
		else {
			System.out.println("\n" + "Sorry " + pName + ", the dealer wins.");
			pStackSize -= pBet;
		}
		return pStackSize;
	}
	
	public void handSummary(int s) {
		p.setStackSize(s);
		System.out.println(pName + "'s final hand was " + p.getHand().getHand() + "; a total of " + p.getHand().getValueOfHand() + ".");
		System.out.println("The dealer's final hand was " + d.getHand().getHand() + "; a total of " + d.getHand().getValueOfHand() + ".");
		System.out.println(pName + "'s new stack size is "  + p.getStackSize() + ".");
	}
}
