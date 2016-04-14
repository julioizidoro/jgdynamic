/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Singleton.ConexaoSingleton;
import Singleton.ConexaoSingletonParametros;
import javax.persistence.EntityManager;
import modeloParametros.Parametros;

/**
 *
 * @author Wolverine
 */
public class ParametrosDao {
    
    private EntityManager manager;
    
    public void salvar(Parametros parametros, int idEmpresa) throws Exception {
        manager = ConexaoSingletonParametros.getConexao(idEmpresa);
        manager.getTransaction().begin();
        manager.merge(parametros);
        manager.getTransaction().commit(); 
        manager.close();
    }
    
    
    
    public Parametros localizar(int idEmpresa) throws Exception{
        manager = ConexaoSingletonParametros.getConexao(idEmpresa);
        manager.getTransaction().begin();
        Parametros parametros = manager.find(Parametros.class, 1); 
        manager.getTransaction().commit(); 
        manager.close();
        return parametros;
    }
    
}
