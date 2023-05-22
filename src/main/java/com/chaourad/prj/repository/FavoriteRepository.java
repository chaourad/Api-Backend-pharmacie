package com.chaourad.prj.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.chaourad.prj.entites.Favorite;
import com.chaourad.prj.entites.Pharmacie;
import com.chaourad.prj.entites.User;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite, Integer> {
    // Ajoutez des méthodes supplémentaires spécifiques au besoin
	Favorite findById (int id);
	User findUserById(int id);
	@Query("Select f from Pharmacie f join Favorite fa where f.id =: favoriteId")
	List<Pharmacie> findPharmacies(int favoriteId);
	
	
	
	
	
}
