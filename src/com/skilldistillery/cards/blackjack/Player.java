package com.skilldistillery.cards.blackjack;

public class Player {
	private String name;
	private Hand hand;
	private int stackSize;
	
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

	public Player(String name, Hand hand, int stackSize) {
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

	public int getStackSize() {
		Integer [] stacks = {25, 50, 100, 100, 100, 200, 500};
		stackSize = stacks[(int)(Math.random() * 7)];
		return stackSize;
	}
}
