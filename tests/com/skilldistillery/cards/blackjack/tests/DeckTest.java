package com.skilldistillery.cards.blackjack.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.skilldistillery.cards.blackjack.Card;
import com.skilldistillery.cards.blackjack.Deck;

public class DeckTest {
	Deck deck;

	@Before
	public void setUp() throws Exception {
		deck = new Deck();
	}

	@After
	public void tearDown() throws Exception {
		deck = null;
	}
	
	@Test
	public void test_deck_size() {
		assertEquals(52, deck.getDeck().size());
	}
	
	@Test
	public void test_new_deck() {
		assertEquals("[2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, T♣, J♣, Q♣, K♣, A♣, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, T♦, J♦, Q♦, K♦, A♦, 2❤, 3❤, 4❤, 5❤, 6❤, 7❤, 8❤, 9❤, T❤, J❤, Q❤, K❤, A❤, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, T♠, J♠, Q♠, K♠, A♠]", deck.getDeck().toString());
		assertEquals(0, deck.getNumDelt()); // We haven't dealt anything yet
	}
	
	@Test
	public void test_some_cards_in_deck() {
		assertEquals("2♣", deck.getDeck().get(0).toString());
		assertEquals("T❤", deck.getDeck().get(34).toString());
		assertEquals("K♦", deck.getDeck().get(24).toString());
		assertEquals("A♠", deck.getDeck().get(51).toString());
	}
	
	@Test
	public void test_deal_1_from_deck() {
		deck.getDeck();
		Card card = deck.dealCard();
		assertEquals("[3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, T♣, J♣, Q♣, K♣, A♣, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, T♦, J♦, Q♦, K♦, A♦, 2❤, 3❤, 4❤, 5❤, 6❤, 7❤, 8❤, 9❤, T❤, J❤, Q❤, K❤, A❤, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, T♠, J♠, Q♠, K♠, A♠]", deck.getDeck().toString());
		assertEquals("2♣", card.toString());
		assertEquals(51, deck.getDeck().size());
		assertEquals(1, deck.getNumDelt());
	}
	
	@Test
	public void test_deal_4_from_deck() {
		deck.getDeck();
		Card card = deck.dealCard();
		Card card2 = deck.dealCard();
		Card card3 = deck.dealCard();
		Card card4 = deck.dealCard();
		assertEquals("[6♣, 7♣, 8♣, 9♣, T♣, J♣, Q♣, K♣, A♣, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, T♦, J♦, Q♦, K♦, A♦, 2❤, 3❤, 4❤, 5❤, 6❤, 7❤, 8❤, 9❤, T❤, J❤, Q❤, K❤, A❤, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, T♠, J♠, Q♠, K♠, A♠]", deck.getDeck().toString());
		assertEquals("2♣", card.toString());
		assertEquals("3♣", card2.toString());
		assertEquals("4♣", card3.toString());
		assertEquals("5♣", card4.toString());
		assertEquals(48, deck.getDeck().size());
		assertEquals(4, deck.getNumDelt());
	}
	
	@Test
	public void test_deal_deck() {
		// Should never run out of cards because deck is shuffled after each hand and the max number of players at a table is 6.
		deck.getDeck();
		for (int i = 0; i < 50; i++) {
			deck.dealCard();
		}
		assertEquals(2, deck.getDeck().size());
		assertEquals(50, deck.getNumDelt());
		Card card = deck.dealCard();
		assertEquals("K♠", card.toString());
		assertEquals(1, deck.getDeck().size());
		assertEquals(51, deck.getNumDelt());
		Card card2 = deck.dealCard();
		assertEquals("A♠", card2.toString());
		assertEquals(0, deck.getDeck().size());
		assertEquals(52, deck.getNumDelt());
	}
	
	
	
	@Test
	public void test_out_of_cards() {
		// To see how jUnit works with exceptions
		deck.getDeck();
		boolean thrown = false;
		
		for (int i = 0; i < 52; i++) {
			deck.dealCard();
		}
		// Should get error because there are only 52 cards in deck
		try {
			deck.dealCard();
		}
		catch (IndexOutOfBoundsException e) {
			thrown = true;
		}
		assertTrue(thrown);
	}
	
	@Test
	public void test_shuffle_deck() {
		deck.getDeck();
		deck.shuffleDeck();
		// There is a very small chance that the order will be the same after the shuffle; but is very unlikely.
		assertNotEquals("[2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, T♣, J♣, Q♣, K♣, A♣, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, T♦, J♦, Q♦, K♦, A♦, 2❤, 3❤, 4❤, 5❤, 6❤, 7❤, 8❤, 9❤, T❤, J❤, Q❤, K❤, A❤, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, T♠, J♠, Q♠, K♠, A♠]", deck.getDeck().toString());  
	}
}
