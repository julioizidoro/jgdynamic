/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PesquisaAssociado.java
 *
 * Created on 20/09/2009, 15:29:05
 */
package telas.Fornecedor;

import Interfaces.IforPedido;
import Interfaces.ItelaConsulta;
import beanController.NfDuplicatas;
import beanController.NfProdutos;
import beanController.NotaEletronica;
import controler.ImprimirJtable;
import facade.FornecedorFacade;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Banco;
import model.Estoque;
import model.Fornecedor;
import model.Produto;
import telas.ContasPagar.IrContasPagar;
import telas.ControleCheques.ItelaControleCheque;
import telas.Devolucao.Defeito.IDevolucaoDefeito;
import telas.Estoque.FrmRelatorioEstoque;
import telas.NotaSaida.INotaSaidaBean;
import telas.RelatorioVendas.FrmRelatorioVenda;
import telas.RelatorioVendas.ItelaGiro;


public final class FrmConsultaFornecedor extends javax.swing.JFrame implements ItelaConsulta {

    private ItelaConsulta telaConsulta;
    private ConsultaFornecedorTableModel model;
    private List<Fornecedor> listaFornecedor;
    private FrmRelatorioEstoque relatorioEstoque;
    private IrContasPagar rContasPagar;
    private FrmRelatorioVenda frmRelatorioVenda;
    private ItelaGiro telaGiro;
    private IforPedido telaPedido;
    private ItelaControleCheque telaCheque;
    private IDevolucaoDefeito telaDefeito;
    private INotaSaidaBean telaNotaSaida;

    public FrmConsultaFornecedor(ItelaConsulta telaConsulta) {
        this.telaConsulta = telaConsulta;
        this.telaPedido = null;
        this.telaCheque = null;
        initComponents();             
        URL url = this.getClass().getResource("/imagens/logo_mini.png");
        Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(imagemTitulo);
        this.setLocationRelativeTo(null);
        setModelProduto(null, null);
        nomejTextField.requestFocus();
        setVisible(true);
    }
    
    public FrmConsultaFornecedor(INotaSaidaBean telaNotaSaida) {
        this.telaNotaSaida = telaNotaSaida;
        this.telaPedido = null;
        this.telaCheque = null;
        initComponents();             
        URL url = this.getClass().getResource("/imagens/logo_mini.png");
        Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(imagemTitulo);
        this.setLocationRelativeTo(null);
        setModelProduto(null, null);
        nomejTextField.requestFocus();
        setVisible(true);
    }
    
     public FrmConsultaFornecedor(ItelaGiro telagiro) {
        this.telaConsulta = null;
        telaPedido = null;
        this.telaCheque = null;
        this.telaGiro = telagiro;
        initComponents();             
        URL url = this.getClass().getResource("/imagens/logo_mini.png");
        Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(imagemTitulo);
        this.setLocationRelativeTo(null);
        setModelProduto(null, null);
        nomejTextField.requestFocus();
        setVisible(true);
    }
     
     public FrmConsultaFornecedor(IDevolucaoDefeito teladefeito) {
        this.telaConsulta = null;
        telaPedido = null;
        this.telaCheque = null;
        this.telaDefeito = teladefeito;
        initComponents();             
        URL url = this.getClass().getResource("/imagens/logo_mini.png");
        Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(imagemTitulo);
        this.setLocationRelativeTo(null);
        setModelProduto(null, null);
        nomejTextField.requestFocus();
        setVisible(true);
    }
    
    public FrmConsultaFornecedor() {
        this.telaConsulta = null;
        this.telaPedido =null;
        this.telaCheque = null;
        initComponents();             
        URL url = this.getClass().getResource("/imagens/logo_mini.png");
        Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(imagemTitulo);
        this.setLocationRelativeTo(null);
        setModelProduto(null, null);
        nomejTextField.requestFocus();
        setVisible(true);
    }
    
    public FrmConsultaFornecedor(IforPedido telaPedido) {
        this.telaConsulta = null;
        this.telaPedido = telaPedido;
        this.telaCheque = null;
        initComponents();             
        URL url = this.getClass().getResource("/imagens/logo_mini.png");
        Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(imagemTitulo);
        this.setLocationRelativeTo(null);
        setModelProduto(null, null);
        nomejTextField.requestFocus();
        setVisible(true);
    }
    
    public FrmConsultaFornecedor(ItelaControleCheque telaCheque) {
        this.telaConsulta = null;
        this.telaPedido = null;
        this.telaCheque = telaCheque;
        initComponents();             
        URL url = this.getClass().getResource("/imagens/logo_mini.png");
        Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(imagemTitulo);
        this.setLocationRelativeTo(null);
        setModelProduto(null, null);
        nomejTextField.requestFocus();
        setVisible(true);
    }
    
    public FrmConsultaFornecedor(FrmRelatorioEstoque relatorioEstoque) {
        initComponents();      
        this.telaPedido = null;
        this.telaCheque = null;
        this.relatorioEstoque = relatorioEstoque;
        URL url = this.getClass().getResource("/imagens/logo_mini.png");
        Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(imagemTitulo);
        this.setLocationRelativeTo(null);
        setModelProduto(null, null);
        nomejTextField.requestFocus();
        setVisible(true);
    }
    
    public FrmConsultaFornecedor(IrContasPagar rContasPagar) {
        initComponents();
        this.rContasPagar = rContasPagar;
        this.telaPedido = null;
        this.telaCheque = null;
        URL url = this.getClass().getResource("/imagens/logo_mini.png");
        Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(imagemTitulo);
        this.setLocationRelativeTo(null);
        setModelProduto(null, null);
        nomejTextField.requestFocus();
        setVisible(true);
    }
    
    public FrmConsultaFornecedor(FrmRelatorioVenda frmRelatorioVenda) {
        initComponents();      
        this.frmRelatorioVenda = frmRelatorioVenda;
        this.telaCheque = null;
        URL url = this.getClass().getResource("/imagens/logo_mini.png");
        Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(imagemTitulo);
        this.setLocationRelativeTo(null);
        setModelProduto(null, null);
        nomejTextField.requestFocus();
        setVisible(true);
    }

    /** Creates new form PesquisaAssociado */


    

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        AssociadosjPanel = new javax.swing.JPanel();
        nomejTextField = new javax.swing.JTextField();
        TabeladeAssociadosScrollPane = new javax.swing.JScrollPane();
        fornecedorjTable = new javax.swing.JTable();
        NomedoAssociadojLabel = new javax.swing.JLabel();
        BarradeTarefasjToolBar = new javax.swing.JToolBar();
        AdicionarjButton = new javax.swing.JButton();
        EditarjButton = new javax.swing.JButton();
        ExcluirjButton = new javax.swing.JButton();
        SeparadordeTarefasjSeparator = new javax.swing.JToolBar.Separator();
        ImprimirjButton = new javax.swing.JButton();
        VisualizarjButton = new javax.swing.JButton();
        RelatoriojButton = new javax.swing.JButton();
        FecharrjButton = new javax.swing.JButton();
        codigojTextField = new javax.swing.JTextField();
        NomedoAssociadojLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta de Produtos");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setIconImages(null);
        setLocationByPlatform(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        AssociadosjPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        AssociadosjPanel.setPreferredSize(new java.awt.Dimension(800, 600));
        AssociadosjPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nomejTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nomejTextFieldKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nomejTextFieldKeyReleased(evt);
            }
        });
        AssociadosjPanel.add(nomejTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 410, -1));

        fornecedorjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Código", "Razão Social", "Nome Fantasia", "Fone Comercial", "Fone Fax", "Fone Celular"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        fornecedorjTable.setToolTipText("Tabela de Associados");
        fornecedorjTable.setAutoscrolls(false);
        fornecedorjTable.setColumnSelectionAllowed(true);
        fornecedorjTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        fornecedorjTable.getTableHeader().setReorderingAllowed(false);
        fornecedorjTable.getColumnModel().getColumn(0).setPreferredWidth(400);
        fornecedorjTable.getColumnModel().getColumn(1).setPreferredWidth(100);
        fornecedorjTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fornecedorjTableMouseClicked(evt);
            }
        });
        fornecedorjTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fornecedorjTableKeyPressed(evt);
            }
        });
        TabeladeAssociadosScrollPane.setViewportView(fornecedorjTable);
        fornecedorjTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        fornecedorjTable.getColumnModel().getColumn(0).setResizable(false);
        fornecedorjTable.getColumnModel().getColumn(0).setPreferredWidth(5);
        fornecedorjTable.getColumnModel().getColumn(1).setResizable(false);
        fornecedorjTable.getColumnModel().getColumn(1).setPreferredWidth(130);
        fornecedorjTable.getColumnModel().getColumn(2).setResizable(false);
        fornecedorjTable.getColumnModel().getColumn(2).setPreferredWidth(130);
        fornecedorjTable.getColumnModel().getColumn(3).setResizable(false);
        fornecedorjTable.getColumnModel().getColumn(3).setPreferredWidth(10);
        fornecedorjTable.getColumnModel().getColumn(4).setResizable(false);
        fornecedorjTable.getColumnModel().getColumn(4).setPreferredWidth(10);
        fornecedorjTable.getColumnModel().getColumn(5).setResizable(false);
        fornecedorjTable.getColumnModel().getColumn(5).setPreferredWidth(10);

        AssociadosjPanel.add(TabeladeAssociadosScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 810, 210));

        NomedoAssociadojLabel.setFont(new java.awt.Font("Tahoma", 0, 12));
        NomedoAssociadojLabel.setText("Código");
        AssociadosjPanel.add(NomedoAssociadojLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        BarradeTarefasjToolBar.setFloatable(false);
        BarradeTarefasjToolBar.setRollover(true);

        AdicionarjButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/novo.png"))); // NOI18N
        AdicionarjButton.setText("Adicionar");
        AdicionarjButton.setToolTipText("Adicionar Associado");
        AdicionarjButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        AdicionarjButton.setMaximumSize(new java.awt.Dimension(80, 90));
        AdicionarjButton.setMinimumSize(new java.awt.Dimension(80, 90));
        AdicionarjButton.setName(""); // NOI18N
        AdicionarjButton.setPreferredSize(new java.awt.Dimension(80, 90));
        AdicionarjButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        AdicionarjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdicionarAssociado(evt);
            }
        });
        BarradeTarefasjToolBar.add(AdicionarjButton);

        EditarjButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/alterar.png"))); // NOI18N
        EditarjButton.setText("Editar");
        EditarjButton.setToolTipText("Editar Associado");
        EditarjButton.setEnabled(false);
        EditarjButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        EditarjButton.setMaximumSize(new java.awt.Dimension(80, 90));
        EditarjButton.setMinimumSize(new java.awt.Dimension(80, 90));
        EditarjButton.setPreferredSize(new java.awt.Dimension(80, 90));
        EditarjButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        EditarjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarCadastroAssociado(evt);
            }
        });
        BarradeTarefasjToolBar.add(EditarjButton);

        ExcluirjButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/excluir.png"))); // NOI18N
        ExcluirjButton.setText("Excluir");
        ExcluirjButton.setToolTipText("Excluir Associado");
        ExcluirjButton.setEnabled(false);
        ExcluirjButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ExcluirjButton.setMaximumSize(new java.awt.Dimension(80, 90));
        ExcluirjButton.setMinimumSize(new java.awt.Dimension(80, 90));
        ExcluirjButton.setPreferredSize(new java.awt.Dimension(80, 90));
        ExcluirjButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        ExcluirjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExcluirjButtonActionPerformed(evt);
            }
        });
        BarradeTarefasjToolBar.add(ExcluirjButton);
        BarradeTarefasjToolBar.add(SeparadordeTarefasjSeparator);

        ImprimirjButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/impressao.png"))); // NOI18N
        ImprimirjButton.setText("Imprimir");
        ImprimirjButton.setToolTipText("Imprimir");
        ImprimirjButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ImprimirjButton.setMaximumSize(new java.awt.Dimension(80, 90));
        ImprimirjButton.setMinimumSize(new java.awt.Dimension(80, 90));
        ImprimirjButton.setPreferredSize(new java.awt.Dimension(80, 90));
        ImprimirjButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        ImprimirjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImprimirjButtonActionPerformed(evt);
            }
        });
        BarradeTarefasjToolBar.add(ImprimirjButton);

        VisualizarjButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/visualizar.png"))); // NOI18N
        VisualizarjButton.setText("Visualizar");
        VisualizarjButton.setToolTipText("Visualizar Cadastro");
        VisualizarjButton.setEnabled(false);
        VisualizarjButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        VisualizarjButton.setMaximumSize(new java.awt.Dimension(80, 90));
        VisualizarjButton.setMinimumSize(new java.awt.Dimension(80, 90));
        VisualizarjButton.setPreferredSize(new java.awt.Dimension(80, 90));
        VisualizarjButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        VisualizarjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VisualizarjButtonActionPerformed(evt);
            }
        });
        BarradeTarefasjToolBar.add(VisualizarjButton);

        RelatoriojButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/relatorio.png"))); // NOI18N
        RelatoriojButton.setText("Relatórios");
        RelatoriojButton.setToolTipText("Relatórios");
        RelatoriojButton.setEnabled(false);
        RelatoriojButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        RelatoriojButton.setMaximumSize(new java.awt.Dimension(80, 90));
        RelatoriojButton.setMinimumSize(new java.awt.Dimension(80, 90));
        RelatoriojButton.setPreferredSize(new java.awt.Dimension(80, 90));
        RelatoriojButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        RelatoriojButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatoriojButtonActionPerformed(evt);
            }
        });
        BarradeTarefasjToolBar.add(RelatoriojButton);

        FecharrjButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/voltar.png"))); // NOI18N
        FecharrjButton.setText("Fechar");
        FecharrjButton.setToolTipText("Fechar");
        FecharrjButton.setFocusable(false);
        FecharrjButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        FecharrjButton.setMaximumSize(new java.awt.Dimension(80, 90));
        FecharrjButton.setMinimumSize(new java.awt.Dimension(80, 90));
        FecharrjButton.setPreferredSize(new java.awt.Dimension(80, 90));
        FecharrjButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        FecharrjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FecharAssociado(evt);
            }
        });
        BarradeTarefasjToolBar.add(FecharrjButton);

        AssociadosjPanel.add(BarradeTarefasjToolBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 300, 600, 80));

        codigojTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                codigojTextFieldKeyPressed(evt);
            }
        });
        AssociadosjPanel.add(codigojTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 90, -1));

        NomedoAssociadojLabel1.setFont(new java.awt.Font("Tahoma", 0, 12));
        NomedoAssociadojLabel1.setText("Razão Social/ Nome Fantasia");
        AssociadosjPanel.add(NomedoAssociadojLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, -1, -1));

        getContentPane().add(AssociadosjPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AdicionarAssociado(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdicionarAssociado
        new FrmCadastrarFornecedor(null, this);
    }//GEN-LAST:event_AdicionarAssociado

    private void EditarCadastroAssociado(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarCadastroAssociado
        int linha = fornecedorjTable.getSelectedRow();
        if (linha>=0){
            new FrmCadastrarFornecedor(this.listaFornecedor.get(linha), this);
        }
    }//GEN-LAST:event_EditarCadastroAssociado

    private void FecharAssociado(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FecharAssociado
        this.dispose();
    }//GEN-LAST:event_FecharAssociado

    private void fornecedorjTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fornecedorjTableMouseClicked
        if (evt.getClickCount()==1){
            EditarjButton.setEnabled(true);
            ExcluirjButton.setEnabled(true);
        }else if (evt.getClickCount()==2){
            int linha = fornecedorjTable.getSelectedRow();
            if (linha>=0){
                if (telaConsulta!=null){
                    telaConsulta.setFornecedor(listaFornecedor.get(linha));
                }else if (this.relatorioEstoque!=null){
                    relatorioEstoque.consultarFornecedor(listaFornecedor.get(linha));
                }else if (this.rContasPagar!=null){
                    rContasPagar.consultarFornecedor(listaFornecedor.get(linha));
                }else if (this.frmRelatorioVenda!=null){
                    frmRelatorioVenda.consultarFornecedor(listaFornecedor.get(linha));
                }else if (this.telaGiro!=null){
                    telaGiro.setFornecedor(listaFornecedor.get(linha));
                }else if (telaPedido!=null){
                    telaPedido.vincularNovoFornecedor(listaFornecedor.get(linha));
                }else if (telaCheque!=null){
                    telaCheque.consultarFornecedor(listaFornecedor.get(linha));
                }else if (telaDefeito!=null){
                    telaDefeito.consultarFornecedor(listaFornecedor.get(linha));
                }else if (telaNotaSaida!=null){
                    telaNotaSaida.consultaFornecedor(listaFornecedor.get(linha));
                }
                this.dispose();
            }
        }
    }//GEN-LAST:event_fornecedorjTableMouseClicked

    private void nomejTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomejTextFieldKeyReleased
        FornecedorFacade fornecedorFacade = new FornecedorFacade();
        try {
            listaFornecedor = fornecedorFacade.consultarFornecedorRazaoSocial(nomejTextField.getText(), nomejTextField.getText());
            setModelFornecedor();
        } catch (SQLException ex) {
            Logger.getLogger(FrmConsultaFornecedor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_nomejTextFieldKeyReleased

    private void ImprimirjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImprimirjButtonActionPerformed
        new ImprimirJtable(fornecedorjTable, "Relação de Fornecedores");
    }//GEN-LAST:event_ImprimirjButtonActionPerformed

    private void RelatoriojButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatoriojButtonActionPerformed
            
        
    }//GEN-LAST:event_RelatoriojButtonActionPerformed

    private void VisualizarjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VisualizarjButtonActionPerformed
        
    }//GEN-LAST:event_VisualizarjButtonActionPerformed

    private void ExcluirjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExcluirjButtonActionPerformed
        int linha = fornecedorjTable.getSelectedRow();
        if (linha>=0){
            FornecedorFacade fornecedorFacade = new FornecedorFacade();
            try {
                fornecedorFacade.excluir(this.listaFornecedor.get(linha));
                setModelProduto(null, null);
            } catch (Exception ex) {
                Logger.getLogger(FrmConsultaFornecedor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_ExcluirjButtonActionPerformed

    private void codigojTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codigojTextFieldKeyPressed
           if (!codigojTextField.getText().equalsIgnoreCase("")){
           FornecedorFacade fornecedorFacade = new FornecedorFacade();
           Fornecedor fornecedor = new Fornecedor();
            try {
                fornecedor = fornecedorFacade.consultarFornecedor(Integer.parseInt(codigojTextField.getText()));
                 listaFornecedor.removeAll(listaFornecedor);
                 listaFornecedor.add(fornecedor);
                 setModelFornecedor();
            } catch (SQLException ex) {
                Logger.getLogger(FrmConsultaFornecedor.class.getName()).log(Level.SEVERE, null, ex);
            }  
       }else {
           JOptionPane.showMessageDialog(null, "Preencha o campo código");
       }

    }//GEN-LAST:event_codigojTextFieldKeyPressed

    private void nomejTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomejTextFieldKeyPressed
        if ((evt.getKeyCode() == evt.VK_UP) || (evt.getKeyCode() == evt.VK_DOWN)){
            fornecedorjTable.requestFocus();
        }
    }//GEN-LAST:event_nomejTextFieldKeyPressed

    private void fornecedorjTableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fornecedorjTableKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            int linha = fornecedorjTable.getSelectedRow();
            if (linha >= 0) {
                telaConsulta.setFornecedor(listaFornecedor.get(linha));
                this.dispose();
            }
        }
    }//GEN-LAST:event_fornecedorjTableKeyPressed
    /**
     * @param args the command line arguments
     */
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AdicionarjButton;
    private javax.swing.JPanel AssociadosjPanel;
    private javax.swing.JToolBar BarradeTarefasjToolBar;
    private javax.swing.JButton EditarjButton;
    private javax.swing.JButton ExcluirjButton;
    private javax.swing.JButton FecharrjButton;
    private javax.swing.JButton ImprimirjButton;
    private javax.swing.JLabel NomedoAssociadojLabel;
    private javax.swing.JLabel NomedoAssociadojLabel1;
    private javax.swing.JButton RelatoriojButton;
    private javax.swing.JToolBar.Separator SeparadordeTarefasjSeparator;
    private javax.swing.JScrollPane TabeladeAssociadosScrollPane;
    private javax.swing.JButton VisualizarjButton;
    private javax.swing.JTextField codigojTextField;
    private javax.swing.JTable fornecedorjTable;
    private javax.swing.JTextField nomejTextField;
    // End of variables declaration//GEN-END:variables
    
    public void setModelFornecedor(){
        model = new ConsultaFornecedorTableModel(listaFornecedor); 
        fornecedorjTable.setModel(model);
        fornecedorjTable.getColumnModel().getColumn(0).setPreferredWidth(5);
        fornecedorjTable.getColumnModel().getColumn(1).setPreferredWidth(130);
        fornecedorjTable.getColumnModel().getColumn(2).setPreferredWidth(130);
        fornecedorjTable.getColumnModel().getColumn(3).setPreferredWidth(10);
        fornecedorjTable.getColumnModel().getColumn(4).setPreferredWidth(10);
        fornecedorjTable.getColumnModel().getColumn(5).setPreferredWidth(10);
        fornecedorjTable.repaint();
    }
    
    public void setData(Object objeto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setBanco(Banco banco) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setModelProduto(Produto produto, Estoque estoque) {
        FornecedorFacade fornecedorFacade = new FornecedorFacade();
         try {
            this.listaFornecedor = fornecedorFacade.consultarFornecedor();
            setModelFornecedor();
        } catch (Exception ex) {
            Logger.getLogger(FrmConsultaFornecedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setNFe(List<NfProdutos> listaProdutos, List<NfDuplicatas> listaDuplicatas, NotaEletronica nota, Fornecedor fornecedor) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setAlterarValorVenda(Estoque estoque) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setFornecedor(Object objeto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setForPedido(Object objeto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setPlanoContas(Object objeto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setCliente(Object objeto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setProdutoXML(Produto produto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setArquivo(File arquivo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
}
