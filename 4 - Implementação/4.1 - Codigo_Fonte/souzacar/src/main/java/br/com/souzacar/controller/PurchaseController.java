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

import br.com.souzacar.model.Purchase;
import br.com.souzacar.repository.PurchaseRepository;
import br.com.souzacar.utlis.Response;

@RestController
@RequestMapping("/api/purchases")
public class PurchaseController {
	
	@Autowired
	private PurchaseRepository purchaseRepository;
	@Autowired
	private Response response;
	@Autowired
	private Purchase purchase;
	
	public PurchaseController() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PurchaseController(br.com.souzacar.repository.PurchaseRepository purchaseRepository, Response response,
			Purchase purchase) {
		super();
		this.purchaseRepository = purchaseRepository;
		this.response = response;
		this.purchase = purchase;
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody Response insert(@RequestBody Purchase purchase){
		try {
			purchaseRepository.save(purchase);
			response.setData(purchase);
		} catch (Exception e) {
			response.setStatus(500, e.getMessage());
		}
		return response;
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = "application/json")
	public @ResponseBody Response update(@PathVariable long id, @RequestBody Purchase purchase){
		try {
			purchaseRepository.save(purchase);
			response.setData(purchase);
		} catch (Exception e) {
			response.setStatus(500, e.getMessage());
		}
		
		return response;
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public @ResponseBody Response delete(@PathVariable long id){
		purchase = purchaseRepository.findOne(id);
		try {
			purchaseRepository.delete(purchase);
		} catch (Exception e) {
			response.setStatus(500, e.getMessage());
		}
		
		return new Response(purchase, null);
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
	public Response list(){
		List<Purchase> result = new ArrayList<Purchase>();
		Iterator<Purchase> iterator = purchaseRepository.findAll().iterator();
		
		while(iterator.hasNext()){
			result.add(iterator.next());
		}
				
		return new Response(result, null);
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public Response get(@PathVariable long id){
		purchase = purchaseRepository.findOne(id);

		return new Response(purchase, null);
	}
}