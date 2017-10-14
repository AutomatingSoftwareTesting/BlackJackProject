package com.skilldistillery.cards.blackjack;

public class Game {
	public void startSession() {
		System.out.println("Welcome to the Skill Distillery Blackjack room.");
		System.out.println("The dealer will stand on hands totaling 17 and above; including 'soft' 17.");
		System.out.println("The player is not allowed to buy insurance. If either side reaches 21 they immdediately win the game." + "\n");
		// The rules above may change as the game evolves. The first rule above favors the dealer; the second the player.
	}
	
	public void Dealer() {
		Dealer d = new Dealer();
		Player p = new Player();
		String pName = p.getName();
		int pStack = p.getStackSize();
		String dName = d.getName();
		
		
		Deck deck = new Deck();
		deck.shuffleDeck();
		Card playerCard1 = deck.dealCard();
		Card dealerCard = deck.dealCard();
		Card playerCard2 = deck.dealCard();
		
		System.out.println(pName + ", the player in the first seat, has $" + pStack + ".");
		System.out.println(pName + " decides to bet $" + p.placeWager() + "." + "\n");
		System.out.println("They are dealt " + playerCard1 + " and " + playerCard2 + ".");
		System.out.println("For a hand total of: " + (playerCard1.getRank().getValue() + playerCard2.getRank().getValue()) + ".");
		System.out.println(dName + ", the dealer, is showing a " + dealerCard + ".");
		System.out.println("With a value of: " + dealerCard.getRank().getValue() +".");
		System.out.println(pName + " what do you want to do?");
	}
	
	public void Player() {
		Player p = new Player();
		
		System.out.println(p.getName() + ", the player in the first seat, has $" + p.getStackSize() + ".");
//		System.out.println("They are dealt " + playerCard1 + " and " + playerCard2 + ".");
	}
}
