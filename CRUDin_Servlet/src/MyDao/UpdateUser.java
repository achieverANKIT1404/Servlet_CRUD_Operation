package MyDao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import MyPojo.AddDetails;

public class UpdateUser {

	public static int update(AddDetails ad){
		
		int status = 0;
		
		try{
			
			Connection con = GetCon.getConnection();
			PreparedStatement ps = con.prepareStatement("update userstb set fname=?,lname=?,ph=?,ctname=?,email=?,pass=? where id=?");
		
			ps.setString(1, ad.getFname());
			ps.setString(2, ad.getLname());
			ps.setString(3, ad.getPh());
			ps.setString(4, ad.getCtname());
			ps.setString(5, ad.getEmail());
			ps.setString(6, ad.getPass());
			ps.setInt(7, ad.getId());
			
			status = ps.executeUpdate();
			
			con.close();
		}catch(Exception ex){
			
			ex.printStackTrace();
		}
		return status;
	}
}
