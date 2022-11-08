package yagmur.Kodlama.io.Devs.business.abstracts;

import java.util.List;

import yagmur.Kodlama.io.Devs.business.requests.technology.CreateTechnologyiesRequest;
import yagmur.Kodlama.io.Devs.business.requests.technology.DeleteTechnologyRequest;
import yagmur.Kodlama.io.Devs.business.requests.technology.UpdateTechnologyRequest;
import yagmur.Kodlama.io.Devs.business.responses.technology.GetAllTechnologyResponse;
import yagmur.Kodlama.io.Devs.business.responses.technology.GetByIdTechnologyResponse;

public interface TechnologyService {

	List<GetAllTechnologyResponse> getAll();
	GetByIdTechnologyResponse getById(int id);
	void add(CreateTechnologyiesRequest createTechnologyRequest);
	void delete(DeleteTechnologyRequest deleteTechnologyRequest);
	void update(UpdateTechnologyRequest updateTechnologyRequest);

}
