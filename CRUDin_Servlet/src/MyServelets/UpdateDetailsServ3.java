package MyServelets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MyDao.SelectDetails;
import MyPojo.AddDetails;

@WebServlet("/serv3")
public class UpdateDetailsServ3 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String uid = request.getParameter("id");
		int id = Integer.parseInt(uid);
		
		AddDetails ad = SelectDetails.getUsersById(id);
		
		out.print("<html>");
		out.print("<head>");
		out.print("<title>Update</title>");
		out.print("<style>");
		
		out.print("body{ background-color:lavender; font-family:calibri;}");
	
		out.print(".frm{ background-color:#fff; width:36pc; height:30pc; padding:2px; border-radius:7px; margin-top:4pc;}");
		    
		out.print(".inp{height:25px; width:215px; margin-left:-15pc; font-size:14px;}");
		
	    out.print(".inp:hover{outline-color:choclate;}");
		
		out.print(".button{margin-left:-15pc;	background-color:darkgreen;border:none;	color:#fff;	font-weight:bold;padding:4px;	width:5pc;height:2pc;	border-radius:4px;cursor:pointer;}"); 
		
		out.print("h1{margin-left:-15pc;	color:teal;}");
		
		out.print("a{  margin-left:-15pc; text-decoration:none;}");
		
		out.print(".image{	width:19pc;height:19pc;}");
		
		out.print(".imge{ width:10pc; margin-left:39pc;margin-top:-24pc;}");
	
		out.print("</style>");
		out.print("</head>");
		out.print("<body>");
		
		out.print("<center>");
        out.print("<div class = 'frm'>");
        out.print("<form action='updatedetails' method = 'post'>");
        out.print("<h1>Update Info</h1>"); 
        out.print(" <input type = 'hidden'  name = 'id' value = '"+ad.getId()+"'/><br><br>");
        out.print(" <input type = 'text'  name = 'fname' class = 'inp' value = '"+ad.getFname()+"'/><br><br>");
        out.print(" <input type = 'text'  name = 'lname' class = 'inp' value = '"+ad.getLname()+"'/><br><br>");
        out.print(" <input type = 'text'  name = 'ph' class = 'inp' value = '"+ad.getPh()+"'/><br><br>");
        out.print(" <input type = 'text'  name = 'ctname' class = 'inp' value = '"+ad.getCtname()+"'/><br><br>");
        out.print(" <input type = 'email' name = 'email' class = 'inp' value = '"+ad.getEmail()+"'/><br><br>");
        out.print(" <input type = 'password'  name = 'pass' class = 'inp' value = '"+ad.getPass()+"'/><br><br>");

        out.print("<input type = 'submit' value = 'Update' name = 'btn' class = 'button'/><br><br>");       
               
        out.print("<a href = 'serv2'>View Users</a> ");   
      
	    out.print("</form>");
	    out.print("</div>"); 
	    out.print("</center>");
	    
	    out.print("<div class = 'imge'>"); 
        out.print("<img src = 'Img/update.png' class = 'image'>");
        out.print("</div>"); 
        
        out.print("</body>");
        out.print("</html>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
