package hcmus14hc.cnpm.airplaneticket.pojo;

public class TicketEntity {
	
	public enum TICKET_CLASS {BUSINESS, ECONOMIC};

	public final String ticketCode;
	public final String fligtCode;
	public final String passengerName;
	public final String passengerPhoneNumber;
	public final TICKET_CLASS ticketClass;
	
	public TicketEntity(String ticketCode, String fligtCode, String passengerName, String passengerPhoneNumber, TICKET_CLASS ticketClass) {
		this.ticketCode = ticketCode;
		this.fligtCode = fligtCode;
		this.passengerName = passengerName;
		this.passengerPhoneNumber = passengerPhoneNumber;
		this.ticketClass = ticketClass;
	}
	
	
}
