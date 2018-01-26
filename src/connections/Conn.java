package connections;

public class Conn {
	
	private String address;
	private String user;
	private String pass;
	private String dbName;
	private String port;
	
	public Conn() {
		this.dbName = "ticketscontrol";
		this.user = "root";
		this.pass = "";
		this.port = "3306";
		this.address = "//localhost";
	}

	public String getAddress() {
		return address;
	}

	public String getUser() {
		return user;
	}

	public String getPass() {
		return pass;
	}

	public String getDbName() {
		return dbName;
	}

	public String getPort() {
		return port;
	}
	
	
	
	
	
}
