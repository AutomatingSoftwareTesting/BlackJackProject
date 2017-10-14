package com.skilldistillery.cards.blackjack;

public class Player {
	private String name;
	private Hand hand;
	private double stackSize;
	
	public void placeWager(int wager) {
		// To do
	}

	public Player(String name, Hand hand, double stackSize) {
		super();
		this.name = name;
		this.hand = hand;
		this.stackSize = stackSize;
	}

	public String getName() {
		return name;
	}

	public Hand getHand() {
		return hand;
	}

	public double getStackSize() {
		return stackSize;
	}
}
