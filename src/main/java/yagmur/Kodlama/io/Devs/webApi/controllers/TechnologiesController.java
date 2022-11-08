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

import yagmur.Kodlama.io.Devs.business.abstracts.TechnologyService;
import yagmur.Kodlama.io.Devs.business.requests.technology.CreateTechnologyiesRequest;
import yagmur.Kodlama.io.Devs.business.requests.technology.DeleteTechnologyRequest;
import yagmur.Kodlama.io.Devs.business.requests.technology.UpdateTechnologyRequest;
import yagmur.Kodlama.io.Devs.business.responses.technology.GetAllTechnologyResponse;
import yagmur.Kodlama.io.Devs.business.responses.technology.GetByIdTechnologyResponse;

@RestController
@RequestMapping("/api/technologies")
public class TechnologiesController {

	private TechnologyService technologyService;

	@Autowired
	public TechnologiesController(TechnologyService technologyService) {
		this.technologyService = technologyService;
	}
	
	@GetMapping("/getall")
	public List<GetAllTechnologyResponse> getAll(){
		return this.technologyService.getAll();
	}
	
	@GetMapping("/getbyid/{id}")
	public GetByIdTechnologyResponse getById(@RequestParam int id) {
		return this.technologyService.getById(id);
	}
	
	@PostMapping("/add")
	public void add(CreateTechnologyiesRequest createTechnologyRequest) {
		this.technologyService.add(createTechnologyRequest);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(DeleteTechnologyRequest deleteTechnologyRequest) {
		this.technologyService.delete(deleteTechnologyRequest);
	}
	
	@PutMapping("/update")
	public void update(UpdateTechnologyRequest updateTechnologyRequest) {
		this.technologyService.update(updateTechnologyRequest);
	}
}
