package gui_admin;

import java.util.EventObject;

public class UpdateUserEvent extends EventObject {
	
	private int id;
	private String name;
	private String username;
	private int type;
	private String pass;

	public UpdateUserEvent(Object souce) {
		super(souce);
	}
		
	public UpdateUserEvent(Object source, int id, String name, String username, String pass, int type) {
		super(source);
		this.id = id;
		this.name = name;
		this.username = username;
		this.type = type;
		this.pass = pass;
	}
	
	public UpdateUserEvent(Object source, int id, String pass) {
		super(source);
		this.id = id;
		this.pass = pass;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
}
