package com.brl.pdv.model.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.swing.JOptionPane;

import com.brl.pdv.model.Cliente;
import com.brl.pdv.model.Desconto;
import com.brl.pdv.model.Localidade;
import com.brl.pdv.model.Produto;
import com.brl.pdv.model.Venda;
import com.brl.pdv.model.dao.conexao.ConnectionFactory;

public class VendaDAO {

	private String sql;
	private PreparedStatement stmt;
	private Connection connection;
	private ProdutoDAO produtoDAO;
	private ClienteDAO clienteDAO;

	public Venda insert(Cliente cliente, Localidade localidade, Produto produto, int quantidade) {
		Venda venda = null;
		try {
			produtoDAO = new ProdutoDAO();
			if (produtoDAO.findById(produto.getCodigo()) == null) {
				JOptionPane.showMessageDialog(null, "Produto não encontrado");
				return null;
			}

			if (quantidade > produtoDAO.findById(produto.getCodigo()).getQuantidade()) {
				JOptionPane.showMessageDialog(null, "Estoque insuficiente");
				return null;
			}

			produto = produtoDAO.update(produto, quantidade);
			BigDecimal total = produto.getPreco().multiply(BigDecimal.valueOf(quantidade));
			total = calcularValorTotal(produto, cliente, quantidade, total);

			if (produto.getLocalidade().getCodigo() == localidade.getCodigo()) {
				BigDecimal mult = total.multiply(BigDecimal.valueOf(0.1));
				total = total.subtract(mult);
			}

			sql = "INSERT INTO venda(codcli, codprod, codlocal, qtd_venda, valor_total, data_venda) VALUES (?, ?, ?, ?, ?, ?)";
			connection = ConnectionFactory.getConexao();
			connection.setAutoCommit(false);
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, cliente.getCodigo());
			stmt.setInt(2, produto.getCodigo());
			stmt.setInt(3, localidade.getCodigo());
			stmt.setInt(4, quantidade);
			stmt.setBigDecimal(5, total);
			stmt.setDate(6, Date.valueOf(LocalDate.now()));
			stmt.executeUpdate();
			venda = new Venda(cliente, localidade, produto, quantidade);
			venda.setValorTotal(total);
			clienteDAO = new ClienteDAO();
			clienteDAO.descontarBonus(cliente);
			connection.commit();
			stmt.close();
			connection.close();
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
			return null;
		}
		return venda;
	}

	private BigDecimal calcularValorTotal(Produto produto, Cliente cliente, int quantidade, BigDecimal total) {
		BigDecimal totalAtualizado = total;
		if (cliente.getBonus() >= 100) {
			DescontoDAO descontoDAO = new DescontoDAO();
			Desconto desconto = descontoDAO.getDesconto(produto, quantidade);
			if (desconto == null) {
				return totalAtualizado;
			} else {
				BigDecimal result = totalAtualizado.multiply(BigDecimal.valueOf(desconto.getPercentual() * 0.01));
				BigDecimal result2 = totalAtualizado.subtract(result);
				return result2;
			}
		}
		return totalAtualizado;
	}

}
