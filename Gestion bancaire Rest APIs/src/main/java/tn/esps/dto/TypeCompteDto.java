package tn.esps.dto;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import tn.esps.entities.Compte;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TypeCompteDto {

	private Long numTypeCompte;
	private String typeCompte;
	private Float tauxInteret;
	
	@JsonIgnore // pour casser la boucle infinie de JSON
	private List<Compte> comptes;

}
