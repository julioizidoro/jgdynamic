/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package telas.NotaSaida;

import Regras.ContasReceberController;
import Regras.Formatacao;
import Regras.ProdutoController;
import Regras.VendaController;
import controler.Config;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import model.Contasreceber;
import model.Contasreceberprodutos;
import model.Produto;
import model.Saida;

/**
 *
 * @author wolverine
 */
public class FrmConsultaProdutoConta extends javax.swing.JFrame {
    
    private ConsultaContasReceberTableModel modelContas;
    private ConsultaProdutosContaReceberTableModel modelProdutos;
    private List<Contasreceber> listaContas;
    private List<Saida> listaProdutoContas;
    private Config config;
    private List<NotaSaidaProdutoBean> listaProdutoBean;
    private INotaSaidaBean telaNota;

    /**
     * Creates new form FrmConsultaProdutoConta
     */
    public FrmConsultaProdutoConta(Config config, int idCliente, INotaSaidaBean telaNota) {
        this.config = config;
        this.telaNota = telaNota;
        this.listaProdutoBean = new ArrayList<NotaSaidaProdutoBean>();
        initComponents();
        URL url = this.getClass().getResource("/imagens/logo_mini.png");
        Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(imagemTitulo);
        this.setLocationRelativeTo(null);
        setModelContas(idCliente);
        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        contasReceberjTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        produtoContasjTable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        listaNFejLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta Produtos Conta do Cliente");

        contasReceberjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "No. Documento", "Data Lançamento", "Valor Conta", "Data Vencimento"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        contasReceberjTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                contasReceberjTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(contasReceberjTable);
        contasReceberjTable.getColumnModel().getColumn(0).setResizable(false);
        contasReceberjTable.getColumnModel().getColumn(1).setResizable(false);
        contasReceberjTable.getColumnModel().getColumn(2).setResizable(false);
        contasReceberjTable.getColumnModel().getColumn(3).setResizable(false);

        produtoContasjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Código", "Descrição", "Unidade", "Quantidade", "Valor Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(produtoContasjTable);
        produtoContasjTable.getColumnModel().getColumn(0).setResizable(false);
        produtoContasjTable.getColumnModel().getColumn(1).setResizable(false);
        produtoContasjTable.getColumnModel().getColumn(2).setResizable(false);
        produtoContasjTable.getColumnModel().getColumn(3).setResizable(false);
        produtoContasjTable.getColumnModel().getColumn(4).setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton1.setText("Todos os Produtos");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Produto Selecionado");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Fechar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Limpar Lista Produtos");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        listaNFejLabel.setText("Lista Produto NF-e = 10");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(listaNFejLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jButton1)
                .addGap(27, 27, 27)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jButton4)
                .addGap(27, 27, 27)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addComponent(listaNFejLabel)
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 526, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void contasReceberjTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_contasReceberjTableMouseClicked
        int linha = contasReceberjTable.getSelectedRow();
        if (linha>=0){
            setModelProdutos(linha);
        }
    }//GEN-LAST:event_contasReceberjTableMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int linha = produtoContasjTable.getSelectedRow();
        if (linha>=0){
            carregarProdutoBean(listaProdutoContas.get(linha));
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        listaProdutoBean = new ArrayList<NotaSaidaProdutoBean>();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (listaProdutoContas.size()>0){
            for(int i=0;i<listaProdutoContas.size();i++){
                carregarProdutoBean(listaProdutoContas.get(i));
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        telaNota.inlcluirProdutoContas(listaProdutoBean);
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable contasReceberjTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel listaNFejLabel;
    private javax.swing.JTable produtoContasjTable;
    // End of variables declaration//GEN-END:variables

    public void setModelContas(int idCliente){
        ContasReceberController contasReceberController = new ContasReceberController();
        String sql = "Select r From Contasreceber r where r.contasreceberpagamento=1 and r.cliente=" + idCliente + " order by r.dataLancamento";
        listaContas = contasReceberController.listarContas(sql);
        if (listaContas==null){
            listaContas = new ArrayList<Contasreceber>();
        }
        modelContas = new ConsultaContasReceberTableModel(listaContas);
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.RIGHT);        
        contasReceberjTable.setModel(modelContas);
        contasReceberjTable.getColumnModel().getColumn(0).setPreferredWidth(40);
        contasReceberjTable.getColumnModel().getColumn(1).setPreferredWidth(60);
        contasReceberjTable.getColumnModel().getColumn(2).setCellRenderer(renderer);
        contasReceberjTable.getColumnModel().getColumn(2).setPreferredWidth(50);
        contasReceberjTable.getColumnModel().getColumn(3).setPreferredWidth(60);
        contasReceberjTable.repaint();
    }
    
    public void setModelProdutos(int linha) {
        ContasReceberController contasReceberController = new ContasReceberController();
        Contasreceberprodutos contasreceberprodutos = contasReceberController.consultarContasReceberProduto(listaContas.get(linha).getIdcontasReceber());
        if (contasreceberprodutos != null) {
            VendaController vendaController = new VendaController();
            listaProdutoContas = vendaController.listarSaidaVenda(contasreceberprodutos.getVenda().getIdvenda());
            if (listaProdutoContas == null) {
                listaProdutoContas = new ArrayList<Saida>();
            }
            modelProdutos = new ConsultaProdutosContaReceberTableModel(listaProdutoContas);
            DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
            renderer.setHorizontalAlignment(SwingConstants.RIGHT);

            produtoContasjTable.setModel(modelProdutos);
            produtoContasjTable.getColumnModel().getColumn(0).setPreferredWidth(20);
            produtoContasjTable.getColumnModel().getColumn(1).setPreferredWidth(300);
            produtoContasjTable.getColumnModel().getColumn(2).setPreferredWidth(40);
            produtoContasjTable.getColumnModel().getColumn(3).setCellRenderer(renderer);
            produtoContasjTable.getColumnModel().getColumn(3).setPreferredWidth(40);
            produtoContasjTable.getColumnModel().getColumn(4).setCellRenderer(renderer);
            produtoContasjTable.getColumnModel().getColumn(4).setPreferredWidth(40);
            produtoContasjTable.getColumnModel().getColumn(5).setPreferredWidth(10);
            produtoContasjTable.repaint();
        }
    }
    
    public void carregarProdutoBean(Saida saida){
        NotaSaidaProdutoBean notaSaidaProdutoBean = new NotaSaidaProdutoBean();
        Produto produto = new Produto();
        ProdutoController produtoController = new ProdutoController();
        produto= produtoController.consultarProdutoid(saida.getProduto());
        String stvalor ="0";
        if (produto!=null){
            notaSaidaProdutoBean.setProduto(produto);
            notaSaidaProdutoBean.setQuantidade(saida.getQuantidade());
            notaSaidaProdutoBean.setValorDesconto(0.0f);
            stvalor = Formatacao.foramtarFloatString(saida.getValorVenda()/saida.getQuantidade().floatValue());
            notaSaidaProdutoBean.setValorUnitario(Formatacao.formatarStringfloat(stvalor));
            stvalor = Formatacao.foramtarDoubleString( notaSaidaProdutoBean.getValorUnitario() * notaSaidaProdutoBean.getQuantidade());
            notaSaidaProdutoBean.setValortotal(Formatacao.formatarStringfloat(stvalor));
            listaProdutoBean.add(notaSaidaProdutoBean);
        }
        listaNFejLabel.setText("Lista Produtos NF-e=" + String.valueOf(listaProdutoBean.size()));   
    }
}
