package hcmus14hc.cnpm.airplaneticket.dao;

import hcmus14hc.cnpm.airplaneticket.pojo.UserEntity;

import java.sql.SQLException;
import java.util.List;

import jtec.mylibs.jbdc.ContentValues;
import jtec.mylibs.jbdc.SQLQueryStatement;
import jtec.mylibs.jbdc.SQLUtils;

public class UserDAO extends BaseDAO {

	private static final String TABLE = "User";
	// char(6)
	private static final String COL_UID = "uid";
	// varchar(45)
	private static final String COL_USERNAME = "username";
	// tinyint(2)
	private static final String COL_ROLE = "role";

	public UserDAO() {
		super();
	}

	public UserEntity getUser(String uID, String pwd) {
		SQLUtils sqlUtils = null;
		try {
			sqlUtils = new SQLUtils(dbConn);
			SQLQueryStatement statement = new SQLQueryStatement.Builder(TABLE)
					.columns(new String[] { COL_UID, COL_USERNAME, COL_ROLE })
					.whereClause("uid=? & password =?")
					.whereArgs(new String[] { uID, pwd }).build();

			List<ContentValues<String, Object>> result = sqlUtils
					.query(statement);
			// user exist
			if (result.size() > 0) {
				ContentValues<String, Object> record = result.get(0);
				return new UserEntity(record.getAsInteger(COL_ROLE),
						record.getAsString(COL_UID),
						record.getAsString(COL_USERNAME));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(sqlUtils != null)
				sqlUtils.release();
		}
		return null;
	}
}
