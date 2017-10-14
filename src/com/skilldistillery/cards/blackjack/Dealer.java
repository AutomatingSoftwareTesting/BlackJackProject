package com.skilldistillery.cards.blackjack;

public class Dealer extends Player {
	Deck deck;
	
	// Licensed dealers in developed nations don't need stack size. They always cover all of the players.
	public Dealer() {
		super();
		deck = new Deck();
		deck.shuffleDeck();
	}
	
	public Card getCard() {
		Card card = deck.dealCard();
		return card;
	}

}
