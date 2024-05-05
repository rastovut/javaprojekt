package library_database;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class subor {
	public static void zapis_do_suboru(Connection spojenie, String nazov) throws IOException {
		String sql = "SELECT * FROM knizky WHERE knizky.nazov = ?";
		try {
        	 
        		PreparedStatement prStmt = spojenie.prepareStatement(sql);
				prStmt.setString(1, nazov);
				ResultSet rs = prStmt.executeQuery();
				BufferedWriter writer = new BufferedWriter(new FileWriter(nazov+".txt", true));
				while (rs.next()) {
					writer.write(rs.getString("Typ"));
					writer.newLine();
					writer.write(rs.getString("Extra"));
					writer.newLine();
					writer.write(rs.getString("Nazov"));
					writer.newLine();
					writer.write(rs.getString("Autor"));
					writer.newLine();
					writer.write(rs.getString("Rok_vydania"));
					writer.newLine();
					writer.write(rs.getString("Dostupnost"));
					writer.newLine();
					writer.close();
			        }
        	}
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void nacitaj_knihu_zo_suboru(Connection spojenie, String nazov) {
		BufferedReader reader;

		try {
			reader = new BufferedReader(new FileReader(nazov));
			

			String typ = reader.readLine();
			String extra = reader.readLine();
			String nazov_knihy = reader.readLine();
			String autor = reader.readLine();
			int rok_vydania = Integer.parseInt(reader.readLine());
			int dostupnost = 0;
			if (reader.readLine()=="dostupne"){
					dostupnost = 1;
			}
			if (reader.readLine()=="nedostupne") {
				dostupnost = 0;
			}
			reader.close();
			update_record.pridajzaznam(spojenie, autor, nazov_knihy, rok_vydania, dostupnost, typ, extra);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
