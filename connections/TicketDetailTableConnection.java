package connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Ticket;

public class TicketDetailTableConnection {
	private Conn datas;
    static List<Ticket> tadas = new ArrayList<>();
    private Ticket ticket;
	private Connection conn;
	private ResultSet rs;
	private Statement stmt;
	
	public TicketDetailTableConnection(){
		
		datas = new Conn();
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql:"+datas.getAddress()+":"+datas.getPort()+"/"+datas.getDbName()+"?user="+datas.getUser()+"&password="+datas.getPass());
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM tickets WHERE ticket_closed != 0;");

			int i = 0;
			while(rs.next()) {
				ticket = new Ticket(Integer.parseInt(rs.getString("ticket_id")),
						Integer.parseInt(rs.getString("client_id")), 
						rs.getString("ticket_description"), 
						rs.getString("ticket_sev"), 
						Long.parseLong(rs.getString("ticket_opened")),
						Long.parseLong(rs.getString("ticket_closed")),
						Integer.parseInt(rs.getString("ticket_assigned")));
				tadas.add(ticket);
				i++;
			}
		}catch(SQLException ex){
			System.out.println("Exception: " + ex.getMessage());
			System.out.println("State: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}

	}
	
	public static List<Ticket> getDados() {
		return tadas;
	}
		
}

