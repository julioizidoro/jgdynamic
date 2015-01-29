/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import Singleton.ConexaoSingleton;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Docentrada;
import model.Entradaproduto;
import model.Nfentrada;
import model.View.Viewentradaproduto;
import model.Vinculo;

/**
 *
 * @author Wolverine
 */
public class EntradaDao {

    private EntityManager manager;

    public Docentrada salvarEntradaDoc(Docentrada docEntrada) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        docEntrada = manager.merge(docEntrada);
        //fechando uma transação
        manager.getTransaction().commit(); 
        manager.close();
        return docEntrada;
    }

    public void salvarEntradaProduto(Entradaproduto entradaProduto) throws SQLException{
         manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        manager.merge(entradaProduto);
        //fechando uma transação
        manager.getTransaction().commit(); 
        manager.close();
    }

    public Nfentrada salvarEntradaNF(Nfentrada nfEntrada) throws SQLException{
         manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        nfEntrada = manager.merge(nfEntrada);
        //fechando uma transação
        manager.getTransaction().commit(); 
        manager.close();
        return nfEntrada;
    }

    public Docentrada consultarEntrada(int idDocEntrada) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        Docentrada docEntrada  = new Docentrada();
        Query q = manager.createQuery("select e from Docentrada e where e.idDocEntrada=" + idDocEntrada);
        if (q.getResultList().size()>0){
            docEntrada = (Docentrada) q.getSingleResult();
        }
        manager.close();
        return docEntrada;
    }
    

    public void excluirEntradaProduto(Entradaproduto entradaProduto) throws SQLException{
         manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        entradaProduto = manager.find(Entradaproduto.class, entradaProduto.getIdEntradaProduto());
        manager.remove(entradaProduto);
        //fechando uma transação
        manager.getTransaction().commit(); 
        manager.close();
    }
    
    public void excluirEntradaProduto(int idProdutoEntrada) throws SQLException{
         manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        Entradaproduto entradaProduto = manager.find(Entradaproduto.class, idProdutoEntrada);
        manager.remove(entradaProduto);
        //fechando uma transação
        manager.getTransaction().commit(); 
        manager.close();
    }

    public void excluirDocEntrada(Docentrada docEntrada) throws SQLException{
         manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        docEntrada = manager.find(Docentrada.class, docEntrada.getIdDocEntrada());
        manager.remove(docEntrada);
        //fechando uma transação
        manager.getTransaction().commit(); 
        manager.close();
    }

    public void excluirNotaEntrada(Nfentrada nfEntrada) throws SQLException{
         manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        nfEntrada = manager.find(Nfentrada.class, nfEntrada.getIdNfEntrada());
        manager.remove(nfEntrada);
        //fechando uma transação
        manager.getTransaction().commit(); 
        manager.close();
    }
    
    public Nfentrada consultarNotaEntrada(int idNfEntrada) throws SQLException{
         manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        Nfentrada nfEntrada = new Nfentrada();
        nfEntrada = manager.find(Nfentrada.class, idNfEntrada);
        //fechando uma transação
        manager.getTransaction().commit(); 
        manager.close();
        return nfEntrada;
    }

    public Vinculo pesquisarCodigoFabricante(int fornecedor, String codigoFabricante) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        Vinculo vinculo = null;
        Query q = manager.createQuery("select v from Vinculo v where v.codigoFabricante='" + codigoFabricante + "' and v.fornecedor=" + fornecedor);
        if (q.getResultList().size()>0){
            vinculo = (Vinculo) q.getSingleResult();
        }
        manager.close();
        return vinculo;
    }

   public int getIdEntrada() throws Exception {
        manager = ConexaoSingleton.getConexao();
        //verificar last insert id
        Query q = manager.createNativeQuery("Select MAX(idDocEntrada) From docentrada");
        int idDocEntrada =(Integer) q.getSingleResult();
        manager.close();
        return idDocEntrada;
    }

   

   public List<Docentrada> pesquisarEntradaPeriodo(String dataInicio, String dataFim, int idEmpresa) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        List<Docentrada> listaEntrada = null;
        Query q = manager.createQuery("select e from Docentrada e where e.dataEntrada>='" + dataInicio + "' and e.dataEntrada<='" +  dataFim + "' and e.empresa=" + idEmpresa + " order by e.dataEntrada");
        if (q.getResultList().size()>0){
            listaEntrada = q.getResultList();
        }
        manager.close();
        return listaEntrada;
   }
   
   public List<Docentrada> pesquisarEntradaPeriodoFornecedor(String dataInicio, String dataFim, int idFornecedor, int idEmpresa) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        List<Docentrada> listaEntrada = null;
        Query q = manager.createQuery("select e from Docentrada e where e.dataEntrada>='" + dataInicio + "' and e.dataEntrada<='" +  dataFim + "' and e.fornecedor=" + idFornecedor + " and e.empresa=" + idEmpresa + " order by e.dataEntrada");
        if (q.getResultList().size()>0){
            listaEntrada = q.getResultList();
        }
        manager.close();
        return listaEntrada;
    }
   
   
   
   public Vinculo pesquisarProduto(int idProduto, int idEmpresa, int idFornecedor) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        Vinculo vinculo = null;
        Query q = manager.createQuery("select v from Vinculo v where v.empresa=" + idEmpresa + " and v.produto="  + idProduto
                + " and v.fornecedor=" + idFornecedor);
        if (q.getResultList().size()>0){
            vinculo = (Vinculo) q.getSingleResult();
        }
        manager.close();
        return vinculo;
   }
   
   public List<Docentrada> pesquisarEntradaSituacao(String situacao, int idEmpresa) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        List<Docentrada> docEntrada  = null;
        Query q = manager.createQuery("select e from Docentrada e where e.situacao<>'" + situacao + "' and e.empresa=" + idEmpresa + " order by e.dataEntrada");
        if (q.getResultList().size()>0){
            docEntrada = q.getResultList();
        }
        manager.close();
        return docEntrada;
   }
   
   public List<Entradaproduto> listarEntradaProduto(Docentrada docEntrada) throws SQLException{
       manager = ConexaoSingleton.getConexao();
       List<Entradaproduto>  ListaEntradaProduto  = null;
        Query q = manager.createQuery("select l from Entradaproduto l where l.docentrada=" + docEntrada.getIdDocEntrada() + " order by l.idEntradaProduto");
        if (q.getResultList().size()>0){
            ListaEntradaProduto = q.getResultList();
        }
        manager.close();
        return ListaEntradaProduto;
   }
   
   public Nfentrada consultarNotaFiscalEntrada(int idDocEntrada) throws SQLException{
       manager = ConexaoSingleton.getConexao();
       Nfentrada nfentrada = null;
        Query q = manager.createQuery("select n from Nfentrada n where n.docentrada=" + idDocEntrada);
        if (q.getResultList().size()>0){
            nfentrada = (Nfentrada) q.getResultList().get(0);
        }
        manager.close();
        return nfentrada;
   }
   
   public List<Viewentradaproduto> viewListarEntradaProduto(Docentrada docEntrada) throws SQLException{
       manager = ConexaoSingleton.getConexao();
       List<Viewentradaproduto>  ListaEntradaProduto  = null;
        Query q = manager.createQuery("select v from Viewentradaproduto v where v.docentradaidDocEntrada=" + docEntrada.getIdDocEntrada() + " order by v.idEntradaProduto");
        if (q.getResultList().size()>0){
            ListaEntradaProduto = q.getResultList();
        }
        manager.close();
        return ListaEntradaProduto;
   }
   
    public Entradaproduto getEntradaProduto(int idEntradaProduto) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        Entradaproduto entradaProduto = manager.find(Entradaproduto.class, idEntradaProduto);
        //fechando uma transação
        manager.getTransaction().commit(); 
        manager.close();
        return entradaProduto;
   }
}
