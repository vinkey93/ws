package fr.afcepf.al34.xs.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.afcepf.al34.xs.entity.Devise;

public interface DeviseDao extends CrudRepository<Devise,String> {
	//principales méthodes héritées:
	//Devise save(Devise d)
	//Optional<Devise> findById(String codeDevise);
	//deleteById(String codeDevise);
	
	//selon conventions de noms de méthodes (pour génération automatique du SQL)
	List<Devise> findByName(String name);
	List<Devise> findByChangeGreaterThanEqual(double changeMini); // >= changeMini
	List<Devise> findByChangeLessThanEqual(double changeMaxi); // <= changeMaxi
}
