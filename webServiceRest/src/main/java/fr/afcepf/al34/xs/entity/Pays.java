package fr.afcepf.al34.xs.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
public class Pays {
	
	@Id
	private String code; //"fr" , "de" , "it"
	private String nom; // "France"
	private String capitale; // "Paris"

	@ManyToOne
	@JoinColumn(name="codeDevise")
	//@JsonIgnore
	private Devise devise;

	public Pays(String code, String nom, String capitale) {
		super();
		this.code = code;
		this.nom = nom;
		this.capitale = capitale;
	}
	
	

}
