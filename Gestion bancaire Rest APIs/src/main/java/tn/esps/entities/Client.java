package tn.esps.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Include;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString

@Entity
@Table(name = "t_client")
public class Client implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Include
	@Column(length = 20)
	private String cin;
	private String nom;
	private String prenom;
	
	@OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Compte> comptes;
	
	@OneToOne
	@JoinColumn(name = "id_adresse")
	private Adresse adresse;
	
	@ManyToOne
	@JoinColumn(name = "id_agence")
	private Agence agence;

}
