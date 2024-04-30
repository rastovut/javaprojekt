package library_database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class newdatabase {
	public static void createNewDatabase(String fileName) {

        String url = "jdbc:sqlite:" + fileName;

        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
	public static void createNewtable(Connection spojenie) {
		
		String sql = "CREATE TABLE IF NOT EXISTS knizky (\n"
	            + "	id integer PRIMARY KEY,\n"
	            + "	Typ text,\n"
	            + "	Autor text NOT NULL,\n"
	            + "	Nazov text,\n"
	            + "	Rok_vydania int,\n"
	            + "	Dostupnost text,\n"
	            + "	Extra text\n"
	            + ");";
		
	      Statement stmt;
		try {
			stmt = spojenie.createStatement();
			stmt.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	        // create a new table
		
	        
	   
	
}
}
