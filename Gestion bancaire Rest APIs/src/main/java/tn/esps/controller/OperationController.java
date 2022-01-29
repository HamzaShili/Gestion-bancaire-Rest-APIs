package tn.esps.controller;

import java.util.Date;

import org.apache.el.parser.ParseException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esps.dto.CompteDto;
import tn.esps.dto.OperationDto;
import tn.esps.dto.TypeCompteDto;
import tn.esps.entities.Compte;
import tn.esps.entities.Operation;
import tn.esps.entities.TypeCompte;
import tn.esps.service.CompteService;
import tn.esps.service.OperationServiceImp;

@RestController
@RequestMapping("/api/operation")
public class OperationController {

	private final OperationServiceImp operationService;
	private final CompteService compteService;
	private ModelMapper modelMapper;

	@Autowired
	public OperationController(OperationServiceImp operationService, CompteService compteService,
			ModelMapper modelMapper) {
		super();
		this.operationService = operationService;
		this.compteService = compteService;
		this.modelMapper = modelMapper;
	}

	@GetMapping(value = "/consulter/{rib}")
	public CompteDto consulter(@PathVariable("rib") Long rib) {
		Compte c = operationService.consulterCompte(rib);
		return convertToDtoCompte(c);
	}

	@PostMapping(value = "/verser")
	public CompteDto verser(@RequestBody OperationDto operationDto) throws ParseException {
		Operation o = convertToEntity(operationDto);
		Compte c = operationService.consulterCompte(o.getCompte().getRib());
		CompteDto c1 = convertToDtoCompte(c);
		operationService.verser(o.getCompte().getRib(), o.getMontant());

		return c1;

	}

	@PostMapping(value = "/retirer")
	public CompteDto retirer(@RequestBody OperationDto operationDto) throws ParseException {
		Operation o = convertToEntity(operationDto);
		operationService.retirer(o.getCompte().getRib(), o.getMontant());
		Compte c1 = operationService.consulterCompte(o.getCompte().getRib());
		return convertToDtoCompte(c1);

	}

	// ConvertToDtoOperation
	private OperationDto convertToDtoOperation(Operation operation) {
		OperationDto postDto = modelMapper.map(operation, OperationDto.class);
		return postDto;
	}

	// ConvertToDtoCompte
	private CompteDto convertToDtoCompte(Compte compte) {
		CompteDto compteDto = modelMapper.map(compte, CompteDto.class);
		return compteDto;
	}

	// convertToEntityCompte
	private Compte convertToCompte(CompteDto compteDto) throws ParseException {
		Compte c = modelMapper.map(compteDto, Compte.class);
		if (compteDto.getRib() != null) {
			Compte oldCompte = compteService.findById(compteDto.getRib());
			c.setClient(oldCompte.getClient());
			c.setSolde(oldCompte.getSolde());

		}

		return c;
	}

	// ConvertToEntity
	private Operation convertToEntity(OperationDto operationDto) throws ParseException {
		Operation operation = modelMapper.map(operationDto, Operation.class);

		if (operationDto.getNumOperation() != null) {
			Operation oldOperation = operationService.findById(operationDto.getNumOperation());
			operation.setMontant(oldOperation.getMontant());
			operation.setCompte(oldOperation.getCompte());
			;
		}
		return operation;
	}

}
