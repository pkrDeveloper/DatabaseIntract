import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
public class Update extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		out.println("<html><body>");
		//String name=req.getParameter("name");
		//String pass=req.getParameter("pass");
		String ROLL_NUMBER= req.getParameter("ROLL_NUMBER");
		String STUDENTNAME=null;
		String HINDI=null;
		String ENGLISH= null;
		String MATH=null;
		String SCIENCE=null;
		String SANSKRIT= null;
		String COMPUTER= null;
		String TOTAL_MARKS= null;
		String GRADE= null;
		String SEMESTER= null;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
			PreparedStatement ps = null;
			ps = c.prepareStatement("SELECT * FROM STUDENT WHERE ROLL_NUMBER=?");
            ps.setString(1,ROLL_NUMBER);
            ResultSet rs = ps.executeQuery();
			ResultSetMetaData rsmd=rs.getMetaData();
			while(rs.next())
			{
				/*out.println(rs.getString(1)+STUDENTNAME);	
				out.println(rs.getString(2)+ROLL_NUMBER);
				out.println(rs.getString(3)+HINDI);
				out.println(rs.getString(4)+ENGLISH);
				out.println(rs.getString(5)+MATH);
				out.println(rs.getString(6)+SCIENCE);
				out.println(rs.getString(7)+SANSKRIT);
				out.println(rs.getString(8)+COMPUTER);
				out.println(rs.getString(9)+TOTAL_MARKS);
				out.println(rs.getString(10)+GRADE);
				out.println(rs.getString(11)+SEMESTER);*/
				STUDENTNAME= rs.getString(1);
				out.println("STUDENT NAME::"+STUDENTNAME);
				ROLL_NUMBER=rs.getString(2);
				out.println("ROLL_NUMBER::"+ROLL_NUMBER);
				HINDI=rs.getString(2);
				out.println("ROLL_NUMBER::"+HINDI);
				ENGLISH=rs.getString(2);
				out.println("ROLL_NUMBER::"+ENGLISH);
				MATH=rs.getString(2);
				out.println("ROLL_NUMBER::"+MATH);
				SCIENCE=rs.getString(2);
				out.println("ROLL_NUMBER::"+SCIENCE);
				SANSKRIT=rs.getString(2);
				out.println("ROLL_NUMBER::"+SANSKRIT);
				COMPUTER=rs.getString(2);
				out.println("ROLL_NUMBER::"+COMPUTER);
				TOTAL_MARKS=rs.getString(2);
				out.println("ROLL_NUMBER::"+TOTAL_MARKS);
				GRADE=rs.getString(2);
				out.println("ROLL_NUMBER::"+GRADE);
				SEMESTER=rs.getString(2);
				out.println("ROLL_NUMBER::"+SEMESTER);
			}
		}
		catch(Exception e)
		{
		}
		out.println("</body></html>");
	}
} 