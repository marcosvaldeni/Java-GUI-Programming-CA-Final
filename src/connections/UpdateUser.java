package connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateUser {
	
	private Conn datas;
	private Connection conn;
	private Statement stmt;
	private int id;
	private String name;
	private int type;
	private String pass;
	private String username;
	
	public UpdateUser(int id, String name, String username, String pass, int type) {
		this.id = id;
		this.name = name;
		this.username = username;
		this.type = type;
		this.pass = pass;
		
		datas = new Conn();
			
		try{
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			}catch(Exception e){}
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql:"+datas.getAddress()+":"+datas.getPort()+"/"+datas.getDbName()+"?user="+datas.getUser()+"&password="+datas.getPass());
			stmt = conn.createStatement();
			stmt.execute("UPDATE users SET user_name = '" + this.name + "', user_login = '" + this.username + "', user_pass = '" + this.pass + "', user_type = " + this.type + " WHERE user_id = "+ this.id +";");
			
		}catch(SQLException ex){
			System.out.println("Exception: " + ex.getMessage());
			System.out.println("State: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}

	}
		
}