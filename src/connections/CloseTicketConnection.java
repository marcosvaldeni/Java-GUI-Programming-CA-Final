package connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Instant;

public class CloseTicketConnection {
	private Conn datas;
	private Connection conn;
	private Statement stmt;
	private int ticket_id;
	private long ticket_closed;

	public CloseTicketConnection(int ticket_id) {
		this.ticket_id = ticket_id;
		this.ticket_closed = Instant.now().getEpochSecond();
		
		datas = new Conn();

		try{
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			}catch(Exception e){}
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql:"+datas.getAddress()+":"+datas.getPort()+"/"+datas.getDbName()+"?user="+datas.getUser()+"&password="+datas.getPass());
			stmt = conn.createStatement();
			stmt.execute("UPDATE tickets SET ticket_closed = '" + ticket_closed + "' WHERE ticket_id = "+ this.ticket_id +";");

		}catch(SQLException ex){
			System.out.println("Exception: " + ex.getMessage());
			System.out.println("State: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}

	}
		
}