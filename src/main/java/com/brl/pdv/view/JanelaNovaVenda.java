package com.brl.pdv.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.brl.pdv.controller.NovaVendaController;
import com.brl.pdv.model.Cliente;
import com.brl.pdv.model.Localidade;
import com.brl.pdv.model.Produto;

public class JanelaNovaVenda extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JTable tabelaVendas;
	private JTextField textField;
	private NovaVendaController novaVendaController;

	public JanelaNovaVenda() {
		novaVendaController = new NovaVendaController();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panelCliente = new JPanel();
		panelCliente.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.CENTER,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(panelCliente, BorderLayout.NORTH);
		GridBagLayout gbl_panelCliente = new GridBagLayout();
		gbl_panelCliente.columnWidths = new int[] { 70, 300, 0, 75, 0, 0 };
		gbl_panelCliente.rowHeights = new int[] { 40, 0 };
		gbl_panelCliente.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
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
		gbc_lblLocalidade.gridx = 3;
		gbc_lblLocalidade.gridy = 0;
		panelCliente.add(lblLocalidade, gbc_lblLocalidade);

		JComboBox<Localidade> comboBoxLocalidade = new JComboBox<>();
		this.novaVendaController.populaComboBoxLocalidades(comboBoxLocalidade);
		comboBoxLocalidade.setEditable(false);
		GridBagConstraints gbc_comboBoxLocalidade = new GridBagConstraints();
		gbc_comboBoxLocalidade.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxLocalidade.gridx = 4;
		gbc_comboBoxLocalidade.gridy = 0;
		panelCliente.add(comboBoxLocalidade, gbc_comboBoxLocalidade);

		JPanel panelProdutos = new JPanel();
		panelProdutos.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panelProdutos, BorderLayout.CENTER);
		GridBagLayout gbl_panelProdutos = new GridBagLayout();
		gbl_panelProdutos.columnWidths = new int[] { 70, 350, 100, 100, 40, 0, 0 };
		gbl_panelProdutos.rowHeights = new int[] { 40, 40, 0 };
		gbl_panelProdutos.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panelProdutos.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		panelProdutos.setLayout(gbl_panelProdutos);

		JLabel lblCdigoDoProduto = new JLabel("Produto:");
		GridBagConstraints gbc_lblCdigoDoProduto = new GridBagConstraints();
		gbc_lblCdigoDoProduto.anchor = GridBagConstraints.EAST;
		gbc_lblCdigoDoProduto.insets = new Insets(0, 0, 5, 5);
		gbc_lblCdigoDoProduto.gridx = 0;
		gbc_lblCdigoDoProduto.gridy = 0;
		panelProdutos.add(lblCdigoDoProduto, gbc_lblCdigoDoProduto);

		JComboBox<Produto> comboBoxProduto = new JComboBox<>();
		this.novaVendaController.populaComboBoxProdutos(comboBoxProduto);
		comboBoxProduto.setEditable(false);
		GridBagConstraints gbc_comboBox_2 = new GridBagConstraints();
		gbc_comboBox_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_2.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_2.gridx = 1;
		gbc_comboBox_2.gridy = 0;
		panelProdutos.add(comboBoxProduto, gbc_comboBox_2);

		JLabel lblQuantidade = new JLabel("Quantidade:");
		GridBagConstraints gbc_lblQuantidade = new GridBagConstraints();
		gbc_lblQuantidade.anchor = GridBagConstraints.EAST;
		gbc_lblQuantidade.insets = new Insets(0, 0, 5, 5);
		gbc_lblQuantidade.gridx = 2;
		gbc_lblQuantidade.gridy = 0;
		panelProdutos.add(lblQuantidade, gbc_lblQuantidade);

		JSpinner spinner = new JSpinner();
		GridBagConstraints gbc_spinner = new GridBagConstraints();
		gbc_spinner.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinner.insets = new Insets(0, 0, 5, 5);
		gbc_spinner.gridx = 3;
		gbc_spinner.gridy = 0;
		panelProdutos.add(spinner, gbc_spinner);

		JLabel lblDescrio = new JLabel("Descrição:");
		GridBagConstraints gbc_lblDescrio = new GridBagConstraints();
		gbc_lblDescrio.anchor = GridBagConstraints.EAST;
		gbc_lblDescrio.insets = new Insets(0, 0, 0, 5);
		gbc_lblDescrio.gridx = 0;
		gbc_lblDescrio.gridy = 1;
		panelProdutos.add(lblDescrio, gbc_lblDescrio);

		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 0, 5);
		gbc_textField.fill = GridBagConstraints.BOTH;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 1;
		panelProdutos.add(textField, gbc_textField);
		textField.setColumns(10);

		JButton btnInserir = new JButton("Inserir");
		GridBagConstraints gbc_btnInserir = new GridBagConstraints();
		gbc_btnInserir.anchor = GridBagConstraints.EAST;
		gbc_btnInserir.insets = new Insets(0, 0, 0, 5);
		gbc_btnInserir.gridx = 2;
		gbc_btnInserir.gridy = 1;
		panelProdutos.add(btnInserir, gbc_btnInserir);

		JButton btnExcluir = new JButton("Excluir");
		GridBagConstraints gbc_btnExcluir = new GridBagConstraints();
		gbc_btnExcluir.insets = new Insets(0, 0, 0, 5);
		gbc_btnExcluir.gridx = 3;
		gbc_btnExcluir.gridy = 1;
		panelProdutos.add(btnExcluir, gbc_btnExcluir);

		JPanel panelVenda = new JPanel();
		panelVenda.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Detalhes da Venda",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panelVenda, BorderLayout.SOUTH);
		GridBagLayout gbl_panelVenda = new GridBagLayout();
		gbl_panelVenda.columnWidths = new int[] { 100, 465, 100, 0, 0 };
		gbl_panelVenda.rowHeights = new int[] { 160, 21, 50, 20, 0 };
		gbl_panelVenda.columnWeights = new double[] { 1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panelVenda.rowWeights = new double[] { 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panelVenda.setLayout(gbl_panelVenda);

		tabelaVendas = new JTable();
		GridBagConstraints gbc_tabelaVendas = new GridBagConstraints();
		gbc_tabelaVendas.gridwidth = 4;
		gbc_tabelaVendas.insets = new Insets(0, 0, 5, 5);
		gbc_tabelaVendas.fill = GridBagConstraints.BOTH;
		gbc_tabelaVendas.gridx = 0;
		gbc_tabelaVendas.gridy = 0;
		panelVenda.add(tabelaVendas, gbc_tabelaVendas);

		JLabel lblTotalParcial = new JLabel("Total parcial:");
		GridBagConstraints gbc_lblTotalParcial = new GridBagConstraints();
		gbc_lblTotalParcial.gridheight = 3;
		gbc_lblTotalParcial.insets = new Insets(0, 0, 0, 5);
		gbc_lblTotalParcial.gridx = 0;
		gbc_lblTotalParcial.gridy = 1;
		panelVenda.add(lblTotalParcial, gbc_lblTotalParcial);

		JLabel lblValorTotal = new JLabel("Grana");
		GridBagConstraints gbc_lblValorTotal = new GridBagConstraints();
		gbc_lblValorTotal.gridheight = 3;
		gbc_lblValorTotal.insets = new Insets(0, 0, 0, 5);
		gbc_lblValorTotal.gridx = 1;
		gbc_lblValorTotal.gridy = 1;
		panelVenda.add(lblValorTotal, gbc_lblValorTotal);

		JButton btnFinalizarCompra = new JButton("Finalizar compra");
		GridBagConstraints gbc_btnFinalizarCompra = new GridBagConstraints();
		gbc_btnFinalizarCompra.fill = GridBagConstraints.VERTICAL;
		gbc_btnFinalizarCompra.insets = new Insets(0, 0, 5, 5);
		gbc_btnFinalizarCompra.gridx = 2;
		gbc_btnFinalizarCompra.gridy = 2;
		panelVenda.add(btnFinalizarCompra, gbc_btnFinalizarCompra);

		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

}
