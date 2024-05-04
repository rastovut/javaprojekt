package library_database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connect {
	private static volatile Connection conn;
	public static Connection connectdb(String filename) {
        conn = null;
        try {
            // db parameters
        	String url = "jdbc:sqlite:" + filename;
            
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            
            System.out.println("Connection to SQLite has been established.");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } 
        return conn;
    }
	  public static void closeConnection() {
		    try {
		      conn.close();
		    } catch (SQLException e) {
		      e.printStackTrace();
		    }
		  }
}
