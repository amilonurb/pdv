package com.brl.pdv.model.dao;

import java.util.List;

public interface GenericDAO<T> {
	void insert(T t);

	void delete(T t);
	
	T findById(int id);

	T findByName(String name);

	List<T> findAll();
}