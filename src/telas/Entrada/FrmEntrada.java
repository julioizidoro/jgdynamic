/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FrmEntrada.java
 *
 * Created on 15/03/2011, 09:14:00
 */

package telas.Entrada;

import Interfaces.ItelaConsulta;
import Regras.AliquotaController;
import Regras.ConfiguracaoController;
import Regras.ContasPagarController;
import Regras.CustoProdutoController;
import Regras.EntradaEstoque;
import Regras.EntradaProdutoController;
import Regras.EstoqueController;
import Regras.ForPedidoController;
import Regras.Formatacao;
import Regras.ListaProdutoEntrada;
import Regras.ParametroLocalController;
import Regras.ProdutoController;
import Regras.VinculoController;
import beanController.LerXml200;
import beanController.NfDuplicatas;
import beanController.NfProdutos;
import beanController.NotaEletronica;
import com.toedter.calendar.JTextFieldDateEditor;
import controler.CodigoBarrasController;
import controler.Config;
import facade.AliquotaFacade;
import facade.ForPedidoFacade;
import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.xml.parsers.ParserConfigurationException;
import model.*;
import org.xml.sax.SAXException;
import table.DuplicataTableModel;
import table.NotaEletronicaTableModel;
import telas.ContasPagar.ContasPagarTableModel;
import telas.ForPedido.FrmConsultaForPedido;
import telas.Fornecedor.FrmCadastrarFornecedor;
import telas.Fornecedor.FrmConsultaFornecedor;
import telas.Produtos.FrmConsultaProdutos;



/**
 *
 * @author wolverine
 */
public class FrmEntrada extends javax.swing.JFrame implements ItelaConsulta {

    private String datePattern;
    private String maskPattern;
    private char placeHolder;
    private LerXml200 nfe;
    private List<NfDuplicatas> listaDuplicata;
    private List<NfProdutos> listaProdutos;
    private NotaEletronica nota;
    private NotaEletronicaTableModel notaEletronicaModel;
    private DuplicataTableModel duplicataModel;
    private EntradaProdutoTableModel entradaProdutoModel;
    private List<ListaProdutoEntrada> listaAlterar = new ArrayList<ListaProdutoEntrada>();
    Forpedido forPediddo;
    Config config;
    private ConsultaForPedidoProdutoTableModel ForPedidoModel;
    private EntradaEstoque entradaEstoque;
    private ListaProdutoEntrada listaProdutoEntrada;
    private int linhaAlterar;
    private List<Forpedproduto> listaPedidoProduto;
    private Configuracao configuracao;
    
    //Variaveis Contas Pagar
    private Planoconta planoConta;
    private List<Contaspagar> listaContasPagar;
    private ContasPagarTableModel modelContasPagar;
    
    private  DefaultTableCellRenderer rendererCor;
    private  DefaultTableCellRenderer rendererCorNumerico;
    private int linhaNota;
    private int linhaPedido;
    Produto produto;
    

    /** Creates new form FrmEntrada */
    public FrmEntrada(Config config) {
        datePattern = "dd/MM/yyyy";
        maskPattern = "##/##/##";
        placeHolder = '_';
        listaDuplicata = new ArrayList<NfDuplicatas>();
        listaProdutos = new ArrayList<NfProdutos>();
        entradaEstoque = new EntradaEstoque();
        nota = new NotaEletronica();
        this.config = config;
        linhaAlterar = -1;
        linhaAlterar=-1;
        linhaPedido=-1;
        produto=null;
        initComponents();
        URL url = this.getClass().getResource("/imagens/logo_mini.png");
        Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(imagemTitulo);
        this.setLocationRelativeTo(null);
        modelarProdutosNotaFiscal();
        dataEntradajDateChooser.setDate(new Date());
        fornecedorjTextField.requestFocus();
        
        setModelContasPagar();
        carregarConfiguracao();
        setVisible(true);
    }

    public FrmEntrada(EntradaEstoque entradaEstoque, Config config) {
        this.config = config;
        datePattern = "dd/MM/yyyy";
        maskPattern = "##/##/##";
        placeHolder = '_';
        listaDuplicata = new ArrayList<NfDuplicatas>();
        listaProdutos = new ArrayList<NfProdutos>();
        this.entradaEstoque = entradaEstoque;
        linhaAlterar=-1;
        initComponents();
        URL url = this.getClass().getResource("/imagens/logo_mini.png");
        Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(imagemTitulo);
        this.setLocationRelativeTo(null);
        alterarEntrada();
        listaAlterar.addAll(entradaEstoque.getListaProdutos());
        entradaEstoque.calcularTotais();
        valorTotalProdutosjTextField.setText(Formatacao.foramtarDoubleString(entradaEstoque.getValorProdutos()));
        valorTotalEncargosjTextField.setText(Formatacao.foramtarDoubleString(entradaEstoque.getValorEncargos()));
        valorTotalNotajTextField.setText(Formatacao.foramtarDoubleString(entradaEstoque.getValorTotal()));
        setModelContasPagar();
        carregarConfiguracao();
        setVisible(true);
    }

    

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel18 = new javax.swing.JLabel();
        jMenuItem1 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        entradajTabbedPane = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        dadosRegistrojPanel = new javax.swing.JPanel();
        fornecedorjTextField = new javax.swing.JTextField();
        dataEntradajDateChooser = new com.toedter.calendar.JDateChooser(null, null, datePattern, new JTextFieldDateEditor(datePattern,
            maskPattern, placeHolder));
    tipoDocumentojComboBox = new javax.swing.JComboBox();
    condicaoPagamentojComboBox = new javax.swing.JComboBox();
    valorEncargosjTextField = new javax.swing.JTextField();
    valorDescontojTextField = new javax.swing.JTextField();
    valorProdutosjTextField = new javax.swing.JTextField();
    situacaojComboBox = new javax.swing.JComboBox();
    valorTotaljTextField = new javax.swing.JTextField();
    jLabel1 = new javax.swing.JLabel();
    controlejButton = new javax.swing.JButton();
    jLabel2 = new javax.swing.JLabel();
    jLabel3 = new javax.swing.JLabel();
    jLabel4 = new javax.swing.JLabel();
    jLabel5 = new javax.swing.JLabel();
    jLabel6 = new javax.swing.JLabel();
    jLabel7 = new javax.swing.JLabel();
    jLabel8 = new javax.swing.JLabel();
    jLabel15 = new javax.swing.JLabel();
    buscaBancojButton3 = new javax.swing.JButton();
    dadosNotafiscaljPanel = new javax.swing.JPanel();
    numerojTextField = new javax.swing.JTextField();
    dataEmissaojDateChooser = new com.toedter.calendar.JDateChooser(null, null, datePattern, new JTextFieldDateEditor(datePattern,
        maskPattern, placeHolder));
dataSaidajDateChooser = new com.toedter.calendar.JDateChooser(null, null, datePattern, new JTextFieldDateEditor(datePattern,
    maskPattern, placeHolder));
    especiejComboBox = new javax.swing.JComboBox();
    seriejTextField = new javax.swing.JTextField();
    subSeriejTextField = new javax.swing.JTextField();
    jLabel9 = new javax.swing.JLabel();
    jLabel10 = new javax.swing.JLabel();
    jLabel11 = new javax.swing.JLabel();
    jLabel12 = new javax.swing.JLabel();
    jLabel13 = new javax.swing.JLabel();
    jLabel14 = new javax.swing.JLabel();
    gerarRecibojButton = new javax.swing.JButton();
    xmljPanel = new javax.swing.JPanel();
    jLabel17 = new javax.swing.JLabel();
    caminhojTextField = new javax.swing.JTextField();
    limparjButton = new javax.swing.JButton();
    localizarjButton = new javax.swing.JButton();
    carregarjButton = new javax.swing.JButton();
    jPanel5 = new javax.swing.JPanel();
    jPanel3 = new javax.swing.JPanel();
    jPanel13 = new javax.swing.JPanel();
    codigojTextField = new javax.swing.JTextField();
    jLabel19 = new javax.swing.JLabel();
    descricaojTextField = new javax.swing.JTextField();
    codigoFabricantejTextField = new javax.swing.JTextField();
    embalagemjTextField = new javax.swing.JTextField();
    unidadejTextField = new javax.swing.JTextField();
    jLabel20 = new javax.swing.JLabel();
    jLabel21 = new javax.swing.JLabel();
    jLabel22 = new javax.swing.JLabel();
    jLabel23 = new javax.swing.JLabel();
    jLabel24 = new javax.swing.JLabel();
    jLabel25 = new javax.swing.JLabel();
    jLabel26 = new javax.swing.JLabel();
    buscaBancojButton1 = new javax.swing.JButton();
    jLabel27 = new javax.swing.JLabel();
    jLabel28 = new javax.swing.JLabel();
    jLabel29 = new javax.swing.JLabel();
    jLabel30 = new javax.swing.JLabel();
    jLabel31 = new javax.swing.JLabel();
    jLabel32 = new javax.swing.JLabel();
    jLabel33 = new javax.swing.JLabel();
    jLabel34 = new javax.swing.JLabel();
    jLabel35 = new javax.swing.JLabel();
    valorVendajTextField = new javax.swing.JTextField();
    quantidadejTextField = new javax.swing.JTextField();
    icmsjTextField = new javax.swing.JTextField();
    ipijTextField = new javax.swing.JTextField();
    stjTextField = new javax.swing.JTextField();
    unitariojTextField = new javax.swing.JTextField();
    custojTextField = new javax.swing.JTextField();
    totalUnitariojTextField = new javax.swing.JTextField();
    dataComprajTextField = new javax.swing.JTextField();
    percentualVendajTextField = new javax.swing.JTextField();
    estoqueAtualjTextField = new javax.swing.JTextField();
    ultimaComprajTextField1 = new javax.swing.JTextField();
    jLabel39 = new javax.swing.JLabel();
    totalCustojTextField = new javax.swing.JTextField();
    jButton13 = new javax.swing.JButton();
    ncmjTextField = new javax.swing.JTextField();
    jLabel46 = new javax.swing.JLabel();
    jButton6 = new javax.swing.JButton();
    jButton7 = new javax.swing.JButton();
    jButton8 = new javax.swing.JButton();
    jLabel36 = new javax.swing.JLabel();
    jLabel37 = new javax.swing.JLabel();
    jLabel38 = new javax.swing.JLabel();
    valorTotalEncargosjTextField = new javax.swing.JTextField();
    valorTotalProdutosjTextField = new javax.swing.JTextField();
    valorTotalNotajTextField = new javax.swing.JTextField();
    jButton9 = new javax.swing.JButton();
    jScrollPane1 = new javax.swing.JScrollPane();
    produtosjTable = new javax.swing.JTable();
    jPanel4 = new javax.swing.JPanel();
    jScrollPane2 = new javax.swing.JScrollPane();
    ProdutosPedidojTable = new javax.swing.JTable();
    jPanel14 = new javax.swing.JPanel();
    jButton4 = new javax.swing.JButton();
    jButton5 = new javax.swing.JButton();
    naoRegistradosjButton = new javax.swing.JButton();
    todosRegistradosjButton = new javax.swing.JButton();
    jButton1 = new javax.swing.JButton();
    jTabbedPane2 = new javax.swing.JTabbedPane();
    jPanel10 = new javax.swing.JPanel();
    jScrollPane5 = new javax.swing.JScrollPane();
    ProdutosNFEjTable = new javax.swing.JTable();
    jPanel16 = new javax.swing.JPanel();
    jLabel41 = new javax.swing.JLabel();
    jScrollPane3 = new javax.swing.JScrollPane();
    ProdutosPedidoNotajTable = new javax.swing.JTable();
    jPanel11 = new javax.swing.JPanel();
    jScrollPane4 = new javax.swing.JScrollPane();
    duplicatajTable = new javax.swing.JTable();
    jPanel6 = new javax.swing.JPanel();
    vencidasjScrollPane = new javax.swing.JScrollPane();
    contasPagarjTable = new javax.swing.JTable();
    jPanel7 = new javax.swing.JPanel();
    jLabel16 = new javax.swing.JLabel();
    valorTotalContasPagarjTextField = new javax.swing.JTextField();
    jLabel40 = new javax.swing.JLabel();
    boletojComboBox = new javax.swing.JComboBox();
    jLabel42 = new javax.swing.JLabel();
    tipoPagamentojComboBox = new javax.swing.JComboBox();
    jPanel9 = new javax.swing.JPanel();
    jLabel43 = new javax.swing.JLabel();
    numeroDocumentojTextField = new javax.swing.JTextField();
    dataVencimentojDateChooser = new com.toedter.calendar.JDateChooser(null, null, datePattern, new JTextFieldDateEditor(datePattern,
        maskPattern, placeHolder));
jLabel44 = new javax.swing.JLabel();
jLabel45 = new javax.swing.JLabel();
valorContajTextField = new javax.swing.JTextField();
jPanel12 = new javax.swing.JPanel();
jButton15 = new javax.swing.JButton();
jButton16 = new javax.swing.JButton();
jPanel15 = new javax.swing.JPanel();
jButton10 = new javax.swing.JButton();
jButton11 = new javax.swing.JButton();
jMenuBar1 = new javax.swing.JMenuBar();
jMenu1 = new javax.swing.JMenu();
jMenuItem2 = new javax.swing.JMenuItem();

jLabel18.setText("jLabel18");

jMenuItem1.setText("jMenuItem1");

setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
setTitle("Registro de Compras");
getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

entradajTabbedPane.addChangeListener(new javax.swing.event.ChangeListener() {
    public void stateChanged(javax.swing.event.ChangeEvent evt) {
        entradajTabbedPaneStateChanged(evt);
    }
    });
    entradajTabbedPane.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
        public void propertyChange(java.beans.PropertyChangeEvent evt) {
            entradajTabbedPanePropertyChange(evt);
        }
    });

    jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    dadosRegistrojPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Documento Registro de Compra"));
    dadosRegistrojPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    fornecedorjTextField.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyPressed(java.awt.event.KeyEvent evt) {
            fornecedorjTextFieldKeyPressed(evt);
        }
    });
    dadosRegistrojPanel.add(fornecedorjTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 410, -1));

    dataEntradajDateChooser.addFocusListener(new java.awt.event.FocusAdapter() {
        public void focusGained(java.awt.event.FocusEvent evt) {
            dataEntradajDateChooserFocusGained(evt);
        }
    });
    dadosRegistrojPanel.add(dataEntradajDateChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 40, 100, -1));

    tipoDocumentojComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nota Fiscal", "Pedido", "Recibo" }));
    tipoDocumentojComboBox.addFocusListener(new java.awt.event.FocusAdapter() {
        public void focusLost(java.awt.event.FocusEvent evt) {
            tipoDocumentojComboBoxFocusLost(evt);
        }
    });
    dadosRegistrojPanel.add(tipoDocumentojComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 40, 220, -1));

    condicaoPagamentojComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "a Prazo", "a Vista" }));
    dadosRegistrojPanel.add(condicaoPagamentojComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 40, 100, -1));

    valorEncargosjTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
    valorEncargosjTextField.setText("0,00");
    valorEncargosjTextField.addFocusListener(new java.awt.event.FocusAdapter() {
        public void focusGained(java.awt.event.FocusEvent evt) {
            valorEncargosjTextFieldFocusGained(evt);
        }
    });
    valorEncargosjTextField.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyReleased(java.awt.event.KeyEvent evt) {
            valorEncargosjTextFieldKeyReleased(evt);
        }
    });
    dadosRegistrojPanel.add(valorEncargosjTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 100, -1));

    valorDescontojTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
    valorDescontojTextField.setText("0,00");
    valorDescontojTextField.addFocusListener(new java.awt.event.FocusAdapter() {
        public void focusGained(java.awt.event.FocusEvent evt) {
            valorDescontojTextFieldFocusGained(evt);
        }
        public void focusLost(java.awt.event.FocusEvent evt) {
            valorDescontojTextFieldFocusLost(evt);
        }
    });
    valorDescontojTextField.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyReleased(java.awt.event.KeyEvent evt) {
            valorDescontojTextFieldKeyReleased(evt);
        }
    });
    dadosRegistrojPanel.add(valorDescontojTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 90, -1));

    valorProdutosjTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
    valorProdutosjTextField.setText("0,00");
    valorProdutosjTextField.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            valorProdutosjTextFieldActionPerformed(evt);
        }
    });
    valorProdutosjTextField.addFocusListener(new java.awt.event.FocusAdapter() {
        public void focusGained(java.awt.event.FocusEvent evt) {
            valorProdutosjTextFieldFocusGained(evt);
        }
        public void focusLost(java.awt.event.FocusEvent evt) {
            valorProdutosjTextFieldFocusLost(evt);
        }
    });
    valorProdutosjTextField.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyReleased(java.awt.event.KeyEvent evt) {
            valorProdutosjTextFieldKeyReleased(evt);
        }
    });
    dadosRegistrojPanel.add(valorProdutosjTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, 100, -1));

    situacaojComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Movimento", "Finalizada", "Reposição" }));
    situacaojComboBox.addFocusListener(new java.awt.event.FocusAdapter() {
        public void focusLost(java.awt.event.FocusEvent evt) {
            situacaojComboBoxFocusLost(evt);
        }
    });
    dadosRegistrojPanel.add(situacaojComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 80, 330, -1));

    valorTotaljTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
    valorTotaljTextField.setText("0,00");
    valorTotaljTextField.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            valorTotaljTextFieldActionPerformed(evt);
        }
    });
    valorTotaljTextField.addFocusListener(new java.awt.event.FocusAdapter() {
        public void focusGained(java.awt.event.FocusEvent evt) {
            valorTotaljTextFieldFocusGained(evt);
        }
        public void focusLost(java.awt.event.FocusEvent evt) {
            valorTotaljTextFieldFocusLost(evt);
        }
    });
    valorTotaljTextField.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyReleased(java.awt.event.KeyEvent evt) {
            valorTotaljTextFieldKeyReleased(evt);
        }
    });
    dadosRegistrojPanel.add(valorTotaljTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 80, 100, -1));

    jLabel1.setText("Fornecedor");
    dadosRegistrojPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 25, -1, -1));

    controlejButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/note.png"))); // NOI18N
    controlejButton.setText("Controle");
    controlejButton.setToolTipText("Situação do Registro de Compras");
    controlejButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            controlejButtonActionPerformed(evt);
        }
    });
    dadosRegistrojPanel.add(controlejButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 75, 100, -1));

    jLabel2.setText("Condição de Pagamento");
    dadosRegistrojPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 25, -1, -1));

    jLabel3.setText("Data da Entrada");
    dadosRegistrojPanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 25, -1, -1));

    jLabel4.setText("Tipo de Documento");
    dadosRegistrojPanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 25, -1, -1));

    jLabel5.setText("Valor Encargos ");
    dadosRegistrojPanel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 65, -1, -1));

    jLabel6.setText("Valor do Desconto");
    dadosRegistrojPanel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 65, -1, -1));

    jLabel7.setText("Valor dos Produtos");
    dadosRegistrojPanel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 65, -1, -1));

    jLabel8.setText("Situação da Entrada");
    dadosRegistrojPanel.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 65, -1, -1));

    jLabel15.setText("Valor Total ");
    dadosRegistrojPanel.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 65, -1, -1));

    buscaBancojButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/magnifier.png"))); // NOI18N
    buscaBancojButton3.setToolTipText("Consultar Fornecedor");
    buscaBancojButton3.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            buscaBancojButton3ActionPerformed(evt);
        }
    });
    dadosRegistrojPanel.add(buscaBancojButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 40, 20, 20));

    jPanel2.add(dadosRegistrojPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 960, 140));

    dadosNotafiscaljPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados Nota Fiscal"));
    dadosNotafiscaljPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    numerojTextField.setEnabled(false);
    numerojTextField.addFocusListener(new java.awt.event.FocusAdapter() {
        public void focusGained(java.awt.event.FocusEvent evt) {
            numerojTextFieldFocusGained(evt);
        }
        public void focusLost(java.awt.event.FocusEvent evt) {
            numerojTextFieldFocusLost(evt);
        }
    });
    dadosNotafiscaljPanel.add(numerojTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 35, 90, -1));

    dataEmissaojDateChooser.setEnabled(false);
    dataEmissaojDateChooser.addFocusListener(new java.awt.event.FocusAdapter() {
        public void focusGained(java.awt.event.FocusEvent evt) {
            dataEmissaojDateChooserFocusGained(evt);
        }
    });
    dadosNotafiscaljPanel.add(dataEmissaojDateChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 35, 100, -1));

    dataSaidajDateChooser.setEnabled(false);
    dataSaidajDateChooser.addFocusListener(new java.awt.event.FocusAdapter() {
        public void focusGained(java.awt.event.FocusEvent evt) {
            dataSaidajDateChooserFocusGained(evt);
        }
    });
    dadosNotafiscaljPanel.add(dataSaidajDateChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 35, 100, -1));

    especiejComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "NF-e", "NFF", "NF" }));
    especiejComboBox.setEnabled(false);
    dadosNotafiscaljPanel.add(especiejComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 35, 90, -1));

    seriejTextField.setEnabled(false);
    seriejTextField.addFocusListener(new java.awt.event.FocusAdapter() {
        public void focusGained(java.awt.event.FocusEvent evt) {
            seriejTextFieldFocusGained(evt);
        }
        public void focusLost(java.awt.event.FocusEvent evt) {
            seriejTextFieldFocusLost(evt);
        }
    });
    dadosNotafiscaljPanel.add(seriejTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 35, 100, -1));

    subSeriejTextField.setEnabled(false);
    subSeriejTextField.addFocusListener(new java.awt.event.FocusAdapter() {
        public void focusGained(java.awt.event.FocusEvent evt) {
            subSeriejTextFieldFocusGained(evt);
        }
        public void focusLost(java.awt.event.FocusEvent evt) {
            subSeriejTextFieldFocusLost(evt);
        }
    });
    dadosNotafiscaljPanel.add(subSeriejTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 35, 80, -1));

    jLabel9.setText("Número");
    dadosNotafiscaljPanel.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

    jLabel10.setText("Data Emissão");
    dadosNotafiscaljPanel.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, -1, -1));

    jLabel11.setText("Data Saída");
    dadosNotafiscaljPanel.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, -1, -1));

    jLabel12.setText("Especie");
    dadosNotafiscaljPanel.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 20, -1, -1));

    jLabel13.setText("Série");
    dadosNotafiscaljPanel.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 20, -1, -1));

    jLabel14.setText("Sub-Serie");
    dadosNotafiscaljPanel.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 20, -1, -1));

    gerarRecibojButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/tick.png"))); // NOI18N
    gerarRecibojButton.setToolTipText("Gerar Numero Pedido ou Recibo");
    gerarRecibojButton.setEnabled(false);
    gerarRecibojButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            gerarRecibojButtonActionPerformed(evt);
        }
    });
    dadosNotafiscaljPanel.add(gerarRecibojButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 35, 20, 20));

    jPanel2.add(dadosNotafiscaljPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 960, 70));

    xmljPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Carregar XML NF-e"));
    xmljPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jLabel17.setText("Local de Armazenamento do Arquivo");
    xmljPanel.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 31, -1, -1));

    caminhojTextField.setEditable(false);
    xmljPanel.add(caminhojTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 570, -1));

    limparjButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cross.png"))); // NOI18N
    limparjButton.setText("Limpar");
    limparjButton.setToolTipText("Limpar dados do Arquivo NF-e");
    limparjButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            limparjButtonActionPerformed(evt);
        }
    });
    xmljPanel.add(limparjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, -1, -1));

    localizarjButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/magnifier.png"))); // NOI18N
    localizarjButton.setText("Localizar");
    localizarjButton.setToolTipText("Localizar Arquivo NF-e");
    localizarjButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            localizarjButtonActionPerformed(evt);
        }
    });
    xmljPanel.add(localizarjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

    carregarjButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/tick.png"))); // NOI18N
    carregarjButton.setText("Carregar");
    carregarjButton.setToolTipText("Carregar dados da NF-e");
    carregarjButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            carregarjButtonActionPerformed(evt);
        }
    });
    xmljPanel.add(carregarjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 90, -1, -1));

    jPanel2.add(xmljPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 960, 130));

    jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Documento de Entrada"));
    jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
    jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 1065, -1));

    entradajTabbedPane.addTab("Documento Entrada", jPanel2);

    jPanel13.setBorder(javax.swing.BorderFactory.createEtchedBorder());
    jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    codigojTextField.addFocusListener(new java.awt.event.FocusAdapter() {
        public void focusLost(java.awt.event.FocusEvent evt) {
            codigojTextFieldFocusLost(evt);
        }
        public void focusGained(java.awt.event.FocusEvent evt) {
            codigojTextFieldFocusGained(evt);
        }
    });
    codigojTextField.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyPressed(java.awt.event.KeyEvent evt) {
            codigojTextFieldKeyPressed(evt);
        }
        public void keyReleased(java.awt.event.KeyEvent evt) {
            codigojTextFieldKeyReleased(evt);
        }
    });
    jPanel13.add(codigojTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 25, 67, -1));

    jLabel19.setText("Código");
    jPanel13.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

    descricaojTextField.setEditable(false);
    jPanel13.add(descricaojTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 25, 290, -1));

    codigoFabricantejTextField.addFocusListener(new java.awt.event.FocusAdapter() {
        public void focusGained(java.awt.event.FocusEvent evt) {
            codigoFabricantejTextFieldFocusGained(evt);
        }
        public void focusLost(java.awt.event.FocusEvent evt) {
            codigoFabricantejTextFieldFocusLost(evt);
        }
    });
    codigoFabricantejTextField.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyPressed(java.awt.event.KeyEvent evt) {
            codigoFabricantejTextFieldKeyPressed(evt);
        }
    });
    jPanel13.add(codigoFabricantejTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 25, 70, -1));

    embalagemjTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
    embalagemjTextField.addFocusListener(new java.awt.event.FocusAdapter() {
        public void focusLost(java.awt.event.FocusEvent evt) {
            embalagemjTextFieldFocusLost(evt);
        }
        public void focusGained(java.awt.event.FocusEvent evt) {
            embalagemjTextFieldFocusGained(evt);
        }
    });
    embalagemjTextField.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyPressed(java.awt.event.KeyEvent evt) {
            embalagemjTextFieldKeyPressed(evt);
        }
    });
    jPanel13.add(embalagemjTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 25, 60, -1));

    unidadejTextField.setEditable(false);
    jPanel13.add(unidadejTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 25, 60, -1));

    jLabel20.setText("Descrição");
    jPanel13.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, -1, -1));

    jLabel21.setText("Cod. Fabricante");
    jPanel13.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 10, -1, -1));

    jLabel22.setText("Embalagem");
    jPanel13.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 10, -1, -1));

    jLabel23.setText("Unidade");
    jPanel13.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 10, -1, -1));

    jLabel24.setText("Estoque Atual");
    jPanel13.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 10, -1, -1));

    jLabel25.setText("Data Compra");
    jPanel13.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 10, -1, -1));

    jLabel26.setText("Valor Compra");
    jPanel13.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 10, -1, -1));

    buscaBancojButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/magnifier.png"))); // NOI18N
    buscaBancojButton1.setToolTipText("Pesquisa Banco");
    buscaBancojButton1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            buscaBancojButton1ActionPerformed(evt);
        }
    });
    jPanel13.add(buscaBancojButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 25, 20, 20));

    jLabel27.setText("$ Venda");
    jPanel13.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 50, -1, -1));

    jLabel28.setText("Quantidade");
    jPanel13.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

    jLabel29.setText("% ICMS");
    jPanel13.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, -1, -1));

    jLabel30.setText("$ IPI");
    jPanel13.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, -1, -1));

    jLabel31.setText("$ ST");
    jPanel13.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 50, -1, -1));

    jLabel32.setText("$ Unitário");
    jPanel13.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 50, -1, -1));

    jLabel33.setText("$ Custo");
    jPanel13.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 50, -1, -1));

    jLabel34.setText("$ Total Unitario");
    jPanel13.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 50, -1, -1));

    jLabel35.setText("% Vendas");
    jPanel13.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 50, -1, -1));

    valorVendajTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
    valorVendajTextField.setText("0,00");
    valorVendajTextField.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyPressed(java.awt.event.KeyEvent evt) {
            valorVendajTextFieldKeyPressed(evt);
        }
        public void keyReleased(java.awt.event.KeyEvent evt) {
            valorVendajTextFieldKeyReleased(evt);
        }
    });
    jPanel13.add(valorVendajTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 65, 80, -1));

    quantidadejTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
    quantidadejTextField.setText("0,00");
    quantidadejTextField.addFocusListener(new java.awt.event.FocusAdapter() {
        public void focusGained(java.awt.event.FocusEvent evt) {
            quantidadejTextFieldFocusGained(evt);
        }
        public void focusLost(java.awt.event.FocusEvent evt) {
            quantidadejTextFieldFocusLost(evt);
        }
    });
    quantidadejTextField.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyPressed(java.awt.event.KeyEvent evt) {
            quantidadejTextFieldKeyPressed(evt);
        }
        public void keyReleased(java.awt.event.KeyEvent evt) {
            quantidadejTextFieldKeyReleased(evt);
        }
    });
    jPanel13.add(quantidadejTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 65, 60, -1));

    icmsjTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
    icmsjTextField.setText("0,00");
    icmsjTextField.addFocusListener(new java.awt.event.FocusAdapter() {
        public void focusGained(java.awt.event.FocusEvent evt) {
            icmsjTextFieldFocusGained(evt);
        }
        public void focusLost(java.awt.event.FocusEvent evt) {
            icmsjTextFieldFocusLost(evt);
        }
    });
    icmsjTextField.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyReleased(java.awt.event.KeyEvent evt) {
            icmsjTextFieldKeyReleased(evt);
        }
    });
    jPanel13.add(icmsjTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 65, 60, -1));

    ipijTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
    ipijTextField.setText("0,00");
    ipijTextField.addFocusListener(new java.awt.event.FocusAdapter() {
        public void focusGained(java.awt.event.FocusEvent evt) {
            ipijTextFieldFocusGained(evt);
        }
        public void focusLost(java.awt.event.FocusEvent evt) {
            ipijTextFieldFocusLost(evt);
        }
    });
    ipijTextField.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyReleased(java.awt.event.KeyEvent evt) {
            ipijTextFieldKeyReleased(evt);
        }
    });
    jPanel13.add(ipijTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 65, 60, -1));

    stjTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
    stjTextField.setText("0,00");
    stjTextField.addFocusListener(new java.awt.event.FocusAdapter() {
        public void focusGained(java.awt.event.FocusEvent evt) {
            stjTextFieldFocusGained(evt);
        }
        public void focusLost(java.awt.event.FocusEvent evt) {
            stjTextFieldFocusLost(evt);
        }
    });
    stjTextField.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyReleased(java.awt.event.KeyEvent evt) {
            stjTextFieldKeyReleased(evt);
        }
    });
    jPanel13.add(stjTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 65, 80, -1));

    unitariojTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
    unitariojTextField.setText("0,00");
    unitariojTextField.addFocusListener(new java.awt.event.FocusAdapter() {
        public void focusGained(java.awt.event.FocusEvent evt) {
            unitariojTextFieldFocusGained(evt);
        }
        public void focusLost(java.awt.event.FocusEvent evt) {
            unitariojTextFieldFocusLost(evt);
        }
    });
    unitariojTextField.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyReleased(java.awt.event.KeyEvent evt) {
            unitariojTextFieldKeyReleased(evt);
        }
    });
    jPanel13.add(unitariojTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 65, 80, -1));

    custojTextField.setEditable(false);
    custojTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
    custojTextField.setText("0,00");
    custojTextField.addFocusListener(new java.awt.event.FocusAdapter() {
        public void focusLost(java.awt.event.FocusEvent evt) {
            custojTextFieldFocusLost(evt);
        }
    });
    jPanel13.add(custojTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 65, 80, -1));

    totalUnitariojTextField.setEditable(false);
    totalUnitariojTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
    totalUnitariojTextField.setText("0,00");
    jPanel13.add(totalUnitariojTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 65, 100, -1));

    dataComprajTextField.setEditable(false);
    dataComprajTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
    jPanel13.add(dataComprajTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 25, 80, -1));

    percentualVendajTextField.setEditable(false);
    percentualVendajTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
    percentualVendajTextField.setText("0,00");
    percentualVendajTextField.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyReleased(java.awt.event.KeyEvent evt) {
            percentualVendajTextFieldKeyReleased(evt);
        }
    });
    jPanel13.add(percentualVendajTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 65, 80, -1));

    estoqueAtualjTextField.setEditable(false);
    estoqueAtualjTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
    estoqueAtualjTextField.setText("0,00");
    jPanel13.add(estoqueAtualjTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 25, 70, -1));

    ultimaComprajTextField1.setEditable(false);
    ultimaComprajTextField1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
    ultimaComprajTextField1.setText("0,00");
    jPanel13.add(ultimaComprajTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 25, 70, -1));

    jLabel39.setText("$ Total Custo");
    jPanel13.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 50, -1, -1));

    totalCustojTextField.setEditable(false);
    totalCustojTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
    totalCustojTextField.setText("0,00");
    jPanel13.add(totalCustojTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 65, 90, -1));

    jButton13.setText("Alterar");
    jButton13.setToolTipText("Alterar Valor de Venda");
    jButton13.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton13ActionPerformed(evt);
        }
    });
    jPanel13.add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 60, -1, -1));

    ncmjTextField.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyPressed(java.awt.event.KeyEvent evt) {
            ncmjTextFieldKeyPressed(evt);
        }
    });
    jPanel13.add(ncmjTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 25, 70, -1));

    jLabel46.setText("NCM");
    jPanel13.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, -1, -1));

    jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/tick.png"))); // NOI18N
    jButton6.setText("Confirma Produto");
    jButton6.setToolTipText("Confirma Registro de Produto");
    jButton6.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton6ActionPerformed(evt);
        }
    });

    jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cross.png"))); // NOI18N
    jButton7.setText("Cancela Produto");
    jButton7.setToolTipText("Cancela Registro de Produto");
    jButton7.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton7ActionPerformed(evt);
        }
    });

    jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cross.png"))); // NOI18N
    jButton8.setText("Excluir Produto ");
    jButton8.setToolTipText("Exclui Produto na Lista de Registro");
    jButton8.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton8ActionPerformed(evt);
        }
    });

    jLabel36.setText("Valor dos Produtos");

    jLabel37.setText("Valor dos Encargos");

    jLabel38.setText("Valor Total");

    valorTotalEncargosjTextField.setEditable(false);
    valorTotalEncargosjTextField.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
    valorTotalEncargosjTextField.setForeground(new java.awt.Color(204, 0, 0));
    valorTotalEncargosjTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
    valorTotalEncargosjTextField.setText("0,00");

    valorTotalProdutosjTextField.setEditable(false);
    valorTotalProdutosjTextField.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
    valorTotalProdutosjTextField.setForeground(new java.awt.Color(0, 204, 0));
    valorTotalProdutosjTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
    valorTotalProdutosjTextField.setText("0,00");

    valorTotalNotajTextField.setEditable(false);
    valorTotalNotajTextField.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
    valorTotalNotajTextField.setForeground(new java.awt.Color(51, 0, 204));
    valorTotalNotajTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
    valorTotalNotajTextField.setText("0,00");

    jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/tick.png"))); // NOI18N
    jButton9.setText("Alterar Produto");
    jButton9.setToolTipText("Alterar Produto");
    jButton9.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton9ActionPerformed(evt);
        }
    });

    produtosjTable.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {
            {null, null, null, null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null, null, null, null}
        },
        new String [] {
            "Código", "Descrição", "Unidade", "Quantidade", "Valor Unitário", "Valor ICMS", "Valor IPI", "Valor ST", "Valor Custo", "Valor Total", "Preço"
        }
    ) {
        boolean[] canEdit = new boolean [] {
            false, false, false, false, false, false, false, false, false, false, false
        };

        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit [columnIndex];
        }
    });
    jScrollPane1.setViewportView(produtosjTable);
    if (produtosjTable.getColumnModel().getColumnCount() > 0) {
        produtosjTable.getColumnModel().getColumn(0).setResizable(false);
        produtosjTable.getColumnModel().getColumn(0).setPreferredWidth(10);
        produtosjTable.getColumnModel().getColumn(1).setResizable(false);
        produtosjTable.getColumnModel().getColumn(1).setPreferredWidth(250);
        produtosjTable.getColumnModel().getColumn(2).setResizable(false);
        produtosjTable.getColumnModel().getColumn(2).setPreferredWidth(5);
        produtosjTable.getColumnModel().getColumn(3).setResizable(false);
        produtosjTable.getColumnModel().getColumn(3).setPreferredWidth(20);
        produtosjTable.getColumnModel().getColumn(4).setResizable(false);
        produtosjTable.getColumnModel().getColumn(4).setPreferredWidth(30);
        produtosjTable.getColumnModel().getColumn(5).setResizable(false);
        produtosjTable.getColumnModel().getColumn(5).setPreferredWidth(10);
        produtosjTable.getColumnModel().getColumn(6).setResizable(false);
        produtosjTable.getColumnModel().getColumn(6).setPreferredWidth(10);
        produtosjTable.getColumnModel().getColumn(7).setResizable(false);
        produtosjTable.getColumnModel().getColumn(7).setPreferredWidth(10);
        produtosjTable.getColumnModel().getColumn(8).setResizable(false);
        produtosjTable.getColumnModel().getColumn(8).setPreferredWidth(10);
        produtosjTable.getColumnModel().getColumn(9).setResizable(false);
        produtosjTable.getColumnModel().getColumn(9).setPreferredWidth(10);
        produtosjTable.getColumnModel().getColumn(10).setResizable(false);
        produtosjTable.getColumnModel().getColumn(10).setPreferredWidth(2);
    }

    javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
    jPanel3.setLayout(jPanel3Layout);
    jPanel3Layout.setHorizontalGroup(
        jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel3Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jButton6)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jButton9)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton7)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jButton8)
            .addGap(18, 18, 18)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addComponent(jLabel36)
                    .addGap(28, 28, 28)
                    .addComponent(jLabel37)
                    .addGap(21, 21, 21)
                    .addComponent(jLabel38))
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addComponent(valorTotalProdutosjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(valorTotalEncargosjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(valorTotalNotajTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGap(219, 219, 219))
        .addGroup(jPanel3Layout.createSequentialGroup()
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, 963, Short.MAX_VALUE)
                .addComponent(jScrollPane1))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    jPanel3Layout.setVerticalGroup(
        jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel3Layout.createSequentialGroup()
            .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(jLabel36)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(jLabel37)))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(valorTotalProdutosjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(valorTotalEncargosjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(valorTotalNotajTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7)
                    .addComponent(jButton9)
                    .addComponent(jButton8)
                    .addComponent(jButton6)))
            .addGap(1334, 1334, 1334))
    );

    entradajTabbedPane.addTab("Produtos", jPanel3);

    ProdutosPedidojTable.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {
            {null, null, null, null, null, null},
            {null, null, null, null, null, null},
            {null, null, null, null, null, null},
            {null, null, null, null, null, null}
        },
        new String [] {
            "Código", "Descrição", "Unidade", "Quantidade", "Código Fabricante", "Entrada"
        }
    ) {
        boolean[] canEdit = new boolean [] {
            false, false, false, false, false, false
        };

        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit [columnIndex];
        }
    });
    ProdutosPedidojTable.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            ProdutosPedidojTableMouseClicked(evt);
        }
    });
    ProdutosPedidojTable.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyPressed(java.awt.event.KeyEvent evt) {
            ProdutosPedidojTableKeyPressed(evt);
        }
    });
    jScrollPane2.setViewportView(ProdutosPedidojTable);
    if (ProdutosPedidojTable.getColumnModel().getColumnCount() > 0) {
        ProdutosPedidojTable.getColumnModel().getColumn(0).setResizable(false);
        ProdutosPedidojTable.getColumnModel().getColumn(0).setPreferredWidth(20);
        ProdutosPedidojTable.getColumnModel().getColumn(1).setResizable(false);
        ProdutosPedidojTable.getColumnModel().getColumn(1).setPreferredWidth(500);
        ProdutosPedidojTable.getColumnModel().getColumn(2).setResizable(false);
        ProdutosPedidojTable.getColumnModel().getColumn(2).setPreferredWidth(20);
        ProdutosPedidojTable.getColumnModel().getColumn(3).setResizable(false);
        ProdutosPedidojTable.getColumnModel().getColumn(3).setPreferredWidth(30);
        ProdutosPedidojTable.getColumnModel().getColumn(4).setResizable(false);
        ProdutosPedidojTable.getColumnModel().getColumn(4).setPreferredWidth(50);
        ProdutosPedidojTable.getColumnModel().getColumn(5).setResizable(false);
        ProdutosPedidojTable.getColumnModel().getColumn(5).setPreferredWidth(10);
    }

    jPanel14.setBorder(javax.swing.BorderFactory.createEtchedBorder());

    jButton4.setText("Carregar Pedido");
    jButton4.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton4ActionPerformed(evt);
        }
    });

    jButton5.setText("Registrar Entrada");
    jButton5.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton5ActionPerformed(evt);
        }
    });

    naoRegistradosjButton.setText("Não Registrados");
    naoRegistradosjButton.setEnabled(false);
    naoRegistradosjButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            naoRegistradosjButtonActionPerformed(evt);
        }
    });

    todosRegistradosjButton.setText("Mostar Todos");
    todosRegistradosjButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            todosRegistradosjButtonActionPerformed(evt);
        }
    });

    jButton1.setText("Registrar Pedido");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton1ActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
    jPanel14.setLayout(jPanel14Layout);
    jPanel14Layout.setHorizontalGroup(
        jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel14Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(todosRegistradosjButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(naoRegistradosjButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGap(146, 146, 146)
            .addComponent(jButton4)
            .addGap(111, 111, 111)
            .addComponent(jButton5)
            .addGap(105, 105, 105)
            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(252, Short.MAX_VALUE))
    );
    jPanel14Layout.setVerticalGroup(
        jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel14Layout.createSequentialGroup()
            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel14Layout.createSequentialGroup()
                    .addGap(22, 22, 22)
                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton4)
                        .addComponent(jButton5)
                        .addComponent(jButton1)))
                .addGroup(jPanel14Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(naoRegistradosjButton)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(todosRegistradosjButton)))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
    jPanel4.setLayout(jPanel4Layout);
    jPanel4Layout.setHorizontalGroup(
        jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(jPanel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING))
            .addContainerGap())
    );
    jPanel4Layout.setVerticalGroup(
        jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel4Layout.createSequentialGroup()
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    entradajTabbedPane.addTab("Pedidos", jPanel4);

    ProdutosNFEjTable.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null}
        },
        new String [] {
            "Title 1", "Title 2", "Title 3", "Title 4"
        }
    ));
    ProdutosNFEjTable.setToolTipText("ENTER Registra Produto - F12  Cadastra novo Produto");
    ProdutosNFEjTable.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            ProdutosNFEjTableMouseClicked(evt);
        }
    });
    ProdutosNFEjTable.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyPressed(java.awt.event.KeyEvent evt) {
            ProdutosNFEjTableKeyPressed(evt);
        }
    });
    jScrollPane5.setViewportView(ProdutosNFEjTable);

    jPanel16.setToolTipText("");

    jLabel41.setForeground(java.awt.Color.blue);
    jLabel41.setText("Pressione ENTER para registrar Produto                  Pressione F12 para Consultar Produto");

    javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
    jPanel16.setLayout(jPanel16Layout);
    jPanel16Layout.setHorizontalGroup(
        jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
            .addContainerGap(155, Short.MAX_VALUE)
            .addComponent(jLabel41)
            .addGap(111, 111, 111))
    );
    jPanel16Layout.setVerticalGroup(
        jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap())
    );

    ProdutosPedidoNotajTable.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {
            {null, null, null, null, null, null},
            {null, null, null, null, null, null},
            {null, null, null, null, null, null},
            {null, null, null, null, null, null}
        },
        new String [] {
            "Código", "Descrição", "Unidade", "Quantidade", "Código Fabricante", "Entrada"
        }
    ) {
        boolean[] canEdit = new boolean [] {
            false, false, false, false, false, false
        };

        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit [columnIndex];
        }
    });
    ProdutosPedidoNotajTable.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            ProdutosPedidoNotajTableMouseClicked(evt);
        }
    });
    ProdutosPedidoNotajTable.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyPressed(java.awt.event.KeyEvent evt) {
            ProdutosPedidoNotajTableKeyPressed(evt);
        }
    });
    jScrollPane3.setViewportView(ProdutosPedidoNotajTable);
    if (ProdutosPedidoNotajTable.getColumnModel().getColumnCount() > 0) {
        ProdutosPedidoNotajTable.getColumnModel().getColumn(0).setResizable(false);
        ProdutosPedidoNotajTable.getColumnModel().getColumn(0).setPreferredWidth(20);
        ProdutosPedidoNotajTable.getColumnModel().getColumn(1).setResizable(false);
        ProdutosPedidoNotajTable.getColumnModel().getColumn(1).setPreferredWidth(500);
        ProdutosPedidoNotajTable.getColumnModel().getColumn(2).setResizable(false);
        ProdutosPedidoNotajTable.getColumnModel().getColumn(2).setPreferredWidth(20);
        ProdutosPedidoNotajTable.getColumnModel().getColumn(3).setResizable(false);
        ProdutosPedidoNotajTable.getColumnModel().getColumn(3).setPreferredWidth(30);
        ProdutosPedidoNotajTable.getColumnModel().getColumn(4).setResizable(false);
        ProdutosPedidoNotajTable.getColumnModel().getColumn(4).setPreferredWidth(50);
        ProdutosPedidoNotajTable.getColumnModel().getColumn(5).setResizable(false);
        ProdutosPedidoNotajTable.getColumnModel().getColumn(5).setPreferredWidth(10);
    }

    javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
    jPanel10.setLayout(jPanel10Layout);
    jPanel10Layout.setHorizontalGroup(
        jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel10Layout.createSequentialGroup()
            .addGap(90, 90, 90)
            .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 177, Short.MAX_VALUE))
        .addComponent(jScrollPane5)
        .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
    );
    jPanel10Layout.setVerticalGroup(
        jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel10Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1522, Short.MAX_VALUE)
            .addGap(18, 18, 18)
            .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
    );

    jTabbedPane2.addTab("Produtos NF-e", jPanel10);

    duplicatajTable.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {
            {null, null, null},
            {null, null, null},
            {null, null, null},
            {null, null, null}
        },
        new String [] {
            "Número", "Data Vencimento", "Valor R$"
        }
    ) {
        boolean[] canEdit = new boolean [] {
            false, false, false
        };

        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit [columnIndex];
        }
    });
    jScrollPane4.setViewportView(duplicatajTable);
    if (duplicatajTable.getColumnModel().getColumnCount() > 0) {
        duplicatajTable.getColumnModel().getColumn(0).setResizable(false);
        duplicatajTable.getColumnModel().getColumn(0).setPreferredWidth(20);
        duplicatajTable.getColumnModel().getColumn(1).setResizable(false);
        duplicatajTable.getColumnModel().getColumn(1).setPreferredWidth(20);
        duplicatajTable.getColumnModel().getColumn(2).setResizable(false);
        duplicatajTable.getColumnModel().getColumn(2).setPreferredWidth(30);
    }

    javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
    jPanel11.setLayout(jPanel11Layout);
    jPanel11Layout.setHorizontalGroup(
        jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel11Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(658, Short.MAX_VALUE))
    );
    jPanel11Layout.setVerticalGroup(
        jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel11Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 1775, Short.MAX_VALUE)
            .addContainerGap())
    );

    jTabbedPane2.addTab("Duplicatas NF-e", jPanel11);

    entradajTabbedPane.addTab("Nota Fiscal Eletrônica", jTabbedPane2);

    contasPagarjTable.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {
            {null, null, null, null, null},
            {null, null, null, null, null},
            {null, null, null, null, null},
            {null, null, null, null, null}
        },
        new String [] {
            "Nº Conta", "Data Conta", "Cedente", "Data Vencimento", "Valor Conta"
        }
    ));
    contasPagarjTable.getTableHeader().setReorderingAllowed(false);
    contasPagarjTable.getColumnModel().getColumn(0).setPreferredWidth(30);
    contasPagarjTable.getColumnModel().getColumn(1).setPreferredWidth(30);
    contasPagarjTable.getColumnModel().getColumn(2).setPreferredWidth(300);
    contasPagarjTable.getColumnModel().getColumn(3).setPreferredWidth(30);
    contasPagarjTable.getColumnModel().getColumn(4).setPreferredWidth(30);
    contasPagarjTable.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            contasPagarjTableMouseClicked(evt);
        }
    });
    contasPagarjTable.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyPressed(java.awt.event.KeyEvent evt) {
            contasPagarjTableKeyPressed(evt);
        }
    });
    vencidasjScrollPane.setViewportView(contasPagarjTable);

    jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

    jLabel16.setText("Valor Total a Pagar");

    valorTotalContasPagarjTextField.setEditable(false);
    valorTotalContasPagarjTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

    jLabel40.setText("Boletos Entregues");

    boletojComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "NAO", "SIM" }));

    jLabel42.setText("Tipo de Pagamento");

    tipoPagamentojComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Boleto", "Carteira", "Cheque", "Debito Conta" }));

    javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
    jPanel7.setLayout(jPanel7Layout);
    jPanel7Layout.setHorizontalGroup(
        jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel7Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel16)
                        .addComponent(valorTotalContasPagarjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(boletojComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jLabel42)
                .addComponent(tipoPagamentojComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addContainerGap(83, Short.MAX_VALUE))
    );
    jPanel7Layout.setVerticalGroup(
        jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel7Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel16)
                .addComponent(jLabel40))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(valorTotalContasPagarjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(boletojComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addComponent(jLabel42)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(tipoPagamentojComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(67, Short.MAX_VALUE))
    );

    jPanel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());

    jLabel43.setText("Nº Documento");

    numeroDocumentojTextField.addFocusListener(new java.awt.event.FocusAdapter() {
        public void focusLost(java.awt.event.FocusEvent evt) {
            numeroDocumentojTextFieldFocusLost(evt);
        }
    });

    dataVencimentojDateChooser.addFocusListener(new java.awt.event.FocusAdapter() {
        public void focusGained(java.awt.event.FocusEvent evt) {
            dataVencimentojDateChooserFocusGained(evt);
        }
    });

    jLabel44.setText("Data Vencimento");

    jLabel45.setText("Valor R$");

    valorContajTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
    valorContajTextField.addFocusListener(new java.awt.event.FocusAdapter() {
        public void focusGained(java.awt.event.FocusEvent evt) {
            valorContajTextFieldFocusGained(evt);
        }
    });
    valorContajTextField.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyPressed(java.awt.event.KeyEvent evt) {
            valorContajTextFieldKeyPressed(evt);
        }
        public void keyReleased(java.awt.event.KeyEvent evt) {
            valorContajTextFieldKeyReleased(evt);
        }
    });

    javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
    jPanel9.setLayout(jPanel9Layout);
    jPanel9Layout.setHorizontalGroup(
        jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel9Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(numeroDocumentojTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel43))
            .addGap(18, 18, 18)
            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel9Layout.createSequentialGroup()
                    .addComponent(dataVencimentojDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(valorContajTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel9Layout.createSequentialGroup()
                    .addComponent(jLabel44)
                    .addGap(37, 37, 37)
                    .addComponent(jLabel45)))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    jPanel9Layout.setVerticalGroup(
        jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel9Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel43)
                .addComponent(jLabel44)
                .addComponent(jLabel45))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(numeroDocumentojTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(dataVencimentojDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(valorContajTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap(22, Short.MAX_VALUE))
    );

    jPanel12.setBorder(javax.swing.BorderFactory.createEtchedBorder());

    jButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/tick.png"))); // NOI18N
    jButton15.setText("Registrar Conta");
    jButton15.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton15ActionPerformed(evt);
        }
    });

    jButton16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cross.png"))); // NOI18N
    jButton16.setText("Excluir Conta");
    jButton16.setToolTipText("Excluir conta já cadastrada");
    jButton16.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton16ActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
    jPanel12.setLayout(jPanel12Layout);
    jPanel12Layout.setHorizontalGroup(
        jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel12Layout.createSequentialGroup()
            .addGap(72, 72, 72)
            .addComponent(jButton15)
            .addGap(83, 83, 83)
            .addComponent(jButton16)
            .addContainerGap(87, Short.MAX_VALUE))
    );
    jPanel12Layout.setVerticalGroup(
        jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel12Layout.createSequentialGroup()
            .addContainerGap(20, Short.MAX_VALUE)
            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jButton15)
                .addComponent(jButton16))
            .addContainerGap())
    );

    javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
    jPanel6.setLayout(jPanel6Layout);
    jPanel6Layout.setHorizontalGroup(
        jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel6Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(vencidasjScrollPane)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 253, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addContainerGap())
    );
    jPanel6Layout.setVerticalGroup(
        jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel6Layout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(26, 26, 26)
            .addComponent(vencidasjScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(34, 34, 34))
    );

    entradajTabbedPane.addTab("Contas a Pagar", jPanel6);

    jPanel1.add(entradajTabbedPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 970, 530));

    jPanel15.setBorder(javax.swing.BorderFactory.createEtchedBorder());

    jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/tick.png"))); // NOI18N
    jButton10.setText("Confirma Compras");
    jButton10.setToolTipText("Confirma Registro de Compras");
    jButton10.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton10ActionPerformed(evt);
        }
    });

    jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cross.png"))); // NOI18N
    jButton11.setText("Cancela Compras");
    jButton11.setToolTipText("Cancela Registro de Compras");
    jButton11.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton11ActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
    jPanel15.setLayout(jPanel15Layout);
    jPanel15Layout.setHorizontalGroup(
        jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel15Layout.createSequentialGroup()
            .addGap(253, 253, 253)
            .addComponent(jButton10)
            .addGap(147, 147, 147)
            .addComponent(jButton11)
            .addContainerGap(290, Short.MAX_VALUE))
    );
    jPanel15Layout.setVerticalGroup(
        jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel15Layout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jButton10)
                .addComponent(jButton11))
            .addContainerGap())
    );

    jPanel1.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 540, 970, 50));

    getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 980, 600));

    jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F12, 0));
    jMenuItem2.setText("Consultar Produto");
    jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMenuItem2ActionPerformed(evt);
        }
    });
    jMenu1.add(jMenuItem2);

    jMenuBar1.add(jMenu1);

    setJMenuBar(jMenuBar1);

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void gerarRecibojButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gerarRecibojButtonActionPerformed
       ParametroLocalController parametroLocalController = new ParametroLocalController();
       ParametrosLocal parametros = new ParametrosLocal();
       parametros.setIdparametros(1);
       parametros = parametroLocalController.localizarEmpresa(config.getEmpresa().getIdparametros());
        int codigo=0;
        if (parametros!=null){
            codigo = parametros.getNumeroReciboEntrada();
            codigo = codigo + 1;
            numerojTextField.setText(String.valueOf(codigo));
            parametros.setNumeroReciboEntrada(codigo);
            parametroLocalController.salvar(parametros);
        }

}//GEN-LAST:event_gerarRecibojButtonActionPerformed

    private void dataEntradajDateChooserFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dataEntradajDateChooserFocusGained

}//GEN-LAST:event_dataEntradajDateChooserFocusGained

    private void dataSaidajDateChooserFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dataSaidajDateChooserFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_dataSaidajDateChooserFocusGained

    private void dataEmissaojDateChooserFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dataEmissaojDateChooserFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_dataEmissaojDateChooserFocusGained

    private void carregarjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carregarjButtonActionPerformed
        if (caminhojTextField.getText().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "Selecione o arquivo.");
        } else {
            try {
                this.nfe = new LerXml200(caminhojTextField.getText(), this);
                try {
                    this.nfe.lerNotaFiscal();
                } catch (ParseException ex) {
                    Logger.getLogger(FrmEntrada.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    this.nfe.lerFornecedor();
                } catch (Exception ex) {
                    Logger.getLogger(FrmEntrada.class.getName()).log(Level.SEVERE, null, ex);
                }
                this.nfe.lerProdutos();
                try {
                    this.nfe.lerDuplicatas();
                } catch (ParseException ex) {
                    Logger.getLogger(FrmEntrada.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (ParserConfigurationException ex) {
                Logger.getLogger(FrmEntrada.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SAXException ex) {
                Logger.getLogger(FrmEntrada.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(FrmEntrada.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_carregarjButtonActionPerformed

    private void limparjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparjButtonActionPerformed
        caminhojTextField.setText("");
    }//GEN-LAST:event_limparjButtonActionPerformed

    private void localizarjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_localizarjButtonActionPerformed
       new FrmLocalizarArquivo(this);
    }//GEN-LAST:event_localizarjButtonActionPerformed

    private void codigojTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codigojTextFieldKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            String cp = codigojTextField.getText();
            if (cp.length()>6){
                cp = localizarcodgioBarras(cp);
                if (cp!=null){
                    codigojTextField.setText(cp);
                    localizarProdoutoCodigo(codigojTextField.getText());
                }else{
                    JOptionPane.showMessageDialog(rootPane, "Produto não Localizado");
                    codigojTextField.requestFocus();
                    codigojTextField.selectAll();
                }
            }else {
                localizarProdoutoCodigo(codigojTextField.getText());
            }
        }
        if (evt.getKeyCode() == evt.VK_F2) {
             new FrmConsultaProdutos(this, config, true);
        }
    }//GEN-LAST:event_codigojTextFieldKeyPressed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        cancelarconfirmarProduto();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
       if (produtosjTable.getSelectedRowCount()>=0){
           int linha = produtosjTable.getSelectedRow();
           if (entradaEstoque.getListaProdutos().get(linha).getEntradaproduto().getIdEntradaProduto()!=null){
               EntradaProdutoController entradaController = new EntradaProdutoController();
               entradaController.excluirProdutoEntrada(entradaEstoque.getListaProdutos().get(linha).getEntradaproduto());
           }
           entradaEstoque.getListaProdutos().get(linha).setExcluido(true);
           entradaEstoque.calcularTotais();
           valorTotalProdutosjTextField.setText(Formatacao.foramtarDoubleString(entradaEstoque.getValorProdutos()));
           valorTotalEncargosjTextField.setText(Formatacao.foramtarDoubleString(entradaEstoque.getValorEncargos()));
           valorTotalNotajTextField.setText(Formatacao.foramtarDoubleString(entradaEstoque.getValorTotal()));
           linhaAlterar = linha;
           organizarListaProdutos();
       }else JOptionPane.showMessageDialog(null, "Selecione um porduto da lista");
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        //Alterar Estoque
        boolean resultado = JOptionPane.showConfirmDialog(null, "Alterar Situação para Reposição?", "Atenção", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == 0;
        if (resultado){
            this.entradaEstoque.getDocEntrada().setSituacao("Reposição");
        }else {
            this.entradaEstoque.getDocEntrada().setSituacao("Movimento");
        }
        setDocEntrada();
        EntradaProdutoController entradaProdutoController = new EntradaProdutoController();
        entradaProdutoController.salvarDocEntrada(entradaEstoque.getDocEntrada());
        if (entradaEstoque.getDocEntrada().getIdDocEntrada()==null){
            entradaEstoque.setDocEntrada(entradaProdutoController.consultarDocEntrada());
        }
        entradaEstoque.getNotaFiscal().setDocentrada(entradaEstoque.getDocEntrada().getIdDocEntrada());
        entradaProdutoController.salvarEntradaNF(entradaEstoque.getNotaFiscal());
        EstoqueController estoqueController = new EstoqueController();
        VinculoController vinculoController = new VinculoController();
        for (int i = 0; i < entradaEstoque.getListaProdutos().size(); i++) {
            if (!entradaEstoque.getListaProdutos().get(i).isEstoqueAdicionado()) {
                if (!(entradaEstoque.getListaProdutos().get(i).isExcluido())) {
                    if (entradaEstoque.getListaProdutos().get(i).getVinculo() != null) {
                        entradaEstoque.getListaProdutos().get(i).getVinculo().setEmpresa(this.config.getEmpresa().getIdempresa());
                        vinculoController.salvarVinculo(entradaEstoque.getListaProdutos().get(i).getVinculo());
                    }
                    entradaEstoque.getListaProdutos().get(i).getEntradaproduto().setDocentrada(entradaEstoque.getDocEntrada().getIdDocEntrada());
                    entradaProdutoController.salvarProdutoEntrada(entradaEstoque.getListaProdutos().get(i).getEntradaproduto());
                    entradaEstoque.getListaProdutos().get(i).getEstoque().setDataEntrada(entradaEstoque.getDocEntrada().getDataEntrada());
                    if (entradaEstoque.getDocEntrada().getTipoDocumento().equalsIgnoreCase("Nota Fiscal")) {
                        estoqueController.entradaEstoque(entradaEstoque.getListaProdutos().get(i).getEntradaproduto().getQuantidade(), entradaEstoque.getListaProdutos().get(i).getEstoque(), this.config.getEmpresa().getIdempresa(), true, entradaEstoque.getListaProdutos().get(i).getEntradaproduto().getValorCusto());
                    } else {
                        estoqueController.entradaEstoque(entradaEstoque.getListaProdutos().get(i).getEntradaproduto().getQuantidade(), entradaEstoque.getListaProdutos().get(i).getEstoque(), this.config.getEmpresa().getIdempresa(), false, entradaEstoque.getListaProdutos().get(i).getEntradaproduto().getValorCusto());
                    }
                    if (entradaEstoque.getListaProdutos().get(i).getEntradaproduto().getValorST() > 0) {
                        ProdutoController produtoController = new ProdutoController();
                        Produto produtoSt = new Produto();
                        produtoSt = produtoController.consultarProdutoReferencia(entradaEstoque.getListaProdutos().get(i).getProduto().getReferencia());
                        if (produtoSt != null) {
                            AliquotaFacade aliquotaFacade = new AliquotaFacade();
                            Aliquota aliquota = null;
                            try {
                                aliquota = aliquotaFacade.buscarAliquotaDescricao("ST");
                            } catch (SQLException ex) {
                                Logger.getLogger(FrmEntrada.class.getName()).log(Level.SEVERE, null, ex);
                                JOptionPane.showMessageDialog(rootPane, "Erro Conusltar Aliquota " + ex);
                            }
                            produtoSt.setAliquota(aliquota.getIdaliquota());
                            produtoController.salvarProduto(produtoSt);
                        }

                    }
                    CustoProduto custoProduto = new CustoProduto();
                    CustoProdutoController custoProdutoController = new CustoProdutoController();
                    custoProduto = custoProdutoController.getCustoProduto(entradaEstoque.getListaProdutos().get(i).getProduto().getIdProduto(), this.config.getEmpresa().getIdempresa());
                    double valorST = 0;
                    if (entradaEstoque.getListaProdutos().get(i).getEntradaproduto().getValorST() > 0) {
                        valorST = entradaEstoque.getListaProdutos().get(i).getEntradaproduto().getValorST();
                        valorST = valorST / entradaEstoque.getListaProdutos().get(i).getEntradaproduto().getQuantidade();
                    } else {
                        valorST = 0;
                    }
                    if (custoProduto != null) {
                        if (custoProduto.getValorST() < valorST) {
                            custoProduto.setValorST(valorST);
                        }
                    } else {
                        custoProduto = new CustoProduto();
                        custoProduto.setEmpresa(this.config.getEmpresa().getIdempresa());
                        custoProduto.setProduto(entradaEstoque.getListaProdutos().get(i).getProduto().getIdProduto());
                        custoProduto.setValorST(valorST);
                    }
                    custoProdutoController.salvar(custoProduto);
                }
                entradaEstoque.getListaProdutos().get(i).setEstoqueAdicionado(true);
            }
        }
        registarContasPagar();
        marcarPedidosProduto();
        if (listaAlterar.size() > 0) {
            AlterarQuantidadeEstoque();
        }

        JOptionPane.showMessageDialog(null, "Entrada Confirmada");
        this.dispose();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        if (validarConfirmaProduto()) {
            
            //Setar dados Estoque
            if (listaProdutoEntrada.getEstoque()==null){
                listaProdutoEntrada.setEstoque(new Estoque());
                listaProdutoEntrada.getEstoque().setPercentualVendas(0.0);
                listaProdutoEntrada.getEstoque().setQuantidadeEstoque(0.0);
                listaProdutoEntrada.getEstoque().setProduto(listaProdutoEntrada.getProduto().getIdProduto());
                listaProdutoEntrada.getEstoque().setValorVenda(0.0f);
                listaProdutoEntrada.getEstoque().setEmpresa(this.config.getEmpresa().getIdempresa());                
            }
            listaProdutoEntrada.getEstoque().setValorVenda(Formatacao.formatarStringfloat(valorVendajTextField.getText()));
            listaProdutoEntrada.getEstoque().setPercentualVendas(Formatacao.ConvercaoMonetariaDouble(percentualVendajTextField.getText()));
//            double vc = calcularValorCusto(listaProdutoEntrada.getEstoque().getValorCusto(), Formatacao.ConvercaoMonetariaDouble(custojTextField.getText()));
//            listaProdutoEntrada.getEstoque().setValorCusto(vc);
            listaProdutoEntrada.getEstoque().setDataCompra(entradaEstoque.getDocEntrada().getDataEntrada());
            listaProdutoEntrada.getEstoque().setValorCompra(Formatacao.ConvercaoMonetariaDouble(unitariojTextField.getText()));


            //Setar vinculo
            if (listaProdutoEntrada.getVinculo() == null) {
                listaProdutoEntrada.setVinculo(new Vinculo());
                listaProdutoEntrada.getVinculo().setEmbalagem(0L);
                listaProdutoEntrada.getEstoque().setValorCusto(0.0);
                listaProdutoEntrada.getEstoque().setEmpresa(config.getEmpresa().getIdempresa());
            }
            if (!codigoFabricantejTextField.getText().equalsIgnoreCase("")) {
                listaProdutoEntrada.getVinculo().setCodigoFabricante(codigoFabricantejTextField.getText());
            }
            listaProdutoEntrada.getVinculo().setDataCompra(dataEntradajDateChooser.getDate());
            if (!embalagemjTextField.getText().equalsIgnoreCase("")) {
                int embalagem = Integer.parseInt(embalagemjTextField.getText());
                long emb = embalagem;
                listaProdutoEntrada.getVinculo().setEmbalagem(emb);
            } else {
                listaProdutoEntrada.getVinculo().setEmbalagem((long) 0);
            }
            listaProdutoEntrada.getVinculo().setFornecedor(entradaEstoque.getFornecedor().getIdfornecedor());
            listaProdutoEntrada.getVinculo().setProduto(listaProdutoEntrada.getProduto().getIdProduto());
            listaProdutoEntrada.getVinculo().setValorCompra(Formatacao.formatarStringfloat(custojTextField.getText()));

            //setar Custo
            
            if ((icmsjTextField.getText().equalsIgnoreCase( "ST")) || (icmsjTextField.getText().equalsIgnoreCase("FF"))){
                listaProdutoEntrada.getEntradaproduto().setAliquitaICMS(0.0);
            }else {
                listaProdutoEntrada.getEntradaproduto().setAliquitaICMS(0.0);
            }
            if (listaProdutoEntrada.getValorVenda() != null) {
                String situacaoValor = verificarAlteracaoValorVenda(listaProdutoEntrada.getValorVenda(), listaProdutoEntrada.getEstoque().getValorVenda());
                listaProdutoEntrada.getEntradaproduto().setPreco(situacaoValor);
            }else listaProdutoEntrada.getEntradaproduto().setPreco("+");
            listaProdutoEntrada.getEntradaproduto().setProduto(listaProdutoEntrada.getProduto().getIdProduto());
            listaProdutoEntrada.getEntradaproduto().setQuantdadeAtual(Formatacao.ConvercaoMonetariaDouble(estoqueAtualjTextField.getText()));
            listaProdutoEntrada.getEntradaproduto().setQuantiaddeAnterior(Formatacao.ConvercaoMonetariaDouble(estoqueAtualjTextField.getText()));
            listaProdutoEntrada.getEntradaproduto().setQuantidade(Formatacao.ConvercaoMonetariaDouble(quantidadejTextField.getText()));
            listaProdutoEntrada.getEntradaproduto().setQuantdadeAtual(listaProdutoEntrada.getEntradaproduto().getQuantdadeAtual() + listaProdutoEntrada.getEntradaproduto().getQuantidade());
            listaProdutoEntrada.getEntradaproduto().setValorCusto(Formatacao.ConvercaoMonetariaFloat(custojTextField.getText()));
            listaProdutoEntrada.getEntradaproduto().setValorIPI(Formatacao.ConvercaoMonetariaFloat(ipijTextField.getText()));
            listaProdutoEntrada.getEntradaproduto().setValorST(Formatacao.ConvercaoMonetariaFloat(stjTextField.getText()));
            listaProdutoEntrada.getEntradaproduto().setValorTotal(Formatacao.ConvercaoMonetariaFloat(totalUnitariojTextField.getText()));
            listaProdutoEntrada.getEntradaproduto().setValorTotalCusto(Formatacao.ConvercaoMonetariaFloat(totalCustojTextField.getText()));
            listaProdutoEntrada.getEntradaproduto().setValorUnitario(Formatacao.ConvercaoMonetariaFloat(unitariojTextField.getText()));
            listaProdutoEntrada.getEntradaproduto().setValorICMS(0.00f);
            
            entradaEstoque.calcularTotais();
            valorTotalProdutosjTextField.setText(Formatacao.foramtarDoubleString(entradaEstoque.getValorProdutos()));
            valorTotalEncargosjTextField.setText(Formatacao.foramtarDoubleString(entradaEstoque.getValorEncargos()));
            valorTotalNotajTextField.setText(Formatacao.foramtarDoubleString(entradaEstoque.getValorTotal()));
            if (linhaAlterar>-1){
               if (entradaEstoque.getListaProdutos().get(linhaAlterar).getEntradaproduto().getIdEntradaProduto()!=null){
                  EntradaProdutoController entradaController = new EntradaProdutoController();
                  entradaController.excluirProdutoEntrada(entradaEstoque.getListaProdutos().get(linhaAlterar).getEntradaproduto());
               }
            }
            organizarListaProdutos();
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void unitariojTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_unitariojTextFieldFocusGained
        unitariojTextField.selectAll();
    }//GEN-LAST:event_unitariojTextFieldFocusGained

    private void unitariojTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_unitariojTextFieldFocusLost
        double quantidade = Formatacao.ConvercaoMonetariaDouble(quantidadejTextField.getText());
        if (quantidade==0.0){
            JOptionPane.showMessageDialog(null, " Quantidade não pode ser Valor Zero");
        }else {
            CalcularValoresEntrada();
        }
    }//GEN-LAST:event_unitariojTextFieldFocusLost

    private void valorEncargosjTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_valorEncargosjTextFieldKeyReleased
        valorEncargosjTextField.setText(Formatacao.decinalValorMonetario(valorEncargosjTextField.getText()));
    }//GEN-LAST:event_valorEncargosjTextFieldKeyReleased

    private void valorDescontojTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_valorDescontojTextFieldKeyReleased
        valorDescontojTextField.setText(Formatacao.decinalValorMonetario(valorDescontojTextField.getText()));
    }//GEN-LAST:event_valorDescontojTextFieldKeyReleased

    private void valorProdutosjTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_valorProdutosjTextFieldKeyReleased
        valorProdutosjTextField.setText(Formatacao.decinalValorMonetario(valorProdutosjTextField.getText()));
    }//GEN-LAST:event_valorProdutosjTextFieldKeyReleased

    private void quantidadejTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_quantidadejTextFieldKeyReleased
       quantidadejTextField.setText(Formatacao.decinalValorMonetario(quantidadejTextField.getText()));
    }//GEN-LAST:event_quantidadejTextFieldKeyReleased

    private void icmsjTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_icmsjTextFieldKeyReleased
        icmsjTextField.setText(Formatacao.decinalValorMonetario(icmsjTextField.getText()));
    }//GEN-LAST:event_icmsjTextFieldKeyReleased

    private void ipijTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ipijTextFieldKeyReleased
        ipijTextField.setText(Formatacao.decinalValorMonetario(ipijTextField.getText()));
    }//GEN-LAST:event_ipijTextFieldKeyReleased

    private void stjTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_stjTextFieldKeyReleased
        stjTextField.setText(Formatacao.decinalValorMonetario(stjTextField.getText()));
    }//GEN-LAST:event_stjTextFieldKeyReleased

    private void unitariojTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_unitariojTextFieldKeyReleased
        unitariojTextField.setText(Formatacao.decinalValorMonetario(unitariojTextField.getText()));
    }//GEN-LAST:event_unitariojTextFieldKeyReleased

    private void percentualVendajTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_percentualVendajTextFieldKeyReleased
        percentualVendajTextField.setText(Formatacao.decinalValorMonetario(percentualVendajTextField.getText()));
    }//GEN-LAST:event_percentualVendajTextFieldKeyReleased

    private void valorVendajTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_valorVendajTextFieldKeyReleased
        valorVendajTextField.setText(Formatacao.decinalValorMonetario(valorVendajTextField.getText()));
    }//GEN-LAST:event_valorVendajTextFieldKeyReleased

    private void controlejButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_controlejButtonActionPerformed
        

    }//GEN-LAST:event_controlejButtonActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        new FrmAlterarValorVenda(listaProdutoEntrada.getEstoque(), this, Formatacao.ConvercaoMonetariaDouble(custojTextField.getText()));
        
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        if (listaAlterar.size()>0){
            EntradaProdutoController entradaProdutoController = new EntradaProdutoController();
            for(int i=0;i<listaAlterar.size();i++){
                entradaProdutoController.salvarProdutoEntrada(listaAlterar.get(i).getEntradaproduto());
            }
        }
        this.dispose();
    }//GEN-LAST:event_jButton11ActionPerformed

    private void entradajTabbedPanePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_entradajTabbedPanePropertyChange
       
    }//GEN-LAST:event_entradajTabbedPanePropertyChange

    private void entradajTabbedPaneStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_entradajTabbedPaneStateChanged
        if (entradajTabbedPane.getSelectedIndex() == 1) {
            if (this.entradaEstoque.getDocEntrada().getEmpresa()==0) {
                entradaEstoque.getNotaFiscal().setDataEmissao(dataEmissaojDateChooser.getDate());
                entradaEstoque.getNotaFiscal().setDataSaida(dataSaidajDateChooser.getDate());
                entradaEstoque.getNotaFiscal().setEspecie((String) especiejComboBox.getSelectedItem());
                entradaEstoque.getNotaFiscal().setNumero(numerojTextField.getText());
                entradaEstoque.getNotaFiscal().setSerie(seriejTextField.getText());
                entradaEstoque.getNotaFiscal().setSubSerie(subSeriejTextField.getText());
                entradaEstoque.getNotaFiscal().setValorProdutos(Formatacao.ConvercaoMonetariaFloat(valorProdutosjTextField.getText()));
                entradaEstoque.getNotaFiscal().setValorTotal(Formatacao.ConvercaoMonetariaFloat(valorTotaljTextField.getText()));
                entradaEstoque.getDocEntrada().setEmpresa(config.getEmpresa().getIdempresa());
                entradaEstoque.getDocEntrada().setCondicaoPagamento((String) condicaoPagamentojComboBox.getSelectedItem());
                entradaEstoque.getDocEntrada().setDataEntrada(dataEntradajDateChooser.getDate());
                entradaEstoque.getDocEntrada().setFornecedor(entradaEstoque.getFornecedor().getIdfornecedor());
                entradaEstoque.getDocEntrada().setSituacao((String) situacaojComboBox.getSelectedItem());
                entradaEstoque.getDocEntrada().setTipoDocumento((String) tipoDocumentojComboBox.getSelectedItem());
                entradaEstoque.getDocEntrada().setValorDesconto(Formatacao.ConvercaoMonetariaFloat(valorDescontojTextField.getText()));
                entradaEstoque.getDocEntrada().setValorEncargos(Formatacao.ConvercaoMonetariaFloat(valorEncargosjTextField.getText()));
                entradaEstoque.getDocEntrada().setValorTotal(Formatacao.ConvercaoMonetariaFloat(valorProdutosjTextField.getText()));
            }
        }else {
            if (entradajTabbedPane.getSelectedIndex()==4){
                if (condicaoPagamentojComboBox.getSelectedItem().toString().equalsIgnoreCase("a Prazo")){
                   valorTotalContasPagarjTextField.setText(valorTotaljTextField.getText());
                   setModelContasPagar();
                }else {
                    JOptionPane.showMessageDialog(rootPane, "Condição diferente de A PRAZO");
                    entradajTabbedPane.setSelectedIndex(0);
                }
            }
        }
    }//GEN-LAST:event_entradajTabbedPaneStateChanged

    private void valorEncargosjTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_valorEncargosjTextFieldFocusGained
       valorEncargosjTextField.selectAll();
    }//GEN-LAST:event_valorEncargosjTextFieldFocusGained

    private void valorDescontojTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_valorDescontojTextFieldFocusLost
        
    }//GEN-LAST:event_valorDescontojTextFieldFocusLost

    private void valorProdutosjTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_valorProdutosjTextFieldFocusLost
       
    }//GEN-LAST:event_valorProdutosjTextFieldFocusLost

    private void numerojTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_numerojTextFieldFocusLost
        
    }//GEN-LAST:event_numerojTextFieldFocusLost

    private void seriejTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_seriejTextFieldFocusLost
        
    }//GEN-LAST:event_seriejTextFieldFocusLost

    private void subSeriejTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_subSeriejTextFieldFocusLost
        
    }//GEN-LAST:event_subSeriejTextFieldFocusLost

    private void valorDescontojTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_valorDescontojTextFieldFocusGained
        valorDescontojTextField.selectAll();
    }//GEN-LAST:event_valorDescontojTextFieldFocusGained

    private void valorProdutosjTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_valorProdutosjTextFieldFocusGained
        valorProdutosjTextField.selectAll();
    }//GEN-LAST:event_valorProdutosjTextFieldFocusGained

    private void numerojTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_numerojTextFieldFocusGained
        numerojTextField.selectAll();
    }//GEN-LAST:event_numerojTextFieldFocusGained

    private void seriejTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_seriejTextFieldFocusGained
        seriejTextField.selectAll();
    }//GEN-LAST:event_seriejTextFieldFocusGained

    private void subSeriejTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_subSeriejTextFieldFocusGained
        subSeriejTextField.selectAll();
    }//GEN-LAST:event_subSeriejTextFieldFocusGained

    private void codigojTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_codigojTextFieldFocusGained
        codigojTextField.selectAll();
    }//GEN-LAST:event_codigojTextFieldFocusGained

    private void quantidadejTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_quantidadejTextFieldFocusGained
        quantidadejTextField.selectAll();
    }//GEN-LAST:event_quantidadejTextFieldFocusGained

    private void icmsjTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_icmsjTextFieldFocusGained
        icmsjTextField.selectAll();
    }//GEN-LAST:event_icmsjTextFieldFocusGained

    private void ipijTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ipijTextFieldFocusGained
        ipijTextField.selectAll();
    }//GEN-LAST:event_ipijTextFieldFocusGained

    private void stjTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_stjTextFieldFocusGained
        stjTextField.selectAll();
    }//GEN-LAST:event_stjTextFieldFocusGained

    private void ProdutosPedidojTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProdutosPedidojTableMouseClicked
        
    }//GEN-LAST:event_ProdutosPedidojTableMouseClicked

    private void embalagemjTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_embalagemjTextFieldFocusGained
        embalagemjTextField.selectAll();
    }//GEN-LAST:event_embalagemjTextFieldFocusGained

    private void valorProdutosjTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valorProdutosjTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_valorProdutosjTextFieldActionPerformed

    private void valorTotaljTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valorTotaljTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_valorTotaljTextFieldActionPerformed

    private void valorTotaljTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_valorTotaljTextFieldFocusGained
        valorTotaljTextField.selectAll();
    }//GEN-LAST:event_valorTotaljTextFieldFocusGained

    private void valorTotaljTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_valorTotaljTextFieldFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_valorTotaljTextFieldFocusLost

    private void valorTotaljTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_valorTotaljTextFieldKeyReleased
        valorTotaljTextField.setText(Formatacao.decinalValorMonetario(valorTotaljTextField.getText()));
    }//GEN-LAST:event_valorTotaljTextFieldKeyReleased

    private void tipoDocumentojComboBoxFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tipoDocumentojComboBoxFocusLost
        if (tipoDocumentojComboBox.getSelectedItem().equals("Nota Fiscal")){
            numerojTextField.setEnabled(true);
            dataEmissaojDateChooser.setEnabled(true);
            dataSaidajDateChooser.setEnabled(true);
            especiejComboBox.setEnabled(true);
            seriejTextField.setEnabled(true);
            subSeriejTextField.setEnabled(true); 
            gerarRecibojButton.setEnabled(false);
        }else {
            numerojTextField.setEnabled(true);
            dataEmissaojDateChooser.setEnabled(true);
            dataSaidajDateChooser.setEnabled(false);
            especiejComboBox.setEnabled(false);
            seriejTextField.setEnabled(false);
            subSeriejTextField.setEnabled(false);
            gerarRecibojButton.setEnabled(true);
        }
    }//GEN-LAST:event_tipoDocumentojComboBoxFocusLost

    private void buscaBancojButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscaBancojButton1ActionPerformed
        new FrmConsultaProdutos(this, config, true);
}//GEN-LAST:event_buscaBancojButton1ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
       int linha = produtosjTable.getSelectedRow();
       if (linha>=0){
           linhaAlterar = -1;
           codigojTextField.setText(String.valueOf(entradaEstoque.getListaProdutos().get(linha).getProduto().getReferencia()));
           localizarProdoutoCodigo(String.valueOf(entradaEstoque.getListaProdutos().get(linha).getProduto().getReferencia()));
           codigojTextField.selectAll();
           codigojTextField.requestFocus();
           quantidadejTextField.setText(Formatacao.foramtarDoubleString(entradaEstoque.getListaProdutos().get(linha).getEntradaproduto().getQuantidade()));
           icmsjTextField.setText(Formatacao.foramtarDoubleString(entradaEstoque.getListaProdutos().get(linha).getEntradaproduto().getAliquitaICMS()));
           ipijTextField.setText(Formatacao.foramtarFloatString(entradaEstoque.getListaProdutos().get(linha).getEntradaproduto().getValorIPI()));
           stjTextField.setText(Formatacao.foramtarFloatString(entradaEstoque.getListaProdutos().get(linha).getEntradaproduto().getValorST()));
           unitariojTextField.setText(Formatacao.foramtarFloatString(entradaEstoque.getListaProdutos().get(linha).getEntradaproduto().getValorUnitario()));
           custojTextField.setText(Formatacao.foramtarFloatString(entradaEstoque.getListaProdutos().get(linha).getEntradaproduto().getValorCusto()));
           totalUnitariojTextField.setText(Formatacao.foramtarFloatString(entradaEstoque.getListaProdutos().get(linha).getEntradaproduto().getValorTotal()));
           totalCustojTextField.setText(Formatacao.foramtarFloatString(entradaEstoque.getListaProdutos().get(linha).getEntradaproduto().getValorTotalCusto()));
           linhaAlterar = linha;
           entradaEstoque.getListaProdutos().get(linha).setExcluido(true);
       }else JOptionPane.showMessageDialog(null, "Selecione um Produto");
    }//GEN-LAST:event_jButton9ActionPerformed

    private void buscaBancojButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscaBancojButton3ActionPerformed
       new FrmConsultaFornecedor(this);
    }//GEN-LAST:event_buscaBancojButton3ActionPerformed

    private void codigoFabricantejTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_codigoFabricantejTextFieldFocusLost
        embalagemjTextField.requestFocus();
    }//GEN-LAST:event_codigoFabricantejTextFieldFocusLost

private void quantidadejTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_quantidadejTextFieldFocusLost
    
}//GEN-LAST:event_quantidadejTextFieldFocusLost

private void embalagemjTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_embalagemjTextFieldFocusLost
    quantidadejTextField.requestFocus();
}//GEN-LAST:event_embalagemjTextFieldFocusLost

private void icmsjTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_icmsjTextFieldFocusLost
    if (icmsjTextField.getText().equalsIgnoreCase("")){
        icmsjTextField.setText("0,00");
    }
}//GEN-LAST:event_icmsjTextFieldFocusLost

private void ipijTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ipijTextFieldFocusLost
    if (ipijTextField.getText().equalsIgnoreCase("")){
        ipijTextField.setText("0,00");
    }
}//GEN-LAST:event_ipijTextFieldFocusLost

private void stjTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_stjTextFieldFocusLost
    if (stjTextField.getText().equalsIgnoreCase("")){
        stjTextField.setText("0,00");
    }
}//GEN-LAST:event_stjTextFieldFocusLost

private void codigojTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_codigojTextFieldFocusLost
    
}//GEN-LAST:event_codigojTextFieldFocusLost

private void codigoFabricantejTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_codigoFabricantejTextFieldFocusGained
    embalagemjTextField.selectAll();
}//GEN-LAST:event_codigoFabricantejTextFieldFocusGained

private void codigoFabricantejTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codigoFabricantejTextFieldKeyPressed
    if (evt.getKeyCode() == evt.VK_TAB) {
        embalagemjTextField.requestFocus();
    }
}//GEN-LAST:event_codigoFabricantejTextFieldKeyPressed

private void embalagemjTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_embalagemjTextFieldKeyPressed
    if (evt.getKeyCode() == KeyEvent.VK_TAB) {
        quantidadejTextField.requestFocus();
    }
}//GEN-LAST:event_embalagemjTextFieldKeyPressed

private void quantidadejTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_quantidadejTextFieldKeyPressed
    if (evt.getKeyCode() == KeyEvent.VK_TAB) {
        double quantidade = Formatacao.ConvercaoMonetariaDouble(quantidadejTextField.getText());
        if (quantidade == 0.0) {
            JOptionPane.showMessageDialog(null, " Quantidade n~ao pode ser Valor Zero");
        }
    }
}//GEN-LAST:event_quantidadejTextFieldKeyPressed

private void codigojTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codigojTextFieldKeyReleased
    if (evt.getKeyCode() == KeyEvent.VK_TAB) {  
        codigoFabricantejTextField.requestFocus();
    }
}//GEN-LAST:event_codigojTextFieldKeyReleased

    private void fornecedorjTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fornecedorjTextFieldKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_F2) {
            new FrmConsultaFornecedor(this);
        }
    }//GEN-LAST:event_fornecedorjTextFieldKeyPressed

    private void situacaojComboBoxFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_situacaojComboBoxFocusLost
        numerojTextField.requestFocus();
    }//GEN-LAST:event_situacaojComboBoxFocusLost

    private void valorVendajTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_valorVendajTextFieldKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jButton6ActionPerformed(null);
        }
    }//GEN-LAST:event_valorVendajTextFieldKeyPressed

    private void ProdutosPedidojTableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ProdutosPedidojTableKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jButton5ActionPerformed(null);
        }
    }//GEN-LAST:event_ProdutosPedidojTableKeyPressed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        int linha = ProdutosPedidojTable.getSelectedRow();
        if (linha >= 0) {
            boolean resultado = true;
            if (listaPedidoProduto.get(linha).getEntrada() == 1) {
                resultado = JOptionPane.showConfirmDialog(null, "Produto já Registrado. Registrar Novamente?", "Atenção", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == 0;
            }
            if (resultado) {
                entradajTabbedPane.setSelectedIndex(1);
                Produto produto = localizarProduto(listaPedidoProduto.get(linha).getProduto());
                int ref = produto.getReferencia();
                String codigo = String.valueOf(ref);
                codigojTextField.setText(codigo);
                ProdutosPedidojTable.repaint();
                localizarProdoutoCodigo(codigo);
                Forpedproduto pedtemp = listaPedidoProduto.get(linha);
                pedtemp.setEntrada(1);
                salvarPedidoProduto(pedtemp);
                setForPedido(this.forPediddo);
                codigoFabricantejTextField.requestFocus();
                codigoFabricantejTextField.selectAll();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um Produto");
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void naoRegistradosjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_naoRegistradosjButtonActionPerformed
        todosRegistradosjButton.setEnabled(true);
        naoRegistradosjButton.setEnabled(false);
        carregarDadosPedidoFornnecedor(0);
    }//GEN-LAST:event_naoRegistradosjButtonActionPerformed

    private void todosRegistradosjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_todosRegistradosjButtonActionPerformed
        naoRegistradosjButton.setEnabled(true);
        todosRegistradosjButton.setEnabled(false);
        carregarDadosPedidoFornnecedor(1);
    }//GEN-LAST:event_todosRegistradosjButtonActionPerformed

    private void custojTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_custojTextFieldFocusLost
        valorVendajTextField.requestFocus();
        valorVendajTextField.selectAll();
    }//GEN-LAST:event_custojTextFieldFocusLost

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ForPedidoController forPedidoController = new ForPedidoController();
        this.forPediddo.setRegistrado("SIM");
        this.forPediddo.setDataRegistro(new Date());
        forPedidoController.salvarForPedido(forPediddo);
        EstoqueController estoqueController = new EstoqueController();
        for (int i=0;i<listaPedidoProduto.size();i++){
            Estoque estoque = new Estoque();
            estoque = estoqueController.consultarEstoque(listaPedidoProduto.get(i).getProduto(), this.config.getEmpresa().getIdempresa());
            if (estoque!=null){
                estoque.setDataPedido(Formatacao.ConvercaoStringData("01/01/2000"));
                estoque.setDataPrevisao(Formatacao.ConvercaoStringData("01/01/2000"));
                estoque.setDataEntrada(Formatacao.ConvercaoStringData("01/01/2000"));
                estoqueController.salvarEstoque(estoque);
            } 
        }
        JOptionPane.showMessageDialog(null, "Pedido REgistrado com Sucesso");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if (!(entradaEstoque.getFornecedor().getIdfornecedor() == null)) {
            ForPedidoFacade forPedidoFacade = new ForPedidoFacade();
            List<Forpedido> listaPedido = new ArrayList<Forpedido>();
            Forpedido forPedido = new Forpedido();
            try {
                listaPedido = forPedidoFacade.consultarForPedidoUltimo(entradaEstoque.getFornecedor().getIdfornecedor(), this.config.getEmpresa().getIdempresa());
                if (listaPedido != null) {
                    if (listaPedido.size() > 0) {
                        new FrmConsultaForPedido(config, listaPedido, this);
                    } else {
                        JOptionPane.showMessageDialog(null, "Não Existem Pedido");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Não Existem Pedido");
                }
            } catch (SQLException ex) {
                Logger.getLogger(FrmEntrada.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione Fornecedor");
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void contasPagarjTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_contasPagarjTableMouseClicked

   }//GEN-LAST:event_contasPagarjTableMouseClicked

    private void contasPagarjTableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_contasPagarjTableKeyPressed
       

    }//GEN-LAST:event_contasPagarjTableKeyPressed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        String mensagemErro = null;
        mensagemErro = validarContasPagar();
        if (mensagemErro == null) {
            Contaspagar conta = new Contaspagar();
            String boleto = boletojComboBox.getSelectedItem().toString();
            if (boleto.equalsIgnoreCase("NAO")) {
                conta.setBoletoEntregue(0);
            } else {
                conta.setBoletoEntregue(1);
            }
            conta.setCredor(this.entradaEstoque.getFornecedor().getRazaoSocial());
            conta.setDataLancamento(new Date());
            conta.setDataVencimento(dataVencimentojDateChooser.getDate());
            conta.setEmpresa(this.config.getEmpresa().getIdempresa());
            conta.setIdFornecedor(this.entradaEstoque.getFornecedor().getIdfornecedor());
            conta.setNumeroDocumento(numeroDocumentojTextField.getText());
            conta.setPagamentocontaspagar(1);
            conta.setPlanoconta(configuracao.getContafornecedor());
            conta.setTipoPagamento(tipoPagamentojComboBox.getSelectedItem().toString());
            conta.setValorConta(Formatacao.ConvercaoMonetariaDouble(valorContajTextField.getText()));
            conta.setValorParcial(0.0);
            conta.setEmpresa(this.config.getEmpresa().getIdempresa());

            int dia = Formatacao.gerarDiaSemana(conta.getDataVencimento());
            if (dia == 1) {
                conta.setDataReal(Formatacao.SomarDiasData(conta.getDataVencimento(), 1));
            } else if (dia == 7) {
                conta.setDataReal(Formatacao.SomarDiasData(conta.getDataVencimento(), 2));
            } else {
                conta.setDataReal(conta.getDataVencimento());
            }
            String data = Formatacao.ConvercaoDataPadrao(conta.getDataVencimento()) + "0";
            String mes = data.substring(3, 10);
            conta.setMes(mes);
            listaContasPagar.add(conta);

            numeroDocumentojTextField.setText("");
            dataVencimentojDateChooser.setDate(null);
            valorContajTextField.setText(Formatacao.foramtarDoubleString(CalcularValorContasPagar()));
            numeroDocumentojTextField.requestFocus();
            setModelContasPagar();
        } else {
            JOptionPane.showMessageDialog(rootPane, mensagemErro);
        }
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        int linha = contasPagarjTable.getSelectedRow();
        if (listaContasPagar.size()==1){
            listaContasPagar = new ArrayList<Contaspagar>();
            valorContajTextField.setText(Formatacao.foramtarDoubleString(CalcularValorContasPagar()));
        }else if (linha>0){
            listaContasPagar.remove(linha);
            valorContajTextField.setText(Formatacao.foramtarDoubleString(CalcularValorContasPagar()));
        }
        setModelContasPagar();
    }//GEN-LAST:event_jButton16ActionPerformed

    private void valorContajTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_valorContajTextFieldKeyReleased
        valorContajTextField.setText(Formatacao.decinalValorMonetario(valorContajTextField.getText()));
    }//GEN-LAST:event_valorContajTextFieldKeyReleased

    private void valorContajTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_valorContajTextFieldFocusGained
        valorContajTextField.selectAll();
    }//GEN-LAST:event_valorContajTextFieldFocusGained

    private void dataVencimentojDateChooserFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dataVencimentojDateChooserFocusGained
        dataVencimentojDateChooser.setDate(null);
        dataVencimentojDateChooser.cleanup();
    }//GEN-LAST:event_dataVencimentojDateChooserFocusGained

    private void numeroDocumentojTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_numeroDocumentojTextFieldFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_numeroDocumentojTextFieldFocusLost

    private void valorContajTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_valorContajTextFieldKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            jButton15ActionPerformed(null);
        }
    }//GEN-LAST:event_valorContajTextFieldKeyPressed

    private void ncmjTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ncmjTextFieldKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            ProdutoController produtoController = new ProdutoController();
            Produto prodNCM = produtoController.consultarProdutoReferencia(Integer.parseInt(codigojTextField.getText()));
            if (ncmjTextField.getText().length()==8){
                prodNCM.setNcm(ncmjTextField.getText());
                prodNCM = produtoController.salvarProduto(prodNCM);
            }else {
                JOptionPane.showMessageDialog(rootPane, "NCM Inválido");
                ncmjTextField.setText(prodNCM.getNcm());
                ncmjTextField.selectAll();
                ncmjTextField.requestFocus();
            }
        }
    }//GEN-LAST:event_ncmjTextFieldKeyPressed

    private void ProdutosNFEjTableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ProdutosNFEjTableKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (linhaNota>=0 && linhaPedido>=0){
                produto =null;
                localizarProdutoNFE();
            }else {
                if (linhaNota>=0 && this.produto!=null){
                    localizarProdutoNFE();
                }
               JOptionPane.showMessageDialog(rootPane, "Selecione os produtos");
            }
        }
    }//GEN-LAST:event_ProdutosNFEjTableKeyPressed

    private void ProdutosPedidoNotajTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProdutosPedidoNotajTableMouseClicked
        linhaPedido = ProdutosPedidoNotajTable.getSelectedRow();
    }//GEN-LAST:event_ProdutosPedidoNotajTableMouseClicked

    private void ProdutosPedidoNotajTableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ProdutosPedidoNotajTableKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (linhaNota>=0 && linhaPedido>=0){
                produto=null;
                localizarProdutoNFE();
            }else {
               JOptionPane.showMessageDialog(rootPane, "Selecione os produtos");
            }
        }
    }//GEN-LAST:event_ProdutosPedidoNotajTableKeyPressed

    private void ProdutosNFEjTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProdutosNFEjTableMouseClicked
        linhaNota = ProdutosNFEjTable.getSelectedRow();
    }//GEN-LAST:event_ProdutosNFEjTableMouseClicked

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        new FrmConsultaProdutos(this, config, true, true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    /**
    * @param args the command line arguments
    */
  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable ProdutosNFEjTable;
    private javax.swing.JTable ProdutosPedidoNotajTable;
    private javax.swing.JTable ProdutosPedidojTable;
    private javax.swing.JComboBox boletojComboBox;
    private javax.swing.JButton buscaBancojButton1;
    private javax.swing.JButton buscaBancojButton3;
    private javax.swing.JTextField caminhojTextField;
    private javax.swing.JButton carregarjButton;
    private javax.swing.JTextField codigoFabricantejTextField;
    private javax.swing.JTextField codigojTextField;
    private javax.swing.JComboBox condicaoPagamentojComboBox;
    private javax.swing.JTable contasPagarjTable;
    private javax.swing.JButton controlejButton;
    private javax.swing.JTextField custojTextField;
    private javax.swing.JPanel dadosNotafiscaljPanel;
    private javax.swing.JPanel dadosRegistrojPanel;
    private javax.swing.JTextField dataComprajTextField;
    private com.toedter.calendar.JDateChooser dataEmissaojDateChooser;
    private com.toedter.calendar.JDateChooser dataEntradajDateChooser;
    private com.toedter.calendar.JDateChooser dataSaidajDateChooser;
    private com.toedter.calendar.JDateChooser dataVencimentojDateChooser;
    private javax.swing.JTextField descricaojTextField;
    private javax.swing.JTable duplicatajTable;
    private javax.swing.JTextField embalagemjTextField;
    private javax.swing.JTabbedPane entradajTabbedPane;
    private javax.swing.JComboBox especiejComboBox;
    private javax.swing.JTextField estoqueAtualjTextField;
    private javax.swing.JTextField fornecedorjTextField;
    private javax.swing.JButton gerarRecibojButton;
    private javax.swing.JTextField icmsjTextField;
    private javax.swing.JTextField ipijTextField;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JButton limparjButton;
    private javax.swing.JButton localizarjButton;
    private javax.swing.JButton naoRegistradosjButton;
    private javax.swing.JTextField ncmjTextField;
    private javax.swing.JTextField numeroDocumentojTextField;
    private javax.swing.JTextField numerojTextField;
    private javax.swing.JTextField percentualVendajTextField;
    private javax.swing.JTable produtosjTable;
    private javax.swing.JTextField quantidadejTextField;
    private javax.swing.JTextField seriejTextField;
    private javax.swing.JComboBox situacaojComboBox;
    private javax.swing.JTextField stjTextField;
    private javax.swing.JTextField subSeriejTextField;
    private javax.swing.JComboBox tipoDocumentojComboBox;
    private javax.swing.JComboBox tipoPagamentojComboBox;
    private javax.swing.JButton todosRegistradosjButton;
    private javax.swing.JTextField totalCustojTextField;
    private javax.swing.JTextField totalUnitariojTextField;
    private javax.swing.JTextField ultimaComprajTextField1;
    private javax.swing.JTextField unidadejTextField;
    private javax.swing.JTextField unitariojTextField;
    private javax.swing.JTextField valorContajTextField;
    private javax.swing.JTextField valorDescontojTextField;
    private javax.swing.JTextField valorEncargosjTextField;
    private javax.swing.JTextField valorProdutosjTextField;
    private javax.swing.JTextField valorTotalContasPagarjTextField;
    private javax.swing.JTextField valorTotalEncargosjTextField;
    private javax.swing.JTextField valorTotalNotajTextField;
    private javax.swing.JTextField valorTotalProdutosjTextField;
    private javax.swing.JTextField valorTotaljTextField;
    private javax.swing.JTextField valorVendajTextField;
    private javax.swing.JScrollPane vencidasjScrollPane;
    private javax.swing.JPanel xmljPanel;
    // End of variables declaration//GEN-END:variables

    public void setData(Object objeto) {
        Produto produto = (Produto) objeto;
        codigojTextField.setText(String.valueOf(produto.getReferencia()));
        localizarProdoutoCodigo(String.valueOf(produto.getReferencia()));
        codigojTextField.selectAll();
        codigojTextField.requestFocus();
    }

    public void setBanco(Banco banco) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setNFe(List<NfProdutos> listaProdutos, List<NfDuplicatas> listaDuplicatas, NotaEletronica nota, Fornecedor fornecedor) {
        this.nota = nota;
        this.listaDuplicata = listaDuplicatas;
        this.listaProdutos = listaProdutos;
        entradaEstoque.setFornecedor(fornecedor);
        modelarProdutosNotaFiscal();
        setCamposNFe();
    }

    public void setCamposNFe() {

        //Preenche os dados da Entrada


        entradaEstoque.getDocEntrada().setFornecedor(entradaEstoque.getFornecedor().getIdfornecedor());
        entradaEstoque.getDocEntrada().setCondicaoPagamento(nota.getFormaPagamento());
        entradaEstoque.getDocEntrada().setDataEntrada(new Date());
        entradaEstoque.getDocEntrada().setTipoDocumento("Nota Fiscal");
        entradaEstoque.getDocEntrada().setValorDesconto(nota.getValorDesconto());
        entradaEstoque.getDocEntrada().setValorEncargos(nota.getValorOutrasDespesass());
        entradaEstoque.getDocEntrada().setEmpresa(config.getEmpresa().getIdempresa());
        fornecedorjTextField.setText(entradaEstoque.getFornecedor().getRazaoSocial());
        tipoDocumentojComboBox.setSelectedItem("Nota Fiscal");
        condicaoPagamentojComboBox.setSelectedItem(this.nota.getFormaPagamento());
        valorEncargosjTextField.setText(Formatacao.foramtarFloatString(this.nota.getValorOutrasDespesass() + this.nota.getValorFrete()));
        valorDescontojTextField.setText(Formatacao.foramtarFloatString(this.nota.getValorDesconto()));
        valorProdutosjTextField.setText(Formatacao.foramtarFloatString(this.nota.getValorProdutos()));
        valorTotaljTextField.setText(Formatacao.foramtarFloatString(this.nota.getValorTotal()));

        //Preenche os dados da Nota Fiscal

        numerojTextField.setText(this.nota.getNumero());
        dataEmissaojDateChooser.setDate(this.nota.getDataEmissao());
        if (this.nota.getDataSaida()==null){
            dataSaidajDateChooser.setDate(this.nota.getDataEmissao());
        }else dataSaidajDateChooser.setDate(this.nota.getDataSaida());
        especiejComboBox.setSelectedItem("NF-e");
        seriejTextField.setText(this.nota.getSerie());
        subSeriejTextField.setText(this.nota.getSubSerie());
        if (this.entradaEstoque.getFornecedor().getIdfornecedor()==null){
            new FrmCadastrarFornecedor(entradaEstoque.getFornecedor(), this);
        }


    }
    
    private void modelarProdutosNotaFiscal(){
        if (listaProdutos.size()>0){
            notaEletronicaModel = new NotaEletronicaTableModel(listaProdutos);
        }else {
            notaEletronicaModel = new NotaEletronicaTableModel(new ArrayList<NfProdutos>());
        }
         rendererCor = new DefaultTableCellRenderer(){
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                        boolean isSelected, boolean hasFocus, int row, int column) {
                    Component comp = super.getTableCellRendererComponent(table, value,
                            isSelected, hasFocus, row, column);
                    if (listaProdutos.get(row).isEntrada()){
                        comp.setBackground(Color.red);
                    }else {
                        comp.setBackground(Color.white);
                    }
                    return comp;
                }
        };
         rendererCorNumerico = new DefaultTableCellRenderer(){
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                        boolean isSelected, boolean hasFocus, int row, int column) {
                    Component comp = super.getTableCellRendererComponent(table, value,
                            isSelected, hasFocus, row, column);
                    if (listaProdutos.get(row).isEntrada()){
                        comp.setBackground(Color.red);
                    }else {
                        comp.setBackground(Color.white);
                    }
                    return comp;
                }
        };
        rendererCorNumerico.setHorizontalAlignment(SwingConstants.RIGHT);
        
        ProdutosNFEjTable.setModel(notaEletronicaModel);
        ProdutosNFEjTable.setSelectionMode(2);
        ProdutosNFEjTable.getColumnModel().getColumn(0).setCellRenderer(rendererCor);
        ProdutosNFEjTable.getColumnModel().getColumn(0).setPreferredWidth(5);
        ProdutosNFEjTable.getColumnModel().getColumn(1).setCellRenderer(rendererCor);
        ProdutosNFEjTable.getColumnModel().getColumn(1).setPreferredWidth(20);
        ProdutosNFEjTable.getColumnModel().getColumn(2).setCellRenderer(rendererCor);
        ProdutosNFEjTable.getColumnModel().getColumn(2).setPreferredWidth(200);
        ProdutosNFEjTable.getColumnModel().getColumn(3).setCellRenderer(rendererCor);
        ProdutosNFEjTable.getColumnModel().getColumn(3).setPreferredWidth(15);
        ProdutosNFEjTable.getColumnModel().getColumn(4).setCellRenderer(rendererCorNumerico);
        ProdutosNFEjTable.getColumnModel().getColumn(4).setPreferredWidth(15);
        ProdutosNFEjTable.getColumnModel().getColumn(5).setCellRenderer(rendererCorNumerico);
        ProdutosNFEjTable.getColumnModel().getColumn(5).setPreferredWidth(15);
        ProdutosNFEjTable.getColumnModel().getColumn(6).setCellRenderer(rendererCorNumerico);
        ProdutosNFEjTable.getColumnModel().getColumn(6).setPreferredWidth(15);
        ProdutosNFEjTable.getColumnModel().getColumn(7).setCellRenderer(rendererCorNumerico);
        ProdutosNFEjTable.getColumnModel().getColumn(7).setPreferredWidth(15);
        ProdutosNFEjTable.getColumnModel().getColumn(8).setCellRenderer(rendererCorNumerico);
        ProdutosNFEjTable.getColumnModel().getColumn(8).setPreferredWidth(15);
        ProdutosNFEjTable.getColumnModel().getColumn(9).setCellRenderer(rendererCorNumerico);
        ProdutosNFEjTable.getColumnModel().getColumn(9).setPreferredWidth(15);
        ProdutosNFEjTable.getColumnModel().getColumn(10).setCellRenderer(rendererCorNumerico);
        ProdutosNFEjTable.getColumnModel().getColumn(10).setPreferredWidth(15);
        ProdutosNFEjTable.getColumnModel().getColumn(11).setCellRenderer(rendererCor);
        ProdutosNFEjTable.getColumnModel().getColumn(11).setPreferredWidth(15);
        ProdutosNFEjTable.setSelectionMode(2);
        ProdutosNFEjTable.repaint();

        if (listaDuplicata.size()>0){
            duplicataModel = new DuplicataTableModel(listaDuplicata);
        }else {
            duplicataModel = new DuplicataTableModel(new ArrayList<NfDuplicatas>());
        }
        DefaultTableCellRenderer rendererDuplicata = new DefaultTableCellRenderer();
        rendererDuplicata.setHorizontalAlignment(SwingConstants.RIGHT);
        duplicatajTable.setModel(duplicataModel);
        duplicatajTable.getColumnModel().getColumn(0).setPreferredWidth(20);
        duplicatajTable.getColumnModel().getColumn(1).setPreferredWidth(20);
        duplicatajTable.getColumnModel().getColumn(2).setCellRenderer(rendererDuplicata);
        duplicatajTable.getColumnModel().getColumn(2).setPreferredWidth(30);
        duplicatajTable.repaint();
    }

    public void setModelProduto(Produto produto, Estoque estoque) {
        
    }

    public void calcularValorCusto(){
        float pEncargos =0;
        double quant = Formatacao.ConvercaoMonetariaDouble(quantidadejTextField.getText());
        float vu = Formatacao.ConvercaoMonetariaFloat(unitariojTextField.getText());
        float st = Formatacao.ConvercaoMonetariaFloat(stjTextField.getText());
        float vipi =Formatacao.ConvercaoMonetariaFloat(ipijTextField.getText());
        if (!valorEncargosjTextField.getText().equalsIgnoreCase(null)){
            float valorEncargos =  Formatacao.ConvercaoMonetariaFloat(valorEncargosjTextField.getText());
            float valorTotalCusto = Formatacao.ConvercaoMonetariaFloat(valorTotaljTextField.getText());
            pEncargos = valorEncargos * 100 / valorTotalCusto;
        }
        float valorCusto =(float) ((st + vipi) / quant) + vu;
        if (pEncargos>0){
            valorCusto = (float) (valorCusto * (1 + (pEncargos / 100)));
        }
        
        
        float total = Formatacao.ConvercaoMonetariaFloat(unitariojTextField.getText());
        total = (float) (total * quant);
        totalUnitariojTextField.setText(Formatacao.foramtarFloatString(total));
        totalCustojTextField.setText(Formatacao.foramtarDoubleString(valorCusto * quant));
        custojTextField.setText(Formatacao.foramtarFloatString(valorCusto));
    }

    
    public void gerarJTableProdutoEntrada(){
         if (entradaEstoque.getListaProdutos().size()>0){
            entradaProdutoModel = new EntradaProdutoTableModel(entradaEstoque.getListaProdutos());
        }else {
            entradaProdutoModel = new EntradaProdutoTableModel(new ArrayList<ListaProdutoEntrada>());
        }
       
         DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
         renderer.setHorizontalAlignment(SwingConstants.RIGHT);
         
        produtosjTable.setModel(entradaProdutoModel);
        produtosjTable.getColumnModel().getColumn(0).setPreferredWidth(20);
        produtosjTable.getColumnModel().getColumn(1).setPreferredWidth(200);
        produtosjTable.getColumnModel().getColumn(2).setPreferredWidth(20);
        produtosjTable.getColumnModel().getColumn(3).setCellRenderer(renderer);
        produtosjTable.getColumnModel().getColumn(3).setPreferredWidth(30);
        produtosjTable.getColumnModel().getColumn(4).setCellRenderer(renderer);
        produtosjTable.getColumnModel().getColumn(4).setPreferredWidth(50);
        produtosjTable.getColumnModel().getColumn(5).setCellRenderer(renderer);
        produtosjTable.getColumnModel().getColumn(5).setPreferredWidth(10);
        produtosjTable.getColumnModel().getColumn(6).setCellRenderer(renderer);
        produtosjTable.getColumnModel().getColumn(6).setPreferredWidth(10);
        produtosjTable.getColumnModel().getColumn(7).setCellRenderer(renderer);
        produtosjTable.getColumnModel().getColumn(7).setPreferredWidth(10);
        produtosjTable.getColumnModel().getColumn(8).setCellRenderer(renderer);
        produtosjTable.getColumnModel().getColumn(8).setPreferredWidth(10);
        produtosjTable.getColumnModel().getColumn(9).setCellRenderer(renderer);
        produtosjTable.getColumnModel().getColumn(9).setPreferredWidth(10);
        produtosjTable.getColumnModel().getColumn(10).setPreferredWidth(5);
        produtosjTable.repaint();
    }

    public void setAlterarValorVenda(Estoque estoque) {
        percentualVendajTextField.setText(Formatacao.foramtarDoubleString(estoque.getPercentualVendas()));
        valorVendajTextField.setText(Formatacao.foramtarFloatString(estoque.getValorVenda()));
        valorVendajTextField.requestFocus();
    }


    public void setDocEntrada(){
        //Seta Nota Fiscal
        if (entradaEstoque.getNotaFiscal()==null){
            entradaEstoque.setNotaFiscal(new Nfentrada());
        }
        entradaEstoque.getNotaFiscal().setDataEmissao(dataEmissaojDateChooser.getDate());
        entradaEstoque.getNotaFiscal().setDataSaida(dataSaidajDateChooser.getDate());
        entradaEstoque.getNotaFiscal().setEspecie((String) especiejComboBox.getSelectedItem());
        entradaEstoque.getNotaFiscal().setNumero(numerojTextField.getText());
        entradaEstoque.getNotaFiscal().setSerie(seriejTextField.getText());
        entradaEstoque.getNotaFiscal().setSubSerie(subSeriejTextField.getText());
        entradaEstoque.getNotaFiscal().setValorProdutos(Formatacao.ConvercaoMonetariaFloat(valorProdutosjTextField.getText()));
        entradaEstoque.getNotaFiscal().setValorTotal(Formatacao.ConvercaoMonetariaFloat(valorTotaljTextField.getText()));
        entradaEstoque.getDocEntrada().setEmpresa(config.getEmpresa().getIdempresa());
        entradaEstoque.getDocEntrada().setCondicaoPagamento((String) condicaoPagamentojComboBox.getSelectedItem());
        entradaEstoque.getDocEntrada().setDataEntrada(dataEntradajDateChooser.getDate());
        entradaEstoque.getDocEntrada().setFornecedor(entradaEstoque.getFornecedor().getIdfornecedor());
        entradaEstoque.getDocEntrada().setSituacao((String) situacaojComboBox.getSelectedItem());
        String tipoDocumento = (String) tipoDocumentojComboBox.getSelectedItem();
        entradaEstoque.getDocEntrada().setTipoDocumento(tipoDocumento);
        entradaEstoque.getDocEntrada().setValorDesconto(Formatacao.ConvercaoMonetariaFloat(valorDescontojTextField.getText()));
        entradaEstoque.getDocEntrada().setValorEncargos(Formatacao.ConvercaoMonetariaFloat(valorEncargosjTextField.getText()));
        entradaEstoque.getDocEntrada().setValorTotal(Formatacao.ConvercaoMonetariaFloat(valorTotaljTextField.getText()));
    }

    public void alterarEntrada(){
        //Preencher Doc entrada
        if (entradaEstoque.getDocEntrada() != null) {
            fornecedorjTextField.setText(entradaEstoque.getFornecedor().getRazaoSocial());
            dataEntradajDateChooser.setDate(entradaEstoque.getDocEntrada().getDataEntrada());
            tipoDocumentojComboBox.setSelectedItem(entradaEstoque.getDocEntrada().getTipoDocumento());
            condicaoPagamentojComboBox.setSelectedItem(entradaEstoque.getDocEntrada().getCondicaoPagamento());
            valorEncargosjTextField.setText(Formatacao.foramtarFloatString(entradaEstoque.getDocEntrada().getValorEncargos()));
            valorDescontojTextField.setText(Formatacao.foramtarFloatString(entradaEstoque.getDocEntrada().getValorDesconto()));
            valorProdutosjTextField.setText(Formatacao.foramtarFloatString(entradaEstoque.getDocEntrada().getValorTotal()));
            situacaojComboBox.setSelectedItem(entradaEstoque.getDocEntrada().getSituacao());
        }

        //Preencher Dados Nota Fiscal
        if (entradaEstoque.getNotaFiscal() != null) {
            numerojTextField.setText(entradaEstoque.getNotaFiscal().getNumero());
            dataEmissaojDateChooser.setDate(entradaEstoque.getNotaFiscal().getDataEmissao());
            dataSaidajDateChooser.setDate(entradaEstoque.getNotaFiscal().getDataSaida());
            especiejComboBox.setSelectedItem(entradaEstoque.getNotaFiscal().getEspecie());
            seriejTextField.setText(entradaEstoque.getNotaFiscal().getSerie());
            subSeriejTextField.setText(entradaEstoque.getNotaFiscal().getSubSerie());
            valorProdutosjTextField.setText(Formatacao.foramtarFloatString(entradaEstoque.getNotaFiscal().getValorProdutos()));
            valorTotaljTextField.setText(Formatacao.foramtarFloatString(entradaEstoque.getNotaFiscal().getValorTotal()));
        }
        //Desabilitar Botoes NF-e
        carregarjButton.setEnabled(false);
        limparjButton.setEnabled(false);
        localizarjButton.setEnabled(false);

        //Carregar produtos jTable
        gerarJTableProdutoEntrada();
    }


    public void AlterarQuantidadeEstoque(){
        EstoqueController estoqueController = new EstoqueController();
        Estoque estoque;
        for(int i=0;i<listaAlterar.size();i++){
            estoque = new Estoque();
            estoque = estoqueController.consultarEstoque(listaAlterar.get(i).getProduto().getIdProduto(), this.config.getEmpresa().getIdempresa());
            if (estoque!=null){
                estoqueController.saidaEstoque(listaAlterar.get(i).getEntradaproduto().getQuantidade(), estoque,1);
            }
        }
    }
    

    public void setFornecedor(Object objeto) {
        this.entradaEstoque.setFornecedor((Fornecedor)objeto);
        fornecedorjTextField.setText(this.entradaEstoque.getFornecedor().getRazaoSocial());
    }
    
    
    public boolean validarConfirmaProduto(){
        if (totalUnitariojTextField.getText().equalsIgnoreCase("0,00")){
            JOptionPane.showMessageDialog(null, "Valor Total Unitário Zerado");
            return false;
        }else if (totalCustojTextField.getText().equalsIgnoreCase("0,00")){
            JOptionPane.showMessageDialog(null, "Valor Total Custo Zerado");
            return false;
        }else if (custojTextField.getText().equalsIgnoreCase("0,00")){
            JOptionPane.showMessageDialog(null, "Valor Custo Zerado");
            return false;
        }else if (percentualVendajTextField.getText().equalsIgnoreCase("0,00")){
            JOptionPane.showMessageDialog(null, "Percentual de Vendas Zerado");
            return false;
        }else if (valorVendajTextField.getText().equalsIgnoreCase("0,00")){
            JOptionPane.showMessageDialog(null, "Valor Venda Zerado");
            return false;
        }else if (descricaojTextField.getText().equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(null, "Produto não Localizado");
            return false;
        }
        return true;
    }
    
    private void localizarProdutoNFE() {
        
        //Localizar Codigo do Fabricante
        ProdutoController produtoController = new ProdutoController();
        
        if (this.produto==null){
            produto = new Produto();
            produto = produtoController.consultarProdutoid(listaPedidoProduto.get(linhaPedido).getProduto());
        }
        if (produto.getIdProduto()!=null){
           listaProdutoEntrada = new ListaProdutoEntrada();
           listaProdutoEntrada.setExcluido(false);
           listaProdutoEntrada.setValorVenda(0.0f);
            produto.setMva(listaProdutos.get(linhaNota).getMva());
            produto.setNcm(listaProdutos.get(linhaNota).getCodigoNCM());
            if (produto.getNcm().length()>0){
                ncmjTextField.setText(produto.getNcm());
            }
            if (listaProdutos.get(linhaNota).getValorICMSST()>0){
                produto.setAliquota(6);
            }
            produto = produtoController.salvarProduto(produto);
            listaProdutoEntrada.setProduto(produto);
            codigoFabricantejTextField.setText(listaProdutos.get(linhaNota).getCodigo());
            quantidadejTextField.setText(Formatacao.foramtarQuantidade(listaProdutos.get(linhaNota).getQuantidade()));
            if(listaProdutos.get(linhaNota).getValorICMSST()>0){
                icmsjTextField.setText("ST");
            }else {
                icmsjTextField.setText(Formatacao.foramtarDoubleString(listaProdutos.get(linhaNota).getAliquotaICMS()));
            }
            ipijTextField.setText(Formatacao.foramtarFloatString(listaProdutos.get(linhaNota).getValorIPI()));
            stjTextField.setText(Formatacao.foramtarFloatString(listaProdutos.get(linhaNota).getValorICMSST()));
            unitariojTextField.setText(Formatacao.foramtarFloatString(listaProdutos.get(linhaNota).getValorUnitario()));
            codigojTextField.setText(String.valueOf(listaProdutoEntrada.getProduto().getReferencia()));
            //localizarProdoutoCodigo(String.valueOf(produto.getReferencia()));
            CalcularValoresEntrada();
            EstoqueController estoqueController = new EstoqueController();
            listaProdutoEntrada.setEstoque(estoqueController.consultarEstoque(listaProdutoEntrada.getProduto().getIdProduto(), this.config.getEmpresa().getIdempresa()));
            descricaojTextField.setText(listaProdutoEntrada.getProduto().getDescricao());
            VinculoController vinculoController = new VinculoController();
            listaProdutoEntrada.setVinculo(vinculoController.consultarVinculo(listaProdutoEntrada.getProduto().getIdProduto(), this.config.getEmpresa().getIdempresa(), entradaEstoque.getFornecedor().getIdfornecedor()));
            AliquotaController aliquotaController = new AliquotaController();
            listaProdutoEntrada.setAliquota(aliquotaController.buscarAliquotaid(listaProdutoEntrada.getProduto().getAliquota()));
            icmsjTextField.setText(listaProdutoEntrada.getAliquota().getDescricao());
            if (listaProdutoEntrada.getEstoque()!=null){
                    ultimaComprajTextField1.setText(Formatacao.foramtarDoubleString(listaProdutoEntrada.getEstoque().getValorCusto()));
                    listaProdutoEntrada.setValorVenda(listaProdutoEntrada.getEstoque().getValorVenda());
                    estoqueAtualjTextField.setText(Formatacao.foramtarQuantidade(listaProdutoEntrada.getEstoque().getQuantidadeEstoque()));
                    valorVendajTextField.setText(Formatacao.foramtarFloatString(listaProdutoEntrada.getEstoque().getValorVenda()));
                    percentualVendajTextField.setText(Formatacao.foramtarDoubleString(listaProdutoEntrada.getEstoque().getPercentualVendas()));
            }
            if (embalagemjTextField.getText().equalsIgnoreCase("0")) {
               embalagemjTextField.setEditable(true);
            }
            entradajTabbedPane.setSelectedIndex(1);
            quantidadejTextField.requestFocus();
            listaProdutos.get(linhaNota).setEntrada(true);
            modelarProdutosNotaFiscal();
            if (linhaPedido>=0){
                if (listaPedidoProduto!=null){
                    Forpedproduto pedtemp = listaPedidoProduto.get(linhaPedido);
                    pedtemp.setEntrada(1);
                    salvarPedidoProduto(pedtemp);
                }
            }
        }else {
            JOptionPane.showMessageDialog(rootPane, "Produto não Localizado");
        }
    }
        
        
    
    
    public void localizarProdoutoCodigo(String referencia) {
        listaProdutoEntrada = new ListaProdutoEntrada();
        listaProdutoEntrada.setExcluido(false);
        listaProdutoEntrada.setValorVenda(0.0f);
        ProdutoController produtoController = new ProdutoController();
        EstoqueController estoqueController = new EstoqueController();
        VinculoController vinculoController = new VinculoController();
        if ((entradajTabbedPane.getSelectedIndex() == 1) || (entradajTabbedPane.getSelectedIndex()==3)){
            this.listaProdutoEntrada = new ListaProdutoEntrada();
            Produto prodNCM = produtoController.consultarProdutoReferencia(Integer.parseInt(referencia));
            if (prodNCM!=null){
                ncmjTextField.setText(prodNCM.getNcm());
                if (prodNCM.getNcm().equalsIgnoreCase("0")){
                    String ncm = JOptionPane.showInputDialog("Informe o NCM somente Numeros");
                    if (ncm.equalsIgnoreCase("")){
                        ncm="0";
                    }
                    prodNCM.setNcm(ncm);
                    ncmjTextField.setText(ncm);
                    prodNCM = produtoController.salvarProduto(prodNCM);
                }
            }
            this.listaProdutoEntrada.setProduto(prodNCM);
            if (listaProdutoEntrada.getProduto()==null) {
                JOptionPane.showMessageDialog(null, "Produto não encontrado");
            } else {
                listaProdutoEntrada.setEstoque(estoqueController.consultarEstoque(listaProdutoEntrada.getProduto().getIdProduto(), this.config.getEmpresa().getIdempresa()));
                descricaojTextField.setText(listaProdutoEntrada.getProduto().getDescricao());
                
                listaProdutoEntrada.setVinculo(vinculoController.consultarVinculo(listaProdutoEntrada.getProduto().getIdProduto(), this.config.getEmpresa().getIdempresa(), entradaEstoque.getFornecedor().getIdfornecedor()));
                
                if (listaProdutoEntrada.getVinculo() != null) {
                    codigoFabricantejTextField.setText(listaProdutoEntrada.getVinculo().getCodigoFabricante());
                    embalagemjTextField.setText(String.valueOf(listaProdutoEntrada.getVinculo().getEmbalagem()));
                    if (listaProdutoEntrada.getVinculo().getDataCompra()!=null){ 
                        dataComprajTextField.setText(Formatacao.ConvercaoDataPadrao(listaProdutoEntrada.getVinculo().getDataCompra()));
                    }
                }
                if (listaProdutoEntrada.getEstoque()!=null){
                    ultimaComprajTextField1.setText(Formatacao.foramtarDoubleString(listaProdutoEntrada.getEstoque().getValorCusto()));
                    listaProdutoEntrada.setValorVenda(listaProdutoEntrada.getEstoque().getValorVenda());
                    estoqueAtualjTextField.setText(Formatacao.foramtarQuantidade(listaProdutoEntrada.getEstoque().getQuantidadeEstoque()));
                    valorVendajTextField.setText(Formatacao.foramtarFloatString(listaProdutoEntrada.getEstoque().getValorVenda()));
                    percentualVendajTextField.setText(Formatacao.foramtarDoubleString(listaProdutoEntrada.getEstoque().getPercentualVendas()));
                }

                unidadejTextField.setText(listaProdutoEntrada.getProduto().getUnidade());
                AliquotaController aliquotaController = new AliquotaController();
                listaProdutoEntrada.setAliquota(aliquotaController.buscarAliquotaid(listaProdutoEntrada.getProduto().getAliquota()));
                    icmsjTextField.setText(listaProdutoEntrada.getAliquota().getDescricao());
                if (codigoFabricantejTextField.getText().equalsIgnoreCase("")) {
                    codigoFabricantejTextField.setEditable(true);
                }
                if (embalagemjTextField.getText().equalsIgnoreCase("0")) {
                    embalagemjTextField.setEditable(true);
                }
                entradajTabbedPane.setSelectedIndex(1);
                quantidadejTextField.setText("");
                quantidadejTextField.requestFocus();
            }
        }
    }

    public void CalcularValoresEntrada(){
        calcularValorCusto();
        if (listaProdutoEntrada.getEstoque() != null) {
            if (listaProdutoEntrada.getEstoque().getPercentualVendas() > 0) {
                Double valorCusto = Formatacao.ConvercaoMonetariaDouble(custojTextField.getText());
                Double percentual = listaProdutoEntrada.getEstoque().getPercentualVendas();
                valorCusto = Formatacao.calcularValorPercentual(percentual, valorCusto);
                valorCusto = Formatacao.ConvercaoMonetariaDouble(custojTextField.getText());
                float valorVenda = listaProdutoEntrada.getEstoque().getValorVenda();
                percentual = Formatacao.calcularValorValorVenda(valorVenda, valorCusto);
                percentualVendajTextField.setText(Formatacao.foramtarDoubleString(percentual));
                if (valorCusto > this.listaProdutoEntrada.getEstoque().getValorCusto()) {
                    boolean resultado = JOptionPane.showConfirmDialog(null, "Deseja alterar valor de venda?", "Atenção", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == 0;
                    if (resultado) {
                        new FrmAlterarValorVenda(listaProdutoEntrada.getEstoque(), this, Formatacao.ConvercaoMonetariaDouble(custojTextField.getText()));
                    } else {
                        valorCusto = Formatacao.ConvercaoMonetariaDouble(custojTextField.getText());
                        valorVenda = listaProdutoEntrada.getEstoque().getValorVenda();
                        percentual = Formatacao.calcularValorValorVenda(valorVenda, valorCusto);
                        percentualVendajTextField.setText(Formatacao.foramtarDoubleString(percentual));
                    }
                } else {
                    valorCusto = Formatacao.ConvercaoMonetariaDouble(custojTextField.getText());
                    valorVenda = listaProdutoEntrada.getEstoque().getValorVenda();
                    percentual = Formatacao.calcularValorValorVenda(valorVenda, valorCusto);
                    percentualVendajTextField.setText(Formatacao.foramtarDoubleString(percentual));
                }
            } else {
                double valorCusto = Formatacao.ConvercaoMonetariaDouble(custojTextField.getText());
                float valorVenda = listaProdutoEntrada.getEstoque().getValorVenda();
                double percentual = Formatacao.calcularValorValorVenda(valorVenda, valorCusto);
                percentualVendajTextField.setText(Formatacao.foramtarDoubleString(percentual));
            }
        }
    }
    
    private void cancelarconfirmarProduto(){
        codigojTextField.setText("");
        descricaojTextField.setText("");
        codigoFabricantejTextField.setText("");
        embalagemjTextField.setText("");
        dataComprajTextField.setText("");
        unidadejTextField.setText("");
        ultimaComprajTextField1.setText("");
        quantidadejTextField.setText("0,00");
        icmsjTextField.setText("0,00");
        ipijTextField.setText("0,00");
        stjTextField.setText("0,00");
        unitariojTextField.setText("0,00");
        custojTextField.setText("0,00");
        totalUnitariojTextField.setText("0,00");
        totalCustojTextField.setText("0,00");
        percentualVendajTextField.setText("0,00");
        valorVendajTextField.setText("0,00");
    }

    public void setForPedido(Object objeto) {
        this.forPediddo = (Forpedido) objeto;
        carregarDadosPedidoFornnecedor(0);
        desmarcarPedidosComprados();
    }
    
   
    
    public void carregarTodosPedido(int tipo){
        ForPedidoFacade forPedidoFacade = new ForPedidoFacade();
        try {
            if (tipo==0){
                listaPedidoProduto = forPedidoFacade.consultarForPedidoProduto(forPediddo, 0);
            } else listaPedidoProduto = forPedidoFacade.consultarForPedidoProduto(forPediddo);
            
        } catch (SQLException ex) {
            Logger.getLogger(FrmEntrada.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(rootPane, "Erro Consultar Pedido Fornecedor " + ex);
        }
        
    }
    
    public void salvarPedidoProduto(Forpedproduto pedidoProduto){
        ForPedidoFacade forPedidoFacade = new ForPedidoFacade();
        try {
            forPedidoFacade.salvarForPedProduto(pedidoProduto);
            //carregarDadosPedidoFornnecedor(0);
        } catch (SQLException ex) {
            Logger.getLogger(FrmEntrada.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(rootPane, "Erro Salvar Pedido Produto " + ex);
        }
    }
    
    
    
    public void carregarDadosPedidoFornnecedor(int tipo){
        carregarTodosPedido(tipo);
       if (listaPedidoProduto.size()>0){
           ForPedidoModel = new ConsultaForPedidoProdutoTableModel(listaPedidoProduto, this.config.getEmpresa().getIdempresa());
        }else {
            ForPedidoModel = new ConsultaForPedidoProdutoTableModel(new ArrayList<Forpedproduto>(), this.config.getEmpresa().getIdempresa());
        }
        ProdutosPedidojTable.setModel(ForPedidoModel);
        ProdutosPedidojTable.getColumnModel().getColumn(0).setPreferredWidth(20);
        ProdutosPedidojTable.getColumnModel().getColumn(1).setPreferredWidth(500);
        ProdutosPedidojTable.getColumnModel().getColumn(2).setPreferredWidth(20);
        ProdutosPedidojTable.getColumnModel().getColumn(3).setPreferredWidth(30);
        ProdutosPedidojTable.getColumnModel().getColumn(4).setPreferredWidth(50);
        ProdutosPedidojTable.repaint();
        
        ProdutosPedidoNotajTable.setModel(ForPedidoModel);
        ProdutosPedidoNotajTable.getColumnModel().getColumn(0).setPreferredWidth(20);
        ProdutosPedidoNotajTable.getColumnModel().getColumn(1).setPreferredWidth(500);
        ProdutosPedidoNotajTable.getColumnModel().getColumn(2).setPreferredWidth(20);
        ProdutosPedidoNotajTable.getColumnModel().getColumn(3).setPreferredWidth(30);
        ProdutosPedidoNotajTable.getColumnModel().getColumn(4).setPreferredWidth(50);
        ProdutosPedidoNotajTable.repaint();
    }
    
    public void organizarListaProdutos(){
        List<ListaProdutoEntrada> listaOrganizada = new ArrayList<ListaProdutoEntrada>();
        if (linhaAlterar==-1){
            entradaEstoque.getListaProdutos().add(listaProdutoEntrada);
        }else {
            for (int i=0;i<entradaEstoque.getListaProdutos().size();i++){
                if (i==linhaAlterar){
                    if (listaProdutoEntrada!=null){
                        listaOrganizada.add(listaProdutoEntrada);
                    }
                }else {
                    if (!(entradaEstoque.getListaProdutos().get(i).isExcluido())){
                        listaOrganizada.add(entradaEstoque.getListaProdutos().get(i));
                    }
                }
            }
            entradaEstoque.setListaProdutos(new ArrayList<ListaProdutoEntrada>());
            entradaEstoque.setListaProdutos(listaOrganizada);
        }
        gerarJTableProdutoEntrada();
        entradaEstoque.calcularTotais();
        valorTotalProdutosjTextField.setText(Formatacao.foramtarDoubleString(entradaEstoque.getValorProdutos()));
        valorTotalEncargosjTextField.setText(Formatacao.foramtarDoubleString(entradaEstoque.getValorEncargos()));
        valorTotalNotajTextField.setText(Formatacao.foramtarDoubleString(entradaEstoque.getValorTotal()));
        cancelarconfirmarProduto();
        codigojTextField.requestFocus();
        linhaAlterar =-1;
        linhaNota=-1;
        linhaPedido=-1;
        ncmjTextField.setText("");
        
    }
    
    private void desmarcarPedidosComprados(){
        VinculoController vinculoController = new VinculoController();
        ForPedidoController forPedidoController = new ForPedidoController();
        List<Forpedproduto> listaPedidoProduto = forPedidoController.consultarForPedidoProduto(forPediddo);
        for (int i = 0; i < listaPedidoProduto.size(); i++) {
            Vinculo vinculo = new Vinculo();
            vinculo = vinculoController.consultarVinculo(listaPedidoProduto.get(i).getProduto(), config.getEmpresa().getIdempresa(), forPediddo.getFornecedor());
            if (vinculo != null) {
                if (vinculo.getPedido() != null) {
                    if (vinculo.getPedido().equalsIgnoreCase("SIM")) {
                        vinculo.setPedido("NAO");
                        vinculoController.salvarVinculo(vinculo);
                    }
                } else {
                    vinculo.setPedido("NAO");
                    vinculoController.salvarVinculo(vinculo);
                }
            }
        }
    }
    
    public Produto localizarProduto(int idProduto){
        ProdutoController produtoController = new ProdutoController();
        return produtoController.consultarProdutoid(idProduto);
    }
    
    public void setModelContasPagar(){
        if (listaContasPagar == null) {
            this.listaContasPagar = new ArrayList<Contaspagar>();
        }
        modelContasPagar = new ContasPagarTableModel(listaContasPagar);
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.RIGHT);
        contasPagarjTable.setModel(modelContasPagar);
        contasPagarjTable.getColumnModel().getColumn(0).setPreferredWidth(20);
        contasPagarjTable.getColumnModel().getColumn(1).setPreferredWidth(40);
        contasPagarjTable.getColumnModel().getColumn(2).setPreferredWidth(300);
        contasPagarjTable.getColumnModel().getColumn(3).setPreferredWidth(40);
        contasPagarjTable.getColumnModel().getColumn(4).setCellRenderer(renderer);
        contasPagarjTable.getColumnModel().getColumn(4).setPreferredWidth(40);
        contasPagarjTable.getColumnModel().getColumn(5).setPreferredWidth(5);
        contasPagarjTable.repaint();
    }
    
    public double CalcularValorContasPagar(){
        double valorTotal = Formatacao.ConvercaoMonetariaDouble(valorTotalContasPagarjTextField.getText());
        for (int i=0; i<listaContasPagar.size();i++){
            valorTotal = valorTotal - listaContasPagar.get(i).getValorConta();
        }
        return valorTotal;
    }
    
    public String validarContasPagar(){
        String mensagemErro = null;
        if (dataVencimentojDateChooser.getDate()==null){
            mensagemErro = "Data de Vencimento Inválida";
        }
        if (numeroDocumentojTextField.getText().length()<=0){
            mensagemErro = mensagemErro + "\\nNº Documento inválido";
        }
        if (valorContajTextField.getText().length()<=0){
            mensagemErro = mensagemErro + "\\nValor da conta inválido";
        }
        return mensagemErro;
    }

    
    public void registarContasPagar(){
        if (listaContasPagar!=null){
            ContasPagarController contasPagarController = new ContasPagarController();
            for (int i=0;i<listaContasPagar.size();i++){
                Contaspagar cp = new Contaspagar();
                cp = listaContasPagar.get(i);
                contasPagarController.salvar(cp);
            }
        }
    }

    public void setCliente(Object objeto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    

    public void setPlanoContas(Object objeto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public void carregarConfiguracao(){
        ConfiguracaoController configuracaoController = new ConfiguracaoController();
        this.configuracao = configuracaoController.getConfiguracao(config.getEmpresa().getIdempresa());
    }
    
    public String verificarAlteracaoValorVenda(double valorVenda, double valorEntrada){
        Double valor = valorVenda;
        Float valorVendafloat = valor.floatValue();
        valor = valorEntrada;
        Float valorEntradafloat = valor.floatValue();
        if (valorVendafloat < valorEntradafloat) {
            return "+";
        } else  if (valorVendafloat > valorEntradafloat){
            return "-";
        }else return "=";
    }

    public void setProdutoXML(Produto produto) {
        if (produto!=null){
            this.produto = produto;
            if (linhaNota>=0 && this.produto!=null){
                    localizarProdutoNFE();
            }else JOptionPane.showMessageDialog(rootPane, "Selecione os produtos");
        }
    }
    
    public String localizarcodgioBarras(String barras){
        CodigoBarrasController codigoBarrasController = new CodigoBarrasController();
        CodigoBarras codigoBarras = codigoBarrasController.pesquisarCodigo(barras);
        ProdutoController produtoController = new ProdutoController();
        if (codigoBarras!=null){
            Produto prod = produtoController.consultarProdutoid(codigoBarras.getProduto());
            if (prod!=null){
                return String.valueOf(prod.getReferencia());
            }else {
                return null;
            }
        }else {
            return null;
        }
    }
    
    public void marcarPedidosProduto() {
        if (forPediddo != null) {
            ForPedidoController forPedidoController = new ForPedidoController();
            listaPedidoProduto = forPedidoController.consultarForPedidoProduto(forPediddo);
            if (listaPedidoProduto != null) {
                EstoqueController estoqueController = new EstoqueController();
                for (int i = 0; i < listaPedidoProduto.size(); i++) {
                    Estoque estoque = estoqueController.consultarEstoque(listaPedidoProduto.get(i).getProduto(), config.getEmpresa().getIdempresa());
                    if (estoque != null) {
                        estoque.setDataPrevisao(null);
                        estoqueController.salvarEstoque(estoque);
                    }
                }
            }
        }
    }

    public void setArquivo(File arquivo) {
        if (arquivo!=null){
            caminhojTextField.setText(arquivo.getPath());
            try {
                gerarArquivoBanco(arquivo);
            } catch (IOException ex) {
                Logger.getLogger(FrmEntrada.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void gerarArquivoBanco(File arquivo) throws IOException {
        File file = arquivo;
        InputStream is = new FileInputStream(file);
        byte[] nfe = new byte[(int) file.length()];
        int offset = 0;
        int numRead = 0;
        while (offset < nfe.length
                && (numRead = is.read(nfe, offset, nfe.length - offset)) >= 0) {
            offset += numRead;
        }
        entradaEstoque.getNotaFiscal().setArquivonfe(nfe);
    }


   
}