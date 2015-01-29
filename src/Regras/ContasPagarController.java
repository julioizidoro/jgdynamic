/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Regras;

import facade.ContasPagarFacade;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Contaspagar;
import model.Formacontaspagar;
import model.Pagamentocontaspagar;
import model.View.Viewcontaspagar;

/**
 *
 * @author Wolverine
 */
public class ContasPagarController {
    
    ContasPagarFacade contasPagarFacade;
        
    public Contaspagar salvar(Contaspagar contasPagar){
        contasPagarFacade = new ContasPagarFacade();
        try {
            return contasPagarFacade.salvar(contasPagar);
        } catch (SQLException ex) {
            Logger.getLogger(ContasPagarController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Salvar Contas Pagar " + ex);
            return null;
        }
    }
    
    public void excluir(Contaspagar contasPagar) {
        contasPagarFacade = new ContasPagarFacade();
        try {
            contasPagarFacade.excluir(contasPagar);
        } catch (SQLException ex) {
            Logger.getLogger(ContasPagarController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Excluir Contas a Pagar " + ex);
        }
    }
    
    public List<Contaspagar> listarContas(String sql) {
        contasPagarFacade = new ContasPagarFacade();
        try {
            return contasPagarFacade.listarContas(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ContasPagarController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Listar Contas Pagar Vencidas " + ex);
            return null;
        }
    }
    
    public Formacontaspagar salvarFormaContasPagar(Formacontaspagar formacontaspagar) {
        contasPagarFacade = new ContasPagarFacade();
        try {
            return contasPagarFacade.salvarFormaContasPagar(formacontaspagar);
        } catch (SQLException ex) {
            Logger.getLogger(ContasPagarController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Salvar Forma de Pagamento Contas a Pagar" + ex);
            return null;
        }
    }
    
    public Pagamentocontaspagar salvarPagamentoContasPagar(Pagamentocontaspagar pagamentocontaspagar){
        contasPagarFacade = new ContasPagarFacade();
        try {
            return contasPagarFacade.salvarPagamentoContasPagar(pagamentocontaspagar);
        } catch (SQLException ex) {
            Logger.getLogger(ContasPagarController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,  "Erro Salvar Pagamento Contas a Pagar " + ex);
            return null;
        }
        
    }
    
    public Float calcularValorContaPagarDia(String data) {
        contasPagarFacade = new ContasPagarFacade();
        try {
            return contasPagarFacade.calcularValorContaPagarDia(data);
        } catch (SQLException ex) {
            Logger.getLogger(ContasPagarController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Calcular Total Contas a Pagar " + ex);
            return null;
        }
    }
    
    public List<Viewcontaspagar> listarContasView(String sql) {
        contasPagarFacade = new ContasPagarFacade();
        try {
            return contasPagarFacade.listarContasView(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ContasPagarController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Listar Contas Pagar Vencidas " + ex);
            return null;
        }
    }
    
    public ResultSet ExportarExcel(String nomeRelatorio, String local, String porta, String senha, String banco, String usuario, String caminhoSalvarExcel, String sql) {
        contasPagarFacade = new ContasPagarFacade();
        try {
            return contasPagarFacade.ExportarExcel(nomeRelatorio, local, porta, senha, banco, usuario, caminhoSalvarExcel, sql);
        } catch (IOException ex) {
            Logger.getLogger(ContasPagarController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Exportar para Excel " + ex);
            return null;
        }
    }
    
    
    
}
