package com.skilldistillery.cards.blackjack.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.skilldistillery.cards.blackjack.Player;

public class PlayerTest {
	Player player;
	
	@Before
	public void setUp() throws Exception {
		player = new Player();
	}

	@After
	public void tearDown() throws Exception {
		player = null;
	}

	@Test
	public void test_default_stack_size() {
		player = new Player("Jason");
		assertEquals("Jason", player.getName());
		assertEquals(100, player.getStackSize(), 0.01);
	}
	
	@Test
	public void test_non_defaults() {
		player = new Player("Bob", 250);
		assertEquals("Bob", player.getName());
		assertEquals(250, player.getStackSize(), 0.01);
		// 'Bob' isn't in the random name list
		assertNotEquals("Bob", player.getRandomName());
	} 
}
