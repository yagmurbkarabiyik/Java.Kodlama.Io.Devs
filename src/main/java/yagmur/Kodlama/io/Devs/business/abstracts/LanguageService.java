package yagmur.Kodlama.io.Devs.business.abstracts;

import java.util.List;

import yagmur.Kodlama.io.Devs.entities.concretes.Language;

public interface LanguageService {
	
	List<Language> getAll();
	Language GetById(int id);
	void Add(Language language);
	void Delete(int id);
	void update(Language language);
	
}
