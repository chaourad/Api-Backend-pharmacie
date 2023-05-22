package com.chaourad.prj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chaourad.prj.dao.IDao;
import com.chaourad.prj.entites.Pharmacie;
import com.chaourad.prj.entites.PharmacieGarde;
import com.chaourad.prj.entites.PharmacyRequest;
import com.chaourad.prj.repository.GardeRepository;
import com.chaourad.prj.repository.PharmacieGardeRepository;
import com.chaourad.prj.repository.ZoneRepository;

@Service
public class PharmacieGardeService implements IDao<PharmacieGarde>{

	@Autowired
	private PharmacieGardeRepository pharmacieGardeRepository;
	@Autowired
	private ZoneRepository zoneRepository;
	
	@Autowired
	private GardeRepository gardeRepository;
	
	@Override
	public PharmacieGarde save(PharmacieGarde o) {
		// TODO Auto-generated method stub
		return pharmacieGardeRepository.save(o);
	}

	@Override
	public PharmacieGarde findById(int id) {
		// TODO Auto-generated method stub
		return pharmacieGardeRepository.findById(id);
	}

	@Override
	public void delete(PharmacieGarde o) {
		pharmacieGardeRepository.delete(o);		
	}

	@Override
	public void update(PharmacieGarde o) {
		pharmacieGardeRepository.save(o);		
	}

	@Override
	public List<PharmacieGarde> findAll() {
		// TODO Auto-generated method stub
		return pharmacieGardeRepository.findAll();
	}

	public long count() {
		// TODO Auto-generated method stub
		return pharmacieGardeRepository.count();
	}
	/**
	 *  public List<PharmacyRequest> findPharmacieAccept(int id){
    	return pharmacyRequestRepository.findPharmacieAccept(id);
    }
    findPharmacieGardes
	 */
	
	public List<Pharmacie> findPharmacieGardes(int garde , int zoneId ){
		return pharmacieGardeRepository.findPharmacieGardes(garde, zoneId);
	}
 // Return the list of pharmacies de garde
	    
}
