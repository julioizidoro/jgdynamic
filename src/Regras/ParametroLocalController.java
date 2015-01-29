/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Regras;

import facade.ParametroLocalFacade;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.ParametrosLocal;

/**
 *
 * @author wolverine
 */
public class ParametroLocalController {
    
    ParametroLocalFacade parametroLocalFacade;
    
    public void salvar(ParametrosLocal parametros) {
        parametroLocalFacade = new ParametroLocalFacade();
        try {
            parametroLocalFacade.salvar(parametros);
        } catch (Exception ex) {
            Logger.getLogger(ParametroLocalController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro salvar Parametro Local " + ex);
        }
    }
    
    public ParametrosLocal localizarParametro(int idParametro) {
        parametroLocalFacade = new ParametroLocalFacade();
        try {
            return parametroLocalFacade.localizarParametro(idParametro);
        } catch (Exception ex) {
            Logger.getLogger(ParametroLocalController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Localizar Parametro Local " +ex);
            return null;
        }
    }
    
    public ParametrosLocal localizarEmpresa(int idEmpresa) {
        parametroLocalFacade = new ParametroLocalFacade();
        try {
            return parametroLocalFacade.localizarEmpresa(idEmpresa);
        } catch (Exception ex) {
            Logger.getLogger(ParametroLocalController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Localizar Parametro Local " +ex);
            return null;
        }
    }
    
    
    
}
