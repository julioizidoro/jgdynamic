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
import model.Forpedido;
import model.Forpedproduto;
import model.Forproduto;

/**
 *
 * @author Wolverine
 */
public class ForPedidoDao {

    EntityManager manager;

    public Forpedido consultarForPedido(int idForPedido, int idEmpresa) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        Forpedido forPedido = new Forpedido();
        Query q = manager.createQuery("SELECT f FROM Forpedido f WHERE f.idForPedido ="+ idForPedido + " and f.empresa=" + idEmpresa);
        if (q.getResultList().size()>0){
            forPedido = (Forpedido) q.getSingleResult();
        }
        manager.close();
        return forPedido;
    }
    
   
    public List<Forpedido> consultarForPedido(String sql) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        List<Forpedido> listaForPedido = new ArrayList<Forpedido>();
        Query q = manager.createQuery(sql);
        listaForPedido = q.getResultList();
        manager.close();
        return listaForPedido;
    }
    
     public Forpedido salvarForPedido(Forpedido forPedido) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        forPedido = manager.merge(forPedido);
        //fechando uma transação
        manager.getTransaction().commit(); 
        manager.close();
        
        return forPedido;
    }

    public void salvarForPedProduto(Forpedproduto forPedProduto) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        manager.merge(forPedProduto);
        //fechando uma transação
        manager.getTransaction().commit(); 
        manager.close();
    }

    public void excluirForPedProduto(Forpedproduto forPedProduto) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        forPedProduto = manager.find(Forpedproduto.class, forPedProduto.getIdForPedProduto());
        manager.remove(forPedProduto);
        //fechando uma transação
        manager.getTransaction().commit(); 
        manager.close();
    }
    
    public void excluirForPedido(Forpedido forPedido) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        manager.remove(forPedido);
        //fechando uma transação
        manager.getTransaction().commit(); 
        manager.close();
    }
    
    public int getIdPedido() throws Exception {
        manager = ConexaoSingleton.getConexao();
        //verificar last insert id
        Query q = manager.createNativeQuery("Select MAX(idForPedido) From Forpedido");
        int idPedido;
        if (q.getResultList().size()>0){
            idPedido =(Integer) q.getSingleResult();
        }else {
            idPedido =0;
        }      
        manager.close();
        return idPedido;
    }
    
     public List<Forpedproduto> consultarForPedidoProduto(Forpedido forPedido) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        List<Forpedproduto> listaForPedidoProduto = new ArrayList<Forpedproduto>();
        Query q = manager.createQuery("SELECT f FROM Forpedproduto f where f.forpedido=" + forPedido.getIdForPedido());
        listaForPedidoProduto = q.getResultList();
        manager.close();
        return listaForPedidoProduto;
    }
     
     public List<Forpedproduto> consultarForPedidoProduto(Forpedido forPedido, int tipo) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        List<Forpedproduto> listaForPedidoProduto = new ArrayList<Forpedproduto>();
        Query q = manager.createQuery("SELECT f FROM Forpedproduto f where f.forpedido=" + forPedido.getIdForPedido() +  " and f.entrada=" + tipo);
        listaForPedidoProduto = q.getResultList();
        manager.close();
        return listaForPedidoProduto;
    }
     
   public List<Forpedido> consultarForPedidoUltimo(int idFornecedor, int idEmpresa) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        List<Forpedido> listaForPedido = null;
        Query q = manager.createQuery("SELECT f FROM Forpedido f where f.fornecedor=" + idFornecedor + " and f.registrado<>'SIM' and f.empresa=" + idEmpresa + " order by f.dataEmissao");
        if (q.getResultList().size()>0){
            listaForPedido =  q.getResultList();
        }
        manager.close();
        return listaForPedido;
    }
   
   public void salvarForProduto(Forproduto forProduto) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        manager.merge(forProduto);
        //fechando uma transação
        manager.getTransaction().commit(); 
        manager.close();
    }
   
   public List<Forproduto> consultarForProduto() throws SQLException{
        manager = ConexaoSingleton.getConexao();
        List<Forproduto> listaForProduto = new ArrayList<Forproduto>();
        Query q = manager.createQuery("SELECT f FROM Forproduto f order by f.descricao");
        listaForProduto = q.getResultList();
        manager.close();
        return listaForProduto;
    }
    
    public void excluirForProduto(int idForProduto) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        Forproduto forProduto = new Forproduto();
        forProduto = manager.find(Forproduto.class, idForProduto);
        manager.remove(forProduto);
        //fechando uma transação
        manager.getTransaction().commit(); 
        manager.close();
    }

}
