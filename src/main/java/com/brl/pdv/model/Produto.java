package com.brl.pdv.model;

import java.math.BigDecimal;

public class Produto {

	private String descricao;
	private int quantidade;
	private BigDecimal preco;
	private Localidade local;

	public Produto(String descricao, int quantidade, BigDecimal preco, Localidade local) {
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.preco = preco;
		this.local = local;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Localidade getLocal() {
		return local;
	}

	public void setLocal(Localidade local) {
		this.local = local;
	}
}