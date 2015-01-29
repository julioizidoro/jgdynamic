/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Singleton.ConexaoSingleton;
import java.sql.SQLException;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.CustoProduto;

/**
 *
 * @author wolverine
 */
public class CustoProdutoDao {
    
    private EntityManager manager;
    
    public void salvar(CustoProduto custoProduto) throws  Exception{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        manager.merge(custoProduto);
        //fechando uma transação
        manager.getTransaction().commit(); 
        manager.close();
    }
    
    public CustoProduto getCustoProduto(int idProduto, int idEmpresa) throws SQLException{
        CustoProduto custoProduto = null;
        manager = ConexaoSingleton.getConexao();
        Query q = manager.createQuery("Select c From CustoProduto c where c.produto=" + idProduto + " and c.empresa=" + idEmpresa);
        if (q.getResultList().size()>0){
            custoProduto = (CustoProduto) q.getResultList().get(0);
        }
        manager.close();
        return custoProduto;
    }
    
}
