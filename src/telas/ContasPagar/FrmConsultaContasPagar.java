/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FrmConsReceber.java
 *
 * Created on 22/09/2009, 09:41:47
 */
package telas.ContasPagar;

import Regras.ContasPagarController;
import Regras.Formatacao;
import com.toedter.calendar.JTextFieldDateEditor;
import controler.Config;
import controler.UsuarioLogado;
import controler.relatoriosJasper;
import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import model.Contaspagar;
import telas.ControleCheques.ControleChequeBean;
import telas.ControleCheques.ItelaControleCheque;


/**
 *
 * @author Gabi
 */
public class FrmConsultaContasPagar extends javax.swing.JFrame implements IContasPagar{
    
  
    Config config;
    private String datePattern;
    private String maskPattern;
    private char placeHolder;
    private ContasPagarTableModel modelVencidas;
    private ContasPagarTableModel modelVencer;
    private ContasPagarTableModel modelVencendo;
    private ContasPagarTableModel modelFutura;
    
    private List<Contaspagar> listaVencidas;
    private List<Contaspagar> listaVencer;
    private List<Contaspagar> listaVencendo;
    private List<Contaspagar> listaFuturas;
    
    private List<Contaspagar> listaPagamento;
    private UsuarioLogado usuarioLogado;
    
    private  DefaultTableCellRenderer rendererCor;
    private int tipoRelatorioFornecedor;
    private ItelaControleCheque telaCheque;
    

    /** Creates new form FrmConsPagar */
    public FrmConsultaContasPagar(Config config, UsuarioLogado usuarioLogado, ItelaControleCheque telaCheque)  {
        this.usuarioLogado = usuarioLogado;
        this.config = config;
        datePattern = "dd/MM/yyyy";
        maskPattern = "##/##/##";
        placeHolder = '_';
        this.telaCheque = telaCheque;
        initComponents();
        dataVencimentojDateChooser.setDate(new Date());
        URL url = this.getClass().getResource("/imagens/logo_mini.png");
        Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(imagemTitulo);
        this.setLocationRelativeTo(null);
        
        this.rendererCor = new DefaultTableCellRenderer(){
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                        boolean isSelected, boolean hasFocus, int row, int column) {
                    Component comp = super.getTableCellRendererComponent(table, value,
                            isSelected, hasFocus, row, column);
                    if (value.equals("SIM")){
                        comp.setBackground(Color.red);
                    }else {
                        comp.setBackground(Color.white);
                    }
                    return comp;
                }
        };
       
        try {
            carregarModel();
        } catch (Exception ex) {
            Logger.getLogger(FrmConsultaContasPagar.class.getName()).log(Level.SEVERE, null, ex);
        }
        contasjTabbedPane.setSelectedIndex(2);
        this.setVisible(true);
     
    }

    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        AssociadosjPanel = new javax.swing.JPanel();
        nomeCredorjTextField = new javax.swing.JTextField();
        nomeCedentejLabel = new javax.swing.JLabel();
        BarradeTarefasjToolBar = new javax.swing.JToolBar();
        adicionarAPagarjButton = new javax.swing.JButton();
        editarAPagarjButton = new javax.swing.JButton();
        excluirAPagarjButton = new javax.swing.JButton();
        pesquisarAPagarjButton = new javax.swing.JButton();
        SeparadordeTarefasjSeparator = new javax.swing.JToolBar.Separator();
        imprimirTelajButton = new javax.swing.JButton();
        visualizarAPagarjButton = new javax.swing.JButton();
        voltarTelajButton = new javax.swing.JButton();
        contasjTabbedPane = new javax.swing.JTabbedPane();
        vencidasjScrollPane = new javax.swing.JScrollPane();
        vencidasjTable = new javax.swing.JTable();
        vencidasjScrollPane1 = new javax.swing.JScrollPane();
        vencerjTable = new javax.swing.JTable();
        vencendojScrollPane = new javax.swing.JScrollPane();
        vencendojTable = new javax.swing.JTable();
        vencendojScrollPane1 = new javax.swing.JScrollPane();
        futurasjTable = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        valorVencerjLabel = new javax.swing.JLabel();
        totalPagarjLabel = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        valorPagarjLabel = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        valorVencidasjLabel = new javax.swing.JLabel();
        totalVencerjLabel = new javax.swing.JLabel();
        totalVencidasjLabel = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        valorVencendojLabel = new javax.swing.JLabel();
        totalVencendojLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        dataVencimentojDateChooser = new com.toedter.calendar.JDateChooser(null, null, datePattern, new JTextFieldDateEditor(datePattern,
            maskPattern, placeHolder));
    jButton3 = new javax.swing.JButton();
    buscaBancojButton3 = new javax.swing.JButton();
    totalVencidasjLabel1 = new javax.swing.JLabel();
    jPanel8 = new javax.swing.JPanel();
    valorFuturasjLabel = new javax.swing.JLabel();
    numerojTextField = new javax.swing.JTextField();
    jLabel1 = new javax.swing.JLabel();
    jMenuBar1 = new javax.swing.JMenuBar();
    jMenu1 = new javax.swing.JMenu();
    jMenuItem1 = new javax.swing.JMenuItem();
    jMenu2 = new javax.swing.JMenu();
    jMenu3 = new javax.swing.JMenu();
    jMenuItem6 = new javax.swing.JMenuItem();
    jMenuItem5 = new javax.swing.JMenuItem();
    jMenuItem7 = new javax.swing.JMenuItem();
    jMenu4 = new javax.swing.JMenu();
    jMenuItem8 = new javax.swing.JMenuItem();
    jMenuItem9 = new javax.swing.JMenuItem();
    jMenu5 = new javax.swing.JMenu();
    jMenuItem10 = new javax.swing.JMenuItem();
    jMenuItem12 = new javax.swing.JMenuItem();
    jMenuItem11 = new javax.swing.JMenuItem();
    jMenu6 = new javax.swing.JMenu();
    jMenuItem2 = new javax.swing.JMenuItem();

    jMenuItem3.setText("jMenuItem3");

    jMenuItem4.setText("jMenuItem4");

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    setTitle("Consulta Contas a Pagar");
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

    nomeCredorjTextField.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyReleased(java.awt.event.KeyEvent evt) {
            nomeCredorjTextFieldKeyReleased(evt);
        }
    });
    AssociadosjPanel.add(nomeCredorjTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 420, -1));

    nomeCedentejLabel.setText("Nome do Cedente");
    AssociadosjPanel.add(nomeCedentejLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, -1, -1));

    BarradeTarefasjToolBar.setFloatable(false);
    BarradeTarefasjToolBar.setRollover(true);

    adicionarAPagarjButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/dinheiromais.png"))); // NOI18N
    adicionarAPagarjButton.setText("Adicionar");
    adicionarAPagarjButton.setToolTipText("Adicionar Contas a Pagar");
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
    editarAPagarjButton.setToolTipText("Editar Contas a Pagar");
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

    excluirAPagarjButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/dinheiromenos.png"))); // NOI18N
    excluirAPagarjButton.setText("Excluir");
    excluirAPagarjButton.setToolTipText("Excluir Contas a Pagar");
    excluirAPagarjButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    excluirAPagarjButton.setMaximumSize(new java.awt.Dimension(80, 90));
    excluirAPagarjButton.setMinimumSize(new java.awt.Dimension(80, 90));
    excluirAPagarjButton.setPreferredSize(new java.awt.Dimension(80, 90));
    excluirAPagarjButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    excluirAPagarjButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            excluirAPagarjButtonActionPerformed(evt);
        }
    });
    BarradeTarefasjToolBar.add(excluirAPagarjButton);

    pesquisarAPagarjButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pesquisar.png"))); // NOI18N
    pesquisarAPagarjButton.setText("Pesquisar");
    pesquisarAPagarjButton.setToolTipText("Pesquisar Contas a Pagar");
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
    imprimirTelajButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            imprimirTelajButtonActionPerformed(evt);
        }
    });
    BarradeTarefasjToolBar.add(imprimirTelajButton);

    visualizarAPagarjButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/visualizar.png"))); // NOI18N
    visualizarAPagarjButton.setText("Visualizar");
    visualizarAPagarjButton.setToolTipText("Visualizar Cadastro");
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

    AssociadosjPanel.add(BarradeTarefasjToolBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 470, 590, 80));

    contasjTabbedPane.addChangeListener(new javax.swing.event.ChangeListener() {
        public void stateChanged(javax.swing.event.ChangeEvent evt) {
            contasjTabbedPaneStateChanged(evt);
        }
    });

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
    vencidasjTable.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            vencidasjTableMouseClicked(evt);
        }
    });
    vencidasjTable.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyPressed(java.awt.event.KeyEvent evt) {
            vencidasjTableKeyPressed(evt);
        }
    });
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
    vencerjTable.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            vencerjTableMouseClicked(evt);
        }
    });
    vencerjTable.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyPressed(java.awt.event.KeyEvent evt) {
            vencerjTableKeyPressed(evt);
        }
    });
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
    vencendojTable.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            vencendojTableMouseClicked(evt);
        }
    });
    vencendojTable.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyPressed(java.awt.event.KeyEvent evt) {
            vencendojTableKeyPressed(evt);
        }
    });
    vencendojScrollPane.setViewportView(vencendojTable);
    if (vencendojTable.getColumnModel().getColumnCount() > 0) {
        vencendojTable.getColumnModel().getColumn(0).setPreferredWidth(20);
        vencendojTable.getColumnModel().getColumn(1).setPreferredWidth(20);
        vencendojTable.getColumnModel().getColumn(2).setPreferredWidth(300);
        vencendojTable.getColumnModel().getColumn(3).setPreferredWidth(20);
        vencendojTable.getColumnModel().getColumn(4).setPreferredWidth(20);
    }

    contasjTabbedPane.addTab("Contas Vencendo", vencendojScrollPane);

    futurasjTable.setModel(new javax.swing.table.DefaultTableModel(
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
    futurasjTable.getTableHeader().setReorderingAllowed(false);
    vencendojTable.getColumnModel().getColumn(0).setPreferredWidth(30);
    vencendojTable.getColumnModel().getColumn(1).setPreferredWidth(30);
    vencendojTable.getColumnModel().getColumn(2).setPreferredWidth(300);
    vencendojTable.getColumnModel().getColumn(3).setPreferredWidth(30);
    vencendojTable.getColumnModel().getColumn(4).setPreferredWidth(30);
    futurasjTable.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            futurasjTableMouseClicked(evt);
        }
    });
    futurasjTable.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyPressed(java.awt.event.KeyEvent evt) {
            futurasjTableKeyPressed(evt);
        }
    });
    vencendojScrollPane1.setViewportView(futurasjTable);
    if (futurasjTable.getColumnModel().getColumnCount() > 0) {
        futurasjTable.getColumnModel().getColumn(0).setPreferredWidth(20);
        futurasjTable.getColumnModel().getColumn(1).setPreferredWidth(20);
        futurasjTable.getColumnModel().getColumn(2).setPreferredWidth(300);
        futurasjTable.getColumnModel().getColumn(3).setPreferredWidth(20);
        futurasjTable.getColumnModel().getColumn(4).setPreferredWidth(20);
    }

    contasjTabbedPane.addTab("Contas Futuras", vencendojScrollPane1);

    AssociadosjPanel.add(contasjTabbedPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 920, 330));

    jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
    jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    valorVencerjLabel.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
    valorVencerjLabel.setForeground(new java.awt.Color(0, 153, 0));
    valorVencerjLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    valorVencerjLabel.setText("0,00");
    jPanel3.add(valorVencerjLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 140, -1));

    AssociadosjPanel.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 420, 150, 40));

    totalPagarjLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    totalPagarjLabel.setText("Total a Pagar");
    AssociadosjPanel.add(totalPagarjLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 400, -1, -1));

    jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
    jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    valorPagarjLabel.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
    valorPagarjLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    valorPagarjLabel.setText("0,00");
    jPanel6.add(valorPagarjLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 140, -1));

    AssociadosjPanel.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 420, 160, 40));

    jPanel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
    jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    valorVencidasjLabel.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
    valorVencidasjLabel.setForeground(java.awt.Color.red);
    valorVencidasjLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    valorVencidasjLabel.setText("0,00");
    jPanel7.add(valorVencidasjLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 130, -1));

    AssociadosjPanel.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 420, 140, 40));

    totalVencerjLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    totalVencerjLabel.setText("Total a Vencer");
    AssociadosjPanel.add(totalVencerjLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 400, -1, -1));

    totalVencidasjLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    totalVencidasjLabel.setText("Total Vencidas");
    AssociadosjPanel.add(totalVencidasjLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 400, -1, -1));

    jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
    jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    valorVencendojLabel.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
    valorVencendojLabel.setForeground(java.awt.Color.blue);
    valorVencendojLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    valorVencendojLabel.setText("0,00");
    jPanel5.add(valorVencendojLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 130, -1));

    AssociadosjPanel.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, 150, 40));

    totalVencendojLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    totalVencendojLabel1.setText("Total Vencendo");
    AssociadosjPanel.add(totalVencendojLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, -1, -1));

    jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Data Vencimento"));
    jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    dataVencimentojDateChooser.addFocusListener(new java.awt.event.FocusAdapter() {
        public void focusGained(java.awt.event.FocusEvent evt) {
            dataVencimentojDateChooserFocusGained(evt);
        }
    });
    dataVencimentojDateChooser.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyPressed(java.awt.event.KeyEvent evt) {
            dataVencimentojDateChooserKeyPressed(evt);
        }
    });
    jPanel1.add(dataVencimentojDateChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 130, -1));

    jButton3.setText("Filtrar Data");
    jButton3.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton3ActionPerformed(evt);
        }
    });
    jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, -1, -1));

    AssociadosjPanel.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 10, 270, 50));

    buscaBancojButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/note.png"))); // NOI18N
    buscaBancojButton3.setToolTipText("Contas por Mês/Ano");
    buscaBancojButton3.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            buscaBancojButton3ActionPerformed(evt);
        }
    });
    AssociadosjPanel.add(buscaBancojButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 420, 40, 40));

    totalVencidasjLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    totalVencidasjLabel1.setText("Total Futuras");
    AssociadosjPanel.add(totalVencidasjLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 400, -1, -1));

    jPanel8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
    jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    valorFuturasjLabel.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
    valorFuturasjLabel.setForeground(java.awt.Color.red);
    valorFuturasjLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    valorFuturasjLabel.setText("0,00");
    jPanel8.add(valorFuturasjLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 130, -1));

    AssociadosjPanel.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 420, 140, 40));

    numerojTextField.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            numerojTextFieldActionPerformed(evt);
        }
    });
    numerojTextField.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyReleased(java.awt.event.KeyEvent evt) {
            numerojTextFieldKeyReleased(evt);
        }
    });
    AssociadosjPanel.add(numerojTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 120, -1));

    jLabel1.setText("Nº da Conta");
    AssociadosjPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

    getContentPane().add(AssociadosjPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 940, 560));

    jMenu1.setText("Pagamento");
    jMenu1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMenu1ActionPerformed(evt);
        }
    });

    jMenuItem1.setText("Efetuar");
    jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMenuItem1ActionPerformed(evt);
        }
    });
    jMenu1.add(jMenuItem1);

    jMenuBar1.add(jMenu1);

    jMenu2.setText("Relatórios");

    jMenu3.setText("Contas a Pagar");

    jMenuItem6.setText("Geral");
    jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMenuItem6ActionPerformed(evt);
        }
    });
    jMenu3.add(jMenuItem6);

    jMenuItem5.setText("Fornecedor");
    jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMenuItem5ActionPerformed(evt);
        }
    });
    jMenu3.add(jMenuItem5);

    jMenuItem7.setText("Período");
    jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMenuItem7ActionPerformed(evt);
        }
    });
    jMenu3.add(jMenuItem7);

    jMenu2.add(jMenu3);

    jMenu4.setText("Contas Vencidas");

    jMenuItem8.setText("Geral");
    jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMenuItem8ActionPerformed(evt);
        }
    });
    jMenu4.add(jMenuItem8);

    jMenuItem9.setText("Fornecedor");
    jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMenuItem9ActionPerformed(evt);
        }
    });
    jMenu4.add(jMenuItem9);

    jMenu2.add(jMenu4);

    jMenu5.setText("Contas Pagas");

    jMenuItem10.setText("Período");
    jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMenuItem10ActionPerformed(evt);
        }
    });
    jMenu5.add(jMenuItem10);

    jMenuItem12.setText("Fornecedor");
    jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMenuItem12ActionPerformed(evt);
        }
    });
    jMenu5.add(jMenuItem12);

    jMenuItem11.setText("Plano Contas");
    jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMenuItem11ActionPerformed(evt);
        }
    });
    jMenu5.add(jMenuItem11);

    jMenu2.add(jMenu5);

    jMenuBar1.add(jMenu2);

    jMenu6.setText("Exportar Excel");

    jMenuItem2.setText("Contas Pagas");
    jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMenuItem2ActionPerformed(evt);
        }
    });
    jMenu6.add(jMenuItem2);

    jMenuBar1.add(jMenu6);

    setJMenuBar(jMenuBar1);

    pack();
    }// </editor-fold>//GEN-END:initComponents
    private void adicionarAPagarjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adicionarAPagarjButtonActionPerformed
        if (this.usuarioLogado.getAcesso().getCpAdicionar()==1){
            new FrmCadastrarContaPagar(config, null, this,0);
        }else JOptionPane.showMessageDialog(null, "Acesso Negado");
        
    }//GEN-LAST:event_adicionarAPagarjButtonActionPerformed
    private void editarAPagarjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarAPagarjButtonActionPerformed
        Contaspagar contaPagar = null;
        if (this.usuarioLogado.getAcesso().getCpEditar() == 1) {
            int linha = -10;
            if (contasjTabbedPane.getSelectedIndex() == 0) {
                linha = vencidasjTable.getSelectedRow();
                if (linha >= 0) {
                    contaPagar = listaVencidas.get(linha);
                }
            } else if (contasjTabbedPane.getSelectedIndex() == 1) {
                linha = vencerjTable.getSelectedRow();
                if (linha >= 0) {
                    contaPagar = listaVencer.get(linha);
                }
            } else if (contasjTabbedPane.getSelectedIndex() == 2) {
                linha = vencendojTable.getSelectedRow();
                if (linha >= 0) {
                    contaPagar = listaVencendo.get(linha);
                }
            }
            if (contaPagar != null) {
                new FrmCadastrarContaPagar(config, contaPagar, this, 0);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso Negado");
        }

    }//GEN-LAST:event_editarAPagarjButtonActionPerformed
    private void excluirAPagarjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirAPagarjButtonActionPerformed
        Contaspagar contaPagar = null;
        if (this.usuarioLogado.getAcesso().getCpExcluir() == 1) {
            int linha = -10;
            if (contasjTabbedPane.getSelectedIndex() == 0) {
                linha = vencidasjTable.getSelectedRow();
                if (linha >= 0) {
                    contaPagar = listaVencidas.get(linha);
                }
            } else if (contasjTabbedPane.getSelectedIndex() == 1) {
                linha = vencerjTable.getSelectedRow();
                if (linha >= 0) {
                    contaPagar = listaVencer.get(linha);
                }
            } else if (contasjTabbedPane.getSelectedIndex() == 2) {
                linha = vencendojTable.getSelectedRow();
                if (linha >= 0) {
                    contaPagar = listaVencendo.get(linha);
                }
            }
            if (contaPagar != null) {
                ContasPagarController contasPagarController = new ContasPagarController();
                String msg = "Excluir Conta Nº " + contaPagar.getNumeroDocumento();
                boolean resultado = JOptionPane.showConfirmDialog(null, msg, "Atenção", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == 0;
                if (resultado){
                    contasPagarController.excluir(contaPagar);
                    setNovaConta();
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso Negado");
        }
    }//GEN-LAST:event_excluirAPagarjButtonActionPerformed
    private void voltarTelajButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarTelajButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_voltarTelajButtonActionPerformed
    private void pesquisarAPagarjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisarAPagarjButtonActionPerformed
       
    }//GEN-LAST:event_pesquisarAPagarjButtonActionPerformed

    private void nomeCredorjTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomeCredorjTextFieldKeyReleased
        if (contasjTabbedPane.getSelectedIndex()==0){
            carregarModelVencidas();
            somarListarContasPagar();
        }else if (contasjTabbedPane.getSelectedIndex()==1){
            carregarModelVencer();
            somarListarContasPagar();
        }else if (contasjTabbedPane.getSelectedIndex()==2){
            carregarModelVencendo();
            somarListarContasPagar();
        }
    }//GEN-LAST:event_nomeCredorjTextFieldKeyReleased

    private void visualizarAPagarjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_visualizarAPagarjButtonActionPerformed
        Contaspagar contaPagar = null;
        int linha = -10;
        if (contasjTabbedPane.getSelectedIndex() == 0) {
            linha = vencidasjTable.getSelectedRow();
            if (linha >= 0) {
                contaPagar = listaVencidas.get(linha);
            }
        } else if (contasjTabbedPane.getSelectedIndex() == 1) {
            linha = vencerjTable.getSelectedRow();
            if (linha >= 0) {
                contaPagar = listaVencer.get(linha);
            }
        } else if (contasjTabbedPane.getSelectedIndex() == 2) {
            linha = vencendojTable.getSelectedRow();
            if (linha >= 0) {
                contaPagar = listaVencendo.get(linha);
            }
        }
        if (contaPagar != null) {
            new FrmCadastrarContaPagar(config, contaPagar, this, 1);
        }
    }//GEN-LAST:event_visualizarAPagarjButtonActionPerformed

    private void imprimirTelajButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imprimirTelajButtonActionPerformed
        
    }//GEN-LAST:event_imprimirTelajButtonActionPerformed

    private void contasjTabbedPaneStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_contasjTabbedPaneStateChanged

            }//GEN-LAST:event_contasjTabbedPaneStateChanged

    private void vencidasjTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vencidasjTableMouseClicked

            }//GEN-LAST:event_vencidasjTableMouseClicked

    private void dataVencimentojDateChooserFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dataVencimentojDateChooserFocusGained

   }//GEN-LAST:event_dataVencimentojDateChooserFocusGained

    private void dataVencimentojDateChooserKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dataVencimentojDateChooserKeyPressed
        try {
            carregarModel();
        } catch (Exception ex) {
            Logger.getLogger(FrmConsultaContasPagar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_dataVencimentojDateChooserKeyPressed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            carregarModel();
        } catch (Exception ex) {
            Logger.getLogger(FrmConsultaContasPagar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void buscaBancojButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscaBancojButton3ActionPerformed
        new FrmListaMes();
    }//GEN-LAST:event_buscaBancojButton3ActionPerformed

    private void vencendojTableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_vencendojTableKeyPressed
         if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            if (this.listaPagamento==null){
                listaPagamento = new ArrayList<Contaspagar>();
            }
            int linha = vencendojTable.getSelectedRow();
            if (linha>=0){
                if (verificarContaPagamento(listaVencendo.get(linha))){
                    listaPagamento.remove(listaVencidas.get(linha));
                    listaVencendo.get(linha).setPagamento("");
                }else {
                    listaPagamento.add(listaVencendo.get(linha));
                    listaVencendo.get(linha).setPagamento("SIM");
                }
            }
        }else if (evt.getKeyCode() == KeyEvent.VK_P){
            if (listaPagamento == null){
                listaPagamento = new ArrayList<Contaspagar>();
            }
             int linha = vencendojTable.getSelectedRow();
             if (linha >= 0) {
                 String valor = JOptionPane.showInputDialog("Valor Pagto Parcial");
                 double valorParcial = Formatacao.ConvercaoMonetariaDouble(valor);
                 listaVencendo.get(linha).setValorParcial(valorParcial);
             }
        }
    }//GEN-LAST:event_vencendojTableKeyPressed

    private void vencidasjTableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_vencidasjTableKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            if (this.listaPagamento==null){
                listaPagamento = new ArrayList<Contaspagar>();
            }
            int linha = vencidasjTable.getSelectedRow();
            if (linha>=0){
                if (verificarContaPagamento(listaVencidas.get(linha))){
                    listaPagamento.remove(listaVencidas.get(linha));
                    listaVencidas.get(linha).setPagamento("");
                }else {
                    listaPagamento.add(listaVencidas.get(linha));
                    listaVencidas.get(linha).setPagamento("SIM");
                }
            }
        }else if (evt.getKeyCode() == KeyEvent.VK_P){
            if (listaPagamento == null){
                listaPagamento = new ArrayList<Contaspagar>();
            }
            int linha = vencidasjTable.getSelectedRow();
            if (linha>=0){
                if (verificarContaPagamento(listaVencidas.get(linha))){
                    listaPagamento.remove(listaVencidas.get(linha));
                    listaVencidas.get(linha).setPagamento("");
                }else {
                    String valor = JOptionPane.showInputDialog("Valor Pagto Parcial");
                    double valorParcial = Formatacao.ConvercaoMonetariaDouble(valor);
                    listaVencidas.get(linha).setValorParcial(valorParcial);
                    listaPagamento.add(listaVencidas.get(linha));
                    listaVencidas.get(linha).setPagamento("PAR");
                }
            }
        }else if (evt.getKeyCode() == KeyEvent.VK_E){
            int linha = vencidasjTable.getSelectedRow();
            if (linha>=0){
                listaVencidas.get(linha).setBoletoEntregue(1);
                ContasPagarController contasPagarController = new ContasPagarController();
                contasPagarController.salvar(listaVencidas.get(linha));
                carregarModelVencidas();
            }
        }
    }//GEN-LAST:event_vencidasjTableKeyPressed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        if (this.listaPagamento!=null){
            if (this.listaPagamento.size()>0){
                new FrmPagamento(listaPagamento, this, 1 ,this.config, usuarioLogado);
            }else JOptionPane.showMessageDialog(null, "Nenhuma conta selecionada");
        }else JOptionPane.showMessageDialog(null, "Nenhuma conta selecionada");
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void vencerjTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vencerjTableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_vencerjTableMouseClicked

    private void vencerjTableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_vencerjTableKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            if (this.listaPagamento==null){
                listaPagamento = new ArrayList<Contaspagar>();
            }
            int linha = vencerjTable.getSelectedRow();
            if (linha>=0){
                if (verificarContaPagamento(listaVencer.get(linha))){
                    listaPagamento.remove(listaVencer.get(linha));
                    listaVencer.get(linha).setPagamento("");
                }else {
                    listaPagamento.add(listaVencer.get(linha));
                    listaVencer.get(linha).setPagamento("SIM");
                }
            }
        }else if (evt.getKeyCode() == KeyEvent.VK_P){
            if (listaPagamento == null){
                listaPagamento = new ArrayList<Contaspagar>();
            }
            int linha = vencerjTable.getSelectedRow();
            if (linha>=0){
                if (verificarContaPagamento(listaVencer.get(linha))){
                    listaPagamento.remove(listaVencer.get(linha));
                    listaVencer.get(linha).setPagamento("");
                }else {
                    String valor = JOptionPane.showInputDialog("Valor Pagto Parcial");
                    double valorParcial = Formatacao.ConvercaoMonetariaDouble(valor);
                    listaVencer.get(linha).setValorParcial(valorParcial);
                    listaPagamento.add(listaVencer.get(linha));
                    listaVencer.get(linha).setPagamento("PAR");
                }
            }
        }
    }//GEN-LAST:event_vencerjTableKeyPressed

    private void vencendojTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vencendojTableMouseClicked
        
    }//GEN-LAST:event_vencendojTableMouseClicked

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        new FrmcpData(this, 2);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        String url = ("telas/ContasPagar/reportcontasPagarGeral.jasper");
        Map parameters = new HashMap();
        try {
            parameters.put("nomeFantasia", this.config.getEmpresa().getNomeFantasia());
            parameters.put("RazaoSocial", this.config.getEmpresa().getRazaoSocial());
            parameters.put("idEmpresa", this.config.getEmpresa().getIdempresa());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Não foi possível gerar o relatório " + ex);
            ex.printStackTrace();
        }
        new relatoriosJasper(url, parameters);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        new FrmcpData(this, 3);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        setRelContasVencidasGeral();
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        new FrmcpData(this, 8);
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        new FrmcpData(this, 5);
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        new FrmcpData(this, 6);
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        new FrmcpData(this, 7);
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void numerojTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numerojTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numerojTextFieldActionPerformed

    private void numerojTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numerojTextFieldKeyReleased
        if (contasjTabbedPane.getSelectedIndex()==0){
            carregarModelVencidas();
            somarListarContasPagar();
        }else if (contasjTabbedPane.getSelectedIndex()==1){
            carregarModelVencer();
            somarListarContasPagar();
        }else if (contasjTabbedPane.getSelectedIndex()==2){
            carregarModelVencendo();
            somarListarContasPagar();
        }
    }//GEN-LAST:event_numerojTextFieldKeyReleased

    private void futurasjTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_futurasjTableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_futurasjTableMouseClicked

    private void futurasjTableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_futurasjTableKeyPressed
        
    }//GEN-LAST:event_futurasjTableKeyPressed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        new FrmExportarContasPagar(this);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AssociadosjPanel;
    private javax.swing.JToolBar BarradeTarefasjToolBar;
    private javax.swing.JToolBar.Separator SeparadordeTarefasjSeparator;
    private javax.swing.JButton adicionarAPagarjButton;
    private javax.swing.JButton buscaBancojButton3;
    private javax.swing.JTabbedPane contasjTabbedPane;
    private com.toedter.calendar.JDateChooser dataVencimentojDateChooser;
    private javax.swing.JButton editarAPagarjButton;
    private javax.swing.JButton excluirAPagarjButton;
    private javax.swing.JTable futurasjTable;
    private javax.swing.JButton imprimirTelajButton;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JLabel nomeCedentejLabel;
    private javax.swing.JTextField nomeCredorjTextField;
    private javax.swing.JTextField numerojTextField;
    private javax.swing.JButton pesquisarAPagarjButton;
    private javax.swing.JLabel totalPagarjLabel;
    private javax.swing.JLabel totalVencendojLabel1;
    private javax.swing.JLabel totalVencerjLabel;
    private javax.swing.JLabel totalVencidasjLabel;
    private javax.swing.JLabel totalVencidasjLabel1;
    private javax.swing.JLabel valorFuturasjLabel;
    private javax.swing.JLabel valorPagarjLabel;
    private javax.swing.JLabel valorVencendojLabel;
    private javax.swing.JLabel valorVencerjLabel;
    private javax.swing.JLabel valorVencidasjLabel;
    private javax.swing.JScrollPane vencendojScrollPane;
    private javax.swing.JScrollPane vencendojScrollPane1;
    private javax.swing.JTable vencendojTable;
    private javax.swing.JTable vencerjTable;
    private javax.swing.JScrollPane vencidasjScrollPane;
    private javax.swing.JScrollPane vencidasjScrollPane1;
    private javax.swing.JTable vencidasjTable;
    private javax.swing.JButton visualizarAPagarjButton;
    private javax.swing.JButton voltarTelajButton;
    // End of variables declaration//GEN-END:variables

    public void carregarModelVencendo(){
        String dataAtual = Formatacao.ConvercaoDataSql(dataVencimentojDateChooser.getDate());
        ContasPagarController contasPagarController = new ContasPagarController();
        String sqlVencendo = null;
        if ((nomeCredorjTextField.getText().length() <= 0) && (numerojTextField.getText().length()<=0)) {
            sqlVencendo = "select c from Contaspagar c where c.pagamentocontaspagar=1  and c.dataReal='" + dataAtual + "' and c.empresa =" + this.config.getEmpresa().getIdempresa() + " order by c.dataVencimento, numeroDocumento";
        }else {
            if (nomeCredorjTextField.getText().length()>0){
                sqlVencendo = "select c from Contaspagar c where c.pagamentocontaspagar=1  and c.dataReal='" + dataAtual + "' and c.credor like '"  + nomeCredorjTextField.getText() + "%' and c.empresa =" + this.config.getEmpresa().getIdempresa() + " order by c.dataVencimento, numeroDocumento";
            }else {
                if (numerojTextField.getText().length()>0){
                    sqlVencendo = "select c from Contaspagar c where c.pagamentocontaspagar=1  and c.dataReal='" + dataAtual + "' and c.numeroDocumento like '"  + numerojTextField.getText() + "%' and c.empresa =" + this.config.getEmpresa().getIdempresa() + " order by c.dataVencimento, numeroDocumento";
                }
            }
        }
        listaVencendo = contasPagarController.listarContas(sqlVencendo);
        if (listaVencendo != null) {
            modelVencendo = new ContasPagarTableModel(listaVencendo);
        } else {
            modelVencendo = new ContasPagarTableModel(new ArrayList<Contaspagar>());
        }
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.RIGHT);
        vencendojTable.setModel(modelVencendo);
        vencendojTable.getColumnModel().getColumn(0).setPreferredWidth(40);
        vencendojTable.getColumnModel().getColumn(1).setPreferredWidth(50);
        vencendojTable.getColumnModel().getColumn(2).setPreferredWidth(240);
        vencendojTable.getColumnModel().getColumn(3).setPreferredWidth(50);
        vencendojTable.getColumnModel().getColumn(4).setCellRenderer(renderer);
        vencendojTable.getColumnModel().getColumn(4).setPreferredWidth(40);
        vencendojTable.getColumnModel().getColumn(5).setPreferredWidth(40);
        vencendojTable.getColumnModel().getColumn(6).setPreferredWidth(5);
        vencendojTable.getColumnModel().getColumn(7).setCellRenderer(this.rendererCor);
        vencendojTable.getColumnModel().getColumn(7).setPreferredWidth(5);
        vencendojTable.repaint();

    
    }
    
    public void carregarModelVencer(){
        String dataAtual = Formatacao.ConvercaoDataSql(dataVencimentojDateChooser.getDate());
        ContasPagarController contasPagarController = new ContasPagarController();
        String sqlVencer = null;
        if ((nomeCredorjTextField.getText().length() <= 0) && (numerojTextField.getText().length()<=0)) {
            sqlVencer = "select c from Contaspagar c where c.pagamentocontaspagar=1  and c.dataReal>'" + dataAtual + "' and c.empresa =" + this.config.getEmpresa().getIdempresa() + " order by c.dataVencimento, numeroDocumento";
        }else {
            if (nomeCredorjTextField.getText().length() > 0) {
                sqlVencer =   "select c from Contaspagar c where c.pagamentocontaspagar=1  and  c.dataReal>'" + dataAtual + "' and c.credor like '"  + nomeCredorjTextField.getText() + "%' and c.empresa =" + this.config.getEmpresa().getIdempresa() + " order by c.dataVencimento, numeroDocumento";
            }else {
                if (numerojTextField.getText().length() > 0) {
                    sqlVencer =   "select c from Contaspagar c where c.pagamentocontaspagar=1  and  c.dataReal>'" + dataAtual + "' and c.numeroDocumento like '"  + numerojTextField.getText() + "%' and c.empresa =" + this.config.getEmpresa().getIdempresa() + " order by c.dataVencimento, numeroDocumento";
                }
            }
        }
        listaVencer = contasPagarController.listarContas(sqlVencer);
        if (listaVencer != null) {
            modelVencer = new ContasPagarTableModel(listaVencer);
        } else {
            modelVencer = new ContasPagarTableModel(new ArrayList<Contaspagar>());
        }
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.RIGHT);
        vencerjTable.setModel(modelVencer);
        vencerjTable.getColumnModel().getColumn(0).setPreferredWidth(40);
        vencerjTable.getColumnModel().getColumn(1).setPreferredWidth(50);
        vencerjTable.getColumnModel().getColumn(2).setPreferredWidth(240);
        vencerjTable.getColumnModel().getColumn(3).setPreferredWidth(50);
        vencerjTable.getColumnModel().getColumn(4).setCellRenderer(renderer);
        vencerjTable.getColumnModel().getColumn(4).setPreferredWidth(40);
        vencerjTable.getColumnModel().getColumn(5).setPreferredWidth(40);
        vencerjTable.getColumnModel().getColumn(6).setPreferredWidth(5);
        vencerjTable.getColumnModel().getColumn(7).setCellRenderer(this.rendererCor);
        vencerjTable.getColumnModel().getColumn(7).setPreferredWidth(5);
        vencerjTable.repaint();
        
    }
    
    public void carregarModelVencidas(){
        String dataAtual = Formatacao.ConvercaoDataSql(dataVencimentojDateChooser.getDate());
        ContasPagarController contasPagarController = new ContasPagarController();
        String sqlVencidas = null;
        if ((nomeCredorjTextField.getText().length() <= 0) && (numerojTextField.getText().length()<=0)) {
            sqlVencidas = "select c from Contaspagar c where c.pagamentocontaspagar=1  and c.dataReal<'" + dataAtual + "' and c.empresa =" + this.config.getEmpresa().getIdempresa() + " order by c.dataVencimento, c.numeroDocumento";
        }else {
            if (nomeCredorjTextField.getText().length()>0){
                sqlVencidas = "select c from Contaspagar c where c.pagamentocontaspagar=1  and c.dataReal<'" + dataAtual + "' and c.credor like '"  + nomeCredorjTextField.getText() + "%' and c.empresa =" + this.config.getEmpresa().getIdempresa() + " order by c.dataVencimento, numeroDocumento";
            }else {
                if (numerojTextField.getText().length()>0){
                    sqlVencidas = "select c from Contaspagar c where c.pagamentocontaspagar=1  and c.dataReal<'" + dataAtual + "' and c.numeroDocumento like '"  + numerojTextField.getText() + "%' and c.empresa =" + this.config.getEmpresa().getIdempresa() + " order by c.dataVencimento, numeroDocumento";
                }
            }
        }
        listaVencidas = contasPagarController.listarContas(sqlVencidas);
         if (listaVencidas != null) {
            modelVencidas = new ContasPagarTableModel(listaVencidas);
        } else {
            modelVencidas = new ContasPagarTableModel(new ArrayList<Contaspagar>());
        }
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.RIGHT);
        vencidasjTable.setModel(modelVencidas);
        vencidasjTable.getColumnModel().getColumn(0).setPreferredWidth(40);
        vencidasjTable.getColumnModel().getColumn(1).setPreferredWidth(50);
        vencidasjTable.getColumnModel().getColumn(2).setPreferredWidth(240);
        vencidasjTable.getColumnModel().getColumn(3).setPreferredWidth(50);
        vencidasjTable.getColumnModel().getColumn(4).setCellRenderer(renderer);
        vencidasjTable.getColumnModel().getColumn(4).setPreferredWidth(40);
        vencidasjTable.getColumnModel().getColumn(5).setPreferredWidth(40);
        vencidasjTable.getColumnModel().getColumn(6).setPreferredWidth(5);
        vencidasjTable.getColumnModel().getColumn(7).setCellRenderer(this.rendererCor);
        vencidasjTable.getColumnModel().getColumn(7).setPreferredWidth(5);
        vencidasjTable.repaint();
        
    }
    
        
    public void carregarModelFuturas(){
        String dataAtual = Formatacao.ConvercaoDataSql(dataVencimentojDateChooser.getDate());
        ContasPagarController contasPagarController = new ContasPagarController();
        String sqlFutura = null;
        if (nomeCredorjTextField.getText().length() <= 0) {          
            sqlFutura = "select c from Contaspagar c where c.pagamentocontaspagar=1  and c.dataReal>'" + dataAtual + "' and c.futura='S' and c.empresa=" + this.config.getEmpresa().getIdempresa();
        }else {
            sqlFutura = "select c from Contaspagar c where c.pagamentocontaspagar=1  and c.dataReal>'" + dataAtual + "' and c.futura='S'  and c.dataReal<'" + dataAtual + "' and c.credor like '"  + nomeCredorjTextField.getText() + "%'  and c.empresa=" + this.config.getEmpresa().getIdempresa() + " order by c.dataVencimento";
        }
        listaFuturas = contasPagarController.listarContas(sqlFutura);
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.RIGHT);
        if (listaFuturas==null){
            listaFuturas = new ArrayList<Contaspagar>();
        }
        modelFutura = new ContasPagarTableModel(listaFuturas);
        futurasjTable.setModel(modelFutura);
        futurasjTable.getColumnModel().getColumn(0).setPreferredWidth(40);
        futurasjTable.getColumnModel().getColumn(1).setPreferredWidth(50);
        futurasjTable.getColumnModel().getColumn(2).setPreferredWidth(240);
        futurasjTable.getColumnModel().getColumn(3).setPreferredWidth(50);
        futurasjTable.getColumnModel().getColumn(4).setCellRenderer(renderer);
        futurasjTable.getColumnModel().getColumn(4).setPreferredWidth(40);
        futurasjTable.getColumnModel().getColumn(5).setPreferredWidth(40);
        futurasjTable.getColumnModel().getColumn(6).setPreferredWidth(5);
        futurasjTable.getColumnModel().getColumn(7).setCellRenderer(this.rendererCor);
        futurasjTable.getColumnModel().getColumn(7).setPreferredWidth(5);
        futurasjTable.repaint();
    }
    
    public void carregarModel(){
        carregarModelFuturas();
        carregarModelVencendo();
        carregarModelVencer();
        carregarModelVencidas();
        somarListarContasPagar();
    }

    public void setNovaConta() {
        try {
            carregarModel();
        } catch (Exception ex) {
            Logger.getLogger(FrmConsultaContasPagar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void somarListarContasPagar(){
        double valorVencer = 0;
        double valorVencida = 0;
        double valorVencendo =0;
        double valorFutura = 0;
        double soma = 0;
        
         for(int i=0;i<listaFuturas.size();i++){
            valorFutura = valorFutura+ listaFuturas.get(i).getValorConta();
        }
        valorFuturasjLabel.setText(Formatacao.foramtarDoubleString(valorFutura));
         
        
        for(int i=0;i<listaVencendo.size();i++){
            valorVencendo = valorVencendo + listaVencendo.get(i).getValorConta();
        }
        valorVencendojLabel.setText(Formatacao.foramtarDoubleString(valorVencendo));
        soma = soma + valorVencendo;
        
        for(int i=0;i<listaVencer.size();i++){
            valorVencer = valorVencer + listaVencer.get(i).getValorConta();
        }
        valorVencerjLabel.setText(Formatacao.foramtarDoubleString(valorVencer - valorFutura));
        soma = soma + valorVencer;
        
        for(int i=0;i<listaVencidas.size();i++){
            valorVencida = valorVencida + listaVencidas.get(i).getValorConta();
        }
        valorVencidasjLabel.setText(Formatacao.foramtarDoubleString(valorVencida));
        soma = valorVencida + soma;
        
              
        valorPagarjLabel.setText(Formatacao.foramtarDoubleString(soma));
    }
    
    public boolean verificarContaPagamento(Contaspagar contaPagar){
        for (int i=0;i<this.listaPagamento.size();i++){
            if (this.listaPagamento.get(i).getIdcontasPagar() == contaPagar.getIdcontasPagar()){
                return true;
            }
        }
        return false;
    }
    
    public boolean buscarContaDocuemnto(String numeroDocuemnto){
        List<Contaspagar> cp = new ArrayList<Contaspagar>();
        ContasPagarController contasPagarController = new ContasPagarController();
        String sql = "select c from Contaspagar c where c.pagamentocontaspagar=1  and c.numeroDocumento='" + numeroDocuemnto;
        cp = contasPagarController.listarContas(sql);
        if (cp.size()>0){
            return verificarContaPagamento(cp.get(0));
        }
        return false;
    }

    public void setPagamento() {
        try {
            carregarModel();
            this.listaPagamento= null;
        } catch (Exception ex) {
            Logger.getLogger(FrmConsultaContasPagar.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    public void setListaCheques(List<ControleChequeBean> listaCheque, double valorFornecedor) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
