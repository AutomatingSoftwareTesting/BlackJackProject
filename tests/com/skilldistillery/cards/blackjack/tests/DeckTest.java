package com.skilldistillery.cards.blackjack.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
	public void test_some_cards_in_deck() {
		assertEquals("2♣", d.getDeck().get(0).toString());
		assertEquals("T❤", d.getDeck().get(34).toString());
		assertEquals("K♦", d.getDeck().get(24).toString());
		assertEquals("A♠", d.getDeck().get(51).toString());
	}

	@Test
	public void test_new_Deck() {
		assertEquals("[2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, T♣, J♣, Q♣, K♣, A♣, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, T♦, J♦, Q♦, K♦, A♦, 2❤, 3❤, 4❤, 5❤, 6❤, 7❤, 8❤, 9❤, T❤, J❤, Q❤, K❤, A❤, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, T♠, J♠, Q♠, K♠, A♠]", d.getDeck().toString());
	}
}
