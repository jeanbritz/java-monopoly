package com.monopoly.models.db;

import java.sql.ResultSet;
import java.util.HashMap;

import com.monopoly.models.persistent.Tariff;

import za.co.neilson.sqlite.orm.DatabaseModel;
import za.co.neilson.sqlite.orm.jdbc.JdbcObjectModel;

public class TariffJdbcObjectModel extends JdbcObjectModel<Tariff> {

	public TariffJdbcObjectModel(DatabaseModel<ResultSet, HashMap<String, Object>> databaseModel)
			throws ClassNotFoundException, NoSuchFieldException {
		super(databaseModel);
		
	}

}
