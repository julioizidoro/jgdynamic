/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Regras;

import facade.EmpresaFacade;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Empresa;

/**
 *
 * @author Wolverine
 */
public class EmpresaController {
    
    public Empresa consultarEmpresa(int idEmpresa){
        EmpresaFacade empresaFacade = new EmpresaFacade();
        try {
            return empresaFacade.buscarEmpresa(idEmpresa);
        } catch (SQLException ex) {
            Logger.getLogger(EmpresaController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Consultar Empresa");
            return null;
        }
    }
    
    public List<Empresa> listarEmpresas(){
        EmpresaFacade empresaFacade = new EmpresaFacade();
        try {
            return empresaFacade.buscarEmpresa();
        } catch (SQLException ex) {
            Logger.getLogger(EmpresaController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Listar Empresas");
            return null;
        }
    }
    
    public Empresa salvar(Empresa empresa) {
        EmpresaFacade empresaFacade = new EmpresaFacade();
        try {
            return empresaFacade.salvar(empresa);
        } catch (SQLException ex) {
            Logger.getLogger(EmpresaController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Salvar Empresa " + ex);
            return null;
        }
    }
    
}
