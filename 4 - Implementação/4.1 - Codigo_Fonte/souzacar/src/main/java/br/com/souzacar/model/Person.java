package br.com.souzacar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public abstract class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;
	protected String name;
	protected String telefone;
	protected String celular;
	protected String email;
	protected String logradouro;
	protected int numero;
	protected String bairro;
	protected String complemento;
	protected String cep;
	@Column( unique=true )
	protected String cpfCnpj;
	protected String documento;
	protected String contato;
	protected String dataCadastro;
	protected String dataAtualizacao;
	
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Person(Long id, String name, String telefone, String celular, String email, String logradouro, int numero,
			String bairro, String complemento, String cep, String cpfCnpj, String documento, String contato,
			String dataCadastro, String dataAtualizacao) {
		super();
		this.id = id;
		this.name = name;
		this.telefone = telefone;
		this.celular = celular;
		this.email = email;
		this.logradouro = logradouro;
		this.numero = numero;
		this.bairro = bairro;
		this.complemento = complemento;
		this.cep = cep;
		this.cpfCnpj = cpfCnpj;
		this.documento = documento;
		this.contato = contato;
		this.dataCadastro = dataCadastro;
		this.dataAtualizacao = dataAtualizacao;
	}	
}