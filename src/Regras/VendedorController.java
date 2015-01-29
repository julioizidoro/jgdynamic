/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Regras;

import facade.VendedorFacade;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Vendedor;

/**
 *
 * @author Wolverine
 */
public class VendedorController {
    
    VendedorFacade vendedorFacade;
    
     public Vendedor salvar(Vendedor vendedor) {
        vendedorFacade = new  VendedorFacade();
        try {
            return vendedorFacade.salvar(vendedor);
        } catch (Exception ex) {
            Logger.getLogger(VendedorController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Salvar Vendedor " + ex);
            return null;
        }
    }
    
    public Vendedor consultarVendedorId(int idVendedor) {
        vendedorFacade = new VendedorFacade();
        try {
            return vendedorFacade.consultarVendedorId(idVendedor);
        } catch (SQLException ex) {
            Logger.getLogger(VendedorController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Consultar Vendedor " + ex);
            return null;
        }
    }
    
    public List<Vendedor> consultarVendedor(String nome, int idEmpresa) {
        vendedorFacade = new VendedorFacade();
        try {
            return vendedorFacade.consultarVendedor(nome, idEmpresa);
        } catch (SQLException ex) {
            Logger.getLogger(VendedorController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Listar Vendedor "  + ex);
            return null;
        }
    }
    
}
