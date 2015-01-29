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
import model.Grupoproduto;
import model.Subgrupoproduto;

/**
 *
 * @author wolverine
 */
public class GrupoProdutoDao {

    private EntityManager manager;

    public List<Grupoproduto> listarGrupoProduto() throws Exception{
        manager = ConexaoSingleton.getConexao();
        List<Grupoproduto> listaGrupoProdutos = new ArrayList<Grupoproduto>();
        Query q = manager.createQuery("select g from Grupoproduto g order by g.descricao");
        listaGrupoProdutos = q.getResultList();
        manager.close();
        return listaGrupoProdutos;
    }

    public List<Subgrupoproduto> listSubGrupoProduto(int idGrupo) throws Exception{
        manager = ConexaoSingleton.getConexao();
        List<Subgrupoproduto> listaSubGrupoProduto = new ArrayList<Subgrupoproduto>();
        Query q = manager.createQuery("select s from Subgrupoproduto s where s.grupoproduto=" + idGrupo + " order by s.descricao");
        listaSubGrupoProduto = q.getResultList();
        manager.close();
        return listaSubGrupoProduto;
    }
    
    public Subgrupoproduto consultarSubGrupoProduto(int idSubGrupo) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        Subgrupoproduto subGrupoProduto = new Subgrupoproduto();
        Query q = manager.createQuery("select s from Subgrupoproduto s where s.idsubGrupoProduto=" + idSubGrupo);
        subGrupoProduto = (Subgrupoproduto) q.getSingleResult();
        manager.close();
        return subGrupoProduto;
    }
    
    public Grupoproduto consultarGrupoProduto(int idGrupo) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        Grupoproduto grupoProduto = new Grupoproduto();
        Query q = manager.createQuery("select g from Grupoproduto g where g.idgrupoProduto=" + idGrupo);
        grupoProduto =  (Grupoproduto) q.getSingleResult();
        manager.close();
        return grupoProduto;
    }
    
    public void salvarGrupoProduto(Grupoproduto grupoProduto) throws Exception {
         manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        manager.merge(grupoProduto);
        //fechando uma transação
        manager.getTransaction().commit(); 
        manager.close();
    }
    
    public void salvarSubGrupoProduto(Subgrupoproduto subGrupoProduto) throws Exception {
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        manager.merge(subGrupoProduto);
        //fechando uma transação
        manager.getTransaction().commit(); 
        manager.close();
    }   
    



}
