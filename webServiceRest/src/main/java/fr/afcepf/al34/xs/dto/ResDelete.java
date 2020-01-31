package fr.afcepf.al34.xs.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString
// { "message" : "bien supprimé " ou bien "déjà supprimé ou inexistant" }
public class ResDelete {
	
	private String message;
	//....

	public ResDelete(String message) {
		super();
		this.message = message;
	}

    
	
}
