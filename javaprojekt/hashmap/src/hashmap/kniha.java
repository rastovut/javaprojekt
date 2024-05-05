package hashmap;

import java.util.List;

public class kniha {
		private String nazov;
		private List<String> autor;
		private int rok_vydania;
		private boolean dostupnost;
		
		public kniha(String nazov, List<String> autori, int rok_vydania, boolean dostupnost) {
			this.nazov = nazov;
			this.autor = autori;
			this.rok_vydania = rok_vydania;
			this.dostupnost = dostupnost;
		}

		public String getNazov() {
			return nazov;
		}

		public void setNazov(String nazov) {
			this.nazov = nazov;
		}

		public List<String> getAutor() {
			return autor;
		}

		public void setAutor(List<String> autor) {
			this.autor = autor;
		}

		public int getRok_vydania() {
			return rok_vydania;
		}

		public void setRok_vydania(int rok_vydania) {
			this.rok_vydania = rok_vydania;
		}

		public boolean isDostupnost() {
			return dostupnost;
		}

		public void setDostupnost(boolean dostupnost) {
			this.dostupnost = dostupnost;
		}
		
	}


