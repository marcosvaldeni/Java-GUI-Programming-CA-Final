package model;

public class User {
	
	private int id;
	private String name;
	private String login;
	private int type;
	private String pass;
	private int numberTicket;
	private long averageTime;
	
	public User() {
	}
	
	public User(int type) {
		this.type = type;
	}
	
	public User(int id, String name, String login, int type, String pass) {
		this.id = id;
		this.name = name;
		this.login = login;
		this.type = type;
		this.pass = pass;
	}
	
	public User(int id, String name, String login, int type) {
		this.id = id;
		this.name = name;
		this.login = login;
		this.type = type;
	}
		
	public User(int id, String name, int numberTicket) {
		this.id = id;
		this.name = name;
		this.numberTicket = numberTicket;
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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public int getNumberTicket() {
		return numberTicket;
	}

	public void setNumberTicket(int numberTicket) {
		this.numberTicket = numberTicket;
	}

	public long getAverageTime() {
		return averageTime;
	}

	public void setAverageTime(long averageTime) {
		this.averageTime = averageTime;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
		
}
