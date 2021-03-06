/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package telas.NotaSaida;

import Regras.ClienteController;
import Regras.Formatacao;
import Regras.NotaSaidaController;
import controler.Config;
import controler.UsuarioLogado;
import controler.relatoriosJasper;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import model.Cliente;
import model.Docentrada;
import model.Fornecedor;
import model.Municipios;
import model.Notasaida;
import model.Terminalcliente;
import telas.ContasReceber.CreditoBean;
import telas.NotaSaida.CartaoCorrecao.FrmCartaoCorrecao;
import telas.NotaSaida.Fatura.DuplicataBean;
import telas.NotaSaida.Fatura.FaturaBean;

/**
 *
 * @author wolverine
 */
public class FrmConsultaNotaSaida extends javax.swing.JFrame implements INotaSaidaBean{
    
    private List<Notasaida> listaNotaSaida;
    private Config config;
    private UsuarioLogado usuarioLogado;
    private ConsultaNotaSaidaTableModel model;
    private int linha;
    private File arquivoXML;
    private String cJustificativa;
    private String email;

    /**
     * Creates new form FrmConsultaNotaSaida
     */
    public FrmConsultaNotaSaida(Config config, UsuarioLogado usuarioLogado) {
        this.config = config;
        this.usuarioLogado = usuarioLogado;
        email = "";
        initComponents();
        URL url = this.getClass().getResource("/imagens/logo_mini.png");
        Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(imagemTitulo);
        this.setLocationRelativeTo(null);
        carregarModelConsultaNotaSaida();
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
        BarradeTarefasjToolBar = new javax.swing.JToolBar();
        AdicionarjButton = new javax.swing.JButton();
        PesquisarjButton = new javax.swing.JButton();
        AdicionarjButton1 = new javax.swing.JButton();
        PesquisarjButton1 = new javax.swing.JButton();
        SeparadordeTarefasjSeparator = new javax.swing.JToolBar.Separator();
        ImprimirjButton1 = new javax.swing.JButton();
        ImprimirjButton = new javax.swing.JButton();
        ImprimirjButton2 = new javax.swing.JButton();
        VisualizarjButton = new javax.swing.JButton();
        RelatoriojButton = new javax.swing.JButton();
        RelatoriojButton1 = new javax.swing.JButton();
        FecharrjButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        notaSaidajTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        nomejTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta NF-e de Saída");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        BarradeTarefasjToolBar.setFloatable(false);
        BarradeTarefasjToolBar.setRollover(true);

        AdicionarjButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/processomais.png"))); // NOI18N
        AdicionarjButton.setText("Venda ");
        AdicionarjButton.setToolTipText("Adicionar Associado");
        AdicionarjButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        AdicionarjButton.setMaximumSize(new java.awt.Dimension(80, 90));
        AdicionarjButton.setMinimumSize(new java.awt.Dimension(80, 90));
        AdicionarjButton.setName(""); // NOI18N
        AdicionarjButton.setPreferredSize(new java.awt.Dimension(80, 90));
        AdicionarjButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        AdicionarjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdicionarjButtonAdicionarAssociado(evt);
            }
        });
        BarradeTarefasjToolBar.add(AdicionarjButton);
        AdicionarjButton.getAccessibleContext().setAccessibleDescription("Emitir NF-e");

        PesquisarjButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/processomenos.png"))); // NOI18N
        PesquisarjButton.setText("Cancelar");
        PesquisarjButton.setToolTipText("Pesquisar Associado");
        PesquisarjButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        PesquisarjButton.setMaximumSize(new java.awt.Dimension(80, 90));
        PesquisarjButton.setMinimumSize(new java.awt.Dimension(80, 90));
        PesquisarjButton.setPreferredSize(new java.awt.Dimension(80, 90));
        PesquisarjButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        PesquisarjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PesquisarjButtonPesquisarAssociado(evt);
            }
        });
        BarradeTarefasjToolBar.add(PesquisarjButton);
        PesquisarjButton.getAccessibleContext().setAccessibleDescription("Cancelar NF-e");

        AdicionarjButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/processomais.png"))); // NOI18N
        AdicionarjButton1.setText("Devolução");
        AdicionarjButton1.setToolTipText("Adicionar Associado");
        AdicionarjButton1.setFocusable(false);
        AdicionarjButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        AdicionarjButton1.setMaximumSize(new java.awt.Dimension(80, 90));
        AdicionarjButton1.setMinimumSize(new java.awt.Dimension(80, 90));
        AdicionarjButton1.setName(""); // NOI18N
        AdicionarjButton1.setPreferredSize(new java.awt.Dimension(80, 90));
        AdicionarjButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        AdicionarjButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdicionarjButton1AdicionarAssociado(evt);
            }
        });
        BarradeTarefasjToolBar.add(AdicionarjButton1);
        AdicionarjButton1.getAccessibleContext().setAccessibleDescription("Emitir NF-e Devolução");

        PesquisarjButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/processomenos.png"))); // NOI18N
        PesquisarjButton1.setText("Correção");
        PesquisarjButton1.setToolTipText("Pesquisar Associado");
        PesquisarjButton1.setFocusable(false);
        PesquisarjButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        PesquisarjButton1.setMaximumSize(new java.awt.Dimension(80, 90));
        PesquisarjButton1.setMinimumSize(new java.awt.Dimension(80, 90));
        PesquisarjButton1.setPreferredSize(new java.awt.Dimension(80, 90));
        PesquisarjButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        PesquisarjButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PesquisarjButton1PesquisarAssociado(evt);
            }
        });
        BarradeTarefasjToolBar.add(PesquisarjButton1);
        PesquisarjButton1.getAccessibleContext().setAccessibleDescription("Carta de Correção");

        BarradeTarefasjToolBar.add(SeparadordeTarefasjSeparator);

        ImprimirjButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/finreceber.png"))); // NOI18N
        ImprimirjButton1.setText("Inutilizar");
        ImprimirjButton1.setToolTipText("Imprimir");
        ImprimirjButton1.setFocusable(false);
        ImprimirjButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ImprimirjButton1.setMaximumSize(new java.awt.Dimension(80, 90));
        ImprimirjButton1.setMinimumSize(new java.awt.Dimension(80, 90));
        ImprimirjButton1.setPreferredSize(new java.awt.Dimension(80, 90));
        ImprimirjButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        ImprimirjButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImprimirjButton1ActionPerformed(evt);
            }
        });
        BarradeTarefasjToolBar.add(ImprimirjButton1);

        ImprimirjButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/impressao.png"))); // NOI18N
        ImprimirjButton.setText("Imprimir");
        ImprimirjButton.setToolTipText("Imprimir");
        ImprimirjButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ImprimirjButton.setMaximumSize(new java.awt.Dimension(80, 90));
        ImprimirjButton.setMinimumSize(new java.awt.Dimension(80, 90));
        ImprimirjButton.setPreferredSize(new java.awt.Dimension(80, 90));
        ImprimirjButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        ImprimirjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImprimirjButtonActionPerformed(evt);
            }
        });
        BarradeTarefasjToolBar.add(ImprimirjButton);

        ImprimirjButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/impressao.png"))); // NOI18N
        ImprimirjButton2.setText("Carta");
        ImprimirjButton2.setToolTipText("Imprimir");
        ImprimirjButton2.setFocusable(false);
        ImprimirjButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ImprimirjButton2.setMaximumSize(new java.awt.Dimension(80, 90));
        ImprimirjButton2.setMinimumSize(new java.awt.Dimension(80, 90));
        ImprimirjButton2.setPreferredSize(new java.awt.Dimension(80, 90));
        ImprimirjButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        ImprimirjButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImprimirjButton2ActionPerformed(evt);
            }
        });
        BarradeTarefasjToolBar.add(ImprimirjButton2);

        VisualizarjButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/visualizar.png"))); // NOI18N
        VisualizarjButton.setText("Pesquisar");
        VisualizarjButton.setToolTipText("Visualizar Cadastro");
        VisualizarjButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        VisualizarjButton.setMaximumSize(new java.awt.Dimension(80, 90));
        VisualizarjButton.setMinimumSize(new java.awt.Dimension(80, 90));
        VisualizarjButton.setPreferredSize(new java.awt.Dimension(80, 90));
        VisualizarjButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        VisualizarjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VisualizarjButtonActionPerformed(evt);
            }
        });
        BarradeTarefasjToolBar.add(VisualizarjButton);

        RelatoriojButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/relatorio.png"))); // NOI18N
        RelatoriojButton.setText("Email");
        RelatoriojButton.setToolTipText("Relatórios");
        RelatoriojButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        RelatoriojButton.setMaximumSize(new java.awt.Dimension(80, 90));
        RelatoriojButton.setMinimumSize(new java.awt.Dimension(80, 90));
        RelatoriojButton.setPreferredSize(new java.awt.Dimension(80, 90));
        RelatoriojButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        RelatoriojButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatoriojButtonActionPerformed(evt);
            }
        });
        BarradeTarefasjToolBar.add(RelatoriojButton);

        RelatoriojButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/contamais.png"))); // NOI18N
        RelatoriojButton1.setText("Relação");
        RelatoriojButton1.setToolTipText("Relação de Arquivos XML para Cotnador");
        RelatoriojButton1.setFocusable(false);
        RelatoriojButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        RelatoriojButton1.setMaximumSize(new java.awt.Dimension(80, 90));
        RelatoriojButton1.setMinimumSize(new java.awt.Dimension(80, 90));
        RelatoriojButton1.setPreferredSize(new java.awt.Dimension(80, 90));
        RelatoriojButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        RelatoriojButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatoriojButton1ActionPerformed(evt);
            }
        });
        BarradeTarefasjToolBar.add(RelatoriojButton1);

        FecharrjButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/voltar.png"))); // NOI18N
        FecharrjButton1.setText("Fechar");
        FecharrjButton1.setToolTipText("Fechar");
        FecharrjButton1.setFocusable(false);
        FecharrjButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        FecharrjButton1.setMaximumSize(new java.awt.Dimension(80, 90));
        FecharrjButton1.setMinimumSize(new java.awt.Dimension(80, 90));
        FecharrjButton1.setPreferredSize(new java.awt.Dimension(80, 90));
        FecharrjButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        FecharrjButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FecharrjButton1FecharAssociado(evt);
            }
        });
        BarradeTarefasjToolBar.add(FecharrjButton1);

        notaSaidajTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Cliente", "No. NF-e", "Data Emissão", "Valor Produtos", "Valor da Nota", "Situação"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(notaSaidajTable);
        if (notaSaidajTable.getColumnModel().getColumnCount() > 0) {
            notaSaidajTable.getColumnModel().getColumn(0).setResizable(false);
            notaSaidajTable.getColumnModel().getColumn(1).setResizable(false);
            notaSaidajTable.getColumnModel().getColumn(2).setResizable(false);
            notaSaidajTable.getColumnModel().getColumn(3).setResizable(false);
            notaSaidajTable.getColumnModel().getColumn(4).setResizable(false);
            notaSaidajTable.getColumnModel().getColumn(5).setResizable(false);
        }

        jLabel1.setText("Nome do Cliente");

        nomejTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nomejTextFieldKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 998, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(nomejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(BarradeTarefasjToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, 902, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nomejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BarradeTarefasjToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AdicionarjButtonAdicionarAssociado(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdicionarjButtonAdicionarAssociado
        try {
            apagarArquivoSaidaAcbr();
        } catch (IOException ex) {
            Logger.getLogger(FrmConsultaNotaSaida.class.getName()).log(Level.SEVERE, null, ex);
        }
        new FrmEmitirNotaCliente(config, usuarioLogado, this);
    }//GEN-LAST:event_AdicionarjButtonAdicionarAssociado

    private void PesquisarjButtonPesquisarAssociado(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PesquisarjButtonPesquisarAssociado
        linha = notaSaidajTable.getSelectedRow();
        if (linha>=0){
           cancelarNFe(linha);
        }else {
            JOptionPane.showMessageDialog(rootPane, "Selecione uma Nota Fiscal");
        }
    }//GEN-LAST:event_PesquisarjButtonPesquisarAssociado

    private void ImprimirjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImprimirjButtonActionPerformed
        int linha = notaSaidajTable.getSelectedRow();
        if (linha>=0){
            try {
                salvarArquivodeNFe(linha);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(FrmConsultaNotaSaida.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(FrmConsultaNotaSaida.class.getName()).log(Level.SEVERE, null, ex);
            }
            imprimirDANFE(linha);
        }else {
            JOptionPane.showMessageDialog(rootPane, "Selecione uma Nota Fiscal");
        }
    }//GEN-LAST:event_ImprimirjButtonActionPerformed

    private void VisualizarjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VisualizarjButtonActionPerformed
        new FrmFiltrarNotaSaida(config, usuarioLogado, this);
    }//GEN-LAST:event_VisualizarjButtonActionPerformed

    private void RelatoriojButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatoriojButtonActionPerformed
        int linha = notaSaidajTable.getSelectedRow();
        if (linha>=0){
            try {
                salvarArquivodeNFe(linha);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(FrmConsultaNotaSaida.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(FrmConsultaNotaSaida.class.getName()).log(Level.SEVERE, null, ex);
            }
            enviarEmailNFeCliente(linha);
        }else {
            JOptionPane.showMessageDialog(rootPane, "Selecione uma Nota Fiscal");
        }
    }//GEN-LAST:event_RelatoriojButtonActionPerformed

    private void FecharrjButton1FecharAssociado(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FecharrjButton1FecharAssociado
         this.dispose();     
    }//GEN-LAST:event_FecharrjButton1FecharAssociado

    private void RelatoriojButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatoriojButton1ActionPerformed
        new FrmGerarAquuivosContador(config);
    }//GEN-LAST:event_RelatoriojButton1ActionPerformed

    private void AdicionarjButton1AdicionarAssociado(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdicionarjButton1AdicionarAssociado
        new FrmEmitirNotaFornecedor(config, usuarioLogado, this);
    }//GEN-LAST:event_AdicionarjButton1AdicionarAssociado

    private void nomejTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomejTextFieldKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            carregarModelConsultaNotaSaidaCliente(nomejTextField.getText());
        }
    }//GEN-LAST:event_nomejTextFieldKeyPressed

    private void PesquisarjButton1PesquisarAssociado(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PesquisarjButton1PesquisarAssociado
        int linha = notaSaidajTable.getSelectedRow();
        if (linha>=0){
            new FrmCartaoCorrecao(listaNotaSaida.get(linha), config);
        }else JOptionPane.showMessageDialog(rootPane, "Selecione uma NF-e");
    }//GEN-LAST:event_PesquisarjButton1PesquisarAssociado

    private void ImprimirjButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImprimirjButton1ActionPerformed
        new FrmInutilizarNFe(config);
    }//GEN-LAST:event_ImprimirjButton1ActionPerformed

    private void ImprimirjButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImprimirjButton2ActionPerformed
        int linha = notaSaidajTable.getSelectedRow();
        if (linha >= 0) {
            String url = ("telas/NotaSaida/CartaoCorrecao/reportCartaCorrecao.jasper");
            Notasaida notaSaida = listaNotaSaida.get(linha);
            if (notaSaida.getProtocolo()!=null) {
                Map parameters = new HashMap();
                try {
                    parameters.put("chave", notaSaida.getChaveAutorizacao());
                    parameters.put("nfe", String.valueOf(notaSaida.getNumero()));
                    parameters.put("protocolo", notaSaida.getProtocolo());
                    parameters.put("data", notaSaida.getDatacorrecao());
                    parameters.put("correcao", notaSaida.getEvento());
                    parameters.put("idempresa", this.config.getEmpresa().getIdempresa());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Não foi possível gerar o relatório " + ex);
                    ex.printStackTrace();
                }
                new relatoriosJasper(url, parameters);
            } else {
                JOptionPane.showMessageDialog(rootPane, "NF-e não possui carta de correção");
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Selecione uma NF-e");
        }

    }//GEN-LAST:event_ImprimirjButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AdicionarjButton;
    private javax.swing.JButton AdicionarjButton1;
    private javax.swing.JToolBar BarradeTarefasjToolBar;
    private javax.swing.JButton FecharrjButton1;
    private javax.swing.JButton ImprimirjButton;
    private javax.swing.JButton ImprimirjButton1;
    private javax.swing.JButton ImprimirjButton2;
    private javax.swing.JButton PesquisarjButton;
    private javax.swing.JButton PesquisarjButton1;
    private javax.swing.JButton RelatoriojButton;
    private javax.swing.JButton RelatoriojButton1;
    private javax.swing.JToolBar.Separator SeparadordeTarefasjSeparator;
    private javax.swing.JButton VisualizarjButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nomejTextField;
    private javax.swing.JTable notaSaidajTable;
    // End of variables declaration//GEN-END:variables
    
    public void carregarModelConsultaNotaSaida() {
        NotaSaidaController notaSaidaController = new NotaSaidaController();
        String data = null;
        try {
            data = Formatacao.SubtarirDatas(new Date(), 60, "yyyy-MM-dd");
        } catch (Exception ex) {
            Logger.getLogger(FrmConsultaNotaSaida.class.getName()).log(Level.SEVERE, null, ex);
        }
        listaNotaSaida = notaSaidaController.consultarNotaSaida(data);
        if (listaNotaSaida==null){
            listaNotaSaida = new ArrayList<Notasaida>();
        }
        carregarModelNotaSaida();
    }
    
    public void carregarModelConsultaNotaSaidaCliente(String nomeCliente) {
        NotaSaidaController notaSaidaController = new NotaSaidaController();
        String sql = "select n from Notasaida n where n.nome like '" + nomeCliente + "%' order by n.numero"; ;
        listaNotaSaida = notaSaidaController.filtrarNotaSaida(sql);
        if (listaNotaSaida==null){
            listaNotaSaida = new ArrayList<Notasaida>();
        }
        carregarModelNotaSaida();
    }
    
    public void carregarModelNotaSaida(){
        model = new ConsultaNotaSaidaTableModel(listaNotaSaida);
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.RIGHT);   
        notaSaidajTable.setModel(model);
        notaSaidajTable.getColumnModel().getColumn(0).setPreferredWidth(400);
        notaSaidajTable.getColumnModel().getColumn(1).setPreferredWidth(20);
        notaSaidajTable.getColumnModel().getColumn(2).setPreferredWidth(40);
        notaSaidajTable.getColumnModel().getColumn(3).setCellRenderer(renderer);
        notaSaidajTable.getColumnModel().getColumn(3).setPreferredWidth(50);
        notaSaidajTable.getColumnModel().getColumn(4).setCellRenderer(renderer);
        notaSaidajTable.getColumnModel().getColumn(4).setPreferredWidth(50);
        notaSaidajTable.getColumnModel().getColumn(5).setPreferredWidth(50);
        notaSaidajTable.repaint();
    }
    
    public void apagarArquivoSaidaAcbr() throws IOException {
       File arqSaida = new File(this.config.getCaminhoAcbr() + "sainfe.txt");
        if (arqSaida.exists()) {
            arqSaida.delete();
        }
        arqSaida = new File(this.config.getCaminhoAcbr() + "LOG.txt");
        if (arqSaida.exists()) {
            arqSaida.delete();
        }
        File folder = new File(this.config.getCaminhoNFe());
        if (folder.isDirectory()) {
            File[] sun = folder.listFiles();
            for (File toDelete : sun) {
                toDelete.delete();
            }
        }
    }
    
    public void enviarEmailNFeCliente(int linha){
        email = JOptionPane.showInputDialog("Adicionar CCO separar por ;");
        Cliente cliente = new Cliente();
        ClienteController clienteController = new ClienteController();
        cliente = clienteController.consultarClienteId(listaNotaSaida.get(linha).getIdcliente());
        String cEmailDestino = cliente.getEmail();
        String cArqXML = this.config.getCaminhoNFe() + listaNotaSaida.get(linha).getNomeArquivoXML();
        String cEnviaPDF = "1";
        String cAssunto = "Segue em Anexo NF-e da empresa " + this.config.getEmpresa().getRazaoSocial();
        String cEmailsCopias = "";
        if ((email!=null)){
            cEmailsCopias = cEmailsCopias + ";" + email;
        }
        String texto = "NFe.EnviarEmail(" + cEmailDestino+ "," + 
                cArqXML + "," + cEnviaPDF + "," + cAssunto + "," +
                        cEmailsCopias+")";
        gerarArquivoAcbr(texto);
        email=null;
    }
    
    public void gerarArquivoAcbr(String texto) {
        try {
            FileWriter acbr = new FileWriter(new File(this.config.getCaminhoAcbr() + "ENTNFE.txt"));
            acbr.write(texto);
            acbr.close();
        } catch (IOException ex) {
            Logger.getLogger(FrmEmitirNotaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
       
   }
    
    public void salvarArquivodeNFe(int linha) throws FileNotFoundException, IOException{
        String caminho = this.config.getCaminhoNFe() + listaNotaSaida.get(linha).getNomeArquivoXML();
        File file = new File(caminho);
        FileOutputStream in = new FileOutputStream(file) ;    
        in.write(listaNotaSaida.get(linha).getXml());  
        in.close();  
    }
    
    public void imprimirDANFE(int linha){
        String cArqXML = this.config.getCaminhoNFe() + listaNotaSaida.get(linha).getNomeArquivoXML();
        String texto = "NFe.ImprimirDANFE("+ cArqXML + ")";
        gerarArquivoAcbr(texto);
    }
    
    public void cancelarNFe(int linha){
        String cChaveNFe = "";
        cChaveNFe = listaNotaSaida.get(linha).getChaveAutorizacao();
        cJustificativa = JOptionPane.showInputDialog("Informe o Motivo do Cancelamento");
        String texto = "NFe.CancelarNFe("+ cChaveNFe + "," + cJustificativa + ")";
        gerarArquivoAcbr(texto);
        Timer timer = new Timer();
        timer.schedule(new RemindTask(), 10 * 1000);
    }    

    public void inlcluirProdutoContas(Object objeto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void incluirProdutoVenda(Object objeto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void consultarCliente(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void finalizarBuscaTerminalCliente(Terminalcliente terminalCliente) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void carregarArquivoXMLLocalizado(File file) {
        if (file != null) {
            arquivoXML = file;
            try {
                listaNotaSaida.get(linha).setXmlcancelada(carregarXML());
                listaNotaSaida.get(linha).setSituacao("CANCELADA");
                listaNotaSaida.get(linha).setMotivocancelamento(cJustificativa);
                NotaSaidaController notaSaidaController = new NotaSaidaController();
                notaSaidaController.salvarNotaSaida(listaNotaSaida.get(linha));
                imprimirEventoCancelamento();
            } catch (IOException ex) {
                Logger.getLogger(FrmConsultaNotaSaida.class.getName()).log(Level.SEVERE, null, ex);
            }
;
        } else {
            JOptionPane.showMessageDialog(rootPane, "Erro carregar Arquivo XML");
        }
    }

    public void carregarFaturas(FaturaBean fatura, List<DuplicataBean> listaDuplicata) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setModel() {
        carregarModelConsultaNotaSaida();
    }

    public void filtrarNotaSaida(String sql) {
        NotaSaidaController notaSaidaController = new NotaSaidaController();
        listaNotaSaida = notaSaidaController.filtrarNotaSaida(sql);
        if (listaNotaSaida==null){
            listaNotaSaida = new ArrayList<Notasaida>();
        }
        carregarModelNotaSaida();
    }

    public void consultaFornecedor(Fornecedor fornecedor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setMunicipio(Municipios municipios) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void utilizarCreditos(List<CreditoBean> listaCreditos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setDocEntrada(Docentrada docEntrada) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    
    class RemindTask extends TimerTask {

        public void run() {
            try {
                lerArquivoSaidaAcbr();
            } catch (IOException ex) {
                Logger.getLogger(FrmConsultaNotaSaida.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void lerArquivoSaidaAcbr() throws IOException{
       File arqSaida = new File(this.config.getCaminhoAcbr() + "sainfe.txt");
        String xml = null;
        while (!arqSaida.exists()) {
            arqSaida = new File(this.config.getCaminhoAcbr() + "sainfe.txt");
        }
        if (!arqSaida.exists()){
            JOptionPane.showMessageDialog(rootPane, "Arquivo de Saída não Localizado");
        }
        FileReader sainfe = new FileReader(arqSaida);
        BufferedReader leitor = new BufferedReader(sainfe);
        xml = leitor.readLine();
        String linha = xml.substring(0, 2);
        if (linha.equalsIgnoreCase("OK")) {
            JOptionPane.showMessageDialog(rootPane, "Nota Fiscal Cancelada com Sucesso");
            NotaSaidaController notaSaidaController = new NotaSaidaController();
            listaNotaSaida.get(this.linha).setSituacao("CANCELADA");
            listaNotaSaida.get(this.linha).setMotivocancelamento(cJustificativa);
            notaSaidaController.salvarNotaSaida(listaNotaSaida.get(this.linha));
            //new FrmLocalizarArquivoNFe(this, this.config.getCaminhoNFe());
        }else {
            JOptionPane.showMessageDialog(rootPane, "Erro oa gerar Nota Fiscal");
        }
        leitor.close();
        carregarModelNotaSaida();
    }
    
    public byte[] carregarXML() throws IOException {
        File file = arquivoXML;
        InputStream is = new FileInputStream(file);
        byte[] xml = new byte[(int) file.length()];
        int offset = 0;
        int numRead = 0;
        while (offset < xml.length
                && (numRead = is.read(xml, offset, xml.length - offset)) >= 0) {
            offset += numRead;
        }
     
        return xml;
    }
    
    public void imprimirEventoCancelamento(){
        String texto = "NFe.ImprimirEvento(";
        String chave = arquivoXML.getAbsolutePath();
        texto = texto + "\"" + chave + "\"" + ")";
        gerarArquivoAcbr(texto);
    }
}