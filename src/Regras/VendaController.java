/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Regras;

import dao.VendaDao;
import facade.VendaFacade;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Saida;
import model.Venda;

/**
 *
 * @author Wolverine
 */
public class VendaController {
    
    public List<Venda> listarVendaPeriodo(String dataInicial, String dataFinal){
        VendaFacade vendaFacade = new VendaFacade();
        try {
            List<Venda> listaVenda = vendaFacade.listarVendaPeriodo(dataInicial, dataFinal);
            return listaVenda;
        } catch (SQLException ex) {
            Logger.getLogger(VendaController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Consultar Vendas Período " + ex);
            return null;
        }
        
        
    }
    
    public List<Saida> listarSaidaVenda(int idVenda){
        VendaFacade vendaFacade = new VendaFacade();
        try {
            return vendaFacade.listarSaidaVenda(idVenda);
        } catch (Exception ex) {
            Logger.getLogger(VendaController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro consultar Saida " + ex);
            return null;
        }
    }
    
    public List<Venda> ListarVenda(int idFechaCaixa) {
        VendaFacade vendaFacade = new VendaFacade();
        try {
            return vendaFacade.ListarVenda(idFechaCaixa);
        } catch (Exception ex) {
            Logger.getLogger(VendaController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Consultar Vendas " + ex);
            return null;
        }
    }
    
    public Venda getVenda(int idVenda) {
        VendaFacade vendaFacade = new VendaFacade();
        try {
            return vendaFacade.getVenda(idVenda);
        } catch (Exception ex) {
            Logger.getLogger(VendaController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Consultar Venda " + ex);
            return null;
        }
    }
    
    public double ValorVendida(int idProduto, String dataInicial, String dataFinal){
        VendaFacade vendaFacade = new VendaFacade();
        try {
            return vendaFacade.ValorVenda(idProduto, dataInicial, dataFinal);
        } catch (SQLException ex) {
            Logger.getLogger(VendaController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Listar Valor Venda " + ex);
            return 0;
        }
    }
    
    public double quantidadeVendida(int idProduto, String dataInicial, String dataFinal) {
        VendaFacade  vendaFacade = new VendaFacade();
        try {
            return vendaFacade.quantidadeVendida(idProduto, dataInicial, dataFinal);
        } catch (SQLException ex) {
            Logger.getLogger(VendaController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro consultar valor venda " + ex);
            return 0;
        }
        
    }
    
    public Float valorFormaPagamento(int idFormaPagamento, int idFechaCaixa) {
        VendaFacade vendaFacade = new VendaFacade();
        try {
            return  vendaFacade.valorFormaPagamento(idFormaPagamento, idFechaCaixa);
        } catch (SQLException ex) {
            Logger.getLogger(VendaController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Consultar Valor Venda por Forma de Pagamento " + ex);
            return 0.0f;
        }
    }
    
    public List<Venda> getVenda(String sql) {
        VendaFacade vendaFacade = new VendaFacade();
        try {
            return vendaFacade.getVenda(sql);
        } catch (Exception ex) {
            Logger.getLogger(VendaController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Listar Vednas " + ex);
            return null;
        }
    }
}
