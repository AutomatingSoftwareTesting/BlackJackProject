package com.skilldistillery.cards.blackjack;

public enum Suit {
	CLUBS("c", '\u2663'),
	DIAMONDS("d", '\u2666'),
	HEARTS("h", '\u2764'),
	SPADES("s", '\u2660');
	
	private String suitDisplay;
	private char suitImage;
	
	private Suit(String suitDisplay, char suitImage) {
		this.suitDisplay = suitDisplay;
		this.suitImage = suitImage;
	}
	
	private Suit(String suitDisplay) {
		this(suitDisplay, 'n');
	}

	public String getSuitDisplay() {
		return suitDisplay;
	}

	public char getSuitImage() {
		return suitImage;
	}
	
	
}
