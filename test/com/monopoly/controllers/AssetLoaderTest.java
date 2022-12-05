package com.monopoly.controllers;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import main.java.monopoly.Asset;
import main.java.monopoly.model.persistent.Card;
import main.java.monopoly.model.persistent.Property;

public class AssetLoaderTest {

	@Test
	public void loadPropertyCardsTest() {
		List<Property> props = Asset.getProperties();

		assertEquals("Not all properties have been loaded", props.size(), 40);
	}

	@Test
	public void loadChanceCardsTest() {
		List<Card> cards = Asset.getChanceCards();

		assertEquals("Not all cards have been loaded", cards.size(), 32);


	}

}
