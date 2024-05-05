package hashmap;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class database {
    private Map<String, kniha> kniznica;

    public database() {
        kniznica = new HashMap<>();
    }

    public void pridatRoman(String nazov, List<String> autor, int rokVydania, boolean dostupnost, String zaner) {
        roman roman = new roman(nazov, autor, rokVydania, dostupnost, zaner);
        kniznica.put(nazov, roman);
    }

    public void pridatUcebnici(String nazov, List<String> autor, int rokVydania, boolean dostupnost, String vekovaKategoria) {
        ucebnica ucebnice = new ucebnica(nazov, autor, rokVydania, dostupnost, vekovaKategoria);
        kniznica.put(nazov, ucebnice);
    }

    public void vypisKnihovnu() {
        for (Map.Entry<String, kniha> entry : kniznica.entrySet()) {
            kniha kniha = entry.getValue();
            System.out.println("Názov: " + kniha.getNazov());
            System.out.println("Autor: " + kniha.getAutor());
            System.out.println("Rok vydania: " + kniha.getRok_vydania());
            System.out.println("Dostupnost: " + (kniha.isDostupnost() ? "Ano" : "Nie"));
            if (kniha instanceof roman) {
                roman roman = (roman) kniha;
                System.out.println("Žáner: " + roman.getZaner());
            } else if (kniha instanceof ucebnica) {
                ucebnica ucebnica = (ucebnica) kniha;
                System.out.println("Veková kategoria: " + ucebnica.getVekova_kategoria());
            }
            System.out.println();
        }
    }

    public List<kniha> filtrujPodlaAutora(String autor) {
    	List<kniha> filtracia = new ArrayList<>();
        for (Map.Entry<String, kniha> entry : kniznica.entrySet()) {
            kniha kniha = entry.getValue();
            if (kniha.getAutor().contains(autor)) {
                filtracia.add(kniha);
            }
        }
        return filtracia;
    }
    public void upravitZaznam(String nazovKnihy, String atribut, Object novaHodnota) {
        kniha kniha = kniznica.get(nazovKnihy);
        if (kniha != null) {
            switch (atribut) {
                case "nazov":
                	kniznica.remove(nazovKnihy);
                    kniha.setNazov((String) novaHodnota);
                    kniznica.put(kniha.getNazov(), kniha);
                    break;
                case "autor":
                	
                	if (novaHodnota instanceof List<?>) {
                        kniha.setAutor((List<String>) novaHodnota);
                    } else {
                        List<String> autori = new ArrayList<>();
                        autori.add((String) novaHodnota);
                        kniha.setAutor(autori);
                    }
                    break;
                case "rokVydania":
                	if (novaHodnota instanceof Integer) {
                        kniha.setRok_vydania((Integer) novaHodnota);
                    } else {
                        System.out.println("Nová hodnota pre atribut 'rokVydania' nie je platné číslo.");
                    }
                    break;
                case "dostupnost":
                	String novaHodnotaStr = novaHodnota.toString().toLowerCase().trim();
                	if (novaHodnotaStr.equalsIgnoreCase("true")) {
                        kniha.setDostupnost(true);
                    } else if (novaHodnotaStr.equalsIgnoreCase("false")) {
                        kniha.setDostupnost(false);
                    } else {
                        System.out.println("Nová hodnota pre atribut 'dostupnost' nie je platna booleanovska hodnota.");
                    }
                    break;
                
                default:
                    System.out.println("Neplatný atribut.");
            }
            System.out.println("Záznam knihy '" + nazovKnihy + "' byl úspěšně upraven.");
        } else {
            System.out.println("Kniha s názvom '" + nazovKnihy + "' nebola najdena v databázi.");
        }
    }
    public kniha getKniha(String nazovKnihy) {
        return kniznica.get(nazovKnihy);
    }
    public List<kniha> filterPodlaZanru(String zaner) {
        List<kniha> najdenieKnihy = new ArrayList<>();
        
        for (kniha kniha : kniznica.values()) {
            if (roman.getZaner().equalsIgnoreCase(zaner)) {
                najdenieKnihy.add(kniha);
            }

    }
		return najdenieKnihy;
	
}
    public void odstranitZaznam(String nazovKnihy) {
        if (kniznica.containsKey(nazovKnihy)) {
            kniznica.remove(nazovKnihy);
            System.out.println("Záznam knihy '" + nazovKnihy + "' bol uspesne odstraneny z databázi.");
        } else {
            System.out.println("Kniha s názvom '" + nazovKnihy + "' nebola najdena v databázi.");
        }
    }
}
