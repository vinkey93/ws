package fr.afcepf.al34.xs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.afcepf.al34.xs.dao.DeviseDao;
import fr.afcepf.al34.xs.entity.Devise;
import fr.afcepf.al34.xs.exception.MyEntityNotFoundException;

@Service
@Transactional
public class DeviseServiceImpl implements DeviseService {
	
	@Autowired
	private DeviseDao deviseDao;

	@Override
	public Devise rechercherDeviseParCode(String code) {
		return deviseDao.findById(code).orElse(null);
	}
	@Override
	public List<Devise> rechercherDeviseParChangeMini(Double change) {
		return deviseDao.findByChangeGreaterThanEqual(change);
	}
	@Override
	public Devise sauvegarderDevise(Devise d) {
		return deviseDao.save(d);
	}
	@Override
	public void supprimerDevise(String code) throws MyEntityNotFoundException {
		try {
			deviseDao.deleteById(code);
		} catch (Exception e) {
			//e.printStackTrace();
			//logger.error("...." , e);
			throw new MyEntityNotFoundException("echec suppression Devise avec code="+code,e);
		}
	}
	@Override
	public List<Devise> rechercherToutesDevises() {
		return (List<Devise>) deviseDao.findAll();
	}

}
