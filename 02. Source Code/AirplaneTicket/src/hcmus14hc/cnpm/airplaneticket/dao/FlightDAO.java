package hcmus14hc.cnpm.airplaneticket.dao;

public class FlightDAO extends BaseDAO{
	
	private static final String TABLE = "Flight";
	// char(10)
	private static final String COL_FLIGHT_CODE = "flight_code";
	
	// int (because maximum INT value type in mysql is 4294967295)
	// then when you compute, you must *10.000 to convert to TimeInMilis
	// divider for 10.000 when store to db
	private static final String COL_DEPART_TIME = "depart_time";
	
	// medium int
	// *1000 to convert to TimeInMilis
	// divider for 1000 when store to db
	private static final String COL_DURATION = "duration";
	// small int(3)
	private static final String COL_BUSINESS_TICKET_AMOUNT = "business_class_tickets";
	// small int(3)
	private static final String COL_ECONOMY_TICKET_AMOUNT = "ecomomy_class_tickets";
	// text json
	private static final String COL_ROUTE = "flight_route";
	
	public FlightDAO() {
		super();
	}
	
}
