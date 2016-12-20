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

import br.com.souzacar.model.Budget;
import br.com.souzacar.repository.BudgetRepository;
import br.com.souzacar.utlis.Response;

@RestController
@RequestMapping("/api/budgets")
public class BudgetController {

	@Autowired
	private BudgetRepository budgetRepository;
	@Autowired
	private Response response;
	@Autowired
	private Budget budget;
	
	public BudgetController() {
		super();
	}

	public BudgetController(BudgetRepository budgetRepository, Response response, Budget budget) {
		super();
		this.budgetRepository = budgetRepository;
		this.response = response;
		this.budget = budget;
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody Response insert(@RequestBody Budget budget){
		try {
			budgetRepository.save(budget);
			response.setData(budget);
		} catch (Exception e) {
			response.setStatus(500, e.getMessage());
		}
		return response;
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = "application/json")
	public @ResponseBody Response update(@PathVariable long id, @RequestBody Budget budget){
		try {
			budgetRepository.save(budget);
			response.setData(budget);
		} catch (Exception e) {
			response.setStatus(500, e.getMessage());
		}
		
		return response;
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public @ResponseBody Response delete(@PathVariable long id){
		budget = budgetRepository.findOne(id);
		try {
			budgetRepository.delete(budget);
		} catch (Exception e) {
			response.setStatus(500, e.getMessage());
		}
		
		return new Response(budget, null);
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
	public Response list(){
		List<Budget> result = new ArrayList<Budget>();
		Iterator<Budget> iterator = budgetRepository.findAll().iterator();
		
		while(iterator.hasNext()){
			result.add(iterator.next());
		}
				
		return new Response(result, null);
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public Response get(@PathVariable long id){
		budget = budgetRepository.findOne(id);

		return new Response(budget, null);
	}
}
