/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package daoRemoto;

import Singleton.ConexaoSingletonRemota;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Produto;
import model.Vinculo;



/**
 *
 * @author Woverine
 */
public class ProdutoRemotoDao {
    
    private EntityManager manager;

    public List<Produto> consultarProduto() throws Exception{
        manager = ConexaoSingletonRemota.getConexao();
        List<Produto> listaProdutos = new ArrayList<Produto>();
        Query q = manager.createQuery("select p from Produto p order by p.descricao");
        listaProdutos = q.getResultList();
        return listaProdutos;
    }
    
    public List<Produto> listarProdutoImportacao() throws Exception{
        manager = ConexaoSingletonRemota.getConexao();
        List<Produto> listaProdutos = new ArrayList<Produto>();
        Query q = manager.createQuery("select p from Produto p where p.sincronizado=0");
        listaProdutos = q.getResultList();
        return listaProdutos;
    }

    public Produto consultarProdutoid(int idProduto) throws Exception {
        manager = ConexaoSingletonRemota.getConexao();
        Produto produto = new Produto();
        Query q = manager.createQuery("select p from Produto p where p.idProduto=" + idProduto);
        if (q.getResultList().size()>0){
            produto = (Produto) q.getSingleResult();
        }
        return produto;
    }

    public Produto consultarProdutoReferencia(int referencia) throws Exception {
        manager = ConexaoSingletonRemota.getConexao();
        Produto produto = new Produto();
        Query q = manager.createQuery("select p from Produto p where p.referencia=" + referencia);
        if (q.getResultList().size()>0){
            produto = (Produto) q.getResultList().get(0);
        }
        return produto;
    }

    public List<Produto> consultarProduto(String descricao) throws Exception {
        manager = ConexaoSingletonRemota.getConexao();
        List<Produto> listaProdutos = new ArrayList<Produto>();
        Query q = manager.createQuery("select p from Produto p where descricao like '%" + descricao + "%' order by p.descricao");
        listaProdutos = q.getResultList();
        return listaProdutos;
    }

    public void salvarProduto(Produto produto) throws Exception{
         manager = ConexaoSingletonRemota.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        manager.merge(produto);
        //fechando uma transação
        manager.getTransaction().commit();
    }

    public void excluir(Produto produto) throws Exception{
         manager = ConexaoSingletonRemota.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        produto = manager.find(Produto.class, produto);
        manager.remove(produto);
        //fechando uma transação
        manager.getTransaction().commit();
    }

    public int getIdProduto() throws Exception {
        manager = ConexaoSingletonRemota.getConexao();
        //verificar last insert id
        Query q = manager.createNativeQuery("Select MAX(idproduto) From Produto");
        int idProduto =(Integer) q.getSingleResult();
        return idProduto;
    }

    public Produto pesquisarCodigoFabricante(String codigoFabricante) throws SQLException, Exception{
        manager = ConexaoSingletonRemota.getConexao();
        Produto produto = new Produto();
        Vinculo vinculo = new Vinculo();
        Query q = manager.createQuery("select v from Vinculo v where v.codigoFabricante='" + codigoFabricante + "'");
        if (q.getResultList().size()>0){
            vinculo = (Vinculo) q.getSingleResult();
            if (vinculo.getProduto()>0){
                produto = consultarProdutoid(vinculo.getProduto());
            }
        }
        return produto;
    }


     
}
