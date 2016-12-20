package br.com.souzacar.model;

import javax.persistence.Entity;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Client extends Person{

	private boolean isActive;

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
}