package hcmus14hc.cnpm.airplaneticket.dao;

import hcmus14hc.cnpm.airplaneticket.pojo.TicketEntity;

public class TicketDAO extends BaseDAO{
	
	private static final String TABLE = "Ticket";
	// char(10)
	private static final String COL_TICKET_CODE = "ticket_code";
	// char(10)
	private static final String COL_PASSENGER_ID = "passenger_id";
	// varchar(45)
	private static final String COL_PASSENGER_NAME = "passenger_name";
	// char(11)
	private static final String COL_PASSENGER_PHONE = "passenger_phone_number";
	
	private static final String COL_REF_FLIGHT_ID = "Flight_flight_code";
	private static final String COL_REF_TICKETCLASS_ID = "TicketClass_id";
	
	public TicketDAO() {
		super();
	}
	
	public void store(TicketEntity entity) {
		
	}
}
