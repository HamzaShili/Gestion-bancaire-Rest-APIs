package tn.esps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esps.dao.AdresseDao;
import tn.esps.entities.Adresse;

@Service
public class AdresseService {

	private AdresseDao adresseDao;

	@Autowired
	public AdresseService(AdresseDao adresseDao) {
		super();
		this.adresseDao = adresseDao;
	}

	public List<Adresse> getAll() {
		return adresseDao.findAll();
	}

	public void save(Adresse adresse) {
		adresseDao.saveAndFlush(adresse);
	}

	public Adresse getByNum(Long id) {
		return adresseDao.getById(id);
	}

	public void update(Adresse adresse) {
		adresseDao.saveAndFlush(adresse);
	}

	public void remove(Adresse adresse) {
		adresseDao.delete(adresse);
	}

	public void removeById(Long id) {
		adresseDao.deleteById(id);
	}

}
