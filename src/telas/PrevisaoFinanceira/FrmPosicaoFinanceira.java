/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package telas.PrevisaoFinanceira;

import Regras.ContasPagarController;
import Regras.ContasReceberController;
import Regras.ControleChequeController;
import Regras.Formatacao;
import Regras.MovimentoBancoController;
import Regras.ParcelaCartaoController;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import org.springframework.core.env.JOptCommandLinePropertySource;

/**
 *
 * @author wolverine
 */
public class FrmPosicaoFinanceira extends javax.swing.JFrame {
    
    PosicaoFinanceiraTableModel modelPosicao;
    List<PosicaoFinanceira> listaPosicao;
    
    private String datePattern;
    private String maskPattern;
    private char placeHolder;

    /**
     * Creates new form FrmPosicaoFinanceira
     */
    public FrmPosicaoFinanceira() {      
        datePattern = "dd/MM/yyyy";
        maskPattern = "##/##/##";
        placeHolder = '_';
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

        periodojPanel = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        dataInicialjDateChooser = new com.toedter.calendar.JDateChooser(null, null, datePattern, new JTextFieldDateEditor(datePattern,
            maskPattern, placeHolder));
    dataFinaljDateChooser = new com.toedter.calendar.JDateChooser(null, null, datePattern, new JTextFieldDateEditor(datePattern,
        maskPattern, placeHolder));
jLabel2 = new javax.swing.JLabel();
jButton1 = new javax.swing.JButton();
jScrollPane1 = new javax.swing.JScrollPane();
posicaojTable = new javax.swing.JTable();

setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
setTitle("Posição Financeira");

periodojPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Período"));

jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/tick.png"))); // NOI18N
jButton2.setText("Gerar");
jButton2.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton2ActionPerformed(evt);
    }
    });

    jLabel1.setText("Data Inicial");

    dataInicialjDateChooser.addFocusListener(new java.awt.event.FocusAdapter() {
        public void focusGained(java.awt.event.FocusEvent evt) {
            dataInicialjDateChooserFocusGained(evt);
        }
    });

    dataFinaljDateChooser.addFocusListener(new java.awt.event.FocusAdapter() {
        public void focusGained(java.awt.event.FocusEvent evt) {
            dataFinaljDateChooserFocusGained(evt);
        }
    });

    jLabel2.setText("Data Final");

    jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/door_in.png"))); // NOI18N
    jButton1.setText("Fechar");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton1ActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
    jPanel4.setLayout(jPanel4Layout);
    jPanel4Layout.setHorizontalGroup(
        jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel4Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(dataInicialjDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel1))
            .addGap(33, 33, 33)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel2)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addComponent(dataFinaljDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(26, 26, 26)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(145, 145, 145)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap(386, Short.MAX_VALUE))
    );
    jPanel4Layout.setVerticalGroup(
        jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel4Layout.createSequentialGroup()
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(dataInicialjDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(dataFinaljDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout periodojPanelLayout = new javax.swing.GroupLayout(periodojPanel);
    periodojPanel.setLayout(periodojPanelLayout);
    periodojPanelLayout.setHorizontalGroup(
        periodojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(periodojPanelLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addContainerGap())
    );
    periodojPanelLayout.setVerticalGroup(
        periodojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(periodojPanelLayout.createSequentialGroup()
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 9, Short.MAX_VALUE))
    );

    posicaojTable.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
    posicaojTable.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {
            {null, null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null, null}
        },
        new String [] {
            "Data", "Contas Pagar", "Cheques Pré", "CEF Cartão", "CEF Cheques", "CEF Boletos", "BB Cartão", "BB Cheques", "BB Boletos"
        }
    ) {
        boolean[] canEdit = new boolean [] {
            false, false, false, false, false, false, false, false, false
        };

        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit [columnIndex];
        }
    });
    jScrollPane1.setViewportView(posicaojTable);
    posicaojTable.getColumnModel().getColumn(0).setResizable(false);
    posicaojTable.getColumnModel().getColumn(1).setResizable(false);
    posicaojTable.getColumnModel().getColumn(2).setResizable(false);
    posicaojTable.getColumnModel().getColumn(3).setResizable(false);
    posicaojTable.getColumnModel().getColumn(4).setResizable(false);
    posicaojTable.getColumnModel().getColumn(5).setResizable(false);
    posicaojTable.getColumnModel().getColumn(6).setResizable(false);
    posicaojTable.getColumnModel().getColumn(7).setResizable(false);
    posicaojTable.getColumnModel().getColumn(8).setResizable(false);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(periodojPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1))
            .addContainerGap())
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(periodojPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE)
            .addContainerGap())
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dataInicialjDateChooserFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dataInicialjDateChooserFocusGained

    }//GEN-LAST:event_dataInicialjDateChooserFocusGained

    private void dataFinaljDateChooserFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dataFinaljDateChooserFocusGained

    }//GEN-LAST:event_dataFinaljDateChooserFocusGained

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if ((dataInicialjDateChooser.getDate()==null) || (dataFinaljDateChooser.getDate()==null)){
            JOptionPane.showMessageDialog(periodojPanel, "Datas Invalidas");
        }else carregarModel();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser dataFinaljDateChooser;
    private com.toedter.calendar.JDateChooser dataInicialjDateChooser;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel periodojPanel;
    private javax.swing.JTable posicaojTable;
    // End of variables declaration//GEN-END:variables

    public void carregarModel(){
        gerarListaPosicaoFinanceira();
        DefaultTableCellRenderer rendererCor = new DefaultTableCellRenderer(){
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                        boolean isSelected, boolean hasFocus, int row, int column) {
                    Component comp = super.getTableCellRendererComponent(table, value,
                            isSelected, hasFocus, row, column);
                    if ((column==2) || (column==3) || (column==5) || (column==6) || (column==8)){
                        comp.setForeground(Color.blue);
                    }else {
                        if (column!=0){
                            comp.setForeground(Color.red);
                        }
                    }
                    return comp;
                }
        };
        
        if (listaPosicao==null){
            listaPosicao = new ArrayList<PosicaoFinanceira>();
        }
        modelPosicao = new PosicaoFinanceiraTableModel(listaPosicao);
        rendererCor.setHorizontalAlignment(SwingConstants.RIGHT);
        posicaojTable.setModel(modelPosicao);
        posicaojTable.getColumnModel().getColumn(0).setPreferredWidth(30);
        posicaojTable.getColumnModel().getColumn(1).setCellRenderer(rendererCor);
        posicaojTable.getColumnModel().getColumn(1).setPreferredWidth(40);
        posicaojTable.getColumnModel().getColumn(2).setCellRenderer(rendererCor);
        posicaojTable.getColumnModel().getColumn(2).setPreferredWidth(40);
        posicaojTable.getColumnModel().getColumn(3).setCellRenderer(rendererCor);
        posicaojTable.getColumnModel().getColumn(3).setPreferredWidth(40);
        posicaojTable.getColumnModel().getColumn(4).setCellRenderer(rendererCor);
        posicaojTable.getColumnModel().getColumn(4).setPreferredWidth(40);
        posicaojTable.getColumnModel().getColumn(5).setCellRenderer(rendererCor);
        posicaojTable.getColumnModel().getColumn(5).setPreferredWidth(40);
        posicaojTable.getColumnModel().getColumn(6).setCellRenderer(rendererCor);
        posicaojTable.getColumnModel().getColumn(6).setPreferredWidth(40);
        posicaojTable.getColumnModel().getColumn(7).setCellRenderer(rendererCor);
        posicaojTable.getColumnModel().getColumn(7).setPreferredWidth(40);
        posicaojTable.getColumnModel().getColumn(8).setCellRenderer(rendererCor);
        posicaojTable.getColumnModel().getColumn(8).setPreferredWidth(40);
        posicaojTable.repaint();
    }
    
    
    private int calcularNumeroDias(){
        int numeroDias =0;
        if (dataInicialjDateChooser.getDate()==dataFinaljDateChooser.getDate()){
            numeroDias=1;
        }else {
            numeroDias = Formatacao.subtrairDatas(dataFinaljDateChooser.getDate(), dataInicialjDateChooser.getDate());
            numeroDias+=1;
        }
        return numeroDias;
    }
    
    private void gerarListaPosicaoFinanceira(){
        this.listaPosicao = new ArrayList<PosicaoFinanceira>();
        Date data = dataInicialjDateChooser.getDate();
        int numerodias = calcularNumeroDias();
        for(int i=0;i<numerodias;i++){
            PosicaoFinanceira ps = new PosicaoFinanceira();
            ps.setData(Formatacao.SomarDiasData(data, i));
            ps.setContasPagar(calcularValorContasPagar(ps.getData()));
            ps.setChequePre(calcularValorChequesRecebidos(ps.getData()));
            ps.setBbCartao(calcularValorCartaoBanco(ps.getData(), 2));
            ps.setBbContasReceber(calcularValorBoletosReceber(ps.getData(), 2));
            ps.setBbMoviemnto(calcularValorChequesEmitidos(ps.getData(), 2));
            ps.setCaixaCartao(calcularValorCartaoBanco(ps.getData(), 1));
            ps.setCaixaContasReceber(calcularValorBoletosReceber(ps.getData(), 1));
            ps.setCaixaMoviemnto(calcularValorChequesEmitidos(ps.getData(), 1));
            listaPosicao.add(ps);
        }
    }
    
    
    public float calcularValorContasPagar(Date data){
        ContasPagarController contasPagarController = new ContasPagarController();
        float valor = contasPagarController.calcularValorContaPagarDia(Formatacao.ConvercaoDataSql(data));
        return valor;
    }
    
    public float calcularValorChequesRecebidos(Date data){
        float valor =0.0f;
        ControleChequeController controleChequeController = new ControleChequeController();
        valor = controleChequeController.calcularValorChequesCompensarDia(Formatacao.ConvercaoDataSql(data));
        return valor;
    }
    
    public float calcularValorCartaoBanco(Date data, int banco){
        String sData = Formatacao.ConvercaoDataSql(data);
        float valor =0.0f;
        ParcelaCartaoController parcelaCartaoController = new ParcelaCartaoController();
        String sql = "Select distinct sum(valorReceber) as valorCartao " +
                "From parcelacartao where(dataRecebimento='" + sData + "')  and banco_idbanco=" + banco;
        valor = parcelaCartaoController.calcularValorCArtaoBancoDia(sql);
        return valor;
    }
    
    public float calcularValorChequesEmitidos(Date data, int banco){
        String sData = Formatacao.ConvercaoDataSql(data);
        MovimentoBancoController movimentoBancoController = new MovimentoBancoController();
        float valor =0.0f;
        String sql = "Select distinct sum(valorSaida) as valorCheque " +
                "From movimentobanco where(dataMovimento='" + sData + "')  and numeroCheque<>'0' and banco_idbanco="+ banco;
        valor = movimentoBancoController.calcularValorChequesBancoDia(sql);
        return valor;
    }
    
    public float calcularValorBoletosReceber(Date data, int banco){
        String sData = Formatacao.ConvercaoDataSql(data);
        ContasReceberController contasReceberController = new ContasReceberController();
        float valor =0.0f;
        String sql = "Select distinct sum(valorParcela) as valorBoletos " +
                "From faturasreceberparcelas where(dataVencimento='" + sData + "')  and contasReceberPagamento_idcontasReceberPagamento=1" +
                " and bancoPagamento="+ banco;
        valor = contasReceberController.calcularValorParcelaFaturaBancoDia(sql);
        return valor;
    }

}
