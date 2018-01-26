package connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.User;

public class LoginConnection {
	private Conn datas;
	private Connection conn;
	private ResultSet rs;
	private Statement stmt;
	private String login;
	private String pass;
	private User user;
	
	public LoginConnection(String login, String pass){
		this.pass = pass;
		this.login = login;
		
		datas = new Conn();
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql:"+datas.getAddress()+":"+datas.getPort()+"/"+datas.getDbName()+"?user="+datas.getUser()+"&password="+datas.getPass());
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM users WHERE user_login = '" + this.login + "' and user_pass = '" + this.pass + "';");

			if(rs.next()) {
				user = new User(Integer.parseInt(rs.getString("user_id")),rs.getString("user_login"),rs.getString("user_pass"),Integer.parseInt(rs.getString("user_type")));
			} else {
				user = new User(0,"","",0);
			}

		}catch(SQLException ex){
			System.out.println("Exception: " + ex.getMessage());
			System.out.println("State: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}

	}
	
	public User getUser() {
		return this.user;
	}
	
}
