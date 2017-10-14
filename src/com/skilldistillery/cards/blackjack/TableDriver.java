package com.skilldistillery.cards.blackjack;

public class TableDriver {
	public static void main(String[] args) {
		Game g = new Game();
		g.startSession();
		g.Dealer();
	}
}
