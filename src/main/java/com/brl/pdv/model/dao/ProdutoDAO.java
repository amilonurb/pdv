package com.brl.pdv.model.dao;

import java.util.ArrayList;
import java.util.List;

import com.brl.pdv.model.Produto;

public class ProdutoDAO implements GenericDAO<Produto> {

	@Override
	public void insert(Produto produto) {
	}

	@Override
	public void delete(Produto produto) {
	}

	@Override
	public Produto findByName(String name) {
		Produto produto = null;
		return produto;
	}

	@Override
	public List<Produto> findAll() {
		List<Produto> produtos = new ArrayList<>();
		return produtos;
	}
}