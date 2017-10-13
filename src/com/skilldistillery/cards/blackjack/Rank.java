package com.skilldistillery.cards.blackjack;

public enum Rank {
	TWO(2, "2"), 
	THREE(3, "3"), 
	FOUR(4, "4"), 
	FIVE(5, "5"), 
	SIX(6, "6"), 
	SEVEN(7, "7"), 
	EIGHT(8, "8"), 
	NINE(9, "9"), 
	TEN(10, "T"), 
    JACK(10, "J"), 
    QUEEN(10, "Q"), 
    KING(10, "K"), 
    ACE(11, "A");
	
	private int value;
	private String rankDisplay;

	private Rank(int value, String rankDisplay) {
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
