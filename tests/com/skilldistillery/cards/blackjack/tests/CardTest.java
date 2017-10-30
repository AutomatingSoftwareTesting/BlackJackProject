package com.skilldistillery.cards.blackjack.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.skilldistillery.cards.blackjack.Card;
import com.skilldistillery.cards.blackjack.Rank;
import com.skilldistillery.cards.blackjack.Suit;

public class CardTest {
	Card card;
	
	@Before
	public void setUp() throws Exception {
		card = new Card();
	}

	@After
	public void tearDown() throws Exception {
		card = null;
	}

	@Test
	public void test_card_eight_of_clubs() {
		card = new Card(Rank.EIGHT, Suit.CLUBS);
		assertEquals("c", card.getSuit().getSuitDisplay());
		assertEquals('♣', card.getSuit().getSuitImage());
		assertEquals("8", card.getRank().getRankDisplay());
		assertEquals(8, card.getRank().getValue());
	}
	
	@Test
	public void test_card_queen_of_spades() {
		card = new Card(Rank.QUEEN, Suit.SPADES);
		assertEquals("s", card.getSuit().getSuitDisplay());
		assertEquals('♠', card.getSuit().getSuitImage());
		assertEquals("Q", card.getRank().getRankDisplay());
		assertEquals(10, card.getRank().getValue());
	}
	
	@Test
	public void test_card_ace_of_hearts() {
		card = new Card(Rank.ACE, Suit.HEARTS);
		assertEquals("h", card.getSuit().getSuitDisplay());
		assertEquals('❤', card.getSuit().getSuitImage());
		assertEquals("A", card.getRank().getRankDisplay());
		assertEquals(11, card.getRank().getValue());
	}
	
	@Test
	public void test_card_ten_of_diamonds() {
		card = new Card(Rank.TEN, Suit.DIAMONDS);
		assertEquals("d", card.getSuit().getSuitDisplay());
		assertEquals('♦', card.getSuit().getSuitImage());
		assertEquals("T", card.getRank().getRankDisplay());
		assertEquals(10, card.getRank().getValue());
	}
}
