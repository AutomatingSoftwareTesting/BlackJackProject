package com.skilldistillery.cards.blackjack;

public class Player {
	private String name;
	private Hand hand;
	private double stackSize;
	
	public void placeWager(int wager) {
		// To do
	}
	
	public Player(String name, Hand hand) {
		this.name = name;
		this.hand = hand;
	}
	
	public Player(String name) {
		this.name = name;
	}
	
	public Player() {}

	public Player(String name, Hand hand, double stackSize) {
		super();
		this.name = name;
		this.hand = hand;
		this.stackSize = stackSize;
	}

	public String getName() {
		String [] names = {"Jason", "Jake", "Ekubay", "Airik", "Chris", "Rosanne", "Dave", "Jen", "Alexis", "Greg", "Dave", "Aaron", "Alex", "Hunter"};
		name = names[(int)(Math.random() * 14)];
		return name;
	}

	public Hand getHand() {
		return hand;
	}

	public double getStackSize() {
		return stackSize;
	}
}
