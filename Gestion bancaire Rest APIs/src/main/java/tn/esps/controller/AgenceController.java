package tn.esps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esps.entities.Agence;
import tn.esps.service.AgenceService;

@RestController
@RequestMapping("/api/agence")
public class AgenceController {

	private final AgenceService agenceService;

	@Autowired
	public AgenceController(AgenceService agenceService) {
		super();
		this.agenceService = agenceService;
	}

	@GetMapping("/all")
	public List<Agence> getAll() {
		return agenceService.getAll();
	}

	@PostMapping("/add")
	public void add(@RequestBody Agence agence) {
		agenceService.save(agence);
	}

	@GetMapping("/{id}")
	public Agence getById(@PathVariable("id") Long id) {
		return agenceService.getById(id);
	}

}
