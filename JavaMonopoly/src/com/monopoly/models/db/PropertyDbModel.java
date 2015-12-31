package com.monopoly.models.db;

import java.lang.reflect.Type;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import com.monopoly.models.persistent.Property;
import com.monopoly.models.persistent.PropertyType;
import com.monopoly.models.persistent.Tariff;

import za.co.neilson.sqlite.orm.ObjectModel;
import za.co.neilson.sqlite.orm.jdbc.JdbcObjectModel;


public class PropertyDbModel extends AbstractDatabaseModel {

	public PropertyDbModel() throws SQLException, ClassNotFoundException, NoSuchFieldException {
		super((Object[]) null);
		
	}

		
	@Override
	protected void onRegisterObjectModels(HashMap<Type, ObjectModel<?, ResultSet, HashMap<String, Object>>> arg0)
			throws ClassNotFoundException, NoSuchFieldException {
		
		/*
		 * Tables managed by this model
		 */
		
		// Register the ObjectModel for the Property class with the DatabaseModel
		objectModels.put(Property.class, new JdbcObjectModel<Property>(this) {});
		
		// PropertyType has a foreign key reference to Property and must therefore be added after
		// Property.
		objectModels.put(PropertyType.class, new JdbcObjectModel<PropertyType>(this) {});
		
		// Tariff has a foreign key reference to Property and must therefore be added after
		// Property.
		objectModels.put(Tariff.class, new JdbcObjectModel<Tariff>(this) {});
		

	}

	
}
