package br.com.souzacar.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.souzacar.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long>{

}
