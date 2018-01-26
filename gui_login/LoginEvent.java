package gui_login;

import java.util.EventObject;


public class LoginEvent extends EventObject {
	
	private String login;
	private String pass;

	public LoginEvent(Object souce) {
		super(souce);
	}

	public LoginEvent(Object souce, String login, String pass) {
		super(souce);
		this.login = login;
		this.pass = pass;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

}
