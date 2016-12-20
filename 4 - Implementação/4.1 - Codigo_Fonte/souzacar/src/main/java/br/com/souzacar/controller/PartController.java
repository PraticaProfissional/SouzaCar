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

import br.com.souzacar.model.Part;
import br.com.souzacar.repository.PartRepository;
import br.com.souzacar.utlis.Response;

@RestController
@RequestMapping("/api/parts")
public class PartController {

	@Autowired
	private PartRepository partRepository; 
	@Autowired
	private Response response;
	@Autowired
	private Part part;
		
	public PartController() {
		super();
	}

	public PartController(PartRepository partRepository, Response response, Part part) {
		super();
		this.partRepository = partRepository;
		this.response = response;
		this.part = part;
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody Response insert(@RequestBody Part part){
		try {
			partRepository.save(part);
			response.setData(part);
		} catch (Exception e) {
			response.setStatus(500, e.getMessage());
		}
		return response;
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = "application/json")
	public @ResponseBody Response update(@PathVariable long id, @RequestBody Part part){
		try {
			partRepository.save(part);
			response.setData(part);
		} catch (Exception e) {
			response.setStatus(500, e.getMessage());
		}
		
		return response;
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public @ResponseBody Response delete(@PathVariable long id){
		part = partRepository.findOne(id);
		try {
			partRepository.delete(part);
		} catch (Exception e) {
			response.setStatus(500, e.getMessage());
		}
		
		return new Response(part, null);
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
	public Response list(){
		List<Part> result = new ArrayList<Part>();
		Iterator<Part> iterator = partRepository.findAll().iterator();
		
		while(iterator.hasNext()){
			result.add(iterator.next());
		}
				
		return new Response(result, null);
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public Response get(@PathVariable long id){
		part = partRepository.findOne(id);

		return new Response(part, null);
	}
}
