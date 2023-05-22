package com.chaourad.prj.dao;

import java.util.List;

public interface IDao<T> {
	T save(T o);
	T findById(int id);
	void delete(T o);
	void update(T o);
	List<T> findAll();

}