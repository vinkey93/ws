package fr.afcepf.al34.xs.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.afcepf.al34.xs.entity.Devise;
import fr.afcepf.al34.xs.service.DeviseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/devise" , headers="Accept=application/json")
@Api(tags = { "My REST Devise api (public part)" })
@CrossOrigin("*") //"*" ou "www.ami1.com" , "www.ami2.com"
public class DeviseRestCtrl {
	
	@Autowired
	private DeviseService deviseService;
	
	//url complete : http://localhost:8080/springBootWs/devise-api/public/devise/EUR
	//@RequestMapping(value="/{codeDevise}" , method=RequestMethod.GET)
	/**
	 * rechercher une devise via son code
	 * @param code code d'une devise (ex: "EUR" , "USD" , ...)
	 * @return Devise recherchée
	 */
	@ApiOperation(value = "getDeviseByCode 2 Le retour")
	@GetMapping(value="/{codeDevise}")
	public Devise getDeviseByCode(@PathVariable("codeDevise")  String code){
		return deviseService.rechercherDeviseParCode(code);
	}
	//url complete : http://localhost:8080/springBootWs/devise-api/public/devise
	//http://localhost:8080/springBootWs/devise-api/public/devise?changeMini=0.95
	@GetMapping(value="/liste")
	public List<Devise> getDevisesByCriteria(
			@RequestParam(value="changeMini",required=false) Double changeMini){
		if(changeMini!=null)
			return deviseService.rechercherDeviseParChangeMini(changeMini);
		else
			return deviseService.rechercherToutesDevises();
	}
	//http://localhost:8080/springBootWs/devise-api/public/devise appelé en mode POST
	//avec { "code" : "SIN" , "name":"monnaieSinge" , "change" :9999 }
	//dans la partie "body" (invisible) de la requête entrante HTTP
	//à tester via le logiciel PostMan ou un equivalent
	@PostMapping(value="")
	public Devise postDevise(@Valid @RequestBody Devise devise) {
		return deviseService.sauvegarderDevise(devise);
	}
	/*
	// Version techniquement correcte (au sens HTTP) MAIS SANS IDEMPOTENCE 
	//en mode DELETE, url=http://localhost:8080/springBootWs/devise-api/public/devise/JPY
	@DeleteMapping(value="/{codeDevise}")
	public void deleteDeviseByCode(@PathVariable("codeDevise")  String code)
	     throws MyEntityNotFoundException{
		     deviseService.supprimerDevise(code); //renvoi code 404 en cas d'erreur
		     //car annotation @ResponseStatus(HttpStatus.NOT_FOUND) au dessus de 
		     //la classe MyEntityNotFoundException
	}*/
	
	
	/*
	//en mode DELETE, url=http://localhost:8080/springBootWs/devise-api/public/devise/JPY
	//à tester via PostMan ou un équivalent
	@DeleteMapping(value="/{codeDevise}")
	public ResponseEntity<?> deleteDeviseByCode(@PathVariable("codeDevise")  String code){
		try {
			deviseService.supprimerDevise(code);
			return new ResponseEntity<String>("suppression bien effectuee" , HttpStatus.OK); //suppression bien effectuée
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);//pas trouvé ce qu'il fallait supprimer
			//return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); //erreur quelconque
		}
	}
	*/
	
	
}
