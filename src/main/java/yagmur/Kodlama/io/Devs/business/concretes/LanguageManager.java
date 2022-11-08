package yagmur.Kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yagmur.Kodlama.io.Devs.business.abstracts.LanguageService;
import yagmur.Kodlama.io.Devs.business.requests.language.CreateLanguageRequest;
import yagmur.Kodlama.io.Devs.business.requests.language.DeleteLanguageRequest;
import yagmur.Kodlama.io.Devs.business.requests.language.UpdateLanguageRequest;
import yagmur.Kodlama.io.Devs.business.responses.language.GetAllLanguagesResponse;
import yagmur.Kodlama.io.Devs.business.responses.language.GetByIdLanguageResponse;
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
	public List<GetAllLanguagesResponse> getAll() {
		List<Language> languages = this.languageRepository.findAll();
		List<GetAllLanguagesResponse> languagesResponse = new ArrayList<>();
		for(Language language : languages) {
			GetAllLanguagesResponse responseItem = new GetAllLanguagesResponse();
			responseItem.setId(language.getId());
			responseItem.setLanguageName(language.getLanguageName());
			
			languagesResponse.add(responseItem);
		}
		return languagesResponse;
	}

	@Override
	public GetByIdLanguageResponse getById(int id) {
		Language language = this.languageRepository.findById(id).get();
		GetByIdLanguageResponse responseItem = new GetByIdLanguageResponse();
		responseItem.setId(language.getId());
		responseItem.setName(language.getLanguageName());
		
		return responseItem;
	}

	@Override
	public void add(CreateLanguageRequest createLanguageRequest) {
		Language language = new Language();
		language.setLanguageName(createLanguageRequest.getLanguageName());
		this.languageRepository.save(language);
	}

	@Override
	public void delete(DeleteLanguageRequest deleteLanguageRequest) {

		this.languageRepository.deleteById(deleteLanguageRequest.getId());
	}

	@Override
	public void update(UpdateLanguageRequest updateLanguageRequest) {
		Language language = this.languageRepository.findById(updateLanguageRequest.getId()).get();
		language.setLanguageName(updateLanguageRequest.getName());
		this.languageRepository.save(language);
		
	}
	
}
