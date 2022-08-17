/* Sign up using servlet */

import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.*;

public class signup extends HttpServlet
{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String n=request.getParameter("firstname");
		String m=request.getParameter("lastname");
		String l=request.getParameter("pass");
		String e=request.getParameter("cpass");
		String h=request.getParameter("email");
		
		try
		{
		
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","mahak","mahak");
			PreparedStatement ps=con.prepareStatement("insert into signup values(?,?,?,?,?)");
			ps.setString(1,n);
			ps.setString(2,m);
			ps.setString(3,l);
			ps.setString(4,e);
			ps.setString(5,h);
		
			ps.executeUpdate();
			RequestDispatcher dispatcher=request.getRequestDispatcher("login.html");
			dispatcher.include(request,response);
			out.println("<br>    hey" +n +"you are registered succesfully");

		
 
 
			
		}
            catch (Exception e2) 
            {
              System.out.println(e2);
            }
		out.close();
			out.close();
	}

}
