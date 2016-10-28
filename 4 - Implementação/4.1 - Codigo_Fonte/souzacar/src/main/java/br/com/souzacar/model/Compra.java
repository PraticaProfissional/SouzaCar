package br.com.souzacar.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Compra {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
}
