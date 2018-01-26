package connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Instant;

public class CreateUser {
	private Conn datas;
	private Connection conn;
	private Statement stmt;
	private String name;
	private String username;
	private String pass;
	private int type;
		
	public CreateUser(String name, String username, String pass, int type) {
		this.name = name;
		this.username = username;
		this.pass = pass;
		this.type = type;
		
		datas = new Conn();
			
		try{
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			}catch(Exception e){}
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql:"+datas.getAddress()+":"+datas.getPort()+"/"+datas.getDbName()+"?user="+datas.getUser()+"&password="+datas.getPass());
			stmt = conn.createStatement();
			stmt.execute("INSERT INTO users (user_name, user_login, user_pass, user_type) VALUES ('" + this.name + "', '" + this.username + "', '" + this.pass + "', " + this.type + ");");

		}catch(SQLException ex){
			System.out.println("Exception: " + ex.getMessage());
			System.out.println("State: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}

	}
		
}
