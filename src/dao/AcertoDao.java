/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Singleton.ConexaoSingleton;
import javax.persistence.EntityManager;
import model.Acerto;

/**
 *
 * @author Wolverine
 */
public class AcertoDao {
    
    private EntityManager manager;
    
    public void salvar(Acerto acerto) throws  Exception{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        manager.merge(acerto);
        //fechando uma transação
        manager.getTransaction().commit(); 
        manager.close();
    }
    
}
