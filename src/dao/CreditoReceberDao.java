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
import model.Creditoreceberprodutos;
import model.Creditosreceber;

/**
 *
 * @author Wolverine
 */
public class CreditoReceberDao {
    
    private EntityManager manager;
    
    public Creditosreceber salvar(Creditosreceber creditoReceber) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        creditoReceber = manager.merge(creditoReceber);
        //fechando uma transação
        manager.getTransaction().commit(); 
        manager.close();
        return creditoReceber;
    }
    
    public List<Creditosreceber> listarCreditos(String sql) throws SQLException{
        List<Creditosreceber> listaCreditosReceber = new ArrayList<Creditosreceber>();
        manager = ConexaoSingleton.getConexao();
        manager.getTransaction().begin();
        Query q = manager.createQuery(sql);
        listaCreditosReceber = q.getResultList();
        manager.getTransaction().commit(); 
        manager.close();
        return listaCreditosReceber;
    }
    
    public List<Creditoreceberprodutos> listaCreditoProdutos(int idCredito) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        List<Creditoreceberprodutos> listaCreditosReceberProdutos = new ArrayList<Creditoreceberprodutos>();
        manager.getTransaction().begin();
        Query q = manager.createQuery("Select c from Creditoreceberprodutos c where c.creditosreceber=" + idCredito);
        List<Creditoreceberprodutos> lista = q.getResultList();
        manager.getTransaction().commit(); 
        manager.close();
        return lista;
    }
}
