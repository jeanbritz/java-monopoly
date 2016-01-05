package com.monopoly.models.db;

import java.lang.reflect.Type;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import com.monopoly.Asset;

import za.co.neilson.sqlite.orm.DatabaseDriverInterface;
import za.co.neilson.sqlite.orm.DatabaseInfo;
import za.co.neilson.sqlite.orm.DatabaseModel;
import za.co.neilson.sqlite.orm.ObjectModel;
import za.co.neilson.sqlite.orm.jdbc.JdbcObjectModel;
import za.co.neilson.sqlite.orm.jdbc.JdbcSqliteDatabaseDriverInterface;

public abstract class AbstractDatabaseModel extends DatabaseModel<ResultSet, HashMap<String, Object>> {

	public AbstractDatabaseModel(Object[] args) throws SQLException, ClassNotFoundException, NoSuchFieldException {
		super((Object[]) null);
		
	}
		
	@Override
	public String getDatabaseName() {
		return Asset.getDbName();
	}

	@Override
	public int getDatabaseVersion() {
		return Asset.getDbVersion();
	}

	@Override
	protected void onInsertDefaultValues() {
		// Nothing to insert
	}
	
	@Override
	public ObjectModel<DatabaseInfo, ResultSet, HashMap<String, Object>> onCreateDatabaseInfoModel()
			throws ClassNotFoundException, NoSuchFieldException {
				return new JdbcObjectModel<DatabaseInfo>(this) {
			};
	}
	
	@Override
	protected DatabaseDriverInterface<ResultSet, HashMap<String, Object>> onInitializeDatabaseDriverInterface(
			Object... arg0) {
			return new JdbcSqliteDatabaseDriverInterface(this);
	}
	
}
