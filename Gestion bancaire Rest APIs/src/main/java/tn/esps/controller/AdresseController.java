package tn.esps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esps.entities.Adresse;
import tn.esps.service.AdresseService;

@RestController
@RequestMapping("/api/adresse")
public class AdresseController {

	private AdresseService adresseService;

	@Autowired
	public AdresseController(AdresseService adresseService) {
		super();
		this.adresseService = adresseService;
	}

	@GetMapping("/all")
	public List<Adresse> getAll() {
		return adresseService.getAll();
	}

	@PostMapping("/add")
	public void add(@RequestBody Adresse adresse) {
		adresseService.save(adresse);
	}

}
