/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Regras;

import facade.AcessoFacade;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Acesso;

/**
 *
 * @author Wolverine
 */
public class AcessoController {
    
    AcessoFacade acessoFacade;
    
    public Acesso getAcessoUsuario(int idUsuario)  {
        acessoFacade = new AcessoFacade();
        try {
            return acessoFacade.getAcessoUsuario(idUsuario);
        } catch (SQLException ex) {
            Logger.getLogger(AcessoController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Consultar Acesso "  + ex);
            return null;
        }
    }
    
}
