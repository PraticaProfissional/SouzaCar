//package br.com.souzacar.controller;
//
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import br.com.souzacar.model.User;
//import br.com.souzacar.repository.ContatoRepository;
//import br.com.souzacar.utlis.Response;
//
//@RestController
//@RequestMapping("/souzacar")
//public class UserController {
//
//	@Autowired
//	private ContatoRepository contatoRepository;
//	@Autowired
//	private Response response;
//	@Autowired
//	private User user;
//
//	public UserController() {
//		super();
//	}
//
//	public UserController(ContatoRepository contatoRepository, Response response, User user) {
//		super();
//		this.contatoRepository = contatoRepository;
//		this.response = response;
//		this.user = user;
//	}
//
//	@CrossOrigin(origins = "*")
//	@RequestMapping(value = "", method = RequestMethod.POST)
//	public @ResponseBody Response insert(@RequestBody User user) {
//		try {
//			contatoRepository.save(user);
//			response.setData(user);
//
//		} catch (Exception e) {
//			response.setStatus(500, e.getMessage());
//		}
//
//		return response;
//	}
//
//	@CrossOrigin(origins = "*")
//	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
//	public @ResponseBody Response update(@PathVariable long id, @RequestBody User user) {
//		try {
//			contatoRepository.save(user);
//			response.setData(user);
//
//		} catch (Exception e) {
//			response.setStatus(500, e.getMessage());
//		}
//
//		return response;
//	}
//
//	@CrossOrigin(origins = "*")
//	@RequestMapping(value = "", method = RequestMethod.GET)
//	public Response list() {
//		List<User> result = new ArrayList<User>();
//		Iterator<User> iterator = contatoRepository.findAll().iterator();
//
//		while (iterator.hasNext()) {
//			result.add(iterator.next());
//		}
//
//		return new Response(result, null);
//	}
//
//	@CrossOrigin(origins = "*")
//	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
//	public Response get(@PathVariable long id) {
//		user = contatoRepository.findOne(id);
//
//		return new Response(user, null);
//	}
//
//	@CrossOrigin(origins = "*")
//	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
//	public @ResponseBody Response delete(@PathVariable long id) {
//		user = contatoRepository.findOne(id);
//		try {
//			contatoRepository.delete(user);
//		} catch (Exception e) {
//			response.setStatus(500, e.getMessage());
//		}
//
//		return new Response(user, null);
//	}
//}