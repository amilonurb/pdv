package com.brl.pdv.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.brl.pdv.model.Cliente;
import com.brl.pdv.model.dao.conexao.ConnectionFactory;

public class ClienteDAO implements GenericDAO<Cliente> {

	private String sql;
	private PreparedStatement stmt;
	private ResultSet rs;
	private Connection connection;

	public ClienteDAO() {
	}

	@Override
	public void insert(Cliente cliente) {
		try {
			sql = "INSERT INTO cliente(nome, perfil, status, bonus) VALUES (?, ?, ?, ?)";
			connection = ConnectionFactory.getConexao();
			connection.setAutoCommit(false);
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, String.valueOf(cliente.getPerfil()));
			stmt.setString(3, String.valueOf(cliente.getStatus()));
			stmt.setInt(4, 0);
			stmt.executeUpdate();
			connection.commit();
			stmt.close();
		} catch (SQLException e1) {

		} catch (ClassNotFoundException e2) {

		}
	}

	@Override
	public void delete(Cliente t) {
		throw new UnsupportedOperationException("Não implementado ainda.");
	}

	@Override
	public List<Cliente> findAll() {
		List<Cliente> clientes = new ArrayList<>();
		try {
			sql = "SELECT nome, status, perfil, bonus FROM cliente";
			connection = ConnectionFactory.getConexao();
			stmt = connection.prepareStatement(sql);
			rs = stmt.executeQuery();
			Cliente cliente = null;
			while (rs.next()) {
				String nome = rs.getString("nome");
				char status = rs.getString("status").charAt(0);
				char perfil = rs.getString("perfil").charAt(0);
				cliente = new Cliente(nome, perfil, status);
				clientes.add(cliente);
			}
			rs.close();
			stmt.close();
			connection.close();
		} catch (SQLException e) {

		} catch (ClassNotFoundException e2) {

		}
		return clientes;
	}

	@Override
	public Cliente findByName(String name) {
		throw new UnsupportedOperationException("Não implementado ainda.");
	}

	@Override
	public Cliente findById(int id) {
		throw new UnsupportedOperationException("Não implementado ainda.");
	}
}