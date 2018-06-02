package com.brl.pdv.model.dao;

import java.util.ArrayList;
import java.util.List;

import com.brl.pdv.model.Venda;

public class VendaDAO implements GenericDAO<Venda> {

	@Override
	public void insert(Venda venda) {
	}

	@Override
	public void delete(Venda venda) {
	}

	@Override
	public Venda findByName(String name) {
		Venda venda = null;
		return venda;
	}

	@Override
	public List<Venda> findAll() {
		List<Venda> vendas = new ArrayList<>();
		return vendas;
	}
}