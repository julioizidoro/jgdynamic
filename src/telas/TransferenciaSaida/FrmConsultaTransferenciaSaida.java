/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FrmConsultaEntrada.java
 *
 * Created on 06/05/2011, 12:39:36
 */

package telas.TransferenciaSaida;

import Regras.Formatacao;
import Regras.TransferenciaSaidaController;
import controler.Config;
import controler.relatoriosJasper;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import model.Saidatransferencia;
import telas.RelatoriosGerenciais.FrmRelatorioData;
import telas.TransferenciaSaida.TransferenciaProdutoProcesso;

/**
 *
 * @author Wolverine
 */
public class FrmConsultaTransferenciaSaida extends javax.swing.JFrame{

   List<TransferenciaProcesso> listaTransfereciaProcessos;
   ConsultaTransferenciaSaidaTableModel modelTransferencia;
   ConsultaTransferenciaSaidaProdutoTableModel modelProduto;
   private Config config;
    

    /** Creates new form FrmConsultaEntrada */
    public FrmConsultaTransferenciaSaida(Config config) {
        this.config = config;
        initComponents();
        URL url = this.getClass().getResource("/imagens/logo_mini.png");
        Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(imagemTitulo);
        this.setLocationRelativeTo(null);
        listaTransfereciaProcessos = new ArrayList<TransferenciaProcesso>();
        setmodelTransferencia();
        if (listaTransfereciaProcessos!=null){
            setModelProduto();
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
        AdicionarjButton = new javax.swing.JButton();
        EditarjButton = new javax.swing.JButton();
        ExcluirjButton = new javax.swing.JButton();
        SeparadordeTarefasjSeparator = new javax.swing.JToolBar.Separator();
        RelatoriojButton = new javax.swing.JButton();
        ImprimirjButton = new javax.swing.JButton();
        FecharrjButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ProdutojTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        EntradajTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta de Transferencias");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
                AdicionarjButtonAdicionarAssociado(evt);
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
                EditarjButtonEditarCadastroAssociado(evt);
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

        getContentPane().add(BarradeTarefasjToolBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 300, 510, 80));

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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 10, 590, 270));

        EntradajTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Empresa", "Nº Transferencia", "Data Emissao", "Valor R$"
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
        EntradajTable.getColumnModel().getColumn(0).setResizable(false);
        EntradajTable.getColumnModel().getColumn(0).setPreferredWidth(150);
        EntradajTable.getColumnModel().getColumn(1).setResizable(false);
        EntradajTable.getColumnModel().getColumn(1).setPreferredWidth(10);
        EntradajTable.getColumnModel().getColumn(2).setResizable(false);
        EntradajTable.getColumnModel().getColumn(2).setPreferredWidth(10);
        EntradajTable.getColumnModel().getColumn(3).setResizable(false);
        EntradajTable.getColumnModel().getColumn(3).setPreferredWidth(10);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 470, 270));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AdicionarjButtonAdicionarAssociado(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdicionarjButtonAdicionarAssociado

}//GEN-LAST:event_AdicionarjButtonAdicionarAssociado

    private void ImprimirjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImprimirjButtonActionPerformed
        int linha = EntradajTable.getSelectedRow();
        if (linha >= 0) {
            String url = ("telas/TransferenciaSaida/reportProdutosTransferencia.jasper");
            Map parameters = new HashMap();
            try {
                parameters.put("id", listaTransfereciaProcessos.get(linha).getTransferencia().getIdsaidaTransferencia());
                parameters.put("nomeFantasia", this.config.getEmpresa().getNomeFantasia());
                parameters.put("RazaoSocial", this.config.getEmpresa().getRazaoSocial());
                parameters.put("idempresa", this.config.getEmpresa().getIdempresa());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Não foi possível gerar o relatório " + ex);
                ex.printStackTrace();
            }
            new relatoriosJasper(url, parameters);
        }
}//GEN-LAST:event_ImprimirjButtonActionPerformed

    private void RelatoriojButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatoriojButtonActionPerformed
        new FrmRelatorioData(2, config);
    }//GEN-LAST:event_RelatoriojButtonActionPerformed

    private void FecharrjButtonFecharAssociado(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FecharrjButtonFecharAssociado
        this.dispose();
}//GEN-LAST:event_FecharrjButtonFecharAssociado

    private void EntradajTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EntradajTableMouseClicked
        if (evt.getClickCount()==1){
            setModelProduto();
            EditarjButton.setEnabled(true);
            ExcluirjButton.setEnabled(true);
        }
    }//GEN-LAST:event_EntradajTableMouseClicked

    private void EntradajTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_EntradajTableKeyReleased
        if ((evt.getKeyCode() == evt.VK_DOWN) || (evt.getKeyCode() == evt.VK_UP)) {
            setModelProduto();
            EditarjButton.setEnabled(true);
            ExcluirjButton.setEnabled(true);

        }
    }//GEN-LAST:event_EntradajTableKeyReleased

    private void EntradajTableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_EntradajTableKeyPressed
       
    }//GEN-LAST:event_EntradajTableKeyPressed

    private void ExcluirjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExcluirjButtonActionPerformed

    }//GEN-LAST:event_ExcluirjButtonActionPerformed

    private void EditarjButtonEditarCadastroAssociado(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarjButtonEditarCadastroAssociado

    }//GEN-LAST:event_EditarjButtonEditarCadastroAssociado

    /**
    * @param args the command line arguments
    */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AdicionarjButton;
    private javax.swing.JToolBar BarradeTarefasjToolBar;
    private javax.swing.JButton EditarjButton;
    private javax.swing.JTable EntradajTable;
    private javax.swing.JButton ExcluirjButton;
    private javax.swing.JButton FecharrjButton;
    private javax.swing.JButton ImprimirjButton;
    private javax.swing.JTable ProdutojTable;
    private javax.swing.JButton RelatoriojButton;
    private javax.swing.JToolBar.Separator SeparadordeTarefasjSeparator;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables

    public void setModelProduto(){
        int linha = EntradajTable.getSelectedRow();
        if (linha >= 0) {
            modelProduto = new ConsultaTransferenciaSaidaProdutoTableModel(listaTransfereciaProcessos.get(linha).getListaProdutos());
        }else {
            if (listaTransfereciaProcessos.size()>0){
                modelProduto = new ConsultaTransferenciaSaidaProdutoTableModel(listaTransfereciaProcessos.get(0).getListaProdutos());
            }else modelProduto = new ConsultaTransferenciaSaidaProdutoTableModel(new ArrayList<TransferenciaProdutoProcesso>());
        }
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.RIGHT);
        ProdutojTable.setModel(modelProduto);
        ProdutojTable.getColumnModel().getColumn(0).setPreferredWidth(10);
        ProdutojTable.getColumnModel().getColumn(1).setPreferredWidth(140);
        ProdutojTable.getColumnModel().getColumn(2).setPreferredWidth(10);
        ProdutojTable.getColumnModel().getColumn(3).setCellRenderer(renderer);
        ProdutojTable.getColumnModel().getColumn(3).setPreferredWidth(10);
        ProdutojTable.getColumnModel().getColumn(4).setCellRenderer(renderer);
        ProdutojTable.getColumnModel().getColumn(4).setPreferredWidth(10);
        this.repaint();
    }

    public void setmodelTransferencia() {
        TransferenciaSaidaController transferenciaSaidaController = new TransferenciaSaidaController();
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.RIGHT);
        String dataInicio = null;
        try {
            dataInicio = Formatacao.SubtarirDatas(new Date(), 60, "yyyy/MM/dd");
        } catch (Exception ex) {
            Logger.getLogger(FrmConsultaTransferenciaSaida.class.getName()).log(Level.SEVERE, null, ex);
        }
        String dataFinal = Formatacao.ConvercaoDataSql(new Date());
        List<Saidatransferencia> listaTransferencia = transferenciaSaidaController.listaTransferencia(dataInicio, dataFinal);
        if (listaTransferencia!=null){
            for (int i=0;i<listaTransferencia.size();i++){
                TransferenciaProcesso processo = new TransferenciaProcesso(listaTransferencia.get(i));
                listaTransfereciaProcessos.add(processo);
            }    
        }
        modelTransferencia = new ConsultaTransferenciaSaidaTableModel(listaTransfereciaProcessos);
        EntradajTable.setModel(modelTransferencia);
        EntradajTable.getColumnModel().getColumn(0).setPreferredWidth(150);
        EntradajTable.getColumnModel().getColumn(1).setPreferredWidth(10);
        EntradajTable.getColumnModel().getColumn(2).setPreferredWidth(10);
        EntradajTable.getColumnModel().getColumn(3).setCellRenderer(renderer);
        EntradajTable.getColumnModel().getColumn(3).setPreferredWidth(10);
       this.repaint();
    }

    

}
