package tn.esps.service;

import java.util.List;


import tn.esps.entities.Compte;
import tn.esps.entities.Operation;

public interface OperationService {
	public Compte consulterCompte(Long rib);

	public void verser(Long rib, double montant);

	public void retirer(Long rib, double montant);

	public void virement(Long rib, Long rib1, double montant);

	public List<Operation> listOperation(Long rib, int page, int size);

}
