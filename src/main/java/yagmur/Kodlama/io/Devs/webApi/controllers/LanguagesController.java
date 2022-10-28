package yagmur.Kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import yagmur.Kodlama.io.Devs.business.abstracts.LanguageService;
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
	public List<Language> getAll(){
		return languageService.getAll();
	}
	
	@GetMapping("/getbyid")
	public Language getById(@RequestParam int id) {
		return languageService.GetById(id);
	}

	@PostMapping("/add")
	public void add(Language language) {
		languageService.Add(language);
	}
	
	@PostMapping("/update")
	public void update(@RequestBody Language language) {
		languageService.update(language);
	}
	
	@PostMapping("/delete")
	public void delete(@RequestParam int id) {
		languageService.Delete(id);
	}
	

	
}
