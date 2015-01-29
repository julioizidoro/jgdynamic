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
import model.Produto;
import model.ProdutoImagem;
import model.Vinculo;



/**
 *
 * @author Woverine
 */
public class ProdutoDao {
    
    private EntityManager manager;

    public List<Produto> consultarProduto() throws Exception{
        manager = ConexaoSingleton.getConexao();
        List<Produto> listaProdutos = new ArrayList<Produto>();
        Query q = manager.createQuery("select p from Produto p order by p.descricao");
        listaProdutos = q.getResultList();
        manager.close();
        return listaProdutos;
    }
    
    public List<Produto> listarProdutoReferencia(int referencia) throws Exception {
        manager = ConexaoSingleton.getConexao();
        List<Produto> listaProduto = new ArrayList<Produto>();
        Query q = manager.createQuery("select p from Produto p where p.referencia>=" + referencia + " order by p.referencia asc");
        if (q.getResultList().size()>0){
            listaProduto = q.getResultList();
        }
        manager.close();
        return listaProduto;
    }

    public Produto consultarProdutoid(int idProduto) throws Exception {
        manager = ConexaoSingleton.getConexao();
        Produto produto = new Produto();
        Query q = manager.createQuery("select p from Produto p where p.idProduto=" + idProduto);
        if (q.getResultList().size()>0){
            produto = (Produto) q.getSingleResult();
        }
        manager.close();
        return produto;
    }

    public Produto consultarProdutoReferencia(int referencia) throws Exception {
        manager = ConexaoSingleton.getConexao();
        Produto produto = null;
        Query q = manager.createQuery("select p from Produto p where p.codigoNovo=" + referencia + " order by p.referencia asc");
        if (q.getResultList().size() > 0) {
            produto = (Produto) q.getResultList().get(0);
        } else {
            q = manager.createQuery("select p from Produto p where p.referencia=" + referencia + " order by p.referencia asc");
            if (q.getResultList().size() > 0) {
                produto = (Produto) q.getResultList().get(0);
            }
        }
        manager.close();
        return produto;
    }

    public List<Produto> consultarProduto(String descricao) throws Exception {
        manager = ConexaoSingleton.getConexao();
        List<Produto> listaProdutos = new ArrayList<Produto>();
        Query q = manager.createQuery("select p from Produto p where p.descricao like '" + descricao + "%' order by p.descricao");
        listaProdutos = q.getResultList();
        manager.close();
        return listaProdutos;
    }

    public Produto salvarProduto(Produto produto) throws Exception{
         manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        produto = manager.merge(produto);
        //fechando uma transação
        manager.getTransaction().commit(); 
        manager.close();
        return produto;
    }

    public void excluir(int idProduto) throws Exception{
         manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        Produto produto = manager.find(Produto.class, idProduto);
        manager.remove(produto);
        //fechando uma transação
        manager.getTransaction().commit(); 
        manager.close();
    }

    public int getIdProduto() throws Exception {
        manager = ConexaoSingleton.getConexao();
        //verificar last insert id
        Query q = manager.createNativeQuery("Select MAX(idproduto) From Produto");
        int idProduto =(Integer) q.getSingleResult();
        manager.close();
        return idProduto;
    }

    public int pesquisarCodigoFabricante(String codigoFabricante) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        int idProduto = 0;
        Vinculo vinculo = new Vinculo();
        Query q = manager.createQuery("select v from Vinculo v where v.codigoFabricante='" + codigoFabricante + "'");
        if (q.getResultList().size()>0){
            vinculo = (Vinculo) q.getResultList().get(0);
            idProduto = vinculo.getProduto();
        }
        manager.close();
        return idProduto;
    }
    
     public int getMaiorReferencia() throws Exception {
        manager = ConexaoSingleton.getConexao();
        //verificar last insert id
        Query q = manager.createNativeQuery("Select MAX(referencia) From produto where referencia<90000");
        int referencia =(Integer) q.getSingleResult();
        manager.close();
        return referencia;
    }
     
    public ProdutoImagem salvarFotoProduto(ProdutoImagem produtoImagem) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        produtoImagem = manager.merge(produtoImagem);
        //fechando uma transação
        manager.getTransaction().commit(); 
        manager.close();
        return produtoImagem;
    }
    
    public ProdutoImagem consultarProdutoFoto(int idProduto) throws Exception {
        manager = ConexaoSingleton.getConexao();
        ProdutoImagem produtoImagem = new ProdutoImagem();
        Query q = manager.createQuery("select p from ProdutoImagem p where p.produto=" + idProduto);
        if (q.getResultList().size()>0){
            produtoImagem = (ProdutoImagem) q.getSingleResult();
        }
        manager.close();
        return produtoImagem;
    }
     
    public List<Produto> consultarProdutoExportacao() throws Exception {
        manager = ConexaoSingleton.getConexao();
        List<Produto> listaProduto = new ArrayList<Produto>();
        Query q = manager.createQuery("select p from Produto p where p.sincronizado=0");
        if (q.getResultList().size()>0){
            listaProduto =  q.getResultList();
        }
        manager.close();
        return listaProduto;
    }    
}
