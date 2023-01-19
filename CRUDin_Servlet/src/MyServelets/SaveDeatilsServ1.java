package MyServelets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MyDao.SaveDetails;
import MyPojo.AddDetails;

@WebServlet("/serv1")
public class SaveDeatilsServ1 extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("id");
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String ph = request.getParameter("ph");
		String ctname = request.getParameter("ctname");
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");

		AddDetails ad = new AddDetails();
		ad.setFname(fname);
		ad.setLname(lname);
		ad.setPh(ph);
		ad.setCtname(ctname);
		ad.setEmail(email);
		ad.setPass(pass);
		
	/*if(fname.equals("")|| lname.equals("") || ph.equals("") || ctname.equals("") || email.equals("")||pass.equals("")){
			
			out.print("<center><p style = 'background-color:maroon; color:#fff; width:15pc;padding:5px; border-radius:6px; margin-top:3pc; font-weight:bold;'>All Fields Are Required!</p></center>");
			request.getRequestDispatcher("index.html").include(request, response);
		}*/

		int status = SaveDetails.save(ad);
		if(status>0){
			
			out.print("<center><p style = 'background-color:green; color:#fff; width:15pc;padding:5px; border-radius:6px; margin-top:3pc; font-weight:bold;'>User Registered Succesfully..</p></center>");
			request.getRequestDispatcher("index.html").include(request, response);
		}
		else{
			
			out.print("<p>Sorry! Unable to save details..</p>");
		}
		out.close();
	}
}
