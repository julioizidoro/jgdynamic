/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Singleton.ConexaoSingleton;
import java.sql.SQLException;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.ParametrosLocal;

/**
 *
 * @author Wolverine
 */
public class ParametroLocalDao {
    
    private EntityManager manager;
    
    public void salvar(ParametrosLocal parametros) throws Exception {
         manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        manager.merge(parametros);
        //fechando uma transação
        manager.getTransaction().commit(); 
        manager.close();
    }
    
    
    
    public ParametrosLocal localizarParametro(int idParametro) throws Exception{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        ParametrosLocal parametros = manager.find(ParametrosLocal.class, idParametro); 
        //fechando uma transação
        manager.getTransaction().commit();
        manager.close();
        return parametros;
    }
    
    public ParametrosLocal localizarEmpresa(int idEmpresa) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        Query q = manager.createQuery("Select p from ParametrosLocal p where p.empresa=" + idEmpresa);
        ParametrosLocal parametrosLocal = null;
        if (q.getResultList().size()>0){
            parametrosLocal = (ParametrosLocal) q.getResultList().get(0);
        }
        manager.close();
        return parametrosLocal;
    }
    
    
    
}
