package com.chaourad.prj.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chaourad.prj.dao.IDao;
import com.chaourad.prj.entites.Ville;
import com.chaourad.prj.entites.Zone;
import com.chaourad.prj.repository.VilleRepository;

@Service
public class VilleService  implements IDao<Ville> {

	@Autowired
	private VilleRepository villeRepository;

	@Override
	public Ville save(Ville o) {
		return villeRepository.save(o);
	}

	@Override
	public Ville findById(int id) {
		// TODO Auto-generated method stub
		return villeRepository.findById(id);
	}

	@Override
	public void delete(Ville o) {
		villeRepository.delete(o);

	}

	@Override
	public void update(Ville o) {
		villeRepository.save(o);

	}
	

	@Override
	public List<Ville> findAll() {
		
		return villeRepository.findAll();
	}


	public long count() {
		// TODO Auto-generated method stub
		return villeRepository.count();
	}
	
	
	public List<Zone> findVilleZones(int id){
		return villeRepository.findVilleZones(id);
	}


}
