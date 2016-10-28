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

import br.com.souzacar.model.Modelo;
import br.com.souzacar.repository.ModeloRepository;
import br.com.souzacar.utlis.Response;

@RestController
@RequestMapping("/modelo")
public class ModeloController {

	@Autowired
	private ModeloRepository modeloRepository;
	@Autowired
	private Response response;
	@Autowired
	private Modelo modelo;
	
	public ModeloController() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ModeloController(ModeloRepository modeloRepository, Response response, Modelo modelo) {
		super();
		this.modeloRepository = modeloRepository;
		this.response = response;
		this.modelo = modelo;
	}
	
	@CrossOrigin(value = "*")
	@RequestMapping(value = "/modelo/", method = RequestMethod.POST)
	public @ResponseBody Response insert(@RequestBody Modelo modelo){
		try {
			modeloRepository.save(modelo);
			response.setData(modelo);
		} catch (Exception e) {
			response.setStatus(500, e.getMessage());
		}
		
		return response;
	}
	
	@CrossOrigin(value = "*")
	@RequestMapping(value = "/modelo/{id}", method = RequestMethod.PUT)
	public @ResponseBody Response update(@PathVariable long id, @RequestBody Modelo modelo){
		try {
			modeloRepository.save(modelo);
			response.setData(modelo);
		} catch (Exception e) {
			response.setStatus(500, e.getMessage());
		}
		
		return response;
	}
	
	@CrossOrigin(value = "*")
	@RequestMapping(value = "/modelo/{id}", method = RequestMethod.DELETE)
	public @ResponseBody Response delete(@PathVariable long id){
		modelo = modeloRepository.findOne(id);
		try {
			modeloRepository.delete(modelo);
		} catch (Exception e) {
			response.setStatus(500, e.getMessage());
		}
		
		return new Response(modelo, null);
	}
	
	@CrossOrigin
	@RequestMapping(value = "/modelo/list", method = RequestMethod.GET)
	public Response list(){
		List<Modelo> result = new ArrayList<Modelo>();
		Iterator<Modelo> iterator = modeloRepository.findAll().iterator();
		
		while(iterator.hasNext()){
			result.add(iterator.next());
		}
		
		return new Response(modelo, null);
	}
	
	@CrossOrigin
	@RequestMapping(value = "/modelo/{id}", method = RequestMethod.GET)
	public Response get(@PathVariable long id){
		modelo = modeloRepository.findOne(id);
		
		return new Response(modelo, null);
	}
}