package gui_tech;

import java.util.EventObject;

public class UpdateTicketEvent extends EventObject {
	
	private int id;
	private int client;
	private String description;
	private String service;

	public UpdateTicketEvent(Object souce) {
		super(souce);
	}
		
	public UpdateTicketEvent(Object source, int id, int client, String description, String service) {
		super(source);
		this.id = id;
		this.client = client;
		this.description = description;
		this.service = service;
	}

	public int getClient() {
		return client;
	}

	public void setClient(int client) {
		this.client = client;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
