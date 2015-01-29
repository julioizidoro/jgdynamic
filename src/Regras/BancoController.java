/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Regras;

import facade.BancoFacade;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Banco;

/**
 *
 * @author Wolverine
 */
public class BancoController {
    
    BancoFacade bancoFacade;
    
    public void salvar(Banco banco)  {
        bancoFacade = new BancoFacade();
        try {
            bancoFacade.salvar(banco);
        } catch (Exception ex) {
            Logger.getLogger(BancoController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Salvar Banco " + ex);
        }
    }
    
    public List<Banco> listar() {
        bancoFacade = new BancoFacade();
        try {
            return bancoFacade.listar();
        } catch (Exception ex) {
            Logger.getLogger(BancoController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Listar Banco " + ex);
            return null;
        }
    }
    
    public List<Banco> listar(String nomeAgencia) {
        bancoFacade = new BancoFacade();
        try {
            return bancoFacade.listar(nomeAgencia);
        } catch (Exception ex) {
            Logger.getLogger(BancoController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Listar Banco " + ex);
            return null;
        }
    }
    
}
