package com.skilldistillery.cards.blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> deck;
    private int numDelt = 0;
    
    public Deck() {
    		deck = new ArrayList<>(52);
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                deck.add(new Card(rank, suit));
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
    
    public int getNumDelt() {
    		return numDelt;
    }
    
	public List<Card> getDeck() {
		return deck;
	}

	@Override
	public String toString() {
		return "Deck: " + deck + ".";
	}
}
