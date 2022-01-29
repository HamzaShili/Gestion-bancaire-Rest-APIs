package tn.esps.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import tn.esps.dao.CompteDao;
import tn.esps.dao.OperationDao;
import tn.esps.entities.Compte;
import tn.esps.entities.Operation;
import tn.esps.entities.Retrait;
import tn.esps.entities.Versement;

@Service
public class OperationServiceImp implements OperationService {

	private CompteDao compteDao;
	private OperationDao operationDao;

	@Autowired
	public OperationServiceImp(CompteDao compteDao, OperationDao operationDao) {
		super();
		this.compteDao = compteDao;
		this.operationDao = operationDao;
	}

	@Override
	public Compte consulterCompte(Long rib) {
		return compteDao.getById(rib);
	}

	@Override
	public void verser(Long rib, double montant) {
		Compte c = consulterCompte(rib);
		Versement v = new Versement(new Date(), montant, c);
		operationDao.save(v);
		c.setSolde(c.getSolde() + montant);
		compteDao.save(c);

	}

	@Override
	public void retirer(Long rib, double montant) {
		Compte c = consulterCompte(rib);
		double interet = c.getType().getTauxInteret();
		if (c.getSolde() + interet < montant)
			throw new RuntimeException("Votre sold est insuffisant");
		Retrait r = new Retrait(new Date(), montant, c);
		operationDao.save(r);
		c.setSolde(c.getSolde() - montant);
		compteDao.save(c);

	}

	@Override
	public void virement(Long rib1, Long rib2, double montant) {
		if (rib1.equals(rib2))
			throw new RuntimeException("Virement impossible");
		Compte c = consulterCompte(rib2);
		if (c == null)
			new RuntimeException("Le compte " + rib2 + " n'est pas disponible");

		retirer(rib1, montant);
		verser(rib2, montant);

	}

	@Override
	public List<Operation> listOperation(Long rib, int page, int size) {

		return operationDao.findAllByRib(rib, PageRequest.of(page, size));
	}

	public Operation findById(Long numOperation) {

		return operationDao.getById(numOperation);
	}

}
