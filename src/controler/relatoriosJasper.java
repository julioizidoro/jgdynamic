/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controler;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.swing.JRViewer;
import telas.ContasReceber.Relatorios.RelContasReceberTodas;
import telas.ContasReceber.Relatorios.RelatorioContasReceber;


/**
 *
 * @author Acer
 */
public final class relatoriosJasper {

    private String url;
    private Map parameters = new HashMap();
    private ConfiguracaoSistema configura;
    

    public relatoriosJasper(String url, Map parameters) {
        this.url = url;
        this.parameters = parameters;
        Sigap utilitario = new Sigap();
        configura = new ConfiguracaoSistema();
        configura = (ConfiguracaoSistema) utilitario.deserializarConfiguracao();
        gerarRelatorios();
    }
    
    public relatoriosJasper(String url, Map parameters, boolean data) {
        this.url = url;
        this.parameters = parameters;
        Sigap utilitario = new Sigap();
        configura = new ConfiguracaoSistema();
        configura = (ConfiguracaoSistema) utilitario.deserializarConfiguracao();
        gerarRelatoriosDS();
    }

    

    public void gerarRelatorios(){
        URL is = this.getClass().getClassLoader().getResource(url);
        String conexao = "jdbc:mysql://" + configura.getBdlocal() + ":" + configura.getBdporta() + "/" + configura.getBdNome();
        Connection conn = null;
        try {

            conn = DriverManager.getConnection(conexao,  configura.getBdusuario(), configura.getBdSenha());
            JDialog viewer = new JDialog(new javax.swing.JFrame(), "Visualização do Relatório", false);
            viewer.setSize(1024, 768);
            viewer.setLocationRelativeTo(null);

            
            JasperReport relatoriosJasper = (JasperReport) JRLoader.loadObject(is);
            this.parameters.put("REPORT_CONNECTION", conn);
            
            
            JasperPrint jasperPrint = JasperFillManager.fillReport(relatoriosJasper, this.parameters);
            JRViewer jrViewer = new JRViewer(jasperPrint);
            //JasperViewer jrViewer = new JasperViewer(jasperPrint, true);
            viewer.getContentPane().add(jrViewer);
            viewer.setVisible(true);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível gerar o relatório " + ex);
            ex.printStackTrace();

        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        }

    }
    
    public void gerarRelatoriosDS(){
        URL is = this.getClass().getClassLoader().getResource(url);
        String conexao = "jdbc:mysql://" + configura.getBdlocal() + ":" + configura.getBdporta() + "/" + configura.getBdNome();
        Connection conn = null;
        try {

            conn = DriverManager.getConnection(conexao,  configura.getBdusuario(), configura.getBdSenha());
            JDialog viewer = new JDialog(new javax.swing.JFrame(), "Visualização do Relatório", false);
            viewer.setSize(1024, 768);
            viewer.setLocationRelativeTo(null);

            
            JasperReport relatoriosJasper = (JasperReport) JRLoader.loadObject(is);
            this.parameters.put("REPORT_CONNECTION", conn);
            
            List<RelContasReceberTodas> listaTodas = RelatorioContasReceber.getLista();
            JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(listaTodas);
            
            JasperPrint jasperPrint = JasperFillManager.fillReport(relatoriosJasper, this.parameters, ds);
            JRViewer jrViewer = new JRViewer(jasperPrint);
            //JasperViewer jrViewer = new JasperViewer(jasperPrint, true);
            viewer.getContentPane().add(jrViewer);
            viewer.setVisible(true);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível gerar o relatório " + ex);
            ex.printStackTrace();

        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        }

    }

}
