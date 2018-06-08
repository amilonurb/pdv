package com.brl.pdv.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.brl.pdv.controller.NovaVendaController;
import com.brl.pdv.model.Cliente;
import com.brl.pdv.model.Venda;
import com.brl.pdv.model.Localidade;
import com.brl.pdv.model.Produto;
import com.brl.pdv.util.FormatadorDinheiro;

public class JanelaNovaVenda extends JFrame {

    private static final long serialVersionUID = 1L;

    private JPanel contentPane;
    private JPanel panelCliente;
    private JPanel panelProdutos;
    private JPanel panelTabelaVenda;
    private JPanel panelTotalCompra;
    private JScrollPane scrollTabelaVenda;

    private JLabel lblCliente;
    private JLabel lblLocalidade;
    private JLabel lblCodigoProduto;
    private JLabel lblQuantidade;
    private JLabel lblDescricao;
    private JLabel lblGetDescricao;
    private JLabel lblTotalDaCompra;
    private JLabel labelValorTotal;

    private JComboBox<Cliente> comboBoxCliente;
    private JComboBox<Localidade> comboBoxLocalidade;
    private JComboBox<Produto> comboBoxProduto;

    private JSpinner spinnerQtd;

    private GridBagLayout gbl_panelCliente;
    private GridBagConstraints gbc_lblCliente;
    private GridBagConstraints gbc_comboBoxCliente;
    private GridBagConstraints gbc_lblLocalidade;
    private GridBagConstraints gbc_comboBoxLocalidade;

    private JButton btnInserir;
    private JButton btnExcluir;
    private JButton btnCancelar;
    private JButton btnFinalizarCompra;

    private JTable tabelaVenda;
    private NovaVendaController novaVendaController;
    private Cliente clienteSelecionado;
    private Localidade localidadeSelecionada;
    private Produto produtoSelecionado;
    private List<Venda> itensDeVenda;
    private BigDecimal totalParcial;

    public JanelaNovaVenda() {
        novaVendaController = new NovaVendaController();
        itensDeVenda = new ArrayList<>();
        totalParcial = BigDecimal.ZERO;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 740, 530);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        panelCliente = new JPanel();
        panelCliente.setBounds(10, 11, 704, 45);
        panelCliente.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.CENTER,
                TitledBorder.TOP, null, new Color(0, 0, 0)));
        contentPane.add(panelCliente);
        gbl_panelCliente = new GridBagLayout();
        gbl_panelCliente.columnWidths = new int[]{70, 300, 75, 0, 0, 0};
        gbl_panelCliente.rowHeights = new int[]{40, 0};
        gbl_panelCliente.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
        gbl_panelCliente.rowWeights = new double[]{0.0, Double.MIN_VALUE};
        panelCliente.setLayout(gbl_panelCliente);

        lblCliente = new JLabel("Cliente:");
        gbc_lblCliente = new GridBagConstraints();
        gbc_lblCliente.insets = new Insets(0, 0, 0, 5);
        gbc_lblCliente.anchor = GridBagConstraints.EAST;
        gbc_lblCliente.gridx = 0;
        gbc_lblCliente.gridy = 0;
        panelCliente.add(lblCliente, gbc_lblCliente);

        comboBoxCliente = new JComboBox<>();
        novaVendaController.populaComboBoxClientes(comboBoxCliente);
        comboBoxCliente.setEditable(false);
        gbc_comboBoxCliente = new GridBagConstraints();
        gbc_comboBoxCliente.insets = new Insets(0, 0, 0, 5);
        gbc_comboBoxCliente.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBoxCliente.gridx = 1;
        gbc_comboBoxCliente.gridy = 0;
        panelCliente.add(comboBoxCliente, gbc_comboBoxCliente);

        lblLocalidade = new JLabel("Local da venda:");
        gbc_lblLocalidade = new GridBagConstraints();
        gbc_lblLocalidade.anchor = GridBagConstraints.WEST;
        gbc_lblLocalidade.insets = new Insets(0, 0, 0, 5);
        gbc_lblLocalidade.gridx = 2;
        gbc_lblLocalidade.gridy = 0;
        panelCliente.add(lblLocalidade, gbc_lblLocalidade);

        comboBoxLocalidade = new JComboBox<>();
        this.novaVendaController.populaComboBoxLocalidades(comboBoxLocalidade);
        comboBoxLocalidade.setEditable(false);
        gbc_comboBoxLocalidade = new GridBagConstraints();
        gbc_comboBoxLocalidade.insets = new Insets(0, 0, 0, 5);
        gbc_comboBoxLocalidade.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBoxLocalidade.gridx = 3;
        gbc_comboBoxLocalidade.gridy = 0;
        panelCliente.add(comboBoxLocalidade, gbc_comboBoxLocalidade);

        panelProdutos = new JPanel();
        panelProdutos.setBounds(10, 67, 704, 120);
        panelProdutos.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Escolher Produto",
                TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        contentPane.add(panelProdutos);
        panelProdutos.setLayout(null);

        lblCodigoProduto = new JLabel("Código do Produto:");
        lblCodigoProduto.setBounds(31, 35, 109, 14);
        panelProdutos.add(lblCodigoProduto);

        comboBoxProduto = new JComboBox<>();
        comboBoxProduto.setBounds(150, 32, 105, 20);
        this.novaVendaController.populaComboBoxProdutos(comboBoxProduto);
        comboBoxProduto.setEditable(false);
        panelProdutos.add(comboBoxProduto);

        lblQuantidade = new JLabel("Quantidade:");
        lblQuantidade.setBounds(265, 35, 75, 14);
        panelProdutos.add(lblQuantidade);

        spinnerQtd = new JSpinner();
        spinnerQtd.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
        spinnerQtd.setValue(1);
        spinnerQtd.setBounds(350, 32, 75, 20);
        panelProdutos.add(spinnerQtd);

        btnInserir = new JButton("Inserir");
        btnInserir.setBounds(450, 25, 108, 35);
        panelProdutos.add(btnInserir);

        lblDescricao = new JLabel("Descrição:");
        lblDescricao.setBounds(31, 75, 80, 14);
        panelProdutos.add(lblDescricao);

        btnExcluir = new JButton("Excluir");
        btnExcluir.setBounds(580, 25, 108, 35);
        btnExcluir.setEnabled(false);
        panelProdutos.add(btnExcluir);

        lblGetDescricao = new JLabel("");
        lblGetDescricao.setBounds(121, 75, 567, 14);
        panelProdutos.add(lblGetDescricao);

        panelTabelaVenda = new JPanel();
        panelTabelaVenda.setBounds(10, 198, 704, 220);
        panelTabelaVenda.setLayout(new BorderLayout(0, 0));
        contentPane.add(panelTabelaVenda);
        tabelaVenda = new JTable();
        tabelaVenda.setModel(new DefaultTableModel(new Object[][]{},
                new String[]{"Descrição", "Quantidade", "Preço 1x", "Total"}));
        scrollTabelaVenda = new JScrollPane();
        scrollTabelaVenda.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        scrollTabelaVenda.setViewportView(tabelaVenda);
        panelTabelaVenda.add(scrollTabelaVenda);

        panelTotalCompra = new JPanel();
        panelTotalCompra.setBounds(10, 429, 704, 58);
        contentPane.add(panelTotalCompra);
        panelTotalCompra.setLayout(null);

        lblTotalDaCompra = new JLabel("Total da Compra:");
        lblTotalDaCompra.setHorizontalAlignment(SwingConstants.RIGHT);
        lblTotalDaCompra.setBounds(0, 11, 200, 38);
        panelTotalCompra.add(lblTotalDaCompra);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(614, 9, 85, 40);
        panelTotalCompra.add(btnCancelar);

        btnFinalizarCompra = new JButton("Finalizar Compra");
        btnFinalizarCompra.setBounds(445, 9, 140, 40);
        panelTotalCompra.add(btnFinalizarCompra);

        comboBoxCliente.setSelectedItem(0);
        clienteSelecionado = (Cliente) comboBoxCliente.getSelectedItem();
        comboBoxCliente.addActionListener(event -> clienteSelecionado = (Cliente) comboBoxCliente.getSelectedItem());
        comboBoxLocalidade.setSelectedItem(0);
        localidadeSelecionada = (Localidade) comboBoxLocalidade.getSelectedItem();
        comboBoxProduto.setSelectedItem(0);
        produtoSelecionado = (Produto) comboBoxProduto.getSelectedItem();
        lblGetDescricao.setText(produtoSelecionado.getDescricao());
        labelValorTotal.setText(FormatadorDinheiro.formata(totalParcial));
        initListeners();
    }

    private void initListeners() {
        comboBoxLocalidade
                .addActionListener(event -> localidadeSelecionada = (Localidade) comboBoxLocalidade.getSelectedItem());

        comboBoxProduto.addItemListener(event -> {
            produtoSelecionado = (Produto) comboBoxProduto.getSelectedItem();
            lblDescricao.setText(produtoSelecionado.getDescricao());
        });

        btnInserir.addActionListener(inserir -> {
            produtoSelecionado = (Produto) comboBoxProduto.getSelectedItem();
            int qtd = (int) (spinnerQtd.getValue());
            Venda itemDeVenda = new Venda(produtoSelecionado, qtd);
            itensDeVenda.add(itemDeVenda);
            atualizarTabela();
        });

    }

    private void atualizarTabela() {
        DefaultTableModel modelo = (DefaultTableModel) tabelaVenda.getModel();
        modelo.setRowCount(0);
        for (Venda itemDeVenda : itensDeVenda) {
            modelo.addRow(new Object[]{itemDeVenda.getProduto().getDescricao(), itemDeVenda.getQuantidade(),
                itemDeVenda.getProduto().getPreco(), FormatadorDinheiro.formata(itemDeVenda.calcularTotal())});
        }
    }

}
