package connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Ticket;
import model.User;

public class UserDetailTableConnection {
	
	private Conn datas;
    static List<User> dadas = new ArrayList<>();
    private User user;
	private Connection conn;
	private ResultSet rs;
	private Statement stmt;
	
	public UserDetailTableConnection(){
		
		datas = new Conn();
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql:"+datas.getAddress()+":"+datas.getPort()+"/"+datas.getDbName()+"?user="+datas.getUser()+"&password="+datas.getPass());
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT users.user_id, users.user_name, count(users.user_id) FROM tickets "
					+ "inner join users ON users.user_id = tickets.ticket_assigned "
					+ "group by tickets.ticket_assigned;");


			int i = 0;
			while(rs.next()) {
				user = new User(
						Integer.parseInt(rs.getString("users.user_id")),
						rs.getString("users.user_name"),
						Integer.parseInt(rs.getString("count(users.user_id)"))
						);
				dadas.add(user);
				i++;
			}
			
		}catch(SQLException ex){
			System.out.println("Exception: " + ex.getMessage());
			System.out.println("State: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}

	}
	
	public static List<User> getDados() {
		return dadas;
	}
		
}

