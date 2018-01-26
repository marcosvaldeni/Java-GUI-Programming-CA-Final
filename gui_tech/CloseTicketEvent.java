package gui_tech;

import java.util.EventObject;

public class CloseTicketEvent extends EventObject {
	
	private int ticket_id;

	public CloseTicketEvent(Object souce) {
		super(souce);
	}
		
	public CloseTicketEvent(Object source, int ticket_id) {
		super(source);
		this.ticket_id = ticket_id;
	}

	public int getTicket_id() {
		return ticket_id;
	}

	public void setTicket_id(int ticket_id) {
		this.ticket_id = ticket_id;
	}
	
}
