package com.skilldistillery.cards.blackjack;

public enum BetSize {
	// Currently this is not used
	ONE(1),
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
