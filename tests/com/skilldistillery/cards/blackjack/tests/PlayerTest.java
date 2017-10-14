package com.skilldistillery.cards.blackjack.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.skilldistillery.cards.blackjack.Player;

public class PlayerTest {
	Player p;
	Player np;
	
	@Before
	public void setUp() throws Exception {
		p = new Player("Jason");
		np = new Player("Bob", 250);
	}

	@After
	public void tearDown() throws Exception {
		p = null;
	}

	@Test
	public void test_name() {
		assertEquals("Jason", p.getName());
	} 
	
	@Test
	public void test_default_stack_size() {
		assertEquals(100, p.getStackSize());
	}
	
	@Test
	public void test_another_name() {
		assertEquals("Bob", np.getName());
		// 'Bob' isn't in the random name list
		assertNotEquals("Bob", np.getRandomName());
	} 
	
	@Test
	public void test_non_default_stack_size() {
		assertEquals(250, np.getStackSize());
	}
}
