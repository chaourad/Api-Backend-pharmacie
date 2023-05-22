package com.chaourad.prj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chaourad.prj.dao.IDao;
import com.chaourad.prj.entites.Garde;
import com.chaourad.prj.repository.GardeRepository;

@Service
public class GardeService implements IDao<Garde> {

	@Autowired
	private GardeRepository gardeRepository;

	@Override
	public Garde save(Garde o) {
		return gardeRepository.save(o);
	}

	@Override
	public Garde findById(int id) {
		// TODO Auto-generated method stub
		return gardeRepository.findById(id);
	}

	@Override
	public void delete(Garde o) {
		gardeRepository.delete(o);

	}

	@Override
	public void update(Garde o) {
		gardeRepository.save(o);

	}

	@Override
	public List<Garde> findAll() {
		
		return gardeRepository.findAll();
	}

	public long count() {
		// TODO Auto-generated method stub
		return gardeRepository.count();
	}

}
