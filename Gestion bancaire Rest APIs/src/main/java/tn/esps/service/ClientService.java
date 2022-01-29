package tn.esps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esps.dao.ClientDao;
import tn.esps.entities.Client;

@Service
public class ClientService {

	private ClientDao clientDao;

	@Autowired
	public ClientService(ClientDao clientDao) {
		super();
		this.clientDao = clientDao;
	}

	public void save(Client client) {
		clientDao.saveAndFlush(client);
	}

	public List<Client> getAll() {
		return clientDao.findAll();
	}

	public Client getById(String cin) {
		return clientDao.findById(cin).get();
	}

	public Client update(Client client) {
		return clientDao.saveAndFlush(client);
	}

	public void delete(Client client) {
		clientDao.delete(client);
	}

	public void deleteByCin(String cin) {
		clientDao.deleteById(cin);
	}
}
