package MyDao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import MyPojo.AddDetails;

public class SaveDetails {

	public static int save(AddDetails ad){
		
		int status = 0;
		
		try{
			
			Connection con = GetCon.getConnection();
			
			PreparedStatement ps = con.prepareStatement("insert into userstb(id,fname,lname,ph,ctname,email,pass)values(?,?,?,?,?,?,?)");
			
			ps.setInt(1, ad.getId());
			ps.setString(2, ad.getFname());
			ps.setString(3, ad.getLname());
			ps.setString(4, ad.getPh());
			ps.setString(5, ad.getCtname());
			ps.setString(6, ad.getEmail());
			ps.setString(7, ad.getPass());
			
			status = ps.executeUpdate();
			
			con.close();
		}catch(Exception ex){
			
			ex.printStackTrace();
		}
		return status;
		
	}
}
