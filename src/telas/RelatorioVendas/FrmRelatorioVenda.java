/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FrmRelatorioData.java
 *
 * Created on 19/09/2011, 15:52:07
 */
package telas.RelatorioVendas;

import Regras.DevolucaoController;
import Regras.Formatacao;
import Regras.FornecedorController;
import Regras.ParametroLocalController;
import Regras.ProdutoController;
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
import model.Devolucao;
import model.Fornecedor;
import model.Grupoproduto;
import model.ParametrosLocal;
import model.Produto;
import telas.Fornecedor.FrmConsultaFornecedor;
import telas.Produtos.FrmConsultaProdutos;

/**
 *
 * @author Wolverine
 */
public class FrmRelatorioVenda extends javax.swing.JFrame implements IrelatorioVenda{
    
    private String datePattern;
    private String maskPattern;
    private char placeHolder;
    int tipo;
    private Config config;
    private Grupoproduto grupoProduto;
    private Fornecedor fornecedor;
    private double valorCompra;
    private double valorVenda;
    private Produto produto;

    /** Creates new form FrmRelatorioData */
    public FrmRelatorioVenda(int tipo, Config config) {
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
        if (tipo==3){
            preencherGrupoProduto();
        }else grupojComboBox.setEnabled(false);
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
grupojComboBox = new javax.swing.JComboBox();
jLabel3 = new javax.swing.JLabel();
codigoFornecedorjTextField = new javax.swing.JTextField();
jLabel4 = new javax.swing.JLabel();
consultaFornecedorjButton = new javax.swing.JButton();
razaoSocialjTextField = new javax.swing.JTextField();
jLabel5 = new javax.swing.JLabel();
codigoProdutojTextField = new javax.swing.JTextField();
consultaProdutojButton = new javax.swing.JButton();
descricaojTextField = new javax.swing.JTextField();
jPanel3 = new javax.swing.JPanel();
jButton1 = new javax.swing.JButton();
jButton2 = new javax.swing.JButton();

setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
setTitle("Relatórios");

jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

jLabel1.setText("Data Inicial");

jLabel2.setText("Data Final");

jLabel3.setText("Grupo");

codigoFornecedorjTextField.addKeyListener(new java.awt.event.KeyAdapter() {
    public void keyPressed(java.awt.event.KeyEvent evt) {
        codigoFornecedorjTextFieldKeyPressed(evt);
    }
    });

    jLabel4.setText("Fornecedor");

    consultaFornecedorjButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/magnifier.png"))); // NOI18N
    consultaFornecedorjButton.setToolTipText("Consultar Fornecedor");
    consultaFornecedorjButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            consultaFornecedorjButtonActionPerformed(evt);
        }
    });

    razaoSocialjTextField.setEditable(false);

    jLabel5.setText("Produto");

    codigoProdutojTextField.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyPressed(java.awt.event.KeyEvent evt) {
            codigoProdutojTextFieldKeyPressed(evt);
        }
    });

    consultaProdutojButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/magnifier.png"))); // NOI18N
    consultaProdutojButton.setToolTipText("Consultar Produto");
    consultaProdutojButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            consultaProdutojButtonActionPerformed(evt);
        }
    });

    descricaojTextField.setEditable(false);

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel2Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(grupojComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addComponent(jLabel3)
                    .addGap(0, 0, Short.MAX_VALUE))
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addGap(10, 10, 10))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(codigoFornecedorjTextField)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                    .addComponent(consultaFornecedorjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(razaoSocialjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addComponent(dataIniciojDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(dataFinaljDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)))
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addGap(10, 10, 10))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(codigoProdutojTextField)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                    .addComponent(consultaProdutojButton, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(descricaojTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap())
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
            .addGap(18, 18, 18)
            .addComponent(jLabel5)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codigoProdutojTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(descricaojTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(consultaProdutojButton, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
            .addComponent(jLabel4)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codigoFornecedorjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(razaoSocialjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(consultaFornecedorjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jLabel3)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(grupojComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(29, 29, 29))
    );

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    jPanel1Layout.setVerticalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, Short.MAX_VALUE))
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
    jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 110, -1));

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE))
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addContainerGap())
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap())
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        verificarTipoRelatorio();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void consultaFornecedorjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultaFornecedorjButtonActionPerformed
        new FrmConsultaFornecedor(this);
    }//GEN-LAST:event_consultaFornecedorjButtonActionPerformed

    private void consultaProdutojButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultaProdutojButtonActionPerformed
        new FrmConsultaProdutos(config, false, this);
    }//GEN-LAST:event_consultaProdutojButtonActionPerformed

    private void codigoProdutojTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codigoProdutojTextFieldKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            ProdutoController produtoController = new ProdutoController();
            produto = produtoController.consultarProdutoReferencia(Integer.parseInt(codigoProdutojTextField.getText()));
            gerarRelatorioProduto(produto);
        }
    }//GEN-LAST:event_codigoProdutojTextFieldKeyPressed

    private void codigoFornecedorjTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codigoFornecedorjTextFieldKeyPressed
        FornecedorController fornecedorController = new FornecedorController();
        this.fornecedor = fornecedorController.consultarFornecedor(Integer.parseInt(codigoFornecedorjTextField.getText()));
        consultarFornecedor(fornecedor);
    }//GEN-LAST:event_codigoFornecedorjTextFieldKeyPressed

    /**
     * @param args the command line arguments
     */
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField codigoFornecedorjTextField;
    private javax.swing.JTextField codigoProdutojTextField;
    private javax.swing.JButton consultaFornecedorjButton;
    private javax.swing.JButton consultaProdutojButton;
    private com.toedter.calendar.JDateChooser dataFinaljDateChooser;
    private com.toedter.calendar.JDateChooser dataIniciojDateChooser;
    private javax.swing.JTextField descricaojTextField;
    private javax.swing.JComboBox grupojComboBox;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField razaoSocialjTextField;
    // End of variables declaration//GEN-END:variables

    
    public void verificarTipoRelatorio(){
        if (tipo==1){
            gerarRelatorioSaidaPeriodo();
        }else if (tipo==2){
            imprimirRelatorioProdutos();
        }else if (tipo==3){
            gerarRelatorioGrupo(0);
        }else if (tipo==5){
            gerarRelatorioVendasST();
        }else if (tipo==4){
            gerarRelatorioFornecedor(fornecedor.getIdfornecedor());
        }
    }
    
    
    public void gerarRelatorioSaidaPeriodo(){
        DevolucaoController devolucaoController = new DevolucaoController();
        String dataInicial = Formatacao.ConvercaoDataSql(dataIniciojDateChooser.getDate());
        String dataFinal = Formatacao.ConvercaoDataSql(dataFinaljDateChooser.getDate());
        List<Devolucao> listaDevolucao = devolucaoController.valorDevolucaoPeriodo(dataInicial, dataFinal);
        String url = ("telas/RelatorioVendas/reportSaidaPeriodo.jasper");
        Map parameters = new HashMap();
        try {
            valorCompra =0;
            valorVenda = 0;
            gerarValorDevoluvao(listaDevolucao);
            parameters.put("valorDevolucao", valorVenda);
            parameters.put("valorCompraDevolucao", valorCompra);
            parameters.put("valorDevolucaoCompra", valorCompra);
            parameters.put("nomeFantasia", this.config.getEmpresa().getNomeFantasia());
            parameters.put("RazaoSocial", this.config.getEmpresa().getRazaoSocial());
            parameters.put("dataInicial", dataIniciojDateChooser.getDate());
            parameters.put("dataFinal", dataFinaljDateChooser.getDate());
            parameters.put("idempresa", this.config.getEmpresa().getIdempresa());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Não foi possível gerar o relatório " + ex);
            ex.printStackTrace();
        }
        new relatoriosJasper(url, parameters);
    }
    
    public void gerarRelatorioVendasST(){
        
        String url = ("telas/RelatorioVendas/reportSaidaPeriodoST.jasper");
        Map parameters = new HashMap();
        try {
            parameters.put("valorDevolucao", 0.0);
            parameters.put("nomeFantasia", this.config.getEmpresa().getNomeFantasia());
            parameters.put("RazaoSocial", this.config.getEmpresa().getRazaoSocial());
            parameters.put("dataInicial", dataIniciojDateChooser.getDate());
            parameters.put("dataFinal", dataFinaljDateChooser.getDate());
            parameters.put("idempresa", this.config.getEmpresa().getIdempresa());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Não foi possível gerar o relatório " + ex);
            ex.printStackTrace();
        }
        new relatoriosJasper(url, parameters);
    }
    
    public void gerarValorDevoluvao(List<Devolucao> listaDevolucao) {
        double valor = 0;
        if (listaDevolucao != null) {
            for (int i = 0; i < listaDevolucao.size(); i++) {
                valorVenda = valorVenda + listaDevolucao.get(i).getValorDevolucao();
                valorCompra = valorCompra + listaDevolucao.get(i).getValorCompra();
            }
        }
    }

   
    public void gerarRelatorioProduto(Produto produto) {
         if (produto!=null){
             this.produto = produto;
             descricaojTextField.setText(produto.getDescricao());
             codigoProdutojTextField.setText(String.valueOf(produto.getReferencia()));
             codigoProdutojTextField.selectAll();
             codigoProdutojTextField.requestFocus();
         }
    }
    

    public void gerarRelatorioFornecedor(int idFornecedor) {
        String url = ("telas/RelatorioVendas/reportSaidaFornecedor.jasper");
        Map parameters = new HashMap();
        try {
            parameters.put("valorDevolucao", 0.0);
            parameters.put("nomeFantasia", this.config.getEmpresa().getNomeFantasia());
            parameters.put("RazaoSocial", this.config.getEmpresa().getRazaoSocial());
            parameters.put("dataInicial", dataIniciojDateChooser.getDate());
            parameters.put("dataFinal", dataFinaljDateChooser.getDate());
            parameters.put("idEmpresa", this.config.getEmpresa().getIdempresa());
            parameters.put("idFornecedor", this.fornecedor.getIdfornecedor());
            parameters.put("nomeFornecedor", String.valueOf(this.fornecedor.getIdfornecedor()) + " - " + this.fornecedor.getRazaoSocial());
            parameters.put("idempresa", this.config.getEmpresa().getIdempresa());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Não foi possível gerar o relatório " + ex);
            ex.printStackTrace();
        }
        new relatoriosJasper(url, parameters);
    }

    public void gerarRelatorioGrupo(int idGrupo) {
        String url = ("telas/RelatorioVendas/reportSaidaGrupo.jasper");
        Map parameters = new HashMap();
        this.grupoProduto = (Grupoproduto) grupojComboBox.getSelectedItem();
        try {
            parameters.put("nomeFantasia", this.config.getEmpresa().getNomeFantasia());
            parameters.put("RazaoSocial", this.config.getEmpresa().getRazaoSocial());
            parameters.put("dataInicial", dataIniciojDateChooser.getDate());
            parameters.put("dataFinal", dataFinaljDateChooser.getDate());
            parameters.put("id", grupoProduto.getIdgrupoProduto());
            parameters.put("nomeGrupo", grupoProduto.getDescricao());
            parameters.put("idempresa", this.config.getEmpresa().getIdempresa());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Não foi possível gerar o relatório " + ex);
            ex.printStackTrace();
        }
        new relatoriosJasper(url, parameters);
    }
    
    
    public final void preencherGrupoProduto(){
        GrupoProdutoFacade grupoProdutoFacade = new GrupoProdutoFacade();
        try {
            List<Grupoproduto> listaGrupoProduto = grupoProdutoFacade.listarGrupoProduto();
            for(int i=0;i<listaGrupoProduto.size();i++){
                grupojComboBox.addItem(listaGrupoProduto.get(i));
            }
        } catch (Exception ex) {
            Logger.getLogger(FrmRelatorioVenda.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void consultarFornecedor(Fornecedor fornecedor){
        this.fornecedor = fornecedor;
        codigoFornecedorjTextField.setText(String.valueOf(this.fornecedor.getIdfornecedor()));
        razaoSocialjTextField.setText(this.fornecedor.getRazaoSocial());
    }
    
    public void imprimirRelatorioProdutos(){
        String url = ("telas/RelatorioVendas/reportSaidaProduto.jasper");
        Map parameters = new HashMap();
        try {
            parameters.put("nomeFantasia", this.config.getEmpresa().getNomeFantasia());
            parameters.put("RazaoSocial", this.config.getEmpresa().getRazaoSocial());
            parameters.put("dataInicial", dataIniciojDateChooser.getDate());
            parameters.put("dataFinal", dataFinaljDateChooser.getDate());
            parameters.put("id", produto.getIdProduto());
            parameters.put("idempresa", this.config.getEmpresa().getIdempresa());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Não foi possível gerar o relatório " + ex);
            ex.printStackTrace();
        }
        new relatoriosJasper(url, parameters);
    }

}
