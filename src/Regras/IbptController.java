/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Regras;

import facade.IbptFacade;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Ibpt;

/**
 *
 * @author Wolverine
 */
public class IbptController {
    
    IbptFacade ibptFacade;
    
    public Ibpt cunsultarIbpt(String ncm) {
        ibptFacade = new IbptFacade();
        try {
            return ibptFacade.cunsultarIbpt(ncm);
        } catch (SQLException ex) {
            Logger.getLogger(IbptController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Consultar NCM " + ex);
            return null;
        }
    }
    
    public List<Ibpt> listarIbpt(String descricao) {
        ibptFacade = new IbptFacade();
        try {
            return ibptFacade.listarIbpt(descricao);
       } catch (SQLException ex) {
            Logger.getLogger(IbptController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Consultar NCM " + ex);
            return null;
        }
    }
    
}
