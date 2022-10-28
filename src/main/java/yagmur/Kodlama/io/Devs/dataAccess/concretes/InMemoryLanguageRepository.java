	package yagmur.Kodlama.io.Devs.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import yagmur.Kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import yagmur.Kodlama.io.Devs.entities.concretes.Language;

@Repository
public class InMemoryLanguageRepository implements LanguageRepository{

	List<Language> languages;
	
	@Autowired
	public InMemoryLanguageRepository() {
		languages = new ArrayList<Language>();
		languages.add(new Language(1, "C#"));
		languages.add(new Language(2, "Java"));
		languages.add(new Language(3, "Phyton"));
	}

	@Override
	public List<Language> getAll(){
		return languages;
	}
	
	@Override
	public Language getById(int id) {
		for(Language language : languages) {
			if(language.getId() == id) {
				return language;
			}
		}
		return null;
	}

	@Override
	public void add(Language language) {
		languages.add(language);
	}

	@Override
	public void update(Language language) {
		Language update = getById(language.getId());
		if(update.getId() == language.getId()) {
			update.setLanguageName(language.getLanguageName());
		}
	}

	@Override
	public void delete(int id) {
		Language language = getById(id);
		languages.remove(language);
	}

}

