package MyDao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeleteUser {

	public static int delete(int id){
		
		int status = 0;
		
		try{
			
			Connection con = GetCon.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from userstb where id=?");
			
			ps.setInt(1, id);
			status = ps.executeUpdate();
			
		}catch(Exception ex){
			
			ex.printStackTrace();
		}
		return status;
	}
}
