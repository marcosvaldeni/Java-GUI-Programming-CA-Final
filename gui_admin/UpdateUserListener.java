package gui_admin;

import java.util.EventListener;

public interface UpdateUserListener extends EventListener {
	public void updateTicketEventOccurred(UpdateUserEvent e);
}
