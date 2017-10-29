package com.skilldistillery.cards.blackjack;

import java.util.ArrayList;
import java.util.List;

public class Hand {
	private List<Card> hand = new ArrayList<>();
	
	public Hand() {};
	
	public void addCard(Card card) {
		hand.add(card);
	}
	
	public void clearHand() {
		hand.clear();
	}

	public List<Card> getHand() {
		return hand;
	}
	
	public int getValueOfHand() {
		// Add multiple values for Aces
		// Liked this solution the most: https://github.com/HunterKir/BlackJackProject/blob/master/src/com/skilldistillery/cards/blackjack/Hand.java
		int hv = 0;
		int aces = 0;
		for (Card card : hand) {
			hv += card.getRank().getValue();
			if (card.getRank().getValue() == 11);
				aces++;
		}
		while (aces > 0) {
			if (hv > 21) {
				hv -= 10;
			}
			aces--;
		}
		return hv;
	}

	public Hand(List<Card> hand) {
		this.hand = hand;
	}

	@Override
	public String toString() {
		return "" + hand;
	}
	
	
}
