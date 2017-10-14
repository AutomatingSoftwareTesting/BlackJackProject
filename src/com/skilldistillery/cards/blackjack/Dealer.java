package com.skilldistillery.cards.blackjack;

public class Dealer extends Player {

	public Dealer(String name, Hand hand, double stackSize) {
		super(name, hand, stackSize);
	}
	
	public Dealer(String name, Hand hand) {
		// the dealer doesn't need stackSize. They always cover the players.
		super(name, hand);
	}
	
	public Dealer(String name) {
		// for testing
		super(name);
	}
	
	public Dealer() {
		// for testing
	}

}
