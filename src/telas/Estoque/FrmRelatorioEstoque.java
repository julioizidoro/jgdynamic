/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FrmRelatorioData.java
 *
 * Created on 19/09/2011, 15:52:07
 */
package telas.Estoque;

import telas.RelatorioVendas.*;
import com.toedter.calendar.JTextFieldDateEditor;
import controler.Config;
import controler.relatoriosJasper;
import facade.GrupoProdutoFacade;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Fornecedor;
import model.Grupoproduto;
import telas.Fornecedor.FrmConsultaFornecedor;
import telas.Produtos.FrmConsultaProdutos;

/**
 *
 * @author Wolverine
 */
public class FrmRelatorioEstoque extends javax.swing.JFrame {
    
    int tipo;
    private Config config;
    private Grupoproduto grupoProduto;
    private Fornecedor fornecedor;

    /** Creates new form FrmRelatorioData */
    public FrmRelatorioEstoque(int tipo, Config config) {
        this.tipo=tipo;
        this.config = config;
        initComponents();
        URL url = this.getClass().getResource("/imagens/logo_mini.png");
        Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(imagemTitulo);
        this.setLocationRelativeTo(null);
        if (tipo==3){
            preencherGrupoProduto();
            codigojTextField.setEditable(false);
            consultajButton.setEnabled(false);
        }else {
            grupojComboBox.setEnabled(false);
        }
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
        jLabel1 = new javax.swing.JLabel();
        grupojComboBox = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        codigojTextField = new javax.swing.JTextField();
        nomejTextField = new javax.swing.JTextField();
        consultajButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Relatórios");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Fornecedor");

        jLabel3.setText("Grupo");

        nomejTextField.setEditable(false);

        consultajButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/magnifier.png"))); // NOI18N
        consultajButton.setToolTipText("Consultar Fornecedor");
        consultajButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultajButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(grupojComboBox, 0, 297, Short.MAX_VALUE)
                    .addComponent(jLabel3)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(codigojTextField)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(10, 10, 10)
                        .addComponent(consultajButton, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nomejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(codigojTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nomejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addComponent(jLabel3))
                    .addComponent(consultajButton, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(grupojComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/tick.png"))); // NOI18N
        jButton1.setText("Confirmar");
        jButton1.setToolTipText("Confirmar Relatório");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 10, -1, -1));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cross.png"))); // NOI18N
        jButton2.setText("Fechar");
        jButton2.setToolTipText("Fechar Janela");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 90, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        verificarTipoRelatorio();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void consultajButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultajButtonActionPerformed
        new FrmConsultaFornecedor(this);
    }//GEN-LAST:event_consultajButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField codigojTextField;
    private javax.swing.JButton consultajButton;
    private javax.swing.JComboBox grupojComboBox;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField nomejTextField;
    // End of variables declaration//GEN-END:variables

    
    public void verificarTipoRelatorio(){
        if (tipo==1){
            gerarRelatorioFornecedor();
        }else if (tipo==3){
            gerarRelatorioGrupo();
        }
        this.dispose();
    }
    
    
    public void gerarRelatorioFornecedor(){
        
        String url = ("telas/Estoque/reportRelacaoEstoqueFornecedor.jasper");
        Map parameters = new HashMap();
        try {
            parameters.put("nomeFantasia", this.config.getEmpresa().getNomeFantasia());
            parameters.put("RazaoSocial", this.config.getEmpresa().getRazaoSocial());
            parameters.put("idFornecedor", this.fornecedor.getIdfornecedor());
            String fornec = String.valueOf(fornecedor.getIdfornecedor()) + " - " + fornecedor.getRazaoSocial();
            parameters.put("Fornecedor", fornec);
            parameters.put("idEmpresa", this.config.getEmpresa().getIdempresa());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Não foi possível gerar o relatório " + ex);
            ex.printStackTrace();
        }
        new relatoriosJasper(url, parameters);
    }
    
   
    public void gerarRelatorioGrupo() {
        String url = ("telas/Estoque/reportRelacaoEstoqueGrupo.jasper");
        grupoProduto = (Grupoproduto) grupojComboBox.getSelectedItem(); 
        Map parameters = new HashMap();
        try {
            parameters.put("nomeFantasia", this.config.getEmpresa().getNomeFantasia());
            parameters.put("RazaoSocial", this.config.getEmpresa().getRazaoSocial());
            parameters.put("idGrupo", grupoProduto.getIdgrupoProduto());
            parameters.put("idEmpresa", this.config.getEmpresa().getIdempresa());
            String nomeGrupo = String.valueOf(grupoProduto.getIdgrupoProduto()) + " - " + grupoProduto.getDescricao();
            parameters.put("grupoProduto", nomeGrupo);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Não foi possível gerar o relatório " + ex);
            ex.printStackTrace();
        }
        new relatoriosJasper(url, parameters);
    }
    

    public void gerarRelatorioFornecedor(int idFornecedor) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    
    public final void preencherGrupoProduto(){
        GrupoProdutoFacade grupoProdutoFacade = new GrupoProdutoFacade();
        try {
            List<Grupoproduto> listaGrupoProduto = grupoProdutoFacade.listarGrupoProduto();
            for(int i=0;i<listaGrupoProduto.size();i++){
                grupojComboBox.addItem(listaGrupoProduto.get(i));
            }
        } catch (Exception ex) {
            Logger.getLogger(FrmRelatorioEstoque.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void consultarFornecedor(Fornecedor fornecedor){
        this.fornecedor = fornecedor;
        if (fornecedor!=null){
            codigojTextField.setText(String.valueOf(fornecedor.getIdfornecedor()));
            nomejTextField.setText(fornecedor.getRazaoSocial());
        }
    }

}
