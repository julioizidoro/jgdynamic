/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Regras;

import facade.FormaVendaFacade;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Formavenda;

/**
 *
 * @author Wolverine
 */
public class FormaVendaController {
    
    public List<Formavenda> consultarFormaVenda(int idVenda) {
        FormaVendaFacade formaVendaFacade = new FormaVendaFacade();
        try {
            return formaVendaFacade.consultarFormaVenda(idVenda);
        } catch (SQLException ex) {
            Logger.getLogger(FormaVendaController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Consultar Forma Venda " + ex);
            return null;
        }
    }
    
    public void gravarFormaVenda(Formavenda formaVenda) {
        FormaVendaFacade formaVendaFacade = new FormaVendaFacade();
        try {
            formaVendaFacade.gravarFormaVenda(formaVenda);
        } catch (Exception ex) {
            Logger.getLogger(FormaVendaController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro salvar Forma Venda " + ex);
        }
    }
    
}
