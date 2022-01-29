package tn.esps.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.EqualsAndHashCode.Exclude;
import lombok.EqualsAndHashCode.Include;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString

@Entity
public class TypeCompte implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) /* Auto-increment */
	@Include
	private Long numTypeCompte;
	private String typeCompte;
	private Float tauxInteret;

	@OneToMany(mappedBy = "type", fetch = FetchType.LAZY) // default fetch = LAZY (ne se charge pas par défaut)
	//@Exclude // pour casser la boucle infinie de toString
	@JsonIgnore // pour casser la boucle infinie de JSON
	private List<Compte> comptes;

	public TypeCompte(String typeCompte, Float tauxInteret) {
		super();
		this.typeCompte = typeCompte;
		this.tauxInteret = tauxInteret;
	}

}
