/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Regras;

import facade.MunicipiosFacade;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Municipios;

/**
 *
 * @author wolverine
 */
public class MunicipiosController {
    
    MunicipiosFacade municipiosFacade;
    
    public List<Municipios> listarMunicipios() {
        municipiosFacade = new MunicipiosFacade();
        try {
            return municipiosFacade.listarMunicipios();
        } catch (SQLException ex) {
            Logger.getLogger(MunicipiosController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Listar Municipios " + ex);
            return null;
        }
    }
        
    public List<Municipios> listarMunicipios(String nomeMunicipio) {
        municipiosFacade = new MunicipiosFacade();
        try {
            return municipiosFacade.listarMunicipios(nomeMunicipio);
        } catch (SQLException ex) {
            Logger.getLogger(MunicipiosController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Consultar Municipio " + ex);
            return null;
        }
    }  

    public Municipios getMunicipio(int idMunicipio) {
        municipiosFacade = new MunicipiosFacade();
        try {
            return municipiosFacade.getMunicipio(idMunicipio);
        } catch (SQLException ex) {
            Logger.getLogger(MunicipiosController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro pesquisar Municipio " + ex);
            return null;
        }
    }
}
