package com.skilldistillery.cards.blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> deck;
    private int numDelt = 0;
    
    public Deck() {
    		deck = new ArrayList<>(52);
        for (Suit s : Suit.values()) {
            for (Rank r : Rank.values()) {
                deck.add(new Card(r, s));
            }
        }
    }
    
    public void shuffleDeck(){
    		Collections.shuffle(deck);
    }
    
    public Card dealCard() {
    		numDelt++;
    		return deck.remove(0);
    }
    
	public List<Card> getDeck() {
		return deck;
	}

	@Override
	public String toString() {
		return "Deck: " + deck + ".";
	}

	public int getNumDelt() {
		return numDelt;
	}
}
