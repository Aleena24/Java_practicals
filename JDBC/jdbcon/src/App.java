import java.sql.*;

public class App {
   static final String DB_URL = "jdbc:mysql://localhost:3306/conference";
   static final String USER = "root";
   static final String PASS = "";
   static final String QUERY = "SELECT * FROM attendees";

   public static void main(String[] args) {
      // Open a connection
      try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(QUERY);) {
         // Extract data from result set
         while (rs.next()) {
            // Retrieve by column name
            System.out.print("Name: " + rs.getString("Name"));
            System.out.print(", Email: " + rs.getString("Email"));
            System.out.println(", Contact: " + rs.getFloat("Contact"));
            System.out.println(", Country: " + rs.getFloat("Country"));
         }

         
      } catch (SQLException e) {
         e.printStackTrace();
      } 
   }
}
