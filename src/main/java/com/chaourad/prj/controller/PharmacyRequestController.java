package com.chaourad.prj.controller;

import java.util.ArrayList;
import java.util.List;

import com.chaourad.prj.entites.Pharmacie;
import com.chaourad.prj.entites.PharmacyRequest;
import com.chaourad.prj.entites.User;
import com.chaourad.prj.entites.Zone;
import com.chaourad.prj.repository.PharmacieRepository;
import com.chaourad.prj.repository.PharmacyRequestRepository;
import com.chaourad.prj.service.PharmacyRequestService;
import com.chaourad.prj.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
;
@CrossOrigin
@RestController
@RequestMapping("/api/pharmacy-requests")
public class PharmacyRequestController {
    private final PharmacyRequestRepository pharmacyRequestRepository;
    private final PharmacyRequestService pharmacyRequestService;
    private final PharmacieRepository pharmacieRepository;
    private final UserService userService;


    @Autowired
    public PharmacyRequestController(PharmacyRequestRepository pharmacyRequestRepository,
                                     PharmacyRequestService pharmacyRequestService,
                                     PharmacieRepository pharmacieRepository,
                                     UserService userService) {
        this.pharmacyRequestRepository = pharmacyRequestRepository;
        this.pharmacyRequestService = pharmacyRequestService;
        this.pharmacieRepository = pharmacieRepository;
        this.userService = userService; // Ajoutez cette ligne
    }

    @PostMapping
    public PharmacyRequest createPharmacyRequest(@RequestBody PharmacyRequest pharmacyRequest) {
        pharmacyRequest.setStatus("En attente");
        return pharmacyRequestRepository.save(pharmacyRequest);
    }

    @GetMapping
    public List<PharmacyRequest> getPendingPharmacyRequests() {
        return pharmacyRequestRepository.findByStatus("En attente");
    }

    @PutMapping("/{id}/approve")
    public PharmacyRequest approvePharmacyRequest(@PathVariable Long id) {
        PharmacyRequest pharmacyRequest = pharmacyRequestRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Demande de pharmacie non trouvée"));

        pharmacyRequestService.updateRequestStatus(id, "accepté");

        // Créez la pharmacie correspondante
        Pharmacie pharmacie = new Pharmacie();
        pharmacie.setNom(pharmacyRequest.getNom());
        pharmacie.setAdresse(pharmacyRequest.getAdresse());
        pharmacie.setLaltitude(pharmacyRequest.getLaltitude());
        pharmacie.setLongitude(pharmacyRequest.getLongitude());
        pharmacie.setZone(pharmacyRequest.getZone());

        pharmacieRepository.save(pharmacie);

        // Mettre à jour le rôle de l'utilisateur et l'ID de pharmacie associé
        int userId = pharmacyRequest.getUser().getId();
        userService.updateUserRole(userId, "pharmacien");
        userService.updateUserPharmacyId(userId, pharmacie.getId());

        return pharmacyRequest;
    }



    @PutMapping("/{id}/reject")
    public PharmacyRequest rejectPharmacyRequest(@PathVariable Long id) {
        PharmacyRequest pharmacyRequest = pharmacyRequestRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Demande de pharmacie non trouvée"));

        pharmacyRequestService.updateRequestStatus(id, "refusé");

        return pharmacyRequest;
    }
    @GetMapping("/accepted")
    public List<Pharmacie> getAcceptedPharmacies() {
        List<Pharmacie> acceptedPharmacies = new ArrayList<>();
        List<PharmacyRequest> pharmacyRequests = pharmacyRequestRepository.findByStatus("accepté");
        
        for (PharmacyRequest pharmacyRequest : pharmacyRequests) {
            User user = pharmacyRequest.getUser();
            if (user != null && user.getRole().equals("pharmacien")) {
            	Pharmacie pharmacy = new Pharmacie();
                pharmacy.setNom(pharmacyRequest.getNom());
                pharmacy.setAdresse(pharmacyRequest.getAdresse());
                pharmacy.setLaltitude(pharmacyRequest.getLaltitude());
                pharmacy.setLongitude(pharmacyRequest.getLongitude());
		pharmacy.setImage(pharmacyRequest.getImage());
                pharmacy.setZone(pharmacyRequest.getZone());
                acceptedPharmacies.add(pharmacy);
            }
        }
        
        return acceptedPharmacies;
    }

  
    @GetMapping("/rejected")
    public List<PharmacyRequest> getRejectedPharmacyRequests() {
        return pharmacyRequestRepository.findByStatus("refusé");
    }
/**
 * @GetMapping("/ville/{id}/zones")
	public List<Zone> findVilleZones(@PathVariable int id){
		return villeService.findVilleZones(id);
	}
 */
    
    @GetMapping("/zone/{id}/pharmacy")
    public List<PharmacyRequest> findPharmacieAccept(@PathVariable int id){
    	return pharmacyRequestRepository.findPharmacieAccept(id);
    }
}


