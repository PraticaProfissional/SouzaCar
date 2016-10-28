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

import br.com.souzacar.model.Venda;
import br.com.souzacar.repository.VendaRepository;
import br.com.souzacar.utlis.Response;

@RestController
@RequestMapping("/venda")
public class VendaController {

	@Autowired
	private  VendaRepository vendaRepository;
	@Autowired
	private Response response;
	@Autowired
	private Venda venda;
	
	public VendaController() {
		super();
	}
	
	public VendaController(VendaRepository vendaRepository, Response response, Venda venda) {
		super();
		this.vendaRepository = vendaRepository;
		this.response = response;
		this.venda = venda;
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/venda/", method = RequestMethod.POST)
	public @ResponseBody Response insert(@RequestBody Venda venda){
		try {
			vendaRepository.save(venda);
			response.setData(venda);
		} catch (Exception e) {
			response.setStatus(500, e.getMessage());
		}
		
		return response;
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/venda/{id}", method = RequestMethod.PUT)
	public @ResponseBody Response update(@PathVariable long id, @RequestBody Venda venda){
		try {
			vendaRepository.save(venda);
			response.setData(venda);
		} catch (Exception e) {
			response.setStatus(500, e.getMessage());
		}
		return response;
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/venda/{id}", method = RequestMethod.DELETE)
	public @ResponseBody Response delete(@PathVariable long id){
		venda = vendaRepository.findOne(id);
		try {
			vendaRepository.delete(venda);
		} catch (Exception e) {
			response.setStatus(500, e.getMessage());
		}
		return new Response(venda, null);
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "", method = RequestMethod.GET)
	public Response list(){
		List<Venda> result = new ArrayList<Venda>();
		Iterator<Venda> iterator = vendaRepository.findAll().iterator();
		
		while (iterator.hasNext()) {
			result.add(iterator.next());
		}
		
		return new Response(venda, null);
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/venda/{id}", method = RequestMethod.GET)
	public Response get(@PathVariable long id){
		venda = vendaRepository.findOne(id);
		
		return new Response(venda, null);
	}
	
	public Response vendasMes(){
		return response;
	}
	
	public Response vendasSemestre(){
		return response;
	}
	
	public Response vendasAno(){
		return response;
	}
}