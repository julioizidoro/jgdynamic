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
import model.Fechacaixa;
import model.Retirada;

/**
 *
 * @author Wolverine
 */
public class RetiradaDao {
    
    private EntityManager manager;
    
    public void salvar(Retirada retirada) throws Exception{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        manager.merge(retirada);
        //fechando uma transação
        manager.getTransaction().commit(); 
        manager.close();
    }
    
    public void excluir(Retirada retirada) throws Exception{
         manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        retirada = manager.find(Retirada.class, retirada.getIdretirada());
        //fechando uma transação
        manager.remove(retirada);
        manager.getTransaction().commit(); 
        manager.close();
    }
    
    public List<Retirada> listarRetiradas(Fechacaixa fechaCaixa) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        Query q = manager.createQuery("Select r FROM Retirada r where r.fechacaixa=" + fechaCaixa.getIdfechaCaixa());
        List<Retirada> listaRetirada = new ArrayList<Retirada>();
        listaRetirada = q.getResultList();
        manager.close();
        return listaRetirada;
    }
    
}
