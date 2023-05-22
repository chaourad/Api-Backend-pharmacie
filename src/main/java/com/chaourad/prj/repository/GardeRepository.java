package com.chaourad.prj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chaourad.prj.entites.Garde;


public interface GardeRepository extends JpaRepository<Garde, Integer>{
	Garde findById(int id);
}
