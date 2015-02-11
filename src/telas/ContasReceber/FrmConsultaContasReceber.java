/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FrmConsReceber.java
 *
 * Created on 22/09/2009, 09:41:47
 */
package telas.ContasReceber;

import Interfaces.ItelaConsulta;
import Regras.ContasPagarController;
import Regras.ContasReceberController;
import Regras.CreditoReceberController;
import Regras.Formatacao;
import beanController.NfDuplicatas;
import beanController.NfProdutos;
import beanController.NotaEletronica;
import com.toedter.calendar.JTextFieldDateEditor;
import controler.Config;
import controler.UsuarioLogado;
import controler.relatoriosJasper;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.net.URL;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import model.*;
import telas.Cliente.FrmConsultaClientes;
import telas.ContasReceber.Fechamento.FrmConsultaFechamentoMes;
import telas.ContasReceber.Fechamento.GerarFechamento;
import telas.ContasReceber.Relatorios.FrmRelatorioContasReceber;
import telas.ContasReceber.Relatorios.GerarRelatorioContasReceberBean;
import telas.ContasReceber.Relatorios.RelContasReceberTodas;
import telas.ContasReceber.Relatorios.RelatorioContasReceber;


/**
 *
 * @author Gabi
 */
public class FrmConsultaContasReceber extends javax.swing.JFrame implements IContasReceber, ItelaConsulta{
    
  
    Config config;
    private String datePattern;
    private String maskPattern;
    private char placeHolder;
    private ConsultaContasReceberTableModel modelVencidas;
    private ConsultaContasReceberTableModel modelVencer;
    private ConsultaContasReceberTableModel modelVencendo;
    private ConsultaContasReceberTableModel model180dias;
    
    private ConsultaFaturaTableModel modelFatura;
    
    private List<Contasreceber> listaVencidas;
    private List<Contasreceber> listaVencer;
    private List<Contasreceber> listaVencendo;
    private List<Contasreceber> lista180dias;
    
    private List<Faturasreceber> listaFatura;
    private List<Creditosreceber> listaCreditos;
    
    private UsuarioLogado usuarioLogado;
    private Cliente cliente;
    
    

    /** Creates new form FrmConsPagar */
    public FrmConsultaContasReceber(Config config, UsuarioLogado usuarioLogado)  {
        this.usuarioLogado = usuarioLogado;
        this.config = config;
        datePattern = "dd/MM/yyyy";
        maskPattern = "##/##/##";
        placeHolder = '_';
        initComponents();
        URL url = this.getClass().getResource("/imagens/logo_mini.png");
        Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(imagemTitulo);
        this.setLocationRelativeTo(null);
        carregarModel();
        this.setVisible(true);
    }

    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        AssociadosjPanel = new javax.swing.JPanel();
        nomeCredorjTextField = new javax.swing.JTextField();
        nomeCedentejLabel = new javax.swing.JLabel();
        BarradeTarefasjToolBar = new javax.swing.JToolBar();
        adicionarAPagarjButton = new javax.swing.JButton();
        editarAPagarjButton = new javax.swing.JButton();
        excluirCReceberjButton = new javax.swing.JButton();
        pesquisarAPagarjButton = new javax.swing.JButton();
        SeparadordeTarefasjSeparator = new javax.swing.JToolBar.Separator();
        imprimirTelajButton = new javax.swing.JButton();
        visualizarAPagarjButton = new javax.swing.JButton();
        voltarTelajButton = new javax.swing.JButton();
        totalPagarjLabel = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        valorPagarjLabel = new javax.swing.JLabel();
        totalVencerjLabel = new javax.swing.JLabel();
        totalVencidasjLabel = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        valorCreditojLabel = new javax.swing.JLabel();
        totalVencendojLabel1 = new javax.swing.JLabel();
        totalVencidasjLabel1 = new javax.swing.JLabel();
        contasjTabbedPane = new javax.swing.JTabbedPane();
        vencidasjScrollPane = new javax.swing.JScrollPane();
        vencidasjTable = new javax.swing.JTable();
        vencidasjScrollPane1 = new javax.swing.JScrollPane();
        vencerjTable = new javax.swing.JTable();
        vencendojScrollPane = new javax.swing.JScrollPane();
        vencendojTable = new javax.swing.JTable();
        vencendojScrollPane1 = new javax.swing.JScrollPane();
        dias180jTable = new javax.swing.JTable();
        vencendojScrollPane2 = new javax.swing.JScrollPane();
        faturasjTable = new javax.swing.JTable();
        buscaBancojButton1 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        valorVencendojLabel = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        valorVencerjLabel = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        valorVencidasjLabel = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        valor180diasjLabel = new javax.swing.JLabel();
        data180jLabel = new javax.swing.JLabel();
        totalVencidasjLabel2 = new javax.swing.JLabel();
        dataInicialjDateChooser = new com.toedter.calendar.JDateChooser(null, null, datePattern, new JTextFieldDateEditor(datePattern,
            maskPattern, placeHolder));
    dataFinaljDateChooser1 = new com.toedter.calendar.JDateChooser(null, null, datePattern, new JTextFieldDateEditor(datePattern,
        maskPattern, placeHolder));
jLabel1 = new javax.swing.JLabel();
jLabel2 = new javax.swing.JLabel();
jMenuBar2 = new javax.swing.JMenuBar();
jMenu3 = new javax.swing.JMenu();
jMenuItem1 = new javax.swing.JMenuItem();
jMenuItem12 = new javax.swing.JMenuItem();
jMenuItem16 = new javax.swing.JMenuItem();
jMenu8 = new javax.swing.JMenu();
jMenuItem8 = new javax.swing.JMenuItem();
jMenuItem13 = new javax.swing.JMenuItem();
jMenuItem14 = new javax.swing.JMenuItem();
jMenu5 = new javax.swing.JMenu();
jMenuItem2 = new javax.swing.JMenuItem();
jMenuItem11 = new javax.swing.JMenuItem();
jMenuItem4 = new javax.swing.JMenuItem();
jMenuItem5 = new javax.swing.JMenuItem();
jMenuItem6 = new javax.swing.JMenuItem();
jMenu7 = new javax.swing.JMenu();
jMenuItem9 = new javax.swing.JMenuItem();
jMenuItem10 = new javax.swing.JMenuItem();
jMenu2 = new javax.swing.JMenu();
jMenuItem3 = new javax.swing.JMenuItem();
jMenu6 = new javax.swing.JMenu();
jMenu9 = new javax.swing.JMenu();
jMenuItem15 = new javax.swing.JMenuItem();
jMenu10 = new javax.swing.JMenu();
jMenuItem17 = new javax.swing.JMenuItem();
jMenuItem18 = new javax.swing.JMenuItem();

jMenu1.setText("jMenu1");

jMenu4.setText("jMenu4");

jMenuItem7.setText("jMenuItem7");

setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
setTitle("Consulta Contas a Receber");
setResizable(false);
getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

URL url = this.getClass().getResource("/imagens/logo_mini.png");
Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);
this.setIconImage(imagemTitulo);
try{
    UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
    }catch (Exception e){
        e.printStackTrace();
    }
    AssociadosjPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
    AssociadosjPanel.setPreferredSize(new java.awt.Dimension(800, 600));
    AssociadosjPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    nomeCredorjTextField.setEditable(false);
    nomeCredorjTextField.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyReleased(java.awt.event.KeyEvent evt) {
            nomeCredorjTextFieldKeyReleased(evt);
        }
    });
    AssociadosjPanel.add(nomeCredorjTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 37, 280, -1));

    nomeCedentejLabel.setText("Nome do Cliente");
    AssociadosjPanel.add(nomeCedentejLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

    BarradeTarefasjToolBar.setFloatable(false);
    BarradeTarefasjToolBar.setRollover(true);

    adicionarAPagarjButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/dinheiromais.png"))); // NOI18N
    adicionarAPagarjButton.setText("Adicionar");
    adicionarAPagarjButton.setToolTipText("Adicionar Contas a Receber");
    adicionarAPagarjButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    adicionarAPagarjButton.setMaximumSize(new java.awt.Dimension(80, 90));
    adicionarAPagarjButton.setMinimumSize(new java.awt.Dimension(80, 90));
    adicionarAPagarjButton.setName(""); // NOI18N
    adicionarAPagarjButton.setPreferredSize(new java.awt.Dimension(80, 90));
    adicionarAPagarjButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    adicionarAPagarjButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            adicionarAPagarjButtonActionPerformed(evt);
        }
    });
    BarradeTarefasjToolBar.add(adicionarAPagarjButton);

    editarAPagarjButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/dinheiroedit.png"))); // NOI18N
    editarAPagarjButton.setText("Editar");
    editarAPagarjButton.setToolTipText("Editar Contas a Receber");
    editarAPagarjButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    editarAPagarjButton.setMaximumSize(new java.awt.Dimension(80, 90));
    editarAPagarjButton.setMinimumSize(new java.awt.Dimension(80, 90));
    editarAPagarjButton.setPreferredSize(new java.awt.Dimension(80, 90));
    editarAPagarjButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    editarAPagarjButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            editarAPagarjButtonActionPerformed(evt);
        }
    });
    BarradeTarefasjToolBar.add(editarAPagarjButton);

    excluirCReceberjButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/dinheiromenos.png"))); // NOI18N
    excluirCReceberjButton.setText("Excluir");
    excluirCReceberjButton.setToolTipText("Editar Contas a Receber");
    excluirCReceberjButton.setFocusable(false);
    excluirCReceberjButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    excluirCReceberjButton.setMaximumSize(new java.awt.Dimension(80, 90));
    excluirCReceberjButton.setMinimumSize(new java.awt.Dimension(80, 90));
    excluirCReceberjButton.setPreferredSize(new java.awt.Dimension(80, 90));
    excluirCReceberjButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    excluirCReceberjButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            excluirCReceberjButtonActionPerformed(evt);
        }
    });
    BarradeTarefasjToolBar.add(excluirCReceberjButton);

    pesquisarAPagarjButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pesquisar.png"))); // NOI18N
    pesquisarAPagarjButton.setText("Pesquisar");
    pesquisarAPagarjButton.setToolTipText("Pesquisar Contas a Receber");
    pesquisarAPagarjButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    pesquisarAPagarjButton.setMaximumSize(new java.awt.Dimension(80, 90));
    pesquisarAPagarjButton.setMinimumSize(new java.awt.Dimension(80, 90));
    pesquisarAPagarjButton.setPreferredSize(new java.awt.Dimension(80, 90));
    pesquisarAPagarjButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    pesquisarAPagarjButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            pesquisarAPagarjButtonActionPerformed(evt);
        }
    });
    BarradeTarefasjToolBar.add(pesquisarAPagarjButton);
    BarradeTarefasjToolBar.add(SeparadordeTarefasjSeparator);

    imprimirTelajButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/impressao.png"))); // NOI18N
    imprimirTelajButton.setText("Imprimir");
    imprimirTelajButton.setToolTipText("Imprimir");
    imprimirTelajButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    imprimirTelajButton.setMaximumSize(new java.awt.Dimension(80, 90));
    imprimirTelajButton.setMinimumSize(new java.awt.Dimension(80, 90));
    imprimirTelajButton.setPreferredSize(new java.awt.Dimension(80, 90));
    imprimirTelajButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    BarradeTarefasjToolBar.add(imprimirTelajButton);

    visualizarAPagarjButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/visualizar.png"))); // NOI18N
    visualizarAPagarjButton.setText("Visualizar");
    visualizarAPagarjButton.setToolTipText("Visualizar Contas a Receber");
    visualizarAPagarjButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    visualizarAPagarjButton.setMaximumSize(new java.awt.Dimension(80, 90));
    visualizarAPagarjButton.setMinimumSize(new java.awt.Dimension(80, 90));
    visualizarAPagarjButton.setPreferredSize(new java.awt.Dimension(80, 90));
    visualizarAPagarjButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    visualizarAPagarjButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            visualizarAPagarjButtonActionPerformed(evt);
        }
    });
    BarradeTarefasjToolBar.add(visualizarAPagarjButton);

    voltarTelajButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/voltar.png"))); // NOI18N
    voltarTelajButton.setText("Voltar");
    voltarTelajButton.setToolTipText("Voltar");
    voltarTelajButton.setFocusable(false);
    voltarTelajButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    voltarTelajButton.setMaximumSize(new java.awt.Dimension(80, 90));
    voltarTelajButton.setMinimumSize(new java.awt.Dimension(80, 90));
    voltarTelajButton.setPreferredSize(new java.awt.Dimension(80, 90));
    voltarTelajButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    voltarTelajButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            voltarTelajButtonActionPerformed(evt);
        }
    });
    BarradeTarefasjToolBar.add(voltarTelajButton);

    AssociadosjPanel.add(BarradeTarefasjToolBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 470, 600, 80));

    totalPagarjLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    totalPagarjLabel.setText("Total a Receber");
    AssociadosjPanel.add(totalPagarjLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 400, -1, -1));

    jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
    jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    valorPagarjLabel.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
    valorPagarjLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    valorPagarjLabel.setText("0,00");
    jPanel6.add(valorPagarjLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 120, -1));

    AssociadosjPanel.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 420, 140, 40));

    totalVencerjLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    totalVencerjLabel.setText("Total a Vencer");
    AssociadosjPanel.add(totalVencerjLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 400, -1, -1));

    totalVencidasjLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    totalVencidasjLabel.setText("Total Vencidas");
    AssociadosjPanel.add(totalVencidasjLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 400, -1, -1));

    jButton1.setText("Pesquisar");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton1ActionPerformed(evt);
        }
    });
    AssociadosjPanel.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 37, -1, -1));

    jButton2.setText("Limpar");
    jButton2.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton2ActionPerformed(evt);
        }
    });
    AssociadosjPanel.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 37, -1, -1));

    jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
    jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    valorCreditojLabel.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
    valorCreditojLabel.setForeground(new java.awt.Color(102, 0, 102));
    valorCreditojLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    valorCreditojLabel.setText("0,00");
    jPanel5.add(valorCreditojLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 110, -1));

    AssociadosjPanel.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 420, 130, 40));

    totalVencendojLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    totalVencendojLabel1.setText("Total Vencendo");
    AssociadosjPanel.add(totalVencendojLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, -1, -1));

    totalVencidasjLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    totalVencidasjLabel1.setText("Total Creditos");
    AssociadosjPanel.add(totalVencidasjLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 400, -1, -1));

    vencidasjTable.setModel(new javax.swing.table.DefaultTableModel(
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
    vencidasjTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
    vencidasjTable.getTableHeader().setReorderingAllowed(false);
    vencidasjTable.getColumnModel().getColumn(0).setPreferredWidth(30);
    vencidasjTable.getColumnModel().getColumn(1).setPreferredWidth(30);
    vencidasjTable.getColumnModel().getColumn(2).setPreferredWidth(300);
    vencidasjTable.getColumnModel().getColumn(3).setPreferredWidth(30);
    vencidasjTable.getColumnModel().getColumn(4).setPreferredWidth(30);
    vencidasjScrollPane.setViewportView(vencidasjTable);

    contasjTabbedPane.addTab("Contas a Vencidas", vencidasjScrollPane);

    vencerjTable.setModel(new javax.swing.table.DefaultTableModel(
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
    vencerjTable.getTableHeader().setReorderingAllowed(false);
    vencidasjTable.getColumnModel().getColumn(0).setPreferredWidth(30);
    vencidasjTable.getColumnModel().getColumn(1).setPreferredWidth(30);
    vencidasjTable.getColumnModel().getColumn(2).setPreferredWidth(300);
    vencidasjTable.getColumnModel().getColumn(3).setPreferredWidth(30);
    vencidasjTable.getColumnModel().getColumn(4).setPreferredWidth(30);
    vencidasjScrollPane1.setViewportView(vencerjTable);

    contasjTabbedPane.addTab("Contas a Vencer", vencidasjScrollPane1);

    vencendojTable.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {
            {null, null, null, null, null},
            {null, null, null, null, null},
            {null, null, null, null, null},
            {null, null, null, null, null}
        },
        new String [] {
            "Nº Conta", "Data Conta", "Cedente", "Data Vencimento", "Valor Conta"
        }
    ) {
        boolean[] canEdit = new boolean [] {
            false, false, false, false, false
        };

        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit [columnIndex];
        }
    });
    vencendojTable.getTableHeader().setReorderingAllowed(false);
    vencendojTable.getColumnModel().getColumn(0).setPreferredWidth(30);
    vencendojTable.getColumnModel().getColumn(1).setPreferredWidth(30);
    vencendojTable.getColumnModel().getColumn(2).setPreferredWidth(300);
    vencendojTable.getColumnModel().getColumn(3).setPreferredWidth(30);
    vencendojTable.getColumnModel().getColumn(4).setPreferredWidth(30);
    vencendojScrollPane.setViewportView(vencendojTable);
    if (vencendojTable.getColumnModel().getColumnCount() > 0) {
        vencendojTable.getColumnModel().getColumn(0).setPreferredWidth(20);
        vencendojTable.getColumnModel().getColumn(1).setPreferredWidth(20);
        vencendojTable.getColumnModel().getColumn(2).setPreferredWidth(300);
        vencendojTable.getColumnModel().getColumn(3).setPreferredWidth(20);
        vencendojTable.getColumnModel().getColumn(4).setPreferredWidth(20);
    }

    contasjTabbedPane.addTab("Contas Vencendo", vencendojScrollPane);

    dias180jTable.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {
            {null, null, null, null, null},
            {null, null, null, null, null},
            {null, null, null, null, null},
            {null, null, null, null, null}
        },
        new String [] {
            "Nº Conta", "Data Conta", "Cedente", "Data Vencimento", "Valor Conta"
        }
    ) {
        boolean[] canEdit = new boolean [] {
            false, false, false, false, false
        };

        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit [columnIndex];
        }
    });
    dias180jTable.getTableHeader().setReorderingAllowed(false);
    vencendojTable.getColumnModel().getColumn(0).setPreferredWidth(30);
    vencendojTable.getColumnModel().getColumn(1).setPreferredWidth(30);
    vencendojTable.getColumnModel().getColumn(2).setPreferredWidth(300);
    vencendojTable.getColumnModel().getColumn(3).setPreferredWidth(30);
    vencendojTable.getColumnModel().getColumn(4).setPreferredWidth(30);
    vencendojScrollPane1.setViewportView(dias180jTable);
    if (dias180jTable.getColumnModel().getColumnCount() > 0) {
        dias180jTable.getColumnModel().getColumn(0).setPreferredWidth(20);
        dias180jTable.getColumnModel().getColumn(1).setPreferredWidth(20);
        dias180jTable.getColumnModel().getColumn(2).setPreferredWidth(300);
        dias180jTable.getColumnModel().getColumn(3).setPreferredWidth(20);
        dias180jTable.getColumnModel().getColumn(4).setPreferredWidth(20);
    }

    contasjTabbedPane.addTab("180 Dias", vencendojScrollPane1);

    faturasjTable.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {
            {null, null, null, null, null},
            {null, null, null, null, null},
            {null, null, null, null, null},
            {null, null, null, null, null}
        },
        new String [] {
            "Nº Conta", "Data Conta", "Cedente", "Data Vencimento", "Valor Conta"
        }
    ) {
        boolean[] canEdit = new boolean [] {
            false, false, false, false, false
        };

        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit [columnIndex];
        }
    });
    faturasjTable.getTableHeader().setReorderingAllowed(false);
    vencendojTable.getColumnModel().getColumn(0).setPreferredWidth(30);
    vencendojTable.getColumnModel().getColumn(1).setPreferredWidth(30);
    vencendojTable.getColumnModel().getColumn(2).setPreferredWidth(300);
    vencendojTable.getColumnModel().getColumn(3).setPreferredWidth(30);
    vencendojTable.getColumnModel().getColumn(4).setPreferredWidth(30);
    vencendojScrollPane2.setViewportView(faturasjTable);
    if (faturasjTable.getColumnModel().getColumnCount() > 0) {
        faturasjTable.getColumnModel().getColumn(0).setPreferredWidth(20);
        faturasjTable.getColumnModel().getColumn(1).setPreferredWidth(20);
        faturasjTable.getColumnModel().getColumn(2).setPreferredWidth(300);
        faturasjTable.getColumnModel().getColumn(3).setPreferredWidth(20);
        faturasjTable.getColumnModel().getColumn(4).setPreferredWidth(20);
    }

    contasjTabbedPane.addTab("Faturas Geradas em Aberto", vencendojScrollPane2);

    AssociadosjPanel.add(contasjTabbedPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 830, 330));

    buscaBancojButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/magnifier.png"))); // NOI18N
    buscaBancojButton1.setToolTipText("Pesquisa Cliente");
    buscaBancojButton1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            buscaBancojButton1ActionPerformed(evt);
        }
    });
    AssociadosjPanel.add(buscaBancojButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(302, 37, 30, 20));

    jPanel9.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
    jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    valorVencendojLabel.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
    valorVencendojLabel.setForeground(java.awt.Color.blue);
    valorVencendojLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    valorVencendojLabel.setText("0,00");
    jPanel9.add(valorVencendojLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 110, -1));

    AssociadosjPanel.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 130, 40));

    jPanel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
    jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    valorVencerjLabel.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
    valorVencerjLabel.setForeground(new java.awt.Color(0, 153, 0));
    valorVencerjLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    valorVencerjLabel.setText("0,00");
    jPanel7.add(valorVencerjLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 110, -1));

    AssociadosjPanel.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 420, 130, 40));

    jPanel8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
    jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    valorVencidasjLabel.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
    valorVencidasjLabel.setForeground(new java.awt.Color(255, 0, 0));
    valorVencidasjLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    valorVencidasjLabel.setText("0,00");
    jPanel8.add(valorVencidasjLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 110, -1));

    AssociadosjPanel.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 420, 130, 40));

    jPanel10.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
    jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    valor180diasjLabel.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
    valor180diasjLabel.setForeground(new java.awt.Color(0, 102, 102));
    valor180diasjLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    valor180diasjLabel.setText("0,00");
    jPanel10.add(valor180diasjLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 8, 110, 30));

    data180jLabel.setText("01/01/2012");
    jPanel10.add(data180jLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

    AssociadosjPanel.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 420, 130, 40));

    totalVencidasjLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    totalVencidasjLabel2.setText("Total 180 dias");
    AssociadosjPanel.add(totalVencidasjLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 400, -1, -1));

    dataInicialjDateChooser.addFocusListener(new java.awt.event.FocusAdapter() {
        public void focusGained(java.awt.event.FocusEvent evt) {
            dataInicialjDateChooserFocusGained(evt);
        }
    });
    AssociadosjPanel.add(dataInicialjDateChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 37, 150, -1));

    dataFinaljDateChooser1.addFocusListener(new java.awt.event.FocusAdapter() {
        public void focusGained(java.awt.event.FocusEvent evt) {
            dataFinaljDateChooser1FocusGained(evt);
        }
    });
    AssociadosjPanel.add(dataFinaljDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(672, 37, 140, -1));

    jLabel1.setText("Data Inicial");
    AssociadosjPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 20, -1, -1));

    jLabel2.setText("Data Final");
    AssociadosjPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 20, -1, -1));

    getContentPane().add(AssociadosjPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 570));

    jMenu3.setText("Informações ");

    jMenuItem1.setText("Produtos");
    jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMenuItem1ActionPerformed(evt);
        }
    });
    jMenu3.add(jMenuItem1);

    jMenuItem12.setText("Formas de Recebimento");
    jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMenuItem12ActionPerformed(evt);
        }
    });
    jMenu3.add(jMenuItem12);

    jMenuItem16.setText("Excluir Contas Receber");
    jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMenuItem16ActionPerformed(evt);
        }
    });
    jMenu3.add(jMenuItem16);

    jMenuBar2.add(jMenu3);

    jMenu8.setText("Créditos");

    jMenuItem8.setText("Listar em Aberto");
    jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMenuItem8ActionPerformed(evt);
        }
    });
    jMenu8.add(jMenuItem8);

    jMenuItem13.setText("Listar por Data");
    jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMenuItem13ActionPerformed(evt);
        }
    });
    jMenu8.add(jMenuItem13);

    jMenuItem14.setText("Listar Cliente");
    jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMenuItem14ActionPerformed(evt);
        }
    });
    jMenu8.add(jMenuItem14);

    jMenuBar2.add(jMenu8);

    jMenu5.setText("Faturas");
    jMenu5.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMenu5ActionPerformed(evt);
        }
    });

    jMenuItem2.setText("Gerar");
    jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMenuItem2ActionPerformed(evt);
        }
    });
    jMenu5.add(jMenuItem2);

    jMenuItem11.setText("Alterar");
    jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMenuItem11ActionPerformed(evt);
        }
    });
    jMenu5.add(jMenuItem11);

    jMenuItem4.setText("Excluir");
    jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMenuItem4ActionPerformed(evt);
        }
    });
    jMenu5.add(jMenuItem4);

    jMenuItem5.setText("Imprimir");
    jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMenuItem5ActionPerformed(evt);
        }
    });
    jMenu5.add(jMenuItem5);

    jMenuItem6.setText("Parcelas");
    jMenu5.add(jMenuItem6);

    jMenuBar2.add(jMenu5);

    jMenu7.setText("Fechamentos");

    jMenuItem9.setText("Gerar Fechamento");
    jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMenuItem9ActionPerformed(evt);
        }
    });
    jMenu7.add(jMenuItem9);

    jMenuItem10.setText("Consultar Fechamento");
    jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMenuItem10ActionPerformed(evt);
        }
    });
    jMenu7.add(jMenuItem10);

    jMenuBar2.add(jMenu7);

    jMenu2.setText("Pagamentos");

    jMenuItem3.setText("Contas Recebidas");
    jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMenuItem3ActionPerformed(evt);
        }
    });
    jMenu2.add(jMenuItem3);

    jMenuBar2.add(jMenu2);

    jMenu6.setText("Relatórios");

    jMenu9.setText("Compras");

    jMenuItem15.setText("Relação Produtos");
    jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMenuItem15ActionPerformed(evt);
        }
    });
    jMenu9.add(jMenuItem15);

    jMenu6.add(jMenu9);

    jMenu10.setText("Receber");

    jMenuItem17.setText("Todas em Aberto");
    jMenuItem17.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMenuItem17ActionPerformed(evt);
        }
    });
    jMenu10.add(jMenuItem17);

    jMenuItem18.setText("Lançadas por Data");
    jMenuItem18.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMenuItem18ActionPerformed(evt);
        }
    });
    jMenu10.add(jMenuItem18);

    jMenu6.add(jMenu10);

    jMenuBar2.add(jMenu6);

    setJMenuBar(jMenuBar2);

    getAccessibleContext().setAccessibleParent(AssociadosjPanel);

    pack();
    }// </editor-fold>//GEN-END:initComponents
    private void voltarTelajButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarTelajButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_voltarTelajButtonActionPerformed

    private void nomeCredorjTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomeCredorjTextFieldKeyReleased
       
    }//GEN-LAST:event_nomeCredorjTextFieldKeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        nomeCredorjTextField.setText("");
        this.cliente = null;
        try {
            carregarModel();
        } catch (Exception ex) {
            Logger.getLogger(FrmConsultaContasReceber.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            carregarModel();
        } catch (Exception ex) {
            Logger.getLogger(FrmConsultaContasReceber.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void adicionarAPagarjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adicionarAPagarjButtonActionPerformed
        if (this.usuarioLogado.getAcesso().getCrAdicionar()==1){
            new FrmCadastrarContaReceber(config, null, this, 0, usuarioLogado);
        }else JOptionPane.showMessageDialog(rootPane, " Acesso Negado");
    }//GEN-LAST:event_adicionarAPagarjButtonActionPerformed

    private void editarAPagarjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarAPagarjButtonActionPerformed
       Contasreceber contaReceber = null;
        if (this.usuarioLogado.getAcesso().getCrEditar() == 1) {
            int linha = -10;
            if (contasjTabbedPane.getSelectedIndex() == 0) {
                linha = vencidasjTable.getSelectedRow();
                if (linha >= 0) {
                    contaReceber = listaVencidas.get(linha);
                }
            } else if (contasjTabbedPane.getSelectedIndex() == 1) {
                linha = vencerjTable.getSelectedRow();
                if (linha >= 0) {
                    contaReceber = listaVencer.get(linha);
                }
            } else if (contasjTabbedPane.getSelectedIndex() == 2) {
                linha = vencendojTable.getSelectedRow();
                if (linha >= 0) {
                    contaReceber = listaVencendo.get(linha);
                }
            }
            if (contaReceber != null) {
                new FrmCadastrarContaReceber(config, contaReceber, this, 0, this.usuarioLogado);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso Negado");
        }
    }//GEN-LAST:event_editarAPagarjButtonActionPerformed

    private void pesquisarAPagarjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisarAPagarjButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pesquisarAPagarjButtonActionPerformed

    private void visualizarAPagarjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_visualizarAPagarjButtonActionPerformed
        Contasreceber contaReceber = null;
        if (this.usuarioLogado.getAcesso().getCrEditar() == 1) {
            int linha = -10;
            if (contasjTabbedPane.getSelectedIndex() == 0) {
                linha = vencidasjTable.getSelectedRow();
                if (linha >= 0) {
                    contaReceber = listaVencidas.get(linha);
                }
            } else if (contasjTabbedPane.getSelectedIndex() == 1) {
                linha = vencerjTable.getSelectedRow();
                if (linha >= 0) {
                    contaReceber = listaVencer.get(linha);
                }
            } else if (contasjTabbedPane.getSelectedIndex() == 2) {
                linha = vencendojTable.getSelectedRow();
                if (linha >= 0) {
                    contaReceber = listaVencendo.get(linha);
                }
            }
            if (contaReceber != null) {
                new FrmCadastrarContaReceber(config, contaReceber, this, 1, this.usuarioLogado);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso Negado");
        }
    }//GEN-LAST:event_visualizarAPagarjButtonActionPerformed

    private void buscaBancojButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscaBancojButton1ActionPerformed
        new FrmConsultaClientes(config, usuarioLogado, this);
    }//GEN-LAST:event_buscaBancojButton1ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        Contasreceber contaReceber = null;
        if (this.usuarioLogado.getAcesso().getCrEditar() == 1) {
            int linha = -10;
            if (contasjTabbedPane.getSelectedIndex() == 0) {
                linha = vencidasjTable.getSelectedRow();
                if (linha >= 0) {
                    contaReceber = listaVencidas.get(linha);
                }
            } else if (contasjTabbedPane.getSelectedIndex() == 1) {
                linha = vencerjTable.getSelectedRow();
                if (linha >= 0) {
                    contaReceber = listaVencer.get(linha);
                }
            } else if (contasjTabbedPane.getSelectedIndex() == 2) {
                linha = vencendojTable.getSelectedRow();
                if (linha >= 0) {
                    contaReceber = listaVencendo.get(linha);
                }
            }
            if (contaReceber != null) {
                new FrmConsultaProdutoContasReceber(contaReceber.getIdcontasReceber());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso Negado");
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        if (this.usuarioLogado.getAcesso().getCrGerarFatura() == 1) {
            if (this.cliente != null) {
                gerarFaturas(cliente);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Cliente não Selecionado");
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, " Acesso Negado");
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        String sqlCreditos = "select c from Creditosreceber c where c.contasreceberpagamento=1 and c.empresa=" + this.config.getEmpresa().getIdempresa() + " order by c.dataLancamento";
        CreditoReceberController creditoReceberController = new CreditoReceberController();
        List<Creditosreceber> listaCreditos = creditoReceberController.listarCreditos(sqlCreditos);
        iniciarCosultaCreditos(listaCreditos);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        
        if (this.usuarioLogado.getAcesso().getCrImprimirFatura() == 1) {
            if (contasjTabbedPane.getSelectedIndex() == 4) {
                int linha = faturasjTable.getSelectedRow();
                if (linha >= 0) {
                    gerarRelatorio(listaFatura.get(linha).getIdFaturasReceber(), Formatacao.valorPorExtenso(listaFatura.get(linha).getValorFatura()));
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, " Acesso Negado");
        }
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        if (this.usuarioLogado.getAcesso().getCrExcluirFatura() == 1) {
            if (contasjTabbedPane.getSelectedIndex() == 4) {
                int linha = faturasjTable.getSelectedRow();
                if (linha >= 0) {
                    boolean resultado = JOptionPane.showConfirmDialog(null, "Excluir Fatura", "Atenção", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == 0;
                    if (resultado) {
                        excluirFatura(listaFatura.get(linha));
                        carregarModel();
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, " Acesso Negado");
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        if (this.usuarioLogado.getAcesso().getCrRecebimentos()==1){
            new FrmConsultarContasRecebidas(config);
        }else JOptionPane.showMessageDialog(rootPane, " Acesso Negado");
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenu5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu5ActionPerformed
    }//GEN-LAST:event_jMenu5ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        if (contasjTabbedPane.getSelectedIndex()==4){
            int linha = faturasjTable.getSelectedRow();
            Faturasreceber fatura = listaFatura.get(linha);
            if (fatura!=null){
                new FrmAlterarFatura(config, fatura);
            }else JOptionPane.showMessageDialog(rootPane, "Fatura não Localizada");
        }
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        String mes = JOptionPane.showInputDialog("Infomar Mes MM/AAAA");
        if (mes.length()>0){
            GerarFechamento g = new GerarFechamento(mes.substring(3), mes.substring(0,2), usuarioLogado.getUsuario().getNome(), this.config);
        }
        
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
       new FrmConsultaFechamentoMes();
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        new FrmContasReceberFormaPagamento(this.config);
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void dataInicialjDateChooserFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dataInicialjDateChooserFocusGained

    }//GEN-LAST:event_dataInicialjDateChooserFocusGained

    private void dataFinaljDateChooser1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dataFinaljDateChooser1FocusGained

    }//GEN-LAST:event_dataFinaljDateChooser1FocusGained

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        listarCreditosData();
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        listarCreditosCliente();
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
        if (this.cliente == null) {
            JOptionPane.showMessageDialog(rootPane, "Seleciona o cliente");
        } else {
            if (dataInicialjDateChooser.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Data inicial não é válida");
            } else {
                if (dataFinaljDateChooser1.getDate() == null) {
                    JOptionPane.showMessageDialog(rootPane, "Data final não é válida");
                } else {
                    String url = ("telas/ContasReceber/Relatorios/produtosContasRebecer.jasper");
                    Map parameters = new HashMap();
                    try {
                        parameters.put("nomeFantasia", this.config.getEmpresa().getNomeFantasia());
                        parameters.put("RazaoSocial", this.config.getEmpresa().getRazaoSocial());
                        parameters.put("idempresa", this.config.getEmpresa().getIdempresa());
                        parameters.put("idcliente", cliente.getIdcliente());
                        parameters.put("dataInicial", dataInicialjDateChooser.getDate());
                        parameters.put("dataFinal", dataFinaljDateChooser1.getDate());
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(this, "Não foi possível gerar o relatório " + ex);
                        ex.printStackTrace();
                    }
                    new relatoriosJasper(url, parameters);
                }
            }
        }

    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
        
    }//GEN-LAST:event_jMenuItem16ActionPerformed

    private void excluirCReceberjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirCReceberjButtonActionPerformed
        if (usuarioLogado.getAcesso().getCrExcluirConta()==1){
            excluirContasReceber();
        }else {
            JOptionPane.showMessageDialog(rootPane, "Acesso Negado");
        }
    }//GEN-LAST:event_excluirCReceberjButtonActionPerformed

    private void jMenuItem17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem17ActionPerformed
        GerarRelatorioContasReceberBean rel = new GerarRelatorioContasReceberBean();
        rel.gerarRelatorioTodas(config.getEmpresa().getIdempresa());
        RelatorioContasReceber relContas = new RelatorioContasReceber();
        relContas.setListaTodas(rel.getListaTodas());
        List<RelContasReceberTodas> listaTodas = rel.getListaTodas();
        if (listaTodas==null){
            JOptionPane.showMessageDialog(rootPane, "Erro ao gerar Relatório");
        }else{
            String url = ("telas/ContasReceber/Relatorios/contasReceberTodas.jasper");
            Map parameters = new HashMap();
            try {
                parameters.put("nomeFantasia", this.config.getEmpresa().getNomeFantasia());
                parameters.put("RazaoSocial", this.config.getEmpresa().getRazaoSocial());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Não foi possível gerar o relatório " + ex);
                ex.printStackTrace();
            }
            new relatoriosJasper(url, parameters, true);
        }
    }//GEN-LAST:event_jMenuItem17ActionPerformed

    private void jMenuItem18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem18ActionPerformed
        new FrmRelatorioContasReceber(config, usuarioLogado);
    }//GEN-LAST:event_jMenuItem18ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AssociadosjPanel;
    private javax.swing.JToolBar BarradeTarefasjToolBar;
    private javax.swing.JToolBar.Separator SeparadordeTarefasjSeparator;
    private javax.swing.JButton adicionarAPagarjButton;
    private javax.swing.JButton buscaBancojButton1;
    private javax.swing.JTabbedPane contasjTabbedPane;
    private javax.swing.JLabel data180jLabel;
    private com.toedter.calendar.JDateChooser dataFinaljDateChooser1;
    private com.toedter.calendar.JDateChooser dataInicialjDateChooser;
    private javax.swing.JTable dias180jTable;
    private javax.swing.JButton editarAPagarjButton;
    private javax.swing.JButton excluirCReceberjButton;
    private javax.swing.JTable faturasjTable;
    private javax.swing.JButton imprimirTelajButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel nomeCedentejLabel;
    private javax.swing.JTextField nomeCredorjTextField;
    private javax.swing.JButton pesquisarAPagarjButton;
    private javax.swing.JLabel totalPagarjLabel;
    private javax.swing.JLabel totalVencendojLabel1;
    private javax.swing.JLabel totalVencerjLabel;
    private javax.swing.JLabel totalVencidasjLabel;
    private javax.swing.JLabel totalVencidasjLabel1;
    private javax.swing.JLabel totalVencidasjLabel2;
    private javax.swing.JLabel valor180diasjLabel;
    private javax.swing.JLabel valorCreditojLabel;
    private javax.swing.JLabel valorPagarjLabel;
    private javax.swing.JLabel valorVencendojLabel;
    private javax.swing.JLabel valorVencerjLabel;
    private javax.swing.JLabel valorVencidasjLabel;
    private javax.swing.JScrollPane vencendojScrollPane;
    private javax.swing.JScrollPane vencendojScrollPane1;
    private javax.swing.JScrollPane vencendojScrollPane2;
    private javax.swing.JTable vencendojTable;
    private javax.swing.JTable vencerjTable;
    private javax.swing.JScrollPane vencidasjScrollPane;
    private javax.swing.JScrollPane vencidasjScrollPane1;
    private javax.swing.JTable vencidasjTable;
    private javax.swing.JButton visualizarAPagarjButton;
    private javax.swing.JButton voltarTelajButton;
    // End of variables declaration//GEN-END:variables

    public void carregarModel()  {
        String dataAtual = Formatacao.ConvercaoDataSql(new Date());
        String data180=null;
        try {
            data180 = Formatacao.SubtarirDatas(new Date(), 180, "yyyy/MM/dd");
            data180jLabel.setText(Formatacao.SubtarirDatas(new Date(), 180, "dd/MM/yyyy"));
        } catch (Exception ex) {
            Logger.getLogger(FrmConsultaContasReceber.class.getName()).log(Level.SEVERE, null, ex);
        }
        ContasPagarController contasPagarController = new ContasPagarController();
        String sqlContaVencendo = null;
        String sqlContaVencer = null;
        String sqlContaVencidas = null;
        String sqlConta180dias = null;
        //Faturas
        
        
        String sqlCredito= null;
        
        
        if (this.cliente==null) {
            sqlContaVencendo = "select c from Contasreceber c where c.contasreceberpagamento=1  and c.dataVencimento='" + dataAtual + "' and c.empresa.idempresa="+ this.config.getEmpresa().getIdempresa() + " order by c.dataVencimento";
            sqlContaVencer = "select c from Contasreceber c where c.contasreceberpagamento=1  and c.dataVencimento>'" + dataAtual + "' and c.empresa.idempresa="+ this.config.getEmpresa().getIdempresa() + " order by c.dataVencimento";
            sqlContaVencidas = "select c from Contasreceber c where c.contasreceberpagamento=1  and c.dataVencimento>'" + data180 + "' and c.dataVencimento<'" + dataAtual + "' and c.empresa.idempresa="+ this.config.getEmpresa().getIdempresa() + " order by c.dataVencimento";
            sqlConta180dias = "select c from Contasreceber c where c.contasreceberpagamento=1  and c.dataVencimento<'" + data180 + "' and c.empresa.idempresa="+ this.config.getEmpresa().getIdempresa() + " order by c.dataVencimento";
            
            sqlCredito = " select c from Creditosreceber c where c.contasreceberpagamento=1 and c.empresa=" + this.config.getEmpresa().getIdempresa(); 
        }else {
            
            sqlContaVencendo = "select c from Contasreceber c where c.contasreceberpagamento=1  and c.dataVencimento='" + dataAtual + "' and c.cliente.idcliente="  + cliente.getIdcliente() +  " and c.empresa.idempresa=" + this.config.getEmpresa().getIdempresa() + " order by c.dataVencimento";
            sqlContaVencer = "select c from Contasreceber c where c.contasreceberpagamento=1  and c.dataVencimento>'" + dataAtual + "' and c.cliente.idcliente="  + cliente.getIdcliente() +  " and c.empresa.idempresa=" + this.config.getEmpresa().getIdempresa() + " order by c.dataVencimento";
            sqlContaVencidas = "select c from Contasreceber c where c.contasreceberpagamento=1  and c.dataVencimento>'" + data180 + "' and c.dataVencimento<'" + dataAtual + "' and c.cliente.idcliente="  + cliente.getIdcliente() +  " and c.empresa.idempresa=" + this.config.getEmpresa().getIdempresa() + " order by c.dataVencimento";
            sqlConta180dias = "select c from Contasreceber c where c.contasreceberpagamento=1  and c.dataVencimento<'" + data180 + "' and c.cliente.idcliente="  + cliente.getIdcliente() +  " and c.empresa.idempresa=" + this.config.getEmpresa().getIdempresa() + " order by c.dataVencimento";
            
            sqlCredito = " select c from Creditosreceber c where c.contasreceberpagamento=1 and c.cliente=" +cliente.getIdcliente() + " and c.empresa=" + this.config.getEmpresa().getIdempresa();
            
            //Faturas 

            
            
        }
        lista180dias = new ArrayList<Contasreceber>();
        listaVencendo = new ArrayList<Contasreceber>();
        listaVencer = new ArrayList<Contasreceber>();
        listaVencidas = new ArrayList<Contasreceber>();
        ContasReceberController contasReceberController = new ContasReceberController();
        listaVencendo = contasReceberController.listarContas(sqlContaVencendo);
        
        
        listaVencer = contasReceberController.listarContas(sqlContaVencer);
        
        listaVencidas  = contasReceberController.listarContas(sqlContaVencidas);
        
        lista180dias  = contasReceberController.listarContas(sqlConta180dias);
        
        consultarCreditos(sqlCredito);
        
        String sqlFatura = "select f from Faturasreceber f where f.contasreceberpagamento=1 order by f.dataVencimento";
        
        
        listaFatura = contasReceberController.listarFaturas(sqlFatura);
        if (listaFatura!=null){
            modelFatura = new ConsultaFaturaTableModel(listaFatura);
        }else modelFatura = new ConsultaFaturaTableModel(new ArrayList<Faturasreceber>());
       
        
        
        
        modelVencendo = new ConsultaContasReceberTableModel(listaVencendo);
        modelVencer = new ConsultaContasReceberTableModel(listaVencer);
        modelVencidas = new ConsultaContasReceberTableModel(listaVencidas);
        model180dias = new ConsultaContasReceberTableModel(lista180dias);

        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.RIGHT);
        
        faturasjTable.setModel(modelFatura);
        faturasjTable.getColumnModel().getColumn(0).setPreferredWidth(20);
        faturasjTable.getColumnModel().getColumn(1).setPreferredWidth(300);
        faturasjTable.getColumnModel().getColumn(2).setPreferredWidth(40);
        faturasjTable.getColumnModel().getColumn(3).setPreferredWidth(40);
        faturasjTable.getColumnModel().getColumn(4).setPreferredWidth(20);
        faturasjTable.getColumnModel().getColumn(5).setCellRenderer(renderer);
        faturasjTable.getColumnModel().getColumn(5).setPreferredWidth(40);
        faturasjTable.repaint();
        
        
        vencerjTable.setModel(modelVencer);
        vencerjTable.getColumnModel().getColumn(0).setPreferredWidth(20);
        vencerjTable.getColumnModel().getColumn(1).setPreferredWidth(300);
        vencerjTable.getColumnModel().getColumn(2).setPreferredWidth(40);
        vencerjTable.getColumnModel().getColumn(3).setPreferredWidth(40);
        vencerjTable.getColumnModel().getColumn(4).setPreferredWidth(40);
        vencerjTable.getColumnModel().getColumn(5).setCellRenderer(renderer);
        vencerjTable.getColumnModel().getColumn(5).setPreferredWidth(40);
        vencerjTable.repaint();


        vencendojTable.setModel(modelVencendo);
        vencendojTable.getColumnModel().getColumn(0).setPreferredWidth(20);
        vencendojTable.getColumnModel().getColumn(1).setPreferredWidth(300);
        vencendojTable.getColumnModel().getColumn(2).setPreferredWidth(40);
        vencendojTable.getColumnModel().getColumn(3).setPreferredWidth(40);
        vencendojTable.getColumnModel().getColumn(4).setPreferredWidth(40);
        vencendojTable.getColumnModel().getColumn(5).setCellRenderer(renderer);
        vencendojTable.getColumnModel().getColumn(5).setPreferredWidth(40);
        vencendojTable.repaint();

        vencidasjTable.setModel(modelVencidas);
        vencidasjTable.getColumnModel().getColumn(0).setPreferredWidth(20);
        vencidasjTable.getColumnModel().getColumn(1).setPreferredWidth(300);
        vencidasjTable.getColumnModel().getColumn(2).setPreferredWidth(40);
        vencidasjTable.getColumnModel().getColumn(3).setPreferredWidth(40);
        vencidasjTable.getColumnModel().getColumn(4).setPreferredWidth(40);
        vencidasjTable.getColumnModel().getColumn(5).setCellRenderer(renderer);
        vencidasjTable.getColumnModel().getColumn(5).setPreferredWidth(40);
        vencidasjTable.repaint();
        
        dias180jTable.setModel(model180dias);
        dias180jTable.getColumnModel().getColumn(0).setPreferredWidth(20);
        dias180jTable.getColumnModel().getColumn(1).setPreferredWidth(300);
        dias180jTable.getColumnModel().getColumn(2).setPreferredWidth(40);
        dias180jTable.getColumnModel().getColumn(3).setPreferredWidth(40);
        dias180jTable.getColumnModel().getColumn(4).setPreferredWidth(40);
        dias180jTable.getColumnModel().getColumn(5).setCellRenderer(renderer);
        dias180jTable.getColumnModel().getColumn(5).setPreferredWidth(40);
        dias180jTable.repaint();
        
        


       

        somarListarContasReceber();

    }

    public void setNovaConta() {
        try {
            carregarModel();
        } catch (Exception ex) {
            Logger.getLogger(FrmConsultaContasReceber.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void somarListarContasReceber(){
        double valorVencer = 0;
        double valorVencida = 0;
        double valorVencendo =0;
        double valor180dias = 0;
        double valorCreditos =0;
        double soma = 0;
        
        for(int i=0;i<lista180dias.size();i++){
            valor180dias = valor180dias + lista180dias.get(i).getValorConta();
        }
        valor180diasjLabel.setText(Formatacao.foramtarDoubleString(valor180dias));
        
        for(int i=0;i<listaCreditos.size();i++){
            valorCreditos = valorCreditos + listaCreditos.get(i).getValorCredito();
        }
        valorCreditojLabel.setText(Formatacao.foramtarDoubleString(valorCreditos));
        soma-=valorCreditos;
         
        
        for(int i=0;i<listaVencendo.size();i++){
            valorVencendo = valorVencendo + listaVencendo.get(i).getValorConta();
        }
        valorVencendojLabel.setText(Formatacao.foramtarDoubleString(valorVencendo));
        soma = soma + valorVencendo;
        
        for(int i=0;i<listaVencer.size();i++){
            valorVencer = valorVencer + listaVencer.get(i).getValorConta();
        }
        valorVencerjLabel.setText(Formatacao.foramtarDoubleString(valorVencer));
        soma = soma + valorVencer;
        
        for(int i=0;i<listaVencidas.size();i++){
            valorVencida = valorVencida + listaVencidas.get(i).getValorConta();
        }
        valorVencidasjLabel.setText(Formatacao.foramtarDoubleString(valorVencida));
        soma = valorVencida + soma;
        
              
        valorPagarjLabel.setText(Formatacao.foramtarDoubleString(soma));
    }
    
    
    public boolean buscarContaDocuemnto(String numeroDocuemnto){
        List<Contaspagar> cp = new ArrayList<Contaspagar>();
        ContasPagarController contasPagarController = new ContasPagarController();
        String sql = "select c from Contaspagar c where c.pagamentocontaspagar=1  and c.numeroDocumento='" + numeroDocuemnto;
        cp = contasPagarController.listarContas(sql);
        return false;
    }

   

    public void setRelContasPagarPeriodo(Date dataInicial, Date dataFinal) {
        String url = ("telas/ContasPagar/reportcontasPagarPeriodo.jasper");
        Map parameters = new HashMap();
        try {
            parameters.put("nomeFantasia", this.config.getEmpresa().getNomeFantasia());
            parameters.put("RazaoSocial", this.config.getEmpresa().getRazaoSocial());
            parameters.put("idEmpresa", this.config.getEmpresa().getIdempresa());
            parameters.put("dataInicial", dataInicial);
            parameters.put("dataFinal", dataFinal);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Não foi possível gerar o relatório " + ex);
            ex.printStackTrace();
        }
        new relatoriosJasper(url, parameters);
    }
   

    public void setRelContasPagarFornecedor(int idFornecedor, String razaoSocial) {
        String url = ("telas/ContasPagar/reportcontasPagarFornecedor.jasper");
        Map parameters = new HashMap();
        try {
            parameters.put("nomeFantasia", this.config.getEmpresa().getNomeFantasia());
            parameters.put("RazaoSocial", this.config.getEmpresa().getRazaoSocial());
            parameters.put("idEmpresa", this.config.getEmpresa().getIdempresa());
            parameters.put("idFornecedor", idFornecedor);
            parameters.put("nomeFornecedor", razaoSocial);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Não foi possível gerar o relatório " + ex);
            ex.printStackTrace();
        }
        new relatoriosJasper(url, parameters);
    }

    public void setRelContasVencidasGeral() {
        String url = ("telas/ContasPagar/reportcontasVencidasGeral.jasper");
        Map parameters = new HashMap();
        try {
            parameters.put("nomeFantasia", this.config.getEmpresa().getNomeFantasia());
            parameters.put("RazaoSocial", this.config.getEmpresa().getRazaoSocial());
            parameters.put("idEmpresa", this.config.getEmpresa().getIdempresa());
            parameters.put("dataVencimento", new Date());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Não foi possível gerar o relatório " + ex);
            ex.printStackTrace();
        }
        new relatoriosJasper(url, parameters);
    }

    public void setRelContasVencidasFornecedor(Date dataInicial, Date dataFinal, int idFornecedor, String razaoSocial) {
        String url = ("telas/ContasPagar/reportcontasVencidasFornecedor.jasper");
        Map parameters = new HashMap();
        try {
            parameters.put("nomeFantasia", this.config.getEmpresa().getNomeFantasia());
            parameters.put("RazaoSocial", this.config.getEmpresa().getRazaoSocial());
            parameters.put("idEmpresa", this.config.getEmpresa().getIdempresa());
            parameters.put("dataVencimento", new Date());
            parameters.put("idFornecedor", idFornecedor);
            parameters.put("nomeFornecedor", razaoSocial);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Não foi possível gerar o relatório " + ex);
            ex.printStackTrace();
        }
        new relatoriosJasper(url, parameters);
    }

    public void setRelContasPagasPeriodo(Date dataInicial, Date dataFinal) {
        String url = ("telas/ContasPagar/reportcontasPagasPeriodo.jasper");
        Map parameters = new HashMap();
        try {
            parameters.put("nomeFantasia", this.config.getEmpresa().getNomeFantasia());
            parameters.put("RazaoSocial", this.config.getEmpresa().getRazaoSocial());
            parameters.put("idEmpresa", this.config.getEmpresa().getIdempresa());
            parameters.put("dataInicial", dataInicial);
            parameters.put("dataFinal", dataFinal);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Não foi possível gerar o relatório " + ex);
            ex.printStackTrace();
        }
        new relatoriosJasper(url, parameters);
    }

    public void setRelContasPagasFornecedor(int idFornecedor, String razaoSocial, Date dataInicial, Date dataFinal) {
        String url = ("telas/ContasPagar/reportcontasPagasFornecedor.jasper");
        Map parameters = new HashMap();
        try {
            parameters.put("nomeFantasia", this.config.getEmpresa().getNomeFantasia());
            parameters.put("RazaoSocial", this.config.getEmpresa().getRazaoSocial());
            parameters.put("idEmpresa", this.config.getEmpresa().getIdempresa());
            parameters.put("dataInicial", dataInicial);
            parameters.put("dataFinal", dataFinal);
            parameters.put("idFornecedor", idFornecedor);
            parameters.put("nomeFornecedor", razaoSocial);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Não foi possível gerar o relatório " + ex);
            ex.printStackTrace();
        }
        new relatoriosJasper(url, parameters);
    }

    public void setRelContasPagasPlanoContas(int idConta, String descricao, Date dataInicial, Date dataFinal) {
        String url = ("telas/ContasPagar/reportcontasPagasPlanoContas.jasper");
        Map parameters = new HashMap();
        try {
            parameters.put("nomeFantasia", this.config.getEmpresa().getNomeFantasia());
            parameters.put("RazaoSocial", this.config.getEmpresa().getRazaoSocial());
            parameters.put("idEmpresa", this.config.getEmpresa().getIdempresa());
            parameters.put("dataInicial", dataInicial);
            parameters.put("dataFinal", dataFinal);
            parameters.put("idConta", idConta);
            parameters.put("descricaoConta", descricao);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Não foi possível gerar o relatório " + ex);
            ex.printStackTrace();
        }
        new relatoriosJasper(url, parameters);
    }
    
    

    public void carregarContas() {
        carregarModel();
    }

    public void setData(Object objeto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setBanco(Banco banco) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setModelProduto(Produto produto, Estoque estoque) {
        throw new UnsupportedOperationException("Not supported yet.");
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
        this.cliente = new Cliente();
        cliente = (Cliente) objeto;
        nomeCredorjTextField.setText(cliente.getNome());
    }
    
    public void consultarCreditos(String sql){
        CreditoReceberController creditoReceberController = new CreditoReceberController();
        listaCreditos = creditoReceberController.listarCreditos(sql);
        if (listaCreditos==null){
            listaCreditos = new ArrayList<Creditosreceber>();
        }
    }
    
    public void gerarFaturas(Cliente cliente){
        List<Contasreceber> listaContasFatura = new ArrayList<Contasreceber>();
        ContasReceberController contasReceberController = new ContasReceberController();
        String sql = "select c from Contasreceber c where c.contasreceberpagamento=1  and c.cliente.idcliente=" + cliente.getIdcliente();
        listaContasFatura = contasReceberController.listarContas(sql);
        if (listaContasFatura.size()>0){
            GerarFaturaBean gerarFaturaBean = new GerarFaturaBean(cliente, listaContasFatura);
            new FrmGerarFatura(gerarFaturaBean, config, 1);
        }else {
            JOptionPane.showMessageDialog(rootPane,"Cliente não possui contas para Gerar Fatura");
        }
    }
    
    public void gerarRelatorio(int idFatura, String valorExtenso){
        String url = ("telas/ContasReceber/Relatorios/faturaReceber.jasper");
        Map parameters = new HashMap();
        try {
            parameters.put("idFatura", idFatura);
            parameters.put("valorExtenso", valorExtenso);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Não foi possível gerar o relatório " + ex);
            ex.printStackTrace();
        }
        new relatoriosJasper(url, parameters);
    }
    
    public void excluirFatura(Faturasreceber fatura){
        ContasReceberController contasReceberController = new ContasReceberController();
        String sql = null;
        if (fatura!=null){
            sql = "Select c From Contasreceber c where c.numeroFatura=" + fatura.getIdFaturasReceber();
            List<Contasreceber> listaParcelas = contasReceberController.listarContas(sql);
            if (listaParcelas!=null){
                for(int i=0;i<listaParcelas.size();i++){
                    contasReceberController.excluirContasReceber(listaParcelas.get(i));
                }
            }
            sql = "Select r From Contasreceber r where r.numeroFaturaGerada='" + fatura.getNumeroFatura() + "'";
            List<Contasreceber> listaContas = contasReceberController.listarContas(sql);
            if (listaContas!=null){
                Contasreceberpagamento contasreceberpagamento = contasReceberController.consultarContaReceberPagamento(1);
                for(int i=0;i<listaContas.size();i++){
                    Contasreceber conta = listaContas.get(i);
                    conta.setNumeroFaturaGerada("0");
                    conta.setContasreceberpagamento(contasreceberpagamento);
                    contasReceberController.salvarContasReceber(conta);
                }
            }
            contasReceberController.excluirFatura(fatura);
            JOptionPane.showMessageDialog(rootPane, "Fatura exluida con sucesso");
        }
    }  

    public void setProdutoXML(Produto produto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void listarCreditosData() {
        String dataInicial = Formatacao.ConvercaoDataSql(dataInicialjDateChooser.getDate());
        String dataFinal = Formatacao.ConvercaoDataSql(dataFinaljDateChooser1.getDate());
        String sqlCreditos = "select c from Creditosreceber c where c.dataLancamento>='" + 
                dataInicial + "' and c.dataLancamento<='" + dataFinal + "' and c.empresa=" + this.config.getEmpresa().getIdempresa() + " order by c.dataLancamento";
        CreditoReceberController creditoReceberController = new CreditoReceberController();
        List<Creditosreceber> listaCreditos = creditoReceberController.listarCreditos(sqlCreditos);
        iniciarCosultaCreditos(listaCreditos);
      
    }

    public void listarCreditosCliente() {
        String dataInicial = Formatacao.ConvercaoDataSql(dataInicialjDateChooser.getDate());
        String dataFinal = Formatacao.ConvercaoDataSql(dataFinaljDateChooser1.getDate());
        String sqlCreditos = "select c from Creditosreceber c where c.dataLancamento>='" + 
                dataInicial + "' and c.dataLancamento<='" + dataFinal + "' and c.cliente=" + cliente.getIdcliente() + " and c.empresa=" + this.config.getEmpresa().getIdempresa() + " order by c.dataLancamento";
        CreditoReceberController creditoReceberController = new CreditoReceberController();
        List<Creditosreceber> listaCreditos = creditoReceberController.listarCreditos(sqlCreditos);
        iniciarCosultaCreditos(listaCreditos);
    }
    
    public void iniciarCosultaCreditos(List<Creditosreceber> listaCreditos){
          List<CreditoBean> listaCreditoBean = new ArrayList<CreditoBean>();
        if (listaCreditos!=null){
            for(int i=0;i<listaCreditos.size();i++){
                CreditoBean creditoBean = new CreditoBean(listaCreditos.get(i));
                listaCreditoBean.add(creditoBean);
            }
        }
        new FrmConsultaCreditosReceber(listaCreditoBean,1, null);
    }
    
    public void excluirContasReceber() {
        int linha = -1;
        Contasreceber contasExcluir = null;
        if (contasjTabbedPane.getSelectedIndex() == 0) {
            linha = vencidasjTable.getSelectedRow();
            if (linha >= 0) {
                contasExcluir = listaVencidas.get(linha);
            }
        } else if (contasjTabbedPane.getSelectedIndex() == 1) {
            linha = vencerjTable.getSelectedRow();
            if (linha >= 0) {
                contasExcluir = listaVencer.get(linha);
            }
        } else if (contasjTabbedPane.getSelectedIndex() == 2) {
            linha = vencendojTable.getSelectedRow();
            if (linha >= 0) {
                contasExcluir = listaVencendo.get(linha);
            }
        }else if (contasjTabbedPane.getSelectedIndex() == 3) {
            linha = dias180jTable.getSelectedRow();
            if (linha >= 0) {
                contasExcluir = lista180dias.get(linha);
            }
        }
        if (contasExcluir != null) {
            ContasReceberController contasReceberController = new ContasReceberController();
            excluirContasReceberProduto(contasExcluir.getIdcontasReceber());
            contasReceberController.excluirContasReceber(contasExcluir);
            JOptionPane.showMessageDialog(rootPane, "Conta Excluida xom Sucesso");
            carregarModel();
        }
    }

    
    public void excluirContasReceberProduto(int idContasReceber){
        ContasReceberController contasReceberController = new ContasReceberController();
        List<Contasreceberprodutos> listaProdutos = contasReceberController.listaContasReceberProdutos(idContasReceber);
        if (listaProdutos!=null){
            for(int i=0;i<listaProdutos.size();i++){
                contasReceberController.excluirContasReceberProduto(listaProdutos.get(i));
            }
        }
    }

    public void setArquivo(File arquivo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setCliente(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
