package yagmur.Kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yagmur.Kodlama.io.Devs.business.abstracts.TechnologyService;
import yagmur.Kodlama.io.Devs.business.requests.technology.CreateTechnologyiesRequest;
import yagmur.Kodlama.io.Devs.business.requests.technology.DeleteTechnologyRequest;
import yagmur.Kodlama.io.Devs.business.requests.technology.UpdateTechnologyRequest;
import yagmur.Kodlama.io.Devs.business.responses.technology.GetAllTechnologyResponse;
import yagmur.Kodlama.io.Devs.business.responses.technology.GetByIdTechnologyResponse;
import yagmur.Kodlama.io.Devs.dataAccess.abstracts.TechnologyRepository;
import yagmur.Kodlama.io.Devs.entities.concretes.Technology;

@Service
public class TechnologyManager implements TechnologyService {

	private TechnologyRepository technologyRepository;
	
	@Autowired
	public TechnologyManager(TechnologyRepository technologyRepository) {
		this.technologyRepository = technologyRepository;
	}
	
	@Override
	public List<GetAllTechnologyResponse> getAll() {
		List<Technology> technologies = this.technologyRepository.findAll();
		List<GetAllTechnologyResponse> technologiesResponse = new ArrayList<>();
		for(Technology technology : technologies) {
			GetAllTechnologyResponse responseItem = new GetAllTechnologyResponse();
			responseItem.setId(technology.getId());
			responseItem.setName(technology.getTechnologyName());
			
			technologiesResponse.add(responseItem);
		}
		return technologiesResponse;
	}

	@Override
	public GetByIdTechnologyResponse getById(int id) {

		Technology technology = this.technologyRepository.findById(id).get();
		GetByIdTechnologyResponse responseItem = new GetByIdTechnologyResponse();
		responseItem.setId(technology.getId());
		responseItem.setName(technology.getTechnologyName());
		
		return responseItem;
	}

	@Override
	public void add(CreateTechnologyiesRequest createTechnologyRequest) {
		Technology technology = new Technology();
		technology.setTechnologyName(createTechnologyRequest.getName());
		this.technologyRepository.save(technology);
		
	}

	@Override
	public void delete(DeleteTechnologyRequest deleteTechnologyRequest) {
		this.technologyRepository.deleteById(deleteTechnologyRequest.getId());
		
	}

	@Override
	public void update(UpdateTechnologyRequest updateTechnologyRequest) {
		Technology technology = this.technologyRepository.findById(updateTechnologyRequest.getId()).get();
		technology.setTechnologyName(updateTechnologyRequest.getName());
		this.technologyRepository.save(technology);
		
		
		
	}

}
