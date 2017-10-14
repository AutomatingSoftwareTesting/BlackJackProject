package com.skilldistillery.cards.blackjack;

public enum Rank {
	TWO("2", 2), 
	THREE("3", 3), 
	FOUR("4", 4), 
	FIVE("5", 5), 
	SIX("6", 6), 
	SEVEN("7", 7), 
	EIGHT("8", 8), 
	NINE("9", 9), 
	TEN("T", 10), 
    JACK("J", 10), 
    QUEEN("Q", 10), 
    KING("K", 10), 
    ACE("A", 11);
	
	private int value;  
	// These values are specific to blackjack only
	// Is that a problem b/c of Your card and deck implementations should NOT be coupled to Blackjack
	private String rankDisplay;

	private Rank(String rankDisplay, int value) {
		this.value = value;
		this.rankDisplay = rankDisplay;
	}
	
	private Rank() {}

	public int getValue() {
		return value;
	}

	public String getRankDisplay() {
		return rankDisplay;
	}
}
