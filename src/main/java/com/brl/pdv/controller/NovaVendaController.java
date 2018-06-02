package com.brl.pdv.controller;

import com.brl.pdv.model.dao.ClienteDAO;
import com.brl.pdv.model.dao.LocalidadeDAO;
import com.brl.pdv.model.dao.ProdutoDAO;
import com.brl.pdv.model.dao.VendaDAO;

public class NovaVendaController {

	private ClienteDAO clienteDAO;
	private LocalidadeDAO localidadeDAO;
	private ProdutoDAO produtoDAO;
	private VendaDAO vendaDAO;

	public NovaVendaController() {
		clienteDAO = new ClienteDAO();
		localidadeDAO = new LocalidadeDAO();
		produtoDAO = new ProdutoDAO();
		vendaDAO = new VendaDAO();
	}

}
