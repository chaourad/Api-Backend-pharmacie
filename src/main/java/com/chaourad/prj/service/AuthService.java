package com.chaourad.prj.service;

import com.chaourad.prj.entites.User;
import com.chaourad.prj.repository.UserRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;

   /* public User authenticate(String email, String password) {
       List<User> users = userRepository.findAll();
       for(User user : users) {
    	   if(user.getEmail().equals(email)) {
    		   return user;
    	   }
       }
  return null;
    }*/
    public User authenticate(String email, String password) {
        User user = userRepository.findByEmail(email);
        
        if (user != null) {
            if (user.getRole().equals("client") || user.getRole().equals("pharmacien") || user.getRole().equals("admin")) {
                // Vérification du mot de passe
                if (user.getPassword().equals(password)) {
                  
                    return user;
                } else {
              
                }
            } else {
               
            }
        }
        
        return null;
    }


	public User getAdminUser(String email) {
		 // Récupérer l'utilisateur administrateur en fonction de l'e-mail
        User admin = userRepository.findByEmailAndRole(email, "admin");

        if (admin == null) {
            // Gérer le cas où l'administrateur n'est pas trouvé
            // Lancez une exception appropriée ou retournez null, selon vos besoins
        }

        return admin;
	}

}
