import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
public class Search extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		out.println("<html><body>");
//		out.println("<a href="update"><font face="verdana" color="red">Update.html</font></a>");
		String name=req.getParameter("name");
		String pass=req.getParameter("pass");
		String STUDENTNAME= req.getParameter("STUDENTNAME");
		String ROLL_NUMBER= req.getParameter("ROLL_NUMBER");
		String HINDI= req.getParameter("HINDI");
		String ENGLISH= req.getParameter("ENGLISH");
		
		String MATH= req.getParameter("MATH");
		String SCIENCE= req.getParameter("SCIENCE");
		String SANSKRIT= req.getParameter("SANSKRIT");
		String COMPUTER= req.getParameter("COMPUTER");
		String TOTAL_MARKS= req.getParameter("TOTAL_MARKS");
		String GRADE= req.getParameter("GRADE");
		String SEMESTER= req.getParameter("SEMESTER");
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//System.out.println("connected to db");
			Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
			//Statement s=c.createStatement();
			PreparedStatement ps = null;
			ps = c.prepareStatement("SELECT * FROM STUDENT WHERE ROLL_NUMBER=?");
            ps.setString(1,ROLL_NUMBER);
            ResultSet rs = ps.executeQuery();
			ResultSetMetaData rsmd=rs.getMetaData();
			out.println("<table bgcolor='#78CBA4' border=1width=400>");
			out.println("<tr>");
			for(int i=1;i<=rsmd.getColumnCount();i++)
			{
				out.println("<th>"+rsmd.getColumnName(i)+"</th>");
			}
			while(rs.next())
			{
				out.println("<tr>");
				out.println("<td>"+rs.getString(1)+"</td>");
				out.println("<td>"+rs.getString(2)+"</td>");
				out.println("<td>"+rs.getString(3)+"</td>");
				out.println("<td>"+rs.getString(4)+"</td>");
				out.println("<td>"+rs.getString(5)+"</td>");
				out.println("<td>"+rs.getString(6)+"</td>");
				out.println("<td>"+rs.getString(7)+"</td>");
				out.println("<td>"+rs.getString(8)+"</td>");
				out.println("<td>"+rs.getString(9)+"</td>");
				out.println("<td>"+rs.getString(10)+"</td>");
				out.println("<td>"+rs.getString(11)+"</td>");
				out.println("<td>"+rs.getString(12)+"</td>");
				out.println("</tr>");
			}
		}
		catch(Exception e)
		{
		}
		out.println("</table>");
		out.println("</body></html>");
	}
} 