package model;

public class Ticket {
    
    private int id;
    private int clientId;
    private String description;
    private String sev;
    private long opened;
    private long closed;
    private int assigned;
    
    public Ticket() {
	}
        	
    public Ticket(int id, int clientId, String description, String sev, long opened, long closed, int assigned) {
		this.id = id;
		this.clientId = clientId;
		this.description = description;
		this.sev = sev;
		this.opened = opened;
		this.closed = closed;
		this.assigned = assigned;
	}

    public Ticket(int id, int clientId, String description, String sev, long opened, int assigned) {
		this.id = id;
		this.clientId = clientId;
		this.description = description;
		this.sev = sev;
		this.opened = opened;
		this.assigned = assigned;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSev() {
		return sev;
	}

	public void setSev(String sev) {
		this.sev = sev;
	}

	public long getOpened() {
		return opened;
	}

	public void setOpened(long opened) {
		this.opened = opened;
	}

	public long getClosed() {
		return closed;
	}

	public void setClosed(long closed) {
		this.closed = closed;
	}

	public int getAssigned() {
		return assigned;
	}

	public void setAssigned(int assigned) {
		this.assigned = assigned;
	}
	    
}
