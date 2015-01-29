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
import model.Formavenda;
import model.Saida;

/**
 *
 * @author Woverine
 */
public class FormaVendaDao {
    
    private EntityManager manager;

    public void gravarFormaVenda(Formavenda formaVenda) throws Exception{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        manager.merge(formaVenda);
        //fechando uma transação
        manager.getTransaction().commit(); 
        manager.close();
    }
    
    public void excluirFormaVenda(Formavenda formaVenda) throws SQLException{
         manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        formaVenda = manager.find(Formavenda.class, formaVenda.getIdformaVenda()); 
        //fechando uma transação
        manager.remove(formaVenda);
        manager.getTransaction().commit(); 
        manager.close();
    }
    
     public void excluirSaida(Saida saida) throws SQLException{
         manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        saida = manager.find(Saida.class, saida.getIdsaida());
        //fechando uma transação
        manager.remove(saida);
        manager.getTransaction().commit(); 
        manager.close();
    }
     
     public List<Formavenda> consultarFormaVenda(int idVenda) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        Query q = manager.createQuery("Select v From Formavenda v where v.venda=" + idVenda);
        List<Formavenda> listaFormaVenda = new ArrayList<Formavenda>();
        listaFormaVenda = q.getResultList();
        manager.close();
        return listaFormaVenda;
    }
}
