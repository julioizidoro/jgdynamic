/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dao.CestDao;
import java.sql.SQLException;
import java.util.List;
import model.Cest;
import model.Ibpt;

/**
 *
 * @author Wolverine
 */
public class CestFacade {
    
    CestDao cestDao;
    
    public Ibpt cunsultarIbpt(String ncm) throws SQLException{
        cestDao = new CestDao();
        return cestDao.cunsultarIbpt(ncm);
    }
    
    public List<Cest> listar(String descricao) throws SQLException{
        cestDao = new CestDao();
        return cestDao.listar(descricao);
    }
    
    public List<Cest> consultar(String descricao) throws SQLException{
        cestDao = new CestDao();
        return cestDao.listar(descricao);
    }
    
    public Cest cunsultarCest(String ncm) throws SQLException{
        cestDao = new CestDao();
        return cestDao.cunsultarCest(ncm);
    }
    
}
