package com.chaourad.prj.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chaourad.prj.dao.IDao;
import com.chaourad.prj.entites.Zone;
import com.chaourad.prj.repository.ZoneRepository;


@Service
public class ZoneService  implements IDao<Zone> {
	@Autowired
	private ZoneRepository zoneRepository;

	@Override
	public Zone save(Zone o) {
		return	zoneRepository.save(o);
	}
	
	public void savee(Zone o) {
			zoneRepository.save(o);
	}
	@Override
	public Zone findById(int id) {
		return zoneRepository.findById(id);
	}

	@Override
	public void delete(Zone o) {
		zoneRepository.delete(o);

	}

    public Zone updateZone(int id, Zone zoneDetails) {
		Zone zone = zoneRepository.findById(id);
			
		zone.setNom(zoneDetails.getNom());
		zone.setVille(zoneDetails.getVille());
		return zoneRepository.save(zone);
	}

	@Override
	public void update(Zone o) {
		zoneRepository.save(o);

	}

	@Override
	public List<Zone> findAll() {
		
		return zoneRepository.findAll();
	}

	public long count() {
		// TODO Auto-generated method stub
		return zoneRepository.count();
	}
	
	

	

}
