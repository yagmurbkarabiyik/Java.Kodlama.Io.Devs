package yagmur.Kodlama.io.Devs.dataAccess.abstracts;

import java.util.List;

import yagmur.Kodlama.io.Devs.entities.concretes.Language;

public interface LanguageRepository {
	
	List<Language> getAll();
	Language getById(int id);
	void add(Language language);
	void update(Language language);
	void delete(int id);
}
