package com.skilldistillery.cards.blackjack.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.skilldistillery.cards.blackjack.Card;
import com.skilldistillery.cards.blackjack.Rank;
import com.skilldistillery.cards.blackjack.Suit;

public class CardTest {
	Card c8c;
	Card cQs;
	Card cAh;
	Card cTd;
	
	@Before
	public void setUp() throws Exception {
		c8c = new Card(Rank.EIGHT, Suit.CLUBS);
		cQs = new Card(Rank.QUEEN, Suit.SPADES);
		cAh = new Card(Rank.ACE, Suit.HEARTS);
		cTd = new Card(Rank.TEN, Suit.DIAMONDS);
	}

	@After
	public void tearDown() throws Exception {
		c8c = null;
		cQs = null;
		cAh = null;
		cTd = null;
	}

	@Test
	public void test_card_suit_display() {
		assertEquals("c", c8c.getSuit().getSuitDisplay());
		assertEquals("s", cQs.getSuit().getSuitDisplay());
		assertEquals("h", cAh.getSuit().getSuitDisplay());
		assertEquals("d", cTd.getSuit().getSuitDisplay());
	}
	
	@Test
	public void test_card_suit_image() {
		assertEquals('♣', c8c.getSuit().getSuitImage());
		assertEquals('♠', cQs.getSuit().getSuitImage());
		assertEquals('❤', cAh.getSuit().getSuitImage());
		assertEquals('♦', cTd.getSuit().getSuitImage());
	}
	
	@Test
	public void test_card_rank_display() {
		assertEquals("8", c8c.getRank().getRankDisplay());
		assertEquals("Q", cQs.getRank().getRankDisplay());
		assertEquals("A", cAh.getRank().getRankDisplay());
		assertEquals("T", cTd.getRank().getRankDisplay());
	}
	
	@Test
	public void test_card_rank_value() {
		assertEquals(8, c8c.getRank().getValue());
		assertEquals(10, cQs.getRank().getValue());
		assertEquals(11, cAh.getRank().getValue());
		assertEquals(10, cTd.getRank().getValue());
	}
}
