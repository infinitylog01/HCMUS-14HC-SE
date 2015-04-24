package hcmus14hc.cnpm.airplaneticket;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import jtec.mylibs.jbdc.ContentValues;
import jtec.mylibs.jbdc.SQLQueryStatement;
import jtec.mylibs.jbdc.SQLUpdateStatement;
import jtec.mylibs.jbdc.SQLUtils;

public final class Config {

	private static final String TABLE = "Configuration";
	private static final String COL_MIN_FLY_TIME = "min_fly_time";
	private static final String COL_MAX_INTER_AIRPORT = "max_intermediate_airport";
	private static final String COL_MIN_STOP_TIME = "min_stop_time";
	private static final String COL_MAX_STOP_TIME = "max_stop_time";
	private static final String COL_LIMIT_TIME_BOOK_TICKET = "limit_time_book_ticket";
	private static final String COL_LIMIT_TIME_ABORT_TICKET = "limit_time_abort_ticket";

	// minimum fly time (time unit: seconds)
	private static long MINIMUM_FLY_TIME = 0;
	// maximum amount of intermediate airport
	private static int MAXIMUM_INTERMEDIATE_AIRPORT = 0;
	// minimum rest time (time unit: seconds)
	private static long MINIMUM_STOP_TIME = 0;
	// maximum rest time (time unit: seconds)
	private static long MAXIMUM_STOP_TIME = 0;
	// limit time to book a ticket (from depart time to now - time unit:
	// seconds)
	private static long LIMIT_TIME_BOOK_TICKET = 0;
	// limit time to abort a ticket (from depart time to now - time unit:
	// seconds)
	private static long LIMIT_TIME_ABORT_TICKET = 0;

	static void loadConfig() {
		/*
		 * Statement statement = db_conn.createStatement(); String sql =
		 * "SELECT * FROM configuration"; ResultSet rs =
		 * statement.executeQuery(sql); while(rs.next()) { MINIMUM_FLY_TIME =
		 * rs.getInt(1); MAXIMUM_INTERMEDIATE_AIRPORT = rs.getInt(2);
		 * MINIMUM_STOP_TIME = rs.getInt(3); MAXIMUM_STOP_TIME = rs.getInt(4); }
		 * statement.close();
		 */
		Connection conn = DBConnectionPool.openConnection();
		SQLUtils sqlUtils = null;
		try {
			sqlUtils = new SQLUtils(conn);
			SQLQueryStatement statement = new SQLQueryStatement.Builder(TABLE)
					.build();
			List<ContentValues<String, Object>> rs = sqlUtils.query(statement);
			ContentValues<String, Object> value = rs.get(0);
			MINIMUM_FLY_TIME = value.getAsInteger(COL_MIN_FLY_TIME) * 1000;
			MAXIMUM_INTERMEDIATE_AIRPORT = value.getAsInteger(COL_MAX_INTER_AIRPORT);
			MINIMUM_STOP_TIME = value.getAsInteger(COL_MIN_STOP_TIME) * 1000;
			MAXIMUM_STOP_TIME = value.getAsInteger(COL_MAX_STOP_TIME) * 1000;
			LIMIT_TIME_BOOK_TICKET = value.getAsInteger(COL_LIMIT_TIME_BOOK_TICKET) * 1000;
			LIMIT_TIME_ABORT_TICKET = value.getAsInteger(COL_LIMIT_TIME_ABORT_TICKET) * 1000;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (sqlUtils != null)
					sqlUtils.release();
			DBConnectionPool.closeConnection(conn);
		}

		// System.out.println(String.format("%d - %d - %d - %d",
		// MINIMUM_FLY_TIME, MAXIMUM_INTERMEDIATE_AIRPORT, MINIMUM_STOP_TIME,
		// MAXIMUM_STOP_TIME));
	}

	/**
	 * setting value to zero will not make changes
	 * 
	 * @param arg0
	 *            minimum fly time (time unit: seconds)
	 * @param arg1
	 *            maximum amount of intermediate airport
	 * @param arg2
	 *            minimum rest time (time unit: seconds)
	 * @param arg3
	 *            maximum rest time (time unit: seconds)
	 * @param arg4
	 *            limit time to book a ticket(time unit: seconds)
	 * @param arg5
	 *            limit time to abort a ticket (time unit: seconds)
	 * @throws SQLException
	 */
	static void update(long arg0, int arg1, long arg2, long arg3, long arg4, long arg5) {
		
		arg0 = arg0 == 0 ? MINIMUM_FLY_TIME : arg0 / 1000;
		arg1 = arg1 == 0 ? MAXIMUM_INTERMEDIATE_AIRPORT : arg1;
		arg2 = arg2 == 0 ? MINIMUM_STOP_TIME : arg2 / 1000;
		arg3 = arg3 == 0 ? MAXIMUM_STOP_TIME : arg3 / 1000;
		arg4 = arg4 == 0 ? LIMIT_TIME_BOOK_TICKET : arg4 / 1000;
		arg5 = arg5 == 0 ? LIMIT_TIME_ABORT_TICKET : arg5 / 1000;
		
		ContentValues<String, Object> contentValues = new ContentValues<>();
		contentValues.put(COL_MIN_FLY_TIME, arg0);
		contentValues.put(COL_MAX_INTER_AIRPORT, arg1);
		contentValues.put(COL_MIN_STOP_TIME, arg2);
		contentValues.put(COL_MAX_STOP_TIME, arg3);
		contentValues.put(COL_LIMIT_TIME_BOOK_TICKET, arg4);
		contentValues.put(COL_LIMIT_TIME_ABORT_TICKET, arg5);
		
		Connection conn = DBConnectionPool.openConnection();
		SQLUtils sqlUtils = null;
		try {
			sqlUtils = new SQLUtils(conn);
			SQLUpdateStatement statement = new SQLUpdateStatement.Builder(TABLE, contentValues).build();
			int val = sqlUtils.update(statement);
			if(val > 0) {
				System.out.println("Successfully update Configuration");
				// TODO handle Configuration changed
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(sqlUtils != null) {
				sqlUtils.release();
			}
			DBConnectionPool.closeConnection(conn);
		}
		
	}

	/**
	 * 
	 * @return minimum fly time (time unit: seconds)
	 */
	public static long MINIMUM_FLY_TIME() {
		return MINIMUM_FLY_TIME;
	}

	/**
	 * 
	 * @return maximum amount of intermediate airport
	 */
	public static int MAXIMUM_INTERMEDIATE_AIRPORT() {
		return MAXIMUM_INTERMEDIATE_AIRPORT;
	}

	/**
	 * 
	 * @return minimum rest time (time unit: seconds)
	 */
	public static long MINIMUM_STOP_TIME() {
		return MINIMUM_STOP_TIME;
	}

	/**
	 * 
	 * @return maximum rest time (time unit: seconds)
	 */
	public static long MAXIMUM_STOP_TIME() {
		return MAXIMUM_STOP_TIME;
	}

	/**
	 * 
	 * @return limit time to book a ticket (from depart time to now - time unit:
	 *         seconds)
	 */
	public static long LIMIT_TIME_BOOK_TICKET() {
		return LIMIT_TIME_BOOK_TICKET;
	}

	/**
	 * 
	 * @return limit time to abort a ticket (from depart time to now - time
	 *         unit: seconds)
	 */
	public static long LIMIT_TIME_ABORT_TICKET() {
		return LIMIT_TIME_ABORT_TICKET;
	}

}
