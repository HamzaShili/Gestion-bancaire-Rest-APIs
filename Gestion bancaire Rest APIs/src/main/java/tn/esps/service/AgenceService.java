package tn.esps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esps.dao.AgenceDao;
import tn.esps.entities.Agence;

@Service
public class AgenceService {

	private AgenceDao agenceDao;

	@Autowired
	public AgenceService(AgenceDao agenceDao) {
		super();
		this.agenceDao = agenceDao;
	}

	public List<Agence> getAll() {
		return agenceDao.findAll();
	}

	public void save(Agence agence) {
		agenceDao.save(agence);
	}

	public Agence getById(Long id) {
		return agenceDao.getById(id);
	}

	public void update(Agence agence) {
		agenceDao.saveAndFlush(agence);
	}

	public void removeById(Long id) {
		agenceDao.deleteById(id);
	}

	public void remove(Agence agence) {
		agenceDao.delete(agence);
	}

}
