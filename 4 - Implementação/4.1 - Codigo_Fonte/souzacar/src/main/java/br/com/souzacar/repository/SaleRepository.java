package br.com.souzacar.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.souzacar.model.Sale;

public interface SaleRepository extends CrudRepository<Sale, Long> {

}
