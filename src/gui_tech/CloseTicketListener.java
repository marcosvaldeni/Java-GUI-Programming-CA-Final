package gui_tech;

import java.util.EventListener;

public interface CloseTicketListener extends EventListener {
	public void closeTicketEventOccurred(CloseTicketEvent e);
}
