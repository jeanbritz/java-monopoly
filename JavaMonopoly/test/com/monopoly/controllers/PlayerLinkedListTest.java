package com.monopoly.controllers;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PlayerLinkedListTest {

	static PlayerLinkedList players;
	static Player p1;
	static Player p2;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		players = new PlayerLinkedList();
		p1 = new Player(null);
		p2 = new Player(null);
		
	}

	@Before
	public void setUp() throws Exception {
		players.add(p1);
	}

	@Test
	public void testAdd() {
		fail("Not yet implemented");
	}

	@Test
	public void testGet() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetNext() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSize() {
		fail("Not yet implemented");
	}
	
	@After
	public void tearDown() throws Exception {
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

}
