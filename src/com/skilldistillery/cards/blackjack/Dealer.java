package com.skilldistillery.cards.blackjack;

public class Dealer extends Player {
	private Deck deck;
	private Hand hand;
	
	// Licensed dealers in developed nations don't need stack size. They always cover all of the players.
	public Dealer() {
		super();
		deck = new Deck();
		hand = new Hand();
		deck.shuffleDeck();
	}
	
	public Deck shuffle() {
		deck.shuffleDeck();
		return deck;
	}
	
	public Card getCard() {
		Card card = deck.dealCard();
		return card;
	}
	
	public void dealerHand(Card card) {
		hand.addCard(card);
	}
	
	// Had to add in order to get hand value. Why didn't it extend from Player?
	public Hand getHand() {
		return hand;
	}
}
