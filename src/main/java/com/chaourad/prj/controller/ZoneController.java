package com.chaourad.prj.controller;

import java.util.List;

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

import com.chaourad.prj.entites.Zone;
import com.chaourad.prj.service.ZoneService;

@RestController
@RequestMapping("/api/zone")
@CrossOrigin
public class ZoneController {
	@Autowired
	private ZoneService zoneService;

	
	@PostMapping("/save")
	public void savee (@RequestBody Zone zone) {
		  zoneService.savee(zone);
	}


	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable(required = true) String id) {
		Zone s = zoneService.findById(Integer.parseInt(id));
		zoneService.delete(s);
	}
	
	@PutMapping("/{id}")
	public Zone updateZone(@PathVariable int id, @RequestBody Zone zone) {
		zone.setId(id);
		return zoneService.save(zone);
	}

	@GetMapping("")
	public List<Zone> findAll() {
		return zoneService.findAll();
	}
	

	@GetMapping("/count")
	public long countFiliere() {
		return zoneService.count();
	}
	

}
