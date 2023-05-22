package com.chaourad.prj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chaourad.prj.entites.Pharmacie;
import com.chaourad.prj.repository.PharmacieRepository;

@RestController
@CrossOrigin
@RequestMapping("/api/pharmacies")
public class PharmacyController {

    @Autowired
    private PharmacieRepository pharmacyRepository;

    @GetMapping
    public ResponseEntity<List<Pharmacie>> getAllPharmacies() {
        List<Pharmacie> pharmacies = pharmacyRepository.findAll();
        return ResponseEntity.ok(pharmacies);
    }

    @GetMapping("/{zoneId}/pharmacy")
    public ResponseEntity<List<Pharmacie>> getPharmaciesByZone(@PathVariable int zoneId) {
        List<Pharmacie> pharmacies = pharmacyRepository.findByZoneId(zoneId);
        return ResponseEntity.ok(pharmacies);
    }


    // Autres méthodes du contrôleur pour les opérations CRUD sur les pharmacies
}
