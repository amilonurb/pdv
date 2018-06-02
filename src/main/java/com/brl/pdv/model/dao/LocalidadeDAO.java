package com.brl.pdv.model.dao;

import java.util.ArrayList;
import java.util.List;

import com.brl.pdv.model.Localidade;

public class LocalidadeDAO implements GenericDAO<Localidade> {

	@Override
	public void insert(Localidade localidade) {
	}

	@Override
	public void delete(Localidade localidade) {
	}

	@Override
	public Localidade findByName(String name) {
		Localidade localidade = null;
		return localidade;
	}

	@Override
	public List<Localidade> findAll() {
		List<Localidade> localidades = new ArrayList<>();
		return localidades;
	}
}