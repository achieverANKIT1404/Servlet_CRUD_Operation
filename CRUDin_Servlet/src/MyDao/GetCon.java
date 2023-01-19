package MyDao;

import java.sql.Connection;
import java.sql.DriverManager;

public class GetCon {

	public static Connection getConnection(){
		
		Connection con = null;
		
		String url="jdbc:mysql://localhost:3306/UserAdd",uname="root",passwrd="abc123";
		
		try{
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection(url,uname,passwrd);
			
		}catch(Exception e){
			
			System.out.println(e);
		}
		return con;
	}
}
