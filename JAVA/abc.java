import java.sql.*;

public class abc {
    public static void main(String[] args) throws SQLException{
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost", "root", "Mi@03122004");
        Statement stmt = con.createStatement();
        String q = "Create table Student"+"Rollno int"+"Name varchar(256)";
        stmt.executeUpdate(q);
    }
}
