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
import model.Cest;
import model.Ibpt;

/**
 *
 * @author Wolverine
 */
public class CestDao {
    
    private EntityManager manager;
    
    public List<Cest> listar() throws SQLException{
        manager = ConexaoSingleton.getConexao();
        Query q = manager.createQuery("select c from Cest c order by c.descricao" );
        List<Cest> lista = null;
        if (q.getResultList().size()>0){
            lista =  q.getResultList();
        }
        manager.close();
        return lista;
    }
    
    public List<Cest> listar(String descricao) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        Query q = manager.createQuery("select i from Cest i where i.descricao like '%" + descricao + "%' order by i.id" );
        List<Cest> lista = null;
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
            ibpt =  (Ibpt) q.getResultList().get(0);
        }
        manager.close();
        return ibpt;
    }
    
    public Cest cunsultarCest(String ncm) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        Query q = manager.createQuery("select i from Cest i where i.ncm = '" + ncm + "' order by i.descricao" );
        Cest cest = null;
        if (q.getResultList().size()>0){
            cest =  (Cest) q.getResultList().get(0);
        }
        manager.close();
        return cest;
    }
    
    public void salvar(Cest cest) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        manager.getTransaction().begin();
        manager.merge(cest);
        manager.getTransaction().commit(); 
        manager.close();
    }
}
