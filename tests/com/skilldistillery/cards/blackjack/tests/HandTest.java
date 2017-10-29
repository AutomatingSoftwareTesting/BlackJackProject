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
	
	@Before
	public void setUp() throws Exception {
		h = new Hand();
	}

	@After
	public void tearDown() throws Exception {
		h = null;
	}

	@Test
	public void test_hand() {
		h.addCard(new Card(Rank.KING, Suit.SPADES));
		h.addCard(new Card(Rank.QUEEN, Suit.CLUBS));
		assertEquals("[K♠, Q♣]", h.getHand().toString());
		assertEquals(20, h.getValueOfHand());
	}
	
	@Test
	public void test_lowest_hand() {
		h.addCard(new Card(Rank.TWO, Suit.SPADES));
		h.addCard(new Card(Rank.TWO, Suit.CLUBS));
		assertEquals("[2♠, 2♣]", h.getHand().toString());
		assertEquals(4, h.getValueOfHand());
	}
	
	@Test
	public void test_lowest_bust_hand() {
		h.addCard(new Card(Rank.TWO, Suit.HEARTS));
		h.addCard(new Card(Rank.TEN, Suit.CLUBS));
		h.addCard(new Card(Rank.QUEEN, Suit.DIAMONDS));
		assertEquals("[2❤, T♣, Q♦]", h.getHand().toString());
		assertEquals(22, h.getValueOfHand());
	}
	
	@Test
	public void test_highest_bust_hand() {
		h.addCard(new Card(Rank.KING, Suit.SPADES));
		h.addCard(new Card(Rank.QUEEN, Suit.CLUBS));
		h.addCard(new Card(Rank.ACE, Suit.SPADES));
		h.addCard(new Card(Rank.KING, Suit.HEARTS));
		assertEquals(31, h.getValueOfHand());
	}
	
	@Test
	public void test_blackjack() {
		h.addCard(new Card(Rank.ACE, Suit.SPADES));
		h.addCard(new Card(Rank.TEN, Suit.SPADES));
		assertEquals(21, h.getValueOfHand());
	}
	
	@Test
	public void test_21() {
		h.addCard(new Card(Rank.THREE, Suit.SPADES));
		h.addCard(new Card(Rank.FIVE, Suit.SPADES));
		h.addCard(new Card(Rank.EIGHT, Suit.SPADES));
		h.addCard(new Card(Rank.FIVE, Suit.HEARTS));
		assertEquals(21, h.getValueOfHand());
	}
	
	@Test
	public void test_1_ace_values() {
		h.addCard(new Card(Rank.TWO, Suit.SPADES));
		h.addCard(new Card(Rank.TEN, Suit.HEARTS));
		assertEquals(12, h.getValueOfHand());
		h.addCard(new Card(Rank.ACE, Suit.CLUBS));
		assertEquals(13, h.getValueOfHand());
		h.addCard(new Card(Rank.SIX, Suit.CLUBS));
		assertEquals(19, h.getValueOfHand());
	}
	
	@Test
	public void test_2_ace_values() {
		h.addCard(new Card(Rank.TWO, Suit.SPADES));
		h.addCard(new Card(Rank.ACE, Suit.HEARTS));
		assertEquals(13, h.getValueOfHand());
		h.addCard(new Card(Rank.ACE, Suit.CLUBS));
		assertEquals(14, h.getValueOfHand());
	}
	
	@Test
	public void test_ace_values_dont_bust() {
		h.addCard(new Card(Rank.TEN, Suit.SPADES));
		h.addCard(new Card(Rank.ACE, Suit.HEARTS));
		h.addCard(new Card(Rank.ACE, Suit.CLUBS));
		assertEquals(12, h.getValueOfHand());
	}
	
	@Test
	public void test_surrender_hand() {
		h.addCard(new Card(Rank.TEN, Suit.SPADES));
		h.addCard(new Card(Rank.ACE, Suit.HEARTS));
		h.addCard(new Card(Rank.ACE, Suit.CLUBS));
		h.surrenderHand();
		assertEquals(0, h.getValueOfHand());
	}
	
	@Test
	public void test_ace_value_busts() {
		h.addCard(new Card(Rank.TEN, Suit.SPADES));
		h.addCard(new Card(Rank.ACE, Suit.HEARTS));
		h.addCard(new Card(Rank.ACE, Suit.CLUBS));
		h.addCard(new Card(Rank.QUEEN, Suit.CLUBS));
		assertEquals(22, h.getValueOfHand());
	}
	
	@Test
	public void test_4_aces() {
		h.addCard(new Card(Rank.ACE, Suit.SPADES));
		h.addCard(new Card(Rank.ACE, Suit.HEARTS));
		h.addCard(new Card(Rank.ACE, Suit.CLUBS));
		h.addCard(new Card(Rank.ACE, Suit.DIAMONDS));
		assertEquals(14, h.getValueOfHand());
	}
	
	@Test
	public void test_many_cards_in_hand() {
		// The max number of players is 6
		Hand h2 = new Hand();
		Hand h3 = new Hand();
		Hand h4 = new Hand();
		Hand h5 = new Hand();
		Hand h6 = new Hand();
		h.addCard(new Card(Rank.TWO, Suit.SPADES));
		h.addCard(new Card(Rank.SEVEN, Suit.HEARTS));
		h.addCard(new Card(Rank.FOUR, Suit.DIAMONDS));
		h.addCard(new Card(Rank.THREE, Suit.CLUBS));
		h.addCard(new Card(Rank.TWO, Suit.CLUBS));
		h2.addCard(new Card(Rank.QUEEN, Suit.SPADES));
		h2.addCard(new Card(Rank.KING, Suit.HEARTS));
		h3.addCard(new Card(Rank.SIX, Suit.DIAMONDS));
		h3.addCard(new Card(Rank.EIGHT, Suit.CLUBS));
		h3.addCard(new Card(Rank.FIVE, Suit.HEARTS));
		h4.addCard(new Card(Rank.TEN, Suit.SPADES));
		h4.addCard(new Card(Rank.TEN, Suit.HEARTS));
		h5.addCard(new Card(Rank.JACK, Suit.DIAMONDS));
		h5.addCard(new Card(Rank.ACE, Suit.CLUBS));
		h6.addCard(new Card(Rank.FOUR, Suit.SPADES));
		h6.addCard(new Card(Rank.THREE, Suit.HEARTS));
		h6.addCard(new Card(Rank.TWO, Suit.DIAMONDS));
		h6.addCard(new Card(Rank.NINE, Suit.CLUBS));
		assertEquals(18, h.getValueOfHand());
		assertEquals(20, h2.getValueOfHand());
		assertEquals(19, h3.getValueOfHand());
		assertEquals(20, h4.getValueOfHand());
		assertEquals(21, h5.getValueOfHand());
		assertEquals(18, h6.getValueOfHand());
		h2 = null;
		h3 = null;
		h4 = null;
		h5 = null;
		h6 = null;
	}
}
