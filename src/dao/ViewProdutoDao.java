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
import telas.RelatoriosGerenciais.Relentradasaida;
import view.Viewprodutoentrada;
import view.Viewprodutosaida;

/**
 *
 * @author Wolverine
 */
public class ViewProdutoDao {
    
    private EntityManager manager;
    
    public List<Viewprodutoentrada> listarEntradas(String dataInicial, String dataFial) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        List<Viewprodutoentrada> listaEntrada = new ArrayList<Viewprodutoentrada>();
        Query q = manager.createQuery("SELECT v FROM Viewprodutoentrada v where v.dataEntrada>='" + dataInicial + "' and dataEntrada<='"  + dataFial + "'" );
        listaEntrada = q.getResultList();
        manager.close();
        return listaEntrada;
    }
    
    public List<Viewprodutosaida> listarSaidas(String dataInicial, String dataFial) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        List<Viewprodutosaida> listaSaida = new ArrayList<Viewprodutosaida>();
        Query q = manager.createQuery("SELECT v FROM Viewprodutosaida v where v.dataVenda>='" + dataInicial + "' and dataVenda<='"  + dataFial + "' order by v.produtoIdproduto" );
        listaSaida = q.getResultList();
        manager.close();
        return listaSaida;
    }
    
    public Relentradasaida consultaProduto(int idProduto) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        Relentradasaida produto = null;
        Query q = manager.createQuery("SELECT r FROM Relentradasaida r where r.idProduto="  + idProduto);
        if (q.getResultList().size()>0){
            produto = (Relentradasaida) q.getSingleResult();
        }
        manager.close();
        return produto;
    }
    
    public void salvar(Relentradasaida produto) throws Exception{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        manager.merge(produto);
        //fechando uma transação
        manager.getTransaction().commit(); 
        manager.close();
    }
    
    public void exluir(int idProduto) throws SQLException {
       manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
       Relentradasaida relentradasaida = manager.find(Relentradasaida.class, idProduto);
        manager.remove(relentradasaida);
        //fechando uma transação
        manager.getTransaction().commit(); 
        manager.close();
    }
    
    public List<Relentradasaida> listaRelEntradaSaida() throws SQLException{
        manager = ConexaoSingleton.getConexao();
        Query q = manager.createQuery("SELECT r FROM Relentradasaida r" );
        List<Relentradasaida> listaRelEntradaSaida = new ArrayList<Relentradasaida>();
        if (q.getResultList().size()>0){
            listaRelEntradaSaida= q.getResultList();
        }
        manager.close();
        return listaRelEntradaSaida;
    }
    
    
}
