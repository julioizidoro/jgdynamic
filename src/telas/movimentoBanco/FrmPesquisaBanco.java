/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FrmPesquisaContasPagar.java
 *
 * Created on 03/11/2009, 19:04:19
 */
package telas.movimentoBanco;

import Interfaces.ItelaConsulta;
import com.toedter.calendar.JTextFieldDateEditor;
import beanController.NfDuplicatas;
import beanController.NfProdutos;
import beanController.NotaEletronica;
import controler.Sigap;
import facade.MovimentoBancoFacade;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import model.Banco;
import model.Estoque;
import model.Fornecedor;
import model.Movimentobanco;
import model.Planoconta;
import model.Produto;
import telas.PlanoContas.FrmConsultaPlanoContas;

/**
 *
 * @author Gabi
 */
public class FrmPesquisaBanco extends javax.swing.JFrame implements ItelaConsulta{

    private FrmConsultaBanco telaConsuta;
    private String datePattern;
    private String maskPattern;
    private char placeHolder;
    private Banco bancoSelecionado;
    /** Creates new form FrmPesquisaContasPagar */
    public FrmPesquisaBanco(FrmConsultaBanco telaConsulta, Banco bancoSelecionado) {
        this.telaConsuta = telaConsulta;
        this.bancoSelecionado = bancoSelecionado;
        datePattern = "dd/MM/yyyy";
        maskPattern = "##/##/##";
        placeHolder = '_';
        initComponents();
        setLocationRelativeTo(this);
        setVisible(true);
    }

    public FrmPesquisaBanco() {
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
planoContasjPanel = new javax.swing.JPanel();
codigoPlanoContasjTextField = new javax.swing.JTextField();
jLabel1 = new javax.swing.JLabel();
jToolBar1 = new javax.swing.JToolBar();
jButton1 = new javax.swing.JButton();
jToolBar2 = new javax.swing.JToolBar();
jButton3 = new javax.swing.JButton();
jPanel9 = new javax.swing.JPanel();
pesquisarjButton = new javax.swing.JButton();
fecharTelajButton = new javax.swing.JButton();
imprimirjButton = new javax.swing.JButton();

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

    planoContasjPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Plano de Contas"));
    planoContasjPanel.setAutoscrolls(true);
    planoContasjPanel.setEnabled(false);
    planoContasjPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    codigoPlanoContasjTextField.setEnabled(false);
    planoContasjPanel.add(codigoPlanoContasjTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 34, 180, -1));

    jLabel1.setText("Conta");
    planoContasjPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 17, -1, -1));

    jToolBar1.setFloatable(false);
    jToolBar1.setRollover(true);

    jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/magnifier.png"))); // NOI18N
    jButton1.setToolTipText("Pesquisa Plano de Contas");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton1consultaPlanoContas(evt);
        }
    });
    jToolBar1.add(jButton1);

    planoContasjPanel.add(jToolBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 70, 30, 20));

    jToolBar2.setFloatable(false);
    jToolBar2.setRollover(true);

    jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/magnifier.png"))); // NOI18N
    jButton3.setToolTipText("Pesquisa Plano de Contas");
    jButton3.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton3consultaPlanoContas(evt);
        }
    });
    jToolBar2.add(jButton3);

    planoContasjPanel.add(jToolBar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 34, 30, 20));

    jPanel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());
    jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    pesquisarjButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/magnifier.png"))); // NOI18N
    pesquisarjButton.setText("Pesquisar");
    pesquisarjButton.setToolTipText("Pesquisar");
    pesquisarjButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            pesquisarjButtonActionPerformed(evt);
        }
    });
    jPanel9.add(pesquisarjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

    fecharTelajButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cross.png"))); // NOI18N
    fecharTelajButton.setText("Fechar");
    fecharTelajButton.setToolTipText("Fechar");
    fecharTelajButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            fecharTelajButtonActionPerformed(evt);
        }
    });
    jPanel9.add(fecharTelajButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 100, -1));

    imprimirjButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/printer.png"))); // NOI18N
    imprimirjButton.setText("Pesquisar");
    imprimirjButton.setToolTipText("Pesquisar");
    imprimirjButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            imprimirjButtonActionPerformed(evt);
        }
    });
    jPanel9.add(imprimirjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

    javax.swing.GroupLayout pesquisaContasPagarjPanelLayout = new javax.swing.GroupLayout(pesquisaContasPagarjPanel);
    pesquisaContasPagarjPanel.setLayout(pesquisaContasPagarjPanelLayout);
    pesquisaContasPagarjPanelLayout.setHorizontalGroup(
        pesquisaContasPagarjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(pesquisaContasPagarjPanelLayout.createSequentialGroup()
            .addContainerGap()
            .addGroup(pesquisaContasPagarjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(dataEmissaojPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                .addComponent(planoContasjPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 248, Short.MAX_VALUE)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap())
    );
    pesquisaContasPagarjPanelLayout.setVerticalGroup(
        pesquisaContasPagarjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pesquisaContasPagarjPanelLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(dataEmissaojPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(planoContasjPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(90, 90, 90))
    );

    getContentPane().add(pesquisaContasPagarjPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, 220));

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1consultaPlanoContas(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1consultaPlanoContas
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1consultaPlanoContas

    private void jButton2consultaPlanoContas(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2consultaPlanoContas
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2consultaPlanoContas

    private void fecharTelajButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fecharTelajButtonActionPerformed
        this.dispose();
}//GEN-LAST:event_fecharTelajButtonActionPerformed

    private void jButton3consultaPlanoContas(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3consultaPlanoContas
       new FrmConsultaPlanoContas(this);
    }//GEN-LAST:event_jButton3consultaPlanoContas

    private void pesquisarjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisarjButtonActionPerformed
        try {
            if (validarPesquisaBanco()) {
                DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
                String idata = df.format(dataIniciojDateChooser.getDate());
                String fdata = df.format(dataFinaljDateChooser.getDate());
                List<Movimentobanco> listaCaixas = new ArrayList<Movimentobanco>();
                MovimentoBancoFacade facade = new MovimentoBancoFacade();
                if ((dataIniciojDateChooser.getDate().toString().length() > 0) &&
                        (dataFinaljDateChooser.getDate().toString().length() > 0)) {
                    if (codigoPlanoContasjTextField.getText().length() > 0) {
                        listaCaixas = facade.MovimentoBanco(idata, fdata, Integer.parseInt(codigoPlanoContasjTextField.getText()), bancoSelecionado );
                    } else {
                        listaCaixas = facade.consutlarMovimentoBanco(idata, fdata, bancoSelecionado);
                    }
                    telaConsuta.setData(listaCaixas);
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro na Pesquisa do Caixa\n" + ex);
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

    private void imprimirjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imprimirjButtonActionPerformed
        String url = null;
        Sigap utilitario = new Sigap();
        Map parameters = new HashMap();
        if ((dataIniciojDateChooser.getDate() != null) &&
            (dataFinaljDateChooser.getDate() != null)) {
            try {
                parameters.put("idata", utilitario.getConverteDatas(utilitario.ConvercaoData(dataIniciojDateChooser.getDate())));
                parameters.put("fdata", utilitario.getConverteDatas(utilitario.ConvercaoData(dataFinaljDateChooser.getDate())));
                MovimentoBancoFacade facade = new MovimentoBancoFacade();
                DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
                List<Double> saldo= facade.calculaSaldos(df.format(dataIniciojDateChooser.getDate()), df.format(dataFinaljDateChooser.getDate()), bancoSelecionado);
                parameters.put("anterior", saldo.get(0) - saldo.get(1));
                parameters.put("ent", saldo.get(2));
                parameters.put("sai", saldo.get(3));
                parameters.put("atual", (saldo.get(0) - saldo.get(1)) + (saldo.get(2) - saldo.get(3)));
            } catch (Exception ex) {
                Logger.getLogger(FrmPesquisaBanco.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            url = ("caixa/relatorios/movimentoCaixa.jasper");
            if (codigoPlanoContasjTextField.getText().length() > 0) {
                url = (" ");

            }
      //      new relatoriosJasper(url, configura, parameters);
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um tipo de relatório");
        }
    }//GEN-LAST:event_imprimirjButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField codigoPlanoContasjTextField;
    private javax.swing.JPanel dataEmissaojPanel;
    private javax.swing.JLabel dataFinalEmissaojLabel;
    private com.toedter.calendar.JDateChooser dataFinaljDateChooser;
    private javax.swing.JLabel dataInicioEmissaojLabel;
    private com.toedter.calendar.JDateChooser dataIniciojDateChooser;
    private javax.swing.JButton fecharTelajButton;
    private javax.swing.JButton imprimirjButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JPanel pesquisaContasPagarjPanel;
    private javax.swing.JButton pesquisarjButton;
    private javax.swing.JPanel planoContasjPanel;
    private javax.swing.ButtonGroup situacaoPagamentobuttonGroup;
    private javax.swing.ButtonGroup tipoPesquisabuttonGroup;
    // End of variables declaration//GEN-END:variables
    private Planoconta conta = new Planoconta();

    public void setData(Object objeto) {
        conta = (Planoconta) objeto;
        if (conta!=null){
            codigoPlanoContasjTextField.setText(conta.getNumeroConta());
        }
    }

    public boolean validarPesquisaBanco(){
        if (dataIniciojDateChooser.getDate()==null){
            JOptionPane.showMessageDialog(null, "Data inicial inválida");
            return false;
        }else if (dataFinaljDateChooser.getDate()==null){
            JOptionPane.showMessageDialog(null, "Data final inválida");
            return false;
        }
        return true;
    }

    public void setBanco(Banco banco) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setModelProduto() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setNFe() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setNFe(List<NfProdutos> listaProdutos, List<NfDuplicatas> listaDuplicatas, NotaEletronica nota, Fornecedor fornecedor) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setAlterarValorVenda(Estoque estoque) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setModelProduto(Produto produto, Estoque estoque) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setFornecedor(Object objeto) {
        throw new UnsupportedOperationException("Not supported yet.");
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
