package hcmus14hc.cnpm.airplaneticket.dao;

public class AirportDAO extends BaseDAO{

	private static final String TABLE = "Airport";
	// int
	private static final String COL_ID = "id";
	// varchar(50)
	private static final String COL_AIRPORT_NAME = "airport_name";
	// decimal(6,6)
	private static final String COL_LATITUDE = "latitude";
	// decimal(6,6)
	private static final String COL_LONGTITUDE = "longitude";
	
	public AirportDAO() {
		super();
	}

}
