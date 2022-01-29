package tn.esps.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.el.parser.ParseException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esps.dto.TypeCompteDto;
import tn.esps.entities.TypeCompte;
import tn.esps.service.TypeCompteService;

@RestController
@RequestMapping("/api/typeCompte")
public class TypeCompteController {

	private final TypeCompteService typeCompteService;
	private ModelMapper modelMapper;

	@Autowired
	public TypeCompteController(TypeCompteService typeCompteService, ModelMapper modelMapper) {
		super();
		this.typeCompteService = typeCompteService;
		this.modelMapper = modelMapper;
	}

	@GetMapping("/all")
	/*
	 * public ResponseEntity<List<TypeCompte>> getAllTypes() { List<TypeCompte>
	 * listType = typeCompteService.getAll(); return new ResponseEntity<>(listType,
	 * HttpStatus.OK);
	 * 
	 * }
	 */
	public List<TypeCompteDto> getAllTypes() {
		List<TypeCompte> listType = typeCompteService.getAll();
		return listType.stream().map(type -> convertToDto(type)).collect(Collectors.toList());

	}

	@PostMapping("/add")
	public ResponseEntity<TypeCompteDto> save(@RequestBody TypeCompteDto typeCompteDto) {

		try {
			TypeCompte typeCompte = convertToEntity(typeCompteDto);
			typeCompteService.save(typeCompte);
			return new ResponseEntity<>(convertToDto(typeCompte), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// ConvertToDto
	private TypeCompteDto convertToDto(TypeCompte typeCompte) {
		TypeCompteDto postDto = modelMapper.map(typeCompte, TypeCompteDto.class);
		return postDto;
	}

	// ConvertToEntity
	private TypeCompte convertToEntity(TypeCompteDto typeCompteDto) throws ParseException {
		TypeCompte typeCompte = modelMapper.map(typeCompteDto, TypeCompte.class);

		if (typeCompteDto.getNumTypeCompte() != null) {
			TypeCompte oldType = typeCompteService.findById(typeCompteDto.getNumTypeCompte());
			typeCompte.setTauxInteret(oldType.getTauxInteret());
			typeCompte.setTypeCompte(oldType.getTypeCompte());
			;
		}
		return typeCompte;
	}

}
