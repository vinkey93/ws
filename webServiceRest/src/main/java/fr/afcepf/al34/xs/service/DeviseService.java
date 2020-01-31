package fr.afcepf.al34.xs.service;

import java.util.List;

import fr.afcepf.al34.xs.entity.Devise;
import fr.afcepf.al34.xs.exception.MyEntityNotFoundException;

public interface DeviseService {
	
	Devise rechercherDeviseParCode(String code);
	List<Devise> rechercherDeviseParChangeMini(Double change);
	
	Devise sauvegarderDevise(Devise d);
	void supprimerDevise(String code) throws MyEntityNotFoundException;
    //...
	List<Devise> rechercherToutesDevises();
}
