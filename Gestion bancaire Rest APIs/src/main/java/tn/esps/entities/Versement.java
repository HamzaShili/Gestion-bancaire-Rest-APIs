package tn.esps.entities;

import java.util.Date;

import javax.persistence.Entity;


@Entity
public class Versement extends Operation {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Versement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Versement(Date dateOperation, double montant, Compte compte) {
		super(dateOperation, montant, compte);
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
