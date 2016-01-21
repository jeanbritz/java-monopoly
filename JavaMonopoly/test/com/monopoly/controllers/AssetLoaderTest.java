package com.monopoly.controllers;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import za.co.geskroef.monopoly.Asset;
import za.co.geskroef.monopoly.model.persistent.Card;
import za.co.geskroef.monopoly.model.persistent.Property;

public class AssetLoaderTest {

	@Test
	public void loadPropertyCardsTest() {
		List<Property> props = Asset.getAllPropertyRecords();

		assertEquals("Not all properties have been loaded", props.size(), 40);
	}

	@Test
	public void loadChanceCardsTest() {
		List<Card> cards = Asset.getChanceCards();

		assertEquals("Not all cards have been loaded", cards.size(), 32);


	}

}
