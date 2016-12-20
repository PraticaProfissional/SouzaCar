package br.com.souzacar.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.souzacar.model.Model;

public interface ModelRepository extends CrudRepository<Model, Long>{

}
