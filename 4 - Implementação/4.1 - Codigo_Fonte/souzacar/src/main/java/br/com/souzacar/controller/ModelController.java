package br.com.souzacar.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.souzacar.model.Model;
import br.com.souzacar.repository.ModelRepository;
import br.com.souzacar.utlis.Response;

@RestController
@RequestMapping("/api/models")
public class ModelController {

	@Autowired
	private ModelRepository modelRepository;
	@Autowired
	private Response response;
	@Autowired
	private Model model;
	
	public ModelController() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ModelController(ModelRepository modelRepository, Response response, Model model) {
		super();
		this.modelRepository = modelRepository;
		this.response = response;
		this.model = model;
	}
	
	@CrossOrigin(value = "*")
	@RequestMapping(value = "", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody Response insert(@RequestBody Model model){
		try {
			modelRepository.save(model);
			response.setData(model);
		} catch (Exception e) {
			response.setStatus(500, e.getMessage());
		}
		
		return response;
	}
	
	@CrossOrigin(value = "*")
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = "application/json")
	public @ResponseBody Response update(@PathVariable long id, @RequestBody Model model){
		try {
			modelRepository.save(model);
			response.setData(model);
		} catch (Exception e) {
			response.setStatus(500, e.getMessage());
		}
		
		return response;
	}
	
	@CrossOrigin(value = "*")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public @ResponseBody Response delete(@PathVariable long id){
		model = modelRepository.findOne(id);
		try {
			modelRepository.delete(model);
		} catch (Exception e) {
			response.setStatus(500, e.getMessage());
		}
		
		return new Response(model, null);
	}
	
	@CrossOrigin
	@RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
	public Response list(){
		List<Model> result = new ArrayList<Model>();
		Iterator<Model> iterator = modelRepository.findAll().iterator();
		
		while(iterator.hasNext()){
			result.add(iterator.next());
		}
		
		return new Response(result, null);
	}
	
	@CrossOrigin
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public Response get(@PathVariable long id){
		model = modelRepository.findOne(id);
		
		return new Response(model, null);
	}
}