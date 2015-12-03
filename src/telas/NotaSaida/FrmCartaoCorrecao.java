/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas.NotaSaida;

import Regras.NotaSaidaController;
import controler.Config;
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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Cliente;
import model.Docentrada;
import model.Fornecedor;
import model.Municipios;
import model.Notasaida;
import model.Terminalcliente;
import telas.ContasReceber.CreditoBean;
import telas.NotaSaida.Fatura.DuplicataBean;
import telas.NotaSaida.Fatura.FaturaBean;
import telas.NotaSaida.FrmConsultaNotaSaida.RemindTask;

/**
 *
 * @author Wolverine
 */
public class FrmCartaoCorrecao extends javax.swing.JFrame implements INotaSaidaBean {
    
    private Notasaida notaSaida;
    private Config config;
    private File arquivoXML;
    private File arquivoNFe;

    /**
     * Creates new form FrmCartaoCorrecao
     */
    public FrmCartaoCorrecao(Notasaida notaSaida, Config config) {
        this.notaSaida= notaSaida;
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
        jScrollPane1 = new javax.swing.JScrollPane();
        motivojTextArea = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Emissão de Carta de Correção");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        motivojTextArea.setColumns(1);
        motivojTextArea.setRows(10);
        jScrollPane1.setViewportView(motivojTextArea);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/tick.png"))); // NOI18N
        jButton1.setText("Enviar");
        jButton1.setToolTipText("Envia arquivo XML para SEFAZ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cross.png"))); // NOI18N
        jButton2.setText("Cancelar");
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
                .addContainerGap(49, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(65, 65, 65)
                .addComponent(jButton2)
                .addGap(42, 42, 42))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(137, 137, 137)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(122, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String texto = gerarArquivoINI();
        gerarArquivoAcbr(texto);
        Timer timer = new Timer();
        timer.schedule(new RemindTask(), 10 * 1000);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea motivojTextArea;
    // End of variables declaration//GEN-END:variables

    public String gerarArquivoINI(){
        //String arq = "NFE.CARTADECORRECAO(" +  "\"[CCE]\"";
        String arq = "[CCE] \b\n";
        arq = arq + "idLote=1 \b\n";
        arq = arq + "[EVENTO001] \b\n";
        arq = arq + "chNFe=" + notaSaida.getChaveAutorizacao() + " \b\n";
        arq = arq + "cOrgao=42\b\n";
        arq = arq + "CNPJ=" + config.getEmpresa().getCnpj() + " \b\n";
        arq = arq + "dhEvento=" + converterDataUTC() + " \b\n";
        arq = arq + "nSeqEvento=1" +  " \b\n";
        arq = arq + "xCorrecao=" + motivojTextArea.getText();
        String novoArq = "NFE.CARTADECORRECAO(" +  "\"" + arq  + "\"" + ")";
        System.out.println(novoArq);
        return novoArq;
    }
    
    
    public String converterDataUTC(){
        SimpleDateFormat fmtHora = new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat fmtData = new SimpleDateFormat("dd/MM/yyyy");
        Date data = new Date();
        String sHora = fmtHora.format(data);   // isto faz com que mostre do jeito que você quer
        String sData = fmtData.format(data);
        return sData + " " + sHora;
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

    public void inlcluirProdutoContas(Object objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void incluirProdutoVenda(Object objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void consultarCliente(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void finalizarBuscaTerminalCliente(Terminalcliente terminalCliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void carregarArquivoXMLLocalizado(File file) {
        if (file != null) {
            arquivoXML = file;
            try {
                notaSaida.setXmlcarta(carregarXML());
                NotaSaidaController notaSaidaController = new NotaSaidaController();
                notaSaida = notaSaidaController.salvarNotaSaida(notaSaida);
                imprimirCartaoCorrecao();
                salvarArquivodeNFe();
                EnviarEmailCartaoCorrecao();
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void filtrarNotaSaida(String sql) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
            JOptionPane.showMessageDialog(rootPane, "Carta de correção emitida com Sucesso");
            new FrmLocalizarArquivoNFe(this, this.config.getCaminhoNFe());
        }else {
            JOptionPane.showMessageDialog(rootPane, "Erro oa gerar Nota Fiscal");
        }
        leitor.close();
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
     
    public void imprimirCartaoCorrecao(){
        String texto = "NFe.ImprimirEvento(";
        String chave = arquivoXML.getAbsolutePath();
        texto = texto + "\"" + chave + "\"" + ")";
        gerarArquivoAcbr(texto);
    }
    
    public void salvarArquivodeNFe() throws FileNotFoundException, IOException{
        String caminho = this.config.getCaminhoNFe() + notaSaida.getNomearquivocarta();
        arquivoXML = new File(caminho);
        FileOutputStream carta = new FileOutputStream(arquivoXML) ;    
        carta.write(notaSaida.getXmlcarta());  
        carta.close();
    }
    
    public void EnviarEmailCartaoCorrecao(){
        String cdestino = notaSaida.getEmail();
        String cArqEvento = this.arquivoXML.getAbsolutePath();
        String cArqNFe = this.arquivoNFe.getAbsolutePath();
        String cEnviaPDF = "1";
        String cAssunto = "Carta de Correção da NF-e em anexo";
        String cEmailcopia = "";
        String texto = "NFe.EnviarEmailEvento(";
        texto = texto + "\"" + cdestino + "\""  + ","
                + "\"" + cArqEvento + "\"" + "," 
                + "\"" + cArqNFe + "\"" + "," 
                + "\"" + cEnviaPDF + "\"" + "," 
                + "\"" + cAssunto + "\"" + "," 
                + "\"" + cEmailcopia + "\"" 
                + ")";
        gerarArquivoAcbr(texto);
        try {
            apagarArquivoSaidaAcbr();
        } catch (IOException ex) {
            Logger.getLogger(FrmCartaoCorrecao.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        this.dispose();
    }
    
    
}
