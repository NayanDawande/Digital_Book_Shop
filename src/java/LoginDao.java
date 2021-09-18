import java.sql.*;  
  
public class LoginDao {  
public static boolean validate(String n,String p){  
boolean status=false;  
try{  
Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection(  
"jdbc:mysql://localhost:3302/internship","root","");  
      
PreparedStatement ps=con.prepareStatement(  
"select * from contact where n=? and p=?");  
ps.setString(1,n);  
ps.setString(2,p);  
      
ResultSet rs=ps.executeQuery();  
status=rs.next();  
          
}catch(Exception e){System.out.println(e);}  
return status;  
}  
}  


