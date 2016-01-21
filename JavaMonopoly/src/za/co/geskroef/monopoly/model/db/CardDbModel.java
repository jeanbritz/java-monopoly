package za.co.geskroef.monopoly.model.db;

import java.lang.reflect.Type;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import za.co.geskroef.monopoly.model.persistent.Card;
import za.co.geskroef.monopoly.model.persistent.CardAction;
import za.co.neilson.sqlite.orm.ObjectModel;
import za.co.neilson.sqlite.orm.jdbc.JdbcObjectModel;

public class CardDbModel extends AbstractDatabaseModel {

	public CardDbModel() throws SQLException, ClassNotFoundException, NoSuchFieldException {
		super((Object[]) null);

	}

	@Override
	protected void onRegisterObjectModels(HashMap<Type, ObjectModel<?, ResultSet, HashMap<String, Object>>> arg0)
	    throws ClassNotFoundException, NoSuchFieldException {

		/*
		 * Tables managed by this model
		 */

		// Register the ObjectModel for the Card class with the DatabaseModel
		objectModels.put(Card.class, new JdbcObjectModel<Card>(this) {
		});

		// CardAction has a foreign key reference to Property and must therefore
		// be added after
		// Property.
		objectModels.put(CardAction.class, new JdbcObjectModel<CardAction>(this) {
		});
	}

}
