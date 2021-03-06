/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FrmListaFornecedor.java
 *
 * Created on 27/09/2011, 15:24:07
 */
package telas.Produtos;

import Interfaces.ItelaConsulta;
import Regras.Formatacao;
import Regras.FornecedorController;
import Regras.VinculoController;
import beanController.NfDuplicatas;
import beanController.NfProdutos;
import beanController.NotaEletronica;
import controler.Config;
import facade.FornecedorFacade;
import facade.VinculoFacade;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import model.*;
import telas.Fornecedor.FrmConsultaFornecedor;

/**
 *
 * @author Wolverine
 */
public class FrmListaFornecedor extends javax.swing.JFrame implements ItelaConsulta {

    /** Creates new form FrmListaFornecedor */
    private Produto produto;
    private List<ListaFornecedorProduto> listaVinculos;
    private ListaFornecedorTableModel model;
    private Config config;
    
    public FrmListaFornecedor(Produto produto, Config config) {
        this.produto = produto;
        this.config = config;
        listaVinculos = new ArrayList<ListaFornecedorProduto>();
        initComponents();
        URL url = this.getClass().getResource("/imagens/logo_mini.png");
        Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(imagemTitulo);
        this.setLocationRelativeTo(null);
        try{
            UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
        }catch (Exception e){
        }
        setModelListaVinculo();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        listaVinculojTable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta Vinculo Fornecedor");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        listaVinculojTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Razao Social", "Codigo Fabricante", "Data Compra", "Valor Compra"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(listaVinculojTable);
        listaVinculojTable.getColumnModel().getColumn(0).setResizable(false);
        listaVinculojTable.getColumnModel().getColumn(0).setPreferredWidth(10);
        listaVinculojTable.getColumnModel().getColumn(1).setResizable(false);
        listaVinculojTable.getColumnModel().getColumn(1).setPreferredWidth(200);
        listaVinculojTable.getColumnModel().getColumn(2).setResizable(false);
        listaVinculojTable.getColumnModel().getColumn(2).setPreferredWidth(30);
        listaVinculojTable.getColumnModel().getColumn(3).setResizable(false);
        listaVinculojTable.getColumnModel().getColumn(3).setPreferredWidth(20);
        listaVinculojTable.getColumnModel().getColumn(4).setResizable(false);
        listaVinculojTable.getColumnModel().getColumn(4).setPreferredWidth(20);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 639, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/door_in.png"))); // NOI18N
        jButton1.setText("Fechar");
        jButton1.setToolTipText("Fechar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/tick.png"))); // NOI18N
        jButton2.setText("Adicioanr Vinculo");
        jButton2.setToolTipText("Adicionar um novo Vuncilo");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cross.png"))); // NOI18N
        jButton3.setText("Remover Vinculo");
        jButton3.setToolTipText("Remover um Vinculo");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(79, 79, 79)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    new FrmConsultaFornecedor(this);
}//GEN-LAST:event_jButton2ActionPerformed

private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    int linha = listaVinculojTable.getSelectedRow();
    if (linha>=0){
        removerVinculoFonrecedor(linha);
    } else JOptionPane.showMessageDialog(rootPane, "Selecione um Produto na Lista");
}//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable listaVinculojTable;
    // End of variables declaration//GEN-END:variables

    public void setModelListaVinculo(){
        listaVinculos = new ArrayList<ListaFornecedorProduto>();
        VinculoFacade vinculoFacade = new VinculoFacade();
        List<Vinculo> lista = null;
        try {
            lista = vinculoFacade.consultarVinculo(produto.getIdProduto(), config.getEmpresa().getIdempresa());
        } catch (SQLException ex) {
            Logger.getLogger(FrmListaFornecedor.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(rootPane, "Erro Consultar Vinculos " + ex);
        }
        if (lista!=null){
            for(int i=0;i<lista.size();i++){
                ListaFornecedorProduto vinculo = new ListaFornecedorProduto();
                vinculo.setCodigo(lista.get(i).getFornecedor());
                vinculo.setCodigoFabricante(lista.get(i).getCodigoFabricante());
                vinculo.setDataCompra(lista.get(i).getDataCompra());
                vinculo.setValorCompra(lista.get(i).getValorCompra());
                FornecedorController fornecedorController = new FornecedorController();
                Fornecedor forncedor = fornecedorController.consultarFornecedor(lista.get(i).getFornecedor());
                vinculo.setRazaoSocial(forncedor.getRazaoSocial());
                listaVinculos.add(vinculo);
            }
        }
        model = new ListaFornecedorTableModel(listaVinculos);
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.RIGHT);  
        listaVinculojTable.setModel(model); 
        listaVinculojTable.getColumnModel().getColumn(0).setPreferredWidth(10);
        listaVinculojTable.getColumnModel().getColumn(1).setPreferredWidth(200);
        listaVinculojTable.getColumnModel().getColumn(2).setPreferredWidth(30);
        listaVinculojTable.getColumnModel().getColumn(3).setPreferredWidth(20);
        listaVinculojTable.getColumnModel().getColumn(4).setCellRenderer(renderer);
        listaVinculojTable.getColumnModel().getColumn(4).setPreferredWidth(20);
        listaVinculojTable.repaint();
    }
    
    public boolean verifcarVinculo(Fornecedor fornecedor){
        VinculoController vinculoController = new VinculoController();
        Vinculo vinculo = new Vinculo();
        vinculo = vinculoController.consultarVinculo(produto.getIdProduto(), this.config.getEmpresa().getIdempresa(), fornecedor.getIdfornecedor());
        if (vinculo!=null){
            return true;
        }else return false;
    }
    
    public void vincularNovoFornecedor(Fornecedor fornecedor) {
        if (verifcarVinculo(fornecedor)) {
            JOptionPane.showMessageDialog(rootPane, "Já existe vinculo entre Produto e Fornecedor");
        } else {
            Vinculo vinculo = new Vinculo();
            vinculo.setCodigoFabricante(JOptionPane.showInputDialog("Informe Código Fabricante"));
            Double embalagem = 0.0;
            Double valorCompra = Formatacao.ConvercaoMonetariaDouble(JOptionPane.showInputDialog("Valor Compra"));
            vinculo.setEmbalagem(embalagem.longValue());
            vinculo.setEmpresa(this.config.getEmpresa().getIdempresa());
            vinculo.setFornecedor(fornecedor.getIdfornecedor());
            vinculo.setProduto(produto.getIdProduto());
            vinculo.setValorCompra(valorCompra.floatValue());
            VinculoFacade vinculoFacade = new VinculoFacade();
            try {
                vinculoFacade.salvaVinculo(vinculo);
                JOptionPane.showMessageDialog(rootPane, "Vinculo Salvo com Sucesso");
                setModelListaVinculo();
            } catch (SQLException ex) {
                Logger.getLogger(FrmListaFornecedor.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(rootPane, "Erro Salvar Vinculo " + ex);
            }
        }
    }
    
    public void removerVinculoFonrecedor(int linha){
        Vinculo vinculo = new Vinculo();
        VinculoController vinculoController = new VinculoController();
        Fornecedor fornecedor = new Fornecedor();
        FornecedorFacade fornecedorFacade = new FornecedorFacade();
        try {
            fornecedor = fornecedorFacade.consultarFornecedor(listaVinculos.get(linha).getCodigo());
        } catch (SQLException ex) {
            Logger.getLogger(FrmListaFornecedor.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(rootPane, "Erro Consultar Fornecedor " + ex);
        }
        if (fornecedor!=null){
            vinculo = vinculoController.consultarVinculo(produto.getIdProduto(), this.config.getEmpresa().getIdempresa(), fornecedor.getIdfornecedor());
            if (vinculo!=null){
                vinculoController.excluirVinculo(vinculo.getIdvinculo());
                JOptionPane.showMessageDialog(rootPane, "Vinculo Removido com Sucesso");
                setModelListaVinculo();
            }
        }
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
        Fornecedor fornecedor = new Fornecedor();
        fornecedor = (Fornecedor) objeto;
        vincularNovoFornecedor(fornecedor);
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
