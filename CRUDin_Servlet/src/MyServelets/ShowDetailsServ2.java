package MyServelets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MyDao.SelectDetails;
import MyPojo.AddDetails;

@WebServlet("/serv2")
public class ShowDetailsServ2 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<div style = 'margin-left:75%; margin-top:4pc; background-color:midnightblue; width:5pc; border-radius:5px; padding:5px; '><center><a href = 'index.html' style = 'color:#fff; font-weight:bold; font-size:13px; text-decoration:none;'>Add New</a></center></div>");
		
		out.print("<html>");
		out.print("<head>");
		out.print("<title>Show</title>");
		
		out.println("<link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css'><script src='https://cdn.jsdelivr.net/npm/jquery@3.6.1/dist/jquery.slim.min.js'></script><script src='https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js'></script><script src='https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js'></script>");

		out.print("<style>");
		
		out.print("body{background-color:lavender;}");
		
		out.print("table{width:50pc; height:7pc; padding:5pc;background-color:white;border-radius:6px;}");
		
		out.print("h1{text-align:center; margin-bottom:2pc; color:darkorange;}");
		
		out.print("th{text-align:center; background-color:lightseagreen; color:white; width:9pc; height:2pc;}");

		out.print("td{text-align:center; width:16pc;}");
		
		out.print(".oper{width:8pc;}");

		out.print(".oper1{width:9pc;}");

		out.print(".rwback:nth-child(odd){background-color:#eeeeee;}");
		
		out.print(".rwback{padding5pc; font-size:15px; height:3pc;}");
		
		out.print(".edit{background-color:green; color:white;padding:4px; font-weight:bold; width:6pc; font-size:13px; border-radius:5px;}");
		
		out.print(".delete{background-color:crimson; color:white;padding:4px; font-weight:bold; width:6pc; font-size:13px; border-radius:5px;}");

		out.print(".edit:hover{color:white; text-decoration:none;}");
		
		out.print(".delete:hover{color:white; text-decoration:none;}");

		out.print("</style>");
		out.print("</head>");
		out.print("<body>");
		
		out.print("<h1>Users Record</h1>");
		
		ArrayList<AddDetails> list = SelectDetails.getAllUsers();
		
		out.print("<center>");
		out.print("<table>");
		out.print("<tr>");
		out.print("<th>Id</th>");
		out.print("<th>First Name</th>");
		out.print("<th>Last Name</th>");
		out.print("<th>Contacts</th>");
		out.print("<th>City</th>");
		out.print("<th>Email</th>");
		out.print("<th>Password</th>");
		out.print("<th>Edit</th>");
		out.print("<th>Delete</th>");
		out.print("</tr>");
		
		for(AddDetails ad:list){
			
			out.print("<tr class = 'rwback'>");
			out.print("<td>"+ad.getId()+"</td>");
			out.print("<td>"+ad.getFname()+"</td>");
			out.print("<td>"+ad.getLname()+"</td>");
			out.print("<td>"+ad.getPh()+"</td>");
			out.print("<td>"+ad.getCtname()+"</td>");
			out.print("<td>"+ad.getEmail()+"</td>");
			out.print("<td>"+ad.getPass()+"</td>");
			out.print("<td class = 'oper'><a href = 'serv3?id="+ad.getId()+"' class = 'edit'>Edit</a></td>");
			out.print("<td class = 'oper1'><a href = 'serv4?id="+ad.getId()+"' class = 'delete'>Delete</a></td>");

			out.print("</tr>");
		}
		
		out.print("</table>");
		out.print("</center>");
		out.print("</body>");
	    out.print("</html>");
		
		out.close();
	}

}
