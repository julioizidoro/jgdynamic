/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Regras;

import facade.CodigoFiscalFacade;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Codigofiscal;


/**
 *
 * @author wolverine
 */
public class CodigoFiscalController {
    
    CodigoFiscalFacade codigoFiscalFacade;
    
    public void salvar(Codigofiscal codigoFiscal) {
        codigoFiscalFacade = new CodigoFiscalFacade();
        try {
            codigoFiscalFacade.salvar(codigoFiscal);
        } catch (Exception ex) {
            Logger.getLogger(CodigoFiscalController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro salvar códgio fiscal " +ex);
        }
    }
    
    public List<Codigofiscal> listarCodigoFiscal(String tipo) {
        codigoFiscalFacade = new CodigoFiscalFacade();
        try {
            return codigoFiscalFacade.listarCodigoFiscal(tipo);
        } catch (Exception ex) {
            Logger.getLogger(CodigoFiscalController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro listar códgio fiscal " +ex);
            return null;
        }
    }
    
}
