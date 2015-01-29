/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import Singleton.ConexaoSingleton;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Ibpt;

/**
 *
 * @author Wolverine
 */
public class IbptDao {
    
    private EntityManager manager;
    
    public List<Ibpt> listarIbpt() throws SQLException{
        manager = ConexaoSingleton.getConexao();
        Query q = manager.createQuery("select i from Ibpt i order by i.descricao" );
        List<Ibpt> lista = null;
        if (q.getResultList().size()>0){
            lista =  q.getResultList();
        }
        manager.close();
        return lista;
    }
    
    public List<Ibpt> listarIbpt(String descricao) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        Query q = manager.createQuery("select i from Ibpt i where i.descricao like '%" + descricao + "%' order by i.descricao" );
        List<Ibpt> lista = null;
        if (q.getResultList().size()>0){
            lista =  q.getResultList();
        }
        manager.close();
        return lista;
    }
    
    public Ibpt cunsultarIbpt(String ncm) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        Query q = manager.createQuery("select i from Ibpt i where i.ncm = '" + ncm + "' order by i.descricao" );
        Ibpt ibpt = null;
        if (q.getResultList().size()>0){
            ibpt =  (Ibpt) q.getSingleResult();
        }
        manager.close();
        return ibpt;
    }
}
