package com.chaourad.prj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chaourad.prj.entites.Pharmacie;
import com.chaourad.prj.entites.PharmacieGarde;
import com.chaourad.prj.entites.PharmacyRequest;
import com.chaourad.prj.service.GardeService;
import com.chaourad.prj.service.PharmacieGardeService;
import com.chaourad.prj.service.VilleService;
import com.chaourad.prj.service.ZoneService;

@RestController
@CrossOrigin
@RequestMapping("/api/pharmacie-garde")
public class GardePharmacieController {
	@Autowired
	private PharmacieGardeService gerdeRepository;
	@Autowired
	private VilleService villeService;
	@Autowired
	private ZoneService zoneRepository;
	@Autowired 
	private GardeService gardeService;
	
	@PostMapping("/save")
	public void save(@RequestBody PharmacieGarde gardePharmacie) {
		gerdeRepository.save(gardePharmacie);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable(required = true) String id) {
		PharmacieGarde s = gerdeRepository.findById(Integer.parseInt(id));
		gerdeRepository.delete(s);
	}

	@GetMapping("")
	public List<PharmacieGarde> findAll() {
		return gerdeRepository.findAll();
	}

	@GetMapping(value = "/count")
	public long countFiliere() {
		return gerdeRepository.count();
	}	
	/**
	 *  @GetMapping("/zone/{id}/pharmacy")
    public List<PharmacyRequest> findPharmacieAccept(@PathVariable int id){
    	return pharmacyRequestRepository.findPharmacieAccept(id);
    }
	 */	



	 
}
