/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Singleton.ConexaoSingleton;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Emissorecf;

/**
 *
 * @author Julio
 */
public class EmissorecfDao {
    
    private EntityManager manager;
    
    public void salvar(Emissorecf emissorEcf) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        manager.merge(emissorEcf);
        //fechando uma transação
        manager.getTransaction().commit(); 
        manager.close();
    }
    
    
    public List<Emissorecf> listar(int idEmpresa) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        Query q = manager.createQuery("Select e FROM Emissorecf e where e.empresa=" + idEmpresa + " order by e.idEmissorECF");
        List<Emissorecf> lista = q.getResultList();
        //fechando uma transação
        manager.getTransaction().commit(); 
        manager.close();
        return lista;
    }
    
}
