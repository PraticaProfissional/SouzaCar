package br.com.souzacar.model;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public abstract class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;
	protected Calendar dueDate;
	protected Calendar payDate;
	protected BigDecimal amount;
	protected String formOfPayment;
	protected String description;
}
