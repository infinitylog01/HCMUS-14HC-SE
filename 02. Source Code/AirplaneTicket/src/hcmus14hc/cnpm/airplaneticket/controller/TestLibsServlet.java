package hcmus14hc.cnpm.airplaneticket.controller;

import hcmus14hc.cnpm.airplaneticket.DBConnectionPool;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jtec.mylibs.jbdc.ContentValues;
import jtec.mylibs.jbdc.SQLDeleteStatement;
import jtec.mylibs.jbdc.SQLInsertStatement;
import jtec.mylibs.jbdc.SQLQueryStatement;
import jtec.mylibs.jbdc.SQLUpdateStatement;
import jtec.mylibs.jbdc.SQLUtils;

public class TestLibsServlet extends HttpServlet {
	
	private static final String TABLE = "User";
	// char(6)
	private static final String COL_UID = "uid";
	
	private static final String COL_PASSWORD = "password";
	// varchar(45)
	private static final String COL_USERNAME = "username";
	// tinyint(1)
	private static final String COL_ROLE = "role";

	/**
	 * 
	 */
	private static final long serialVersionUID = 5882032549993929193L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("start: " + System.currentTimeMillis());
		testInsert(); 
		testQuery();
		testUpdate();
		testQuery();
		testDelete();
		System.out.println("end: " + System.currentTimeMillis());
	}

	// passed
	private void testQuery() {
		Connection conn = DBConnectionPool.openConnection();
		SQLUtils sqlUtils = new SQLUtils(conn);
		SQLQueryStatement statement;
		try {										// ten table
			statement = new SQLQueryStatement.Builder(TABLE)
					// cac columns can lay
					.columns(
							new String[] { COL_UID,
									COL_USERNAME,
									COL_PASSWORD,
									COL_ROLE})
					// cau lenh where
					.whereClause("uid = ?")
					// tham so cho dau ?
					.whereArgs(new String[] { "245308" }).build();

			List<ContentValues<String, Object>> rs = sqlUtils.query(statement);

			ContentValues<String, Object> value = rs.get(0);
			String uid = value.getAsString(COL_UID);
			String username = value.getAsString(COL_USERNAME);
			String password = value.getAsString(COL_PASSWORD);
			int role = value.getAsInteger(COL_ROLE);
			
			System.out.println("uid: " + uid);
			System.out.println("username: " + username);
			System.out.println("pass: " + password);
			System.out.println("role: " + role);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(sqlUtils != null)
				sqlUtils.release();
			DBConnectionPool.closeConnection(conn);
		}
	}

	private void testUpdate() {
		Connection conn = DBConnectionPool.openConnection();
		SQLUtils sqlUtils = new SQLUtils(conn);
		SQLUpdateStatement statement;
		try {
			ContentValues<String, Object> value = new ContentValues<>();
			value.put("role", 2);

			statement = new SQLUpdateStatement.Builder(TABLE, value)
			.whereClause("uid = ?")
			.whereArgs(new String[] {"245308"})
			.build();
			
			sqlUtils.update(statement);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(sqlUtils != null)
				sqlUtils.release();
			DBConnectionPool.closeConnection(conn);
		}
	}
	
	private void testInsert() {
		Connection conn = DBConnectionPool.openConnection();
		SQLUtils sqlUtils = new SQLUtils(conn);
		SQLInsertStatement statement;
		try {
			ContentValues<String, Object> value = new ContentValues<>();
			value.put(COL_UID, "245308");
			value.put(COL_USERNAME, "Trịnh Văn Vinh");
			value.put(COL_PASSWORD, "123456");
			value.put(COL_ROLE, 1);

			statement = new SQLInsertStatement.Builder(TABLE, value)
			.build();
			
			sqlUtils.insert(statement);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			sqlUtils.release();
			DBConnectionPool.closeConnection(conn);
		}
	}
	
	private void testDelete() {
		Connection conn = DBConnectionPool.openConnection();
		SQLUtils sqlUtils = new SQLUtils(conn);
		try {

			SQLDeleteStatement statement = new SQLDeleteStatement.Builder(TABLE)
			.whereClause("uid = ?")
			.whereArgs(new String[] {"245308"})
			.build();
			
			sqlUtils.delete(statement);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(sqlUtils != null)
				sqlUtils.release();
			DBConnectionPool.closeConnection(conn);
		}
	}
}
