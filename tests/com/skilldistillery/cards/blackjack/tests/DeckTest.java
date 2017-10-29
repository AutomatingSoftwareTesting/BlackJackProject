package com.skilldistillery.cards.blackjack.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.skilldistillery.cards.blackjack.Card;
import com.skilldistillery.cards.blackjack.Deck;

public class DeckTest {
	Deck d;

	@Before
	public void setUp() throws Exception {
		d = new Deck();
	}

	@After
	public void tearDown() throws Exception {
		d = null;
	}
	
	@Test
	public void test_deck_size() {
		assertEquals(52, d.getDeck().size());
	}
	
	@Test
	public void test_new_deck() {
		assertEquals("[2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, T♣, J♣, Q♣, K♣, A♣, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, T♦, J♦, Q♦, K♦, A♦, 2❤, 3❤, 4❤, 5❤, 6❤, 7❤, 8❤, 9❤, T❤, J❤, Q❤, K❤, A❤, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, T♠, J♠, Q♠, K♠, A♠]", d.getDeck().toString());
		assertEquals(0, d.getNumDelt()); // We haven't dealt anything yet
	}
	
	@Test
	public void test_some_cards_in_deck() {
		assertEquals("2♣", d.getDeck().get(0).toString());
		assertEquals("T❤", d.getDeck().get(34).toString());
		assertEquals("K♦", d.getDeck().get(24).toString());
		assertEquals("A♠", d.getDeck().get(51).toString());
	}
	
	@Test
	public void test_deal_1_from_deck() {
		d.getDeck();
		Card card = d.dealCard();
		assertEquals("[3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, T♣, J♣, Q♣, K♣, A♣, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, T♦, J♦, Q♦, K♦, A♦, 2❤, 3❤, 4❤, 5❤, 6❤, 7❤, 8❤, 9❤, T❤, J❤, Q❤, K❤, A❤, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, T♠, J♠, Q♠, K♠, A♠]", d.getDeck().toString());
		assertEquals("2♣", card.toString());
		assertEquals(51, d.getDeck().size());
		assertEquals(1, d.getNumDelt());
	}
	
	@Test
	public void test_deal_4_from_deck() {
		d.getDeck();
		Card card = d.dealCard();
		Card card2 = d.dealCard();
		Card card3 = d.dealCard();
		Card card4 = d.dealCard();
		assertEquals("[6♣, 7♣, 8♣, 9♣, T♣, J♣, Q♣, K♣, A♣, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, T♦, J♦, Q♦, K♦, A♦, 2❤, 3❤, 4❤, 5❤, 6❤, 7❤, 8❤, 9❤, T❤, J❤, Q❤, K❤, A❤, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, T♠, J♠, Q♠, K♠, A♠]", d.getDeck().toString());
		assertEquals("2♣", card.toString());
		assertEquals("3♣", card2.toString());
		assertEquals("4♣", card3.toString());
		assertEquals("5♣", card4.toString());
		assertEquals(48, d.getDeck().size());
		assertEquals(4, d.getNumDelt());
	}
	
	@Test
	public void test_deal_deck() {
		// Should never run out of cards because deck is shuffled after each hand and the max number of players at a table is 6.
		d.getDeck();
		for (int i = 0; i < 50; i++) {
			d.dealCard();
		}
		assertEquals(2, d.getDeck().size());
		assertEquals(50, d.getNumDelt());
		Card card = d.dealCard();
		assertEquals("K♠", card.toString());
		assertEquals(1, d.getDeck().size());
		assertEquals(51, d.getNumDelt());
		Card card2 = d.dealCard();
		assertEquals("A♠", card2.toString());
		assertEquals(0, d.getDeck().size());
		assertEquals(52, d.getNumDelt());
	}
	
	@Test
	public void test_out_of_cards() {
		// To see how jUnit works with exceptions
		d.getDeck();
		Card c;
		boolean thrown = false;
		
		for (int i = 0; i < 52; i++) {
			d.dealCard();
		}
		// Should get error because there are only 52 cards in deck
		try {
			c = d.dealCard();
		}
		catch (IndexOutOfBoundsException e) {
			thrown = true;
		}
		assertTrue(thrown);
	}
	
	@Test
	public void test_shuffle_deck() {
		d.getDeck();
		d.shuffleDeck();
		// There is a very small chance that the order will be the same after the shuffle; but is very unlikely.
		assertNotEquals("[2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, T♣, J♣, Q♣, K♣, A♣, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, T♦, J♦, Q♦, K♦, A♦, 2❤, 3❤, 4❤, 5❤, 6❤, 7❤, 8❤, 9❤, T❤, J❤, Q❤, K❤, A❤, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, T♠, J♠, Q♠, K♠, A♠]", d.getDeck().toString());  
	}
}
