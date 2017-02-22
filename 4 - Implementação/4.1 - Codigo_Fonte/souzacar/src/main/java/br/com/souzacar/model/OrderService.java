package br.com.souzacar.model;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class OrderService {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nameClient;
	private Calendar releaseDate;
	private String description;
	
	private Vehicle vehicle;
	private Part part;
}
