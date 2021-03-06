/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FrmSelecionarClienteTerminal.java
 *
 * Created on 08/11/2010, 13:19:54
 */

package telas.NotaSaida;

import Regras.ProdutoVenda;
import facade.TerminalVendasFacade;
import java.awt.Component;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import model.Terminalcliente;

/**
 *
 * @author Woverine
 */
public class FrmSelecionarClienteTerminal extends javax.swing.JFrame {

    private TerminalVendasTableModel model;
    private DefaultTableCellRenderer renderer;
    private List<Terminalcliente> listaTerminalCliente;
    private List<ProdutoVenda> listaProdutoVenda;
    private INotaSaidaBean telaNota;
    private List<NotaSaidaProdutoBean> listaProdutoBean;

    /** Creates new form FrmSelecionarClienteTerminal */
    public FrmSelecionarClienteTerminal(INotaSaidaBean telaNota) throws Exception {
        this.renderer = new DefaultTableCellRenderer() {

            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {

                String valorFormatado;
                if (value instanceof Double) {
                    Double valor = (Double) value;

                    NumberFormat format = NumberFormat.getCurrencyInstance();
                    format.setMinimumFractionDigits(3);
                    valorFormatado = format.format(valor);
                } else if (value instanceof Float) {
                    Float valor = (Float) value;

                    NumberFormat format = NumberFormat.getCurrencyInstance();
                    format.setMinimumFractionDigits(2);
                    valorFormatado = format.format(valor);
                } else {
                    valorFormatado = value.toString();
                }

                Component comp = super.getTableCellRendererComponent(table, valorFormatado,
                        isSelected, hasFocus, row, column);

                return comp;
            }
        };
        this.telaNota = telaNota;
        renderer.setHorizontalAlignment(SwingConstants.RIGHT);
        listaTerminalCliente = new ArrayList<Terminalcliente>();
        TerminalVendasFacade terminalVendasFacade = new TerminalVendasFacade();
        listaTerminalCliente = terminalVendasFacade.consultaTerminalCliente();
        model = new TerminalVendasTableModel(listaTerminalCliente);
        initComponents();
        this.setLocationRelativeTo(null);
        gerarTableModel();
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
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        listaClientesjTable = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastrar Cliente Terminal de Vendas");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 360, -1));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 250, 350, -1));

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        listaClientesjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nome", "Forma Pagamento", "Vendedor", "Valor"
            }
        ));
        listaClientesjTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                listaClientesjTableKeyPressed(evt);
            }
        });
        jScrollPane3.setViewportView(listaClientesjTable);
        listaClientesjTable.getColumnModel().getColumn(0).setPreferredWidth(200);
        listaClientesjTable.getColumnModel().getColumn(1).setPreferredWidth(50);
        listaClientesjTable.getColumnModel().getColumn(2).setPreferredWidth(50);
        listaClientesjTable.getColumnModel().getColumn(3).setResizable(false);
        listaClientesjTable.getColumnModel().getColumn(3).setPreferredWidth(8);

        jPanel4.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 620, 370));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 650, 390));

        jMenu1.setText("Menu de Teclas");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ENTER, 0));
        jMenuItem1.setText("Confirmar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        jMenuItem2.setText("Cancela");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        int linha = listaClientesjTable.getSelectedRow();
        if (linha>=0){
            this.telaNota.finalizarBuscaTerminalCliente(this.listaTerminalCliente.get(linha));
            this.dispose();
        }else {
            JOptionPane.showMessageDialog(null, "Selecione um cliente");
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void listaClientesjTableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_listaClientesjTableKeyPressed
         if  (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER){
             jMenuItem1ActionPerformed(null);
         }
    }//GEN-LAST:event_listaClientesjTableKeyPressed

    /**
    * @param args the command line arguments
    */
   

   public void gerarTableModel(){
        model = new TerminalVendasTableModel(this.listaTerminalCliente);
        this.setLocationRelativeTo(this);
        listaClientesjTable.setModel(model);
        listaClientesjTable.getColumnModel().getColumn(0).setPreferredWidth(200);
        listaClientesjTable.getColumnModel().getColumn(1).setPreferredWidth(50);
        listaClientesjTable.getColumnModel().getColumn(2).setPreferredWidth(50);
        listaClientesjTable.getColumnModel().getColumn(3).setPreferredWidth(8);
        listaClientesjTable.setDefaultRenderer(Float.class, renderer);
        listaClientesjTable.repaint();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable listaClientesjTable;
    // End of variables declaration//GEN-END:variables

}
