package library_database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class newdatabase {
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
			e.printStackTrace();
		}

}
}
