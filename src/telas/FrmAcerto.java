/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * NewJFrame.java
 *
 * Created on 11/10/2011, 13:10:53
 */
package telas;

import Interfaces.ItelaConsulta;
import Regras.EstoqueController;
import Regras.Formatacao;
import Regras.ProdutoController;
import beanController.NfDuplicatas;
import beanController.NfProdutos;
import beanController.NotaEletronica;
import controler.Config;
import facade.AcertoFacade;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.File;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.*;
import telas.Produtos.FrmConsultaProdutos;
import telas.Produtos.FrmRelatorioAcerto;

/**
 *
 * @author Wolverine
 */
public class FrmAcerto extends javax.swing.JFrame implements ItelaConsulta{

    /** Creates new form NewJFrame */
    private Config config;
    private Acerto acerto;
    private Produto produto;
    private Estoque estoque;
    
    
    public FrmAcerto(Config config) {
        this.config = config;
        produto = new Produto();
        estoque = new Estoque();
        acerto = new Acerto();
        initComponents();
        URL url = this.getClass().getResource("/imagens/logo_mini.png");
        Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(imagemTitulo);
        this.setLocationRelativeTo(null);
        setVisible(true);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        codigojTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        descricaojTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        quantidadejTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        estoquejTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        motivojTextField = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        salvarjButton2 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Acerto de Estoque");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        codigojTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                codigojTextFieldFocusLost(evt);
            }
        });
        codigojTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                codigojTextFieldKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                codigojTextFieldKeyReleased(evt);
            }
        });

        jLabel1.setText("Código");

        descricaojTextField.setEditable(false);

        jLabel2.setText("Descrição");

        jLabel3.setText("Quantidade");

        quantidadejTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                quantidadejTextFieldFocusGained(evt);
            }
        });
        quantidadejTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                quantidadejTextFieldKeyPressed(evt);
            }
        });

        jLabel4.setText("Estoque");

        estoquejTextField.setEditable(false);

        jLabel6.setText("Motivo");

        motivojTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                motivojTextFieldKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(codigojTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(descricaojTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(36, 36, 36))
                            .addComponent(estoquejTextField)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(quantidadejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(motivojTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
                            .addComponent(jLabel6))))
                .addGap(24, 24, 24))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(estoquejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(codigojTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(descricaojTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(quantidadejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(motivojTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        salvarjButton2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        salvarjButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/tick.png"))); // NOI18N
        salvarjButton2.setText("Confirmar");
        salvarjButton2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        salvarjButton2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        salvarjButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarjButton2ActionPerformed(evt);
            }
        });
        jPanel4.add(salvarjButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cross.png"))); // NOI18N
        jButton2.setText("Fechar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, -1, -1));

        jMenu3.setText("Relatórios");

        jMenuItem1.setText("Período");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuItem2.setText("Produto");
        jMenuItem2.setEnabled(false);
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        jMenuBar2.add(jMenu3);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void codigojTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codigojTextFieldKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_F2){
            new FrmConsultaProdutos(this, config, false);
        }
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
                localizarProduto();
                quantidadejTextField.requestFocus();
        }       
    }//GEN-LAST:event_codigojTextFieldKeyPressed

    private void codigojTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_codigojTextFieldFocusLost
        
    }//GEN-LAST:event_codigojTextFieldFocusLost

    private void quantidadejTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_quantidadejTextFieldFocusGained
        quantidadejTextField.selectAll();
    }//GEN-LAST:event_quantidadejTextFieldFocusGained

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void salvarjButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarjButton2ActionPerformed
        gravarAcerto();
    }//GEN-LAST:event_salvarjButton2ActionPerformed

    private void quantidadejTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_quantidadejTextFieldKeyPressed
        
    }//GEN-LAST:event_quantidadejTextFieldKeyPressed

    private void codigojTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codigojTextFieldKeyReleased
         
    }//GEN-LAST:event_codigojTextFieldKeyReleased

    private void motivojTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_motivojTextFieldKeyPressed
         if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            gravarAcerto();
        }
    }//GEN-LAST:event_motivojTextFieldKeyPressed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        new FrmRelatorioAcerto(1, config);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    /**
     * @param args the command line arguments
     */
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField codigojTextField;
    private javax.swing.JTextField descricaojTextField;
    private javax.swing.JTextField estoquejTextField;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField motivojTextField;
    private javax.swing.JTextField quantidadejTextField;
    private javax.swing.JButton salvarjButton2;
    // End of variables declaration//GEN-END:variables

    public void setData(Object objeto) {
        produto = (Produto) objeto;
        acerto.setProduto(produto.getIdProduto());
        codigojTextField.setText(String.valueOf(produto.getReferencia()));
        descricaojTextField.setText(produto.getDescricao());
        localizarEstoque();
    }

    public void setBanco(Banco banco) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setModelProduto(Produto produto, Estoque estoque) {
        
    }

    public void setNFe(List<NfProdutos> listaProdutos, List<NfDuplicatas> listaDuplicatas, NotaEletronica nota, Fornecedor fornecedor) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setAlterarValorVenda(Estoque estoque) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setFornecedor(Object objeto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setForPedido(Object objeto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
     public void gravarAcerto() {
        if (validarCampos()) {
            Double quantidade = Formatacao.ConvercaoMonetariaDouble(quantidadejTextField.getText());
            acerto.setData(new Date());
            EstoqueController estoqueController = new EstoqueController();
            acerto.setQuantidadeEstoque(estoque.getQuantidadeEstoque());
            acerto.setQuantidadeAcerto(quantidade);
            acerto.setMotivo(motivojTextField.getText());
            acerto.setEmpresa(this.config.getEmpresa().getIdempresa());
            AcertoFacade acertoFacade = new AcertoFacade();
            try {
                acertoFacade.salvar(acerto);
            } catch (Exception ex) {
                Logger.getLogger(FrmAcerto.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Erro Salvar Estoque " + ex);
            }
            estoque.setQuantidadeEstoque(estoque.getQuantidadeEstoque() + quantidade);
            estoqueController.salvarEstoque(estoque);
            codigojTextField.setText("");
            descricaojTextField.setText("");
            quantidadejTextField.setText("");
            estoquejTextField.setText("");
            motivojTextField.setText("");
            codigojTextField.requestFocus();
            acerto = new Acerto();
        }
    }
     
     
    public boolean validarCampos(){
        if (quantidadejTextField.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Quantidade não pode ser Zero");
            return false;
        }
        if (motivojTextField.getText().length() == 0){
            JOptionPane.showMessageDialog(null, "Motivo não pode estar em branco");
            return false;
        }
        return true;
    }
     
    public void localizarProduto(){
        ProdutoController produtoController = new ProdutoController();
        int referencia = Integer.parseInt(codigojTextField.getText());
        Produto produto = produtoController.consultarProdutoReferencia(referencia);
        if (produto!=null){
            acerto.setProduto(produto.getIdProduto());
            descricaojTextField.setText(produto.getDescricao());
            localizarEstoque();
            quantidadejTextField.requestFocus();
        }
    }
    
    public void localizarEstoque(){
        EstoqueController estoqueController = new EstoqueController();
        estoque = estoqueController.consultarEstoque(acerto.getProduto(), config.getEmpresa().getIdempresa());
        if (estoque!=null){
            estoquejTextField.setText(Formatacao.foramtarDoubleString(estoque.getQuantidadeEstoque()));
        }else this.estoque.setQuantidadeEstoque(0.0);
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
