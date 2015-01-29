/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FrmPedidoFornecedor.java
 *
 * Created on 10/09/2011, 10:00:40
 */
package telas.ForPedido;

import Interfaces.IforPedido;
import Regras.*;
import controler.Config;
import Interfaces.ItelaConsulta;
import facade.*;
import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import model.*;
import telas.Fornecedor.FrmConsultaFornecedor;
import telas.Produtos.FrmListaFornecedor;

/**
 *
 * @author Wolverine
 */
public final class FrmPedidoFornecedor extends javax.swing.JFrame implements IforPedido {
    
    private ForPedido forPedido;
    private List<Forproduto> listaForProduto;
    private List<ForVinculo> listaForVinculo;
    private int dias = 0;
    private ForProdutoTableModel modelForProduto;
    private ForVinculoTableModel modelForVinculo;
    private ItelaConsulta telaConsulta;
    private Produto produto;
    private Config config;
    
    private DefaultTableCellRenderer rendererCor;
    private DefaultTableCellRenderer rendererData;
    private DefaultTableCellRenderer rendererCorAlinhado;
    

    /** Creates new form FrmPedidoFornecedor */
    public FrmPedidoFornecedor(Fornecedor fornecedor, Config config, ForPedido forPedido, ItelaConsulta telaConsulta) {
        
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
        
        this.rendererData = new DefaultTableCellRenderer(){
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                        boolean isSelected, boolean hasFocus, int row, int column) {
                   String sdata = (String)value;
                   Date data = null;
                   if (sdata.length()>3){
                       data = Formatacao.ConvercaoStringData(sdata);
                   }
                    Component comp = super.getTableCellRendererComponent(table, value,
                            isSelected, hasFocus, row, column);
                   if (data != null) {
                    if (data.after(new Date())) {
                        comp.setBackground(Color.blue);
                        comp.setForeground(Color.white);
                    } else {
                        comp.setBackground(Color.white);
                    }
                }else {
                       comp.setBackground(Color.white);
                   }
                return comp;
            }
        };
        
        
        
        this.rendererCorAlinhado = new DefaultTableCellRenderer(){
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                        boolean isSelected, boolean hasFocus, int row, int column) {
                    Component comp = super.getTableCellRendererComponent(table, value,
                            isSelected, hasFocus, row, column);
                    if (value.equals("xxx")){
                        comp.setBackground(Color.red);
                    }
                    return comp;
                }
        };
        
        
        this.forPedido = forPedido;
        this.config = config;
        this.telaConsulta = telaConsulta;
        this.produto = null;
        forPedido.getForPedido().setFornecedor(fornecedor.getIdfornecedor());
        forPedido.getForPedido().setEmpresa(config.getEmpresa().getIdempresa());
        listaForProduto = new ArrayList<Forproduto>();
        initComponents();
        this.dias = parametroDias();
        carregarListaForProduto();
        carregarModelForProduto();        
        URL url = this.getClass().getResource("/imagens/logo_mini.png");
        Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(imagemTitulo);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
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
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        forProdutojTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        totalPedidojLabel = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ForVinculojTable = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pedido de Fornecedore");

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        forProdutojTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Código", "Descrição", "Unidade", "Estoque", "Valor Venda", "Ultimas Vendas", "Valor Compra", "Ultima Compra", "Chegada", "Embalagem", "Fabricante", "Pedido"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        forProdutojTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                forProdutojTableKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                forProdutojTableKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(forProdutojTable);
        if (forProdutojTable.getColumnModel().getColumnCount() > 0) {
            forProdutojTable.getColumnModel().getColumn(0).setResizable(false);
            forProdutojTable.getColumnModel().getColumn(0).setPreferredWidth(5);
            forProdutojTable.getColumnModel().getColumn(1).setResizable(false);
            forProdutojTable.getColumnModel().getColumn(1).setPreferredWidth(200);
            forProdutojTable.getColumnModel().getColumn(2).setResizable(false);
            forProdutojTable.getColumnModel().getColumn(2).setPreferredWidth(5);
            forProdutojTable.getColumnModel().getColumn(3).setResizable(false);
            forProdutojTable.getColumnModel().getColumn(3).setPreferredWidth(15);
            forProdutojTable.getColumnModel().getColumn(4).setResizable(false);
            forProdutojTable.getColumnModel().getColumn(4).setPreferredWidth(15);
            forProdutojTable.getColumnModel().getColumn(5).setResizable(false);
            forProdutojTable.getColumnModel().getColumn(5).setPreferredWidth(20);
            forProdutojTable.getColumnModel().getColumn(6).setResizable(false);
            forProdutojTable.getColumnModel().getColumn(6).setPreferredWidth(15);
            forProdutojTable.getColumnModel().getColumn(7).setResizable(false);
            forProdutojTable.getColumnModel().getColumn(7).setPreferredWidth(15);
            forProdutojTable.getColumnModel().getColumn(8).setResizable(false);
            forProdutojTable.getColumnModel().getColumn(8).setPreferredWidth(5);
            forProdutojTable.getColumnModel().getColumn(9).setResizable(false);
            forProdutojTable.getColumnModel().getColumn(9).setPreferredWidth(15);
            forProdutojTable.getColumnModel().getColumn(10).setResizable(false);
            forProdutojTable.getColumnModel().getColumn(10).setPreferredWidth(10);
            forProdutojTable.getColumnModel().getColumn(11).setResizable(false);
        }

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("Total do Pedido R$ :");

        totalPedidojLabel.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        totalPedidojLabel.setText("0,00");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(totalPedidojLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(totalPedidojLabel))
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        ForVinculojTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Código", "Razão Social", "Valor Custo", "Valor Compra", "Valor Frete", "Prazo Entrega", "Data Compra", "Embalagem", "Fabricante", "ST"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(ForVinculojTable);
        if (ForVinculojTable.getColumnModel().getColumnCount() > 0) {
            ForVinculojTable.getColumnModel().getColumn(0).setResizable(false);
            ForVinculojTable.getColumnModel().getColumn(0).setPreferredWidth(5);
            ForVinculojTable.getColumnModel().getColumn(1).setResizable(false);
            ForVinculojTable.getColumnModel().getColumn(1).setPreferredWidth(200);
            ForVinculojTable.getColumnModel().getColumn(2).setResizable(false);
            ForVinculojTable.getColumnModel().getColumn(2).setPreferredWidth(5);
            ForVinculojTable.getColumnModel().getColumn(3).setResizable(false);
            ForVinculojTable.getColumnModel().getColumn(3).setPreferredWidth(15);
            ForVinculojTable.getColumnModel().getColumn(4).setResizable(false);
            ForVinculojTable.getColumnModel().getColumn(4).setPreferredWidth(15);
            ForVinculojTable.getColumnModel().getColumn(5).setResizable(false);
            ForVinculojTable.getColumnModel().getColumn(5).setPreferredWidth(20);
            ForVinculojTable.getColumnModel().getColumn(6).setResizable(false);
            ForVinculojTable.getColumnModel().getColumn(6).setPreferredWidth(15);
            ForVinculojTable.getColumnModel().getColumn(7).setResizable(false);
            ForVinculojTable.getColumnModel().getColumn(7).setPreferredWidth(15);
            ForVinculojTable.getColumnModel().getColumn(8).setResizable(false);
            ForVinculojTable.getColumnModel().getColumn(8).setPreferredWidth(5);
            ForVinculojTable.getColumnModel().getColumn(9).setResizable(false);
            ForVinculojTable.getColumnModel().getColumn(9).setPreferredWidth(15);
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/magnifier.png"))); // NOI18N
        jButton1.setText("Visualizar");
        jButton1.setToolTipText("Visualiza Pedido para Finalizar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/door_in.png"))); // NOI18N
        jButton2.setText("Fechar");
        jButton2.setToolTipText("Fechar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/bricks.png"))); // NOI18N
        jButton3.setText("No. Dias");
        jButton3.setToolTipText("");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/tick.png"))); // NOI18N
        jButton4.setText("Adcionar Vinculo");
        jButton4.setToolTipText("Vincular novo Fornecedor");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cross.png"))); // NOI18N
        jButton5.setText("Remover Outros Vinculo");
        jButton5.setToolTipText("Remover vinculo de Fornecedor");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cross.png"))); // NOI18N
        jButton6.setText("Remover Vinculo Atual");
        jButton6.setToolTipText("Remover vinculo de Fornecedor Atual");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/tick.png"))); // NOI18N
        jButton7.setText("Fornecedor");
        jButton7.setToolTipText("Vincula noo Fornecedor a um Produto");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton5)
                .addGap(18, 18, 18)
                .addComponent(jButton6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton3)
                    .addComponent(jButton5)
                    .addComponent(jButton4)
                    .addComponent(jButton2)
                    .addComponent(jButton6)
                    .addComponent(jButton7))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void forProdutojTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_forProdutojTableKeyReleased
    int linha = forProdutojTable.getSelectedRow(); 
    if ((evt.getKeyCode() == java.awt.event.KeyEvent.VK_DOWN) || (evt.getKeyCode() == java.awt.event.KeyEvent.VK_UP)) {
        if (linha >= 0) {
            produto = new Produto();
            produto.setIdProduto(listaForProduto.get(linha).getIdProduto());
            carregarListaForVinculo(listaForProduto.get(linha).getIdProduto(), forPedido.getForPedido().getEmpresa(), forPedido.getForPedido().getFornecedor());
        }
    }
}//GEN-LAST:event_forProdutojTableKeyReleased

private void forProdutojTableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_forProdutojTableKeyPressed
    if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
        int linha = forProdutojTable.getSelectedRow();
        if (linha >= 0) {
            String fabricante = listaForProduto.get(linha).getCodigoFabricante();
            double embalagem = listaForProduto.get(linha).getEmbalagem();
            double quantidade = verificarQuantidade(listaForProduto.get(linha).getIdProduto());
            double valorCusto = 0;
            if (listaForProduto.get(linha).getValorCompra()!=null){
                valorCusto = listaForProduto.get(linha).getValorCompra();
            }
            new FrmQuantidadePedido(this, quantidade, fabricante, embalagem, linha, valorCusto);
        }
    }
    
    if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_DELETE) {
        int linha = forProdutojTable.getSelectedRow();
        if (linha >= 0) {
            double valorCusto = 0;
            if (listaForProduto.get(linha).getValorCompra()!=null){
                valorCusto = listaForProduto.get(linha).getValorCompra();
            }
             
            removerProdutoListaPedido(listaForProduto.get(linha).getIdProduto(), valorCusto);
            this.listaForProduto.get(linha).setPedido("NAO");
            linha = forProdutojTable.getSelectedRow();
            if (linha > 0) {
                linha = linha - 1;
            }
            carregarModelForProduto();
            forProdutojTable.setRowSelectionInterval(linha, linha);
        }
    }
}//GEN-LAST:event_forProdutojTableKeyPressed

private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (this.forPedido.getListaPedidoProduto().size()>0){
            boolean resultado = JOptionPane.showConfirmDialog(null, "Existem Produtos na Relação de Pedido. Sair e Excluir?", "Atenção", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == 0;
            if (resultado){
                this.dispose();
            }
        }else this.dispose();
}//GEN-LAST:event_jButton2ActionPerformed

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      new FrmVisualizarPedidoForProduto(forPedido, this, this.config);
}//GEN-LAST:event_jButton1ActionPerformed

private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    this.dias = Integer.parseInt(JOptionPane.showInputDialog("Número de dias das Vendas"));
}//GEN-LAST:event_jButton3ActionPerformed

private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
    int linha = ForVinculojTable.getSelectedRow();
    if (linha>=0){
        removerVinculoFonrecedor(linha);
    } else JOptionPane.showMessageDialog(rootPane, "Selecione um Produto na Lista");
}//GEN-LAST:event_jButton5ActionPerformed

private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
    new FrmConsultaFornecedor(this);
}//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        int linha = forProdutojTable.getSelectedRow();
        if (linha >= 0) {
            removerVinculoFonrecedorAtual(linha);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Selecione um Produto na Lista");
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        new FrmConsultaFornecedor(this);
    }//GEN-LAST:event_jButton7ActionPerformed

    /**
     * @param args the command line arguments
     */
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable ForVinculojTable;
    private javax.swing.JTable forProdutojTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel totalPedidojLabel;
    // End of variables declaration//GEN-END:variables

    public void carregarListaForProduto(){
        VinculoController vinculoController = new VinculoController();
        List<Vinculo> listaVinculo = vinculoController.consultaVinculo(forPedido.getForPedido().getFornecedor(), forPedido.getForPedido().getEmpresa());
        ForPedidoFacade forPedidoFacade = new ForPedidoFacade();
        excluirListaForProduto();
        if (listaVinculo != null) {
            for (int i = 0; i < listaVinculo.size(); i++) {
                Produto produto = localizarProduto(listaVinculo.get(i).getProduto());
                Estoque estoque = localizarEstoque(produto.getIdProduto(), listaVinculo.get(i).getEmpresa());
                Forproduto forProduto = new Forproduto();
                forProduto.setCodigoFabricante(listaVinculo.get(i).getCodigoFabricante());
                if (estoque != null) {
                    if (estoque.getDataPrevisao() != null) {
                        forProduto.setDataChegada(estoque.getDataPrevisao());
                    }
                    if (estoque.getDataCompra() != null) {
                        forProduto.setDataUltimaCompra(listaVinculo.get(i).getDataCompra());
                    }
                    forProduto.setDescricao(produto.getDescricao());
                    forProduto.setEmbalagem(listaVinculo.get(i).getEmbalagem().doubleValue());
                    forProduto.setIdProduto(produto.getIdProduto());
                    forProduto.setQuantidadeEstoque(estoque.getQuantidadeEstoque());
                    forProduto.setQuantidadeUltimaVenda(quantidadeVendida(forProduto.getIdProduto()));
                    forProduto.setReferencia(produto.getReferencia());
                    forProduto.setUnidade(produto.getUnidade());
                    forProduto.setValorCompra(listaVinculo.get(i).getValorCompra().doubleValue());
                    forProduto.setValorVenda(estoque.getValorVenda().doubleValue());
                    forProduto.setIdVinculo(listaVinculo.get(i).getIdvinculo());
                    forProduto.setPedido(listaVinculo.get(i).getPedido());
                    forProduto.setPedido("NAO");
                    try {
                        forPedidoFacade.salvarForProduto(forProduto);
                    } catch (SQLException ex) {
                        Logger.getLogger(FrmPedidoFornecedor.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(null, "Erro Salvar FoProduto " + ex);
                    }
                }
            }
        }
        try {
            this.listaForProduto = forPedidoFacade.consultarForProduto();
        } catch (SQLException ex) {
            Logger.getLogger(FrmPedidoFornecedor.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(rootPane, "Eror consultar ForProduto " + ex);
        }
    }
    
    public double quantidadeVendida(int idProduto){
        int dias = this.dias - (2*this.dias);
        String dataInicial = null;
        String dataFinal = null;
        try {
            dataInicial = Formatacao.SomarDatas(new Date(),dias , "yyyy/MM/dd");
            dataFinal = Formatacao.ConvercaoDataSql(new Date());
        } catch (Exception ex) {
            Logger.getLogger(FrmPedidoFornecedor.class.getName()).log(Level.SEVERE, null, ex);
        }
        VendaFacade vendaFacade = new VendaFacade();
        try {
            return vendaFacade.quantidadeVendida(idProduto, dataInicial, dataFinal);
        } catch (SQLException ex) {
            Logger.getLogger(FrmPedidoFornecedor.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Consultar Quantidade Vendida " + ex);
            return 0;
        }
    }
    
    public void carregarModelForProduto(){
        modelForProduto = new ForProdutoTableModel(listaForProduto);
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.RIGHT);
        forProdutojTable.setModel(modelForProduto);
        forProdutojTable.getColumnModel().getColumn(0).setPreferredWidth(10);
        forProdutojTable.getColumnModel().getColumn(1).setPreferredWidth(200);
        forProdutojTable.getColumnModel().getColumn(2).setPreferredWidth(10);
        forProdutojTable.getColumnModel().getColumn(3).setCellRenderer(renderer);
        forProdutojTable.getColumnModel().getColumn(3).setPreferredWidth(15);
        forProdutojTable.getColumnModel().getColumn(4).setCellRenderer(renderer);
        forProdutojTable.getColumnModel().getColumn(4).setPreferredWidth(15);
        forProdutojTable.getColumnModel().getColumn(5).setCellRenderer(renderer);
        forProdutojTable.getColumnModel().getColumn(5).setPreferredWidth(20);
        forProdutojTable.getColumnModel().getColumn(6).setCellRenderer(renderer);
        forProdutojTable.getColumnModel().getColumn(6).setPreferredWidth(15);
        forProdutojTable.getColumnModel().getColumn(7).setPreferredWidth(10);
        forProdutojTable.getColumnModel().getColumn(8).setCellRenderer(rendererData);
        forProdutojTable.getColumnModel().getColumn(8).setPreferredWidth(10);
        forProdutojTable.getColumnModel().getColumn(9).setCellRenderer(renderer);
        forProdutojTable.getColumnModel().getColumn(9).setPreferredWidth(15);
        forProdutojTable.getColumnModel().getColumn(10).setPreferredWidth(10);
        forProdutojTable.getColumnModel().getColumn(11).setCellRenderer(rendererCor);
        forProdutojTable.getColumnModel().getColumn(11).setPreferredWidth(10);
        forProdutojTable.repaint();
        if (listaForProduto.size()>0){
            carregarListaForVinculo(listaForProduto.get(0).getIdProduto(), forPedido.getForPedido().getEmpresa(), forPedido.getForPedido().getFornecedor());
        }
    }
    
    public void carregarListaForVinculo(int idProduto, int idEmpresa, int idFornecedor){
        listaForVinculo = new ArrayList<ForVinculo>();
        List<Vinculo> listaVinculo = new ArrayList<Vinculo>();
        VinculoController vinculoController = new VinculoController();
        listaVinculo = vinculoController.consultarVinculoPedido(idProduto, idEmpresa, idFornecedor);
        if (listaVinculo!=null){
            for (int i=0;i<listaVinculo.size();i++){
                Fornecedor fornecedor = localizarFornecedor(listaVinculo.get(i).getFornecedor());
                ForVinculo forVinculo = new ForVinculo();
                forVinculo.setCodigoFabricante(listaVinculo.get(i).getCodigoFabricante());
                forVinculo.setDataCompra(listaVinculo.get(i).getDataCompra());
                forVinculo.setEmbalagem(listaVinculo.get(i).getEmbalagem());
                forVinculo.setIdFornecedor(fornecedor.getIdfornecedor());
                forVinculo.setPrazoEntrega(fornecedor.getPrazoEntrega());
                forVinculo.setRazaoSocial(fornecedor.getRazaoSocial());
                forVinculo.setValorCompra(listaVinculo.get(i).getValorCompra());
                forVinculo.setValorCusto(listaVinculo.get(i).getValorCompra());
                forVinculo.setPedido(listaVinculo.get(i).getPedido());
                forVinculo.setValorFrete(0);
                listaForVinculo.add(forVinculo);
            }
        }
        carregarModelForVinculo();
    }
    
    public void carregarModelForVinculo(){
        modelForVinculo = new ForVinculoTableModel(listaForVinculo);
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.RIGHT);
        ForVinculojTable.setModel(modelForVinculo);
        ForVinculojTable.getColumnModel().getColumn(0).setPreferredWidth(10);
        ForVinculojTable.getColumnModel().getColumn(1).setPreferredWidth(200);
        ForVinculojTable.getColumnModel().getColumn(2).setCellRenderer(renderer);
        ForVinculojTable.getColumnModel().getColumn(2).setPreferredWidth(10);
        ForVinculojTable.getColumnModel().getColumn(3).setCellRenderer(renderer);
        ForVinculojTable.getColumnModel().getColumn(3).setPreferredWidth(15);
        ForVinculojTable.getColumnModel().getColumn(4).setCellRenderer(renderer);
        ForVinculojTable.getColumnModel().getColumn(4).setPreferredWidth(15);
        ForVinculojTable.getColumnModel().getColumn(5).setPreferredWidth(20);
        ForVinculojTable.getColumnModel().getColumn(6).setPreferredWidth(15);
        ForVinculojTable.getColumnModel().getColumn(7).setCellRenderer(renderer);
        ForVinculojTable.getColumnModel().getColumn(7).setPreferredWidth(10);
        ForVinculojTable.getColumnModel().getColumn(8).setPreferredWidth(10);
        ForVinculojTable.getColumnModel().getColumn(9).setPreferredWidth(15);
        ForVinculojTable.repaint();
    }
    
    public Produto getProduto(int referencia){
        Produto produto = new Produto();
        ProdutoController produtoController = new ProdutoController();
        produto = produtoController.consultarProdutoReferencia(referencia);
        return produto;
    }
    
    public void adicionarProdutoListaPedido(double quantidade, int referencia, int idVinculo, double valorCusto){
       Forpedproduto produtoPedido = new Forpedproduto();
       produtoPedido.setProduto(getProduto(referencia).getIdProduto()); 
       produtoPedido.setQuantidade(quantidade);
       VinculoController vinculoController = new VinculoController();
       produtoPedido.setVinculo(vinculoController.getVinculo(idVinculo).getIdvinculo());
       produtoPedido.setEntrada(null);
       forPedido.somarValorCusto(valorCusto * quantidade);
       forPedido.adicionarProduto(produtoPedido);
       totalPedidojLabel.setText(Formatacao.foramtarDoubleString(forPedido.getTotalPedido()));
    }
    
    private boolean verificarProdutoSolicitado(int idProduto){
        List<Forpedproduto> listaPedidoProduto = forPedido.getListaPedidoProduto();
        for(int i=0;i<listaPedidoProduto.size();i++){
            int idPedido = listaPedidoProduto.get(i).getProduto();
            if (idPedido==idProduto){
                return true;
            }
        }
        return false;
    }
    
    private double verificarQuantidade(int idProduto){
        List<Forpedproduto> listaPedidoProduto = forPedido.getListaPedidoProduto();
        double quantidade =0;
        for(int i=0;i<listaPedidoProduto.size();i++){
            int idPedido = listaPedidoProduto.get(i).getProduto();
            if (idPedido==idProduto){
                quantidade = listaPedidoProduto.get(i).getQuantidade();
                return quantidade;
            }
        }
        return 0.0;
    }
    
    public void removerProdutoListaPedido(int idProduto, double valorCusto){
        List<Forpedproduto> listaPedidoProduto = forPedido.getListaPedidoProduto();
        ForPedidoController forPedidoController = new ForPedidoController();
        for(int i=0;i<listaPedidoProduto.size();i++){
            int idPedido = listaPedidoProduto.get(i).getProduto();
            if (idPedido==idProduto){
                if (forPedido.getListaPedidoProduto().get(i).getIdForPedProduto()!=null){                    
                    forPedidoController.excluirForPedProduto(forPedido.getListaPedidoProduto().get(i));
                }
                forPedido.subtrairValorCusto(valorCusto * forPedido.getListaPedidoProduto().get(i).getQuantidade());
                forPedido.getListaPedidoProduto().remove(i);
            }
        }
        totalPedidojLabel.setText(Formatacao.foramtarDoubleString(forPedido.getTotalPedido()));
    }
    
    public int parametroDias(){
       ParametroLocalController parametroLocalController = new ParametroLocalController();
       ParametrosLocal parametros = new ParametrosLocal();
       parametros = parametroLocalController.localizarEmpresa(config.getEmpresa().getIdparametros());
       if (parametros.getNumeroDias()==null){
           return 1;
       }else{
           return parametros.getNumeroDias();     
       }
    }

    public void fecharForProduto() {
        telaConsulta.setForPedido(this);
        this.dispose();
    }
    
    public void excluirListaForProduto(){
        List<Forproduto> listaForProduto = new ArrayList<Forproduto>();
        ForPedidoFacade forPedidoFacade = new ForPedidoFacade();
        try {
            listaForProduto = forPedidoFacade.consultarForProduto();
            if (listaForProduto!=null){
                for (int i=0;i<listaForProduto.size();i++){
                    forPedidoFacade.excluirForProduto(listaForProduto.get(i).getIdProduto());
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(FrmPedidoFornecedor.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(rootPane, "Erro Exluir ForProduto "+ ex);
        }
    }
    
    public void removerVinculoFonrecedor(int linha) {
        if (this.produto != null) {
            Vinculo vinculo = new Vinculo();
            VinculoController vinculoController = new VinculoController();
            Fornecedor fornecedor = new Fornecedor();
            FornecedorFacade fornecedorFacade = new FornecedorFacade();
            try {
                fornecedor = fornecedorFacade.consultarFornecedor(listaForVinculo.get(linha).getIdFornecedor());
            } catch (SQLException ex) {
                Logger.getLogger(FrmListaFornecedor.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(rootPane, "Erro Consultar Fornecedor " + ex);
            }
            if (fornecedor != null) {
                vinculo = vinculoController.consultarVinculo(this.produto.getIdProduto(), forPedido.getForPedido().getEmpresa(), fornecedor.getIdfornecedor());
                if (vinculo != null) {
                    vinculoController.excluirVinculo(vinculo.getIdvinculo());
                    JOptionPane.showMessageDialog(rootPane, "Vinculo Removido com Sucesso");
                    carregarListaForVinculo(this.produto.getIdProduto(), forPedido.getForPedido().getEmpresa(), forPedido.getForPedido().getFornecedor());
                }
            }  
        }
    }
    
    public void removerVinculoFonrecedorAtual(int linha) {
            Vinculo vinculo = new Vinculo();
            VinculoController vinculoController = new VinculoController();
            Fornecedor fornecedor = new Fornecedor();
            FornecedorFacade fornecedorFacade = new FornecedorFacade();
            try {
                fornecedor = fornecedorFacade.consultarFornecedor(forPedido.getForPedido().getFornecedor());
            } catch (SQLException ex) {
                Logger.getLogger(FrmListaFornecedor.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(rootPane, "Erro Consultar Fornecedor " + ex);
            }
            if (fornecedor != null) {
                vinculo = vinculoController.consultarVinculo(listaForProduto.get(linha).getIdProduto(), forPedido.getForPedido().getEmpresa(), fornecedor.getIdfornecedor());
                if (vinculo != null) {
                    vinculoController.excluirVinculo(vinculo.getIdvinculo());
                    JOptionPane.showMessageDialog(rootPane, "Vinculo Atual Removido com Sucesso");
                }
            }
    }

    public void vincularProduto(Produto produto) {
        if (verifcarVinculo(produto)) {
            JOptionPane.showMessageDialog(rootPane, "Já existe vinculo entre Produto e Fornecedor");
        } else {
            Vinculo vinculo = new Vinculo();
            vinculo.setCodigoFabricante(JOptionPane.showInputDialog("Informe Código Fabricante"));
            Double embalagem = 0.0;
            vinculo.setEmbalagem(embalagem.longValue());
            vinculo.setEmpresa(forPedido.getForPedido().getEmpresa());
            vinculo.setFornecedor(forPedido.getForPedido().getFornecedor());
            vinculo.setProduto(produto.getIdProduto());
            vinculo.setValorCompra(0f);
            VinculoFacade vinculoFacade = new VinculoFacade();
            try {
                vinculo = vinculoFacade.salvaVinculo(vinculo);
                Forproduto forProduto = new Forproduto();
                forProduto.setCodigoFabricante(vinculo.getCodigoFabricante());
                forProduto.setDataChegada(produto.getDataPedido());
                forProduto.setDataUltimaCompra(vinculo.getDataCompra());
                forProduto.setDescricao(produto.getDescricao());
                forProduto.setEmbalagem(vinculo.getEmbalagem().doubleValue());
                forProduto.setIdProduto(produto.getIdProduto());
                Estoque estoque = localizarEstoque(produto.getIdProduto(), vinculo.getEmpresa());
                forProduto.setQuantidadeEstoque(estoque.getQuantidadeEstoque());
                forProduto.setQuantidadeUltimaVenda(quantidadeVendida(forProduto.getIdProduto()));
                forProduto.setReferencia(produto.getReferencia());
                forProduto.setUnidade(produto.getUnidade());
                forProduto.setValorCompra(vinculo.getValorCompra().doubleValue());
                forProduto.setValorVenda(estoque.getValorVenda().doubleValue());
                forProduto.setIdVinculo(vinculo.getIdvinculo());
                this.listaForProduto.add(forProduto);
                carregarModelForProduto();        
                JOptionPane.showMessageDialog(rootPane, "Vinculo Salvo com Sucesso");
            } catch (SQLException ex) {
                Logger.getLogger(FrmListaFornecedor.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(rootPane, "Erro Salvar Vinculo " + ex);
            }
        }
    }
    
    public boolean verifcarVinculo(Produto produto){
        VinculoController vinculoController = new VinculoController();
        Vinculo vinculo = new Vinculo();
        vinculo = vinculoController.consultarVinculo(produto.getIdProduto(), forPedido.getForPedido().getEmpresa(), forPedido.getForPedido().getFornecedor());
        if (vinculo!=null){
            return true;
        }else return false;
    }

    public void quantidadePedido(double quantidade, String fabricante, Double embalagem, int linha, double valorCusto) {
        this.listaForProduto.get(linha).setPedido("SIM");
        removerProdutoListaPedido(listaForProduto.get(linha).getIdProduto(), valorCusto);
        adicionarProdutoListaPedido(quantidade, listaForProduto.get(linha).getReferencia(), listaForProduto.get(linha).getIdVinculo(), valorCusto);
        VinculoController vinculoController = new VinculoController();
        ProdutoController produtoController = new ProdutoController();
        Produto produtoVinculo = produtoController.consultarProdutoid(listaForProduto.get(linha).getIdProduto());
        Vinculo vinculo = vinculoController.consultarVinculo(produtoVinculo.getIdProduto(), forPedido.getForPedido().getEmpresa(), forPedido.getForPedido().getFornecedor());
        if (vinculo==null){
            vinculo.setCodigoFabricante(fabricante);
            vinculo.setDataCompra(new Date());
            vinculo.setEmbalagem(embalagem.longValue());
            vinculo.setEmpresa(forPedido.getForPedido().getEmpresa());
            vinculo.setFornecedor(forPedido.getForPedido().getFornecedor());
            vinculo.setProduto(produto.getIdProduto());
            vinculo.setValorCompra(0.0f);
            vinculoController.salvarVinculo(vinculo);
        }else {
            if (vinculo.getCodigoFabricante()==null){
                vinculo.setCodigoFabricante(fabricante);
                vinculo.setEmbalagem(embalagem.longValue());
                vinculoController.salvarVinculo(vinculo);
            }else{
            if (!vinculo.getCodigoFabricante().equalsIgnoreCase(fabricante)){
                vinculo.setCodigoFabricante(fabricante);
                vinculo.setEmbalagem(embalagem.longValue());
                vinculoController.salvarVinculo(vinculo);
            }else if (vinculo.getEmbalagem()!=embalagem.longValue()){
                vinculo.setCodigoFabricante(fabricante);
                vinculo.setEmbalagem(embalagem.longValue());
                vinculoController.salvarVinculo(vinculo);
            }
        }
        linha = forProdutojTable.getSelectedRow();
        if (linha>0){
            linha = linha - 1;
        }
        carregarModelForProduto();
        forProdutojTable.setRowSelectionInterval(linha, linha);
    }
    }
    
     public Produto localizarProduto(int idProduto){
        ProdutoController produtoController = new ProdutoController();
        return produtoController.consultarProdutoid(idProduto);
    }
     
     public Estoque localizarEstoque(int idProduto, int idEmpresa){
         EstoqueController estoqueController = new EstoqueController();
         return estoqueController.consultarEstoque(idProduto, idEmpresa);
     }
     
     public Fornecedor localizarFornecedor(int idFornecedor){
        FornecedorController fornecedorController = new FornecedorController();
        return fornecedorController.consultarFornecedor(idFornecedor);
    }

    public void vincularNovoFornecedor(Fornecedor fornecedor) {
        Vinculo vinculoNovofornecedor = new Vinculo();
        int linha = forProdutojTable.getSelectedRow();
        if (linha>=0){
            vinculoNovofornecedor.setCodigoFabricante(listaForProduto.get(linha).getCodigoFabricante());
            vinculoNovofornecedor.setEmbalagem(0l);
            vinculoNovofornecedor.setEmpresa(config.getEmpresa().getIdempresa());
            vinculoNovofornecedor.setFornecedor(fornecedor.getIdfornecedor());
            vinculoNovofornecedor.setPedido("NAO");
            vinculoNovofornecedor.setProduto(listaForProduto.get(linha).getIdProduto());
            vinculoNovofornecedor.setValorCompra(0.0f);
            VinculoController vinculoController = new VinculoController();
            vinculoNovofornecedor = vinculoController.salvarVinculo(vinculoNovofornecedor);
            ForVinculo forVinculo = new ForVinculo();
            forVinculo.setCodigoFabricante(vinculoNovofornecedor.getCodigoFabricante());
            forVinculo.setDataCompra(null);
            forVinculo.setEmbalagem(vinculoNovofornecedor.getEmbalagem());
            forVinculo.setIdFornecedor(vinculoNovofornecedor.getFornecedor());
            forVinculo.setPrazoEntrega(fornecedor.getPrazoEntrega());
            forVinculo.setRazaoSocial(fornecedor.getRazaoSocial());
            forVinculo.setValorCompra(vinculoNovofornecedor.getValorCompra());
            forVinculo.setValorCusto(vinculoNovofornecedor.getValorCompra());
            forVinculo.setValorFrete(0.0f);
            this.listaForVinculo.add(forVinculo);
            carregarModelForVinculo();
        }
        
    }
}
