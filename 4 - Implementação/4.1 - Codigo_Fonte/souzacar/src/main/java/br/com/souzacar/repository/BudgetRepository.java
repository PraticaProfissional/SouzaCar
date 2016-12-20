package br.com.souzacar.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.souzacar.model.Budget;

public interface BudgetRepository extends CrudRepository<Budget, Long>{

}
