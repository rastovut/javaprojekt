package library_database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class vypis {
	public static void vypis_abecedne_poradie(Connection spojenie){
		String sql = "SELECT * FROM knizky ORDER BY Nazov COLLATE NOCASE ASC";
		try (PreparedStatement prStmt = spojenie.prepareStatement(sql);) {
		      ResultSet rs = prStmt.executeQuery();
		      while (rs.next()) {
		          System.out.println(
		             "Typ: "+ rs.getString("Typ") + ", Nazov: " +rs.getString("Nazov") + ", Autor: " + rs.getString("Autor")+", Rok vydania: "+rs.getString("Rok_vydania")+ ", Dostupnost: "+rs.getString("Dostupnost"));
		        }
		    } catch (SQLException e) {
		      e.printStackTrace();
		    }
	}
	public static void vypis_knihu(Connection spojenie, String nazov) {
		String sql = "SELECT * FROM knizky WHERE knizky.nazov = ?";
		try {
        	 
        		PreparedStatement prStmt = spojenie.prepareStatement(sql);
				prStmt.setString(1, nazov);
				ResultSet rs = prStmt.executeQuery();
				while (rs.next()) {
			          System.out.println(
			             "Typ: "+ rs.getString("Typ") +", Extra: "+rs.getString("Extra")+ ", Nazov: " +rs.getString("Nazov") + ", Autor: " + rs.getString("Autor")+", Rok vydania: "+rs.getString("Rok_vydania")+ ", Dostupnost: "+rs.getString("Dostupnost"));
			        }
        	}
        	
        	
			
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void vypis_knihy_autora(Connection spojenie, String autor) {
		
		String sql = "SELECT Nazov,Rok_vydania FROM knizky WHERE knizky.Autor LIKE ?";
		sql += " ORDER BY Rok_vydania ASC";
		
		try {
        	
        		
        		
        		
        		PreparedStatement prStmt = spojenie.prepareStatement(sql);
        		prStmt.setString(1, '%' + autor + '%');
        		
				ResultSet rs = prStmt.executeQuery();
				while (rs.next()) {
			          System.out.println(
			             "Nazov: "+ rs.getString("Nazov") + ", Rok vydania: " +rs.getString("Rok_vydania"));
			        }
        	
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void vypis_knihu_podla_zanru(Connection spojenie, String zaner) {
		String sql = "SELECT * FROM knizky WHERE knizky.Typ = ?";
		try {
        	
        		PreparedStatement prStmt = spojenie.prepareStatement(sql);
				prStmt.setString(1, zaner);
				ResultSet rs = prStmt.executeQuery();
				while (rs.next()) {
			          System.out.println(
			             "Typ: "+ rs.getString("Typ") + ", Nazov: " +rs.getString("Nazov") + ", Autor: " + rs.getString("Autor")+", Rok vydania: "+rs.getString("Rok_vydania")+ ", Dostupnost: "+rs.getString("Dostupnost"));
			        }
    
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void vypis_vypozicane(Connection spojenie) {
		String sql = "SELECT * FROM knizky WHERE knizky.Dostupnost = 'nedostupne'";
		try {
        	
        		PreparedStatement prStmt = spojenie.prepareStatement(sql);
				ResultSet rs = prStmt.executeQuery();
				while (rs.next()) {
			          System.out.println(
			             "Typ: "+ rs.getString("Typ") + ", Nazov: " +rs.getString("Nazov") + ", Autor: " + rs.getString("Autor"));
			        }
    
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
