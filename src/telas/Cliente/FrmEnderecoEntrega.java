/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package telas.Cliente;

import Regras.ClienteController;
import controler.UsuarioLogado;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Cliente;
import model.Clienteenderecoentrega;

/**
 *
 * @author Wolverine
 */
public class FrmEnderecoEntrega extends javax.swing.JFrame {

    /**
     * Creates new form FrmAutorizados
     */
    
    private List<Clienteenderecoentrega> listaEntrega;
    private ConsultaEnderecoEntragaTableModel modelEntrega;
    private Cliente cliente;
    private UsuarioLogado usuarioLogado;
    private Clienteenderecoentrega enderecoEntrega;
    
    
    public FrmEnderecoEntrega(Cliente cliente, UsuarioLogado usuarioLogado) {
        initComponents();
        this.usuarioLogado = usuarioLogado;
        this.cliente = cliente;
        URL url = this.getClass().getResource("/imagens/logo_mini.png");
        Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(imagemTitulo);
        this.setLocationRelativeTo(null);
        this.setTitle("Cliente : " + cliente.getNome());
        setModelEnderecoEntrega();
        try {
            cepjFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (ParseException ex) {
            Logger.getLogger(FrmEnderecoEntrega.class.getName()).log(Level.SEVERE, null, ex);
        }
        logradourojTextField.requestFocus();
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

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        entregajTable = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        tipoLogradourojComboBox = new javax.swing.JComboBox();
        logradourojTextField = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        numerojTextField = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        pontoReferenciajTextField = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        bairrojTextField = new javax.swing.JTextField();
        cepjFormattedTextField = new javax.swing.JFormattedTextField();
        jLabel18 = new javax.swing.JLabel();
        cidadejTextField = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        estadojComboBox = new javax.swing.JComboBox();
        jLabel20 = new javax.swing.JLabel();
        complementojTextField = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        entregajTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Tipo Logradouro", "Logradouro", "Numero", "Complemento", "Bairro"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(entregajTable);
        entregajTable.getColumnModel().getColumn(0).setResizable(false);
        entregajTable.getColumnModel().getColumn(1).setResizable(false);
        entregajTable.getColumnModel().getColumn(2).setResizable(false);
        entregajTable.getColumnModel().getColumn(3).setResizable(false);
        entregajTable.getColumnModel().getColumn(4).setResizable(false);

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/tick.png"))); // NOI18N
        jButton1.setText("Adicionar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cross.png"))); // NOI18N
        jButton2.setText("Excluir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/note.png"))); // NOI18N
        jButton3.setText("Alterar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/door_in.png"))); // NOI18N
        jButton4.setText("Fechar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(76, 76, 76)
                .addComponent(jButton2)
                .addGap(98, 98, 98)
                .addComponent(jButton4)
                .addGap(23, 23, 23))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel13.setText("Tipo Logradouro");

        tipoLogradourojComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Avenida", "BR", "Estrada", "Rodovia", "Rua", "Servidão" }));

        jLabel14.setText("Logradouro");

        jLabel15.setText("Número");

        jLabel16.setText("Complemento");

        jLabel17.setText("Bairro");

        jLabel18.setText("CEP");

        jLabel19.setText("Cidade");

        estadojComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SC", "RS", "PR", "SP", "RJ", "ES", "MG", "MT", "MS", "BH" }));

        jLabel20.setText("Estado");

        jLabel21.setText("Ponto de Referencia");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17)
                                    .addComponent(bairrojTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cepjFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel18))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cidadejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel19))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(estadojComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel20))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel21)
                                    .addComponent(pontoReferenciajTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(tipoLogradourojComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(logradourojTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel14)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel15)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel16))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(numerojTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(complementojTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jLabel13)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tipoLogradourojComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(logradourojTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numerojTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(complementojTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bairrojTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cepjFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cidadejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(estadojComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pontoReferenciajTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (this.usuarioLogado.getAcesso().getClienteEntregaAdicionar() == 1) {
            String validar = validarEnderco();
            if (validar != null) {
                JOptionPane.showMessageDialog(rootPane, validar);
            } else {
                if (this.enderecoEntrega==null){
                    this.enderecoEntrega = new Clienteenderecoentrega();
                }
                salvarEndereco(this.enderecoEntrega);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Acesso Negado");
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (this.usuarioLogado.getAcesso().getClienteEntregaExcluir()==1){
            int linha = entregajTable.getSelectedRow();
            if (linha >=0){
                ClienteController clienteController = new  ClienteController();
                clienteController.excluirEndercoEntrega(listaEntrega.get(linha));
                setModelEnderecoEntrega();
            }
        }else JOptionPane.showMessageDialog(rootPane, "Acesso Negado");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int linha = entregajTable.getSelectedRow();
        if (linha>=0){
            enderecoEntrega = new Clienteenderecoentrega();
            enderecoEntrega = listaEntrega.get(linha);
            tipoLogradourojComboBox.setSelectedItem(enderecoEntrega.getTipoLogradouro());
            logradourojTextField.setText(enderecoEntrega.getLogradouro());
            numerojTextField.setText(enderecoEntrega.getNumero());
            complementojTextField.setText(enderecoEntrega.getComplemento());
            bairrojTextField.setText(enderecoEntrega.getBairro());
            cepjFormattedTextField.setText(enderecoEntrega.getCep());
            cidadejTextField.setText(enderecoEntrega.getCidade());
            estadojComboBox.setSelectedItem(enderecoEntrega.getEstado());
            pontoReferenciajTextField.setText(enderecoEntrega.getPontoReferencia());
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField bairrojTextField;
    private javax.swing.JFormattedTextField cepjFormattedTextField;
    private javax.swing.JTextField cidadejTextField;
    private javax.swing.JTextField complementojTextField;
    private javax.swing.JTable entregajTable;
    private javax.swing.JComboBox estadojComboBox;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField logradourojTextField;
    private javax.swing.JTextField numerojTextField;
    private javax.swing.JTextField pontoReferenciajTextField;
    private javax.swing.JComboBox tipoLogradourojComboBox;
    // End of variables declaration//GEN-END:variables

    public void setModelEnderecoEntrega(){
        ClienteController clienteController = new  ClienteController();
        this.listaEntrega = clienteController.listarEnderecoEntrega(this.cliente.getIdcliente());
        if (listaEntrega==null){
            listaEntrega  = new ArrayList<Clienteenderecoentrega>();
        }
        modelEntrega = new ConsultaEnderecoEntragaTableModel(listaEntrega);
        entregajTable.setModel(modelEntrega);
        entregajTable.getColumnModel().getColumn(0).setPreferredWidth(10);
        entregajTable.getColumnModel().getColumn(1).setPreferredWidth(200);
        entregajTable.getColumnModel().getColumn(2).setPreferredWidth(20);
        entregajTable.getColumnModel().getColumn(3).setPreferredWidth(70);
        entregajTable.getColumnModel().getColumn(4).setPreferredWidth(70);
        entregajTable.repaint();
    }
    
    public String validarEnderco(){
        if (logradourojTextField.getText()==null){
            return "Logradouro campo obrigatório";
        }
        if (numerojTextField.getText()==null){
            return  "Número campo obrigatório";
        }
        if (bairrojTextField.getText()==null){
            return "Bairro campo obrigatório";
        }
        if (cepjFormattedTextField.getText()==null){
            return "CEP campo obrigatório";
        }
        if (cidadejTextField.getText()==null){
            return "Cidade campo obrigatório";
        }
        return null;
    }
    
    public void salvarEndereco(Clienteenderecoentrega endereco){
        endereco.setTipoLogradouro(tipoLogradourojComboBox.getSelectedItem().toString());
        endereco.setLogradouro(logradourojTextField.getText());
        endereco.setNumero(numerojTextField.getText());
        endereco.setComplemento(complementojTextField.getText());
        endereco.setBairro(bairrojTextField.getText());
        endereco.setCep(cepjFormattedTextField.getText());
        endereco.setCidade(cidadejTextField.getText());
        endereco.setEstado(estadojComboBox.getSelectedItem().toString());
        endereco.setPontoReferencia(pontoReferenciajTextField.getText());
        endereco.setClienteIdcliente(this.cliente.getIdcliente());
        
        ClienteController clienteController = new ClienteController();
        clienteController.salvarEnderecoEntrega(endereco);
        setModelEnderecoEntrega();
        logradourojTextField.setText("");
        numerojTextField.setText("");
        complementojTextField.setText("");
        bairrojTextField.setText("");
        cepjFormattedTextField.setText("");
        cidadejTextField.setText("");
        pontoReferenciajTextField.setText("");
        try {
            cepjFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (ParseException ex) {
            Logger.getLogger(FrmEnderecoEntrega.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
