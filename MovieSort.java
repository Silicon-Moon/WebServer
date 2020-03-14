// Import required packages
import java.sql.*;

public class MovieSort {
   
  static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
  static final String DB_URL = ""./src/main/resources/Oscar_Winner_data_csv.csv";

   
   public static void main(String[] args) {
   Connection conn = null;
   Statement stmt = null;
   try{
      
     //Class.forName("com.SiliconMoon");

      //STEP 3: Open a connection
      System.out.println("Connecting to a selected database...");
    
      //STEP 4: Execute a query
      System.out.println("Creating statement...");
      stmt = conn.createStatement();

      // Extract records in ascending order by first name.
      System.out.println("Fetching Movie records in ascending order...");
      String sql = "SELECT Year, Category, Winner, Entity FROM Registration" +
                   " ORDER BY first ASC";
      ResultSet rs = stmt.executeQuery(sql);

      while(rs.next()){
         //Retrieve by column name
         int year  = rs.getInt("Year");
         String category = rs.getString("Category");
         String winner = rs.getString("Winner");
         String entity = rs.getString("Entity");

         //Display values
         System.out.print("Year: " + year);
         System.out.print(", Category: " + category);
         System.out.print(", Winner: " + winner);
         System.out.println(", Entity: " + entity);
      }

      // Extract records in descending order by year
      System.out.println("Fetching Movie records in descending order...");
      sql = "SELECT Year, Category, Winner, Entity FROM Registration" +
                   " ORDER BY first DESC";
      rs = stmt.executeQuery(sql);

      while(rs.next()){
         //Retrieve by column name
    	  int year  = rs.getInt("Year");
          String category = rs.getString("Category");
          String winner = rs.getString("Winner");
          String entity = rs.getString("Entity");

         //Display values
          System.out.print("Year: " + year);
          System.out.print(", Category: " + category);
          System.out.print(", Winner: " + winner);
          System.out.println(", Entity: " + entity);
      }
      rs.close();
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for MovieSort.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            conn.close();
      }catch(SQLException se){
      }// do nothing
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
   System.out.println("Goodbye!");
}//end main
}//end MovieSort