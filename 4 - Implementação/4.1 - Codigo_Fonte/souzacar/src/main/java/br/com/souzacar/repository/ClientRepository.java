package br.com.souzacar.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.souzacar.model.Client;


public interface ClientRepository extends CrudRepository<Client, Long> {

}
