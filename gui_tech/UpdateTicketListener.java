package gui_tech;

import java.util.EventListener;

public interface UpdateTicketListener extends EventListener {
	public void updateTicketEventOccurred(UpdateTicketEvent e);
}
