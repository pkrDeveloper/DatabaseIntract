import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
public class Update1 extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		out.println("<html><body>");
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
		String PERCENTAGE="40";
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//System.out.println("connected to db");
			Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
			 
			//Statement s=c.createStatement();
			PreparedStatement ps = null;
			ps = c.prepareStatement("UPDATE STUDENT SET STUDENTNAME=?,ROLL_NUMBER=?,HINDI=?,ENGLISH=?,MATH=?,SCIENCE=?,SANSKRIT=?,COMPUTER=?,TOTAL_MARKS=?,PERCENTAGE=?,GRADE=?,SEMESTER=? WHERE ROLL_NUMBER=?");
			    ps.setString(1,STUDENTNAME);
				ps.setString(2,ROLL_NUMBER);				
                ps.setString(3,HINDI); 
                ps.setString(4,ENGLISH); 
                ps.setString(5,MATH); 
                ps.setString(6,SCIENCE); 
				ps.setString(7,SANSKRIT); 
				ps.setString(8,COMPUTER); 
				ps.setString(9,TOTAL_MARKS); 
				ps.setString(10,PERCENTAGE);
				ps.setString(11,GRADE); 
				ps.setString(12,SEMESTER); 
			//ps = c.prepareStatement("COMMIT");
			//ps=c.prepareStatement("SELECT * FROM STUDENT");
               ps.setString(13,ROLL_NUMBER);
			   out.println("Sucessfull");
           int i = ps.executeUpdate(); 
                out.println(i); 


                if(i!=0)    {
					c.commit();
                    out.println("Your data has been stored in the database"); 
                } 
                else    { 
                    out.println("Your data could not be stored in the database"); 
                } 
			
				
		}
		catch(Exception e)
		{
		e.printStackTrace();
		}
		out.println("</body></html>");
		
	}
} 