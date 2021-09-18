import java.io.*;  
import java.sql.*;  
import javax.servlet.ServletException;  
import javax.servlet.http.*;  
  
public class Contact extends HttpServlet {  
public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
  
response.setContentType("text/html");  
PrintWriter out = response.getWriter();  
          
String n=request.getParameter("name");  
String p=request.getParameter("phone");  
String e=request.getParameter("email");  
String m=request.getParameter("message");  
          
try{  
Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection(  
"jdbc:mysql://localhost:3302/internship", "root", "");  
  
PreparedStatement ps=con.prepareStatement(  
"insert into contact values(?,?,?,?)");  
  
ps.setString(1,n);  
ps.setString(2,p);  
ps.setString(3,e);  
ps.setString(4,m);  
          
int i=ps.executeUpdate();  
if(i>0)  
out.print("You are successfully registered...");  
response.sendRedirect("login.html");
      
          
}catch (Exception e2) {System.out.println(e2);}  
          
out.close();  
}  
  }

