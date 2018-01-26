package gui_tech;

import java.util.EventListener;

public interface CreateTicketListener extends EventListener {
	public void createEventOccurred(CreateTicketEvent e);
}
