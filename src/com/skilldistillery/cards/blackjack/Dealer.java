package com.skilldistillery.cards.blackjack;

public class Dealer extends Player {
	Deck deck = new Deck();
	
	public Dealer(String name, Hand hand) {
		// Licensed dealers in developed countries don't need stackSize. They always cover the players.
		super(name, hand);
	}
	
	public Dealer() {
		// for testing
	}
	
	public void dealHand(Deck deck) {
		Card card1 = deck.dealCard();
		Card card2 = deck.dealCard();
	}

}
