package gui_admin;

import java.util.EventObject;

public class CreateUserEvent extends EventObject {
	
	private String name;
	private String username;
	private String pass;
	private int type;

	public CreateUserEvent(Object souce) {
		super(souce);
	}

	public CreateUserEvent(Object source, String name, String username, String pass, int type) {
		super(source);
		this.name = name;
		this.username = username;
		this.pass = pass;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

}
