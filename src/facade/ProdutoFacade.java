/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package facade;

import dao.ProdutoDao;
import java.sql.SQLException;
import java.util.List;
import model.Produto;
import model.ProdutoImagem;


/**
 *
 * @author Woverine
 */
public class ProdutoFacade {
    
    private ProdutoDao produtoDao;

    public List<Produto> consultarProduto() throws Exception{
        produtoDao = new ProdutoDao();
        return produtoDao.consultarProduto();
    }

    public Produto consultarProdutoid(int idProduto) throws Exception {
        produtoDao = new ProdutoDao();
        return produtoDao.consultarProdutoid(idProduto);
    }

    public List<Produto> consultarProduto(String descricao) throws Exception {
        produtoDao = new ProdutoDao();
        return produtoDao.consultarProduto(descricao);
    }

    public Produto salvarProduto(Produto produto) throws Exception {
        produtoDao = new ProdutoDao();
        return produtoDao.salvarProduto(produto);
    }

     public int getIdProduto() throws Exception{
         produtoDao = new ProdutoDao();
         return produtoDao.getIdProduto();
     }

     public void excluir(int idProduto) throws Exception{
         produtoDao = new ProdutoDao();
         produtoDao.excluir(idProduto);
     }

      public Produto consultarProdutoReferencia(int referencia) throws Exception {
          produtoDao = new ProdutoDao();
          return produtoDao.consultarProdutoReferencia(referencia);
      }
      
      public List<Produto> listarReferencia(int referencia) throws Exception {
          produtoDao = new ProdutoDao();
          return produtoDao.listarReferencia(referencia);
      }

      public int pesquisarCodigoFabricante(String codigoFabricante) throws SQLException{
          produtoDao = new ProdutoDao();
          return produtoDao.pesquisarCodigoFabricante(codigoFabricante);
      }
      
       public List<Produto> listarProdutoReferencia(int referencia) throws Exception {
           produtoDao = new ProdutoDao();
           return produtoDao.listarProdutoReferencia(referencia);
       }
       
       public int getMaiorReferencia() throws Exception {
           produtoDao = new ProdutoDao();
           return produtoDao.getMaiorReferencia();
       }
       
       public ProdutoImagem salvarFotoProduto(ProdutoImagem produtoImagem) throws SQLException{
           produtoDao = new ProdutoDao();
           return produtoDao.salvarFotoProduto(produtoImagem);
       }
       
       public ProdutoImagem consultarProdutoFoto(int idProduto) throws Exception {
           produtoDao = new ProdutoDao();
           return produtoDao.consultarProdutoFoto(idProduto);
       }
       
       public List<Produto> consultarProdutoExportacao() throws Exception {
           produtoDao = new ProdutoDao();
           return produtoDao.consultarProdutoExportacao();
       }
       
       public List<Produto> consultarProdutoSemCEST() throws Exception {
           produtoDao = new ProdutoDao();
           return produtoDao.consultarProdutoSemCEST();
       }

}
