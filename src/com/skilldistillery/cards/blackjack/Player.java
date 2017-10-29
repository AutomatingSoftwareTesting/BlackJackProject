package com.skilldistillery.cards.blackjack;


public class Player {
	private String name;
	private Hand hand;
	private double stackSize;
	private double betSize;
	
	public Player(String name) {
		this(name, 100);
	}
	
	public Player(String name, double stackSize) {
		this.name = name;
		this.stackSize = stackSize;
	}
	
	public Hand getHand() {
		return hand;
	}
	
	public String getName() {
		return name;
	}
	
	public double getStackSize() {
		return stackSize;
	}
	
	public void playerHand(Card card) {
		hand.addCard(card);
	}
	
	public void removeCardsFromPlayerHand() {
		hand = new Hand();
	}
	
	public void setStackSize(double stackSize) {
		this.stackSize = stackSize;
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

	public double getRandomStackSize() {
		Double [] stacks = {25.0, 50.0, 100.0, 100.0, 100.0, 200.0, 500.0};
		stackSize = stacks[(int)(Math.random() * 7)];
		return stackSize;
	}
	
	public double placeRandomBet() {
		Double [] bets = {1.0, 5.0, 10.0, 20.0};
		betSize = bets[(int)(Math.random() * 4)];
		return betSize;
	}

}
