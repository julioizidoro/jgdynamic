/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FrmRelatorioDevolucao.java
 *
 * Created on 13/09/2011, 13:25:24
 */
package telas.Devolucao;

import Interfaces.IdevolucaoRelatorio;
import Regras.DevolucaoController;
import Regras.Formatacao;
import com.toedter.calendar.JTextFieldDateEditor;
import controler.Config;
import controler.relatoriosJasper;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import telas.Produtos.FrmConsultaProdutos;
import view.Viewrelatoriodevolucao;

/**
 *
 * @author Wolverine
 */
public class FrmRelatorioDevolucao extends javax.swing.JFrame implements IdevolucaoRelatorio{

    /** Creates new form FrmRelatorioDevolucao */
    private String tipoRelatorio;
    private String datePattern;
    private String maskPattern;
    private char placeHolder;
    private String dataInicial;
    private String dataFinal;
    private Config config;
    private double totalGraral;
    private int numeroItens;
    private List<Viewrelatoriodevolucao> listaRelatorioDevolucao;
    
    public FrmRelatorioDevolucao(String tipoRelatorio, Config config) {
        this.tipoRelatorio = tipoRelatorio;
        datePattern = "dd/MM/yyyy";
        maskPattern = "##/##/####";
        placeHolder = '_';
        this.config = config;
        listaRelatorioDevolucao = new ArrayList<Viewrelatoriodevolucao>();
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
        dataIniciojDateChooser = new com.toedter.calendar.JDateChooser(null, null, datePattern, new JTextFieldDateEditor(datePattern,
            maskPattern, placeHolder));
    dataFinaljDateChooser = new com.toedter.calendar.JDateChooser(null, null, datePattern, new JTextFieldDateEditor(datePattern,
        maskPattern, placeHolder));
jLabel2 = new javax.swing.JLabel();
jLabel1 = new javax.swing.JLabel();
jPanel3 = new javax.swing.JPanel();
jButton1 = new javax.swing.JButton();
jButton2 = new javax.swing.JButton();

setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
setTitle("Relatório de Devolução");

jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

jLabel2.setText("Data Final");

jLabel1.setText("Data Inicial");

javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
jPanel2.setLayout(jPanel2Layout);
jPanel2Layout.setHorizontalGroup(
    jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
    .addGroup(jPanel2Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1)
            .addComponent(dataIniciojDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(18, 18, 18)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dataFinaljDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel2))
        .addContainerGap(32, Short.MAX_VALUE))
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
                .addComponent(dataFinaljDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(dataIniciojDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

    jButton1.setText("Gerar Relatório");
    jButton1.setToolTipText("Gerar Relatório");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton1ActionPerformed(evt);
        }
    });

    jButton2.setText("Fechar");
    jButton2.setToolTipText("Fechar Geração de Relatório");
    jButton2.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton2ActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
    jPanel3.setLayout(jPanel3Layout);
    jPanel3Layout.setHorizontalGroup(
        jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel3Layout.createSequentialGroup()
            .addGap(20, 20, 20)
            .addComponent(jButton1)
            .addGap(36, 36, 36)
            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(26, Short.MAX_VALUE))
    );
    jPanel3Layout.setVerticalGroup(
        jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel3Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jButton1)
                .addComponent(jButton2))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    jPanel1Layout.setVerticalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (validarDatas()){
            DevolucaoController devolucaoController = new DevolucaoController();
            if (tipoRelatorio.equalsIgnoreCase("periodo")){
                listaRelatorioDevolucao = devolucaoController.relatorioDevolucao(dataInicial, dataFinal, 0, "");
                gerarRelatorioPeriodo();
            }else if (tipoRelatorio.equalsIgnoreCase("A VISTA")){
                listaRelatorioDevolucao = devolucaoController.relatorioDevolucao(dataInicial, dataFinal, 0, "A VISTA");
                gerarRelatorioCondicao();
            }else if (tipoRelatorio.equalsIgnoreCase("A PRAZO")){
                listaRelatorioDevolucao = devolucaoController.relatorioDevolucao(dataInicial, dataFinal, 0, "A PRAZO");
                gerarRelatorioCondicao();
            }else if (tipoRelatorio.equalsIgnoreCase("produto")){
                new FrmConsultaProdutos(this, this.config);
            }
            this.dispose();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
  
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser dataFinaljDateChooser;
    private com.toedter.calendar.JDateChooser dataIniciojDateChooser;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables

    public boolean validarDatas(){
        if (dataIniciojDateChooser.getDate()!=null){
            dataInicial = Formatacao.ConvercaoDataSql(dataIniciojDateChooser.getDate());
        }else {
            JOptionPane.showMessageDialog(rootPane, "Data Inicial não é válida");
            return false;
        }
        if (dataFinaljDateChooser.getDate()!=null){
            dataFinal = Formatacao.ConvercaoDataSql(dataFinaljDateChooser.getDate());
        }else{
            JOptionPane.showMessageDialog(rootPane, "Data Final não é válida");
            return false;
        }
        return true;
    }
    
    
    public void gerarRelatorioPeriodo(){
        String url = ("telas/Devolucao/reportDevolucaoPeriodo.jasper");
        Map parameters = new HashMap();
        try {
            parameters.put("nomeFantasia", this.config.getEmpresa().getNomeFantasia());
            parameters.put("RazaoSocial", this.config.getEmpresa().getRazaoSocial());
            parameters.put("dataInicial", dataIniciojDateChooser.getDate());
            parameters.put("dataFinal", dataFinaljDateChooser.getDate());
            parameters.put("condicao", "TODAS");
            parameters.put("idempresa", this.config.getEmpresa().getIdempresa());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Não foi possível gerar o relatório " + ex);
            ex.printStackTrace();
        }
        new relatoriosJasper(url, parameters);

    }
    
    public void gerarRelatorioCondicao(){
        String url = ("telas/Devolucao/reportDevolucaoCondicao.jasper");
        Map parameters = new HashMap();
        try {
            parameters.put("nomeFantasia", this.config.getEmpresa().getNomeFantasia());
            parameters.put("RazaoSocial", this.config.getEmpresa().getRazaoSocial());
            parameters.put("dataInicial", dataIniciojDateChooser.getDate());
            parameters.put("dataFinal", dataFinaljDateChooser.getDate());
            parameters.put("condicao", tipoRelatorio);
            parameters.put("idempresa", this.config.getEmpresa().getIdempresa());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Não foi possível gerar o relatório " + ex);
            ex.printStackTrace();
        }
        new relatoriosJasper(url, parameters);

    }
    
    public void gerarRelatorioProduto(int idProduto){
        String url = ("telas/Devolucao/reportDevolucaoProduto.jasper");
        Map parameters = new HashMap();
        try {
            parameters.put("nomeFantasia", this.config.getEmpresa().getNomeFantasia());
            parameters.put("RazaoSocial", this.config.getEmpresa().getRazaoSocial());
            parameters.put("dataInicial", dataIniciojDateChooser.getDate());
            parameters.put("dataFinal", dataFinaljDateChooser.getDate());
            parameters.put("totalGeral", totalGraral);
            parameters.put("numeroItens", numeroItens);
            parameters.put("produto", idProduto);
            parameters.put("idempresa", this.config.getEmpresa().getIdempresa());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Não foi possível gerar o relatório " + ex);
            ex.printStackTrace();
        }
        new relatoriosJasper(url, parameters);

    }

    public void setProduto(int idProduto) {
        DevolucaoController devolucaoController = new DevolucaoController();
        listaRelatorioDevolucao = devolucaoController.relatorioDevolucao(dataInicial, dataFinal, idProduto, "");
        gerarRelatorioProduto(idProduto);
    }
    
    

}
