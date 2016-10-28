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

import br.com.souzacar.model.Fornecedor;
import br.com.souzacar.repository.FornecedorRepository;
import br.com.souzacar.utlis.Response;

@RestController
@RequestMapping("/fornecedor/")
public class FornecedorController {
	
	@Autowired
	private FornecedorRepository fornecedorRepository;
	@Autowired
	private Response response;
	@Autowired
	private Fornecedor fornecedor;
	
	public FornecedorController() {
		super();
	}

	public FornecedorController(FornecedorRepository fornecedorRepository, Response response, Fornecedor fornecedor) {
		super();
		this.fornecedorRepository = fornecedorRepository;
		this.response = response;
		this.fornecedor = fornecedor;
	}
	
	@CrossOrigin(value = "*")
	@RequestMapping(value = "/fornecedor/", method = RequestMethod.POST)
	public @ResponseBody Response insert(@RequestBody Fornecedor fornecedor){
		try {
			fornecedorRepository.save(fornecedor);
			response.setData(fornecedor);
		} catch (Exception e) {
			response.setStatus(500, e.getMessage());
		}
		return response;
	}

	@CrossOrigin(value = "*")
	@RequestMapping(value = "/fornecedor/{id}", method = RequestMethod.PUT)
	public @ResponseBody Response  update(@PathVariable long id, @RequestBody Fornecedor fornecedor){
		try {
			fornecedorRepository.save(fornecedor);
			response.setData(fornecedor);
		} catch (Exception e) {
			response.setStatus(500, e.getMessage());
		}
		return response;
	}
	
	@CrossOrigin(value = "*")
	@RequestMapping(value = "/fornecedor/{id}", method = RequestMethod.DELETE)
	public @ResponseBody Response delete(@PathVariable long id){
		fornecedor = fornecedorRepository.findOne(id);
		try {
			fornecedorRepository.delete(fornecedor);
		} catch (Exception e) {
			response.setStatus(500, e.getMessage());
		}
		return new Response(fornecedor, null);
	}
	
	@CrossOrigin(value = "*")
	@RequestMapping(value = "/fornecedor/list", method = RequestMethod.GET)
	public Response list(){
		List<Fornecedor> result = new ArrayList<Fornecedor>();
		Iterator<Fornecedor> iterator = fornecedorRepository.findAll().iterator();
		
		while(iterator.hasNext()){
			result.add(iterator.next());
		}
		
		return new Response(fornecedor, null);
	}
	
	@CrossOrigin(value = "*")
	@RequestMapping(value = "/fornecedor/{id}", method = RequestMethod.GET)
	public Response get(@PathVariable long id){
		fornecedor = fornecedorRepository.findOne(id);
		
		return new Response(fornecedor, null);
	}
}
