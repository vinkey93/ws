package fr.afcepf.al34.xs.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.afcepf.al34.xs.dto.ResDelete;
import fr.afcepf.al34.xs.service.DeviseService;

@RestController
@RequestMapping(value="/devise" , headers="Accept=application/json")
public class DeviseRestPrivateCtrl {
	
	@Autowired
	private DeviseService deviseService;
	
	// version avec IDEMPOTENCE (retour toujours au même format et regulier si plusieurs appels de suite)
		//en mode DELETE, url=http://localhost:8383/springBootWs/devise-api/private/devise/JPY
		//à tester via PostMan ou un équivalent
		@DeleteMapping(value="/{codeDevise}")
		public ResponseEntity<ResDelete> deleteDeviseByCode(@PathVariable("codeDevise")  String code){
				try {
					deviseService.supprimerDevise(code);
					return new ResponseEntity<ResDelete>( new ResDelete("suppression bien effectuee") , 
							                           HttpStatus.OK); 
				} catch (Exception e) {
					e.printStackTrace();
					return new ResponseEntity<ResDelete>(new ResDelete("devise déjà supprimée ou inexistante"),
							                    HttpStatus.OK);
					
				}
			}

}
