/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Singleton.ConexaoSingletonParametros;
import javax.persistence.EntityManager;
import modeloParametros.Parametros;

/**
 *
 * @author Wolverine
 */
public class ParametrosDao {
    
    private EntityManager manager;
    
    public void salvar(Parametros parametros) throws Exception {
         manager = ConexaoSingletonParametros.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        manager.merge(parametros);
        //fechando uma transação
        manager.getTransaction().commit(); 
        manager.close();
    }
    
    
    
    public Parametros localizar(int idParamtro) throws Exception{
        manager = ConexaoSingletonParametros.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        Parametros parametros = manager.find(Parametros.class, idParamtro); 
        //fechando uma transação
        manager.getTransaction().commit(); 
        manager.close();
        return parametros;
    }
    
}
