package com.brl.pdv.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.brl.pdv.model.Localidade;
import com.brl.pdv.model.dao.conexao.ConnectionFactory;

public class LocalidadeDAO implements GenericDAO<Localidade> {

	private String sql;
	private PreparedStatement stmt;
	private ResultSet rs;
	private Connection connection;

	public LocalidadeDAO() {
	}

	@Override
	public void insert(Localidade localidade) {
		try {
			sql = "INSERT INTO localidade(nome, endereco, telefone) VALUES (?, ?, ?)";
			connection = ConnectionFactory.getConexao();
			connection.setAutoCommit(false);
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, localidade.getNome());
			stmt.setString(2, localidade.getEndereco());
			stmt.setString(3, localidade.getTelefone());
			stmt.executeUpdate();
			connection.commit();
			stmt.close();
		} catch (SQLException e1) {

		} catch (ClassNotFoundException e2) {

		}
	}

	@Override
	public void delete(Localidade localidade) {
		throw new UnsupportedOperationException("Não implementado ainda.");
	}
	
	@Override
	public Localidade findById(int id) {
		Localidade localidade = null;
		try {
			sql = "SELECT nome, endereco, telefone FROM localidade WHERE codlocal = ?";
			connection = ConnectionFactory.getConexao();
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			if (rs.next()) {
				String nome = rs.getString("nome");
				String endereco = rs.getString("endereco");
				String telefone = rs.getString("telefone");
				localidade = new Localidade(nome, endereco, telefone);
			}
			rs.close();
			stmt.close();
			connection.close();
		} catch (SQLException e) {

		} catch (ClassNotFoundException e2) {

		}
		return localidade;
	}

	@Override
	public Localidade findByName(String name) {
		throw new UnsupportedOperationException("Não implementado ainda.");
	}

	@Override
	public List<Localidade> findAll() {
		List<Localidade> localidades = new ArrayList<>();
		try {
			sql = "SELECT nome, endereco, telefone FROM localidade";
			connection = ConnectionFactory.getConexao();
			stmt = connection.prepareStatement(sql);
			rs = stmt.executeQuery();
			Localidade localidade = null;
			while (rs.next()) {
				String nome = rs.getString("nome");
				String endereco = rs.getString("endereco");
				String telefone = rs.getString("telefone");
				localidade = new Localidade(nome, endereco, telefone);
				localidades.add(localidade);
			}
			rs.close();
			stmt.close();
			connection.close();
		} catch (SQLException e) {

		} catch (ClassNotFoundException e2) {

		}
		return localidades;
	}
}
