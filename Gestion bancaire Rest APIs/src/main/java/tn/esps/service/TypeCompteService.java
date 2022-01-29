package tn.esps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esps.dao.TypeCompteDao;
import tn.esps.entities.TypeCompte;

@Service
public class TypeCompteService {

	private final TypeCompteDao typeCompteDao;

	@Autowired
	public TypeCompteService(TypeCompteDao typeCompteDaoJpa) {
		super();
		this.typeCompteDao = typeCompteDaoJpa;
	}

	public void save(TypeCompte typeCompte) {
		typeCompteDao.saveAndFlush(typeCompte);
	}

	public List<TypeCompte> getAll() {
		return typeCompteDao.findAll();
	}

	public TypeCompte findById(Long numTypeCompte) {
		return typeCompteDao.getById(numTypeCompte);
	}

	public TypeCompte update(TypeCompte typeCompte) {
		return typeCompteDao.saveAndFlush(typeCompte);

	}

	public void remove(TypeCompte typeCompte) {
		typeCompteDao.delete(typeCompte);
	}

	public void remove(Long numTypeCompte) {
		typeCompteDao.deleteById(numTypeCompte);
	}

}
