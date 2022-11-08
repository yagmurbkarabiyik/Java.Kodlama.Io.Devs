package yagmur.Kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import yagmur.Kodlama.io.Devs.business.abstracts.LanguageService;
import yagmur.Kodlama.io.Devs.business.requests.language.CreateLanguageRequest;
import yagmur.Kodlama.io.Devs.business.requests.language.DeleteLanguageRequest;
import yagmur.Kodlama.io.Devs.business.requests.language.UpdateLanguageRequest;
import yagmur.Kodlama.io.Devs.business.responses.language.GetAllLanguagesResponse;
import yagmur.Kodlama.io.Devs.business.responses.language.GetByIdLanguageResponse;
import yagmur.Kodlama.io.Devs.entities.concretes.Language;

//annotation
@RestController
@RequestMapping("/api/languages")
public class LanguagesController {

	private LanguageService languageService;

	@Autowired
	public LanguagesController(LanguageService languageService) {
		this.languageService = languageService;
	}

	@GetMapping("/getall")
	public List<GetAllLanguagesResponse> getAll() {
		return this.languageService.getAll();
	}

	@GetMapping("/getbyid/{id}")
	public GetByIdLanguageResponse getById(@RequestParam int id) {
		return this.languageService.getById(id);
	}

	@PostMapping("/add")
	public void add(CreateLanguageRequest createLanguageRequest) {
		this.languageService.add(createLanguageRequest);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(DeleteLanguageRequest deleteLanguageRequest) {
		this.languageService.delete(deleteLanguageRequest);
	}

	@PutMapping("/update")
	public void update(UpdateLanguageRequest updateLanguageRequest) {
		this.languageService.update(updateLanguageRequest);
	}

}
