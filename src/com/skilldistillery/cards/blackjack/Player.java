package com.skilldistillery.cards.blackjack;


public class Player {
	private String name;
	private Hand hand;
	private int stackSize;
	private int betSize;
	
	public Player(String name) {
		this(name, 100);
	}
	
	public Player(String name, int stackSize) {
		this.name = name;
		this.stackSize = stackSize;
	}
	
	public Hand getHand() {
		return hand;
	}
	
	public String getName() {
		return name;
	}
	
	public int getStackSize() {
		return stackSize;
	}
	
	public void playerHand(Card card) {
		hand.addCard(card);
	}
	
// -------------------BELOW IS RANDOM ---------------------------
	
	public Player() {
		hand = new Hand();
		this.name = getName();
		this.stackSize = getStackSize();
	}
	
	public String getRandomName() {
		String [] names = {"Jason", "Jake", "Ekubay", "Airik", "Chris", "Rosanne", "Dave", "Jen", "Alexis", "Greg", "Dave", "Aaron", "Alex", "Hunter"};
		name = names[(int)(Math.random() * 14)]; 
		return name;
	}

	public int getRandomStackSize() {
		Integer [] stacks = {25, 50, 100, 100, 100, 200, 500};
		stackSize = stacks[(int)(Math.random() * 7)];
		return stackSize;
	}
	
	public int placeRandomBet() {
		Integer [] bets = {1, 5, 10, 20};
		betSize = bets[(int)(Math.random() * 4)];
		return betSize;
	}
}
