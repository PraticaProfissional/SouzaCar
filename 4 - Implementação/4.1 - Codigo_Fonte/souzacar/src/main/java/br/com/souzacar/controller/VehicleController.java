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

import br.com.souzacar.model.Vehicle;
import br.com.souzacar.repository.VehicleRepository;
import br.com.souzacar.utlis.Response;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

	@Autowired
	private VehicleRepository vehicleRepository;
	@Autowired
	private Response response;
	@Autowired
	private Vehicle vehicle;
	
	public VehicleController() {
		super();
	}

	public VehicleController(VehicleRepository vehicleRepository, Response response, Vehicle vehicle) {
		super();
		this.vehicleRepository = vehicleRepository;
		this.response = response;
		this.vehicle = vehicle;
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody Response insert(@RequestBody Vehicle vehicle){
		try {
			vehicleRepository.save(vehicle);
			response.setData(vehicle);
		} catch (Exception e) {
			response.setStatus(500, e.getMessage());
		}
		return response;
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = "application/json")
	public @ResponseBody Response update(@PathVariable long id, @RequestBody Vehicle vehicle){
		try {
			vehicleRepository.save(vehicle);
			response.setData(vehicle);
		} catch (Exception e) {
			response.setStatus(500, e.getMessage());
		}
		return response;
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public @ResponseBody Response  delete(@PathVariable long id){
		vehicle = vehicleRepository.findOne(id);
		try {
			vehicleRepository.delete(vehicle);
		} catch (Exception e) {
			response.setStatus(500, e.getMessage());
		}
		return new Response(vehicle, null);
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
	public Response list(){
		List<Vehicle> result = new ArrayList<Vehicle>();
		Iterator<Vehicle> iterator = vehicleRepository.findAll().iterator();
		
		while (iterator.hasNext()) {
			result.add(iterator.next());
		}
		
		return new Response(result, null);
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public Response get(@PathVariable long id){
		vehicle = vehicleRepository.findOne(id);
		
		return new Response(vehicle, null);
	}
}