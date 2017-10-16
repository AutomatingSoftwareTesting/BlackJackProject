package com.skilldistillery.cards.blackjack;


public class Card implements Comparable<Card> {
    private Rank rank;
    private Suit suit;

    public Card(Rank r, Suit s) {
        rank = r;
        suit = s;
    }
    
    public Card() {}
    
    public boolean isFaceUp() {
    		// If not face up don't want to show rank or suit; i.e. XX.
    		return true;
    }

    @Override
    public String toString() {
        return (rank.getRankDisplay() + suit.getSuitImage());
    }

    public int compareTo(Card o) {
    	// Not using for blackjack. However, will need for other card games later.
	    	if (this.rank.ordinal() < o.rank.ordinal()) {
	    		return -1;
	    	}
	    	else if (this.rank.ordinal() > o.rank.ordinal()) {
	    		return 1;
	    	}
	    	else {
	    		return 0;
	    	}
    }

	public Rank getRank() {
		return rank;
	}

	public Suit getSuit() {
		return suit;
	}
}
