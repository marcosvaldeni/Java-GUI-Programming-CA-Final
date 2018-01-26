package connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateTickets {
	private Conn datas;
	private Connection conn;
	private Statement stmt;
	private int id;
	private int client;
	private String obs;
	private String sev;
	
	public UpdateTickets(int id, int client, String obs, String sev) {
		this.id = id;
		this.client = client;
		this.obs = obs;
		this.sev = sev;
		
		datas = new Conn();
			
		try{
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			}catch(Exception e){}
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql:"+datas.getAddress()+":"+datas.getPort()+"/"+datas.getDbName()+"?user="+datas.getUser()+"&password="+datas.getPass());
			stmt = conn.createStatement();
			stmt.execute("UPDATE tickets SET ticket_description = '" + obs + "', ticket_sev = '" + sev + "' WHERE ticket_id = "+ id +";");
			
		}catch(SQLException ex){
			System.out.println("Exception: " + ex.getMessage());
			System.out.println("State: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}

	}
		
}