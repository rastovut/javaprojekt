package library_database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class insertbook  {
	public static void pridajzaznam(Connection spojenie, String autor, String nazov, int rok_vydania, int dostupnost, String typ, String extra) {
		String sql = "INSERT INTO knizky " + "(Typ,Autor,Nazov,Rok_vydania,Dostupnost,Extra)" + "VALUES(?,?,?,?,?,?)"; 
		
	            try {
					Statement stmt = spojenie.createStatement();
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
		   
	}

