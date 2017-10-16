package com.skilldistillery.cards.blackjack.tests;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.skilldistillery.cards.blackjack.Card;
import com.skilldistillery.cards.blackjack.Hand;
import com.skilldistillery.cards.blackjack.Rank;
import com.skilldistillery.cards.blackjack.Suit;

public class HandTest {
	Hand h;
	Hand blackjack;
	Hand mc;
	
	@Before
	public void setUp() throws Exception {
		h = new Hand();
		h.addCard(new Card(Rank.KING, Suit.SPADES));
		h.addCard(new Card(Rank.QUEEN, Suit.CLUBS));
		
		blackjack = new Hand();
		blackjack.addCard(new Card(Rank.ACE, Suit.SPADES));
		blackjack.addCard(new Card(Rank.TEN, Suit.SPADES));
		
		mc = new Hand();
		mc.addCard(new Card(Rank.TWO, Suit.SPADES));
		mc.addCard(new Card(Rank.SEVEN, Suit.HEARTS));
		mc.addCard(new Card(Rank.FOUR, Suit.DIAMONDS));
		mc.addCard(new Card(Rank.FIVE, Suit.CLUBS));
		mc.addCard(new Card(Rank.TWO, Suit.CLUBS));
	}

	@After
	public void tearDown() throws Exception {
		h = null;
		blackjack = null;
	}

	@Test
	public void test_hand() {
		assertEquals("[K♠, Q♣]", h.getHand().toString());
		assertEquals(20, h.getValueOfHand());
	}
	
	@Test
	public void test_many_cards_in_hand() {
		assertEquals("[2♠, 7❤, 4♦, 5♣, 2♣]", mc.getHand().toString());
		assertEquals(20, mc.getValueOfHand());
	}
	
	@Test
	public void test_blackjack() {
		assertEquals(21, blackjack.getValueOfHand());
	}
}
