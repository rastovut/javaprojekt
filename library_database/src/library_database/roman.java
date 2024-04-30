package library_database;

public class roman extends kniha {
	private String typ;
	public roman(String nazov, String autor, int rok_vydania, int dostupnost, String typ) {
		super(nazov, autor, rok_vydania, dostupnost);
		
	}
	public String getTyp() {
		return typ;
	}
	public void setTyp(String typ) {
		this.typ = typ;
	}

}
