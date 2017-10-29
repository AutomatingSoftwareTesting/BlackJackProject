package com.skilldistillery.cards.blackjack.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.skilldistillery.cards.blackjack.Card;
import com.skilldistillery.cards.blackjack.Rank;
import com.skilldistillery.cards.blackjack.Suit;

public class CardTest {
	Card c;
	
	@Before
	public void setUp() throws Exception {
		c = new Card();
	}

	@After
	public void tearDown() throws Exception {
		c = null;
	}

	@Test
	public void test_card_eight_of_clubs() {
		c = new Card(Rank.EIGHT, Suit.CLUBS);
		assertEquals("c", c.getSuit().getSuitDisplay());
		assertEquals('♣', c.getSuit().getSuitImage());
		assertEquals("8", c.getRank().getRankDisplay());
		assertEquals(8, c.getRank().getValue());
	}
	
	@Test
	public void test_card_queen_of_spades() {
		c = new Card(Rank.QUEEN, Suit.SPADES);
		assertEquals("s", c.getSuit().getSuitDisplay());
		assertEquals('♠', c.getSuit().getSuitImage());
		assertEquals("Q", c.getRank().getRankDisplay());
		assertEquals(10, c.getRank().getValue());
	}
	
	@Test
	public void test_card_ace_of_hearts() {
		c = new Card(Rank.ACE, Suit.HEARTS);
		assertEquals("h", c.getSuit().getSuitDisplay());
		assertEquals('❤', c.getSuit().getSuitImage());
		assertEquals("A", c.getRank().getRankDisplay());
		assertEquals(11, c.getRank().getValue());
	}
	
	@Test
	public void test_card_ten_of_diamonds() {
		c = new Card(Rank.TEN, Suit.DIAMONDS);
		assertEquals("d", c.getSuit().getSuitDisplay());
		assertEquals('♦', c.getSuit().getSuitImage());
		assertEquals("T", c.getRank().getRankDisplay());
		assertEquals(10, c.getRank().getValue());
	}
}
