package tn.esps.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class ClientDto {

	private String cin;
	private String nom;
	private String prenom;

	@JsonIgnore
	private List<CompteDto> comptes;

	private AdresseDto adresse;

	private AgenceDto agence;

}
