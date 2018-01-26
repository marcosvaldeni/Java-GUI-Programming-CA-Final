package gui_tech;

import java.util.EventObject;

public class CreateTicketEvent extends EventObject {
	
	private int client;
	private String description;
	private String service;

	public CreateTicketEvent(Object souce) {
		super(souce);
	}
		
	public CreateTicketEvent(Object source, int client, String description, String service) {
		super(source);
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

}
