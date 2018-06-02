package com.brl.pdv.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class JanelaInicial extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaInicial frame = new JanelaInicial();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JanelaInicial() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 225);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panelTitulo = new JPanel();
		contentPane.add(panelTitulo, BorderLayout.NORTH);

		JLabel lblPontoDeVenda = new JLabel("PONTO DE VENDA - PDV");
		panelTitulo.add(lblPontoDeVenda);

		JPanel panelOpcoes = new JPanel();
		contentPane.add(panelOpcoes, BorderLayout.CENTER);
		GridBagLayout gbl_panelOpcoes = new GridBagLayout();
		gbl_panelOpcoes.columnWidths = new int[] { 0, 200, 200, 0, 0 };
		gbl_panelOpcoes.rowHeights = new int[] { 40, 40, 0, 0, 0 };
		gbl_panelOpcoes.columnWeights = new double[] { 0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_panelOpcoes.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panelOpcoes.setLayout(gbl_panelOpcoes);

		JLabel lblEscolhaUmaDas = new JLabel("ESCOLHA UMA DAS OPÇÕES ABAIXO");
		lblEscolhaUmaDas.setHorizontalTextPosition(SwingConstants.CENTER);
		lblEscolhaUmaDas.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblEscolhaUmaDas = new GridBagConstraints();
		gbc_lblEscolhaUmaDas.gridwidth = 2;
		gbc_lblEscolhaUmaDas.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblEscolhaUmaDas.insets = new Insets(0, 0, 5, 5);
		gbc_lblEscolhaUmaDas.gridx = 1;
		gbc_lblEscolhaUmaDas.gridy = 0;
		panelOpcoes.add(lblEscolhaUmaDas, gbc_lblEscolhaUmaDas);

		JButton btnNovaVenda = new JButton("Nova Venda");
		GridBagConstraints gbc_btnNovaVenda = new GridBagConstraints();
		gbc_btnNovaVenda.fill = GridBagConstraints.BOTH;
		gbc_btnNovaVenda.insets = new Insets(0, 0, 5, 5);
		gbc_btnNovaVenda.gridx = 1;
		gbc_btnNovaVenda.gridy = 1;
		panelOpcoes.add(btnNovaVenda, gbc_btnNovaVenda);

		JButton btnExcluirVendas = new JButton("Excluir Venda(s)");
		GridBagConstraints gbc_btnExcluirVendas = new GridBagConstraints();
		gbc_btnExcluirVendas.insets = new Insets(0, 0, 5, 5);
		gbc_btnExcluirVendas.fill = GridBagConstraints.BOTH;
		gbc_btnExcluirVendas.gridx = 2;
		gbc_btnExcluirVendas.gridy = 1;
		panelOpcoes.add(btnExcluirVendas, gbc_btnExcluirVendas);

		JButton btnSair = new JButton("Sair");
		GridBagConstraints gbc_btnSair = new GridBagConstraints();
		gbc_btnSair.insets = new Insets(0, 0, 0, 5);
		gbc_btnSair.anchor = GridBagConstraints.EAST;
		gbc_btnSair.gridx = 2;
		gbc_btnSair.gridy = 3;
		panelOpcoes.add(btnSair, gbc_btnSair);
		btnSair.setHorizontalTextPosition(SwingConstants.LEFT);
		btnSair.setHorizontalAlignment(SwingConstants.LEFT);
	}

}
