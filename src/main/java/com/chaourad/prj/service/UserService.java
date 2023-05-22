package com.chaourad.prj.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chaourad.prj.dao.IDao;
import com.chaourad.prj.entites.Pharmacie;
import com.chaourad.prj.entites.User;
import com.chaourad.prj.repository.PharmacieRepository;
import com.chaourad.prj.repository.UserRepository;


@Service
public class UserService implements IDao<User> {
	   @Autowired
	private UserRepository userRepository;
@Autowired
private PharmacieRepository pharmacieRepository;
	   @Override
	public User save(User o) {
		return userRepository.save(o);
	}

	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id);
	}

	@Override
	public void delete(User o) {
		userRepository.delete(o);

	} @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void updateUserRole(int userId, String role) {
        User user = userRepository.findById(userId);
                

        user.setRole(role);
        userRepository.save(user);
    }

    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    public void createUser(User user) {
        userRepository.save(user);
    }

	@Override
	public void update(User o) {
		userRepository.save(o);

	}

	@Override
	public List<User> findAll() {
		
		return userRepository.findAll();
	}

	public long count() {
		// TODO Auto-generated method stub
		return userRepository.count();
	}
	public void updateUserPharmacyId(int id, int pharmacyId) {
	    User user = userRepository.findById(id);
	    Pharmacie pharmacie = pharmacieRepository.findById(pharmacyId);

	    if (user != null && pharmacie != null) {
	        user.setPharmacy(pharmacie);
	        userRepository.save(user);
	    }
	}



	



}