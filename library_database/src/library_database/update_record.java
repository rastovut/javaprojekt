package library_database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class update_record {
public static void upravautor(Connection spojenie, String nazov, String autor) {
		
		
		String sql = "UPDATE knizky SET Autor = ? WHERE knizky.nazov = ?";

	            try {
	            	if (testIfBookExists(spojenie, nazov)==true) {
	            		Statement stmt = spojenie.createStatement();
						PreparedStatement prStmt = spojenie.prepareStatement(sql);
						prStmt.setString(1, autor);
						prStmt.setString(2, nazov);
						prStmt.executeUpdate();
	            	}
	            	else {
	            		System.out.println("Kniha nieje v databazi");
	            	}
				}
	            catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
		}	    
		   
	}
public static void upravrokvydania(Connection spojenie, String nazov, int rok_vydania) {
	
	
	String sql = "UPDATE knizky SET Rok_vydania = ? WHERE knizky.nazov = ?";

            try {
            		Statement stmt = spojenie.createStatement();
            		PreparedStatement prStmt = spojenie.prepareStatement(sql);
            		prStmt.setInt(1, rok_vydania);
            		prStmt.setString(2, nazov);
            		prStmt.executeUpdate();
            	
            	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
	}	    
	   
}
public static void upravdostunost(Connection spojenie, String nazov, int dostupnost ) {
	
	
	String sql = "UPDATE knizky SET Dostupnost = ? WHERE knizky.nazov = ?";

            try {
            	
            		Statement stmt = spojenie.createStatement();
            		PreparedStatement prStmt = spojenie.prepareStatement(sql);
            		if (dostupnost == 1){
            			prStmt.setString(1, "dostupne");
            		}
            		else {
            			prStmt.setString(1, "nedostupne");
            		}
            		prStmt.setString(2, nazov);
            		prStmt.executeUpdate();
            	
            		
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
	}	    
	   
}
public static boolean testIfBookExists(Connection spojenie, String nazov) {
    if (nazov == null) {
      throw new NullPointerException("query must not be null!");
    } else if (nazov.isEmpty()) {
      throw new IllegalArgumentException("query must not be empty!");
    }

    
    String sql = "SELECT * FROM knizky WHERE knizky.nazov = ?";

    try (PreparedStatement prStmt = spojenie.prepareStatement(sql);) {
      prStmt.setString(1, nazov);
      ResultSet rs = prStmt.executeQuery();
      if (rs.next())
        return true;
      else
        return false;
    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }
  }
public static boolean testIfTypExists(Connection spojenie, String zaner) {
    if (zaner == null) {
      throw new NullPointerException("query must not be null!");
    } else if (zaner.isEmpty()) {
      throw new IllegalArgumentException("query must not be empty!");
    }

    
    String sql = "SELECT Typ FROM knizky WHERE knizky.Typ = ?";

    try (PreparedStatement prStmt = spojenie.prepareStatement(sql);) {
      prStmt.setString(1, zaner);
      ResultSet rs = prStmt.executeQuery();
      if (rs.next())
        return true;
      else
        return false;
    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }
  }
public static boolean testIfAutorExists(Connection spojenie, String autor) {
    if (autor == null) {
      throw new NullPointerException("query must not be null!");
    } else if (autor.isEmpty()) {
      throw new IllegalArgumentException("query must not be empty!");
    }

    
    String sql = "SELECT * FROM knizky WHERE knizky.Autor = ?";

    try (PreparedStatement prStmt = spojenie.prepareStatement(sql);) {
      prStmt.setString(1, autor);
      ResultSet rs = prStmt.executeQuery();
      if (rs.next())
        return true;
      else
        return false;
    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }
  }

public static void odstranzaznam(Connection spojenie, String nazov) {
	
	
	String sql = "DELETE FROM knizky WHERE knizky.nazov = ?";

            try {
            	if (testIfBookExists(spojenie, nazov) == true){
            		Statement stmt = spojenie.createStatement();
					PreparedStatement prStmt = spojenie.prepareStatement(sql);
					prStmt.setString(1, nazov);
					prStmt.executeUpdate();
					System.out.println("kniha bola vymazana");
            	}
            	else {
            		System.out.println("kniha neni v databazi");
            	}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	   
}
}
