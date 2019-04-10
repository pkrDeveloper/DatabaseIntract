import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
public class Delete extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		out.println("<html><body>");
		
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
			ps = c.prepareStatement("DELETE FROM STUDENT WHERE ROLL_NUMBER=?");
            ps.setString(1,ROLL_NUMBER);
			out.println("Sucessfull");
           int i = ps.executeUpdate(); 
                out.println(i); 
                if(i!=0)    {
					c.commit();
                    out.println("Your data has been deleted"); 
                } 
                else    { 
                    out.println("Your data could not be deleted"); 
                } 
		
		}
		catch(Exception e)
		{
		}
		out.println("</body></html>");
	}
} 