package yagmur.Kodlama.io.Devs.business.abstracts;

import java.util.List;

import yagmur.Kodlama.io.Devs.business.requests.language.CreateLanguageRequest;
import yagmur.Kodlama.io.Devs.business.requests.language.DeleteLanguageRequest;
import yagmur.Kodlama.io.Devs.business.requests.language.UpdateLanguageRequest;
import yagmur.Kodlama.io.Devs.business.requests.technology.DeleteTechnologyRequest;
import yagmur.Kodlama.io.Devs.business.responses.language.GetAllLanguagesResponse;
import yagmur.Kodlama.io.Devs.business.responses.language.GetByIdLanguageResponse;

public interface LanguageService {

	List<GetAllLanguagesResponse> getAll();
	GetByIdLanguageResponse getById(int id);
	void add(CreateLanguageRequest createLanguageRequest);
	void delete(DeleteLanguageRequest deleteLanguageRequest);
	void update(UpdateLanguageRequest updateLanguageRequest);
}
