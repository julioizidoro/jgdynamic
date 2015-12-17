/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Regras;

import facade.CestFacade;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Cest;
import model.Ibpt;

/**
 *
 * @author Wolverine
 */
public class CestController {
    
    CestFacade ibptFacade;
    
    public Ibpt cunsultarIbpt(String ncm) {
        ibptFacade = new CestFacade();
        try {
            return ibptFacade.cunsultarIbpt(ncm);
        } catch (SQLException ex) {
            Logger.getLogger(CestController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Consultar NCM " + ex);
            return null;
        }
    }
    
    public List<Cest> listar(String descricao) {
        ibptFacade = new CestFacade();
        try {
            return ibptFacade.listar(descricao);
       } catch (SQLException ex) {
            Logger.getLogger(CestController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Consultar NCM " + ex);
            return null;
        }
    }
    
    public Cest cunsultarCest(String ncm) {
        ibptFacade = new CestFacade();
        try {
            return ibptFacade.cunsultarCest(ncm);
        } catch (SQLException ex) {
            Logger.getLogger(CestController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Consultar NCM " + ex);
            return null;
        }
    }
    
}
