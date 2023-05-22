package com.chaourad.prj.service;

import org.springframework.stereotype.Service;

import com.chaourad.prj.entites.Pharmacie;
import com.chaourad.prj.entites.User;
import com.chaourad.prj.repository.PharmacieRepository;
import com.chaourad.prj.repository.UserRepository;

@Service
public class DemandePharmacieService {
    private final UserRepository userRepository;
    private  PharmacieRepository pharmacieRepository;

    public DemandePharmacieService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void accepterDemandePharmacie(int userId, int pharmacieId) {
        User user = userRepository.findById(userId);
        Pharmacie pharmacie = pharmacieRepository.findById(pharmacieId);

        if (user != null && pharmacie != null) {
            user.setPharmacy(pharmacie); // Mettre à jour la pharmacie associée à l'utilisateur
            userRepository.save(user); // Sauvegarder les modifications dans la base de données
        }
    }
}
