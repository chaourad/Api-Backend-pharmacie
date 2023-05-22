package com.chaourad.prj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chaourad.prj.entites.Zone;

public interface ZoneRepository extends JpaRepository<Zone, Integer> {
	Zone findById(int id);
}