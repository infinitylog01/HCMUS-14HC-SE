package hcmus14hc.cnpm.airplaneticket;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public final class Config {
	// max fly time (time unit: seconds)
	private static int MINIMUM_FLY_TIME;
	// maximum amount of intermediate airport
	private static int MAXIMUM_INTERMEDIATE_AIRPORT;
	// minimum rest time (time unit: seconds)
	private static int MINIMUM_STOP_TIME;
	// maximum rest time (time unit: seconds)
	private static int MAXIMUM_STOP_TIME;
	
	static void loadConfig(Connection db_conn) throws SQLException {
		Statement statement = db_conn.createStatement();
        String sql = "SELECT * FROM configuration";
        ResultSet rs = statement.executeQuery(sql);
        while(rs.next()) {
        	MINIMUM_FLY_TIME = rs.getInt(1);
        	MAXIMUM_INTERMEDIATE_AIRPORT = rs.getInt(2);
        	MINIMUM_STOP_TIME = rs.getInt(3);
        	MAXIMUM_STOP_TIME = rs.getInt(4);
        }
        statement.close();
        rs.close();
	}
	
	/**
	 * 
	 * @param db_conn
	 * @param arg0 minimum_fly_time
	 * @param arg1 maximum_intermediate_airport_amount
	 * @param arg2
	 * @param arg3
	 * @throws SQLException
	 */
	static void update(Connection db_conn, int arg0, int arg1, int arg2, int arg3) throws SQLException {
//		StringBuilder strBuilder = new StringBuilder("UPDATE configuration SET ");
		
		Statement statement = db_conn.createStatement();
		String sql = "UPDATE configuration SET minimum_fly_time = " + (arg0 > 0 ? arg0 : MINIMUM_FLY_TIME) +
											", maximum_intermediate_airport_amount = " + (arg1 > 0 ? arg1 : MAXIMUM_INTERMEDIATE_AIRPORT) +
											", minimum_stop_time = " + (arg2 > 0 ? arg2 : MINIMUM_STOP_TIME) +
											", maximum_stop_time = " + (arg3 > 0 ? arg3 : MAXIMUM_STOP_TIME);
		if(statement.execute(sql)) {
			System.out.println("Successfully update configuration table");
		}
		statement.close();
	}

	/**
	 * 
	 * @return max fly time (time unit: seconds)
	 */
	public static int MINIMUM_FLY_TIME() {
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
	public static int MINIMUM_STOP_TIME() {
		return MINIMUM_STOP_TIME;
	}

	/**
	 * 
	 * @return maximum rest time (time unit: seconds)
	 */
	public static int MAXIMUM_STOP_TIME() {
		return MAXIMUM_STOP_TIME;
	}
	
	/*public static class Builder{
		private Connection conn;
		private int minimumFlyTime;
		private int maximumIntermediateAirport;
		private int minimumStopTime;
		private int maximumStopTime;
		
		public Builder() {
			
		}
		
		public Builder dbConnection(Connection conn) {
			this.conn = conn;
			return this;
		}
		
		public Builder minimumFlyTime(int arg) {
			this.minimumFlyTime = arg;
			return this;
		}
		
		public Builder maximumIntermediateAirport(int arg) {
			this.maximumIntermediateAirport = arg;
			return this;
		}
		
		public Builder minimumStopTime(int arg) {
			this.minimumStopTime = arg;
			return this;
		}
		
		public Builder maximumStopTime(int arg) {
			this.maximumStopTime = arg;
			return this;
		}
		
		public createConfig() {
			return new Config(conn, minimumFlyTime, maximumIntermediateAirport, minimumStopTime, maximumStopTime);
		}
	}*/
}
