package fr.afcepf.al34.xs.init;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

//import fr.afcepf.al34.xs.dao.PaysDao;
import fr.afcepf.al34.xs.entity.Devise;
import fr.afcepf.al34.xs.entity.Pays;
import fr.afcepf.al34.xs.service.DeviseService;

@Profile("initData")//en développement seulement , pas en production 
@Component
public class InitDataSet {
	
	@Autowired
	private DeviseService deviseService;
	
//	@Autowired
//	private PaysDao paysDao;
	
	@PostConstruct()
	public void initData() {
		Devise euro = deviseService.sauvegarderDevise(new Devise("EUR","euro",0.9));
		Pays france = new Pays("fr","France","Paris");
		//france.setDevise(euro);		paysDao.save(france);
		Pays allemagne = new Pays("de","Allemagne","Berlin");
		//allemagne.setDevise(euro);		paysDao.save(allemagne);
		
		deviseService.sauvegarderDevise(new Devise("USD","dollar",1.0));
		deviseService.sauvegarderDevise(new Devise("GBP","livre",0.8));
		deviseService.sauvegarderDevise(new Devise("JPY","yen",120.0));
	}

}
