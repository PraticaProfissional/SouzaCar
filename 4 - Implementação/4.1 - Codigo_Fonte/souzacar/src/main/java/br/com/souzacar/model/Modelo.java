package br.com.souzacar.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Modelo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;

	public Modelo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Modelo(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

}