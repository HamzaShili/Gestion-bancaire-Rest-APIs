package tn.esps.dto;


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
public class AdresseDto {

	private Long numAdress;
	private String ville;
	private String quartier;
	private String rue;
	private String telephone;
	private int codePostal;
	private String email;

	@JsonIgnore
	private ClientDto client;

	@JsonIgnore
	private AgenceDto agence;

}
