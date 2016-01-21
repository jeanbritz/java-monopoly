package com.monopoly.controllers;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.britzj.monopoly.Asset;
import com.britzj.monopoly.model.persistent.Card;
import com.britzj.monopoly.model.persistent.Property;

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
