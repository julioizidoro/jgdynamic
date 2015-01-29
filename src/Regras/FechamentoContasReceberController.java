/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Regras;

import facade.FechamentoContasReceberFacade;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.FechamentoCliente;
import model.FechamentoMes;
import view.ViewClienteFechamento;

/**
 *
 * @author wolverine
 */
public class FechamentoContasReceberController {

    public FechamentoContasReceberFacade fechamentoContasReceberFacade;
    
    public FechamentoMes salvarFechamentoMes(FechamentoMes mes){
        fechamentoContasReceberFacade = new FechamentoContasReceberFacade();
        try {
            return fechamentoContasReceberFacade.salvarFechamentoMes(mes);
        } catch (SQLException ex) {
            Logger.getLogger(FechamentoContasReceberController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Salvar Fechamento Mes " + mes);
            return null;
        }
    }
    
    public FechamentoCliente salvarFechamentoCliente(FechamentoCliente fechamentoCliente) {
        fechamentoContasReceberFacade = new FechamentoContasReceberFacade();
        try {
            return fechamentoContasReceberFacade.salvarFechamentoCliente(fechamentoCliente);
        } catch (SQLException ex) {
            Logger.getLogger(FechamentoContasReceberController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Salvar Fechamento Cliente " + ex);
            return null;
        }
    }
    
    public void  apagarFechamentoCliente(FechamentoCliente fechamentoCliente) {
        fechamentoContasReceberFacade = new FechamentoContasReceberFacade();
        try {
            fechamentoContasReceberFacade.apagarFechamentoCliente(fechamentoCliente);
        } catch (SQLException ex) {
            Logger.getLogger(FechamentoContasReceberController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro apagar fechamento cliente " + ex);
        }
    }
    
    public FechamentoCliente consultarFechamentoCliente(int idcliente, int mes) {
        fechamentoContasReceberFacade = new FechamentoContasReceberFacade();
        try {
            return fechamentoContasReceberFacade.consultarFechamentoCliente(idcliente, mes);
        } catch (SQLException ex) {
            Logger.getLogger(FechamentoContasReceberController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Consultar Fechamento Cliente " + ex);
            return null;
        }
    }
    
    public List<FechamentoCliente> ListaFechamentoCliente(int idFechamentoMes) {
        fechamentoContasReceberFacade = new FechamentoContasReceberFacade();
        try {
            return fechamentoContasReceberFacade.ListaFechamentoCliente(idFechamentoMes);
        } catch (SQLException ex) {
            Logger.getLogger(FechamentoContasReceberController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Listar Fechametno Cliente " + ex);
            return null;
        }
    }
    
    public FechamentoMes consultaFechamentoMes(String mes) {
        fechamentoContasReceberFacade= new FechamentoContasReceberFacade();
        try {
            return fechamentoContasReceberFacade.consultaFechamentoMes(mes);
        } catch (SQLException ex) {
            Logger.getLogger(FechamentoContasReceberController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro consultar fechamento mes " + mes);
            return null;
        }
    }
    
    public List<ViewClienteFechamento> consultaFechamentoCliente(int idMes) {
        fechamentoContasReceberFacade = new FechamentoContasReceberFacade();
        try {
            return fechamentoContasReceberFacade.consultaFechamentoCliente(idMes);
        } catch (SQLException ex) {
            Logger.getLogger(FechamentoContasReceberController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Consultar Fechamento Cliente " + ex);
            return null;
        }
    }
    
    public void exportarFechamentoClinte(String nomeRelatorio, String linhaBanco, String banco, String sql, String usuario, String senha) {
        fechamentoContasReceberFacade = new FechamentoContasReceberFacade();
        try {
            fechamentoContasReceberFacade.exportarFechamentoClinte(nomeRelatorio, linhaBanco, banco, sql, usuario, senha);
        } catch (IOException ex) {
            Logger.getLogger(FechamentoContasReceberController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Exportar Fechamento para Excel " + ex);
        }
    }
    
}
