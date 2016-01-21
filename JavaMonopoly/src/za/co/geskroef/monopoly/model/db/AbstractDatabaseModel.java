package za.co.geskroef.monopoly.model.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import za.co.geskroef.monopoly.Asset;
import za.co.neilson.sqlite.orm.DatabaseDriverInterface;
import za.co.neilson.sqlite.orm.DatabaseInfo;
import za.co.neilson.sqlite.orm.DatabaseModel;
import za.co.neilson.sqlite.orm.ObjectModel;
import za.co.neilson.sqlite.orm.jdbc.JdbcObjectModel;
import za.co.neilson.sqlite.orm.jdbc.JdbcSqliteDatabaseDriverInterface;

abstract class AbstractDatabaseModel extends DatabaseModel<ResultSet, HashMap<String, Object>> {

	protected AbstractDatabaseModel(Object[] args) throws SQLException, ClassNotFoundException, NoSuchFieldException {
		super((Object[]) args);
		
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
