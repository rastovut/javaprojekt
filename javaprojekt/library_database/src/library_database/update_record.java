package library_database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class update_record {
public static void upravautor(Connection spojenie, String nazov, String autor) {
		
		
		String sql = "UPDATE knizky SET Autor = ? WHERE knizky.nazov = ?";

	            try {
	            	if (testIfBookExists(spojenie, nazov)==true) {
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
					
					e.printStackTrace();
		}	    
		   
	}

public static void upravrokvydania(Connection spojenie, String nazov, int rok_vydania) {
	String sql = "UPDATE knizky SET Rok_vydania = ? WHERE knizky.nazov = ?";
            try {
            		PreparedStatement prStmt = spojenie.prepareStatement(sql);
            		prStmt.setInt(1, rok_vydania);
            		prStmt.setString(2, nazov);
            		prStmt.executeUpdate();
			} catch (SQLException e) {
				
				e.printStackTrace();
	}	    
}
public static void upravdostunost(Connection spojenie, String nazov, int dostupnost ) {
	
	
	String sql = "UPDATE knizky SET Dostupnost = ? WHERE knizky.nazov = ?";

            try {
            	
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
				
				e.printStackTrace();
	}	    
	   
}
public static boolean testIfBookExists(Connection spojenie, String nazov) {
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

public static boolean testIfDataExists(Connection spojenie) {
	String sql = "SELECT * FROM knizky";

    try (PreparedStatement prStmt = spojenie.prepareStatement(sql);) {
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
    String sql = "SELECT * FROM knizky WHERE knizky.Autor LIKE ?";

    try (PreparedStatement prStmt = spojenie.prepareStatement(sql);) {
      prStmt.setString(1, '%'+autor+'%');
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
public static void pridajzaznam(Connection spojenie, String autor, String nazov, int rok_vydania, int dostupnost, String typ, String extra) {
	String sql = "INSERT INTO knizky " + "(Typ,Autor,Nazov,Rok_vydania,Dostupnost,Extra)" + "VALUES(?,?,?,?,?,?)"; 
            try {
				PreparedStatement prStmt = spojenie.prepareStatement(sql);
				prStmt.setString(1,typ);
			    prStmt.setString(2, autor);
			    prStmt.setString(3, nazov);
			    prStmt.setInt(4, rok_vydania);
			    if (dostupnost == 1){
			    	prStmt.setString(5, "dostupne");
			    }
			    else {
			    	prStmt.setString(5, "nedostupne");
			    }
			    prStmt.setString(6, extra);
			    prStmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
            System.out.println("kniha bola pridana");
    }

public static void odstranzaznam(Connection spojenie, String nazov) {
	
	
	String sql = "DELETE FROM knizky WHERE knizky.nazov = ?";

            try {
            	if (testIfBookExists(spojenie, nazov) == true){
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
