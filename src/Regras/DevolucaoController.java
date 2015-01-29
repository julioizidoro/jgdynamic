/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Regras;

import facade.DevolucaoFacade;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Devolucao;
import model.Enviodevolucaodefeito;
import model.Enviodevolucaodefeitoproduto;
import view.Viewdevolucaodefeitoenviadas;
import view.Viewdevolucaodefeitoproduto;
import view.Viewrelatoriodevolucao;

/**
 *
 * @author Wolverine
 */
public class DevolucaoController {
    
    DevolucaoFacade devolucaoFacade;
    
    public List<Viewrelatoriodevolucao> relatorioDevolucao(String dataInicial, String dataFinal, int idProduto, String condicao){
        devolucaoFacade = new DevolucaoFacade();
        try {
            return devolucaoFacade.relatorioDevolucao(dataInicial, dataFinal, idProduto, condicao);
        } catch (SQLException ex) {
            Logger.getLogger(DevolucaoController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro gerar Relatório de Devolução " + ex);
            return null;
        }
    }
    
    public List<Devolucao> valorDevolucaoPeriodo(String dataInicial, String dataFinal){
        devolucaoFacade = new DevolucaoFacade();
        try {
            List<Devolucao> listaDevolucao =  devolucaoFacade.valorDevolucaoPeriodo(dataInicial, dataFinal);
            return listaDevolucao;
        } catch (Exception ex) {
            Logger.getLogger(DevolucaoController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Consultar Devolucao Período " +ex);
            return null;
        }
    }
    public List<Viewdevolucaodefeitoproduto> listarDevolucaoDefeitoProduto(String sql) {
        devolucaoFacade = new DevolucaoFacade();
        try {
            return devolucaoFacade.listarDevolucaoDefeitoProduto(sql);
        } catch (Exception ex) {
            Logger.getLogger(DevolucaoController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Listar Devolucao Defeito " +ex);
            return null;
        }
    }
    
    public List<Viewdevolucaodefeitoenviadas> listarDevolucaoDefeitoEnviadas() {
        devolucaoFacade = new DevolucaoFacade();
        try {
            return devolucaoFacade.listarDevolucaoDefeitoEnviadas();
        } catch (Exception ex) {
            Logger.getLogger(DevolucaoController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Listar Devolucao Defeito Enviadas" +ex);
            return null;
        }
    }
    
     public Enviodevolucaodefeito salvarEnvioDevolucao(Enviodevolucaodefeito enviodevolucaodefeito){
        devolucaoFacade = new DevolucaoFacade();
        try {
            return devolucaoFacade.salvarEnvioDevolucao(enviodevolucaodefeito);
        } catch (SQLException ex) {
            Logger.getLogger(DevolucaoController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Salvar Envio " + ex);
            return null;
        }
    }
    
    public void salvarDevolucaoDefetio(int idDevolucaoDefeito, int idEnvio) {
        devolucaoFacade = new DevolucaoFacade();
        try {
            devolucaoFacade.salvarDevolucaoDefetio(idDevolucaoDefeito, idEnvio);
        } catch (SQLException ex) {
            Logger.getLogger(DevolucaoController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Salvar Devolução Defeito " + ex);
        }
    }
    
    public void salvarDevolucaoDefeitoProduto(Enviodevolucaodefeitoproduto enviodevolucaodefeitoproduto) {
        devolucaoFacade = new DevolucaoFacade();
        try {
            devolucaoFacade.salvarDevolucaoDefeitoProduto(enviodevolucaodefeitoproduto);
        } catch (SQLException ex) {
            Logger.getLogger(DevolucaoController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Salvar Envio Devolucao Defeito Produto " + ex);
        }
    }
    
    public List<Enviodevolucaodefeito> listarEnvioDevolucaoDefeito(int idEmpresa) {
        devolucaoFacade = new DevolucaoFacade();
        try {
            return devolucaoFacade.listarEnvioDevolucaoDefeito(idEmpresa);
        } catch (SQLException ex) {
            Logger.getLogger(DevolucaoController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Listar Devolucao Defeito " + ex);
            return null;
        }
    }
    
    public Enviodevolucaodefeito consultarEnvioDevolucaoDefeito(int idEnvio) {
        devolucaoFacade = new DevolucaoFacade();
        try {
            return devolucaoFacade.consultarEnvioDevolucaoDefeito(idEnvio);
        } catch (SQLException ex) {
            Logger.getLogger(DevolucaoController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Consultar Envio Devolucao Defeito " + ex);
            return null;
        }
    }
    
    
}
