/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FrmCadastrarContaPagar.java
 *
 * Created on 09/02/2012, 07:45:25
 */
package telas.ContasPagar;

import Interfaces.ItelaConsulta;
import Regras.ContasPagarController;
import Regras.Formatacao;
import Regras.PlanoContaController;
import beanController.NfDuplicatas;
import beanController.NfProdutos;
import beanController.NotaEletronica;
import com.toedter.calendar.JTextFieldDateEditor;
import controler.Config;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.File;
import java.net.URL;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import model.*;
import telas.Fornecedor.FrmConsultaFornecedor;
import telas.PlanoContas.FrmConsultaPlanoContas;


/**
 *
 * @author Wolverine
 */
public class FrmCadastrarContaPagar extends javax.swing.JFrame implements ItelaConsulta{

    /** Creates new form FrmCadastrarContaPagar */
    
    private Contaspagar contasPagar;
    private String datePattern;
    private String maskPattern;
    private char placeHolder;
    Config config;
    IContasPagar telaConsulta;
    Planoconta planoConta;
    private Fornecedor fornecedor;
    
    public FrmCadastrarContaPagar(Config config, Contaspagar contasPagar, IContasPagar telaConsulta, int tipo) {
        datePattern = "dd/MM/yyyy";
        maskPattern = "##/##/##";
        placeHolder = '_';
        this.config = config;
        this.contasPagar = contasPagar;
        this.telaConsulta = telaConsulta;
        initComponents();
        datalancamentojDateChooser.setDate(new Date());
        if (this.contasPagar!=null){
            preencherCampos();
            if (tipo==1){
                funcaoVisualizar();
            }
        }else {
            this.contasPagar = new Contaspagar();
        }
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
        jLabel1 = new javax.swing.JLabel();
        numeroDocumentojTextField = new javax.swing.JTextField();
        datalancamentojDateChooser = new com.toedter.calendar.JDateChooser(null, null, datePattern, new JTextFieldDateEditor(datePattern,
            maskPattern, placeHolder));
    jLabel2 = new javax.swing.JLabel();
    dataVencimentojDateChooser = new com.toedter.calendar.JDateChooser(null, null, datePattern, new JTextFieldDateEditor(datePattern,
        maskPattern, placeHolder));
jLabel3 = new javax.swing.JLabel();
jLabel4 = new javax.swing.JLabel();
credorjTextField = new javax.swing.JTextField();
jLabel5 = new javax.swing.JLabel();
valorContajTextField = new javax.swing.JTextField();
jLabel6 = new javax.swing.JLabel();
planoContajTextField = new javax.swing.JTextField();
descricaoplanoContajTextField = new javax.swing.JTextField();
jLabel7 = new javax.swing.JLabel();
tipoPagamentojComboBox = new javax.swing.JComboBox();
jLabel8 = new javax.swing.JLabel();
observacaojTextField = new javax.swing.JTextField();
jLabel9 = new javax.swing.JLabel();
boletoEntreguejComboBox = new javax.swing.JComboBox();
jPanel4 = new javax.swing.JPanel();
salvarjButton2 = new javax.swing.JButton();
jButton2 = new javax.swing.JButton();
salvarjButton3 = new javax.swing.JButton();

setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
setTitle("Cadastrar Contas a Pagar");

jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

jLabel1.setText("Nº Documento");

datalancamentojDateChooser.addFocusListener(new java.awt.event.FocusAdapter() {
    public void focusGained(java.awt.event.FocusEvent evt) {
        datalancamentojDateChooserFocusGained(evt);
    }
    });

    jLabel2.setText("Data Lançamento");

    dataVencimentojDateChooser.addFocusListener(new java.awt.event.FocusAdapter() {
        public void focusGained(java.awt.event.FocusEvent evt) {
            dataVencimentojDateChooserFocusGained(evt);
        }
    });

    jLabel3.setText("Data Vencimento");

    jLabel4.setText("Credor (Se for Fornecedor tem que Consultar com F2)");

    credorjTextField.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyPressed(java.awt.event.KeyEvent evt) {
            credorjTextFieldKeyPressed(evt);
        }
    });

    jLabel5.setText("Valor da Conta R$");

    valorContajTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
    valorContajTextField.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyReleased(java.awt.event.KeyEvent evt) {
            valorContajTextFieldKeyReleased(evt);
        }
    });

    jLabel6.setText("Plano de Conta (Pressione F2 para Consultar)");

    planoContajTextField.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyPressed(java.awt.event.KeyEvent evt) {
            planoContajTextFieldKeyPressed(evt);
        }
    });

    descricaoplanoContajTextField.setEditable(false);

    jLabel7.setText("Tipo de Pagamento");

    tipoPagamentojComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Boleto", "Carteira", "Cheque", "Debito Conta" }));

    jLabel8.setText("Observação");

    jLabel9.setText("Boleto Entregue");

    boletoEntreguejComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "NAO", "SIM" }));

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(numeroDocumentojTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1))
                    .addGap(28, 28, 28)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(datalancamentojDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3)
                            .addGap(19, 19, 19))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addComponent(dataVencimentojDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(credorjTextField, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(valorContajTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(planoContajTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(jLabel9)
                                .addComponent(boletoEntreguejComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(observacaojTextField, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(descricaoplanoContajTextField, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(tipoPagamentojComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel8)
                                        .addComponent(jLabel7))
                                    .addGap(0, 0, Short.MAX_VALUE)))))
                    .addGap(23, 23, 23))
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel4)
                        .addComponent(jLabel6))
                    .addContainerGap())))
    );
    jPanel1Layout.setVerticalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel1)
                .addComponent(jLabel2)
                .addComponent(jLabel3))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(numeroDocumentojTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(datalancamentojDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(dataVencimentojDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jLabel4)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(credorjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jLabel6)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(planoContajTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(descricaoplanoContajTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel5)
                .addComponent(jLabel7))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(valorContajTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(tipoPagamentojComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel8)
                .addComponent(jLabel9))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(observacaojTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(boletoEntreguejComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
    jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    salvarjButton2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
    salvarjButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/tick.png"))); // NOI18N
    salvarjButton2.setText("Futuras");
    salvarjButton2.setToolTipText("Gerar Contas para o Ano Corrente");
    salvarjButton2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    salvarjButton2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
    salvarjButton2.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            salvarjButton2ActionPerformed(evt);
        }
    });
    jPanel4.add(salvarjButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, -1, -1));

    jButton2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
    jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cross.png"))); // NOI18N
    jButton2.setText("Fechar");
    jButton2.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton2ActionPerformed(evt);
        }
    });
    jPanel4.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, -1, -1));

    salvarjButton3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
    salvarjButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/tick.png"))); // NOI18N
    salvarjButton3.setText("Salvar");
    salvarjButton3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    salvarjButton3.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
    salvarjButton3.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            salvarjButton3ActionPerformed(evt);
        }
    });
    jPanel4.add(salvarjButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void datalancamentojDateChooserFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_datalancamentojDateChooserFocusGained

    }//GEN-LAST:event_datalancamentojDateChooserFocusGained

    private void dataVencimentojDateChooserFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dataVencimentojDateChooserFocusGained

    }//GEN-LAST:event_dataVencimentojDateChooserFocusGained

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void salvarjButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarjButton2ActionPerformed
        if (validarCampos()) {
            gerarContasFuturas();
        }
    }//GEN-LAST:event_salvarjButton2ActionPerformed

    private void planoContajTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_planoContajTextFieldKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_F2){
            new FrmConsultaPlanoContas(this);
        }
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            PlanoContaController planoContaController = new PlanoContaController();
            this.planoConta = new Planoconta();
            this.planoConta = planoContaController.consultarPlanocontaNuemroConta(planoContajTextField.getText());
            if (this.planoConta==null){
                descricaoplanoContajTextField.setText("Conta não Cadastrado");
            }else {
                planoContajTextField.setText(this.planoConta.getNumeroConta());
                descricaoplanoContajTextField.setText(this.planoConta.getDescricao());
            }
        }
    }//GEN-LAST:event_planoContajTextFieldKeyPressed

    private void credorjTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_credorjTextFieldKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_F2){
            new FrmConsultaFornecedor(this);
        }
    }//GEN-LAST:event_credorjTextFieldKeyPressed

    private void valorContajTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_valorContajTextFieldKeyReleased
        valorContajTextField.setText(Formatacao.decinalValorMonetario(valorContajTextField.getText()));
    }//GEN-LAST:event_valorContajTextFieldKeyReleased

    private void salvarjButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarjButton3ActionPerformed
        if (validarCampos()) {
            salvarContaPagar();
            this.dispose();
        }
    }//GEN-LAST:event_salvarjButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox boletoEntreguejComboBox;
    private javax.swing.JTextField credorjTextField;
    private com.toedter.calendar.JDateChooser dataVencimentojDateChooser;
    private com.toedter.calendar.JDateChooser datalancamentojDateChooser;
    private javax.swing.JTextField descricaoplanoContajTextField;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField numeroDocumentojTextField;
    private javax.swing.JTextField observacaojTextField;
    private javax.swing.JTextField planoContajTextField;
    private javax.swing.JButton salvarjButton2;
    private javax.swing.JButton salvarjButton3;
    private javax.swing.JComboBox tipoPagamentojComboBox;
    private javax.swing.JTextField valorContajTextField;
    // End of variables declaration//GEN-END:variables
    
    private void preencherCampos(){
        numeroDocumentojTextField.setText(contasPagar.getNumeroDocumento());
        datalancamentojDateChooser.setDate(contasPagar.getDataLancamento());
        dataVencimentojDateChooser.setDate(contasPagar.getDataVencimento());
        credorjTextField.setText(contasPagar.getCredor());
        consultaPalnoContas(contasPagar.getPlanoconta());
        if (planoConta!=null){
            planoContajTextField.setText(planoConta.getNumeroConta());
            descricaoplanoContajTextField.setText(planoConta.getDescricao());
        }
        valorContajTextField.setText(Formatacao.foramtarDoubleString(contasPagar.getValorConta()));
        tipoPagamentojComboBox.setSelectedItem(contasPagar.getTipoPagamento());
        observacaojTextField.setText(contasPagar.getObservacao());
    }
    
    private void funcaoVisualizar(){
        numeroDocumentojTextField.setEditable(false);
        datalancamentojDateChooser.setEnabled(false);
        dataVencimentojDateChooser.setEnabled(false);
        credorjTextField.setEditable(false);
        planoContajTextField.setEditable(false);;
        descricaoplanoContajTextField.setEditable(false);
        valorContajTextField.setEditable(false);
        tipoPagamentojComboBox.setEditable(false);
        observacaojTextField.setEditable(false);
        salvarjButton2.setEnabled(false);
    }
    
    private void consultaPalnoContas(int idPlanoContas){
        PlanoContaController planoContaController = new PlanoContaController();
        planoConta= planoContaController.consultarPlanoconta(idPlanoContas);
    }

    public void setData(Object objeto) {
        
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
        this.fornecedor = new Fornecedor();
        fornecedor = (Fornecedor) objeto;
        if (fornecedor!=null){
            credorjTextField.setText(fornecedor.getRazaoSocial());
        }
    }

    public void setForPedido(Object objeto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public boolean validarCampos(){
        String erros = "";
        boolean retorno = true;
        if (dataVencimentojDateChooser.getDate()==null){
            retorno = false;
            erros = erros + "Data Vencimento não é válida\\n";
        }
        if (datalancamentojDateChooser.getDate()==null){
            erros = erros +  "Data Lançamento não é válida\\n";
            retorno = false;
        }
        if (credorjTextField.getText().length()<=0){
            erros = erros +  "Campo credor não preenchido\\n";
            retorno = false;
        }
        if (this.planoConta==null){
            erros = erros + "Plano de conta não selecionado\\n";
            retorno = false;
        }
        if (valorContajTextField.getText().length()<=0){
            erros = erros + "Valor da Conta dever ser preenchido";
        }
        if (retorno==false){
            JOptionPane.showMessageDialog(rootPane, erros);
        }
        return retorno;
    }
    
    private void gerarDataReal(){
        int dia = Formatacao.gerarDiaSemana(this.contasPagar.getDataVencimento());
        if (dia==1){
            this.contasPagar.setDataReal(Formatacao.SomarDiasData(this.contasPagar.getDataVencimento(), 1));
        }else if (dia==7){
            this.contasPagar.setDataReal(Formatacao.SomarDiasData(this.contasPagar.getDataVencimento(), 2));
        }else {
            this.contasPagar.setDataReal(this.contasPagar.getDataVencimento());
        }
        String data = Formatacao.ConvercaoDataPadrao(this.contasPagar.getDataVencimento()) + "0";
        String mes = data.substring(3, 10);
        this.contasPagar.setMes(mes);
        
    }

    public void setPlanoContas(Object objeto) {
        this.planoConta = new Planoconta();
        this.planoConta = (Planoconta) objeto;
        if (this.planoConta!=null){
            planoContajTextField.setText(this.planoConta.getNumeroConta());
            descricaoplanoContajTextField.setText(this.planoConta.getDescricao());
        }else descricaoplanoContajTextField.setText("Conta não Cadastrado");
    }

    public void setCliente(Object objeto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setProdutoXML(Produto produto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public void salvarContaPagar() {
        contasPagar.setCredor(credorjTextField.getText());
        contasPagar.setDataLancamento(datalancamentojDateChooser.getDate());
        contasPagar.setDataVencimento(dataVencimentojDateChooser.getDate());
        contasPagar.setEmpresa(config.getEmpresa().getIdempresa());
        contasPagar.setNumeroDocumento(numeroDocumentojTextField.getText());
        contasPagar.setObservacao(observacaojTextField.getText());
        contasPagar.setPlanoconta(planoConta.getIdplanoconta());
        contasPagar.setTipoPagamento(tipoPagamentojComboBox.getSelectedItem().toString());
        contasPagar.setValorConta(Formatacao.formatarStringDouble(valorContajTextField.getText()));
        String boletoEntregue = (String) boletoEntreguejComboBox.getSelectedItem();
        if (boletoEntregue.equalsIgnoreCase("SIM")) {
            this.contasPagar.setBoletoEntregue(1);
        } else {
            this.contasPagar.setBoletoEntregue(0);
        }
        if (this.fornecedor != null) {
            contasPagar.setIdFornecedor(this.fornecedor.getIdfornecedor());
        } else {
            contasPagar.setIdFornecedor(0);
        }
        contasPagar.setPagamentocontaspagar(1);
        contasPagar.setValorParcial(0.0);
        contasPagar.setEmpresa(this.config.getEmpresa().getIdempresa());
        gerarDataReal();
        ContasPagarController contasPagarController = new ContasPagarController();
        contasPagarController.salvar(contasPagar);
        telaConsulta.setNovaConta();
    }
    
    public void salvarContaPagarFuturas(String data) {
        contasPagar.setCredor(credorjTextField.getText());
        contasPagar.setDataLancamento(datalancamentojDateChooser.getDate());
        contasPagar.setDataVencimento(Formatacao.ConvercaoStringData(data));
        contasPagar.setEmpresa(config.getEmpresa().getIdempresa());
        contasPagar.setNumeroDocumento(numeroDocumentojTextField.getText());
        contasPagar.setObservacao(observacaojTextField.getText());
        contasPagar.setPlanoconta(planoConta.getIdplanoconta());
        contasPagar.setTipoPagamento(tipoPagamentojComboBox.getSelectedItem().toString());
        contasPagar.setValorConta(Formatacao.formatarStringDouble(valorContajTextField.getText()));
        String boletoEntregue = (String) boletoEntreguejComboBox.getSelectedItem();
        contasPagar.setFutura("S");
        if (boletoEntregue.equalsIgnoreCase("SIM")) {
            this.contasPagar.setBoletoEntregue(1);
        } else {
            this.contasPagar.setBoletoEntregue(0);
        }
        if (this.fornecedor != null) {
            contasPagar.setIdFornecedor(this.fornecedor.getIdfornecedor());
        } else {
            contasPagar.setIdFornecedor(0);
        }
        contasPagar.setPagamentocontaspagar(1);
        contasPagar.setValorParcial(0.0);
        contasPagar.setEmpresa(this.config.getEmpresa().getIdempresa());
        gerarDataReal();
        ContasPagarController contasPagarController = new ContasPagarController();
        contasPagarController.salvar(contasPagar);
    }
    
    public void gerarContasFuturas(){
        String data = Formatacao.ConvercaoDataPadrao(dataVencimentojDateChooser.getDate());
        String mes = data.substring(3, 5);
        String ano = data.substring(6,10);
        String dia = data.substring(0,2);
        int intMes = Integer.parseInt(mes);
        for(int i=12;intMes<13;intMes++){
            String novaData = dia + "/";
            if (intMes<10){
                novaData = novaData + "0";
            }
            novaData = novaData + String.valueOf(intMes) + "/" + ano;
            salvarContaPagarFuturas(novaData);
        }
        this.dispose();
    }
    public void setArquivo(File arquivo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

