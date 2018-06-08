package com.brl.pdv.model.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.brl.pdv.model.Localidade;
import com.brl.pdv.model.Produto;
import com.brl.pdv.model.dao.conexao.ConnectionFactory;

public class ProdutoDAO implements GenericDAO<Produto> {

    private String sql;
    private PreparedStatement stmt;
    private ResultSet rs;
    private Connection connection;
    private LocalidadeDAO localidadeDAO;

    public ProdutoDAO() {
    }

    @Override
    public void insert(Produto produto) {
        throw new UnsupportedOperationException("Não implementado ainda.");
    }

    @Override
    public void delete(Produto produto) {
        throw new UnsupportedOperationException("Não implementado ainda.");
    }

    @Override
    public Produto find(Produto produto) {
        try {
            sql = "SELECT * FROM produto WHERE codprod = ?";
            connection = ConnectionFactory.getConexao();
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, produto.getCodigo());
            rs = stmt.executeQuery();
            if (!rs.next()) {
                return null;
            }
            rs.close();
            stmt.close();
            connection.close();
        } catch (SQLException e) {

        } catch (ClassNotFoundException e2) {

        }
        return produto;
    }
    
    @Override
    public Produto findById(int id) {
        throw new UnsupportedOperationException("Não implementado ainda.");
    }

    @Override
    public Produto findByName(String name) {
        throw new UnsupportedOperationException("Não implementado ainda.");
    }

    @Override
    public List<Produto> findAll() {
        List<Produto> produtos = new ArrayList<>();
        try {
            sql = "SELECT * FROM produto";
            connection = ConnectionFactory.getConexao();
            stmt = connection.prepareStatement(sql);
            rs = stmt.executeQuery();
            Produto produto = null;
            localidadeDAO = new LocalidadeDAO();
            while (rs.next()) {
                int codigo = rs.getInt("codprod");
                String descricao = rs.getString("descricao");
                int quantidade = rs.getInt("qtd_estoque");
                BigDecimal preco = rs.getBigDecimal("preco_unitario");
                produto = new Produto(descricao, quantidade, preco);
                produto.setCodigo(codigo);
                Localidade localidade = localidadeDAO.findById(rs.getInt("codlocal"));
                produto.setLocalidade(localidade);
                produtos.add(produto);
            }
            rs.close();
            stmt.close();
            connection.close();
        } catch (SQLException e) {

        } catch (ClassNotFoundException e2) {

        }
        return produtos;
    }
}
