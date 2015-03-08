/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FrmRelatorioData.java
 *
 * Created on 19/09/2011, 15:52:07
 */
package telas.RelatoriosGerenciais;

import Regras.Formatacao;
import com.toedter.calendar.JTextFieldDateEditor;
import controler.Config;
import controler.relatoriosJasper;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author Wolverine
 */
public class FrmRelatorioData extends javax.swing.JFrame {
    
    private String datePattern;
    private String maskPattern;
    private char placeHolder;
    int tipo;
    private Config config;

    /** Creates new form FrmRelatorioData */
    public FrmRelatorioData(int tipo, Config config) {
        datePattern = "dd/MM/yyyy";
        maskPattern = "##/##/####";
        placeHolder = '_';
        this.tipo=tipo;
        this.config = config;
        initComponents();
        URL url = this.getClass().getResource("/imagens/logo_mini.png");
        Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(imagemTitulo);
        this.setLocationRelativeTo(null);
        dataIniciojDateChooser.setDate(new Date());
        dataFinaljDateChooser.setDate(new Date());
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
        dataIniciojDateChooser = new com.toedter.calendar.JDateChooser(null, null, datePattern, new JTextFieldDateEditor(datePattern,
            maskPattern, placeHolder));
    dataFinaljDateChooser = new com.toedter.calendar.JDateChooser(null, null, datePattern, new JTextFieldDateEditor(datePattern,
        maskPattern, placeHolder));
jLabel2 = new javax.swing.JLabel();
jPanel3 = new javax.swing.JPanel();
jButton1 = new javax.swing.JButton();
jButton2 = new javax.swing.JButton();
infojTextField = new javax.swing.JTextField();

setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
setTitle("Relatórios");

jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

jLabel1.setText("Data Inicial");

jLabel2.setText("Data Final");

javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
jPanel2.setLayout(jPanel2Layout);
jPanel2Layout.setHorizontalGroup(
    jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
    .addGroup(jPanel2Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1)
            .addComponent(dataIniciojDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(44, 44, 44)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dataFinaljDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel2))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    jPanel2Layout.setVerticalGroup(
        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel2Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel1)
                .addComponent(jLabel2))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(dataIniciojDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(dataFinaljDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    infojTextField.setEditable(false);
    infojTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    infojTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    infojTextField.setText("Selecione o Período e Confirme....");

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addComponent(infojTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap())
    );
    jPanel1Layout.setVerticalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(infojTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap())
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addContainerGap())
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        infojTextField.setText("Aguarde Gerando Relatório...");
        if (this.tipo==1){
            gerarRelatorioEntradaSaidaEStoque();
        }
        if (this.tipo==2){
            gerarRelatorioRelacaoTransferencia();
        }
        if (this.tipo==3){
            gerarRelatorioAcerto();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser dataFinaljDateChooser;
    private com.toedter.calendar.JDateChooser dataIniciojDateChooser;
    private javax.swing.JTextField infojTextField;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables

    public void gerarRelatorioEntradaSaidaEStoque(){
        String dataInicial = Formatacao.ConvercaoDataSql(dataIniciojDateChooser.getDate());
        String dataFinal = Formatacao.ConvercaoDataSql(dataFinaljDateChooser.getDate());
        GerarRelEntradaSaida relaroeio = new GerarRelEntradaSaida(dataInicial, dataFinal);
        
        String url = ("telas/Estoque/reportEntradaSaida.jasper");
        Map parameters = new HashMap();
        try {
            parameters.put("nomeFantasia", this.config.getEmpresa().getNomeFantasia());
            parameters.put("RazaoSocial", this.config.getEmpresa().getRazaoSocial());
            parameters.put("dataInicial", dataIniciojDateChooser.getDate());
            parameters.put("dataFinal", dataFinaljDateChooser.getDate());
            parameters.put("valorDevolucao", relaroeio.getValorDevolucao());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Não foi possível gerar o relatório " + ex);
            ex.printStackTrace();
        }
        new relatoriosJasper(url, parameters);
        this.dispose();
    }
    
    public void gerarRelatorioRelacaoTransferencia(){
         String url = ("telas/TransferenciaSaida/reportRelacaoTransferencia.jasper");
            Map parameters = new HashMap();
            try {
                parameters.put("dataInicial", dataIniciojDateChooser.getDate());
                parameters.put("dataFinal", dataFinaljDateChooser.getDate());
                parameters.put("nomeFantasia", this.config.getEmpresa().getNomeFantasia());
                parameters.put("RazaoSocial", this.config.getEmpresa().getRazaoSocial());
                parameters.put("idempresa", this.config.getEmpresa().getIdempresa());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Não foi possível gerar o relatório " + ex);
                ex.printStackTrace();
            }
            new relatoriosJasper(url, parameters);
            this.dispose();
    }
    
    public void gerarRelatorioAcerto() {
        String url = ("telas/Estoque/reportRelacaoAcerto.jasper");
        Map parameters = new HashMap();
        try {
            parameters.put("dataInicial", dataIniciojDateChooser.getDate());
            parameters.put("dataFinal", dataFinaljDateChooser.getDate());
            parameters.put("nomeFantasia", this.config.getEmpresa().getNomeFantasia());
            parameters.put("RazaoSocial", this.config.getEmpresa().getRazaoSocial());
            parameters.put("idempresa", this.config.getEmpresa().getIdempresa());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Não foi possível gerar o relatório " + ex);
            ex.printStackTrace();
        }
        new relatoriosJasper(url, parameters);
        this.dispose();
    }

}
