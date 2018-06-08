package com.brl.pdv.model.dao;

import com.brl.pdv.model.Produto;
import java.util.List;

import com.brl.pdv.model.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VendaDAO implements GenericDAO<Venda> {
    
    private String sql;
    private PreparedStatement stmt;
    private ResultSet rs;
    private Connection connection;
    private LocalidadeDAO localidadeDAO;

    @Override
    public void insert(Venda venda) {
        try {
            ProdutoDAO produtoDAO = new ProdutoDAO();
            Produto produto = venda.getProduto();
            if (produtoDAO.find(produto)) {
                
                
                
            } else if (pro) {
                
            } else {
                return;
            }
        } catch (SQLException e) {
        } catch (ClassNotFoundException e) {
        }
    }

    @Override
    public void delete(Venda venda) {
        throw new UnsupportedOperationException("Não implementado ainda.");
    }

    @Override
    public Venda find(Venda venda) {
        throw new UnsupportedOperationException("Não implementado ainda.");
    }

    @Override
    public Venda findById(int id) {
        throw new UnsupportedOperationException("Não implementado ainda.");
    }

    @Override
    public Venda findByName(String name) {
        throw new UnsupportedOperationException("Não implementado ainda.");
    }

    @Override
    public List<Venda> findAll() {
        throw new UnsupportedOperationException("Não implementado ainda.");
    }
}
