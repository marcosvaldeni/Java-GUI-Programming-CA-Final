package gui_admin;

import java.util.EventListener;

public interface CreateUserListener extends EventListener {
	public void createEventOccurred(CreateUserEvent e);
}
