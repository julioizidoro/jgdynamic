/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FrmMovimentoFinanceiro.java
 *
 * Created on 27/08/2011, 12:52:24
 */
package telas.RelatoriosGerenciais;

import Regras.Formatacao;
import com.toedter.calendar.JTextFieldDateEditor;
import controler.Config;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/**
 *
 * @author Wolverine
 */
public class FrmMovimentoFinanceiro extends javax.swing.JFrame {
    
    private String datePattern;
    private String maskPattern;
    private char placeHolder;
    private movimentoFinanceiroTableModel model;
    relMovimentoFinanceiro movimentoFinanceiro;
    private Config config;
   

    /** Creates new form FrmMovimentoFinanceiro */
    public FrmMovimentoFinanceiro(Config config) {
        datePattern = "dd/MM/yyyy";
        maskPattern = "##/##/####";
        placeHolder = '_';
        this.config = config;
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        dataIniciojDateChooser = new com.toedter.calendar.JDateChooser(null, null, datePattern, new JTextFieldDateEditor(datePattern,
            maskPattern, placeHolder));
    dataFinaljDateChooser = new com.toedter.calendar.JDateChooser(null, null, datePattern, new JTextFieldDateEditor(datePattern,
        maskPattern, placeHolder));
jPanel2 = new javax.swing.JPanel();
jButton1 = new javax.swing.JButton();
jButton2 = new javax.swing.JButton();
jPanel3 = new javax.swing.JPanel();
jScrollPane1 = new javax.swing.JScrollPane();
valoresjTable = new javax.swing.JTable();
jPanel4 = new javax.swing.JPanel();
jPanel5 = new javax.swing.JPanel();
vendaVistajLabel = new javax.swing.JLabel();
jPanel6 = new javax.swing.JPanel();
cartaoCreditojLabel = new javax.swing.JLabel();
jPanel7 = new javax.swing.JPanel();
vendaPrazojLabel = new javax.swing.JLabel();
jPanel8 = new javax.swing.JPanel();
chequePrejLabel = new javax.swing.JLabel();
jPanel9 = new javax.swing.JPanel();
totalCreditosjLabel = new javax.swing.JLabel();
jPanel10 = new javax.swing.JPanel();
recebimentosjLabel = new javax.swing.JLabel();
jPanel11 = new javax.swing.JPanel();
totalGeraljLabel = new javax.swing.JLabel();
jPanel12 = new javax.swing.JPanel();
totalVendasjLabel = new javax.swing.JLabel();
jPanel13 = new javax.swing.JPanel();
totalDescontojLabel = new javax.swing.JLabel();

setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
setTitle("Movimento Financeiro");

jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

jLabel1.setText("Data Inicial");

jLabel2.setText("Data Final");

javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
jPanel1.setLayout(jPanel1Layout);
jPanel1Layout.setHorizontalGroup(
    jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
    .addGroup(jPanel1Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1)
            .addComponent(dataIniciojDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(44, 44, 44)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dataFinaljDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel2))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    jPanel1Layout.setVerticalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel1)
                .addComponent(jLabel2))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(dataIniciojDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(dataFinaljDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

    jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/magnifier.png"))); // NOI18N
    jButton1.setText("Procurar");
    jButton1.setToolTipText("Procurar Fechamentos");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton1ActionPerformed(evt);
        }
    });

    jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icone_excel.gif"))); // NOI18N
    jButton2.setText("Exportar");
    jButton2.setToolTipText("Procurar Fechamentos");
    jButton2.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton2ActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel2Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jButton1)
            .addGap(26, 26, 26)
            .addComponent(jButton2)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    jPanel2Layout.setVerticalGroup(
        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jButton1)
                .addComponent(jButton2))
            .addContainerGap())
    );

    jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

    valoresjTable.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {
            {null, null, null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null, null, null}
        },
        new String [] {
            "Data", "Venda Vista", "Venda Prazo", "Cartão Crédito", "Cheque Pré", "Total das Vendas", "Recebimentos", "Total Geral", "Creditos", "Descontos"
        }
    ) {
        boolean[] canEdit = new boolean [] {
            false, false, false, false, false, false, false, false, false, false
        };

        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit [columnIndex];
        }
    });
    jScrollPane1.setViewportView(valoresjTable);
    if (valoresjTable.getColumnModel().getColumnCount() > 0) {
        valoresjTable.getColumnModel().getColumn(0).setResizable(false);
        valoresjTable.getColumnModel().getColumn(0).setPreferredWidth(20);
        valoresjTable.getColumnModel().getColumn(1).setResizable(false);
        valoresjTable.getColumnModel().getColumn(1).setPreferredWidth(20);
        valoresjTable.getColumnModel().getColumn(2).setResizable(false);
        valoresjTable.getColumnModel().getColumn(2).setPreferredWidth(20);
        valoresjTable.getColumnModel().getColumn(3).setResizable(false);
        valoresjTable.getColumnModel().getColumn(3).setPreferredWidth(20);
        valoresjTable.getColumnModel().getColumn(4).setResizable(false);
        valoresjTable.getColumnModel().getColumn(4).setPreferredWidth(20);
        valoresjTable.getColumnModel().getColumn(5).setResizable(false);
        valoresjTable.getColumnModel().getColumn(5).setPreferredWidth(20);
        valoresjTable.getColumnModel().getColumn(6).setResizable(false);
        valoresjTable.getColumnModel().getColumn(6).setPreferredWidth(20);
        valoresjTable.getColumnModel().getColumn(7).setResizable(false);
        valoresjTable.getColumnModel().getColumn(7).setPreferredWidth(20);
        valoresjTable.getColumnModel().getColumn(8).setResizable(false);
        valoresjTable.getColumnModel().getColumn(8).setPreferredWidth(50);
        valoresjTable.getColumnModel().getColumn(9).setResizable(false);
        valoresjTable.getColumnModel().getColumn(9).setPreferredWidth(50);
    }

    jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

    jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Venda Vista"));

    vendaVistajLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    vendaVistajLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    vendaVistajLabel.setText("0,00");

    javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
    jPanel5.setLayout(jPanel5Layout);
    jPanel5Layout.setHorizontalGroup(
        jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel5Layout.createSequentialGroup()
            .addComponent(vendaVistajLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    jPanel5Layout.setVerticalGroup(
        jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(vendaVistajLabel)
    );

    jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Cartão de Crédito"));

    cartaoCreditojLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    cartaoCreditojLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    cartaoCreditojLabel.setText("0,00");

    javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
    jPanel6.setLayout(jPanel6Layout);
    jPanel6Layout.setHorizontalGroup(
        jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel6Layout.createSequentialGroup()
            .addComponent(cartaoCreditojLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(18, Short.MAX_VALUE))
    );
    jPanel6Layout.setVerticalGroup(
        jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(cartaoCreditojLabel)
    );

    jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Venda Prazo"));

    vendaPrazojLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    vendaPrazojLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    vendaPrazojLabel.setText("0,00");

    javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
    jPanel7.setLayout(jPanel7Layout);
    jPanel7Layout.setHorizontalGroup(
        jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel7Layout.createSequentialGroup()
            .addComponent(vendaPrazojLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    jPanel7Layout.setVerticalGroup(
        jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(vendaPrazojLabel)
    );

    jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Cheque Pré"));

    chequePrejLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    chequePrejLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    chequePrejLabel.setText("0,00");

    javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
    jPanel8.setLayout(jPanel8Layout);
    jPanel8Layout.setHorizontalGroup(
        jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel8Layout.createSequentialGroup()
            .addComponent(chequePrejLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    jPanel8Layout.setVerticalGroup(
        jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(chequePrejLabel)
    );

    jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Total dos Créditos"));

    totalCreditosjLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    totalCreditosjLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    totalCreditosjLabel.setText("0,00");

    javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
    jPanel9.setLayout(jPanel9Layout);
    jPanel9Layout.setHorizontalGroup(
        jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
            .addGap(0, 18, Short.MAX_VALUE)
            .addComponent(totalCreditosjLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
    );
    jPanel9Layout.setVerticalGroup(
        jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
            .addGap(0, 0, Short.MAX_VALUE)
            .addComponent(totalCreditosjLabel))
    );

    jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Recebimentos"));

    recebimentosjLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    recebimentosjLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    recebimentosjLabel.setText("0,00");

    javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
    jPanel10.setLayout(jPanel10Layout);
    jPanel10Layout.setHorizontalGroup(
        jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel10Layout.createSequentialGroup()
            .addComponent(recebimentosjLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    jPanel10Layout.setVerticalGroup(
        jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(recebimentosjLabel)
    );

    jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Total Geral"));

    totalGeraljLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    totalGeraljLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    totalGeraljLabel.setText("0,00");

    javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
    jPanel11.setLayout(jPanel11Layout);
    jPanel11Layout.setHorizontalGroup(
        jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel11Layout.createSequentialGroup()
            .addComponent(totalGeraljLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    jPanel11Layout.setVerticalGroup(
        jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(totalGeraljLabel)
    );

    jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Total das Vendas"));

    totalVendasjLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    totalVendasjLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    totalVendasjLabel.setText("0,00");

    javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
    jPanel12.setLayout(jPanel12Layout);
    jPanel12Layout.setHorizontalGroup(
        jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel12Layout.createSequentialGroup()
            .addComponent(totalVendasjLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(18, Short.MAX_VALUE))
    );
    jPanel12Layout.setVerticalGroup(
        jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(totalVendasjLabel)
    );

    jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Total Desconto"));

    totalDescontojLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    totalDescontojLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    totalDescontojLabel.setText("0,00");

    javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
    jPanel13.setLayout(jPanel13Layout);
    jPanel13Layout.setHorizontalGroup(
        jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
            .addGap(0, 18, Short.MAX_VALUE)
            .addComponent(totalDescontojLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
    );
    jPanel13Layout.setVerticalGroup(
        jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(totalDescontojLabel, javax.swing.GroupLayout.Alignment.TRAILING)
    );

    javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
    jPanel4.setLayout(jPanel4Layout);
    jPanel4Layout.setHorizontalGroup(
        jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel4Layout.createSequentialGroup()
            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    jPanel4Layout.setVerticalGroup(
        jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel4Layout.createSequentialGroup()
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(0, 23, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
    jPanel3.setLayout(jPanel3Layout);
    jPanel3Layout.setHorizontalGroup(
        jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel3Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addContainerGap())
    );
    jPanel3Layout.setVerticalGroup(
        jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addContainerGap())
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    if ((dataIniciojDateChooser.getDate()!=null) && (dataFinaljDateChooser.getDate()!=null)){
        movimentoFinanceiro = new relMovimentoFinanceiro(dataIniciojDateChooser.getDate(), dataFinaljDateChooser.getDate(), config);
        setModel();
        
    }
    
}//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Integer rows = valoresjTable.getModel().getRowCount();
      if (rows > 0) {
    
    JFileChooser seleccionar = new JFileChooser();
    
    File arquivo;
   
    if (seleccionar.showDialog(null, "Exportar Excel") == JFileChooser.APPROVE_OPTION) {
        
        arquivo = seleccionar.getSelectedFile();            
        int cantFila = valoresjTable.getRowCount();
        int cantColumna = valoresjTable.getColumnCount();
       
        Workbook wb;
        wb = new HSSFWorkbook();
        Sheet folha = wb.createSheet("  ");

        try {
            for (int i = -1; i <cantFila; i++) {
                
                Row fila = folha.createRow(i+1);
                
                for (int j = 0;j<cantColumna; j++) {
                    
                    Cell celda = fila.createCell(j);
                    
                    if(i==-1) {
    
                        celda.setCellValue(String.valueOf(valoresjTable.getColumnName(j)));

                                        
                   
                    } else {
                        
                       celda.setCellValue(String.valueOf(valoresjTable.getValueAt(i, j)));        
                       
                                 
                    }
                    
                    
                    wb.write(new FileOutputStream(arquivo + ".xls"));
                
                }
            }
            
            JOptionPane.showMessageDialog(null, "Planilha exportada com sucesso.");
        
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Por favor tente novamente"+e);
        }
        
    } else {
        JOptionPane.showMessageDialog(null, "Erro ao Exportar Planilha....");
    }  

    
     }else{
      
          JOptionPane.showMessageDialog(null, "Favor escolha o pedido e clique em adicionar.!!"); 
      
      }   // fim do if
    
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
 
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
      
        //</editor-fold>

        /* Create and display the form */
        
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cartaoCreditojLabel;
    private javax.swing.JLabel chequePrejLabel;
    private com.toedter.calendar.JDateChooser dataFinaljDateChooser;
    private com.toedter.calendar.JDateChooser dataIniciojDateChooser;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel recebimentosjLabel;
    private javax.swing.JLabel totalCreditosjLabel;
    private javax.swing.JLabel totalDescontojLabel;
    private javax.swing.JLabel totalGeraljLabel;
    private javax.swing.JLabel totalVendasjLabel;
    private javax.swing.JTable valoresjTable;
    private javax.swing.JLabel vendaPrazojLabel;
    private javax.swing.JLabel vendaVistajLabel;
    // End of variables declaration//GEN-END:variables

    public void setModel(){
        model = new movimentoFinanceiroTableModel(movimentoFinanceiro.getListaMovimentoFinanceiro());
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.RIGHT);
        valoresjTable.setModel(model);
        valoresjTable.getColumnModel().getColumn(0).setPreferredWidth(20);
        valoresjTable.getColumnModel().getColumn(1).setCellRenderer(renderer);
        valoresjTable.getColumnModel().getColumn(1).setPreferredWidth(20);
        valoresjTable.getColumnModel().getColumn(2).setCellRenderer(renderer);
        valoresjTable.getColumnModel().getColumn(2).setPreferredWidth(20);
        valoresjTable.getColumnModel().getColumn(3).setCellRenderer(renderer);
        valoresjTable.getColumnModel().getColumn(3).setPreferredWidth(20);
        valoresjTable.getColumnModel().getColumn(4).setCellRenderer(renderer);
        valoresjTable.getColumnModel().getColumn(4).setPreferredWidth(20);
        valoresjTable.getColumnModel().getColumn(5).setCellRenderer(renderer);
        valoresjTable.getColumnModel().getColumn(5).setPreferredWidth(20);
        valoresjTable.getColumnModel().getColumn(6).setCellRenderer(renderer);
        valoresjTable.getColumnModel().getColumn(6).setPreferredWidth(20);
        valoresjTable.getColumnModel().getColumn(7).setCellRenderer(renderer);
        valoresjTable.getColumnModel().getColumn(7).setPreferredWidth(20);
        valoresjTable.getColumnModel().getColumn(8).setCellRenderer(renderer);
        valoresjTable.getColumnModel().getColumn(8).setPreferredWidth(20);
        valoresjTable.getColumnModel().getColumn(9).setCellRenderer(renderer);
        valoresjTable.getColumnModel().getColumn(9).setPreferredWidth(20);
        valoresjTable.repaint();
        calcularTotais();
    }
    
    public void calcularTotais(){
        double vendaVista=0;
        double vendaPrazo=0;
        double cartaoCredito=0;
        double chequePre =0;
        double totalVendas=0;
        double recebinentos=0;
        double totalGeral=0;
        double totalCreditos=0;
        double totaldesconto=0;
        for (int i=0;i<this.movimentoFinanceiro.getListaMovimentoFinanceiro().size();i++){
            vendaVista = vendaVista + this.movimentoFinanceiro.getListaMovimentoFinanceiro().get(i).getVendaVista();
            vendaPrazo = vendaPrazo + this.movimentoFinanceiro.getListaMovimentoFinanceiro().get(i).getVendaPrazo();
            cartaoCredito = cartaoCredito + this.movimentoFinanceiro.getListaMovimentoFinanceiro().get(i).getCartaoCredito();
            chequePre = chequePre + this.movimentoFinanceiro.getListaMovimentoFinanceiro().get(i).getChequePre();
            totalVendas = totalVendas + this.movimentoFinanceiro.getListaMovimentoFinanceiro().get(i).getTotalVendas();
            recebinentos = recebinentos + this.movimentoFinanceiro.getListaMovimentoFinanceiro().get(i).getRecebimentos();
            totalGeral = totalGeral + this.movimentoFinanceiro.getListaMovimentoFinanceiro().get(i).getTotalGeral();
            totalCreditos = totalCreditos + this.movimentoFinanceiro.getListaMovimentoFinanceiro().get(i).getCredito();
            totaldesconto = totaldesconto + this.movimentoFinanceiro.getListaMovimentoFinanceiro().get(i).getDesconto();
        }
        vendaVistajLabel.setText(Formatacao.foramtarDoubleString(vendaVista));
        vendaPrazojLabel.setText(Formatacao.foramtarDoubleString(vendaPrazo));
        cartaoCreditojLabel.setText(Formatacao.foramtarDoubleString(cartaoCredito));
        chequePrejLabel.setText(Formatacao.foramtarDoubleString(chequePre));
        totalVendasjLabel.setText(Formatacao.foramtarDoubleString(totalVendas));
        recebimentosjLabel.setText(Formatacao.foramtarDoubleString(recebinentos));
        totalGeraljLabel.setText(Formatacao.foramtarDoubleString(totalGeral));
        totalCreditosjLabel.setText(Formatacao.foramtarDoubleString(totalCreditos));
        totalDescontojLabel.setText(Formatacao.foramtarDoubleString(totaldesconto));
    }
}
