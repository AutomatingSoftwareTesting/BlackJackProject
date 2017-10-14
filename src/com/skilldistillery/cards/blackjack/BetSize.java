package com.skilldistillery.cards.blackjack;

public enum BetSize {
	FIVE(5),
	TEN(10),
	TWENTY(20);
	
	private int betSize;
	
	private BetSize(int size) {
		this.betSize = size;
	}

	public int getBetSize() {
		return betSize;
	}
}
