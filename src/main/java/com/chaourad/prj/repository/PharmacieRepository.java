package com.chaourad.prj.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.chaourad.prj.entites.Pharmacie;
import com.chaourad.prj.entites.PharmacyRequest;

@Repository
public interface PharmacieRepository extends JpaRepository<Pharmacie, Integer> {
	 Pharmacie findById(int id);

	 List<Pharmacie> findByZoneId(int zoneId);
}

