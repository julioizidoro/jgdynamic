/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package telas.ContasReceber;

import Regras.CreditoReceberController;
import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import model.Creditoreceberprodutos;
import telas.NotaSaida.INotaSaidaBean;

/**
 *
 * @author Wolverine
 */
public class FrmConsultaCreditosReceber extends javax.swing.JFrame {
    
    private List<CreditoBean> listaCreditos;
    private List<CreditosProdutosBean> listaProdutos;
    
    private ConsultaCreditosProdutosTableModel modelProdutos;
    private ConsultaCreditosTableModel modelCreditos;
    private DefaultTableCellRenderer rendererCor;
    private IGerarFatura telaFatura;
    private INotaSaidaBean telaNFe;

    /**
     * Creates new form FrmConsultaCreditosReceber
     */
    public FrmConsultaCreditosReceber(List<CreditoBean> listaCreditos, int tipo, IGerarFatura telaFatura) {
        this.listaCreditos = listaCreditos;
        this.telaFatura = telaFatura;
        initComponents();
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
        carregarModelCreditos();
        if (listaCreditos.size()>0){
            carregarModelProdutos(listaCreditos.get(0).getCredito().getIdcreditosReceber());
        }
        if (tipo==1){
            confirmarjButton.setEnabled(false);
            marcarjButton.setEnabled(false);
            desmarcarjButton.setEnabled(false);
        }
        this.setVisible(true);
    }
    
    public FrmConsultaCreditosReceber(List<CreditoBean> listaCreditos, int tipo) {
        this.listaCreditos = listaCreditos;
        this.telaFatura = telaFatura;
        initComponents();
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
        carregarModelCreditos();
        if (listaCreditos.size()>0){
            carregarModelProdutos(listaCreditos.get(0).getCredito().getIdcreditosReceber());
        }
        if (tipo==1){
            confirmarjButton.setEnabled(false);
            marcarjButton.setEnabled(false);
            desmarcarjButton.setEnabled(false);
        }
        this.setVisible(true);
    }
    
    public FrmConsultaCreditosReceber(List<CreditoBean> listaCreditos, int tipo, INotaSaidaBean telaNFe) {
        this.listaCreditos = listaCreditos;
        this.telaNFe = telaNFe;
        initComponents();
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
        carregarModelCreditos();
        if (listaCreditos.size()>0){
            carregarModelProdutos(listaCreditos.get(0).getCredito().getIdcreditosReceber());
        }
        if (tipo==1){
            confirmarjButton.setEnabled(false);
            marcarjButton.setEnabled(false);
            desmarcarjButton.setEnabled(false);
        }
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        creditosjTable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        creditosProdutosjTable = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        confirmarjButton = new javax.swing.JButton();
        marcarjButton = new javax.swing.JButton();
        desmarcarjButton = new javax.swing.JButton();
        fecharjButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta de Creditos");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        creditosjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        creditosjTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                creditosjTableMouseClicked(evt);
            }
        });
        creditosjTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                creditosjTableKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(creditosjTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        creditosProdutosjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Código", "Descrição", "Unidade", "Quantidade", "Valor Unitário", "Valor Total"
            }
        ));
        creditosProdutosjTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                creditosProdutosjTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(creditosProdutosjTable);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 795, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(259, 259, 259))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        confirmarjButton.setText("Confirmar");
        confirmarjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmarjButtonActionPerformed(evt);
            }
        });

        marcarjButton.setText("Marcar Creditos");
        marcarjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                marcarjButtonActionPerformed(evt);
            }
        });

        desmarcarjButton.setText("Desmarcar Creditos");
        desmarcarjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                desmarcarjButtonActionPerformed(evt);
            }
        });

        fecharjButton.setText("Fechar");
        fecharjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fecharjButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(confirmarjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(marcarjButton)
                .addGap(37, 37, 37)
                .addComponent(desmarcarjButton)
                .addGap(67, 67, 67)
                .addComponent(fecharjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirmarjButton)
                    .addComponent(marcarjButton)
                    .addComponent(desmarcarjButton)
                    .addComponent(fecharjButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void creditosjTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_creditosjTableMouseClicked
        int linha = creditosjTable.getSelectedRow();
        if (linha>=0){
            carregarModelProdutos(listaCreditos.get(linha).getCredito().getIdcreditosReceber());
        }
    }//GEN-LAST:event_creditosjTableMouseClicked

    private void creditosProdutosjTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_creditosProdutosjTableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_creditosProdutosjTableMouseClicked

    private void fecharjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fecharjButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_fecharjButtonActionPerformed

    private void marcarjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_marcarjButtonActionPerformed
        int linha = creditosjTable.getSelectedRow();
        if (linha>=0){
            listaCreditos.get(linha).setMarcado("SIM");
        }
    }//GEN-LAST:event_marcarjButtonActionPerformed

    private void desmarcarjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_desmarcarjButtonActionPerformed
        int linha = creditosjTable.getSelectedRow();
        if (linha>=0){
            listaCreditos.get(linha).setMarcado("NAO");
        }
    }//GEN-LAST:event_desmarcarjButtonActionPerformed

    private void creditosjTableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_creditosjTableKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            int linha = creditosjTable.getSelectedRow();
            if (linha>=0){
                if (listaCreditos.get(linha).getMarcado().equalsIgnoreCase("NAO")){
                    listaCreditos.get(linha).setMarcado("SIM");
                }else {
                    listaCreditos.get(linha).setMarcado("NAO");
                }
            }
        }
    }//GEN-LAST:event_creditosjTableKeyPressed

    private void confirmarjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmarjButtonActionPerformed
        if (listaCreditos.size()>0){
            if (telaFatura!=null){
                telaFatura.utilizarCreditos(listaCreditos);
            }else if (telaNFe!=null){
                telaNFe.utilizarCreditos(listaCreditos);
            }
            this.dispose();
        }
    }//GEN-LAST:event_confirmarjButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton confirmarjButton;
    private javax.swing.JTable creditosProdutosjTable;
    private javax.swing.JTable creditosjTable;
    private javax.swing.JButton desmarcarjButton;
    private javax.swing.JButton fecharjButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton marcarjButton;
    // End of variables declaration//GEN-END:variables

    public void carregarModelCreditos(){
        modelCreditos = new ConsultaCreditosTableModel(listaCreditos);
        
         DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.RIGHT);
        
        creditosjTable.setModel(modelCreditos);
        creditosjTable.getColumnModel().getColumn(0).setPreferredWidth(150);
        creditosjTable.getColumnModel().getColumn(1).setPreferredWidth(20);
        creditosjTable.getColumnModel().getColumn(2).setCellRenderer(renderer);
        creditosjTable.getColumnModel().getColumn(2).setPreferredWidth(20);
        creditosjTable.getColumnModel().getColumn(3).setPreferredWidth(50);
        creditosjTable.getColumnModel().getColumn(4).setPreferredWidth(20);
        creditosjTable.getColumnModel().getColumn(5).setCellRenderer(rendererCor);
        creditosjTable.getColumnModel().getColumn(5).setPreferredWidth(10);
        creditosjTable.repaint();
    }
    
    public void carregarModelProdutos(int idCredito){
        CreditoReceberController creditoReceberController = new CreditoReceberController();
        List<Creditoreceberprodutos> listaCreditosProduto  = creditoReceberController.listaCreditoProdutos(idCredito);
        if (listaCreditosProduto!=null){
            listaProdutos = new ArrayList<CreditosProdutosBean>();
            carregarListaProdutosBean(listaCreditosProduto);
        }
        modelProdutos = new ConsultaCreditosProdutosTableModel(listaProdutos);
        
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.RIGHT);
        
        creditosProdutosjTable.setModel(modelProdutos);
        creditosProdutosjTable.getColumnModel().getColumn(0).setPreferredWidth(20);
        creditosProdutosjTable.getColumnModel().getColumn(1).setPreferredWidth(200);
        creditosProdutosjTable.getColumnModel().getColumn(2).setPreferredWidth(20);
        creditosProdutosjTable.getColumnModel().getColumn(3).setCellRenderer(renderer);
        creditosProdutosjTable.getColumnModel().getColumn(3).setPreferredWidth(40);
        creditosProdutosjTable.getColumnModel().getColumn(4).setCellRenderer(renderer);
        creditosProdutosjTable.getColumnModel().getColumn(4).setPreferredWidth(40);
        creditosProdutosjTable.getColumnModel().getColumn(5).setCellRenderer(renderer);
        creditosProdutosjTable.getColumnModel().getColumn(5).setPreferredWidth(20);
        creditosProdutosjTable.repaint();
    }
    
    public void carregarListaProdutosBean(List<Creditoreceberprodutos> listaCreditosProduto){
        for(int i=0;i<listaCreditosProduto.size();i++){
            CreditosProdutosBean creditosProdutosBean = new CreditosProdutosBean(listaCreditosProduto.get(i));
            this.listaProdutos.add(creditosProdutosBean);
        }
    }
}
