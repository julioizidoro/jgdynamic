/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Regras;

import facade.UsuariosFacade;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Usuarios;

/**
 *
 * @author Wolverine
 */
public class UsuariosController {
    
    UsuariosFacade usuariosFacede;
    
    public Usuarios consultarUsuario(String login, String senha) {
        usuariosFacede = new UsuariosFacade();
        try {
            return usuariosFacede.consultarUsuario(login, senha);
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro consultar Usuario");
            return null;
        }
    }
    
    public Usuarios consultarUsuario(int idUsuario) {
        usuariosFacede = new UsuariosFacade();
        try {
            return usuariosFacede.consultarUsuario(idUsuario);
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro consultar Usuario");
            return null;
        }
    }
    
    public Usuarios salvarUsuario(Usuarios usuario) {
        usuariosFacede = new UsuariosFacade();
        try {
            return usuariosFacede.salvarUsuario(usuario);
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Salvar Usuario " + ex);
            return null;
        }
    }
    
    
    
}
