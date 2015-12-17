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
import model.Estoque;
import view.Viewconsultaprodutoestoque;

/**
 *
 * @author Woverine
 */
public class EstoqueDao {

    private EntityManager manager;

    public Estoque salvarEstoque(Estoque estoque) throws  Exception{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        estoque = manager.merge(estoque);
        //fechando uma transação
        manager.getTransaction().commit(); 
        manager.close();
        return estoque;
    }
    
    public Estoque getEstoque(Estoque estoque) throws  Exception{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        estoque = manager.find(Estoque.class, estoque.getIdestoque()); 
        //fechando uma transação
        manager.getTransaction().commit(); 
        manager.close();
        return estoque;
    }

    
    public int getIdEstoque() throws Exception {
        manager = ConexaoSingleton.getConexao();
        //verificar last insert id
        Query q = manager.createNativeQuery("Select MAX(idestoque) From Estoque");
        int idEstoque=(Integer) q.getSingleResult();
        manager.close();
        return idEstoque;
    }

    public Estoque getEstoque(int idEstoque, int idEmpresa) throws Exception{
         manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        Query q = manager.createQuery("Select e From Estoque e where e.idestoque=" + idEstoque + " and e.empresa=" + idEmpresa);
        if (q.getResultList().size()>0){
            Estoque estoque = (Estoque) q.getResultList().get(0);
            manager.getTransaction().begin();
            estoque = manager.find(Estoque.class, estoque.getIdestoque());
            manager.getTransaction().commit(); 
            manager.close();
            return estoque;
        }
        manager.close();
        return null;
    }
    
    public List<Estoque> listarEstoque(int idEmpresa) throws SQLException{
         manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        Query q = manager.createQuery("Select e From Estoque e where e.empresa.idempresa=" + idEmpresa);
        List<Estoque> listaestoque = q.getResultList();
        manager.close();
        return listaestoque;
    }
    
    public Estoque getEstoqueProduto(int idProduto, int idEmpresa) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        manager.getTransaction().begin();
        Query q = manager.createQuery("Select e From Estoque e where e.produto=" + idProduto + " and e.empresa=" + idEmpresa);
        if (q.getResultList().size()>0){
            Estoque estoque = (Estoque) q.getResultList().get(0);
            manager.getTransaction().commit(); 
            manager.close();
            return estoque;
        }
        manager.getTransaction().commit(); 
        manager.close();
        return null;
    }
    
    public List<Estoque> consultaEstoqueProduto(int idProduto, int idEmpresa) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        manager.getTransaction().begin();
        Query q = manager.createQuery("Select e From Estoque e where e.produto=" + idProduto + " and e.empresa=" + idEmpresa);
        List<Estoque> listaEstoque = q.getResultList();
        manager.getTransaction().commit(); 
        manager.close();
        return listaEstoque;
    }
    
    public List<Viewconsultaprodutoestoque> listarEstoqueZero(int idEmpresa) throws SQLException{
       manager = ConexaoSingleton.getConexao();
       List<Viewconsultaprodutoestoque>  listaEstoque  = new ArrayList<Viewconsultaprodutoestoque>();
        Query q = manager.createQuery("select c from Viewconsultaprodutoestoque c where c.quantidadeEstoque>0 and empresa=" + idEmpresa + " order by c.descricao");
        listaEstoque = q.getResultList();
        manager.close();
        return listaEstoque;
   }
    
    public List<Viewconsultaprodutoestoque> listarEstoqueGeral(int idEmpresa) throws SQLException{
       manager = ConexaoSingleton.getConexao();
       List<Viewconsultaprodutoestoque>  listaEstoque  = new ArrayList<Viewconsultaprodutoestoque>();
        Query q = manager.createQuery("select c from Viewconsultaprodutoestoque c where c.empresa=" + idEmpresa + " order by c.referencia");
        listaEstoque = q.getResultList();
        manager.close();
        return listaEstoque;
   }
    
   public List<Viewconsultaprodutoestoque> listarEstoqueReferencia(int referencia, int idEmpresa) throws SQLException{
       manager = ConexaoSingleton.getConexao();
       List<Viewconsultaprodutoestoque>  listaEstoque  = new ArrayList<Viewconsultaprodutoestoque>();
        Query q = manager.createQuery("select c from Viewconsultaprodutoestoque c where c.referencia>=" + referencia + " and empresa=" + idEmpresa + " order by c.referencia");
        listaEstoque = q.getResultList();
        manager.close();
        return listaEstoque;
   }
   
   public List<Viewconsultaprodutoestoque> listarEstoqueCodigoBarras(String codigoBarras, int idEmpresa) throws SQLException{
       manager = ConexaoSingleton.getConexao();
       List<Viewconsultaprodutoestoque>  listaEstoque  = new ArrayList<Viewconsultaprodutoestoque>();
        Query q = manager.createQuery("select c from Viewconsultaprodutoestoque c where c.codigoBarras='" + codigoBarras + "' and empresa=" + idEmpresa + " order by c.codigoBarras");
        listaEstoque = q.getResultList();
        manager.close();
        return listaEstoque;
   }
    
    public List<Viewconsultaprodutoestoque> listarEstoqueDescricao(String descricao, int idEmpresa) throws SQLException{
       manager = ConexaoSingleton.getConexao();
       List<Viewconsultaprodutoestoque>  listaEstoque  = new ArrayList<Viewconsultaprodutoestoque>();
        Query q = manager.createQuery("select c from Viewconsultaprodutoestoque c where  c.descricao like '" + descricao + "%'  and empresa=" + idEmpresa + " order by c.descricao");
        listaEstoque = q.getResultList();
        manager.close();
        return listaEstoque;
   }    
}
