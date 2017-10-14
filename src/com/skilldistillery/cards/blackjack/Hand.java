package com.skilldistillery.cards.blackjack;

import java.util.ArrayList;
import java.util.List;

public class Hand {
	private List<Card> hand = new ArrayList<>();
	
	public void addCard(Card card) {
		hand.add(card);
	}

	public List<Card> getHand() {
		return hand;
	}
	
	public int getValueOfHand() {
		int hv = 0;
		for (Card card : hand) {
			hv += card.getRank().getValue();
		}
		return hv;
	}

	public Hand(List<Card> hand) {
		this.hand = hand;
	}
	
	
}
