/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Singleton.ConexaoSingleton;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Aliquota;

/**
 *
 * @author Wolverine
 */
public class AliquotaDao {
    
    private EntityManager manager;
    
    public Aliquota buscarAliquotaValor(Double valor) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        Aliquota aliquota = new Aliquota();
        Query q = manager.createQuery("select a from Aliquota a where a.valor=" + valor);
        if (q.getResultList().size()>0){
            aliquota= (Aliquota) q.getSingleResult();
        }
        manager.close();
        return aliquota;
    }
    
    public List<Aliquota> buscarAliquota() throws SQLException{
        manager = ConexaoSingleton.getConexao();
        List<Aliquota> listaAliquota = new ArrayList<Aliquota>();
        Query q = manager.createQuery("select a from Aliquota a order by a.descricao");
        listaAliquota = q.getResultList();
        manager.close();
        return listaAliquota;
    }
    
    public Aliquota buscarAliquotaDescricao(String descricao) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        Aliquota aliquota = null;
        Query q = manager.createQuery("select a from Aliquota a where a.descricao='" + descricao + "'");
        if (q.getResultList().size()>0){
            aliquota = (Aliquota) q.getSingleResult();
        }
        manager.close();
        return aliquota;
    }
    
    public Aliquota buscarAliquotaid(int idAliquota) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        Aliquota aliquota = null;
        Query q = manager.createQuery("select a from Aliquota a where a.idaliquota=" + idAliquota);
        if (q.getResultList().size()>0){
            aliquota= (Aliquota) q.getSingleResult();
        }
        manager.close();
        return aliquota;
    }
    
}
