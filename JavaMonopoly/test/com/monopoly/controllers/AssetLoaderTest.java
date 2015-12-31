package com.monopoly.controllers;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.monopoly.AssetLoader;
import com.monopoly.models.persistent.Card;
import com.monopoly.models.persistent.Property;

public class AssetLoaderTest {

	@Test
	public void loadPropertyCardsTest() {
		List<Property> props = AssetLoader.getAllPropertyRecords();

		assertEquals("Not all properties have been loaded", props.size(), 40);
	}

	@Test
	public void loadChanceCardsTest() {
		List<Card> cards = AssetLoader.getChanceCards();

		assertEquals("Not all cards have been loaded", cards.size(), 32);


	}

}
