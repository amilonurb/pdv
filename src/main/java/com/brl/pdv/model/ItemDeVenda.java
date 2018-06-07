package com.brl.pdv.model;

import java.math.BigDecimal;

public class ItemDeVenda {
	private Produto produto;
	private int quantidade;

	public ItemDeVenda(Produto produto, int quantidade) {
		this.produto = produto;
		this.quantidade = quantidade;
	}

	public Produto getProduto() {
		return produto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public BigDecimal calcularTotal() {
		BigDecimal qtd = BigDecimal.valueOf(this.quantidade);
		BigDecimal resultado = produto.getPreco().multiply(qtd);
		return resultado;
	}
}