package com.skilldistillery.cards.blackjack;

import java.util.List;

public class Hand {
	private List<Card> hand;
	
	public void addCard(Card card) {
		hand = card;
	}

	public List<Card> getHand() {
		// To do
		return hand;  // is this supposed to be Hand
	}
	
	public int getValueOfHand() {
		// To do
		return 0;
	}

	public Hand(List<Card> hand) {
		super();
		this.hand = hand;
	}
	
	
}
