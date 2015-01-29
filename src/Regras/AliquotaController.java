/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Regras;

import facade.AliquotaFacade;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Aliquota;

/**
 *
 * @author Wolverine
 */
public class AliquotaController {
    
    AliquotaFacade  aliquotaFacade = new AliquotaFacade();
    
    public Aliquota buscarAliquotaid(int idAliquota) {
        aliquotaFacade = new AliquotaFacade();
        try {
            Aliquota aliquota = aliquotaFacade.buscarAliquotaid(idAliquota);
            return aliquota;
        } catch (SQLException ex) {
            Logger.getLogger(AliquotaController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Consultar Aliquota " + ex);
            return null;
        }
    }
    
}
