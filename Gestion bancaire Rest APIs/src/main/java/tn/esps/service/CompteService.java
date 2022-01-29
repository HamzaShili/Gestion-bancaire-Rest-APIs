package tn.esps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esps.dao.CompteDao;
import tn.esps.entities.Compte;

@Service
public class CompteService {
	private CompteDao compteDao;

	@Autowired
	public CompteService(CompteDao compteDao) {
		super();
		this.compteDao = compteDao;
	}

	public void save(Compte compte) {
		compteDao.saveAndFlush(compte);
	}

	public List<Compte> getAll() {
		return compteDao.findAll();
	}

	public Compte findById(Long rib) {
		return compteDao.findById(rib).get();
	}

	public void remove(Long rib) {
		compteDao.deleteById(rib);
	}

	public void remove(Compte compte) {
		compteDao.delete(compte);
	}

	public Compte update(Compte compte) {
		return compteDao.saveAndFlush(compte);
	}

}
