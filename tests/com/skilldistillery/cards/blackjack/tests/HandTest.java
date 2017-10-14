package com.skilldistillery.cards.blackjack.tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.skilldistillery.cards.blackjack.Card;
import com.skilldistillery.cards.blackjack.Hand;
import com.skilldistillery.cards.blackjack.Rank;
import com.skilldistillery.cards.blackjack.Suit;

public class HandTest {
	Hand h;
	Card c1 = new Card(Rank.ACE, Suit.SPADES);
	Card c2 = new Card(Rank.TEN, Suit.SPADES);
	
	@Before
	public void setUp() throws Exception {
		h.addCard(c1);
		h.addCard(c2);
	}

	@After
	public void tearDown() throws Exception {
		h = null;
	}

	@Test
	public void test_hand_value() {
		assertEquals(21, h.getValueOfHand());
	}

}
