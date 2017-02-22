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
public class Sale {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nameClient;
	private Calendar releaseDate;
	private BigDecimal amount;
	private String description;
	
	private Part part;
}