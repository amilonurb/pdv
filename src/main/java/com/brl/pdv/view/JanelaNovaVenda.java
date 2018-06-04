package com.brl.pdv.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.TableColumnModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import com.brl.pdv.controller.NovaVendaController;
import com.brl.pdv.model.Cliente;
import com.brl.pdv.model.Localidade;
import com.brl.pdv.model.Produto;
import javax.swing.JScrollPane;

class ItemDeVenda {
	private Produto produto;
	private int quantidade;

	public BigDecimal calcularTotal() {
		BigDecimal resultado = BigDecimal.ZERO;
		resultado.add(produto.getPreco().multiply(BigDecimal.valueOf(quantidade)));
		return resultado;
	}
}

public class JanelaNovaVenda extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private NovaVendaController novaVendaController;
	private Produto produtoSelecionadoComboBox;
	private List<ItemDeVenda> itensDeVenda;

	public JanelaNovaVenda() {
		novaVendaController = new NovaVendaController();
		itensDeVenda = new ArrayList<>();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 680, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panelCliente = new JPanel();
		panelCliente.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.CENTER,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(panelCliente, BorderLayout.NORTH);
		GridBagLayout gbl_panelCliente = new GridBagLayout();
		gbl_panelCliente.columnWidths = new int[] { 70, 300, 75, 0, 0, 0 };
		gbl_panelCliente.rowHeights = new int[] { 40, 0 };
		gbl_panelCliente.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_panelCliente.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panelCliente.setLayout(gbl_panelCliente);

		JLabel lblCliente = new JLabel("Cliente:");
		GridBagConstraints gbc_lblCliente = new GridBagConstraints();
		gbc_lblCliente.insets = new Insets(0, 0, 0, 5);
		gbc_lblCliente.anchor = GridBagConstraints.EAST;
		gbc_lblCliente.gridx = 0;
		gbc_lblCliente.gridy = 0;
		panelCliente.add(lblCliente, gbc_lblCliente);

		JComboBox<Cliente> comboBoxCliente = new JComboBox<>();
		this.novaVendaController.populaComboBoxClientes(comboBoxCliente);
		comboBoxCliente.setEditable(false);
		GridBagConstraints gbc_comboBoxCliente = new GridBagConstraints();
		gbc_comboBoxCliente.insets = new Insets(0, 0, 0, 5);
		gbc_comboBoxCliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxCliente.gridx = 1;
		gbc_comboBoxCliente.gridy = 0;
		panelCliente.add(comboBoxCliente, gbc_comboBoxCliente);

		JLabel lblLocalidade = new JLabel("Local da venda:");
		GridBagConstraints gbc_lblLocalidade = new GridBagConstraints();
		gbc_lblLocalidade.anchor = GridBagConstraints.WEST;
		gbc_lblLocalidade.insets = new Insets(0, 0, 0, 5);
		gbc_lblLocalidade.gridx = 2;
		gbc_lblLocalidade.gridy = 0;
		panelCliente.add(lblLocalidade, gbc_lblLocalidade);

		JComboBox<Localidade> comboBoxLocalidade = new JComboBox<>();
		this.novaVendaController.populaComboBoxLocalidades(comboBoxLocalidade);
		comboBoxLocalidade.setEditable(false);
		GridBagConstraints gbc_comboBoxLocalidade = new GridBagConstraints();
		gbc_comboBoxLocalidade.insets = new Insets(0, 0, 0, 5);
		gbc_comboBoxLocalidade.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxLocalidade.gridx = 3;
		gbc_comboBoxLocalidade.gridy = 0;
		panelCliente.add(comboBoxLocalidade, gbc_comboBoxLocalidade);

		JPanel panelProdutos = new JPanel();
		panelProdutos.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Escolher Produto",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(panelProdutos, BorderLayout.CENTER);
		GridBagLayout gbl_panelProdutos = new GridBagLayout();
		gbl_panelProdutos.columnWidths = new int[] { 100, 120, 0, 80, 90, 80, 0, 90, 45, 0, 0 };
		gbl_panelProdutos.rowHeights = new int[] { 0, 40, 40, 0, 0 };
		gbl_panelProdutos.columnWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gbl_panelProdutos.rowWeights = new double[] { 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		panelProdutos.setLayout(gbl_panelProdutos);

		JLabel lblCodigoProduto = new JLabel("Código do Produto:");
		GridBagConstraints gbc_lblCodigoProduto = new GridBagConstraints();
		gbc_lblCodigoProduto.anchor = GridBagConstraints.EAST;
		gbc_lblCodigoProduto.insets = new Insets(0, 0, 5, 5);
		gbc_lblCodigoProduto.gridx = 1;
		gbc_lblCodigoProduto.gridy = 1;
		panelProdutos.add(lblCodigoProduto, gbc_lblCodigoProduto);

		JComboBox<Produto> comboBoxProduto = new JComboBox<>();
		this.novaVendaController.populaComboBoxProdutos(comboBoxProduto);
		comboBoxProduto.setEditable(false);
		GridBagConstraints gbc_comboBox_2 = new GridBagConstraints();
		gbc_comboBox_2.gridwidth = 2;
		gbc_comboBox_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_2.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_2.gridx = 2;
		gbc_comboBox_2.gridy = 1;
		panelProdutos.add(comboBoxProduto, gbc_comboBox_2);

		JLabel lblQuantidade = new JLabel("Quantidade:");
		GridBagConstraints gbc_lblQuantidade = new GridBagConstraints();
		gbc_lblQuantidade.anchor = GridBagConstraints.EAST;
		gbc_lblQuantidade.insets = new Insets(0, 0, 5, 5);
		gbc_lblQuantidade.gridx = 4;
		gbc_lblQuantidade.gridy = 1;
		panelProdutos.add(lblQuantidade, gbc_lblQuantidade);

		JSpinner spinner = new JSpinner();
		GridBagConstraints gbc_spinner = new GridBagConstraints();
		gbc_spinner.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinner.insets = new Insets(0, 0, 5, 5);
		gbc_spinner.gridx = 5;
		gbc_spinner.gridy = 1;
		panelProdutos.add(spinner, gbc_spinner);

		JButton btnInserir = new JButton("Inserir");
		GridBagConstraints gbc_btnInserir = new GridBagConstraints();
		gbc_btnInserir.gridwidth = 2;
		gbc_btnInserir.fill = GridBagConstraints.VERTICAL;
		gbc_btnInserir.insets = new Insets(0, 0, 5, 5);
		gbc_btnInserir.gridx = 7;
		gbc_btnInserir.gridy = 1;
		panelProdutos.add(btnInserir, gbc_btnInserir);

		JLabel lblDescrio = new JLabel("Descrição:");
		GridBagConstraints gbc_lblDescrio = new GridBagConstraints();
		gbc_lblDescrio.anchor = GridBagConstraints.EAST;
		gbc_lblDescrio.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescrio.gridx = 1;
		gbc_lblDescrio.gridy = 2;
		panelProdutos.add(lblDescrio, gbc_lblDescrio);

		JLabel lblDescricao = new JLabel("");
		GridBagConstraints gbc_lblDescricao = new GridBagConstraints();
		gbc_lblDescricao.gridwidth = 5;
		gbc_lblDescricao.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescricao.gridx = 2;
		gbc_lblDescricao.gridy = 2;
		panelProdutos.add(lblDescricao, gbc_lblDescricao);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setEnabled(false);
		GridBagConstraints gbc_btnExcluir = new GridBagConstraints();
		gbc_btnExcluir.gridwidth = 2;
		gbc_btnExcluir.fill = GridBagConstraints.VERTICAL;
		gbc_btnExcluir.insets = new Insets(0, 0, 5, 5);
		gbc_btnExcluir.gridx = 7;
		gbc_btnExcluir.gridy = 2;
		panelProdutos.add(btnExcluir, gbc_btnExcluir);

		JPanel panelVenda = new JPanel();
		panelVenda.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Detalhes da Compra",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(panelVenda, BorderLayout.SOUTH);
		GridBagLayout gbl_panelVenda = new GridBagLayout();
		gbl_panelVenda.columnWidths = new int[] { 380, 120, 110, 100, 0 };
		gbl_panelVenda.rowHeights = new int[] { 160, 50, 20, 0, 0 };
		gbl_panelVenda.columnWeights = new double[] { 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_panelVenda.rowWeights = new double[] { 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		panelVenda.setLayout(gbl_panelVenda);
		
				JLabel lblTotalParcial = new JLabel("Total parcial:");
				GridBagConstraints gbc_lblTotalParcial = new GridBagConstraints();
				gbc_lblTotalParcial.anchor = GridBagConstraints.EAST;
				gbc_lblTotalParcial.insets = new Insets(0, 0, 5, 5);
				gbc_lblTotalParcial.gridx = 0;
				gbc_lblTotalParcial.gridy = 2;
				panelVenda.add(lblTotalParcial, gbc_lblTotalParcial);
				
						JLabel lblGrana = new JLabel("Grana");
						GridBagConstraints gbc_lblGrana = new GridBagConstraints();
						gbc_lblGrana.insets = new Insets(0, 0, 5, 5);
						gbc_lblGrana.gridx = 1;
						gbc_lblGrana.gridy = 2;
						panelVenda.add(lblGrana, gbc_lblGrana);
						
								JButton btnFinalizarCompra = new JButton("Finalizar compra");
								GridBagConstraints gbc_btnFinalizarCompra = new GridBagConstraints();
								gbc_btnFinalizarCompra.insets = new Insets(0, 0, 5, 0);
								gbc_btnFinalizarCompra.fill = GridBagConstraints.VERTICAL;
								gbc_btnFinalizarCompra.gridwidth = 2;
								gbc_btnFinalizarCompra.gridx = 2;
								gbc_btnFinalizarCompra.gridy = 2;
								panelVenda.add(btnFinalizarCompra, gbc_btnFinalizarCompra);

		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

		comboBoxProduto.addItemListener(event -> {
			produtoSelecionadoComboBox = (Produto) comboBoxProduto.getSelectedItem();
			lblDescricao.setText(produtoSelecionadoComboBox.getDescricao());
		});
	}

}
