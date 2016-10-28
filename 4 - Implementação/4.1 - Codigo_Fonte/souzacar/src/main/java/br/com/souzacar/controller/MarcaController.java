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

import br.com.souzacar.model.Marca;
import br.com.souzacar.repository.MarcaRepository;
import br.com.souzacar.utlis.Response;

@RestController
@RequestMapping("/api/marcas")
public class MarcaController {

	@Autowired
	private MarcaRepository marcaRepository;
	@Autowired
	private Response response;
	@Autowired
	private Marca marca;
	
	public MarcaController() {
		super();
	}

	public MarcaController(MarcaRepository marcaRepository, Response response, Marca marca) {
		super();
		this.marcaRepository = marcaRepository;
		this.response = response;
		this.marca = marca;
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "", method = RequestMethod.POST)
	public @ResponseBody Response insert(@RequestBody Marca marca){
		try {
			marcaRepository.save(marca);
			response.setData(marca);
		} catch (Exception e) {
			response.setStatus(500, e.getMessage());
		}
		return response;
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public @ResponseBody Response update(@PathVariable long id, @RequestBody Marca marca){
		try {
			marcaRepository.save(marca);
			response.setData(marca);
		} catch (Exception e) {
			response.setStatus(500, e.getMessage());
		}
		
		return response;
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public @ResponseBody Response delete(@PathVariable long id){
		marca = marcaRepository.findOne(id);
		try {
			marcaRepository.delete(marca);
		} catch (Exception e) {
			response.setStatus(500, e.getMessage());
		}
		
		return new Response(marca, null);
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "", method = RequestMethod.GET)
	public Response list(){
		List<Marca> result = new ArrayList<Marca>();
		Iterator<Marca> iterator = marcaRepository.findAll().iterator();
		
		while(iterator.hasNext()){
			result.add(iterator.next());
		}
				
		return new Response(result, null);
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Response get(@PathVariable long id){
		marca = marcaRepository.findOne(id);

		return new Response(marca, null);
	}
}