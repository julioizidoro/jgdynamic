/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dao.IbptDao;
import java.sql.SQLException;
import java.util.List;
import model.Ibpt;

/**
 *
 * @author Wolverine
 */
public class IbptFacade {
    
    IbptDao ibptDao;
    
    public Ibpt cunsultarIbpt(String ncm) throws SQLException{
        ibptDao = new IbptDao();
        return ibptDao.cunsultarIbpt(ncm);
    }
    
    public List<Ibpt> listarIbpt(String descricao) throws SQLException{
        ibptDao = new IbptDao();
        return ibptDao.listarIbpt(descricao);
    }
    
}
