package br.com.souzacar.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.souzacar.model.PayAccount;

public interface PayAccountReposutory extends CrudRepository<PayAccount, Long>{

}
