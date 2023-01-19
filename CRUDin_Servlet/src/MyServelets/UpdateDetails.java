package MyServelets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MyDao.UpdateUser;
import MyPojo.AddDetails;

@WebServlet("/updatedetails")
public class UpdateDetails extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String uid = request.getParameter("id");
		int id = Integer.parseInt(uid);
		
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String ph = request.getParameter("ph");
		String ctname = request.getParameter("ctname");
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		
		AddDetails ad = new AddDetails();
		
		ad.setId(id);
		ad.setFname(fname);
		ad.setLname(lname);
		ad.setPh(ph);
		ad.setCtname(ctname);
		ad.setEmail(email);
		ad.setPass(pass);
		
		int status = UpdateUser.update(ad);
		if(status>0){
			
			response.sendRedirect("serv2");
		}
		else{
			
			out.print("Sorry!, Unable to update details..");
		}
		out.close();
	}

}
