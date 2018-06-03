package com.brl.pdv.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;

public class JanelaNovaVenda extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaNovaVenda frame = new JanelaNovaVenda();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JanelaNovaVenda() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panelCliente = new JPanel();
		panelCliente.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Cliente", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		contentPane.add(panelCliente, BorderLayout.NORTH);
		GridBagLayout gbl_panelCliente = new GridBagLayout();
		gbl_panelCliente.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_panelCliente.rowHeights = new int[] { 0, 0 };
		gbl_panelCliente.columnWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_panelCliente.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panelCliente.setLayout(gbl_panelCliente);

		JLabel lblCliente = new JLabel("Nome:");
		GridBagConstraints gbc_lblCliente = new GridBagConstraints();
		gbc_lblCliente.insets = new Insets(0, 0, 0, 5);
		gbc_lblCliente.anchor = GridBagConstraints.EAST;
		gbc_lblCliente.gridx = 0;
		gbc_lblCliente.gridy = 0;
		panelCliente.add(lblCliente, gbc_lblCliente);

		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 0, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		panelCliente.add(textField, gbc_textField);
		textField.setColumns(10);

		JButton btnProcurar = new JButton("Procurar");
		GridBagConstraints gbc_btnProcurar = new GridBagConstraints();
		gbc_btnProcurar.gridx = 2;
		gbc_btnProcurar.gridy = 0;
		panelCliente.add(btnProcurar, gbc_btnProcurar);

		JPanel panelProdutos = new JPanel();
		panelProdutos.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)), "Produtos",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panelProdutos, BorderLayout.CENTER);
		GridBagLayout gbl_panelProdutos = new GridBagLayout();
		gbl_panelProdutos.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_panelProdutos.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gbl_panelProdutos.columnWeights = new double[] { 1.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_panelProdutos.rowWeights = new double[] { 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		panelProdutos.setLayout(gbl_panelProdutos);

		JLabel lblCdigoDoProduto = new JLabel("Código do produto:");
		GridBagConstraints gbc_lblCdigoDoProduto = new GridBagConstraints();
		gbc_lblCdigoDoProduto.insets = new Insets(0, 0, 5, 5);
		gbc_lblCdigoDoProduto.anchor = GridBagConstraints.EAST;
		gbc_lblCdigoDoProduto.gridx = 0;
		gbc_lblCdigoDoProduto.gridy = 0;
		panelProdutos.add(lblCdigoDoProduto, gbc_lblCdigoDoProduto);

		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 0;
		panelProdutos.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);

		JButton btnProcurar_1 = new JButton("Procurar");
		GridBagConstraints gbc_btnProcurar_1 = new GridBagConstraints();
		gbc_btnProcurar_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnProcurar_1.gridx = 2;
		gbc_btnProcurar_1.gridy = 0;
		panelProdutos.add(btnProcurar_1, gbc_btnProcurar_1);

		JLabel lblQuantidade = new JLabel("Quantidade:");
		GridBagConstraints gbc_lblQuantidade = new GridBagConstraints();
		gbc_lblQuantidade.insets = new Insets(0, 0, 5, 5);
		gbc_lblQuantidade.gridx = 0;
		gbc_lblQuantidade.gridy = 1;
		panelProdutos.add(lblQuantidade, gbc_lblQuantidade);

		JSpinner spinner = new JSpinner();
		GridBagConstraints gbc_spinner = new GridBagConstraints();
		gbc_spinner.insets = new Insets(0, 0, 5, 5);
		gbc_spinner.gridx = 1;
		gbc_spinner.gridy = 1;
		panelProdutos.add(spinner, gbc_spinner);

		table = new JTable();
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.gridwidth = 3;
		gbc_table.insets = new Insets(0, 0, 0, 5);
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 0;
		gbc_table.gridy = 3;
		panelProdutos.add(table, gbc_table);

		JPanel panelVenda = new JPanel();
		panelVenda.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Detalhes da Venda",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panelVenda, BorderLayout.SOUTH);
		GridBagLayout gbl_panelVenda = new GridBagLayout();
		gbl_panelVenda.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_panelVenda.rowHeights = new int[] { 0, 0 };
		gbl_panelVenda.columnWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panelVenda.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panelVenda.setLayout(gbl_panelVenda);

		JLabel lblTotalParcial = new JLabel("Total parcial:");
		GridBagConstraints gbc_lblTotalParcial = new GridBagConstraints();
		gbc_lblTotalParcial.insets = new Insets(0, 0, 0, 5);
		gbc_lblTotalParcial.gridx = 0;
		gbc_lblTotalParcial.gridy = 0;
		panelVenda.add(lblTotalParcial, gbc_lblTotalParcial);

		JLabel lblGrana = new JLabel("Grana");
		GridBagConstraints gbc_lblGrana = new GridBagConstraints();
		gbc_lblGrana.insets = new Insets(0, 0, 0, 5);
		gbc_lblGrana.gridx = 1;
		gbc_lblGrana.gridy = 0;
		panelVenda.add(lblGrana, gbc_lblGrana);

		JButton btnFinalizarCompra = new JButton("Finalizar compra");
		GridBagConstraints gbc_btnFinalizarCompra = new GridBagConstraints();
		gbc_btnFinalizarCompra.gridx = 2;
		gbc_btnFinalizarCompra.gridy = 0;
		panelVenda.add(btnFinalizarCompra, gbc_btnFinalizarCompra);
	}

}
