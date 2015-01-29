/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Singleton.ConexaoSingleton;
import java.sql.SQLException;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Configuracao;

/**
 *
 * @author wolverine
 */
public class ConfiguracaoDao {
    
    private EntityManager manager;
    
    public Configuracao salvarConfiguracao(Configuracao configuracao) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        configuracao = manager.merge(configuracao);
        //fechando uma transação
        manager.getTransaction().commit(); 
        manager.close();
        return configuracao;
    }
    
    public Configuracao getConfiguracao(int idEmpresa) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        Query q = manager.createQuery("Select c from Configuracao c where c.empresa=" + idEmpresa);
        Configuracao configuracao = null;
        if (q.getResultList().size()>0){
            configuracao = (Configuracao) q.getResultList().get(0);
        }
        manager.close();
        return configuracao;
    }
    
}
