package com.skilldistillery.cards.blackjack.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.skilldistillery.cards.blackjack.Player;

public class PlayerTest {
	Player p;
	
	@Before
	public void setUp() throws Exception {
		p = new Player();
	}

	@After
	public void tearDown() throws Exception {
		p = null;
	}

	@Test
	public void test_default_stack_size() {
		Player p = new Player("Jason");
		assertEquals("Jason", p.getName());
		assertEquals(100, p.getStackSize(), 0.01);
	}
	
	@Test
	public void test_non_default() {
		p = new Player("Bob", 250);
		assertEquals("Bob", p.getName());
		assertEquals(250, p.getStackSize(), 0.01);
		// 'Bob' isn't in the random name list
		assertNotEquals("Bob", p.getRandomName());
	} 
}
