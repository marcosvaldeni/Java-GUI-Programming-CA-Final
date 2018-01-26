package gui_login;

import java.util.EventListener;

public interface LoginListener extends EventListener {
	public void loginEventOccurred(LoginEvent e);
}
