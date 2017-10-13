package com.skilldistillery.cards.blackjack;

public class main {

	public static void main(String[] args) {
		Deck d = new Deck();
		d.createDeck();
		System.out.println(d);
		d.shuffleDeck();
		System.out.println(d);
	}

}
