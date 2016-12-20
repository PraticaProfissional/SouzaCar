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

import br.com.souzacar.model.Sale;
import br.com.souzacar.repository.SaleRepository;
import br.com.souzacar.utlis.Response;

@RestController
@RequestMapping("/api/sales")
public class SaleController {

	@Autowired
	private  SaleRepository saleRepository;
	@Autowired
	private Response response;
	@Autowired
	private Sale sale;
	
	public SaleController() {
		super();
	}
	
	public SaleController(SaleRepository saleRepository, Response response, Sale sale) {
		super();
		this.saleRepository = saleRepository;
		this.response = response;
		this.sale = sale;
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody Response insert(@RequestBody Sale sale){
		try {
			saleRepository.save(sale);
			response.setData(sale);
		} catch (Exception e) {
			response.setStatus(500, e.getMessage());
		}
		
		return response;
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = "application/json")
	public @ResponseBody Response update(@PathVariable long id, @RequestBody Sale sale){
		try {
			saleRepository.save(sale);
			response.setData(sale);
		} catch (Exception e) {
			response.setStatus(500, e.getMessage());
		}
		return response;
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public @ResponseBody Response delete(@PathVariable long id){
		sale = saleRepository.findOne(id);
		try {
			saleRepository.delete(sale);
		} catch (Exception e) {
			response.setStatus(500, e.getMessage());
		}
		return new Response(sale, null);
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
	public Response list(){
		List<Sale> result = new ArrayList<Sale>();
		Iterator<Sale> iterator = saleRepository.findAll().iterator();
		
		while (iterator.hasNext()) {
			result.add(iterator.next());
		}
		
		return new Response(result, null);
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public Response get(@PathVariable long id){
		sale = saleRepository.findOne(id);
		
		return new Response(sale, null);
	}
	
	public Response salesMes(){
		return response;
	}
	
	public Response salesSemestre(){
		return response;
	}
	
	public Response salesAno(){
		return response;
	}
}