package hashmap;

import java.util.List;

public class ucebnica extends kniha{
	static String vekova_kategoria;
	public ucebnica(String nazov, List<String> autor, int rok_vydania, boolean dostupnost, String vekova_kategoria ) {
		super(nazov, autor, rok_vydania, dostupnost);
		this.vekova_kategoria = vekova_kategoria;
	}
	public String getVekova_kategoria() {
		return vekova_kategoria;
	}
	public void setVekova_kategoria(String vekova_kategoria) {
		this.vekova_kategoria = vekova_kategoria;
	}
	

}
