/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PesquisaAssociado.java
 *
 * Created on 20/09/2009, 15:29:05
 */
package telas.Produtos;


import Interfaces.IdevolucaoRelatorio;
import Interfaces.IforPedido;
import Interfaces.ItelaConsulta;
import Regras.CestController;
import Regras.EstoqueController;
import Regras.Formatacao;
import Regras.ProdutoController;
import beanController.NfDuplicatas;
import beanController.NfProdutos;
import beanController.NotaEletronica;
import beanController.ProdutoRemotoBean;
import controler.CodigoBarrasController;
import controler.Config;
import controler.relatoriosJasper;
import dao.VendaDao;
import facade.ProdutoFacade;
import facadeRemoto.ProdutoRemotoFacade;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.net.URL;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import model.Banco;
import model.Cest;
import model.CodigoBarras;
import model.Estoque;
import model.Fornecedor;
import model.Produto;
import telas.Produtos.codigoBarras.FrmConsultaCodigoBarras;
import telas.RelatorioVendas.IrelatorioVenda;
import view.Viewconsultaprodutoestoque;



public final class FrmConsultaProdutos extends javax.swing.JFrame implements ItelaConsulta {

    private ItelaConsulta telaConsulta;
    private List<Viewconsultaprodutoestoque> listaProduto;
    private ConsultaProdutoTableModel model;
    private Produto produto;
    private Config config;
    private boolean entrada;
    private IdevolucaoRelatorio telaDevolucao;
    private IforPedido telaPedido;
    IrelatorioVenda telaVenda;
    List<Produto> listaProdutoRemoto;
    private int linhaTabela;
    private boolean nfe=false;

 
    public FrmConsultaProdutos(ItelaConsulta telaConsulta, Produto produto, Config config, boolean entrada) {
        this.config = config;
        this.produto = produto;
        this.entrada = entrada;
        this.nfe=false;
        this.telaConsulta = telaConsulta;
        initComponents();
        URL url = this.getClass().getResource("/imagens/logo_mini.png");
        Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(imagemTitulo);
        this.setLocationRelativeTo(null);
        try{
            UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
        }catch (Exception e){
        }
        caregarConsultaProduto(0);
        descricaojTextField.requestFocus();
        setVisible(true);
    }

    /** Creates new form PesquisaAssociado */


    public FrmConsultaProdutos(Config config) {
        this.produto = null;
        this.entrada = false;
        this.config = config;
        this.telaConsulta = null;
        this.telaPedido = null;
        this.telaDevolucao = null;
        this.config = config;
        initComponents();
        URL url = this.getClass().getResource("/imagens/logo_mini.png");
        Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(imagemTitulo);
        this.setLocationRelativeTo(null);
        try{
            UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
        }catch (Exception e){
        }
        carregarImportacao();
        caregarConsultaProduto(0);
        descricaojTextField.requestFocus();
        setVisible(true);
    }
    
    public FrmConsultaProdutos(ItelaConsulta telaConsulta, Config config, boolean entrada) {
        this.produto = null;
        this.entrada = entrada;
        this.config = config;
        this.telaPedido = null;
        this.telaConsulta = telaConsulta;
        this.telaDevolucao = null;
        this.config = config;
        initComponents();
        URL url = this.getClass().getResource("/imagens/logo_mini.png");
        Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(imagemTitulo);
        this.setLocationRelativeTo(null);
        try{
            UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
        }catch (Exception e){
        }
        caregarConsultaProduto(0);
        descricaojTextField.requestFocus();
        setVisible(true);
    }
    
    public FrmConsultaProdutos(ItelaConsulta telaConsulta, Config config, boolean entrada, boolean nfe) {
        this.produto = null;
        this.entrada = false;
        this.nfe = nfe;
        this.config = config;
        this.telaPedido = null;
        this.telaConsulta = telaConsulta;
        this.telaDevolucao = null;
        this.config = config;
        initComponents();
        URL url = this.getClass().getResource("/imagens/logo_mini.png");
        Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(imagemTitulo);
        this.setLocationRelativeTo(null);
        try{
            UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
        }catch (Exception e){
        }
        caregarConsultaProduto(0);
        descricaojTextField.requestFocus();
        setVisible(true);
    }
    
    public FrmConsultaProdutos(IforPedido telaPedido, Config config, boolean entrada) {
        this.produto = null;
        this.entrada = entrada;
        this.config = config;
        this.telaPedido = telaPedido;
        this.telaConsulta = null;
        this.telaDevolucao = null;
        this.config = config;
        initComponents();
        URL url = this.getClass().getResource("/imagens/logo_mini.png");
        Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(imagemTitulo);
        this.setLocationRelativeTo(null);
        try{
            UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
        }catch (Exception e){
        }
        caregarConsultaProduto(0);
        descricaojTextField.requestFocus();
        setVisible(true);
        
    }
    
    public FrmConsultaProdutos(IdevolucaoRelatorio telaDevolucao, Config config) throws HeadlessException {
        this.telaDevolucao= telaDevolucao;
        this.telaPedido = null;
        this.telaConsulta = null;
        this.config = config;
        initComponents();
        URL url = this.getClass().getResource("/imagens/logo_mini.png");
        Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(imagemTitulo);
        this.setLocationRelativeTo(null);
        try{
            UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
        }catch (Exception e){
        }
        caregarConsultaProduto(0);
        descricaojTextField.requestFocus();
        setVisible(true);
    }
    
    public FrmConsultaProdutos(Config config, boolean entrada, IrelatorioVenda telaVenda) {
        this.produto = null;
        this.entrada = entrada;
        this.config = config;
        this.telaVenda = telaVenda;
        this.telaDevolucao=null;
        this.telaPedido=null;
        this.telaConsulta=null;
        initComponents();
        URL url = this.getClass().getResource("/imagens/logo_mini.png");
        Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(imagemTitulo);
        this.setLocationRelativeTo(null);
        try{
            UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
        }catch (Exception e){
        }
        caregarConsultaProduto(0);
        descricaojTextField.requestFocus();
        setVisible(true);
    }
    
    public FrmConsultaProdutos(Config config, boolean entrada) {
        this.produto = null;
        this.entrada = entrada;
        this.config = config;
        initComponents();
        URL url = this.getClass().getResource("/imagens/logo_mini.png");
        Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(imagemTitulo);
        this.setLocationRelativeTo(null);
        try{
            UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
        }catch (Exception e){
        }
        caregarConsultaProduto(0);
        descricaojTextField.requestFocus();
        setVisible(true);
    }
    
    
    
    public void caregarConsultaProduto(int referencia){
        EstoqueController estoqueController = new EstoqueController();
        listaProduto = estoqueController.consultarEstoqueGeral(config.getEmpresa().getIdempresa());
        setModelProduto(null, null);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        AssociadosjPanel = new javax.swing.JPanel();
        descricaojTextField = new javax.swing.JTextField();
        NomedoAssociadojLabel = new javax.swing.JLabel();
        BarradeTarefasjToolBar = new javax.swing.JToolBar();
        AdicionarjButton = new javax.swing.JButton();
        EditarjButton = new javax.swing.JButton();
        ValorVendajButton = new javax.swing.JButton();
        ExcluirjButton = new javax.swing.JButton();
        PesquisarjButton = new javax.swing.JButton();
        SeparadordeTarefasjSeparator = new javax.swing.JToolBar.Separator();
        ImprimirjButton = new javax.swing.JButton();
        VisualizarjButton = new javax.swing.JButton();
        RelatoriojButton = new javax.swing.JButton();
        FecharrjButton = new javax.swing.JButton();
        FecharrjButton1 = new javax.swing.JButton();
        codigojTextField = new javax.swing.JTextField();
        NomedoAssociadojLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ProdutosjTable = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        alterarEstoquejMenuItem = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        jMenu3.setText("jMenu3");

        jMenuItem4.setText("jMenuItem4");

        jMenu5.setText("jMenu5");

        jMenuItem9.setText("jMenuItem9");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta de Produtos");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setIconImages(null);
        setLocationByPlatform(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        AssociadosjPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        AssociadosjPanel.setPreferredSize(new java.awt.Dimension(800, 600));
        AssociadosjPanel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                AssociadosjPanelKeyPressed(evt);
            }
        });
        AssociadosjPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        descricaojTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                descricaojTextFieldKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                descricaojTextFieldKeyReleased(evt);
            }
        });
        AssociadosjPanel.add(descricaojTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 410, -1));

        NomedoAssociadojLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
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

        ValorVendajButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/dinheiroedit.png"))); // NOI18N
        ValorVendajButton.setText("Valor Venda");
        ValorVendajButton.setToolTipText("Editar Associado");
        ValorVendajButton.setEnabled(false);
        ValorVendajButton.setFocusable(false);
        ValorVendajButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ValorVendajButton.setMaximumSize(new java.awt.Dimension(80, 90));
        ValorVendajButton.setMinimumSize(new java.awt.Dimension(80, 90));
        ValorVendajButton.setPreferredSize(new java.awt.Dimension(80, 90));
        ValorVendajButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        ValorVendajButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ValorVendajButtonEditarCadastroAssociado(evt);
            }
        });
        BarradeTarefasjToolBar.add(ValorVendajButton);

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

        PesquisarjButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pesquisar.png"))); // NOI18N
        PesquisarjButton.setText("Pesquisar");
        PesquisarjButton.setToolTipText("Pesquisar Associado");
        PesquisarjButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        PesquisarjButton.setMaximumSize(new java.awt.Dimension(80, 90));
        PesquisarjButton.setMinimumSize(new java.awt.Dimension(80, 90));
        PesquisarjButton.setPreferredSize(new java.awt.Dimension(80, 90));
        PesquisarjButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        PesquisarjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PesquisarAssociado(evt);
            }
        });
        BarradeTarefasjToolBar.add(PesquisarjButton);
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
        FecharrjButton.setText("Fotos");
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

        FecharrjButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/voltar.png"))); // NOI18N
        FecharrjButton1.setText("Fechar");
        FecharrjButton1.setToolTipText("Fechar");
        FecharrjButton1.setFocusable(false);
        FecharrjButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        FecharrjButton1.setMaximumSize(new java.awt.Dimension(80, 90));
        FecharrjButton1.setMinimumSize(new java.awt.Dimension(80, 90));
        FecharrjButton1.setPreferredSize(new java.awt.Dimension(80, 90));
        FecharrjButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        FecharrjButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FecharrjButton1FecharAssociado(evt);
            }
        });
        BarradeTarefasjToolBar.add(FecharrjButton1);

        AssociadosjPanel.add(BarradeTarefasjToolBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 300, 830, 80));

        codigojTextField.addFocusListener(new java.awt.event.FocusAdapter() {
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
        AssociadosjPanel.add(codigojTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 120, -1));

        NomedoAssociadojLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        NomedoAssociadojLabel1.setText("Descrição Prodtudo");
        AssociadosjPanel.add(NomedoAssociadojLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, -1, -1));

        ProdutosjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "null", "null"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ProdutosjTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ProdutosjTableMouseClicked(evt);
            }
        });
        ProdutosjTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ProdutosjTableKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(ProdutosjTable);
        if (ProdutosjTable.getColumnModel().getColumnCount() > 0) {
            ProdutosjTable.getColumnModel().getColumn(0).setResizable(false);
            ProdutosjTable.getColumnModel().getColumn(1).setResizable(false);
            ProdutosjTable.getColumnModel().getColumn(2).setResizable(false);
            ProdutosjTable.getColumnModel().getColumn(3).setResizable(false);
            ProdutosjTable.getColumnModel().getColumn(4).setResizable(false);
            ProdutosjTable.getColumnModel().getColumn(5).setResizable(false);
        }

        AssociadosjPanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 1000, 210));

        getContentPane().add(AssociadosjPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1030, 400));

        jMenu1.setText("Operações");

        jMenuItem3.setText("Enviar Remoto");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem5.setText("Adicionar Código Barras");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuItem8.setText("Consultar Código Barras");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem8);

        jMenuItem10.setText("Alterar Código Novo");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem10);

        jMenuItem12.setText("Calcular Estoque Mínimo");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem12);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Fornecedor");

        jMenuItem2.setText("Vinculo");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        jMenu6.setText("Relatórios");

        jMenuItem7.setText("Tabela de Preço");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem7);

        jMenuItem11.setText("Giro de Produtos");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem11);

        jMenuBar1.add(jMenu6);

        alterarEstoquejMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        alterarEstoquejMenuItem.setText("Alterar Estoque");
        alterarEstoquejMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alterarEstoquejMenuItemActionPerformed(evt);
            }
        });
        jMenu4.add(alterarEstoquejMenuItem);

        jMenuItem6.setText("jMenuItem6");
        jMenu4.add(jMenuItem6);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AdicionarAssociado(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdicionarAssociado
        new FrmCadastrarProduto(this.produto, this, this.config, this.entrada, true);
    }//GEN-LAST:event_AdicionarAssociado

    private void PesquisarAssociado(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PesquisarAssociado
    }//GEN-LAST:event_PesquisarAssociado

    private void EditarCadastroAssociado(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarCadastroAssociado
        this.linhaTabela = ProdutosjTable.getSelectedRow();
        if (linhaTabela >= 0) {
            ProdutoController produtoController = new ProdutoController();
            Produto produto = produtoController.consultarProdutoid(listaProduto.get(linhaTabela).getIdProduto());
            new FrmCadastrarProduto(produto, this, this.config, this.entrada, false);
        }

    }//GEN-LAST:event_EditarCadastroAssociado

    private void FecharAssociado(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FecharAssociado
        int linha = ProdutosjTable.getSelectedRow();
        if (linha >=0) {
            ProdutoController produtoController = new ProdutoController();
            Produto produto = new Produto();
            produto = produtoController.consultarProdutoid(listaProduto.get(linha).getIdProduto());
            new FrmFotoProduto(produto);
        }
    }//GEN-LAST:event_FecharAssociado

    private void descricaojTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descricaojTextFieldKeyReleased
        EstoqueController estoqueController = new EstoqueController();
            this.listaProduto.removeAll(listaProduto);
            if (!descricaojTextField.getText().equalsIgnoreCase("")) {
                this.listaProduto = estoqueController.listarEstoqueDescricao(descricaojTextField.getText(), config.getEmpresa().getIdempresa());
            } else {
                this.listaProduto = estoqueController.consultarEstoqueGeral(config.getEmpresa().getIdempresa());
            }
            setModelProduto(null, null);
    }//GEN-LAST:event_descricaojTextFieldKeyReleased

    private void ImprimirjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImprimirjButtonActionPerformed
        listaProduto.get(1).setValorVenda(0.0f);
        ProdutosjTable.repaint();
    }//GEN-LAST:event_ImprimirjButtonActionPerformed

    private void RelatoriojButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatoriojButtonActionPerformed
            
        
    }//GEN-LAST:event_RelatoriojButtonActionPerformed

    private void VisualizarjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VisualizarjButtonActionPerformed
        
    }//GEN-LAST:event_VisualizarjButtonActionPerformed

    private void ExcluirjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExcluirjButtonActionPerformed
        int linha = ProdutosjTable.getSelectedRow();
        if (linha>=0){
            ProdutoFacade produtoFacade = new ProdutoFacade();
            try {
                produtoFacade.excluir(this.listaProduto.get(linha).getIdProduto());
            } catch (Exception ex) {
                Logger.getLogger(FrmConsultaProdutos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_ExcluirjButtonActionPerformed

    private void codigojTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codigojTextFieldKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            EstoqueController estoqueController = new EstoqueController();
            this.listaProduto.removeAll(listaProduto);
            if (!codigojTextField.getText().equalsIgnoreCase("")) {
               int ref = Integer.parseInt(codigojTextField.getText());
               this.listaProduto = estoqueController.listarEstoqueReferencia(ref, config.getEmpresa().getIdempresa());
            } else {
                this.listaProduto = estoqueController.consultarEstoqueGeral(config.getEmpresa().getIdempresa());
            }
            setModelProduto(null, null);
        }else {
             if (evt.getKeyCode() == evt.VK_F1) {
                 verificarProduto();
             }else {
                 if (evt.getKeyCode() == evt.VK_F6) {
                    verificarCodigoCEST();
                 }
             }
        }
    }//GEN-LAST:event_codigojTextFieldKeyPressed

    private void descricaojTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descricaojTextFieldKeyPressed
        if ((evt.getKeyCode() == evt.VK_UP) || (evt.getKeyCode() == evt.VK_DOWN)) {
            ProdutosjTable.requestFocus();
        } else if (evt.getKeyCode() == evt.VK_ENTER) {
            EstoqueController estoqueController = new EstoqueController();
            this.listaProduto.removeAll(listaProduto);
            if (!descricaojTextField.getText().equalsIgnoreCase("")) {
                this.listaProduto = estoqueController.listarEstoqueDescricao(descricaojTextField.getText(), config.getEmpresa().getIdempresa());
            } else {
                this.listaProduto = estoqueController.consultarEstoqueGeral(config.getEmpresa().getIdempresa());
            }
            setModelProduto(null, null);
        }
    }//GEN-LAST:event_descricaojTextFieldKeyPressed

    private void codigojTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codigojTextFieldKeyReleased
        if ((evt.getKeyCode() == evt.VK_UP) || (evt.getKeyCode() == evt.VK_DOWN)){
            ProdutosjTable.requestFocus();
        }

    }//GEN-LAST:event_codigojTextFieldKeyReleased

private void codigojTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_codigojTextFieldFocusGained

}//GEN-LAST:event_codigojTextFieldFocusGained

private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
    int linha = ProdutosjTable.getSelectedRow();
    if (linha>=0){
        ProdutoController produtoController = new ProdutoController();
        Produto produto = produtoController.consultarProdutoid(listaProduto.get(linha).getIdProduto());
        new FrmListaFornecedor(produto, config);
    }else {
        JOptionPane.showMessageDialog(rootPane,  "Selecione um Produto na Lista");
    }
    
}//GEN-LAST:event_jMenuItem2ActionPerformed

    private void ProdutosjTableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ProdutosjTableKeyPressed
            if (evt.getKeyCode() == evt.VK_ENTER) {
            int linha = ProdutosjTable.getSelectedRow();
            if (linha >= 0) {
                ProdutoController produtoController = new ProdutoController();
                Produto produto = produtoController.consultarProdutoid(listaProduto.get(linha).getIdProduto());
                if (telaConsulta != null) {
                    if (!nfe){
                        this.telaConsulta.setData(produto);
                        this.dispose();
                    }else {
                        this.telaConsulta.setProdutoXML(produto);
                        this.dispose();
                    }
                } else if (telaDevolucao !=null){
                    this.telaDevolucao.setProduto(produto.getIdProduto());
                    this.dispose();
                }else if (this.telaVenda!=null){
                    this.telaVenda.gerarRelatorioProduto(produto);
                    this.dispose();
                }else {
                    jMenuItem5ActionPerformed(null);
                }
                
            }
        }
    }//GEN-LAST:event_ProdutosjTableKeyPressed

    private void ProdutosjTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProdutosjTableMouseClicked
            if (evt.getClickCount() == 1) {
            EditarjButton.setEnabled(true);
            ExcluirjButton.setEnabled(true);
            ValorVendajButton.setEnabled(true);
            linhaTabela = ProdutosjTable.getSelectedRow();
        } else if (evt.getClickCount() == 2) {
            int linha = ProdutosjTable.getSelectedRow();
            if (linha >= 0) {
                ProdutoController produtoController = new ProdutoController();
                Produto produto = produtoController.consultarProdutoid(listaProduto.get(linha).getIdProduto());
                if (telaDevolucao != null) {
                    this.telaDevolucao.setProduto(produto.getIdProduto());
                } else if (this.telaConsulta != null) {
                    if (entrada){
                        this.telaConsulta.setData(produto);
                    }else {
                        if (nfe){
                            telaConsulta.setProdutoXML(produto);
                        }
                    }
                }else if (this.telaVenda!=null){
                    this.telaVenda.gerarRelatorioProduto(produto);
                }
                this.dispose();
            }
        }
    }//GEN-LAST:event_ProdutosjTableMouseClicked

    private void AssociadosjPanelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AssociadosjPanelKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_AssociadosjPanelKeyPressed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        int linha = ProdutosjTable.getSelectedRow();
        if (linha>=0){
            ProdutoController produtoController = new ProdutoController();
            Produto prodExterno = produtoController.consultarProdutoid(listaProduto.get(linha).getIdProduto());
            prodExterno.setSincronizado(0);
            produtoController.salvarProduto(prodExterno);
            ProdutoRemotoBean produtoRemotoBean = new ProdutoRemotoBean(this.config);
            produtoRemotoBean.IniciarExportacaoProduto();
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void alterarEstoquejMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alterarEstoquejMenuItemActionPerformed
        int linha = ProdutosjTable.getSelectedRow();
        if (linha>=0){
            double quantidade = Double.parseDouble(JOptionPane.showInputDialog(rootPane, "Quantidade para Alterar"));
            EstoqueController estoqueController = new EstoqueController();
            Estoque estoque = estoqueController.consultarEstoque(listaProduto.get(linha).getIdProduto(), config.getEmpresa().getIdempresa());
            if (estoque!=null){
                estoque.setQuantidadeEstoque(quantidade);
                estoqueController.salvarEstoque(estoque);
                caregarConsultaProduto(0);
            }
        }
    }//GEN-LAST:event_alterarEstoquejMenuItemActionPerformed

    private void FecharrjButton1FecharAssociado(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FecharrjButton1FecharAssociado
        this.dispose();
    }//GEN-LAST:event_FecharrjButton1FecharAssociado

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        int linha = ProdutosjTable.getSelectedRow();
        if (linha >=0){
            String barras = JOptionPane.showInputDialog("Digite Codigo  e Pressione ENTER");
            if (!barras.equalsIgnoreCase("")){
                CodigoBarrasController codigoBarrasController = new CodigoBarrasController();
                CodigoBarras codigoBarras = codigoBarrasController.pesquisarCodigo(barras);
                if (codigoBarras!=null){
                    Produto produto = new Produto();
                    ProdutoController produtoController = new ProdutoController();
                    produto = produtoController.consultarProdutoid(codigoBarras.getProduto());
                    JOptionPane.showMessageDialog(rootPane, "Codigo ja cadastrado\n" + produto.getReferencia() + 
                            "  - " + produto.getDescricao());
                }else{
                    codigoBarras = new CodigoBarras();
                    codigoBarras.setBarras(barras);
                    codigoBarras.setProduto(listaProduto.get(linha).getIdProduto());
                    codigoBarras = codigoBarrasController.salvar(codigoBarras);
                }   
            }
        }
        
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        String url = ("telas/Produtos/reportTabelaPreco.jasper");
        Map parameters = new HashMap();
        try {
            parameters.put("nomeFantasia", this.config.getEmpresa().getNomeFantasia());
            parameters.put("RazaoSocial", this.config.getEmpresa().getRazaoSocial());
            parameters.put("idempresa", this.config.getEmpresa().getIdempresa());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Não foi possível gerar o relatório " + ex);
            ex.printStackTrace();
        }
        new relatoriosJasper(url, parameters);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        int linha = ProdutosjTable.getSelectedRow();
        if (linha >= 0) {
            ProdutoController produtoController = new ProdutoController();
            Produto prod = produtoController.consultarProdutoid(listaProduto.get(linha).getIdProduto());
            if (prod != null) {
                new FrmConsultaCodigoBarras(prod);
            }
        }
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        if (linhaTabela >= 0) {
            int codigoNovo = Integer.parseInt(JOptionPane.showInputDialog("Informe novo Código Novo"));
            if (codigoNovo > 0) {
                ProdutoController produtoController = new ProdutoController();
                Produto produto = produtoController.consultarProdutoid(listaProduto.get(linhaTabela).getIdProduto());
                if (produto!=null){
                    produto.setCodigoNovo(codigoNovo);
                    produtoController.salvarProduto(produto);
                    caregarConsultaProduto(0);
                }
            }
        }
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        int linha = ProdutosjTable.getSelectedRow();
        if (linha>=0){
            calcularGiroProduto(linha);
        }else JOptionPane.showMessageDialog(rootPane, "Selecione um Produto");
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        calcularEstoqueMinimo();
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void ValorVendajButtonEditarCadastroAssociado(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ValorVendajButtonEditarCadastroAssociado
        this.linhaTabela = ProdutosjTable.getSelectedRow();
        if (linhaTabela >= 0) {
            EstoqueController estoqueController = new EstoqueController();
            Estoque estoque = estoqueController.consultarEstoque(listaProduto.get(linhaTabela).getIdProduto(), config.getEmpresa().getIdempresa());
            if (estoque!=null){
                new FrmAlterarPreco(listaProduto.get(linhaTabela).getDescricao(), listaProduto.get(linhaTabela).getReferencia(), 
                        Formatacao.foramtarFloatString(listaProduto.get(linhaTabela).getValorVenda()), estoque, this);
            }else JOptionPane.showMessageDialog(rootPane, "Estoque não localizado");
        }
    }//GEN-LAST:event_ValorVendajButtonEditarCadastroAssociado
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
    private javax.swing.JButton FecharrjButton1;
    private javax.swing.JButton ImprimirjButton;
    private javax.swing.JLabel NomedoAssociadojLabel;
    private javax.swing.JLabel NomedoAssociadojLabel1;
    private javax.swing.JButton PesquisarjButton;
    private javax.swing.JTable ProdutosjTable;
    private javax.swing.JButton RelatoriojButton;
    private javax.swing.JToolBar.Separator SeparadordeTarefasjSeparator;
    private javax.swing.JButton ValorVendajButton;
    private javax.swing.JButton VisualizarjButton;
    private javax.swing.JMenuItem alterarEstoquejMenuItem;
    private javax.swing.JTextField codigojTextField;
    private javax.swing.JTextField descricaojTextField;
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
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
    

   public void setModel(List listamodel) {
       
    }

    public void setData(Object objeto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setBanco(Banco banco) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

   

    public void setModelProduto(Produto produto, Estoque estoque){
        verificarEstoque();
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.RIGHT);      
        model = new ConsultaProdutoTableModel(listaProduto);
        ProdutosjTable.setModel(model);
        
        ProdutosjTable.getColumnModel().getColumn(0).setPreferredWidth(20);
        ProdutosjTable.getColumnModel().getColumn(1).setPreferredWidth(40);
        ProdutosjTable.getColumnModel().getColumn(2).setPreferredWidth(330);
        ProdutosjTable.getColumnModel().getColumn(3).setPreferredWidth(10);
        ProdutosjTable.getColumnModel().getColumn(4).setCellRenderer(renderer);
        ProdutosjTable.getColumnModel().getColumn(4).setPreferredWidth(10);
        ProdutosjTable.getColumnModel().getColumn(5).setCellRenderer(renderer);
        ProdutosjTable.getColumnModel().getColumn(5).setPreferredWidth(10);
        ProdutosjTable.getColumnModel().getColumn(6).setCellRenderer(renderer);
        ProdutosjTable.getColumnModel().getColumn(6).setPreferredWidth(10);
        ProdutosjTable.getColumnModel().getColumn(7).setPreferredWidth(15);
        ProdutosjTable.getColumnModel().getColumn(8).setPreferredWidth(15);
        if (produto!=null){
            listaProduto.get(linhaTabela).setDescricao(produto.getDescricao());
        }
        if(estoque!=null){
            listaProduto.get(linhaTabela).setValorVenda(estoque.getValorVenda());
        }
        ProdutosjTable.repaint();
        if (this.entrada){
            if (produto!=null){
                this.telaConsulta.setData(produto);
                this.dispose();
            }
        }
    }
    
    public void verificarEstoque(){
        for (int i=0;i<listaProduto.size();i++){
            if (listaProduto.get(i).getQuantidadeEstoque()==null){
                Viewconsultaprodutoestoque pro = listaProduto.get(i);
                System.out.println("sem Estoque " + listaProduto.get(i).getReferencia());
                System.out.println(listaProduto.get(i).getIdEstoque());
                EstoqueController estoqueController = new EstoqueController();
                Estoque estoque = estoqueController.consultarEstoque(listaProduto.get(i).getIdProduto(), 2);
                if (estoque!=null){
                    estoque.setQuantidadeEstoque(0.0);
                    estoque.setQuantidadeMinima(0.0);
                    estoqueController.salvarEstoque(estoque);
                }
            }
        }
    }

    public void setNFe() {
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
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public boolean salvarProdutoRemotoExterno(Produto produto){
        ProdutoRemotoFacade produtoRemotoFacade = new ProdutoRemotoFacade();
        try {
            produtoRemotoFacade.salvarProduto(produto);
            return true;
        } catch (Exception ex) {
            Logger.getLogger(FrmCadastrarProduto.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public void setProdutoXML(Produto produto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public void carregarImportacao(){
        if (config.getEmpresa().getImportacao()==1){
            ProdutoRemotoBean produtoRemotoBean = new ProdutoRemotoBean(this.config);
            produtoRemotoBean.ImportarProduto();
        }
    }
    
    public void calcularGiroProduto(int linha){
        Date dataCompra = listaProduto.get(linha).getDataCompra();
        Date dataVenda = listaProduto.get(linha).getDataVenda();
        int dias = Formatacao.subtrairDatas(dataVenda, dataCompra);
        VendaDao vendaDao = new VendaDao();
        double quantidade = 0.0;
        try {
            quantidade = vendaDao.quantidadeVendida(listaProduto.get(linha).getIdProduto(),
                    Formatacao.ConvercaoDataSql(dataCompra), Formatacao.ConvercaoDataSql(dataVenda));
        } catch (SQLException ex) {
            Logger.getLogger(FrmConsultaProdutos.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(rootPane,"Erro Cosultar Quantidade Vendida "  + ex);
        }
        double media = 0.0;
        if ((quantidade>0) && (dias>0)){
            media = quantidade / dias;
        }
        String texto = "Nº Dias     : " + String.valueOf(dias) + "\b\n";
        texto = texto + "Quantidade : " + Formatacao.foramtarDoubleString(quantidade) + "\b\n";
        texto = texto + "Média      : " + Formatacao.foramtarDoubleString(media);
        JOptionPane.showMessageDialog(rootPane, texto);
    }
    
    public void calcularEstoqueMinimo(){
        Date dataAtual = new Date();
        Date dataInicial = Formatacao.SomarDiasData(dataAtual, -30);
        int dias = Formatacao.subtrairDatas(dataAtual, dataInicial);
        double quantidade = 0.0;
        VendaDao vendaDao = new VendaDao();
        for (int i=0;i<listaProduto.size();i++){
            try {
                quantidade = vendaDao.quantidadeVendida(listaProduto.get(i).getIdProduto(),
                        Formatacao.ConvercaoDataSql(dataInicial), Formatacao.ConvercaoDataSql(dataAtual));
            } catch (SQLException ex) {
                Logger.getLogger(FrmConsultaProdutos.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(rootPane, "Erro Cosultar Quantidade Vendida " + ex);
            }
            Double media = 0.0;
            if ((quantidade > 0) && (dias > 0)) {
                media = quantidade / dias;
                media = media * 15;
                Integer exato = media.intValue();
                Integer valor = exato + 1;
                media = valor.doubleValue();
            }else {
                media=0.0;
            }
            
            EstoqueController estoqueController = new EstoqueController();
            Estoque estoque = estoqueController.consultarEstoque(listaProduto.get(i).getIdProduto(), config.getEmpresa().getIdempresa());
            if (estoque!=null){
                estoque.setQuantidadeMinima(media);
                estoqueController.salvarEstoque(estoque);
            }
        }
        JOptionPane.showMessageDialog(rootPane, "Estoque Mínimo Calculado");
        
    }

    public void setArquivo(File arquivo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void verificarProduto(){
        ProdutoController produtoController = new ProdutoController();
        List<Produto> listaProdutos = produtoController.consultarProduto();
        EstoqueController estoqueController = new EstoqueController();
        boolean salvar=false;
        if (listaProdutos!=null){
            for(int i=0;i<listaProdutos.size();i++){
                salvar=false;
                List<Produto> listaReferencia = produtoController.listarReferencia(listaProdutos.get(i).getReferencia());
                List<Estoque> listaEstoque = estoqueController.consultaEstoqueProduto(listaProdutos.get(i).getIdProduto(), config.getEmpresa().getIdempresa());
                if (listaReferencia!=null){
                    if (listaReferencia.size()>1){
                        salvar=true;
                        listaProdutos.get(i).setProduto("S");
                    }
                }
                if (listaEstoque!=null){
                    if (listaEstoque.size()>1){
                        salvar=true;
                        listaProdutos.get(i).setEstoque("S");
                    }
                }
                if(salvar){
                    produtoController.salvarProduto(listaProdutos.get(i));
                }
            }
        }
        JOptionPane.showMessageDialog(rootPane, "Terminou");
    }
    
    public void verificarCodigoCEST(){
        ProdutoController produtoController = new ProdutoController();
        List<Produto> listaProdutos = produtoController.consultarProduto();
        CestController cestController = new CestController();
        for(int i=0;i<listaProdutos.size();i++){
            if (listaProdutos.get(i).getCest().equalsIgnoreCase("0")){
                if ((listaProdutos.get(i).getNcm()!=null) && (listaProdutos.get(i).getNcm().length()>0)){
                    Cest cest = cestController.cunsultarCest(listaProdutos.get(i).getNcm());
                    if (cest!=null){
                        listaProdutos.get(i).setCest(cest.getCest());
                        produtoController.salvarProduto(listaProdutos.get(i));
                    }
                }
            }
        }
        JOptionPane.showMessageDialog(rootPane, "Terminou");
    }
}

