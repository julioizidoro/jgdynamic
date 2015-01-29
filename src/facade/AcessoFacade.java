/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dao.AcessoDao;
import java.sql.SQLException;
import model.Acesso;

/**
 *
 * @author Wolverine
 */
public class AcessoFacade {
    
    AcessoDao acessoDao;
    
    public Acesso getAcessoUsuario(int idUsuario) throws SQLException{
        acessoDao = new AcessoDao();
        return acessoDao.getAcessoUsuario(idUsuario);
    }
    
}
