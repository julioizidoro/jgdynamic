/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FrmPesquisaContasPagar.java
 *
 * Created on 03/11/2009, 19:04:19
 */
package telas.movimentoCaixa;

import com.toedter.calendar.JTextFieldDateEditor;
import Interfaces.ItelaModel;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author Gabi
 */
public class FrmRelatorioData extends javax.swing.JFrame {

    private ItelaModel telaConsulta;
    private String datePattern;
    private String maskPattern;
    private char placeHolder;
    
    /** Creates new form FrmPesquisaContasPagar */
    public FrmRelatorioData(ItelaModel telaConsulta) {
        this.telaConsulta = telaConsulta;
        datePattern = "dd/MM/yyyy";
        maskPattern = "##/##/##";
        placeHolder = '_';
        initComponents();
        setLocationRelativeTo(this);
        setVisible(true);
    }

   

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tipoPesquisabuttonGroup = new javax.swing.ButtonGroup();
        situacaoPagamentobuttonGroup = new javax.swing.ButtonGroup();
        jButton2 = new javax.swing.JButton();
        pesquisaContasPagarjPanel = new javax.swing.JPanel();
        dataEmissaojPanel = new javax.swing.JPanel();
        dataInicioEmissaojLabel = new javax.swing.JLabel();
        dataFinalEmissaojLabel = new javax.swing.JLabel();
        dataIniciojDateChooser = new com.toedter.calendar.JDateChooser(null, null, datePattern, new JTextFieldDateEditor(datePattern,
            maskPattern, placeHolder));
    dataFinaljDateChooser = new com.toedter.calendar.JDateChooser(null, null, datePattern, new JTextFieldDateEditor(datePattern,
        maskPattern, placeHolder));
jPanel9 = new javax.swing.JPanel();
pesquisarjButton = new javax.swing.JButton();
fecharTelajButton = new javax.swing.JButton();

jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/magnifier.png"))); // NOI18N
jButton2.setToolTipText("Pesquisa Plano de Contas");
jButton2.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton2consultaPlanoContas(evt);
    }
    });

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    setTitle("Pesquisa de Caixa");
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
    pesquisaContasPagarjPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

    dataEmissaojPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Data Lançamento"));
    dataEmissaojPanel.setAutoscrolls(true);
    dataEmissaojPanel.setEnabled(false);
    dataEmissaojPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    dataInicioEmissaojLabel.setText("Data Inicio");
    dataEmissaojPanel.add(dataInicioEmissaojLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 23, -1, -1));

    dataFinalEmissaojLabel.setText("Data Final");
    dataEmissaojPanel.add(dataFinalEmissaojLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 23, -1, -1));

    dataIniciojDateChooser.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
        public void propertyChange(java.beans.PropertyChangeEvent evt) {
            dataIniciojDateChooserPropertyChange(evt);
        }
    });
    dataEmissaojPanel.add(dataIniciojDateChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 100, -1));

    dataFinaljDateChooser.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
        public void propertyChange(java.beans.PropertyChangeEvent evt) {
            dataFinaljDateChooserPropertyChange(evt);
        }
    });
    dataEmissaojPanel.add(dataFinaljDateChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 100, -1));

    jPanel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());
    jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    pesquisarjButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/printer.png"))); // NOI18N
    pesquisarjButton.setText("Imprimir");
    pesquisarjButton.setToolTipText("Imprimir");
    pesquisarjButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            pesquisarjButtonActionPerformed(evt);
        }
    });
    jPanel9.add(pesquisarjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

    fecharTelajButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cross.png"))); // NOI18N
    fecharTelajButton.setText("Fechar");
    fecharTelajButton.setToolTipText("Fechar");
    fecharTelajButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            fecharTelajButtonActionPerformed(evt);
        }
    });
    jPanel9.add(fecharTelajButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 100, -1));

    javax.swing.GroupLayout pesquisaContasPagarjPanelLayout = new javax.swing.GroupLayout(pesquisaContasPagarjPanel);
    pesquisaContasPagarjPanel.setLayout(pesquisaContasPagarjPanelLayout);
    pesquisaContasPagarjPanelLayout.setHorizontalGroup(
        pesquisaContasPagarjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(pesquisaContasPagarjPanelLayout.createSequentialGroup()
            .addContainerGap()
            .addGroup(pesquisaContasPagarjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(dataEmissaojPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap())
    );
    pesquisaContasPagarjPanelLayout.setVerticalGroup(
        pesquisaContasPagarjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pesquisaContasPagarjPanelLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(dataEmissaojPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(168, 168, 168))
    );

    getContentPane().add(pesquisaContasPagarjPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, 140));

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2consultaPlanoContas(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2consultaPlanoContas
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2consultaPlanoContas

    private void fecharTelajButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fecharTelajButtonActionPerformed
        this.dispose();
}//GEN-LAST:event_fecharTelajButtonActionPerformed

    private void pesquisarjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisarjButtonActionPerformed
        if (validarPesquisaCaixa()){
            this.telaConsulta.imprimirData(dataIniciojDateChooser.getDate(), dataFinaljDateChooser.getDate());
            this.dispose();
        }
    }//GEN-LAST:event_pesquisarjButtonActionPerformed

    private void dataIniciojDateChooserPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dataIniciojDateChooserPropertyChange
        if ((dataIniciojDateChooser.getDate() != null) && (dataFinaljDateChooser.getDate()!= null) ){
            if (dataIniciojDateChooser.getDate().after(dataFinaljDateChooser.getDate())){
                JOptionPane.showMessageDialog(null,"Data Inicial maior que Data de Final");
                dataIniciojDateChooser.setDate(null);
                dataIniciojDateChooser.grabFocus();
                dataFinaljDateChooser.setDate(null);
            }
        }
}//GEN-LAST:event_dataIniciojDateChooserPropertyChange

    private void dataFinaljDateChooserPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dataFinaljDateChooserPropertyChange
        if ((dataIniciojDateChooser.getDate() != null) && (dataFinaljDateChooser.getDate()!= null) ){
            if (dataIniciojDateChooser.getDate().after(dataFinaljDateChooser.getDate())){
                JOptionPane.showMessageDialog(null,"Data Inicial maior que Data de Final");
                dataIniciojDateChooser.setDate(null);
                dataIniciojDateChooser.grabFocus();
                dataFinaljDateChooser.setDate(null);
            }
        }
}//GEN-LAST:event_dataFinaljDateChooserPropertyChange

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel dataEmissaojPanel;
    private javax.swing.JLabel dataFinalEmissaojLabel;
    private com.toedter.calendar.JDateChooser dataFinaljDateChooser;
    private javax.swing.JLabel dataInicioEmissaojLabel;
    private com.toedter.calendar.JDateChooser dataIniciojDateChooser;
    private javax.swing.JButton fecharTelajButton;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel pesquisaContasPagarjPanel;
    private javax.swing.JButton pesquisarjButton;
    private javax.swing.ButtonGroup situacaoPagamentobuttonGroup;
    private javax.swing.ButtonGroup tipoPesquisabuttonGroup;
    // End of variables declaration//GEN-END:variables
  

    public boolean validarPesquisaCaixa(){
        if (dataIniciojDateChooser.getDate()==null){
            JOptionPane.showMessageDialog(null, "Data inicial inválida");
            return false;
        }else if (dataFinaljDateChooser.getDate()==null){
            JOptionPane.showMessageDialog(null, "Data final inválida");
            return false;
        }
        return true;
    }

   
}
