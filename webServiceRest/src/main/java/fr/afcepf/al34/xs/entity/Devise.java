package fr.afcepf.al34.xs.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @NoArgsConstructor @ToString()
public class Devise {
	@Id
	private String code; // "EUR" , "USD" , "JPY" , "GBP"
	private String name; // "euro" , "dollar" , "yen" , "livre"
	
	@Column(name="d_change")
	@Min(value=0 , message="change mini=0")
	private Double change; // nb ... pour un dollar

	@OneToMany(mappedBy = "devise")
	@JsonIgnore
	private List<Pays> pays;
	
	public Devise(String code, String name, Double change) {
		super();
		this.code = code;
		this.name = name;
		this.change = change;
	}

}
