/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FrmConsultaEntrada.java
 *
 * Created on 06/05/2011, 12:39:36
 */

package telas.Entrada;

import Interfaces.ItelaConsulta;
import Regras.*;
import beanController.NfDuplicatas;
import beanController.NfProdutos;
import beanController.NotaEletronica;
import com.toedter.calendar.JTextFieldDateEditor;
import controler.Config;
import controler.relatoriosJasper;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.net.URL;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import model.*;
import telas.Entrada.nova.FrmDocEntrada;
import telas.Fornecedor.FrmConsultaFornecedor;
import telas.NotaSaida.INotaSaidaBean;

/**
 *
 * @author Wolverine
 */
public class FrmConsultaEntrada extends javax.swing.JFrame implements ItelaConsulta{

    
    private String datePattern;
    private String maskPattern;
    private char placeHolder;
    private List<Docentrada> listaEntrada;
    private List<Entradaproduto> listaProduto;
    private ConsultaEntradaTableModel modelEntrada;
    private ConsultaEntradaProdutoTableModel modelProduto;
    private Config config;
    private List<Entradaproduto> listaEntradaProduto;
    private Fornecedor fornecedor;
    private INotaSaidaBean telaNotaSaida;
    

    /** Creates new form FrmConsultaEntrada */
    public FrmConsultaEntrada(Config config) {
        this.config = config;
        datePattern = "dd/MM/yyyy";
        maskPattern = "##/##/##";
        placeHolder = '_';
        initComponents();
        URL url = this.getClass().getResource("/imagens/logo_mini.png");
        Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(imagemTitulo);
        this.setLocationRelativeTo(null);
        dataInicialjDateChooser.setDate(Formatacao.SomarDiasData(new Date(), -30));
        dataFinaljDateChooser.setDate(new Date());
        setData(null);
        if (!(listaEntrada==null)){
            setModelProduto(null, null);
        }
        setVisible(true);
    }
    public FrmConsultaEntrada(Config config, INotaSaidaBean telaNotaSaida) {
        this.config = config;
        datePattern = "dd/MM/yyyy";
        maskPattern = "##/##/##";
        placeHolder = '_';
        this.telaNotaSaida = telaNotaSaida;
        initComponents();
        URL url = this.getClass().getResource("/imagens/logo_mini.png");
        Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(imagemTitulo);
        this.setLocationRelativeTo(null);
        dataInicialjDateChooser.setDate(Formatacao.SomarDiasData(new Date(), -30));
        dataFinaljDateChooser.setDate(new Date());
        setData(null);
        if (!(listaEntrada==null)){
            setModelProduto(null, null);
        }
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

        BarradeTarefasjToolBar = new javax.swing.JToolBar();
        AdicionarjButton1 = new javax.swing.JButton();
        EditarjButton1 = new javax.swing.JButton();
        ExcluirjButton = new javax.swing.JButton();
        SeparadordeTarefasjSeparator = new javax.swing.JToolBar.Separator();
        RelatoriojButton = new javax.swing.JButton();
        ImprimirjButton = new javax.swing.JButton();
        FecharrjButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ProdutojTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        EntradajTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        razaosocialjTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        dataInicialjDateChooser = new com.toedter.calendar.JDateChooser(null, null, datePattern, new JTextFieldDateEditor(datePattern,
            maskPattern, placeHolder));
    dataFinaljDateChooser = new com.toedter.calendar.JDateChooser(null, null, datePattern, new JTextFieldDateEditor(datePattern,
        maskPattern, placeHolder));
jLabel3 = new javax.swing.JLabel();
jButton1 = new javax.swing.JButton();
buscaBancojButton1 = new javax.swing.JButton();
jButton2 = new javax.swing.JButton();

setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
setTitle("Consulta  de Compras");
getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

BarradeTarefasjToolBar.setFloatable(false);
BarradeTarefasjToolBar.setRollover(true);

AdicionarjButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/novo.png"))); // NOI18N
AdicionarjButton1.setText("Adicionar");
AdicionarjButton1.setToolTipText("Adicionar Associado");
AdicionarjButton1.setFocusable(false);
AdicionarjButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
AdicionarjButton1.setMaximumSize(new java.awt.Dimension(80, 90));
AdicionarjButton1.setMinimumSize(new java.awt.Dimension(80, 90));
AdicionarjButton1.setName(""); // NOI18N
AdicionarjButton1.setPreferredSize(new java.awt.Dimension(80, 90));
AdicionarjButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
AdicionarjButton1.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        AdicionarjButton1AdicionarAssociado(evt);
    }
    });
    BarradeTarefasjToolBar.add(AdicionarjButton1);

    EditarjButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/alterar.png"))); // NOI18N
    EditarjButton1.setText("Editar");
    EditarjButton1.setToolTipText("Editar Associado");
    EditarjButton1.setFocusable(false);
    EditarjButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    EditarjButton1.setMaximumSize(new java.awt.Dimension(80, 90));
    EditarjButton1.setMinimumSize(new java.awt.Dimension(80, 90));
    EditarjButton1.setPreferredSize(new java.awt.Dimension(80, 90));
    EditarjButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    EditarjButton1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            EditarjButton1EditarCadastroAssociado(evt);
        }
    });
    BarradeTarefasjToolBar.add(EditarjButton1);

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
            FecharrjButtonFecharAssociado(evt);
        }
    });
    BarradeTarefasjToolBar.add(FecharrjButton);

    getContentPane().add(BarradeTarefasjToolBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 360, 510, 80));

    ProdutojTable.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {
            {null, null, null, null, null},
            {null, null, null, null, null},
            {null, null, null, null, null},
            {null, null, null, null, null}
        },
        new String [] {
            "Código", "Descrição", "Unidade", "Quantidade", "Valor Custo"
        }
    ) {
        boolean[] canEdit = new boolean [] {
            false, false, false, false, false
        };

        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit [columnIndex];
        }
    });
    jScrollPane1.setViewportView(ProdutojTable);
    if (ProdutojTable.getColumnModel().getColumnCount() > 0) {
        ProdutojTable.getColumnModel().getColumn(0).setResizable(false);
        ProdutojTable.getColumnModel().getColumn(0).setPreferredWidth(10);
        ProdutojTable.getColumnModel().getColumn(1).setResizable(false);
        ProdutojTable.getColumnModel().getColumn(1).setPreferredWidth(140);
        ProdutojTable.getColumnModel().getColumn(2).setResizable(false);
        ProdutojTable.getColumnModel().getColumn(2).setPreferredWidth(10);
        ProdutojTable.getColumnModel().getColumn(3).setResizable(false);
        ProdutojTable.getColumnModel().getColumn(3).setPreferredWidth(10);
        ProdutojTable.getColumnModel().getColumn(4).setResizable(false);
        ProdutojTable.getColumnModel().getColumn(4).setPreferredWidth(10);
    }

    getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 70, 590, 270));

    EntradajTable.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null}
        },
        new String [] {
            "Fornecedor", "Nº Nota Fiscal", "Data Registro", "Valor R$"
        }
    ) {
        boolean[] canEdit = new boolean [] {
            false, false, false, false
        };

        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit [columnIndex];
        }
    });
    EntradajTable.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            EntradajTableMouseClicked(evt);
        }
    });
    EntradajTable.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyPressed(java.awt.event.KeyEvent evt) {
            EntradajTableKeyPressed(evt);
        }
        public void keyReleased(java.awt.event.KeyEvent evt) {
            EntradajTableKeyReleased(evt);
        }
    });
    jScrollPane2.setViewportView(EntradajTable);
    if (EntradajTable.getColumnModel().getColumnCount() > 0) {
        EntradajTable.getColumnModel().getColumn(0).setResizable(false);
        EntradajTable.getColumnModel().getColumn(0).setPreferredWidth(10);
        EntradajTable.getColumnModel().getColumn(1).setResizable(false);
        EntradajTable.getColumnModel().getColumn(1).setPreferredWidth(140);
        EntradajTable.getColumnModel().getColumn(2).setResizable(false);
        EntradajTable.getColumnModel().getColumn(2).setPreferredWidth(10);
        EntradajTable.getColumnModel().getColumn(3).setPreferredWidth(10);
    }

    getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 470, 270));

    jLabel1.setText("Razão Social Fornecedor");
    getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

    razaosocialjTextField.setEditable(false);
    getContentPane().add(razaosocialjTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 280, -1));

    jLabel2.setText("Data Inicial");
    getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 10, -1, -1));

    dataInicialjDateChooser.addFocusListener(new java.awt.event.FocusAdapter() {
        public void focusGained(java.awt.event.FocusEvent evt) {
            dataInicialjDateChooserFocusGained(evt);
        }
    });
    getContentPane().add(dataInicialjDateChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 30, 100, -1));

    dataFinaljDateChooser.addFocusListener(new java.awt.event.FocusAdapter() {
        public void focusGained(java.awt.event.FocusEvent evt) {
            dataFinaljDateChooserFocusGained(evt);
        }
    });
    getContentPane().add(dataFinaljDateChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 30, 100, -1));

    jLabel3.setText("Data Final");
    getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 10, -1, -1));

    jButton1.setText("Pesquisar");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton1ActionPerformed(evt);
        }
    });
    getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 30, -1, -1));

    buscaBancojButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/magnifier.png"))); // NOI18N
    buscaBancojButton1.setToolTipText("Pesquisa Fornecedor");
    buscaBancojButton1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            buscaBancojButton1ActionPerformed(evt);
        }
    });
    getContentPane().add(buscaBancojButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 30, 20, 20));

    jButton2.setText("Remover Fornecedor");
    jButton2.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton2ActionPerformed(evt);
        }
    });
    getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 30, -1, -1));

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ExcluirjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExcluirjButtonActionPerformed
        int linha = EntradajTable.getSelectedRow();
        if (linha >= 0) {
            listaProduto = this.listaEntradaProduto;
            if (listaEntradaProduto.size() == 0) {
                EntradaProdutoController entradaProdutoController = new EntradaProdutoController();
                entradaProdutoController.excluirEntradaNF(localizarNotaFiscal(listaEntrada.get(linha).getIdDocEntrada()));
                entradaProdutoController.exluirDocEntrada(this.listaEntrada.get(linha));
                setData(null);
                setModelProduto(null, null);
            }else JOptionPane.showMessageDialog(rootPane, "Entrada possui produtos");
        }
        
//        for (int i = 0; i < listaEntrada.size(); i++) {
//            EntradaProdutoController entradaController = new EntradaProdutoController();
//            this.listaEntradaProduto = entradaController.listarProdutoEntrada(this.listaEntrada.get(i));
//            if (listaEntradaProduto != null) {
//                for (int n = 0; n < listaEntradaProduto.size(); n++) {
//                    VinculoController vinculoController = new VinculoController();
//                    Vinculo vinculo = vinculoController.consultarVinculo(listaEntradaProduto.get(n).getProduto(),
//                            this.config.getEmpresa().getIdempresa(), listaEntrada.get(i).getFornecedor());
//                    if (vinculo == null) {
//                        int prod = listaEntradaProduto.get(n).getProduto();
//                        int forn = listaEntrada.get(i).getFornecedor();
//                        vinculo = new Vinculo();
//                        vinculo.setEmbalagem(0L);
//                    }
//                    vinculo.setDataCompra(listaEntrada.get(i).getDataEntrada());
//                    vinculo.setEmbalagem((long) 0);
//                    vinculo.setFornecedor(listaEntrada.get(i).getFornecedor());
//                    vinculo.setProduto(listaEntradaProduto.get(n).getProduto());
//                    vinculo.setValorCompra(listaEntradaProduto.get(n).getValorCusto());
//                    vinculo.setEmpresa(config.getEmpresa().getIdempresa());
//                    vinculoController.salvarVinculo(vinculo);
//                }
//            }
//        }
//        JOptionPane.showMessageDialog(rootPane, "Terminou");
}//GEN-LAST:event_ExcluirjButtonActionPerformed

    private void ImprimirjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImprimirjButtonActionPerformed
        int linha = EntradajTable.getSelectedRow();
        if (linha >= 0) {
            String url = ("telas/Entrada/reportEntradaSituacao.jasper");
            Map parameters = new HashMap();
            try {
                parameters.put("idDocEntrada", this.listaEntrada.get(linha).getIdDocEntrada());
                parameters.put("idEmpresa", this.config.getEmpresa().getIdempresa());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Não foi possível gerar o relatório " + ex);
                ex.printStackTrace();
            }
            new relatoriosJasper(url, parameters);
        }
}//GEN-LAST:event_ImprimirjButtonActionPerformed

    private void RelatoriojButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatoriojButtonActionPerformed
        //gerarVicnulos();
    }//GEN-LAST:event_RelatoriojButtonActionPerformed

    private void FecharrjButtonFecharAssociado(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FecharrjButtonFecharAssociado
        this.dispose();
}//GEN-LAST:event_FecharrjButtonFecharAssociado

    private void EntradajTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EntradajTableMouseClicked
        if (evt.getClickCount()==1){
            setModelProduto(null, null);
            ExcluirjButton.setEnabled(true);
        }
        if (evt.getClickCount()==2){
            if (telaNotaSaida!=null){
                int linha = EntradajTable.getSelectedRow();
                if (linha>=0){
                    telaNotaSaida.setDocEntrada(listaEntrada.get(linha));
                    this.dispose();
                }
            }
        }
    }//GEN-LAST:event_EntradajTableMouseClicked

    private void EntradajTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_EntradajTableKeyReleased
        if ((evt.getKeyCode() == evt.VK_DOWN) || (evt.getKeyCode() == evt.VK_UP)) {
            setModelProduto(null, null);
            ExcluirjButton.setEnabled(true);

        }
    }//GEN-LAST:event_EntradajTableKeyReleased

    private void EntradajTableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_EntradajTableKeyPressed
       
    }//GEN-LAST:event_EntradajTableKeyPressed

    private void dataInicialjDateChooserFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dataInicialjDateChooserFocusGained

   }//GEN-LAST:event_dataInicialjDateChooserFocusGained

    private void dataFinaljDateChooserFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dataFinaljDateChooserFocusGained

   }//GEN-LAST:event_dataFinaljDateChooserFocusGained

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        EntradaProdutoController entradaProdutoController = new EntradaProdutoController();
        String iData = Formatacao.ConvercaoDataSql(dataInicialjDateChooser.getDate());
        String fData = Formatacao.ConvercaoDataSql(dataFinaljDateChooser.getDate());
        if (this.fornecedor==null){
            listaEntrada = entradaProdutoController.pesquisarEntradaPeriodo(iData, fData, this.config.getEmpresa().getIdempresa());
        }else {
            listaEntrada = entradaProdutoController.pesquisarEntradaPeriodoFornecedor(iData, fData, this.fornecedor.getIdfornecedor(), this.config.getEmpresa().getIdempresa());
        }
        if (listaEntrada==null){
            JOptionPane.showMessageDialog(rootPane, "Sem dados para consultar");
        }
        setData(null);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void buscaBancojButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscaBancojButton1ActionPerformed
         new FrmConsultaFornecedor(this);
    }//GEN-LAST:event_buscaBancojButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.fornecedor = null;
        razaosocialjTextField.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void AdicionarjButton1AdicionarAssociado(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdicionarjButton1AdicionarAssociado
        new FrmDocEntrada(config, null);
    }//GEN-LAST:event_AdicionarjButton1AdicionarAssociado

    private void EditarjButton1EditarCadastroAssociado(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarjButton1EditarCadastroAssociado
        int linha = EntradajTable.getSelectedRow();
        if (linha>=0){
            new FrmDocEntrada(config, listaEntrada.get(linha));
        }
    }//GEN-LAST:event_EditarjButton1EditarCadastroAssociado

    /**
    * @param args the command line arguments
    */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AdicionarjButton1;
    private javax.swing.JToolBar BarradeTarefasjToolBar;
    private javax.swing.JButton EditarjButton1;
    private javax.swing.JTable EntradajTable;
    private javax.swing.JButton ExcluirjButton;
    private javax.swing.JButton FecharrjButton;
    private javax.swing.JButton ImprimirjButton;
    private javax.swing.JTable ProdutojTable;
    private javax.swing.JButton RelatoriojButton;
    private javax.swing.JToolBar.Separator SeparadordeTarefasjSeparator;
    private javax.swing.JButton buscaBancojButton1;
    private com.toedter.calendar.JDateChooser dataFinaljDateChooser;
    private com.toedter.calendar.JDateChooser dataInicialjDateChooser;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField razaosocialjTextField;
    // End of variables declaration//GEN-END:variables

    public void setModelProduto(Produto produto, Estoque estoque){
        int linha = EntradajTable.getSelectedRow();
        EntradaProdutoController entradaController = new EntradaProdutoController();
        if (linha >= 0) {
            this.listaEntradaProduto = entradaController.listarProdutoEntrada(this.listaEntrada.get(linha));
            if (this.listaEntradaProduto != null) {
                if (this.listaEntradaProduto.size() > 0) {
                    modelProduto = new ConsultaEntradaProdutoTableModel(listaEntradaProduto);
                } else {
                    modelProduto = new ConsultaEntradaProdutoTableModel(new ArrayList<Entradaproduto>());
                }
            }else {
                modelProduto = new ConsultaEntradaProdutoTableModel(new ArrayList<Entradaproduto>());
            }
        } else {
            modelProduto = new ConsultaEntradaProdutoTableModel(new ArrayList<Entradaproduto>());
        }
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.RIGHT);
        ProdutojTable.setModel(modelProduto);
        ProdutojTable.getColumnModel().getColumn(0).setPreferredWidth(10);
        ProdutojTable.getColumnModel().getColumn(1).setPreferredWidth(10);
        ProdutojTable.getColumnModel().getColumn(2).setPreferredWidth(130);
        ProdutojTable.getColumnModel().getColumn(3).setPreferredWidth(10);
        ProdutojTable.getColumnModel().getColumn(4).setCellRenderer(renderer);
        ProdutojTable.getColumnModel().getColumn(4).setPreferredWidth(10);
        ProdutojTable.getColumnModel().getColumn(5).setCellRenderer(renderer);
        ProdutojTable.getColumnModel().getColumn(5).setPreferredWidth(10);
        this.repaint();
    }

    public void setData(Object objeto) {
        if (this.listaEntrada==null){
            EntradaProdutoController entradaProdutoController = new EntradaProdutoController();
            this.listaEntrada = entradaProdutoController.listarDocEntrada(this.config.getEmpresa().getIdempresa());
        }
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.RIGHT);
        if (listaEntrada==null){
            modelEntrada = new ConsultaEntradaTableModel(new ArrayList<Docentrada>());
        }else modelEntrada = new ConsultaEntradaTableModel(listaEntrada);
        EntradajTable.setModel(modelEntrada);
        EntradajTable.getColumnModel().getColumn(0).setPreferredWidth(150);
        EntradajTable.getColumnModel().getColumn(1).setPreferredWidth(10);
        EntradajTable.getColumnModel().getColumn(2).setPreferredWidth(10);
        EntradajTable.getColumnModel().getColumn(3).setCellRenderer(renderer);
        EntradajTable.getColumnModel().getColumn(3).setPreferredWidth(10);
       this.repaint();
    }

    public void setBanco(Banco banco) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setNFe(List<NfProdutos> listaProdutos, List<NfDuplicatas> listaDuplicatas, NotaEletronica nota, Fornecedor fornecedor) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setAlterarValorVenda(Estoque estoque) {
        throw new UnsupportedOperationException("Not supported yet.");
    }


    
    public void setFornecedor(Object objeto) {
        this.fornecedor = (Fornecedor) objeto;
        razaosocialjTextField.setText(this.fornecedor.getRazaoSocial());
    }

    public void setForPedido(Object objeto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public Fornecedor localizarFornecedor(int idFornecedor){
        FornecedorController fornecedorController = new FornecedorController();
        return fornecedorController.consultarFornecedor(idFornecedor);
    }
    
    public Nfentrada localizarNotaFiscal(int idNfentrada){
        EntradaProdutoController entradaProdutoController = new EntradaProdutoController();
        return entradaProdutoController.consultarNotaFiscalEntrada(idNfentrada);
    }
    
    public Produto localizarProduto(int idProduto){
        ProdutoController produtoController = new ProdutoController();
        return produtoController.consultarProdutoid(idProduto);
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
    
    public void gerarVicnulos(){
        EntradaProdutoController entradaController = new EntradaProdutoController();
        VinculoController vinculoController = new VinculoController();
        for (int i = 0; i < listaEntrada.size(); i++) {
            listaEntradaProduto = entradaController.listarProdutoEntrada(this.listaEntrada.get(i));
            if (this.listaEntradaProduto != null) {
                for (int p = 0; p < listaEntradaProduto.size(); p++) {
                    Vinculo vinculo = vinculoController.consultarVinculo(listaEntradaProduto.get(p).getProduto(), config.getEmpresa().getIdempresa(), listaEntrada.get(i).getFornecedor());
                    if (vinculo == null) {
                        vinculo = new Vinculo();
                        vinculo.setCodigoFabricante("0");
                        vinculo.setDataCompra(listaEntrada.get(i).getDataEntrada());
                        vinculo.setEmbalagem(Long.valueOf("0"));
                        vinculo.setEmpresa(config.getEmpresa().getIdempresa());
                        vinculo.setFornecedor(listaEntrada.get(i).getFornecedor());
                        vinculo.setPedido("NAO");
                        vinculo.setProduto(listaEntradaProduto.get(p).getProduto());
                        vinculo.setValorCompra(listaEntradaProduto.get(p).getValorCusto());
                        vinculoController.salvarVinculo(vinculo);
                    }
                }
            }
        }
        JOptionPane.showMessageDialog(rootPane, "Terminou");
    }
}
