package connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.User;

public class ReadUser {
	
	private Conn datas;
    static List<User> dados = new ArrayList<>();
    private User user;
	private Connection conn;
	private ResultSet rs;
	private Statement stmt;
	
	public ReadUser(){
		
		datas = new Conn();
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql:"+datas.getAddress()+":"+datas.getPort()+"/"+datas.getDbName()+"?user="+datas.getUser()+"&password="+datas.getPass());
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM users;");

			int i = 0;
			while(rs.next()) {
				user = new User(Integer.parseInt(rs.getString("user_id")),
						rs.getString("user_name"), 
						rs.getString("user_login"), 
						Integer.parseInt(rs.getString("user_type")),
						rs.getString("user_pass"));
				dados.add(user);
				i++;
			}
		}catch(SQLException ex){
			System.out.println("Exception: " + ex.getMessage());
			System.out.println("State: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}

	}
	
	public static List<User> getDados() {
		return dados;
	}
		
}
