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
import model.Vinculo;

/**
 *
 * @author Wolverine
 */
public class VinculoDao {

    private EntityManager manager;

    public Vinculo salvaVinculo(Vinculo vinculo) throws SQLException{
         manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        vinculo = manager.merge(vinculo);
        //fechando uma transação
        manager.getTransaction().commit(); 
        manager.close();
        return vinculo;
   }

    public List<Vinculo> consultarVinculo(int idProduto, int idEmpresa) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        List<Vinculo> listaVinculo = new ArrayList<Vinculo>();
        Query q = manager.createQuery("SELECT v FROM Vinculo v where v.produto="  + idProduto + " and v.empresa=" + idEmpresa + " order by v.produto");
        listaVinculo = q.getResultList();
        manager.close();
        return listaVinculo;
    }
    
    public Vinculo consultarVinculo(int produto, int empresa, int fornecedor) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        Query q = manager.createQuery("SELECT v FROM Vinculo v where v.produto="  + produto + " and v.empresa=" + empresa + " and v.fornecedor=" + fornecedor + " order by v.dataCompra desc");
        Vinculo vinculo = null;
        if (q.getResultList().size()>0){
            vinculo = (Vinculo) q.getResultList().get(0);
        }
        manager.close();
        return vinculo;
    }
    
    public List<Vinculo> consultaVinculo(int fornecedor, int empresa) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        List<Vinculo> listaVinculo = new ArrayList<Vinculo>();
        Query q = manager.createQuery("SELECT v FROM Vinculo v where v.fornecedor="  + fornecedor + " and v.empresa=" + empresa);
        if (q.getResultList().size()>0){
            listaVinculo = q.getResultList();
        }
        manager.close();
        return listaVinculo;
    }
    
    public List<Vinculo> consultarVinculoPedido(int idProduto, int idEmpresa, int idfornecedor) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        List<Vinculo> listaVinculo = new ArrayList<Vinculo>();
        Query q = manager.createQuery("SELECT v FROM Vinculo v where v.produto="  + idProduto + " and v.empresa=" + idEmpresa + " "
                + " and v.fornecedor<>" + idfornecedor + " order by v.produto");
        listaVinculo = q.getResultList();
        manager.close();
        return listaVinculo;
    }
    
    public List<Vinculo> consultarVinculoFornecedorProduto(int idProduto, int idEmpresa, int idfornecedor) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        List<Vinculo> listaVinculo = new ArrayList<Vinculo>();
        Query q = manager.createQuery("SELECT v FROM Vinculo v where v.produto="  + idProduto + " and v.empresa=" + idEmpresa + " "
                + " and v.fornecedor=" + idfornecedor + " order by v.produto");
        listaVinculo = q.getResultList();
        manager.close();
        return listaVinculo;
    }
    
    public Vinculo getVinculo(int idVinculo) throws SQLException{
         manager = ConexaoSingleton.getConexao();
         Vinculo vinculo = new Vinculo();
        //abrindo uma transação
        manager.getTransaction().begin();
        vinculo = manager.find(Vinculo.class, idVinculo);
        //fechando uma transação
        manager.getTransaction().commit(); 
        manager.close();
        return vinculo;
   }
    
    public void excluirVinculo(int idVinculo) throws SQLException{
         manager = ConexaoSingleton.getConexao();
         Vinculo vinculo = new Vinculo();
        //abrindo uma transação
        manager.getTransaction().begin();
        vinculo = manager.find(Vinculo.class, idVinculo);
        manager.remove(vinculo);
        //fechando uma transação
        manager.getTransaction().commit(); 
        manager.close();
   }
    
    
}
