package tn.esps.dto;

import java.util.List;

import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CompteDto {

	
	private Long rib;
	private double solde;

	private TypeCompteDto type;

	private ClientDto client;
	
	@JsonIgnore
	private List<OperationDto> operations;

}
