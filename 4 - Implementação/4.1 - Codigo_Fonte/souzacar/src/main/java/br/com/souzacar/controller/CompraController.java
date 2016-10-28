package br.com.souzacar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.souzacar.model.Compra;
import br.com.souzacar.repository.CompraRepository;
import br.com.souzacar.utlis.Response;

@RestController
@RequestMapping("/compra")
public class CompraController {
	
	@Autowired
	private CompraRepository compraRepository;
	@Autowired
	private Response response;
	@Autowired
	private Compra compra;
}