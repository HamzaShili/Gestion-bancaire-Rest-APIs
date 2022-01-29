package tn.esps.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import tn.esps.entities.Compte;
import tn.esps.service.CompteService;

@RestController
@RequestMapping("/api/compte")
public class CompteController {

	private final CompteService compteService;

	@Autowired
	public CompteController(CompteService compteService) {
		super();
		this.compteService = compteService;
	}

	@GetMapping("/all")
	public Iterable<Compte> getAllTypes() {
		List<Compte> listType = compteService.getAll();
		return listType;

	}

	@PostMapping("/add")
	public ResponseEntity<Compte> save(@RequestBody Compte c) throws ParseException {
		try {
			compteService.save(c);
			return new ResponseEntity<>(c, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(value = "/{rib}")
	public Compte findById(@PathVariable("rib") Long rib) {
		return compteService.findById(rib);
	}

	@PutMapping("/{rib}")
	public void update(@PathVariable("rib") Long rib, @RequestBody Compte compte) {
		Compte _compte = compteService.findById(rib);
		_compte.setSolde(compte.getSolde());
		compteService.update(_compte);

	}

	@DeleteMapping("/{rib}")
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable("rib") Long rib) {
		compteService.remove(rib);
	}

}
