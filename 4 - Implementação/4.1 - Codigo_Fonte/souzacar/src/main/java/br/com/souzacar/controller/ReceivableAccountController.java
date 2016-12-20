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

import br.com.souzacar.model.ReceivableAccount;
import br.com.souzacar.repository.ReceivableAccountRepository;
import br.com.souzacar.utlis.Response;

@RestController
@RequestMapping("/api/receivableAcconts")
public class ReceivableAccountController {

	@Autowired
	private ReceivableAccountRepository receivableAccountRepository;
	@Autowired
	private Response response;
	@Autowired
	private ReceivableAccount receivableAccount;
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody Response insert(@RequestBody ReceivableAccount receivableAccount){
		try {
			receivableAccountRepository.save(receivableAccount);
			response.setData(receivableAccount);
		} catch (Exception e) {
			response.setStatus(500, e.getMessage());
		}
		return response;
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = "application/json")
	public @ResponseBody Response update(@PathVariable long id, @RequestBody ReceivableAccount receivableAccount){
		try {
			receivableAccountRepository.save(receivableAccount);
			response.setData(receivableAccount);
		} catch (Exception e) {
			response.setStatus(500, e.getMessage());
		}
		
		return response;
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public @ResponseBody Response delete(@PathVariable long id){
		receivableAccount = receivableAccountRepository.findOne(id);
		try {
			receivableAccountRepository.delete(receivableAccount);
		} catch (Exception e) {
			response.setStatus(500, e.getMessage());
		}
		
		return new Response(receivableAccount, null);
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
	public Response list(){
		List<ReceivableAccount> result = new ArrayList<ReceivableAccount>();
		Iterator<ReceivableAccount> iterator = receivableAccountRepository.findAll().iterator();
		
		while(iterator.hasNext()){
			result.add(iterator.next());
		}
				
		return new Response(result, null);
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public Response get(@PathVariable long id){
		receivableAccount = receivableAccountRepository.findOne(id);

		return new Response(receivableAccount, null);
	}
}
