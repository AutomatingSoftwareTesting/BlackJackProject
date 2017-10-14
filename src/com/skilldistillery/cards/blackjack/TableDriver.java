package com.skilldistillery.cards.blackjack;

public class TableDriver {
	public static void main(String[] args) {
		Dealer d = new Dealer("Jason");
		Player p = new Player("Bob");
		Deck deck = new Deck();
		
		deck.shuffleDeck();
		Card playerCard1 = deck.dealCard();
		Card dealerCard = deck.dealCard();
		Card playerCard2 = deck.dealCard();
		
		System.out.println(p.getName() + ", is dealt " + playerCard1 + " and " + playerCard2 + ".");
		System.out.println("For a hand total of: " + (playerCard1.getRank().getValue() + playerCard2.getRank().getValue()) + ".");
		System.out.println(d.getName() + ", the dealer, is showing a " + dealerCard + ".");
		System.out.println("With a value of: " + dealerCard.getRank().getValue() +".");
		System.out.println(p.getName() + " what do you want to do?");
	}
}
