package yagmur.Kodlama.io.Devs.entities.concretes;

public class Language {

	private int id;
	private String languageName;
	
	public Language() {
	}
	
	public Language(int id, String languageName) {
		this.id = id;
		this.languageName = languageName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLanguageName() {
		return languageName;
	}

	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}
	
	

}
