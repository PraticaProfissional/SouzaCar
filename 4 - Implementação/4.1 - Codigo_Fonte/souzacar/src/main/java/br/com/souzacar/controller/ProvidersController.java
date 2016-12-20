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

import br.com.souzacar.model.Providers;
import br.com.souzacar.repository.ProvidersRepository;
import br.com.souzacar.utlis.Response;

@RestController
@RequestMapping("/api/providers")
public class ProvidersController {
	
	@Autowired
	private ProvidersRepository providersRepository;
	@Autowired
	private Response response;
	@Autowired
	private Providers providers;
	
	public ProvidersController() {
		super();
	}

	public ProvidersController(ProvidersRepository providersRepository, Response response, Providers providers) {
		super();
		this.providersRepository = providersRepository;
		this.response = response;
		this.providers = providers;
	}
	
	@CrossOrigin(value = "*")
	@RequestMapping(value = "", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody Response insert(@RequestBody Providers fornecedor){
		try {
			providersRepository.save(fornecedor);
			response.setData(fornecedor);
		} catch (Exception e) {
			response.setStatus(500, e.getMessage());
		}
		return response;
	}

	@CrossOrigin(value = "*")
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = "application/json")
	public @ResponseBody Response  update(@PathVariable long id, @RequestBody Providers fornecedor){
		try {
			providersRepository.save(fornecedor);
			response.setData(fornecedor);
		} catch (Exception e) {
			response.setStatus(500, e.getMessage());
		}
		return response;
	}
	
	@CrossOrigin(value = "*")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public @ResponseBody Response delete(@PathVariable long id){
		providers = providersRepository.findOne(id);
		try {
			providersRepository.delete(providers);
		} catch (Exception e) {
			response.setStatus(500, e.getMessage());
		}
		return new Response(providers, null);
	}
	
	@CrossOrigin(value = "*")
	@RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
	public Response list(){
		List<Providers> result = new ArrayList<Providers>();
		Iterator<Providers> iterator = providersRepository.findAll().iterator();
		
		while(iterator.hasNext()){
			result.add(iterator.next());
		}
		
		return new Response(result, null);
	}
	
	@CrossOrigin(value = "*")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public Response get(@PathVariable long id){
		providers = providersRepository.findOne(id);
		
		return new Response(providers, null);
	}
}
