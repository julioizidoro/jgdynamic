/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FrmSituacaoEntrada.java
 *
 * Created on 14/07/2011, 09:46:54
 */
package telas.Entrada;

import Regras.EntradaProdutoController;
import Regras.Formatacao;
import Regras.FornecedorController;
import beanController.NfDuplicatas;
import beanController.NfProdutos;
import beanController.NotaEletronica;
import com.toedter.calendar.JTextFieldDateEditor;
import controler.Config;
import Interfaces.ItelaConsulta;
import controler.Sigap;
import facade.EntradaFacade;
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
import model.Banco;
import model.Docentrada;
import model.Estoque;
import model.Fornecedor;
import model.Nfentrada;
import model.Produto;
import telas.Fornecedor.FrmConsultaFornecedor;

/**
 *
 * @author Wolverine
 */
public final class FrmSituacaoEntrada extends javax.swing.JFrame implements ItelaConsulta{
    
    private Docentrada docEntrada;
    private String datePattern;
    private String maskPattern;
    private char placeHolder;
    private Config config;
    private ItelaConsulta telaConsulta;
    private Fornecedor fornecedor;

    /** Creates new form FrmSituacaoEntrada */
    public FrmSituacaoEntrada(Config config, ItelaConsulta telaConsulta) {
        this.config = config;
        this.telaConsulta = telaConsulta;
        this.docEntrada = new Docentrada();
        initComponents();
        alterarEntrada();
        URL url = this.getClass().getResource("/imagens/logo_mini.png");
        Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(imagemTitulo);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
     public FrmSituacaoEntrada(Config config, ItelaConsulta telaConsulta, Docentrada docEntrada) {
        this.config = config;
        this.docEntrada = docEntrada;
        this.fornecedor = localizarFornecedor(docEntrada.getFornecedor());
        initComponents();
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

        jPanel6 = new javax.swing.JPanel();
        fornecedorjTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        buscaBancojButton = new javax.swing.JButton();
        dataEntradajDateChooser = new com.toedter.calendar.JDateChooser(null, null, datePattern, new JTextFieldDateEditor(datePattern,
            maskPattern, placeHolder));
    jLabel2 = new javax.swing.JLabel();
    condicaoPagamentojComboBox = new javax.swing.JComboBox();
    jLabel3 = new javax.swing.JLabel();
    tipoDocumentojComboBox = new javax.swing.JComboBox();
    jLabel4 = new javax.swing.JLabel();
    jLabel5 = new javax.swing.JLabel();
    jLabel6 = new javax.swing.JLabel();
    jLabel7 = new javax.swing.JLabel();
    jLabel8 = new javax.swing.JLabel();
    situacaojComboBox = new javax.swing.JComboBox();
    valorTotaljTextField = new javax.swing.JTextField();
    valorEncargosjTextField = new javax.swing.JTextField();
    valorDescontojTextField = new javax.swing.JTextField();
    jPanel7 = new javax.swing.JPanel();
    jLabel9 = new javax.swing.JLabel();
    numerojTextField = new javax.swing.JTextField();
    dataSaidajDateChooser = new com.toedter.calendar.JDateChooser(null, null, datePattern, new JTextFieldDateEditor(datePattern,
        maskPattern, placeHolder));
dataEmissaojDateChooser = new com.toedter.calendar.JDateChooser(null, null, datePattern, new JTextFieldDateEditor(datePattern,
    maskPattern, placeHolder));
    jLabel10 = new javax.swing.JLabel();
    jLabel11 = new javax.swing.JLabel();
    jLabel12 = new javax.swing.JLabel();
    especiejComboBox = new javax.swing.JComboBox();
    jLabel13 = new javax.swing.JLabel();
    seriejTextField = new javax.swing.JTextField();
    jLabel14 = new javax.swing.JLabel();
    subSeriejTextField = new javax.swing.JTextField();
    jLabel15 = new javax.swing.JLabel();
    jLabel16 = new javax.swing.JLabel();
    totalNotajTextField = new javax.swing.JTextField();
    valorProdutosjTextField = new javax.swing.JTextField();
    jPanel5 = new javax.swing.JPanel();
    salvarjButton3 = new javax.swing.JButton();
    jButton3 = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Documento Registro de Compra"));
    jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    fornecedorjTextField.setEditable(false);
    jPanel6.add(fornecedorjTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 330, -1));

    jLabel1.setText("Fornecedor");
    jPanel6.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 25, -1, -1));

    buscaBancojButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/magnifier.png"))); // NOI18N
    buscaBancojButton.setToolTipText("Pesquisa Banco");
    buscaBancojButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            buscaBancojButtonActionPerformed(evt);
        }
    });
    jPanel6.add(buscaBancojButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 40, 20, 20));

    dataEntradajDateChooser.addFocusListener(new java.awt.event.FocusAdapter() {
        public void focusGained(java.awt.event.FocusEvent evt) {
            dataEntradajDateChooserFocusGained(evt);
        }
    });
    jPanel6.add(dataEntradajDateChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 40, 100, -1));

    jLabel2.setText("Condição de Pagamento");
    jPanel6.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 70, -1, -1));

    condicaoPagamentojComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "a Prazo", "a Vista" }));
    jPanel6.add(condicaoPagamentojComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 90, 230, -1));

    jLabel3.setText("Data da Entrada");
    jPanel6.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 20, -1, -1));

    tipoDocumentojComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nota Fiscal", "Pedido", "Recibo" }));
    jPanel6.add(tipoDocumentojComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 220, -1));

    jLabel4.setText("Tipo de Documento");
    jPanel6.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

    jLabel5.setText("Valor Encargos R$");
    jPanel6.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

    jLabel6.setText("Valor do Desconto R$");
    jPanel6.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, -1, -1));

    jLabel7.setText("Valor Total R$");
    jPanel6.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 120, -1, -1));

    jLabel8.setText("Situação da Entrada");
    jPanel6.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));

    situacaojComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Aguardando", "Finalizada", "Movimento", "Reposição" }));
    jPanel6.add(situacaojComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 470, -1));

    valorTotaljTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
    valorTotaljTextField.setText("0,00");
    valorTotaljTextField.addFocusListener(new java.awt.event.FocusAdapter() {
        public void focusGained(java.awt.event.FocusEvent evt) {
            valorTotaljTextFieldFocusGained(evt);
        }
        public void focusLost(java.awt.event.FocusEvent evt) {
            valorTotaljTextFieldFocusLost(evt);
        }
    });
    valorTotaljTextField.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyReleased(java.awt.event.KeyEvent evt) {
            valorTotaljTextFieldKeyReleased(evt);
        }
    });
    jPanel6.add(valorTotaljTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 140, 120, -1));

    valorEncargosjTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
    valorEncargosjTextField.setText("0,00");
    valorEncargosjTextField.addFocusListener(new java.awt.event.FocusAdapter() {
        public void focusGained(java.awt.event.FocusEvent evt) {
            valorEncargosjTextFieldFocusGained(evt);
        }
    });
    valorEncargosjTextField.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyReleased(java.awt.event.KeyEvent evt) {
            valorEncargosjTextFieldKeyReleased(evt);
        }
    });
    jPanel6.add(valorEncargosjTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 130, -1));

    valorDescontojTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
    valorDescontojTextField.setText("0,00");
    valorDescontojTextField.addFocusListener(new java.awt.event.FocusAdapter() {
        public void focusGained(java.awt.event.FocusEvent evt) {
            valorDescontojTextFieldFocusGained(evt);
        }
        public void focusLost(java.awt.event.FocusEvent evt) {
            valorDescontojTextFieldFocusLost(evt);
        }
    });
    valorDescontojTextField.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyReleased(java.awt.event.KeyEvent evt) {
            valorDescontojTextFieldKeyReleased(evt);
        }
    });
    jPanel6.add(valorDescontojTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, 120, -1));

    jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados Nota Fiscal"));
    jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jLabel9.setText("Número");
    jPanel7.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

    numerojTextField.addFocusListener(new java.awt.event.FocusAdapter() {
        public void focusGained(java.awt.event.FocusEvent evt) {
            numerojTextFieldFocusGained(evt);
        }
        public void focusLost(java.awt.event.FocusEvent evt) {
            numerojTextFieldFocusLost(evt);
        }
    });
    jPanel7.add(numerojTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 35, 90, -1));

    dataSaidajDateChooser.addFocusListener(new java.awt.event.FocusAdapter() {
        public void focusGained(java.awt.event.FocusEvent evt) {
            dataSaidajDateChooserFocusGained(evt);
        }
    });
    jPanel7.add(dataSaidajDateChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 35, 100, -1));

    dataEmissaojDateChooser.addFocusListener(new java.awt.event.FocusAdapter() {
        public void focusGained(java.awt.event.FocusEvent evt) {
            dataEmissaojDateChooserFocusGained(evt);
        }
    });
    jPanel7.add(dataEmissaojDateChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 35, 100, -1));

    jLabel10.setText("Data Emissão");
    jPanel7.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, -1, -1));

    jLabel11.setText("Data Saída");
    jPanel7.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, -1, -1));

    jLabel12.setText("Especie");
    jPanel7.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 20, -1, -1));

    especiejComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "NF-e", "NFF", "NF" }));
    jPanel7.add(especiejComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 35, 90, -1));

    jLabel13.setText("Série");
    jPanel7.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

    seriejTextField.addFocusListener(new java.awt.event.FocusAdapter() {
        public void focusGained(java.awt.event.FocusEvent evt) {
            seriejTextFieldFocusGained(evt);
        }
        public void focusLost(java.awt.event.FocusEvent evt) {
            seriejTextFieldFocusLost(evt);
        }
    });
    jPanel7.add(seriejTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 100, -1));

    jLabel14.setText("Sub-Serie");
    jPanel7.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, -1, -1));

    subSeriejTextField.addFocusListener(new java.awt.event.FocusAdapter() {
        public void focusGained(java.awt.event.FocusEvent evt) {
            subSeriejTextFieldFocusGained(evt);
        }
        public void focusLost(java.awt.event.FocusEvent evt) {
            subSeriejTextFieldFocusLost(evt);
        }
    });
    jPanel7.add(subSeriejTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 80, -1));

    jLabel15.setText("Valor Total R$");
    jPanel7.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 60, -1, -1));

    jLabel16.setText("Valor dos Produtos R$");
    jPanel7.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 60, -1, -1));

    totalNotajTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
    totalNotajTextField.setText("0,00");
    totalNotajTextField.addFocusListener(new java.awt.event.FocusAdapter() {
        public void focusGained(java.awt.event.FocusEvent evt) {
            totalNotajTextFieldFocusGained(evt);
        }
        public void focusLost(java.awt.event.FocusEvent evt) {
            totalNotajTextFieldFocusLost(evt);
        }
    });
    totalNotajTextField.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyReleased(java.awt.event.KeyEvent evt) {
            totalNotajTextFieldKeyReleased(evt);
        }
    });
    jPanel7.add(totalNotajTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 80, 100, -1));

    valorProdutosjTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
    valorProdutosjTextField.setText("0,00");
    valorProdutosjTextField.addFocusListener(new java.awt.event.FocusAdapter() {
        public void focusGained(java.awt.event.FocusEvent evt) {
            valorProdutosjTextFieldFocusGained(evt);
        }
        public void focusLost(java.awt.event.FocusEvent evt) {
            valorProdutosjTextFieldFocusLost(evt);
        }
    });
    valorProdutosjTextField.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyReleased(java.awt.event.KeyEvent evt) {
            valorProdutosjTextFieldKeyReleased(evt);
        }
    });
    jPanel7.add(valorProdutosjTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 80, 120, -1));

    jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    salvarjButton3.setFont(new java.awt.Font("Tahoma", 0, 12));
    salvarjButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/tick.png"))); // NOI18N
    salvarjButton3.setText("Salvar");
    salvarjButton3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    salvarjButton3.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
    salvarjButton3.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            salvarjButton3SalvarCadastroAssociado(evt);
        }
    });
    jPanel5.add(salvarjButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, -1, -1));

    jButton3.setFont(new java.awt.Font("Tahoma", 0, 12));
    jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cross.png"))); // NOI18N
    jButton3.setText("Fechar");
    jButton3.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton3FecharCadastro(evt);
        }
    });
    jPanel5.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, -1, -1));

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE)))
                .addGroup(layout.createSequentialGroup()
                    .addGap(53, 53, 53)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(20, Short.MAX_VALUE))
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buscaBancojButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscaBancojButtonActionPerformed
        new FrmConsultaFornecedor(this);
}//GEN-LAST:event_buscaBancojButtonActionPerformed

    private void dataEntradajDateChooserFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dataEntradajDateChooserFocusGained
        
}//GEN-LAST:event_dataEntradajDateChooserFocusGained

    private void valorTotaljTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_valorTotaljTextFieldFocusGained
        valorTotaljTextField.selectAll();
}//GEN-LAST:event_valorTotaljTextFieldFocusGained

    private void valorTotaljTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_valorTotaljTextFieldFocusLost
        
}//GEN-LAST:event_valorTotaljTextFieldFocusLost

    private void valorTotaljTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_valorTotaljTextFieldKeyReleased
        valorTotaljTextField.setText(Sigap.decinalValorMonetario(valorTotaljTextField.getText()));
}//GEN-LAST:event_valorTotaljTextFieldKeyReleased

    private void valorEncargosjTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_valorEncargosjTextFieldFocusGained
        valorEncargosjTextField.selectAll();
}//GEN-LAST:event_valorEncargosjTextFieldFocusGained

    private void valorEncargosjTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_valorEncargosjTextFieldKeyReleased
        valorEncargosjTextField.setText(Sigap.decinalValorMonetario(valorEncargosjTextField.getText()));
}//GEN-LAST:event_valorEncargosjTextFieldKeyReleased

    private void valorDescontojTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_valorDescontojTextFieldFocusGained
        valorDescontojTextField.selectAll();
}//GEN-LAST:event_valorDescontojTextFieldFocusGained

    private void valorDescontojTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_valorDescontojTextFieldFocusLost
        
}//GEN-LAST:event_valorDescontojTextFieldFocusLost

    private void valorDescontojTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_valorDescontojTextFieldKeyReleased
        valorDescontojTextField.setText(Sigap.decinalValorMonetario(valorDescontojTextField.getText()));
}//GEN-LAST:event_valorDescontojTextFieldKeyReleased

    private void numerojTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_numerojTextFieldFocusGained
        numerojTextField.selectAll();
}//GEN-LAST:event_numerojTextFieldFocusGained

    private void numerojTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_numerojTextFieldFocusLost
        
}//GEN-LAST:event_numerojTextFieldFocusLost

    private void dataSaidajDateChooserFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dataSaidajDateChooserFocusGained
        // TODO add your handling code here:
}//GEN-LAST:event_dataSaidajDateChooserFocusGained

    private void dataEmissaojDateChooserFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dataEmissaojDateChooserFocusGained
        // TODO add your handling code here:
}//GEN-LAST:event_dataEmissaojDateChooserFocusGained

    private void seriejTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_seriejTextFieldFocusGained
        seriejTextField.selectAll();
}//GEN-LAST:event_seriejTextFieldFocusGained

    private void seriejTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_seriejTextFieldFocusLost
        
}//GEN-LAST:event_seriejTextFieldFocusLost

    private void subSeriejTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_subSeriejTextFieldFocusGained
        subSeriejTextField.selectAll();
}//GEN-LAST:event_subSeriejTextFieldFocusGained

    private void subSeriejTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_subSeriejTextFieldFocusLost
        
}//GEN-LAST:event_subSeriejTextFieldFocusLost

    private void totalNotajTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_totalNotajTextFieldFocusGained
        totalNotajTextField.selectAll();
}//GEN-LAST:event_totalNotajTextFieldFocusGained

    private void totalNotajTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_totalNotajTextFieldFocusLost
        // TODO add your handling code here:
}//GEN-LAST:event_totalNotajTextFieldFocusLost

    private void totalNotajTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_totalNotajTextFieldKeyReleased
        totalNotajTextField.setText(Sigap.decinalValorMonetario(totalNotajTextField.getText()));
}//GEN-LAST:event_totalNotajTextFieldKeyReleased

    private void valorProdutosjTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_valorProdutosjTextFieldFocusGained
        valorProdutosjTextField.selectAll();
}//GEN-LAST:event_valorProdutosjTextFieldFocusGained

    private void valorProdutosjTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_valorProdutosjTextFieldFocusLost
        
}//GEN-LAST:event_valorProdutosjTextFieldFocusLost

    private void valorProdutosjTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_valorProdutosjTextFieldKeyReleased
        valorProdutosjTextField.setText(Sigap.decinalValorMonetario(valorProdutosjTextField.getText()));
}//GEN-LAST:event_valorProdutosjTextFieldKeyReleased

    private void salvarjButton3SalvarCadastroAssociado(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarjButton3SalvarCadastroAssociado
        EntradaFacade entradaFacade = new EntradaFacade();
        setDocEntrada();
        try {
            entradaFacade.salvarEntradaDoc(docEntrada);
        } catch (SQLException ex) {
            Logger.getLogger(FrmSituacaoEntrada.class.getName()).log(Level.SEVERE, null, ex);
        }
        telaConsulta.setData(null);
        this.dispose();
    }//GEN-LAST:event_salvarjButton3SalvarCadastroAssociado

    private void jButton3FecharCadastro(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3FecharCadastro
        this.dispose();
}//GEN-LAST:event_jButton3FecharCadastro

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buscaBancojButton;
    private javax.swing.JComboBox condicaoPagamentojComboBox;
    private com.toedter.calendar.JDateChooser dataEmissaojDateChooser;
    private com.toedter.calendar.JDateChooser dataEntradajDateChooser;
    private com.toedter.calendar.JDateChooser dataSaidajDateChooser;
    private javax.swing.JComboBox especiejComboBox;
    private javax.swing.JTextField fornecedorjTextField;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JTextField numerojTextField;
    private javax.swing.JButton salvarjButton3;
    private javax.swing.JTextField seriejTextField;
    private javax.swing.JComboBox situacaojComboBox;
    private javax.swing.JTextField subSeriejTextField;
    private javax.swing.JComboBox tipoDocumentojComboBox;
    private javax.swing.JTextField totalNotajTextField;
    private javax.swing.JTextField valorDescontojTextField;
    private javax.swing.JTextField valorEncargosjTextField;
    private javax.swing.JTextField valorProdutosjTextField;
    private javax.swing.JTextField valorTotaljTextField;
    // End of variables declaration//GEN-END:variables

    
    public void preencherCampos(){
        Fornecedor fornecedor = localizarFornecedor(docEntrada.getFornecedor());
        fornecedorjTextField.setText(fornecedor.getRazaoSocial());
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
        this.fornecedor = (Fornecedor) objeto;
        fornecedorjTextField.setText(this.fornecedor.getRazaoSocial());
    }

    public void setForPedido(Object objeto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public void setDocEntrada(){
        //Seta Nota Fiscal
        
        
        docEntrada.setEmpresa(config.getEmpresa().getIdempresa());
        docEntrada.setCondicaoPagamento((String) condicaoPagamentojComboBox.getSelectedItem());
        docEntrada.setDataEntrada(dataEntradajDateChooser.getDate());
        docEntrada.setFornecedor(fornecedor.getIdfornecedor());
        docEntrada.setSituacao((String) situacaojComboBox.getSelectedItem());
        docEntrada.setTipoDocumento((String) tipoDocumentojComboBox.getSelectedItem());
        docEntrada.setValorDesconto(Sigap.ConvercaoMonetariaFloat(valorDescontojTextField.getText()));
        docEntrada.setValorEncargos(Sigap.ConvercaoMonetariaFloat(valorEncargosjTextField.getText()));
        docEntrada.setValorTotal(Sigap.ConvercaoMonetariaFloat(valorTotaljTextField.getText()));

    }
    
    
    public void setNfEntrada(){
        Nfentrada nfEntrada = new Nfentrada();
        nfEntrada.setDataEmissao(dataEmissaojDateChooser.getDate());
        nfEntrada.setDataSaida(dataSaidajDateChooser.getDate());
        nfEntrada.setEspecie((String) especiejComboBox.getSelectedItem());
        nfEntrada.setNumero(numerojTextField.getText());
        nfEntrada.setSerie(seriejTextField.getText());
        nfEntrada.setSubSerie(subSeriejTextField.getText());
        nfEntrada.setValorProdutos(Formatacao.ConvercaoMonetariaFloat(valorProdutosjTextField.getText()));
        nfEntrada.setValorTotal(Formatacao.ConvercaoMonetariaFloat(totalNotajTextField.getText()));
        EntradaFacade entradaFacade = new EntradaFacade();
        try {
            docEntrada = entradaFacade.consultarEntrada(entradaFacade.getIdEntrada());
            nfEntrada.setDocentrada(docEntrada.getIdDocEntrada());
            entradaFacade.salvarEntradaNF(nfEntrada);
        } catch (Exception ex) {
            Logger.getLogger(FrmSituacaoEntrada.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro salvar dados Nota Fiscal "+ ex);
        }
    }
    
    public void alterarEntrada(){
        //Preencher Doc entrada
        if (docEntrada.getIdDocEntrada() != null) {
            fornecedorjTextField.setText(this.fornecedor.getRazaoSocial());
            dataEntradajDateChooser.setDate(this.docEntrada.getDataEntrada());
            tipoDocumentojComboBox.setSelectedItem(this.docEntrada.getTipoDocumento());
            condicaoPagamentojComboBox.setSelectedItem(this.docEntrada.getCondicaoPagamento());
            valorEncargosjTextField.setText(Sigap.ConvercaoMonetaria(this.docEntrada.getValorEncargos()));
            valorDescontojTextField.setText(Sigap.ConvercaoMonetaria(this.docEntrada.getValorDesconto()));
            valorTotaljTextField.setText(Sigap.ConvercaoMonetaria(this.docEntrada.getValorTotal()));
            situacaojComboBox.setSelectedItem(this.docEntrada.getSituacao());
        }
        
        
        //Preencher Dados Nota Fiscal
                
        Nfentrada nfEntrada = new Nfentrada();
        nfEntrada = localizarNotaFiscal(docEntrada.getIdDocEntrada());
        if (nfEntrada!=null) {
            numerojTextField.setText(nfEntrada.getNumero());
            dataEmissaojDateChooser.setDate(nfEntrada.getDataEmissao());
            dataSaidajDateChooser.setDate(nfEntrada.getDataSaida());
            especiejComboBox.setSelectedItem(nfEntrada.getEspecie());
            seriejTextField.setText(nfEntrada.getSerie());
            subSeriejTextField.setText(nfEntrada.getSubSerie());
            valorProdutosjTextField.setText(Sigap.ConvercaoMonetaria(nfEntrada.getValorProdutos()));
            totalNotajTextField.setText(Sigap.ConvercaoMonetaria(nfEntrada.getValorTotal()));
        }
    }
    
    public Fornecedor localizarFornecedor(int idFornecedor){
        FornecedorController fornecedorController = new FornecedorController();
        return fornecedorController.consultarFornecedor(idFornecedor);
    }
    
    public Nfentrada localizarNotaFiscal(int idNfentrada){
        EntradaProdutoController entradaProdutoController = new EntradaProdutoController();
        return entradaProdutoController.consultarNotaFiscalEntrada(idNfentrada);
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
