package com.skilldistillery.cards.blackjack;

public class Dealer extends Player {

	public Dealer(String name, Hand hand, double stackSize) {
		super(name, hand, stackSize);
	}
	
	public Dealer(String name, Hand hand) {
		super(name, hand);
	}
	
	public Dealer(String name) {
		super(name);
	}

}
