package hcmus14hc.cnpm.airplaneticket.dao;

public class TicketClassDAO extends BaseDAO{

	private static final String TABLE = "TicketClass";
	// int
	private static final String COL_ID = "id";
	// varchar(45)
	private static final String COL_TICKET_NAME = "ticket_name";
	// decimal(5,2)
	private static final String COL_PRICE = "price";
	
	public TicketClassDAO() {
		super();
	}
}
