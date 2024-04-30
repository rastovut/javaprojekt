package library_database;

public class kniha {
	private String nazov;
	private String autor;
	private int rok_vydania;
	private int dostupnost;
	public kniha(String nazov, String autor, int rok_vydania, int dostupnost) {
		this.nazov=nazov;
		this.autor=autor;
		this.rok_vydania=rok_vydania;
		this.dostupnost = dostupnost;
	}
	public String getNazov() {
		return nazov;
	}
	public void setNazov(String nazov) {
		this.nazov = nazov;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public int getRok_vydania() {
		return rok_vydania;
	}
	public void setRok_vydania(int rok_vydania) {
		this.rok_vydania = rok_vydania;
	}
	public int getDostupnost() {
		return dostupnost;
	}
	public void setDostupnost(int dostupnost) {
		this.dostupnost = dostupnost;
	}
	
}
