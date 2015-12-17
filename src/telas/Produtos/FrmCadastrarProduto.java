/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FrmCadastrarProduto.java
 *
 * Created on 04/03/2011, 11:45:25
 */

package telas.Produtos;

import Interfaces.ItelaConsulta;
import Regras.EstoqueController;
import Regras.Formatacao;
import Regras.GrupoProdutoController;
import Regras.ParametroLocalController;
import Regras.ProdutoController;
import Regras.VinculoController;
import beanController.ProdutoRemotoBean;
import controler.Config;
import controler.Sigap;
import facade.*;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.*;
import modeloParametros.Parametros;
import telas.NCM.FrmConsultaNCM;

/**
 *
 * @author wolverine
 */
public class FrmCadastrarProduto extends javax.swing.JFrame implements ICadProduto{

    private Produto produto;
    private ItelaConsulta telaConsulta;
    private int codigo;
    private Aliquota aliquota;
    private Config config;
    private Estoque estoque;
    private boolean entrada;
    private boolean sair;
    private boolean novoProduto;
    private Vinculo vinculo;

    /** Creates new form FrmCadastrarProduto */
    public FrmCadastrarProduto(Produto produto, ItelaConsulta telaConsulta, Config config, boolean entrada, boolean novoProduto) {
        this.produto = produto;
        this.entrada =entrada;
        this.telaConsulta = telaConsulta;
        this.codigo = 0;
        this.sair = true;
        this.config = config;
        this.vinculo=null;
        this.novoProduto = novoProduto;
        initComponents();
        preencherGrupoProduto();
        preencherAliquota();
        preencherSubGrupo();
        if (this.produto==null){
            this.produto = new Produto();
            this.estoque = new Estoque();
            this.estoque.setQuantidadeEstoque(0.0);
            this.estoque.setQuantidadeMinima(0.0);
        } else {
            EstoqueController estoqueController = new EstoqueController();
            this.estoque = estoqueController.consultarEstoque(produto.getIdProduto(), config.getEmpresa().getIdempresa());
            preencherCampos();
//            String senha = JOptionPane.showInputDialog("Informe a Senha");
//            if (senha.equals("libera")) {
//                descricaojTextField.setEditable(true);
//            } else {
//                JOptionPane.showMessageDialog(null, "Acesso Negado");
//                descricaojTextField.setEditable(false);
//            }
        }
        URL url = this.getClass().getResource("/imagens/logo_mini.png");
        Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(imagemTitulo);
        this.setLocationRelativeTo(null);
        descricaojTextField.requestFocus();
        setVisible(true);
    }

    
    //Construtor para Cadastro direto da XML NF-e
    
    public FrmCadastrarProduto(Produto produto, Vinculo vinculo, Config config) {
        this.produto = produto;
        this.entrada =false;
        this.telaConsulta = null;
        this.codigo = 0;
        this.sair = true;
        this.config = config;
        this.novoProduto = true;
        this.vinculo = vinculo;
        this.estoque = new Estoque();
        estoque.setEmpresa(config.getEmpresa().getIdempresa());
        estoque.setPercentualVendas(0.0);
        estoque.setQuantidadeEstoque(0.0);
        estoque.setQuantidadeMaxima(0.0);
        estoque.setQuantidadeMinima(0.0);
        estoque.setValorCompra(0.0);
        estoque.setValorCusto(0.0);
        estoque.setValorDesconto(0.0f);
        estoque.setValorVenda(0.0f);
        initComponents();
        preencherGrupoProduto();
        preencherAliquota();
        preencherSubGrupo();
        preencherCampos();
        URL url = this.getClass().getResource("/imagens/logo_mini.png");
        Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(imagemTitulo);
        this.setLocationRelativeTo(null);
        codigojTextField.requestFocus();
        setVisible(true);
    }
    
    public final void preencherGrupoProduto(){
        GrupoProdutoFacade grupoProdutoFacade = new GrupoProdutoFacade();
        try {
            List<Grupoproduto> listaGrupoProduto = grupoProdutoFacade.listarGrupoProduto();
            for(int i=0;i<listaGrupoProduto.size();i++){
                grupojComboBox.addItem(listaGrupoProduto.get(i));
            }
        } catch (Exception ex) {
            Logger.getLogger(FrmCadastrarProduto.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public final void preencherSubGrupo(){
        GrupoProdutoFacade grupoProdutoFacade = new GrupoProdutoFacade();
        Grupoproduto grupoProduto = (Grupoproduto) grupojComboBox.getSelectedItem();
        subGrupojComboBox.removeAllItems();
        try {
            List<Subgrupoproduto> listaSubGrupo = grupoProdutoFacade.listarSubGrupoProduto(grupoProduto.getIdgrupoProduto());
            for (int i=0;i<listaSubGrupo.size();i++){
                subGrupojComboBox.addItem(listaSubGrupo.get(i));
            }
        } catch (Exception ex) {
            Logger.getLogger(FrmCadastrarProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public final void preencherAliquota(){
        AliquotaFacade aliquotaFacade = new AliquotaFacade();
        try {
            List<Aliquota> listaAliquota = aliquotaFacade.buscarAliquota();
            for (int i=0;i<listaAliquota.size();i++){
                aliquotajComboBox.addItem(listaAliquota.get(i));
            }
        } catch (Exception ex) {
            Logger.getLogger(FrmCadastrarProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public final void preencherCampos(){
        codigojTextField.setText(String.valueOf(produto.getReferencia()));
        descricaojTextField.setText(produto.getDescricao());
        unidadejComboBox.setSelectedItem(produto.getUnidade());
        if (produto.getPrecoFixo()==1){
            precoFixojComboBox.setSelectedIndex(0);
        }else precoFixojComboBox.setSelectedIndex(1);
        if (this.produto.getIdProduto()!=null){
            GrupoProdutoController grupoProdutoController = new GrupoProdutoController();
            Subgrupoproduto subGrupoProduto = grupoProdutoController.consultarSubGrupoProduto(produto.getSubgrupoproduto());
            Grupoproduto grupoProduto = grupoProdutoController.consultarGrupoProduto(subGrupoProduto.getGrupoproduto());
            grupojComboBox.setSelectedItem(grupoProduto);
            subGrupojComboBox.setSelectedItem(subGrupoProduto);
        }
        AliquotaFacade aliquotaFacade = new AliquotaFacade();
        Aliquota aliquota = null;
        try {
            aliquota = aliquotaFacade.buscarAliquotaid(produto.getAliquota());
        } catch (SQLException ex) {
            Logger.getLogger(FrmCadastrarProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
        aliquotajComboBox.setSelectedItem(aliquota);
        ipijFormattedTextField.setValue(produto.getIpi());
        ncmjTextField.setText(produto.getNcm());
        cestjTextField.setText(produto.getCest());
        mvajFormattedTextField.setValue(produto.getMva());
        situacaojComboBox.setSelectedItem(produto.getSituacao());
        valorVendajFormattedTextField.setText(Formatacao.foramtarFloatString(estoque.getValorVenda()));
        valorCustojFormattedTextField.setText(Formatacao.foramtarDoubleString(estoque.getValorCusto()));
        percVendajFormattedTextField.setText(Formatacao.foramtarDoubleString(estoque.getPercentualVendas()));
        valorDescontojFormattedTextField.setText(Formatacao.foramtarFloatString(estoque.getValorDesconto()));
        comissaojFormattedTextField.setText(Formatacao.foramtarDoubleString(produto.getPercentualComissao()));
    }





    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        descricaojTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        grupojComboBox = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        subGrupojComboBox = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        ipijFormattedTextField = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        ncmjTextField = new javax.swing.JTextField();
        mvajFormattedTextField = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        unidadejComboBox = new javax.swing.JComboBox();
        situacaojComboBox = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        aliquotajComboBox = new javax.swing.JComboBox();
        codigojTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        valorVendajFormattedTextField = new javax.swing.JFormattedTextField();
        valorDescontojFormattedTextField = new javax.swing.JFormattedTextField();
        percVendajFormattedTextField = new javax.swing.JFormattedTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        valorCustojFormattedTextField = new javax.swing.JFormattedTextField();
        precoFixojComboBox = new javax.swing.JComboBox();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        comissaojFormattedTextField = new javax.swing.JFormattedTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        buscaBancojButton1 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        cestjTextField = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        salvarjButton2 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Produto");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        descricaojTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                descricaojTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                descricaojTextFieldFocusLost(evt);
            }
        });

        jLabel2.setText("Descricao");

        grupojComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                grupojComboBoxItemStateChanged(evt);
            }
        });

        jLabel3.setText("Grupo");

        jLabel4.setText("SubGrupo");

        jLabel6.setText("% IPI");

        ipijFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        ipijFormattedTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        ipijFormattedTextField.setText("0");
        ipijFormattedTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ipijFormattedTextFieldFocusGained(evt);
            }
        });
        ipijFormattedTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ipijFormattedTextFieldKeyReleased(evt);
            }
        });

        jLabel7.setText("NCM");

        ncmjTextField.setText("0");
        ncmjTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ncmjTextFieldFocusGained(evt);
            }
        });

        mvajFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        mvajFormattedTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        mvajFormattedTextField.setText("0");
        mvajFormattedTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                mvajFormattedTextFieldFocusGained(evt);
            }
        });
        mvajFormattedTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                mvajFormattedTextFieldKeyReleased(evt);
            }
        });

        jLabel8.setText("% MVA");

        jLabel9.setText("Unidade");

        unidadejComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "UN", "MT", "KG", "CM", "LT" }));

        situacaojComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ativo", "Inativo" }));

        jLabel10.setText("Situacao");

        codigojTextField.setEditable(false);
        codigojTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        codigojTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                codigojTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                codigojTextFieldFocusLost(evt);
            }
        });

        jLabel1.setText("Código");

        valorVendajFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        valorVendajFormattedTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        valorVendajFormattedTextField.setText("0");
        valorVendajFormattedTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                valorVendajFormattedTextFieldFocusGained(evt);
            }
        });
        valorVendajFormattedTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                valorVendajFormattedTextFieldKeyReleased(evt);
            }
        });

        valorDescontojFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        valorDescontojFormattedTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        valorDescontojFormattedTextField.setText("0");
        valorDescontojFormattedTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                valorDescontojFormattedTextFieldFocusGained(evt);
            }
        });
        valorDescontojFormattedTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                valorDescontojFormattedTextFieldKeyReleased(evt);
            }
        });

        percVendajFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        percVendajFormattedTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        percVendajFormattedTextField.setText("0");
        percVendajFormattedTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                percVendajFormattedTextFieldFocusGained(evt);
            }
        });
        percVendajFormattedTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                percVendajFormattedTextFieldKeyReleased(evt);
            }
        });

        jLabel12.setText("% Venda");

        jLabel13.setText("Valor Custo");

        valorCustojFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        valorCustojFormattedTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        valorCustojFormattedTextField.setText("0");
        valorCustojFormattedTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                valorCustojFormattedTextFieldFocusGained(evt);
            }
        });
        valorCustojFormattedTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                valorCustojFormattedTextFieldKeyReleased(evt);
            }
        });

        precoFixojComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SIM", "NÃO" }));

        jLabel14.setText("Preço Fixo");

        jLabel15.setText("Valor Desconto");

        jLabel5.setText("% ICMS");

        comissaojFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        comissaojFormattedTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        comissaojFormattedTextField.setText("0");
        comissaojFormattedTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                comissaojFormattedTextFieldFocusGained(evt);
            }
        });
        comissaojFormattedTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                comissaojFormattedTextFieldKeyReleased(evt);
            }
        });

        jLabel16.setText("% Comissão");

        jLabel17.setText("Valor Venda");

        buscaBancojButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/magnifier.png"))); // NOI18N
        buscaBancojButton1.setToolTipText("Pesquisa NCM");
        buscaBancojButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscaBancojButton1ActionPerformed(evt);
            }
        });

        jLabel11.setText("CEST");

        cestjTextField.setText("0");
        cestjTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cestjTextFieldFocusGained(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(aliquotajComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel6)
                                .addComponent(ipijFormattedTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                                .addComponent(jLabel11)
                                .addComponent(cestjTextField))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel8)
                                .addComponent(mvajFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel16)
                                .addComponent(comissaojFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(grupojComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addComponent(subGrupojComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(valorVendajFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel17)
                                    .addGap(59, 59, 59)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(valorDescontojFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel15))))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(percVendajFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel12))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(valorCustojFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel13))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(situacaojComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel10))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(precoFixojComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel14)
                                    .addGap(0, 38, Short.MAX_VALUE))))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(codigojTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(descricaojTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(unidadejComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel9))))
                    .addComponent(jLabel7)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(ncmjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buscaBancojButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(descricaojTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(unidadejComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codigojTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(grupojComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(subGrupojComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel17)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(valorVendajFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel13)
                                                .addComponent(jLabel10)
                                                .addComponent(jLabel14))
                                            .addComponent(jLabel12))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(valorCustojFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(situacaojComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(precoFixojComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(percVendajFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(valorDescontojFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(aliquotajComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ipijFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(mvajFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comissaojFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ncmjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(buscaBancojButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cestjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 650, 280));

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        salvarjButton2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        salvarjButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/tick.png"))); // NOI18N
        salvarjButton2.setText("Salvar");
        salvarjButton2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        salvarjButton2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        salvarjButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarjButton2SalvarCadastroAssociado(evt);
            }
        });
        jPanel4.add(salvarjButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, -1, -1));

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cross.png"))); // NOI18N
        jButton2.setText("Fechar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2FecharCadastro(evt);
            }
        });
        jPanel4.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, -1, -1));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 300, 470, 40));

        jMenu1.setText("Parametros");

        jMenuItem1.setText("Código Produto");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem4.setText("Código Produto Manual");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void salvarjButton2SalvarCadastroAssociado(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarjButton2SalvarCadastroAssociado
        produto.setDescricao(descricaojTextField.getText());
        produto.setUnidade((String) unidadejComboBox.getSelectedItem());
        Subgrupoproduto subgrupo = ((Subgrupoproduto) subGrupojComboBox.getSelectedItem());
        produto.setSubgrupoproduto(subgrupo.getIdsubGrupoProduto());
        Aliquota aliquota = (Aliquota)aliquotajComboBox.getSelectedItem();
        produto.setAliquota(aliquota.getIdaliquota());
        produto.setIpi(Formatacao.ConvercaoMonetariaDouble(ipijFormattedTextField.getText()));
        if (ncmjTextField.getText().length()==0){
            produto.setNcm("0");
        }else produto.setNcm(ncmjTextField.getText());
        if (cestjTextField.getText().length()==0){
            produto.setCest("0");
        }else produto.setCest(cestjTextField.getText());
        if (comissaojFormattedTextField.getText().length()==0){
            produto.setPercentualComissao(0.0);
        }else produto.setPercentualComissao(Formatacao.ConvercaoMonetariaDouble(comissaojFormattedTextField.getText()));
        produto.setMva(Formatacao.ConvercaoMonetariaDouble(mvajFormattedTextField.getText()));
        produto.setSituacao((String) situacaojComboBox.getSelectedItem());
        produto.setReferencia(Integer.parseInt(codigojTextField.getText()));
        produto.setCodigoBarras(codigojTextField.getText());
        if (precoFixojComboBox.getSelectedItem().toString().equalsIgnoreCase("SIM")){
            produto.setPrecoFixo(1);
        }else produto.setPrecoFixo(2);
        if (this.novoProduto){
            produto.setCodigoNovo(produto.getReferencia());
            salvarProduto();
            if (vinculo!=null){
                salvarVinculo();
            }
            if (config.getEmpresa().getImportacao()==1){
                ProdutoRemotoBean produtoRemotoBean = new ProdutoRemotoBean(this.config);
                produtoRemotoBean.IniciarExportacaoProduto();
            }
        }else {
            salvarProduto();
            telaConsulta.setModelProduto(this.produto, this.estoque);
        }
        this.dispose();
}//GEN-LAST:event_salvarjButton2SalvarCadastroAssociado

    private void jButton2FecharCadastro(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2FecharCadastro
        if (codigojTextField.getText().length() > 0) {
            produto.setDescricao("******CADASTRO INCOMPLETO******");
            produto.setUnidade((String) unidadejComboBox.getSelectedItem());
            Subgrupoproduto subgrupo = ((Subgrupoproduto) subGrupojComboBox.getSelectedItem());
            produto.setSubgrupoproduto(subgrupo.getGrupoproduto());
            Aliquota aliquota = (Aliquota) aliquotajComboBox.getSelectedItem();
            produto.setAliquota(aliquota.getIdaliquota());
            produto.setIpi(Formatacao.ConvercaoMonetariaDouble(ipijFormattedTextField.getText()));
            produto.setNcm(ncmjTextField.getText());
            produto.setMva(Formatacao.ConvercaoMonetariaDouble(mvajFormattedTextField.getText()));
            produto.setSituacao((String) situacaojComboBox.getSelectedItem());
            produto.setReferencia(Integer.parseInt(codigojTextField.getText()));
            produto.setCodigoBarras(codigojTextField.getText());
            boolean remotoOK = false;
            if (novoProduto){
                    salvarProduto();
            }
            sair = false;
            this.dispose();
        }else {
            this.dispose();
        }
        
}//GEN-LAST:event_jButton2FecharCadastro

    private void grupojComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_grupojComboBoxItemStateChanged
        preencherSubGrupo();
    }//GEN-LAST:event_grupojComboBoxItemStateChanged

    private void ipijFormattedTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ipijFormattedTextFieldKeyReleased
        ipijFormattedTextField.setText(Sigap.decinalValorMonetario(ipijFormattedTextField.getText()));
    }//GEN-LAST:event_ipijFormattedTextFieldKeyReleased

    private void mvajFormattedTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mvajFormattedTextFieldKeyReleased
        mvajFormattedTextField.setText(Sigap.decinalValorMonetario(mvajFormattedTextField.getText()));
    }//GEN-LAST:event_mvajFormattedTextFieldKeyReleased

    private void valorVendajFormattedTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_valorVendajFormattedTextFieldKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_valorVendajFormattedTextFieldKeyReleased

    private void percVendajFormattedTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_percVendajFormattedTextFieldKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_percVendajFormattedTextFieldKeyReleased

    private void valorVendajFormattedTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_valorVendajFormattedTextFieldFocusGained
        valorVendajFormattedTextField.selectAll();
    }//GEN-LAST:event_valorVendajFormattedTextFieldFocusGained

    private void percVendajFormattedTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_percVendajFormattedTextFieldFocusGained
        percVendajFormattedTextField.selectAll();
    }//GEN-LAST:event_percVendajFormattedTextFieldFocusGained

    private void descricaojTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_descricaojTextFieldFocusGained
        descricaojTextField.selectAll();
    }//GEN-LAST:event_descricaojTextFieldFocusGained

    private void ipijFormattedTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ipijFormattedTextFieldFocusGained
        ipijFormattedTextField.selectAll();
    }//GEN-LAST:event_ipijFormattedTextFieldFocusGained

    private void ncmjTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ncmjTextFieldFocusGained
        ncmjTextField.selectAll();
    }//GEN-LAST:event_ncmjTextFieldFocusGained

    private void mvajFormattedTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_mvajFormattedTextFieldFocusGained
        mvajFormattedTextField.selectAll();
    }//GEN-LAST:event_mvajFormattedTextFieldFocusGained

    private void codigojTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_codigojTextFieldFocusLost
        if (sair) {
            if ((codigojTextField.isEditable())) {
                int codigo = 0;
                if (codigojTextField.getText().equalsIgnoreCase("")) {
                    codigo = 0;
                } else {
                    codigo = Integer.parseInt(codigojTextField.getText());
                }
                if ((codigo < 90000) && (codigo > 0)) {
                    JOptionPane.showMessageDialog(null, "Sequencia de Codigo não Permitida");
                    codigojTextField.setText("");
                    codigojTextField.requestFocus();
                    codigojTextField.selectAll();
                } else {
                    ProdutoFacade produtoFacade = new ProdutoFacade();
                    Produto pesquisa = new Produto();
                    try {
                        pesquisa = produtoFacade.consultarProdutoReferencia(codigo);
                        if (pesquisa != null) {
                            codigojTextField.setText("");
                            JOptionPane.showMessageDialog(null, "Código já Cadastrado");
                            codigojTextField.requestFocus();
                            codigojTextField.selectAll();
                        }
                    } catch (Exception ex) {
                        Logger.getLogger(FrmCadastrarProduto.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(null, "Erro pesquisa Referencia");
                    }
                }
            }
        }else {
            codigo = Integer.parseInt(codigojTextField.getText());
            ProdutoFacade produtoFacade = new ProdutoFacade();
            Produto pesquisa = new Produto();
            try {
                pesquisa = produtoFacade.consultarProdutoReferencia(codigo);
                if (pesquisa != null) {
                    codigojTextField.setText("");
                    JOptionPane.showMessageDialog(null, "Código já Cadastrado");
                    codigojTextField.requestFocus();
                    codigojTextField.selectAll();
                }
            } catch (Exception ex) {
                Logger.getLogger(FrmCadastrarProduto.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Erro pesquisa Referencia");
            }
        }
    }//GEN-LAST:event_codigojTextFieldFocusLost

private void valorCustojFormattedTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_valorCustojFormattedTextFieldFocusGained
// TODO add your handling code here:
}//GEN-LAST:event_valorCustojFormattedTextFieldFocusGained

private void valorCustojFormattedTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_valorCustojFormattedTextFieldKeyReleased
// TODO add your handling code here:
}//GEN-LAST:event_valorCustojFormattedTextFieldKeyReleased

    private void codigojTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_codigojTextFieldFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_codigojTextFieldFocusGained

    private void descricaojTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_descricaojTextFieldFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_descricaojTextFieldFocusLost

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
//        String senha = JOptionPane.showInputDialog("Informe a Senha");
//        if (senha.equalsIgnoreCase("libera")) {
            codigojTextField.setEditable(true);
            codigojTextField.requestFocus();
            sair = false;
//        }else JOptionPane.showMessageDialog(null, "Acesso Negado");
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        ParametrosFacade parametrosFacade = new ParametrosFacade();
        Parametros parametros = new Parametros();
        try {
            parametros = parametrosFacade.localizar(config.getEmpresa().getIdparametros());
        } catch (Exception ex) {
            Logger.getLogger(FrmCadastrarProduto.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Gerar Código " + ex);
        }
        int codigo = 0;
        if (parametros != null) {
            codigo = parametros.getCodigoProduto();
            codigo = codigo + 1;
            ProdutoController produtoController = new ProdutoController();
            Produto prodCodigo = produtoController.consultarProdutoReferencia(codigo);
            if (prodCodigo == null) {
                salvarCodigo(parametros, codigo);
                codigojTextField.setText(String.valueOf(codigo));
                parametros.setCodigoProduto(codigo);
                try {
                    parametrosFacade.salvar(parametros);
                } catch (Exception ex) {
                    Logger.getLogger(FrmCadastrarProduto.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "Erro Salvar Código " + ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Código já Cadastrado:  " + prodCodigo.getDescricao());
                salvarParametroCodigo(parametros, codigo);
            }
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void valorDescontojFormattedTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_valorDescontojFormattedTextFieldFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_valorDescontojFormattedTextFieldFocusGained

    private void valorDescontojFormattedTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_valorDescontojFormattedTextFieldKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_valorDescontojFormattedTextFieldKeyReleased

    private void comissaojFormattedTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_comissaojFormattedTextFieldFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_comissaojFormattedTextFieldFocusGained

    private void comissaojFormattedTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_comissaojFormattedTextFieldKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_comissaojFormattedTextFieldKeyReleased

    private void buscaBancojButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscaBancojButton1ActionPerformed
        new FrmConsultaNCM(this);
    }//GEN-LAST:event_buscaBancojButton1ActionPerformed

    private void cestjTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cestjTextFieldFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_cestjTextFieldFocusGained

    
    
        /**
    * @param args the command line arguments
    */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox aliquotajComboBox;
    private javax.swing.JButton buscaBancojButton1;
    private javax.swing.JTextField cestjTextField;
    private javax.swing.JTextField codigojTextField;
    private javax.swing.JFormattedTextField comissaojFormattedTextField;
    private javax.swing.JTextField descricaojTextField;
    private javax.swing.JComboBox grupojComboBox;
    private javax.swing.JFormattedTextField ipijFormattedTextField;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JFormattedTextField mvajFormattedTextField;
    private javax.swing.JTextField ncmjTextField;
    private javax.swing.JFormattedTextField percVendajFormattedTextField;
    private javax.swing.JComboBox precoFixojComboBox;
    private javax.swing.JButton salvarjButton2;
    private javax.swing.JComboBox situacaojComboBox;
    private javax.swing.JComboBox subGrupojComboBox;
    private javax.swing.JComboBox unidadejComboBox;
    private javax.swing.JFormattedTextField valorCustojFormattedTextField;
    private javax.swing.JFormattedTextField valorDescontojFormattedTextField;
    private javax.swing.JFormattedTextField valorVendajFormattedTextField;
    // End of variables declaration//GEN-END:variables

        
    public void salvarCodigo(Parametros parametro, int codigo){
        Produto produto = new Produto();
        produto.setReferencia(codigo);
        produto.setCodigoNovo(codigo);
        produto.setSincronizado(0);
        produto.setDescricao("AAAAAAAAAAAAAAAAAAAA");
        produto.setSubgrupoproduto(1);
        produto.setAliquota(1);
        produto.setIpi(0.0);
        produto.setMva(0.0);
        produto.setSituacao("ATIVO");
        produto.setPrecoFixo(1);
        this.produto = produto;
        salvarProduto();
        salvarParametroCodigo(parametro, codigo);
    }
    
    public void salvarParametroCodigo(Parametros parametro, int codigo){
        ParametrosFacade parametrosFacade = new ParametrosFacade();
        parametro.setCodigoProduto(codigo);
        try {
            parametrosFacade.salvar(parametro);
        } catch (Exception ex) {
            Logger.getLogger(FrmCadastrarProduto.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(rootPane, "Erro Salvar Código");
        }
    }
    
    public void gerarEstoque(){
        if (valorVendajFormattedTextField.getText().equalsIgnoreCase("")){
            estoque.setValorVenda(Float.valueOf(0)); 
        }else estoque.setValorVenda(Formatacao.formatarStringfloat(valorVendajFormattedTextField.getText()));
        if (valorDescontojFormattedTextField.getText().equalsIgnoreCase("")){
            estoque.setValorDesconto(Float.valueOf(0)); 
        }else estoque.setValorDesconto(Formatacao.formatarStringfloat(valorDescontojFormattedTextField.getText()));
         if (valorCustojFormattedTextField.getText().equalsIgnoreCase("")){
            estoque.setValorCusto(Double.valueOf(0)); 
        }else estoque.setValorCusto(Formatacao.formatarStringDouble(valorCustojFormattedTextField.getText()));
        if (percVendajFormattedTextField.getText().equalsIgnoreCase("")){
            estoque.setPercentualVendas(0.0);
        }else estoque.setPercentualVendas(Formatacao.formatarStringDouble(percVendajFormattedTextField.getText()));
        estoque.setValorCompra(0.0);
        estoque.setProduto(produto.getIdProduto());
    }
    
    public Estoque verificarEstoque(int idProduto, int idEmpresa){
        EstoqueController estoqueController = new EstoqueController();
        Estoque verficarEstoque = new Estoque();
        verficarEstoque = estoqueController.consultarEstoque(idProduto, idEmpresa);
        return verficarEstoque;
    }
    
    public void verificarTipoSalvarEstoque() {
        ParametroLocalController parametroLocalController = new ParametroLocalController();
        ParametrosLocal parametrosLocal = parametroLocalController.localizarEmpresa(config.getEmpresa().getIdparametros());
        if (parametrosLocal != null) {
            if (!novoProduto) {
                salvarEstoqueEmrpesaCorrente();
                AlterarEstoqueEmrpesaCorrente();
            } else {
                salvarEstoqueEmrpesaCorrente();
            }
        }
    }
    
    public void salvarEstoqueEmrpesaCorrente(){
        Estoque verEstoque = verificarEstoque(this.produto.getIdProduto(), this.config.getEmpresa().getIdempresa());
        if (verEstoque==null){
            estoque = new Estoque();
            gerarEstoque();
            estoque.setEmpresa(this.config.getEmpresa().getIdempresa());
            SalvarEstoque();
        }
    }
    
    public void AlterarEstoqueEmrpesaCorrente(){
        if (estoque!=null){
            estoque.setValorVenda(Formatacao.formatarStringfloat(valorVendajFormattedTextField.getText()));
            estoque.setValorDesconto(Formatacao.formatarStringfloat(valorDescontojFormattedTextField.getText()));
            estoque.setValorCusto(Formatacao.formatarStringDouble(valorCustojFormattedTextField.getText()));
            SalvarEstoque();
        }
    }
    
//    public void salvarEstoqueTodasEmpresas() {
//        EmpresaController empresaController = new EmpresaController();
//        List<Empresa> listaEmpresas = empresaController.listarEmpresas();
//        for (int i = 0; i < listaEmpresas.size(); i++) {
//            Estoque verEstoque = verificarEstoque(this.produto.getIdProduto(), listaEmpresas.get(i).getIdempresa());
//            int idEmpresaCorrente = this.config.getEmpresa().getIdempresa();
//            int idOutrasEmpreasa = listaEmpresas.get(i).getIdempresa();
//            if (verEstoque != null) {
//                this.estoque = verEstoque;
//                gerarEstoque();
//                estoque.setEmpresa(listaEmpresas.get(i).getIdempresa());
//            } else {
//                estoque = new Estoque();
//                gerarEstoque();
//                estoque.setEmpresa(listaEmpresas.get(i).getIdempresa());
//            }
//            if (idEmpresaCorrente!=idOutrasEmpreasa){
//                estoque.setValorCompra(0.0);
//                estoque.setValorCusto(0.0);
//                estoque.setValorVenda(0.0f);
//            }
//            SalvarEstoque();
//        }
//    }
    
    public void SalvarEstoque(){
        EstoqueController estoqueController = new EstoqueController();
        if (estoque.getQuantidadeEstoque()==null){
            estoque.setQuantidadeEstoque(0.0);
        }
        if (estoque.getQuantidadeMaxima()==null){
            estoque.setQuantidadeMaxima(0.0);
        }
        if (estoque.getQuantidadeMinima()==null){
            estoque.setQuantidadeMinima(0.0);
        }
        if (estoque.getValorCompra()==null){
            estoque.setValorCompra(0.0);
        }
        if (estoque.getValorCusto()==null){
            estoque.setValorCusto(0.0);
        }
        if (estoque.getValorDesconto()==null){
            estoque.setValorDesconto(0.0f);
        }
        if (estoque.getValorVenda()==null){
            estoque.setValorVenda(0.0f);
        }
        estoqueController.salvarEstoque(estoque);
    }
    
    public void salvarVinculo(){
        VinculoController vinculoController = new VinculoController();
        vinculoController.salvarVinculo(vinculo);
    }
    
    private void salvarProduto(){
        ProdutoController produtoController = new ProdutoController();
        this.produto = produtoController.salvarProduto(produto);
        verificarTipoSalvarEstoque();
    }

    public void consultaNCM(Cest ncm) {
        if (ncm!=null){
            ncmjTextField.setText(ncm.getNcm());
            cestjTextField.setText(ncm.getCest());
        }
    }
}
