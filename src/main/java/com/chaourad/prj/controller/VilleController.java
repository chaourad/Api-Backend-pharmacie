package com.chaourad.prj.controller;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chaourad.prj.entites.Pharmacie;
import com.chaourad.prj.entites.Ville;
import com.chaourad.prj.entites.Zone;
import com.chaourad.prj.repository.VilleRepository;
import com.chaourad.prj.service.VilleService;
import com.chaourad.prj.service.ZoneService;

@RestController
@RequestMapping("/api/villes")
@CrossOrigin
public class VilleController {
	@Autowired
	private VilleService villeService;
	@Autowired
	private ZoneService zoneRepository;

	@PostMapping("/save")
	public void save(@RequestBody Ville ville) {
		villeService.save(ville);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable(required = true) String id) {
		Ville s = villeService.findById(Integer.parseInt(id));
		villeService.delete(s);
	}
	@PutMapping("/{id}")
    public Ville updateCity(@PathVariable int id, @RequestBody Ville city) {
		Ville existingCity = villeService.findById(id);
        if (existingCity != null) {
            existingCity.setNom(city.getNom());
            return villeService.save(existingCity);
        }
        return null;
    }
	@GetMapping("")
	public List<Ville> findAll() {
		return villeService.findAll();
	}


	@GetMapping(value = "/count")
	public long countFiliere() {
		return villeService.count();
	}
	

	@GetMapping("/ville/{id1}/zones/{id2}")
	public Collection<Pharmacie> findByPharmacieByZone(@PathVariable String id1 , @PathVariable String id2) {
		Ville ville = villeService.findById(Integer.parseInt(id1));
		Zone zone = zoneRepository.findById(Integer.parseInt(id2));
		return zone.getPharmacies();
	}
	
	@GetMapping("/ville/{id}/zones")
	public List<Zone> findVilleZones(@PathVariable int id){
		return villeService.findVilleZones(id);
	}
}
