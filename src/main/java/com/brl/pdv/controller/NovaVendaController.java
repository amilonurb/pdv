package com.brl.pdv.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.swing.JComboBox;

import com.brl.pdv.model.Cliente;
import com.brl.pdv.model.Localidade;
import com.brl.pdv.model.Produto;
import com.brl.pdv.model.dao.ClienteDAO;
import com.brl.pdv.model.dao.LocalidadeDAO;
import com.brl.pdv.model.dao.ProdutoDAO;
import com.brl.pdv.model.dao.VendaDAO;

public class NovaVendaController {

	private ClienteDAO clienteDAO;
	private LocalidadeDAO localidadeDAO;
	private ProdutoDAO produtoDAO;
	private VendaDAO vendaDAO;

	private List<Cliente> clientes;
	private List<Localidade> localidades;
	private List<Produto> produtos;

	public NovaVendaController() {
		clienteDAO = new ClienteDAO();
		localidadeDAO = new LocalidadeDAO();
		produtoDAO = new ProdutoDAO();
		vendaDAO = new VendaDAO();
	}

	public void populaComboBoxClientes(JComboBox<Cliente> comboBoxCliente) {
		clientes = this.clienteDAO.findAll();
		clientes.forEach(cliente -> comboBoxCliente.addItem(cliente));
	}

	public void populaComboBoxLocalidades(JComboBox<Localidade> comboBoxLocalidade) {
		localidades = this.localidadeDAO.findAll();
		localidades.forEach(localidade -> comboBoxLocalidade.addItem(localidade));
	}

	public void populaComboBoxProdutos(JComboBox<Produto> comboBoxProdutos) {
		produtos = this.produtoDAO.findAll();
		produtos.forEach(produto -> comboBoxProdutos.addItem(produto));
	}
	
	public BigDecimal calcularTotalParcial(List<BigDecimal> totaisParciais) {
		return null;
	}
}
