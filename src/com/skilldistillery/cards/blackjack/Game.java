package com.skilldistillery.cards.blackjack;

public class Game {
	public void startSession() {
		System.out.println("Welcome to the Skill Distillery Blackjack room.");
		System.out.println("The dealer will stand on hands totaling 17 and above; including 'soft' 17.");
		System.out.println("The player is not allowed to buy insurance.");
		System.out.println("If either side reaches 21 they immdediately win the game.");
		System.out.println("The table limits are $5 to $20" + "\n");
		// The rules above may change as the game evolves. The first rule above favors the dealer; the second the player.
	}
	
	public void play() {
		Dealer d = new Dealer();
		Player p = new Player();
		String pName = p.getName();
		int pStackSize = p.getStackSize();
		Card card;
		
		System.out.println(pName + ", the player in the first seat, has $" + pStackSize + ".");
		System.out.println(pName + " decides to bet $" + p.placeWager() + "." + "\n");
		
		// Player gets dealt first card
		card = d.getCard();
		System.out.println(card);
//		p.addCard(card);
		
		// Dealer gets dealt first card
		card = d.getCard();
		System.out.println(card);
//		d.addCard(card);
//		
		// Player gets dealt second card
		card = d.getCard();
		System.out.println(card);
//		p.addCard(card);
//		
		// Dealer gets dealt second card
		// This will need to be face down eventually
		card = d.getCard();
		System.out.println(card);
//		d.addCard(card);
		
		
//		System.out.println("They are dealt " + playerCard1 + " and " + playerCard2 + ".");
//		System.out.println("For a hand total of: " + (playerCard1.getRank().getValue() + playerCard2.getRank().getValue()) + ".");
//		System.out.println(dName. + ", the dealer, is showing a " + dealerCard + ".");
//		System.out.println("With a value of: " + dealerCard.getRank().getValue() +".");
//		System.out.println(pName + " what do you want to do?");
	
		
//		System.out.println(pName + ", the player in the first seat, has $" + pStack + ".");
//		System.out.println(pName + " decides to bet $" + p.placeWager() + "." + "\n");
	}
}
