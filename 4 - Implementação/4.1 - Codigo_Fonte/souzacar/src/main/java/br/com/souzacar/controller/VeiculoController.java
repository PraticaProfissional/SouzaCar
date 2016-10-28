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

import br.com.souzacar.model.Veiculo;
import br.com.souzacar.repository.VeiculoRepository;
import br.com.souzacar.utlis.Response;

@RestController
@RequestMapping("/veiculo")
public class VeiculoController {

	@Autowired
	private VeiculoRepository veiculoRepository;
	@Autowired
	private Response response;
	@Autowired
	private Veiculo veiculo;
	
	public VeiculoController() {
		super();
	}

	public VeiculoController(VeiculoRepository veiculoRepository, Response response, Veiculo veiculo) {
		super();
		this.veiculoRepository = veiculoRepository;
		this.response = response;
		this.veiculo = veiculo;
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/veiculo/", method = RequestMethod.POST)
	public @ResponseBody Response insert(@RequestBody Veiculo veiculo){
		try {
			veiculoRepository.save(veiculo);
			response.setData(veiculo);
		} catch (Exception e) {
			response.setStatus(500, e.getMessage());
		}
		return response;
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/veiculo/{id}", method = RequestMethod.PUT)
	public @ResponseBody Response update(@PathVariable long id, @RequestBody Veiculo veiculo){
		try {
			veiculoRepository.save(veiculo);
			response.setData(veiculo);
		} catch (Exception e) {
			response.setStatus(500, e.getMessage());
		}
		return response;
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/veiculo/{id}", method = RequestMethod.DELETE)
	public @ResponseBody Response  delete(@PathVariable long id){
		veiculo = veiculoRepository.findOne(id);
		try {
			veiculoRepository.delete(veiculo);
		} catch (Exception e) {
			response.setStatus(500, e.getMessage());
		}
		return new Response(veiculo, null);
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/veiculo/list", method = RequestMethod.GET)
	public Response list(){
		List<Veiculo> result = new ArrayList<Veiculo>();
		Iterator<Veiculo> iterator = veiculoRepository.findAll().iterator();
		
		while (iterator.hasNext()) {
			result.add(iterator.next());
		}
		
		return new Response(veiculo, null);
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/veiculo/{id}", method = RequestMethod.GET)
	public Response get(@PathVariable long id){
		veiculo = veiculoRepository.findOne(id);
		
		return new Response(veiculo, null);
	}
}