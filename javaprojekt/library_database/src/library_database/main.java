package library_database;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import java.sql.Connection;



public class main {

	
	
	
	public static void main(String[] args) {
		Connection conn = connect.connectdb("databaza2.db");
		Scanner sc = new Scanner(System.in);
		
		try {
			newdatabase.createNewtable(conn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean run = true;
		
		int volba =0;
		while (run) {
		    	System.out.println("Vyberte moznost:");
			      System.out.println("1 .. Vlozenie knihy");
			      System.out.println("2 .. Vymazanie knihy");
			      System.out.println("3 .. Zmen autora");
			      System.out.println("4 .. Zmen rok vydania");
			      System.out.println("5 .. Zmen stav dostupnosti");
			      System.out.println("6 .. Vypis knih v abecednom poradi");
			      System.out.println("7 .. Vypis info o knihe");
			      System.out.println("8 .. Filter podla autora");
			      System.out.println("9 .. Filter podla typu");
			      System.out.println("10 .. Vypis vypozicanych");
			      System.out.println("11 .. Zaznam do suboru");
			      System.out.println("12 .. Nacitanie zo suboru");
			      
			      
		    
			volba = sc.nextInt();
			String nazov_knihy; 
			switch (volba) {
	        case 1:
	        	sc.nextLine();
	        	System.out.println("Zadaj typ knihy:");
	        	String typ = sc.nextLine();
	        	System.out.println("Zadaj meno Autora:");
	        	
	        	String autor = sc.nextLine();
	        	
	        	if (autor.indexOf(",") != -1){
	        		String[]autors = autor.split(",");
	        	}
	        	System.out.println("Zadaj nazov knihy:");
	        	nazov_knihy = sc.nextLine();
	        	boolean valid = false;
	        	int rok =0;
	        	while (!valid) {
	        		System.out.println("Zadaj rok vydania:");
	        		if (sc.hasNextInt()) {
	        			rok = sc.nextInt();
	        			valid = true;
	        		}
	        		else {
	        			System.out.println("Zadaj ciselnu hodnotu");
	        			sc.nextLine();
	        		}
	        	}
	        
	        	
	        	
	        	
	        	int dostupnost = 2;
	        	
	        
	        	try {
	        		while (dostupnost >1) {
	        			System.out.println("Stav dostupnosti 0-1:");
	        			dostupnost = sc.nextInt();
	        		}
	        		
	        			
	        		
	        		
	        	
	        	}
	        	catch(Exception e) {
	        		System.out.println("Nezadali ste spravny parameter, defaultne nastavene na nedostupne");
	        	}
	        	
	        		
	        	
	        	
	        	sc.nextLine();
	        	System.out.println("Zadaj doplnujuce info:");
	        	String extra = sc.nextLine();
	        	update_record.pridajzaznam(conn, autor, nazov_knihy, rok, dostupnost, typ, extra);
	        	break;
	        case 2:
	        	sc.nextLine();
	        	System.out.println("Zadaj nazov knihy, ktoru chces zmazat:");
	        	nazov_knihy = sc.nextLine();
	        	update_record.odstranzaznam(conn, nazov_knihy);
	        	break;
	        case 3:
	        	sc.nextLine();
	        	System.out.println("Zadaj nazov knihy, ktorej autora chces upravit:");
	        	nazov_knihy = sc.nextLine();
	        	
	        	
	        	if (update_record.testIfBookExists(conn, nazov_knihy)==true) {
	        		System.out.println("Zadaj meno noveho autora:");
	        		String new_autor = sc.nextLine();
	        		update_record.upravautor(conn, nazov_knihy, new_autor);
	        	}
	        	else {
	        		System.out.println("Kniha nie je v databazi");
	        	}
	        	
	        	break;
	        case 4:
	        	sc.nextLine();
	        	System.out.println("Zadaj nazov knihy, ktorej rok vydania chces zmenit:");
	        	nazov_knihy = sc.nextLine();
	        	if (update_record.testIfBookExists(conn, nazov_knihy)==true) {
	        		
		        	
		        	valid = false;
		        	rok =0;
		        	while (!valid) {
		        		System.out.println("Zadaj upraveny rok vydania:");
		        		if (sc.hasNextInt()) {
		        			rok = sc.nextInt();
		        			valid = true;
		        		}
		        		else {
		        			System.out.println("Zadaj ciselnu hodnotu");
		        			sc.nextLine();
		        		}
		        	}
		        	update_record.upravrokvydania(conn, nazov_knihy, rok);
	        	}
	        	else {
	        		System.out.println("Kniha nie je v databazi");
	        	}
	        	
	        	break;
	        case 5:
	        	sc.nextLine();
	        	System.out.println("Zadaj nazov knihy, ktorej stav dostupnosti chces zmenit:");
	        	nazov_knihy = sc.nextLine();
	        	if (update_record.testIfBookExists(conn, nazov_knihy)==true) {
	        		System.out.println("Zadaj novy stav, dostupne - 1, nedostupne - 0:");
		        	dostupnost = sc.nextInt();
		        	update_record.upravdostunost(conn, nazov_knihy, dostupnost);
	        	}
	        	else {
	        		System.out.println("Kniha nie je v databazi");
	        	}
	        	
	        	break;
	        case 6:
	        	if (update_record.testIfDataExists(conn)==true) {
		        	
	        		vypis.vypis_abecedne_poradie(conn);
	        	}
	        	else {
	        		System.out.println("Databaza je prazdna");
	        	}
	      
	        	break;
	        case 7:
	        	sc.nextLine();
	        	System.out.println("Zadaj nazov knihy:");
	        	nazov_knihy = sc.nextLine();
	        	if (update_record.testIfBookExists(conn, nazov_knihy)==true) {
	        	
		        	vypis.vypis_knihu(conn, nazov_knihy);
	        	}
	        	else {
	        		System.out.println("Kniha nie je v databazi");
	        	}
	        	break;
	        case 8:
	        	sc.nextLine();
	        	System.out.println("Zadaj meno autora:");
	        	autor = sc.nextLine();
	        	if (update_record.testIfAutorExists(conn, autor)==true) {
	        	
		        	vypis.vypis_knihy_autora(conn, autor);
	        	}
	        	else {
	        		System.out.println("Autor nie je v databazi");
	        	}
	        	break;
	        case 9:
	        	sc.nextLine();
	        	System.out.println("Zadaj typ:");
	        	typ = sc.nextLine();
	        	if (update_record.testIfTypExists(conn, typ)==true) {
	        	
		        	vypis.vypis_knihu_podla_zanru(conn, typ);;
	        	}
	        	else {
	        		System.out.println("Tento typ knih  nie je v databazi");
	        	}
	        	break;
	        case 10:
	        	vypis.vypis_vypozicane(conn);
	        	break;
	        case 11:
	        	sc.nextLine();
	        	System.out.println("Zadaj nazov knihy:");
	        	nazov_knihy = sc.nextLine();
	        	if (update_record.testIfBookExists(conn, nazov_knihy)==true) {
	        	
		        	try {
						subor.zapis_do_suboru(conn, nazov_knihy);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	        	}
	        	else {
	        		System.out.println("Tato kniha nie je v databazi");
	        	}
	        	break;
	        case 12:
	        	sc.nextLine();
	        	System.out.println("Zadajte cely nazov suboru:");
	        	String nazov_suboru = sc.nextLine();
	        	subor.nacitaj_knihu_zo_suboru(conn, nazov_suboru);
	        	break;
	        default:
	            run = false;
	            connect.closeConnection();
	            sc.close();
	            break;
	        
		
	}
	}
	}
}
