/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package telas.NotaSaida;

import Regras.Formatacao;
import com.toedter.calendar.JTextFieldDateEditor;
import controler.Config;
import controler.UsuarioLogado;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.net.URL;
import java.util.List;
import model.Cliente;
import model.Fornecedor;
import model.Terminalcliente;
import telas.Cliente.FrmConsultaClientes;
import telas.NotaSaida.Fatura.DuplicataBean;
import telas.NotaSaida.Fatura.FaturaBean;

/**
 *
 * @author Wolverine
 */
public class FrmFiltrarNotaSaida extends javax.swing.JFrame implements INotaSaidaBean{
    
    private String datePattern;
    private String maskPattern;
    private char placeHolder;
    private INotaSaidaBean telaNotaSaida;
    private Cliente cliente;
     private Config config;
    private UsuarioLogado usuarioLogado;

    /**
     * Creates new form FrmFiltrarNotaSaida
     */
    public FrmFiltrarNotaSaida(Config config, UsuarioLogado usuarioLogado, INotaSaidaBean telaNotaSaida) {
        this.telaNotaSaida = telaNotaSaida;
        datePattern = "dd/MM/yyyy";
        maskPattern = "##/##/##";
        placeHolder = '_';
        cliente=null;
        this.usuarioLogado = usuarioLogado;
        this.config = config;
        initComponents();
        URL url = this.getClass().getResource("/imagens/logo_mini.png");
        Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(imagemTitulo);
        this.setLocationRelativeTo(null);
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
        jLabel7 = new javax.swing.JLabel();
        dataInicialjDateChooser = new com.toedter.calendar.JDateChooser(null, null, datePattern, new JTextFieldDateEditor(datePattern,
            maskPattern, placeHolder));
    jLabel8 = new javax.swing.JLabel();
    dataFinaljDateChooser = new com.toedter.calendar.JDateChooser(null, null, datePattern, new JTextFieldDateEditor(datePattern,
        maskPattern, placeHolder));
jLabel1 = new javax.swing.JLabel();
clientejTextField = new javax.swing.JTextField();
jLabel2 = new javax.swing.JLabel();
numerojTextField = new javax.swing.JTextField();
jButton1 = new javax.swing.JButton();
jPanel4 = new javax.swing.JPanel();
salvarjButton2 = new javax.swing.JButton();
jButton2 = new javax.swing.JButton();

setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

jLabel7.setText("Data Inicial");

jLabel8.setText("Data Final");

jLabel1.setText("Cliente");

jLabel2.setText("Número NF-e");

jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/magnifier.png"))); // NOI18N
jButton1.setText("Selecionar");
jButton1.setToolTipText("Seleciona cliente para consultar");
jButton1.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton1ActionPerformed(evt);
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
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(clientejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(21, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel7)
                        .addComponent(dataInicialjDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(52, 52, 52)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(dataFinaljDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(2, 2, 2)
                            .addComponent(jLabel2))
                        .addComponent(numerojTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(33, 33, 33))))
    );
    jPanel1Layout.setVerticalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dataFinaljDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dataInicialjDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(jLabel2)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(numerojTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jLabel1)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(clientejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton1))
            .addContainerGap(20, Short.MAX_VALUE))
    );

    jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
    jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    salvarjButton2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
    salvarjButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/tick.png"))); // NOI18N
    salvarjButton2.setText("Confirmar");
    salvarjButton2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    salvarjButton2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
    salvarjButton2.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            salvarjButton2SalvarCadastroAssociado(evt);
        }
    });
    jPanel4.add(salvarjButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, -1, -1));

    jButton2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
    jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cross.png"))); // NOI18N
    jButton2.setText("Fechar");
    jButton2.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton2FecharCadastro(evt);
        }
    });
    jPanel4.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, -1, -1));

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addContainerGap())
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(29, 29, 29))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void salvarjButton2SalvarCadastroAssociado(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarjButton2SalvarCadastroAssociado
       String sql = "select n from NotaSaida n where ";
       if ((dataInicialjDateChooser.getDate()!=null) && (dataFinaljDateChooser.getDate()!=null)){
           sql = sql + "n.dataEmissao>='" + Formatacao.ConvercaoDataSql(dataInicialjDateChooser.getDate()) + 
                   "'  and n.dataEmissao<='" + Formatacao.ConvercaoDataSql(dataFinaljDateChooser.getDate()) + "' ";
       }
       if (cliente!=null){
           sql = sql + " and n.cliente=" + cliente.getIdcliente() + " ";
       }
       if (numerojTextField.getText().length()>0){
           sql = sql + " and n.numero=" + numerojTextField.getText();
       }
       sql = sql + " order by n.numero";
       telaNotaSaida.filtrarNotaSaida(sql);
       this.dispose();
    }//GEN-LAST:event_salvarjButton2SalvarCadastroAssociado

    private void jButton2FecharCadastro(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2FecharCadastro
        this.telaNotaSaida.setModel();
        this.dispose();
    }//GEN-LAST:event_jButton2FecharCadastro

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new FrmConsultaClientes(config, usuarioLogado, this);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField clientejTextField;
    private com.toedter.calendar.JDateChooser dataFinaljDateChooser;
    private com.toedter.calendar.JDateChooser dataInicialjDateChooser;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField numerojTextField;
    private javax.swing.JButton salvarjButton2;
    // End of variables declaration//GEN-END:variables

    public void inlcluirProdutoContas(Object objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void incluirProdutoVenda(Object objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void consultarCliente(Cliente cliente) {
        if (cliente!=null){
            this.cliente = cliente;
            clientejTextField.setText(cliente.getNome());
        }
    }

    public void finalizarBuscaTerminalCliente(Terminalcliente terminalCliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void carregarArquivoXMLLocalizado(File file) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void carregarFaturas(FaturaBean fatura, List<DuplicataBean> listaDuplicata) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setModel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void filtrarNotaSaida(String sql) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void consultaFornecedor(Fornecedor fornecedor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
