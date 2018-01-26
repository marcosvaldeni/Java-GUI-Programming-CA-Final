package connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Instant;

public class CreateTickets {
	
	private Conn datas;
	private Connection conn;
	private Statement stmt;
	private int client;
	private String obs;
	private String sev;
	private long opened;
	
	

	public CreateTickets(int client, String obs, String sev) {
		this.client = client;
		this.obs = obs;
		this.sev = sev;
		this.opened =  Instant.now().getEpochSecond();
		
		datas = new Conn();
			
		try{
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			}catch(Exception e){}
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql:"+datas.getAddress()+":"+datas.getPort()+"/"+datas.getDbName()+"?user="+datas.getUser()+"&password="+datas.getPass());
			stmt = conn.createStatement();
			stmt.execute("INSERT INTO tickets (client_id, ticket_description, ticket_sev, ticket_opened) VALUES (" + this.client + ", '" + this.obs + "', '" + this.sev + "', " + this.opened + ");");

		}catch(SQLException ex){
			System.out.println("Exception: " + ex.getMessage());
			System.out.println("State: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}

	}
		
}
