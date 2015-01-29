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
import model.CodigoBarras;

/**
 *
 * @author wolverine
 */
public class CodigoBarrasDao {
    
    private EntityManager manager;
    
    public CodigoBarras salvar(CodigoBarras codigoBarras) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        codigoBarras = manager.merge(codigoBarras);
        //fechando uma transação
        manager.getTransaction().commit(); 
        manager.close();
        return codigoBarras;
    }
    
    public CodigoBarras pesquisarCodigo(String barras) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        CodigoBarras codigoBarras = null;
        Query q = manager.createQuery("select c from CodigoBarras c where c.barras='" + barras+ "'");
        if (q.getResultList().size()>0){
            codigoBarras =  (CodigoBarras) q.getResultList().get(0);
        }
        manager.close();
        return codigoBarras;
    }
    
    public List<CodigoBarras> pesquisarProduto(int idProduto) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        CodigoBarras codigoBarras = null;
        Query q = manager.createQuery("select c from CodigoBarras c where c.produto=" + idProduto);
        if (q.getResultList().size()>0){
            codigoBarras = (CodigoBarras) q.getSingleResult();
        }
        manager.close();
        return q.getResultList();
    }
    
    public void excluirCodigoBarras(CodigoBarras codigoBarras) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        codigoBarras = manager.find(CodigoBarras.class, codigoBarras.getIdcodigoBarras());
        manager.remove(codigoBarras);
        //fechando uma transação
        manager.getTransaction().commit(); 
        manager.close();
    }
    
}
