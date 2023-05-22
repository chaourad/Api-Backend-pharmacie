package com.chaourad.prj.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.chaourad.prj.entites.Ville;
import com.chaourad.prj.entites.Zone;

public interface VilleRepository extends JpaRepository<Ville,Integer>{

	Ville findById(int id);
	
	
	@Query("Select z from Zone z join z.ville v where v.id =:ville_id")
	List<Zone> findVilleZones(@Param("ville_id") int ville_id);
	

}