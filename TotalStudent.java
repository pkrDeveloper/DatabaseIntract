import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
public class TotalStudent extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		out.println("<html><body bgcolor='#9BC9E7'>");
		//String name=req.getParameter("name");
		//String pass=req.getParameter("pass");
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
			/*
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//System.out.println("connected to db");
			Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
			//Statement s=c.createStatement();
			PreparedStatement ps = null;
			out.println("Sucessfull");
			ps = c.prepareStatement("SELECT STUDENTNAME,ROLL_NUMBER,HINDI,ENGLISH,MATH,SCIENCE,SANSKRIT,COMPUTER,TOTAL_MARKS,PERCENTAGE,GRADE,SEMESTER FROM STUDENT");
            //ps.setString(1,ROLL_NUMBER);
            ResultSet rs = ps.executeQuery();
			
			*/
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
			Statement s=con.createStatement();
			ResultSet rs=s.executeQuery("SELECT * FROM STUDENT");
			ResultSetMetaData rsmd=rs.getMetaData();
			out.println("<table bgcolor='#78CBA4' border=1width=400>");
			out.println("<tr>");
			out.println("Sucessfull");
			for(int i=1;i<=rsmd.getColumnCount();i++)
			{
				out.println("<th>"+rsmd.getColumnName(i)+"</th>");
			}
			int i=0;
			out.println("<center><b><u><h1><center><u>Table Data</u></center></h1></u></b></center>");
			while(rs.next())
			{
				
				i++;	
				
				out.println("<tr><br>");
				out.println();
				out.println("<td><br>"+rs.getString(1)+"</td>");
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
				
				out.println(i);
			}
			}
		catch(Exception e)
		{
		}
		out.println("</table>");
		out.println("</body></html>");
	}
}