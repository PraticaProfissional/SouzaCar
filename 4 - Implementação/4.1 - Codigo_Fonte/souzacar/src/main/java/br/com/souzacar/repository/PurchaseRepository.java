package br.com.souzacar.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.souzacar.model.Purchase;

public interface PurchaseRepository extends CrudRepository<Purchase, Long>{

}
