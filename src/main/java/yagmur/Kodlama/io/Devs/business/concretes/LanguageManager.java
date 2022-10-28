package yagmur.Kodlama.io.Devs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yagmur.Kodlama.io.Devs.business.abstracts.LanguageService;
import yagmur.Kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import yagmur.Kodlama.io.Devs.entities.concretes.Language;

@Service
public class LanguageManager implements LanguageService{
	
	private LanguageRepository languageRepository;
	
	@Autowired
	public LanguageManager(LanguageRepository languageRepository) {

		this.languageRepository = languageRepository;
	}
	
	@Override
	public List<Language> getAll() {
		return languageRepository.getAll();
	}
	
	@Override
	public Language GetById(int id) {
		return languageRepository.getById(id);
	}

	@Override
	public void Add(Language language) {
		if(!language.getLanguageName().equals(language.getLanguageName()) && !language.getLanguageName().isEmpty() && language.getId() != 0) {
			languageRepository.add(language);
		}
	}

	@Override
	public void update(Language language) {
		languageRepository.update(language);
	}
	
	@Override
	public void Delete(int id) {
		languageRepository.delete(id);
	}
}
