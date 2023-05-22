package com.chaourad.prj.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.chaourad.prj.entites.Pharmacie;
import com.chaourad.prj.entites.PharmacieGarde;
import com.chaourad.prj.entites.PharmacieGardeKey;

public interface PharmacieGardeRepository extends JpaRepository<PharmacieGarde, Integer>  {
	PharmacieGarde findById(int id);
	List<PharmacieGarde>findByPharmacie(Pharmacie pharmacie);
	List<PharmacieGarde> findById(PharmacieGardeKey id);
	
	/*
	 *  select * from  pharmacie_garde p join pharmacie f  where p.garde=1 and f.zone_id=1
	 *   /*
	  * select * from  pharmacy_request where STATUS="accepté" and zone_id=1
	  * 
	  * @Query("Select z from Zone z join z.ville v where v.id =:ville_id")
	List<Zone> findVilleZones(@Param("ville_id") int ville_id);
	
    @Query ("Select p from PharmacyRequest p join p.zone z  where p.status='accepté' and z.id =:zone_id")
    List<PharmacyRequest> findPharmacieAccept(@Param("zone_id") int zone_id);
	 * */
	 
	@Query("SELECT p FROM PharmacieGarde p join p.pharmacie f WHERE p.garde =:gardeId and f.zone =:zoneId")
	List<Pharmacie> findPharmacieGardes(@Param("gardeId") int garde, @Param("zoneId") int zoneId);

	
}
