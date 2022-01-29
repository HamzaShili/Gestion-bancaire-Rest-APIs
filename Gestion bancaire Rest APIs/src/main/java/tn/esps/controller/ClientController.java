package tn.esps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esps.entities.Client;
import tn.esps.service.ClientService;

@RestController
@RequestMapping("/api/client")
public class ClientController {

	private final ClientService clientService;

	@Autowired
	public ClientController(ClientService clientService) {
		super();
		this.clientService = clientService;
	}

	@GetMapping("/all")
	public List<Client> getAll() {
		return clientService.getAll();
	}

	@PostMapping("/add")
	public void add(@RequestBody Client client) {
		clientService.save(client);
	}

}
