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
public class AgenceDto {

	private Long numAgence;
	private String libelle;
	private String horaires;

	private AdresseDto adresse;

	@JsonIgnore
	private List<ClientDto> clients;

}
