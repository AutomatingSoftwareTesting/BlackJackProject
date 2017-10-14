package com.skilldistillery.cards.blackjack.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.skilldistillery.cards.blackjack.Player;

public class PlayerTest {
	Player p;
	// Not sure how to test this
	// See comments in Player class
	
	@Before
	public void setUp() throws Exception {
		p = new Player();
	}

	@After
	public void tearDown() throws Exception {
		p = null;
	}

	@Test
	public void test_default_name() {
		assertEquals("Player Jason", p.getName());
	} 
	
	@Test
	public void test_default_stack_size() {
		assertEquals(100, p.getStackSize());
	}
}
