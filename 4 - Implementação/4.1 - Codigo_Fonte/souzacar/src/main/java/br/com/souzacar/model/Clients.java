package br.com.souzacar.model;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Client extends Person{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String phone;
	private String cellPhone;
	private String eMail;
	private String address;
	private String typePerson;
	private String cpfCnpj;
	private String rgInscricaoEstadual;
	private String contact;
	private Calendar dateRegiter;
	private Calendar updateDate;
	private boolean isActive;

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
}