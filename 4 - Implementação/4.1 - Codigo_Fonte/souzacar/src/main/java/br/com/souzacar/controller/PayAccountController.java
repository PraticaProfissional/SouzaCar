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

import br.com.souzacar.model.PayAccount;
import br.com.souzacar.repository.PayAccountReposutory;
import br.com.souzacar.utlis.Response;

@RestController
@RequestMapping("/api/payAccounts")
public class PayAccountController {

	@Autowired
	private PayAccountReposutory payAccountReposutory;
	@Autowired
	private Response response;
	@Autowired
	private PayAccount payAccount;
	
	public PayAccountController() {
		super();
	}

	public PayAccountController(PayAccountReposutory payAccountReposutory, Response response, PayAccount payAccount) {
		super();
		this.payAccountReposutory = payAccountReposutory;
		this.response = response;
		this.payAccount = payAccount;
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody Response insert(@RequestBody PayAccount payAccount){
		try {
			payAccountReposutory.save(payAccount);
			response.setData(payAccount);
		} catch (Exception e) {
			response.setStatus(500, e.getMessage());
		}
		return response;
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = "application/json")
	public @ResponseBody Response update(@PathVariable long id, @RequestBody PayAccount payAccount){
		try {
			payAccountReposutory.save(payAccount);
			response.setData(payAccount);
		} catch (Exception e) {
			response.setStatus(500, e.getMessage());
		}
		
		return response;
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public @ResponseBody Response delete(@PathVariable long id){
		payAccount = payAccountReposutory.findOne(id);
		try {
			payAccountReposutory.delete(payAccount);
		} catch (Exception e) {
			response.setStatus(500, e.getMessage());
		}
		
		return new Response(payAccount, null);
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
	public Response list(){
		List<PayAccount> result = new ArrayList<PayAccount>();
		Iterator<PayAccount> iterator = payAccountReposutory.findAll().iterator();
		
		while(iterator.hasNext()){
			result.add(iterator.next());
		}
				
		return new Response(result, null);
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public Response get(@PathVariable long id){
		payAccount = payAccountReposutory.findOne(id);

		return new Response(payAccount, null);
	}	
}
