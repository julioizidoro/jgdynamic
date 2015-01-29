/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dao.UsuariosDao;
import java.sql.SQLException;
import model.Usuarios;

/**
 *
 * @author Wolverine
 */
public class UsuariosFacade {
    
    UsuariosDao usuariosDao;
    
    public Usuarios consultarUsuario(String login, String senha) throws SQLException{
        usuariosDao = new UsuariosDao();
        return usuariosDao.consultarUsuario(login, senha);
    }
    
    public Usuarios consultarUsuario(int idUsuario) throws SQLException{
        usuariosDao = new UsuariosDao();
        return usuariosDao.consultarUsuario(idUsuario);
    }
    
    public Usuarios salvarUsuario(Usuarios usuario) throws SQLException{
        usuariosDao = new UsuariosDao();
        return usuariosDao.salvarUsuario(usuario);
    }
    
}
