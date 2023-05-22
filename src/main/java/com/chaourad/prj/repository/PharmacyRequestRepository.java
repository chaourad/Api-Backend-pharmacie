package com.chaourad.prj.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.chaourad.prj.entites.PharmacyRequest;

@Repository
public interface PharmacyRequestRepository extends JpaRepository<PharmacyRequest, Long> {
    List<PharmacyRequest> findByStatus(String status);
    /*
	  * select * from  pharmacy_request where STATUS="accepté" and zone_id=1
	  * 
	  * @Query("Select z from Zone z join z.ville v where v.id =:ville_id")
	List<Zone> findVilleZones(@Param("ville_id") int ville_id);
	  */
    @Query ("Select p from PharmacyRequest p join p.zone z  where p.status='accepté' and z.id =:zone_id")
    List<PharmacyRequest> findPharmacieAccept(@Param("zone_id") int zone_id);
}