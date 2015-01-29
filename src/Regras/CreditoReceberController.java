/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Regras;

import facade.CreditoReceberFacade;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Creditoreceberprodutos;
import model.Creditosreceber;

/**
 *
 * @author Wolverine
 */
public class CreditoReceberController {
    
    CreditoReceberFacade creditoReceberFacade;
    
    public Creditosreceber salvar(Creditosreceber creditoReceber) {
        creditoReceberFacade = new CreditoReceberFacade();
        try {
            return creditoReceberFacade.salvar(creditoReceber);
        } catch (SQLException ex) {
            Logger.getLogger(CreditoReceberController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, " Erro Salvar Credito "  + ex);
            return null;
        }
    }
        
    

    public List<Creditosreceber> listarCreditos(String sql) {
        creditoReceberFacade = new CreditoReceberFacade();
        try {
            return creditoReceberFacade.listarCreditos(sql);
        } catch (SQLException ex) {
            Logger.getLogger(CreditoReceberController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Listar Creditos " + ex);
            return null;
        }
    }
    
    public List<Creditoreceberprodutos> listaCreditoProdutos(int idCredito) {
        creditoReceberFacade = new CreditoReceberFacade();
        try {
            return creditoReceberFacade.listaCreditoProdutos(idCredito);
        } catch (SQLException ex) {
            Logger.getLogger(CreditoReceberController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Listar Produtos Credito " + ex);
            return null;
        }
    }
}