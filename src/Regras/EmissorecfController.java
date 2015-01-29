/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Regras;

import facade.EmissorecfFacade;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Emissorecf;

/**
 *
 * @author Julio
 */
public class EmissorecfController {
    
    EmissorecfFacade emissorecfFacade;
    
    public void salvar(Emissorecf emissorEcf) {
        emissorecfFacade = new EmissorecfFacade();
        try {
            emissorecfFacade.salvar(emissorEcf);
        } catch (SQLException ex) {
            Logger.getLogger(EmissorecfController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Salvar Enissor ECF "  + ex);
        }
    }
    
    public List<Emissorecf> listar(int idEmpresa) {
        emissorecfFacade = new EmissorecfFacade();
        try {
            return emissorecfFacade.listar(idEmpresa);
        } catch (SQLException ex) {
            Logger.getLogger(EmissorecfController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Salvar Enissor ECF "  + ex);
            return null;
        }
    }
    
}
