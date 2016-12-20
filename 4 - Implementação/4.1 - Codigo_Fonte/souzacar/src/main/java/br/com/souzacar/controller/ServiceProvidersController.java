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

import br.com.souzacar.model.ServiceProvider;
import br.com.souzacar.repository.ServiceProviderRepository;
import br.com.souzacar.utlis.Response;

@RestController
@RequestMapping("/api/serviceProvider")
public class ServiceProvidersController {

	@Autowired
	private ServiceProviderRepository serviceProviderRepository;
	@Autowired
	private Response response;
	@Autowired
	private ServiceProvider serviceProvider;
	
	public ServiceProvidersController() {
		super();
	}
	
	public ServiceProvidersController(ServiceProviderRepository serviceProviderRepository, Response response,
			ServiceProvider serviceProvider) {
		super();
		this.serviceProviderRepository = serviceProviderRepository;
		this.response = response;
		this.serviceProvider = serviceProvider;
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody Response insert(@RequestBody ServiceProvider serviceProvider){
		try {
			serviceProviderRepository.save(serviceProvider);
			response.setData(serviceProvider);
		} catch (Exception e) {
			response.setStatus(500, e.getMessage());
		}
		return response;
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = "application/json")
	public @ResponseBody Response update(@PathVariable long id, @RequestBody ServiceProvider serviceProvider){
		try {
			serviceProviderRepository.save(serviceProvider);
			response.setData(serviceProvider);
		} catch (Exception e) {
			response.setStatus(500, e.getMessage());
		}
		
		return response;
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public @ResponseBody Response delete(@PathVariable long id){
		serviceProvider = serviceProviderRepository.findOne(id);
		try {
			serviceProviderRepository.delete(serviceProvider);
		} catch (Exception e) {
			response.setStatus(500, e.getMessage());
		}
		
		return new Response(serviceProvider, null);
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
	public Response list(){
		List<ServiceProvider> result = new ArrayList<ServiceProvider>();
		Iterator<ServiceProvider> iterator = serviceProviderRepository.findAll().iterator();
		
		while(iterator.hasNext()){
			result.add(iterator.next());
		}
				
		return new Response(result, null);
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public Response get(@PathVariable long id){
		serviceProvider = serviceProviderRepository.findOne(id);

		return new Response(serviceProvider, null);
	}
}
