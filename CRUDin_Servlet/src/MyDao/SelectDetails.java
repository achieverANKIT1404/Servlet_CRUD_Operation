package MyDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import MyPojo.AddDetails;

public class SelectDetails {

	public static AddDetails getUsersById(int id){
		
		AddDetails ad = new AddDetails();
		
		try{
			
			Connection con = GetCon.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from userstb where id=?");
			
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				
				ad.setId(rs.getInt(1));
				ad.setFname(rs.getString(2));
				ad.setLname(rs.getString(3));
				ad.setPh(rs.getString(4));
				ad.setCtname(rs.getString(5));
				ad.setEmail(rs.getString(6));
				ad.setPass(rs.getString(7));
			}
			con.close();
		}catch(Exception ex){
			
			ex.printStackTrace();
		}
		return ad;
	}
	
	public static ArrayList<AddDetails>  getAllUsers(){
		
		ArrayList<AddDetails> list = new ArrayList<AddDetails>();
		
try{
			
			Connection con = GetCon.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from userstb");
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				
				AddDetails ad = new AddDetails();
				
				ad.setId(rs.getInt(1));
				ad.setFname(rs.getString(2));
				ad.setLname(rs.getString(3));
				ad.setPh(rs.getString(4));
				ad.setCtname(rs.getString(5));
				ad.setEmail(rs.getString(6));
				ad.setPass(rs.getString(7));
				
				list.add(ad);
			}
			con.close();
		}catch(Exception ex){
			
			ex.printStackTrace();
		}
       return list;
     
	}
}
