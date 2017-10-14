package com.skilldistillery.cards.blackjack;



public class Card implements Comparable<Card> {
    private Rank rank;
    private Suit suit;

    public Card(Rank r, Suit s) {
        rank = r;
        suit = s;
    }
    
    public Card() {}

    @Override
    public String toString() {
        return (rank.getRankDisplay() + suit.getSuitImage());
    }

    public int compareTo(Card o) {
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
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Card other = (Card) obj;
        if (rank != other.rank)
        		return false;
        if (suit != other.suit)
            return false;
        return true;
    }

	public Rank getRank() {
		return rank;
	}

	public Suit getSuit() {
		return suit;
	}
}


