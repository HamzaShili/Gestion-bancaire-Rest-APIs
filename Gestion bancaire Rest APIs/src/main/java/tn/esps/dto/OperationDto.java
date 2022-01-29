package tn.esps.dto;

import java.util.Date;

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
public class OperationDto {

	private Long numOperation;
	private Date dateOperation;
	private double montant;

	private CompteDto compte;

	public OperationDto(Date dateOperation, double montant, CompteDto compte) {
		super();
		this.dateOperation = dateOperation;
		this.montant = montant;
		this.compte = compte;
	}

	public OperationDto(double montant, CompteDto compte) {
		super();
		this.montant = montant;
		this.compte = compte;
	}

}
