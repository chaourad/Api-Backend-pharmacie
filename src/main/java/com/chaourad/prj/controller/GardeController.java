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

import com.chaourad.prj.entites.Garde;
import com.chaourad.prj.service.GardeService;



@RestController
@RequestMapping("/api/garde")
@CrossOrigin
public class GardeController{

	@Autowired
	private GardeService garderepository;

	@PostMapping("/save")
	public void save(@RequestBody Garde role) {
		garderepository.save(role);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable String id) {
		Garde s = garderepository.findById(Integer.parseInt(id));
		garderepository.delete(s);
	}
	@PutMapping("/{id}")
    public Garde updateGarde(@PathVariable int id, @RequestBody Garde garde) {
		Garde existingCity = garderepository.findById(id);
        if (existingCity != null) {
            existingCity.setType(garde.getType());
            return garderepository.save(existingCity);
        }
        return null;
    }

	@GetMapping("/all")
	public List<Garde> findAll() {
		return garderepository.findAll();
	}

	@GetMapping(value = "/count")
	public long countFiliere() {
		return garderepository.count();
	}
	
}
