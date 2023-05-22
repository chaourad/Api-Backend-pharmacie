package com.chaourad.prj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chaourad.prj.entites.PharmacyRequest;
import com.chaourad.prj.entites.Zone;
import com.chaourad.prj.repository.PharmacyRequestRepository;

@Service
public class PharmacyRequestService {

    private final PharmacyRequestRepository pharmacyRequestRepository;

    @Autowired
    public PharmacyRequestService(PharmacyRequestRepository pharmacyRequestRepository) {
        this.pharmacyRequestRepository = pharmacyRequestRepository;
    }

    public void submitPharmacyRequest(PharmacyRequest pharmacyRequest) {
        // Définir le statut initial de la demande de pharmacie
        pharmacyRequest.setStatus("pending");

        // Enregistrer la demande de pharmacie dans la base de données
        pharmacyRequestRepository.save(pharmacyRequest);
    }

    public void updateRequestStatus(Long requestId, String status) {
        PharmacyRequest pharmacyRequest = pharmacyRequestRepository.findById(requestId)
                .orElseThrow(() -> new RuntimeException("Demande de pharmacie non trouvée"));

        pharmacyRequest.setStatus(status);
        pharmacyRequestRepository.save(pharmacyRequest);
    }
    
    
    /**
     * public List<Zone> findVilleZones(int id){
		return villeRepository.findVilleZones(id);
	}
     */
    
    public List<PharmacyRequest> findPharmacieAccept(int id){
    	return pharmacyRequestRepository.findPharmacieAccept(id);
    }
}
