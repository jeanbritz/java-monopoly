package com.monopoly.controllers;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import za.co.geskroef.monopoly.controller.Player;
import za.co.geskroef.monopoly.util.LinkedList;
import za.co.geskroef.monopoly.util.LinkedList.Node;

public class LinkedListTest {

	static LinkedList ll;
	static Player p1;
	static Player p2;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ll = new LinkedList();
		p1 = new Player(null, "Tom");
		p2 = new Player(null, "Jerry");
		ll.add(p1);
		ll.add(p2);
	}

	@Before
	public void setUp() throws Exception {


	}

	@Test
	public void sizeTest() {
		assertEquals("Size is not correct", 2, ll.size());
		assertEquals("Is not accurate", false, ll.isEmpty());
	}

	@Test
	public void getInitNodeTest() {
		Node init = ll.getInitNode();
		assertEquals("Not init node", p1, init.getNextNode().getData());
	}
	


	@After
	public void tearDown() throws Exception {
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

}
