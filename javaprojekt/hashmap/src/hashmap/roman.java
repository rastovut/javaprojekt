package hashmap;

import java.util.List;

public class roman extends kniha{
	private static String zaner;
	public roman(String nazov,List<String> autori, int rok_vydania, boolean dostupnost, String zaner) {
		super(nazov, autori, rok_vydania, dostupnost);
		this.zaner = zaner;
	}
	public static String getZaner() {
		return zaner;
	}
	public void setZaner(String zaner) {
		this.zaner = zaner;
	}
	public String toString() {
        return "Názov: " + getNazov() + "\n" +
               "Autor: " + getAutor() + "\n" +
               "Rok vydania: " + getRok_vydania() + "\n" +
               "Dostupnost: " + (isDostupnost() ? "Ano" : "Nie") + "\n" +
               "Žáner: " + getZaner();
    }
	
}
