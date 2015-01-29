/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Singleton.ConexaoSingleton;
import java.sql.SQLException;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Usuarios;



/**
 *
 * @author Wolverine
 */
public class UsuariosDao {
    
    EntityManager manager;
    
    public Usuarios consultarUsuario(String login, String senha) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        Query q = manager.createQuery("SELECT u FROM Usuarios u WHERE u.login='" + login + "' and u.senha='" + senha + "'");
        Usuarios usuarios = null;
        if (q.getResultList().size()>0){
            usuarios = (Usuarios) q.getSingleResult();
        }
        manager.close();
        return usuarios;
    }
    
    public Usuarios consultarUsuario(int idUsuario) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        Query q = manager.createQuery("SELECT u FROM Usuarios u WHERE u.idusuarios=" + idUsuario);
        Usuarios usuarios = null;
        if (q.getResultList().size()>0){
            usuarios = (Usuarios) q.getSingleResult();
        }
        manager.close();
        return usuarios;
        
    }
    
    public Usuarios salvarUsuario(Usuarios usuario) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        String senha = null;
        if (usuario.getIdusuarios()!=null){
             senha = usuario.getSenha();
            usuario = manager.find(Usuarios.class, usuario.getIdusuarios());
            usuario.setSenha(senha);
        }
        usuario = manager.merge(usuario);
        //fechando uma transação
        manager.getTransaction().commit(); 
        manager.close();
        return usuario;
    }    
}
