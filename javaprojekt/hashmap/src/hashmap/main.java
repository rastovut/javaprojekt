package hashmap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		database databaza = new database();
		
		
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Vyberte možnost:");
            System.out.println("1. Pridat roman");
            System.out.println("2. Pridat ucebnicu");
            System.out.println("3. Vypisat databazu");
            System.out.println("4. Filter podla autora");
            System.out.println("5. Uprava zaznamu");
            System.out.println("6. Filter podľa žanru");
            System.out.println("7. Odstranit zaznam");

            int volba = scanner.nextInt();
            scanner.nextLine(); 

            switch (volba) {
                case 1:
                    System.out.println("Zadajte nazov románu:");
                    String nazovRomanu = scanner.nextLine();
                    System.out.println("Zadajte autora alebo autorov románu (oddelen ciarkami):");
                    String autoriRomanu = scanner.nextLine();
                    System.out.println("Zadajte rok vydania románu:");
                    int rokVydaniaRomanu = scanner.nextInt();
                    System.out.println("Dostupnost (true/false):");
                    boolean dostupnostRomanu = scanner.nextBoolean();
                    scanner.nextLine();  
                    System.out.println("Zadajte žáner románu:");
                    String zanerRomanu = scanner.nextLine();

                    List<String> autoriList = Arrays.asList(autoriRomanu.split("\\s*,\\s*"));
                    databaza.pridatRoman(nazovRomanu, autoriList, rokVydaniaRomanu, dostupnostRomanu, zanerRomanu);
                    break;
                case 2:
                    System.out.println("Zadajte názov učebnice:");
                    String nazovUcebnice = scanner.nextLine();
                    System.out.println("Zadajte autora alebo autorov učebnice (oddelene ciarkami):");
                    String autoriUcebnice = scanner.nextLine();
                    System.out.println("Zadajte rok vydania učebnice:");
                    int rokVydaniaUcebnice = scanner.nextInt();
                    System.out.println("Dostupnost (true/false):");
                    boolean dostupnostUcebnice = scanner.nextBoolean();
                    scanner.nextLine(); 
                    System.out.println("Zadejte věkovou kategorii učebnice:");
                    String vekovaKategoriaUcebnice = scanner.nextLine();

                    List<String> autoriListUcebnice = Arrays.asList(autoriUcebnice.split("\\s*,\\s*"));
                    databaza.pridatUcebnici(nazovUcebnice, autoriListUcebnice, rokVydaniaUcebnice, dostupnostUcebnice, vekovaKategoriaUcebnice);
                    break;
                case 3:
                    System.out.println("Všetky knihy v databazi:");
                    databaza.vypisKnihovnu();
                    break;
                case 4:
                	System.out.println("Zadajte meno autora:");
                    String autor = scanner.nextLine();
                    List<kniha> filtracePodleAutora = databaza.filtrujPodlaAutora(autor);
                    System.out.println("Knihy autora " + autor + ":");
                    for (kniha kniha : filtracePodleAutora) {
                        System.out.println(kniha.getNazov());
                    }
                    break;
                case 5:
                	 System.out.println("Zadajte názov knihy, ktoru chcete upravit:");
                     String nazovKnihy = scanner.nextLine();
                     kniha kniha = databaza.getKniha(nazovKnihy);
                     if (kniha != null) {
                         System.out.println("Zadajte atribut, ktorý chcete upravit: (nazov, autor, rokVydania, dostupnost)");
                         String atribut = scanner.nextLine();
                         System.out.println("Zadajte novu hodnotu pre atribut:");
                         String novaHodnota = scanner.nextLine();

                         databaza.upravitZaznam(nazovKnihy, atribut, novaHodnota);
                     } else {
                         System.out.println("Kniha s názvom '" + nazovKnihy + "' nebola najdena v databázi.");
                     }
                     break;
                case 6:
                	System.out.println("Zadajte žáner, podla ktorého chcete filtrovat:");
                    String zaner = scanner.nextLine();
                    List<kniha> najdenieKnihy = databaza.filterPodlaZanru(zaner);
                    if (najdenieKnihy.isEmpty()) {
                        System.out.println("Žiadne knihy s vybraným žánrom neboli najdene.");
                    } else {
                        System.out.println("Najdene knihy podla žánru '" + zaner + "':");
                        for (kniha kniha1 : najdenieKnihy) {
                            System.out.println(kniha1);
                        }
                    }
                    break;
                case 7:
                	System.out.println("Zadajte názov knihy, ktoru chcete odstranit:");
                    String nazovK = scanner.nextLine();
                    databaza.odstranitZaznam(nazovK);
                    break;
                default:
                    System.out.println("Neplatná volba, zvolte znovu.");
            }
        }
}
}	
