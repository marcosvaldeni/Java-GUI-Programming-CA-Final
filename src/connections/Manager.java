package connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Ticket;

public class Manager {
	private Conn datas;
	private Connection conn;
	private ResultSet rs;
	private Statement stmt;
	private int ticketsTotal;
	private int techUser;
	private int ticketsOpened;
	private int ticketsClosed;
	
	public Manager(){
		
		datas = new Conn();
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql:"+datas.getAddress()+":"+datas.getPort()+"/"+datas.getDbName()+"?user="+datas.getUser()+"&password="+datas.getPass());
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery("SELECT COUNT(*) FROM tickets WHERE ticket_closed > 0;");
			if(rs.next()) {
				ticketsClosed = rs.getInt("COUNT(*)");
			}
			
			rs = stmt.executeQuery("SELECT COUNT(*) FROM tickets WHERE ticket_closed = 0;");
			if(rs.next()) {
				ticketsOpened = rs.getInt("COUNT(*)");
			}
			
			rs = stmt.executeQuery("SELECT COUNT(*) FROM tickets;");
			if(rs.next()) {
				ticketsTotal = rs.getInt("COUNT(*)");
			}
			
			rs = stmt.executeQuery("SELECT COUNT(*) FROM users WHERE user_type = 3;");
			if(rs.next()) {
				techUser = rs.getInt("COUNT(*)");
			}
			

			
		}catch(SQLException ex){
			System.out.println("Exception: " + ex.getMessage());
			System.out.println("State: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}

	}

	public int getTicketsTotal() {
		return ticketsTotal;
	}

	public void setTicketsTotal(int ticketsTotal) {
		this.ticketsTotal = ticketsTotal;
	}

	public int getTechUser() {
		return techUser;
	}

	public void setTechUser(int techUser) {
		this.techUser = techUser;
	}

	public int getTicketsOpened() {
		return ticketsOpened;
	}

	public void setTicketsOpened(int ticketsOpened) {
		this.ticketsOpened = ticketsOpened;
	}

	public int getTicketsClosed() {
		return ticketsClosed;
	}

	public void setTicketsClosed(int ticketsClosed) {
		this.ticketsClosed = ticketsClosed;
	}
	
}
