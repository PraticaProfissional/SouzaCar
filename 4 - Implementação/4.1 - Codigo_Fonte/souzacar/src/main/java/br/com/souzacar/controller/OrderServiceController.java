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

import br.com.souzacar.model.OrderService;
import br.com.souzacar.repository.OrderServiceRepository;
import br.com.souzacar.utlis.Response;

@RestController
@RequestMapping("/api/orderServices")
public class OrderServiceController {

	@Autowired
	private OrderServiceRepository orderServiceRepository;
	@Autowired
	private Response response;
	@Autowired
	private OrderService orderService;
	
	public OrderServiceController() {
		super();
	}

	public OrderServiceController(OrderServiceRepository orderServiceRepository, Response response,
			OrderService orderService) {
		super();
		this.orderServiceRepository = orderServiceRepository;
		this.response = response;
		this.orderService = orderService;
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody Response insert(@RequestBody OrderService orderService){
		try {
			orderServiceRepository.save(orderService);
			response.setData(orderService);
		} catch (Exception e) {
			response.setStatus(500, e.getMessage());
		}
		return response;
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = "application/json")
	public @ResponseBody Response update(@PathVariable long id, @RequestBody OrderService orderService){
		try {
			orderServiceRepository.save(orderService);
			response.setData(orderService);
		} catch (Exception e) {
			response.setStatus(500, e.getMessage());
		}
		
		return response;
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public @ResponseBody Response delete(@PathVariable long id){
		orderService = orderServiceRepository.findOne(id);
		try {
			orderServiceRepository.delete(orderService);
		} catch (Exception e) {
			response.setStatus(500, e.getMessage());
		}
		
		return new Response(orderService, null);
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
	public Response list(){
		List<OrderService> result = new ArrayList<OrderService>();
		Iterator<OrderService> iterator = orderServiceRepository.findAll().iterator();
		
		while(iterator.hasNext()){
			result.add(iterator.next());
		}
				
		return new Response(result, null);
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public Response get(@PathVariable long id){
		orderService = orderServiceRepository.findOne(id);

		return new Response(orderService, null);
	}
}
